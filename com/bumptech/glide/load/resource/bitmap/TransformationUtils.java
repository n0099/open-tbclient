package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public final class TransformationUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Lock BITMAP_DRAWABLE_LOCK;
    public static final Paint CIRCLE_CROP_BITMAP_PAINT;
    public static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    public static final Paint CIRCLE_CROP_SHAPE_PAINT;
    public static final Paint DEFAULT_PAINT;
    public static final Set<String> MODELS_REQUIRING_BITMAP_LOCK;
    public static final int PAINT_FLAGS = 6;
    public static final String TAG = "TransformationUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class NoLock implements Lock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NoLock() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException("Should not be called");
            }
            return (Condition) invokeV.objValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j2, timeUnit)) == null) {
                return true;
            }
            return invokeJL.booleanValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752069624, "Lcom/bumptech/glide/load/resource/bitmap/TransformationUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1752069624, "Lcom/bumptech/glide/load/resource/bitmap/TransformationUtils;");
                return;
            }
        }
        DEFAULT_PAINT = new Paint(6);
        CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        MODELS_REQUIRING_BITMAP_LOCK = hashSet;
        BITMAP_DRAWABLE_LOCK = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public TransformationUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void applyMatrix(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, bitmap, bitmap2, matrix) == null) {
            BITMAP_DRAWABLE_LOCK.lock();
            try {
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawBitmap(bitmap, matrix, DEFAULT_PAINT);
                clear(canvas);
            } finally {
                BITMAP_DRAWABLE_LOCK.unlock();
            }
        }
    }

    public static Bitmap centerCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, bitmapPool, bitmap, i2, i3)) == null) {
            if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            float f2 = 0.0f;
            if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
                width = i3 / bitmap.getHeight();
                f2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = i2 / bitmap.getWidth();
                height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
            }
            matrix.setScale(width, width);
            matrix.postTranslate((int) (f2 + 0.5f), (int) (height + 0.5f));
            Bitmap bitmap2 = bitmapPool.get(i2, i3, getNonNullConfig(bitmap));
            setAlpha(bitmap, bitmap2);
            applyMatrix(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static Bitmap centerInside(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmapPool, bitmap, i2, i3)) == null) {
            if (bitmap.getWidth() <= i2 && bitmap.getHeight() <= i3) {
                Log.isLoggable(TAG, 2);
                return bitmap;
            }
            Log.isLoggable(TAG, 2);
            return fitCenter(bitmapPool, bitmap, i2, i3);
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static Bitmap circleCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(AdIconUtil.AD_TEXT_ID, null, bitmapPool, bitmap, i2, i3)) == null) {
            int min = Math.min(i2, i3);
            float f2 = min;
            float f3 = f2 / 2.0f;
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float max = Math.max(f2 / width, f2 / height);
            float f4 = width * max;
            float f5 = max * height;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = (f2 - f5) / 2.0f;
            RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
            Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
            Bitmap bitmap2 = bitmapPool.get(min, min, getAlphaSafeConfig(bitmap));
            bitmap2.setHasAlpha(true);
            BITMAP_DRAWABLE_LOCK.lock();
            try {
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawCircle(f3, f3, f3, CIRCLE_CROP_SHAPE_PAINT);
                canvas.drawBitmap(alphaSafeBitmap, (Rect) null, rectF, CIRCLE_CROP_BITMAP_PAINT);
                clear(canvas);
                BITMAP_DRAWABLE_LOCK.unlock();
                if (!alphaSafeBitmap.equals(bitmap)) {
                    bitmapPool.put(alphaSafeBitmap);
                }
                return bitmap2;
            } catch (Throwable th) {
                BITMAP_DRAWABLE_LOCK.unlock();
                throw th;
            }
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static void clear(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, canvas) == null) {
            canvas.setBitmap(null);
        }
    }

    public static Bitmap fitCenter(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, bitmapPool, bitmap, i2, i3)) == null) {
            if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                Log.isLoggable(TAG, 2);
                return bitmap;
            }
            float min = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
            int round = Math.round(bitmap.getWidth() * min);
            int round2 = Math.round(bitmap.getHeight() * min);
            if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
                Log.isLoggable(TAG, 2);
                return bitmap;
            }
            Bitmap bitmap2 = bitmapPool.get((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), getNonNullConfig(bitmap));
            setAlpha(bitmap, bitmap2);
            if (Log.isLoggable(TAG, 2)) {
                String str = "request: " + i2 + "x" + i3;
                String str2 = "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight();
                String str3 = "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight();
                String str4 = "minPct:   " + min;
            }
            Matrix matrix = new Matrix();
            matrix.setScale(min, min);
            applyMatrix(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static Bitmap getAlphaSafeBitmap(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bitmapPool, bitmap)) == null) {
            Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
            if (alphaSafeConfig.equals(bitmap.getConfig())) {
                return bitmap;
            }
            Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), alphaSafeConfig);
            new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return bitmap2;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @NonNull
    public static Bitmap.Config getAlphaSafeConfig(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bitmap)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
        return (Bitmap.Config) invokeL.objValue;
    }

    public static Lock getBitmapDrawableLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? BITMAP_DRAWABLE_LOCK : (Lock) invokeV.objValue;
    }

    public static int getExifOrientationDegrees(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            switch (i2) {
                case 3:
                case 4:
                    return 180;
                case 5:
                case 6:
                    return 90;
                case 7:
                case 8:
                    return 270;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    @NonNull
    public static Bitmap.Config getNonNullConfig(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bitmap)) == null) ? bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888 : (Bitmap.Config) invokeL.objValue;
    }

    @VisibleForTesting
    public static void initializeMatrixForRotation(int i2, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, null, i2, matrix) == null) {
            switch (i2) {
                case 2:
                    matrix.setScale(-1.0f, 1.0f);
                    return;
                case 3:
                    matrix.setRotate(180.0f);
                    return;
                case 4:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    return;
                case 5:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    return;
                case 6:
                    matrix.setRotate(90.0f);
                    return;
                case 7:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    return;
                case 8:
                    matrix.setRotate(-90.0f);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean isExifOrientationRequired(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) {
            switch (i2) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static Bitmap rotateImage(@NonNull Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, bitmap, i2)) == null) {
            if (i2 != 0) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i2);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } catch (Exception unused) {
                    Log.isLoggable(TAG, 6);
                    return bitmap;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap rotateImageExif(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, bitmapPool, bitmap, i2)) == null) {
            if (isExifOrientationRequired(i2)) {
                Matrix matrix = new Matrix();
                initializeMatrixForRotation(i2, matrix);
                RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                matrix.mapRect(rectF);
                Bitmap bitmap2 = bitmapPool.get(Math.round(rectF.width()), Math.round(rectF.height()), getNonNullConfig(bitmap));
                matrix.postTranslate(-rectF.left, -rectF.top);
                applyMatrix(bitmap, bitmap2, matrix);
                return bitmap2;
            }
            return bitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{bitmapPool, bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? roundedCorners(bitmapPool, bitmap, i4) : (Bitmap) invokeCommon.objValue;
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, bitmap, bitmap2) == null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65553, null, bitmapPool, bitmap, i2)) == null) {
            Preconditions.checkArgument(i2 > 0, "roundingRadius must be greater than 0.");
            Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
            Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
            Bitmap bitmap2 = bitmapPool.get(alphaSafeBitmap.getWidth(), alphaSafeBitmap.getHeight(), alphaSafeConfig);
            bitmap2.setHasAlpha(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(alphaSafeBitmap, tileMode, tileMode);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
            BITMAP_DRAWABLE_LOCK.lock();
            try {
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                float f2 = i2;
                canvas.drawRoundRect(rectF, f2, f2, paint);
                clear(canvas);
                BITMAP_DRAWABLE_LOCK.unlock();
                if (!alphaSafeBitmap.equals(bitmap)) {
                    bitmapPool.put(alphaSafeBitmap);
                }
                return bitmap2;
            } catch (Throwable th) {
                BITMAP_DRAWABLE_LOCK.unlock();
                throw th;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }
}
