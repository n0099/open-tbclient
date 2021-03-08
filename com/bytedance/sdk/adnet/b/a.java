package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.q;
/* loaded from: classes6.dex */
public class a implements d.b {

    /* renamed from: a  reason: collision with root package name */
    protected LruCache<String, Bitmap> f4020a = new LruCache<String, Bitmap>(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) { // from class: com.bytedance.sdk.adnet.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    @Override // com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) {
        try {
            return this.f4020a.get(str);
        } catch (Throwable th) {
            q.a(th, "DefaultImageCache get bitmap error", new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            try {
                this.f4020a.put(str, bitmap);
            } catch (Throwable th) {
                q.a(th, "DefaultImageCache put bitmap error", new Object[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return null;
    }
}
