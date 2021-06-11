package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;
/* loaded from: classes6.dex */
public final class DrawableToBitmapConverter {
    public static final BitmapPool NO_RECYCLE_BITMAP_POOL = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void put(Bitmap bitmap) {
        }
    };
    public static final String TAG = "DrawableToBitmap";

    @Nullable
    public static Resource<Bitmap> convert(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = drawToBitmap(bitmapPool, current, i2, i3);
            z = true;
        }
        if (!z) {
            bitmapPool = NO_RECYCLE_BITMAP_POOL;
        }
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Nullable
    public static Bitmap drawToBitmap(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
            bitmapDrawableLock.lock();
            Bitmap bitmap = bitmapPool.get(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return bitmap;
            } finally {
                bitmapDrawableLock.unlock();
            }
        }
    }
}
