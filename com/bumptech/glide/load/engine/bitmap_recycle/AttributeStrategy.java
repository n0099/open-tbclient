package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.bumptech.glide.util.Util;
/* loaded from: classes8.dex */
public class AttributeStrategy implements LruPoolStrategy {
    public final KeyPool keyPool = new KeyPool();
    public final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    @VisibleForTesting
    /* loaded from: classes8.dex */
    public static class Key implements Poolable {
        public Bitmap.Config config;
        public int height;
        public final KeyPool pool;
        public int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.width != key.width || this.height != key.height || this.config != key.config) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            if (config != null) {
                i = config.hashCode();
            } else {
                i = 0;
            }
            return i2 + i;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }

        public void init(int i, int i2, Bitmap.Config config) {
            this.width = i;
            this.height = i2;
            this.config = config;
        }
    }

    @VisibleForTesting
    /* loaded from: classes8.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }

        public Key get(int i, int i2, Bitmap.Config config) {
            Key key = get();
            key.init(i, i2, config);
            return key;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public static String getBitmapString(int i, int i2, Bitmap.Config config) {
        return PreferencesUtil.LEFT_MOUNT + i + "x" + i2 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(i, i2, config);
    }

    public static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
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
}
