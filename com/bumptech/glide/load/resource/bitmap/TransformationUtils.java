package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public final class TransformationUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Lock BITMAP_DRAWABLE_LOCK;
    public static final Paint CIRCLE_CROP_BITMAP_PAINT;
    public static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    public static final Paint CIRCLE_CROP_SHAPE_PAINT;
    public static final Paint DEFAULT_PAINT;
    public static final Set MODELS_REQUIRING_BITMAP_LOCK;
    public static final int PAINT_FLAGS = 6;
    public static final String TAG = "TransformationUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface DrawRoundedCornerFn {
        void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF);
    }

    public static int getExifOrientationDegrees(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            switch (i) {
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

    public static boolean isExifOrientationRequired(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            switch (i) {
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

    /* loaded from: classes7.dex */
    public final class NoLock implements Lock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, timeUnit)) == null) {
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

        public NoLock() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException("Should not be called");
            }
            return (Condition) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        Lock noLock;
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
        if (hashSet.contains(Build.MODEL)) {
            noLock = new ReentrantLock();
        } else {
            noLock = new NoLock();
        }
        BITMAP_DRAWABLE_LOCK = noLock;
        Paint paint = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public TransformationUtils() {
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

    public static Lock getBitmapDrawableLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return BITMAP_DRAWABLE_LOCK;
        }
        return (Lock) invokeV.objValue;
    }

    public static void applyMatrix(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
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

    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, null, bitmapPool, bitmap, i)) == null) {
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "roundingRadius must be greater than 0.");
            return roundedCorners(bitmapPool, bitmap, new DrawRoundedCornerFn(i) { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$roundingRadius;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$roundingRadius = i;
                }

                @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
                public void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, canvas, paint, rectF) == null) {
                        int i2 = this.val$roundingRadius;
                        canvas.drawRoundRect(rectF, i2, i2, paint);
                    }
                }
            });
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap centerCrop(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, bitmapPool, bitmap, i, i2)) == null) {
            if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            float f = 0.0f;
            if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
                width = i2 / bitmap.getHeight();
                f = (i - (bitmap.getWidth() * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = i / bitmap.getWidth();
                height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
            }
            matrix.setScale(width, width);
            matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
            Bitmap bitmap2 = bitmapPool.get(i, i2, getNonNullConfig(bitmap));
            setAlpha(bitmap, bitmap2);
            applyMatrix(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static Bitmap circleCrop(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, bitmapPool, bitmap, i, i2)) == null) {
            int min = Math.min(i, i2);
            float f = min;
            float f2 = f / 2.0f;
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float max = Math.max(f / width, f / height);
            float f3 = width * max;
            float f4 = max * height;
            float f5 = (f - f3) / 2.0f;
            float f6 = (f - f4) / 2.0f;
            RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
            Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
            Bitmap bitmap2 = bitmapPool.get(min, min, getAlphaSafeConfig(bitmap));
            bitmap2.setHasAlpha(true);
            BITMAP_DRAWABLE_LOCK.lock();
            try {
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawCircle(f2, f2, f2, CIRCLE_CROP_SHAPE_PAINT);
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

    public static Bitmap centerInside(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmapPool, bitmap, i, i2)) == null) {
            if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "requested target size larger or equal to input, returning input");
                }
                return bitmap;
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "requested target size too big for input, fit centering instead");
            }
            return fitCenter(bitmapPool, bitmap, i, i2);
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static void clear(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, canvas) == null) {
            canvas.setBitmap(null);
        }
    }

    public static Bitmap.Config getAlphaSafeConfig(Bitmap bitmap) {
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

    public static Bitmap.Config getNonNullConfig(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bitmap)) == null) {
            if (bitmap.getConfig() != null) {
                return bitmap.getConfig();
            }
            return Bitmap.Config.ARGB_8888;
        }
        return (Bitmap.Config) invokeL.objValue;
    }

    public static Bitmap fitCenter(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, bitmapPool, bitmap, i, i2)) == null) {
            if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "requested target size matches input, returning input");
                }
                return bitmap;
            }
            float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
            int round = Math.round(bitmap.getWidth() * min);
            int round2 = Math.round(bitmap.getHeight() * min);
            if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "adjusted target size matches input, returning input");
                }
                return bitmap;
            }
            Bitmap bitmap2 = bitmapPool.get((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), getNonNullConfig(bitmap));
            setAlpha(bitmap, bitmap2);
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "request: " + i + "x" + i2);
                Log.v(TAG, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                Log.v(TAG, "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
                StringBuilder sb = new StringBuilder();
                sb.append("minPct:   ");
                sb.append(min);
                Log.v(TAG, sb.toString());
            }
            Matrix matrix = new Matrix();
            matrix.setScale(min, min);
            applyMatrix(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static Bitmap getAlphaSafeBitmap(BitmapPool bitmapPool, Bitmap bitmap) {
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

    public static Bitmap rotateImage(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, bitmap, i)) == null) {
            if (i != 0) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } catch (Exception e) {
                    if (Log.isLoggable(TAG, 6)) {
                        Log.e(TAG, "Exception when trying to orient image", e);
                        return bitmap;
                    }
                    return bitmap;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static void initializeMatrixForRotation(int i, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, null, i, matrix) == null) {
            switch (i) {
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

    public static Bitmap rotateImageExif(BitmapPool bitmapPool, Bitmap bitmap, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, bitmapPool, bitmap, i)) == null) {
            if (!isExifOrientationRequired(i)) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            initializeMatrixForRotation(i, matrix);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            Bitmap bitmap2 = bitmapPool.get(Math.round(rectF.width()), Math.round(rectF.height()), getNonNullConfig(bitmap));
            matrix.postTranslate(-rectF.left, -rectF.top);
            bitmap2.setHasAlpha(bitmap.hasAlpha());
            applyMatrix(bitmap, bitmap2, matrix);
            return bitmap2;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{bitmapPool, bitmap, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return roundedCorners(bitmapPool, bitmap, new DrawRoundedCornerFn(f, f2, f3, f4) { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float val$bottomLeft;
                public final /* synthetic */ float val$bottomRight;
                public final /* synthetic */ float val$topLeft;
                public final /* synthetic */ float val$topRight;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$topLeft = f;
                    this.val$topRight = f2;
                    this.val$bottomRight = f3;
                    this.val$bottomLeft = f4;
                }

                @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
                public void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, canvas, paint, rectF) == null) {
                        Path path = new Path();
                        float f5 = this.val$topLeft;
                        float f6 = this.val$topRight;
                        float f7 = this.val$bottomRight;
                        float f8 = this.val$bottomLeft;
                        path.addRoundRect(rectF, new float[]{f5, f5, f6, f6, f7, f7, f8, f8}, Path.Direction.CW);
                        canvas.drawPath(path, paint);
                    }
                }
            });
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Deprecated
    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{bitmapPool, bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return roundedCorners(bitmapPool, bitmap, i3);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, DrawRoundedCornerFn drawRoundedCornerFn) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, bitmapPool, bitmap, drawRoundedCornerFn)) == null) {
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
                drawRoundedCornerFn.drawRoundedCorners(canvas, paint, rectF);
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
        return (Bitmap) invokeLLL.objValue;
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, bitmap, bitmap2) == null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
