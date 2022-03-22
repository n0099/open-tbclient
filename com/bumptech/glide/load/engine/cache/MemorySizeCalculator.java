package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes6.dex */
public final class MemorySizeCalculator {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    public static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    public static final String TAG = "MemorySizeCalculator";
    public transient /* synthetic */ FieldHolder $fh;
    public final int arrayPoolSize;
    public final int bitmapPoolSize;
    public final Context context;
    public final int memoryCacheSize;

    /* loaded from: classes6.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        public static final int BITMAP_POOL_TARGET_SCREENS;
        public static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        public static final float MAX_SIZE_MULTIPLIER = 0.4f;
        @VisibleForTesting
        public static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivityManager activityManager;
        public int arrayPoolSizeBytes;
        public float bitmapPoolScreens;
        public final Context context;
        public float lowMemoryMaxSizeMultiplier;
        public float maxSizeMultiplier;
        public float memoryCacheScreens;
        public ScreenDimensions screenDimensions;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1895433924, "Lcom/bumptech/glide/load/engine/cache/MemorySizeCalculator$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1895433924, "Lcom/bumptech/glide/load/engine/cache/MemorySizeCalculator$Builder;");
                    return;
                }
            }
            BITMAP_POOL_TARGET_SCREENS = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.memoryCacheScreens = 2.0f;
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.maxSizeMultiplier = 0.4f;
            this.lowMemoryMaxSizeMultiplier = 0.33f;
            this.arrayPoolSizeBytes = 4194304;
            this.context = context;
            this.activityManager = (ActivityManager) context.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        public MemorySizeCalculator build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MemorySizeCalculator(this) : (MemorySizeCalculator) invokeV.objValue;
        }

        @VisibleForTesting
        public Builder setActivityManager(ActivityManager activityManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activityManager)) == null) {
                this.activityManager = activityManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setArrayPoolSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.arrayPoolSizeBytes = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBitmapPoolScreens(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                Preconditions.checkArgument(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
                this.bitmapPoolScreens = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
                Preconditions.checkArgument(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
                this.lowMemoryMaxSizeMultiplier = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setMaxSizeMultiplier(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                Preconditions.checkArgument(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
                this.maxSizeMultiplier = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setMemoryCacheScreens(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
                Preconditions.checkArgument(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
                this.memoryCacheScreens = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @VisibleForTesting
        public Builder setScreenDimensions(ScreenDimensions screenDimensions) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, screenDimensions)) == null) {
                this.screenDimensions = screenDimensions;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {displayMetrics};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.displayMetrics.heightPixels : invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.displayMetrics.widthPixels : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i = builder.arrayPoolSizeBytes / 2;
        } else {
            i = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i4 = maxSize - this.arrayPoolSize;
        int i5 = round2 + round;
        if (i5 <= i4) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f2 = i4;
            float f3 = builder.bitmapPoolScreens;
            float f4 = builder.memoryCacheScreens;
            float f5 = f2 / (f3 + f4);
            this.memoryCacheSize = Math.round(f4 * f5);
            this.bitmapPoolSize = Math.round(f5 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(", pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(", byte array size: ");
            sb.append(toMb(this.arrayPoolSize));
            sb.append(", memory class limited? ");
            sb.append(i5 > maxSize);
            sb.append(", max size: ");
            sb.append(toMb(maxSize));
            sb.append(", memoryClass: ");
            sb.append(builder.activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(builder.activityManager));
            Log.d(TAG, sb.toString());
        }
    }

    public static int getMaxSize(ActivityManager activityManager, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activityManager, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
            float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
            if (isLowMemoryDevice) {
                f2 = f3;
            }
            return Math.round(memoryClass * f2);
        }
        return invokeCommon.intValue;
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activityManager)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private String toMb(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) ? Formatter.formatFileSize(this.context, i) : (String) invokeI.objValue;
    }

    public int getArrayPoolSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.arrayPoolSize : invokeV.intValue;
    }

    public int getBitmapPoolSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bitmapPoolSize : invokeV.intValue;
    }

    public int getMemoryCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.memoryCacheSize : invokeV.intValue;
    }
}
