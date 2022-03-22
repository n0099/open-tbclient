package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;
/* loaded from: classes6.dex */
public final class DrawableToBitmapConverter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BitmapPool NO_RECYCLE_BITMAP_POOL;
    public static final String TAG = "DrawableToBitmap";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1514978104, "Lcom/bumptech/glide/load/resource/bitmap/DrawableToBitmapConverter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1514978104, "Lcom/bumptech/glide/load/resource/bitmap/DrawableToBitmapConverter;");
                return;
            }
        }
        NO_RECYCLE_BITMAP_POOL = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
            public void put(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                }
            }
        };
    }

    public DrawableToBitmapConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public static Resource<Bitmap> convert(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        InterceptResult invokeLLII;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, bitmapPool, drawable, i, i2)) == null) {
            Drawable current = drawable.getCurrent();
            boolean z = false;
            if (current instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) current).getBitmap();
            } else if (current instanceof Animatable) {
                bitmap = null;
            } else {
                bitmap = drawToBitmap(bitmapPool, current, i, i2);
                z = true;
            }
            if (!z) {
                bitmapPool = NO_RECYCLE_BITMAP_POOL;
            }
            return BitmapResource.obtain(bitmap, bitmapPool);
        }
        return (Resource) invokeLLII.objValue;
    }

    @Nullable
    public static Bitmap drawToBitmap(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, bitmapPool, drawable, i, i2)) == null) {
            if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                }
                return null;
            } else if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
                return null;
            } else {
                if (drawable.getIntrinsicWidth() > 0) {
                    i = drawable.getIntrinsicWidth();
                }
                if (drawable.getIntrinsicHeight() > 0) {
                    i2 = drawable.getIntrinsicHeight();
                }
                Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
                bitmapDrawableLock.lock();
                Bitmap bitmap = bitmapPool.get(i, i2, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, i, i2);
                    drawable.draw(canvas);
                    canvas.setBitmap(null);
                    return bitmap;
                } finally {
                    bitmapDrawableLock.unlock();
                }
            }
        }
        return (Bitmap) invokeLLII.objValue;
    }
}
