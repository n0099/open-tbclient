package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.bumptech.glide.util.Util;
/* loaded from: classes6.dex */
public class AttributeStrategy implements LruPoolStrategy {
    public final KeyPool keyPool = new KeyPool();
    public final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class Key implements Poolable {
        public Bitmap.Config config;
        public int height;
        public final KeyPool pool;
        public int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.width == key.width && this.height == key.height && this.config == key.config;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i2, int i3, Bitmap.Config config) {
            this.width = i2;
            this.height = i3;
            this.config = config;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i2, int i3, Bitmap.Config config) {
            Key key = get();
            key.init(i2, i3, config);
            return key;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    public static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i2, int i3, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public static String getBitmapString(int i2, int i3, Bitmap.Config config) {
        return PreferencesUtil.LEFT_MOUNT + i2 + "x" + i3 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i2, int i3, Bitmap.Config config) {
        return getBitmapString(i2, i3, config);
    }
}
