package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.core.r;
/* loaded from: classes6.dex */
public class e extends Request<Bitmap> {
    private static final Object i = new Object();
    private final Object c;
    @Nullable
    @GuardedBy("mLock")
    private p.a<Bitmap> d;
    private final Bitmap.Config e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;

    public e(String str, p.a<Bitmap> aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.c = new Object();
        setRetryPolicy(new com.bytedance.sdk.adnet.core.g(1000, 2, 2.0f));
        this.d = aVar;
        this.e = config;
        this.f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        } else if (i2 == 0) {
            return (int) ((i3 / i5) * i4);
        } else {
            if (i3 != 0) {
                double d = i5 / i4;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    if (i2 * d < i3) {
                        return (int) (i3 / d);
                    }
                    return i2;
                } else if (i2 * d > i3) {
                    return (int) (i3 / d);
                } else {
                    return i2;
                }
            }
            return i2;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected p<Bitmap> a(l lVar) {
        p<Bitmap> c;
        synchronized (i) {
            try {
                c = b(lVar);
            } catch (OutOfMemoryError e) {
                r.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(lVar.f6043b.length), getUrl());
                c = p.c(new com.bytedance.sdk.adnet.err.e(e));
            }
        }
        return c;
    }

    private p<Bitmap> b(l lVar) {
        Bitmap bitmap;
        byte[] bArr = lVar.f6043b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f == 0 && this.g == 0) {
            options.inPreferredConfig = this.e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a2 = a(this.f, this.g, i2, i3, this.h);
            int a3 = a(this.g, this.f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a2, a3);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= a2 && decodeByteArray.getHeight() <= a3)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return p.c(new com.bytedance.sdk.adnet.err.e(lVar));
        }
        return p.a(bitmap, com.bytedance.sdk.adnet.d.c.c(lVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(p<Bitmap> pVar) {
        p.a<Bitmap> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(pVar);
        }
    }

    @VisibleForTesting
    static int a(int i2, int i3, int i4, int i5) {
        float f = 1.0f;
        while (f * 2.0f <= Math.min(i2 / i4, i3 / i5)) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
