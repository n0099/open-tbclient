package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class HardwareConfigState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    public static final File FD_SIZE_LIST;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    public static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    public static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    public static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    @VisibleForTesting
    public static final int MIN_HARDWARE_DIMENSION_O = 128;
    public static final int MIN_HARDWARE_DIMENSION_P = 0;
    public static final int NO_MAX_FD_COUNT = -1;
    public static final String TAG = "HardwareConfig";
    public static volatile HardwareConfigState instance;
    public static volatile int manualOverrideMaxFdCount;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public int decodesSinceLastFdCheck;
    @GuardedBy("this")
    public boolean isFdSizeBelowHardwareLimit;
    public final AtomicBoolean isHardwareConfigAllowedByAppState;
    public final boolean isHardwareConfigAllowedByDeviceModel;
    public final int minHardwareDimension;
    public final int sdkBasedMaxFdCount;

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830500439, "Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-830500439, "Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;");
                return;
            }
        }
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 29) {
            z = true;
        } else {
            z = false;
        }
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = z;
        if (Build.VERSION.SDK_INT < 26) {
            z2 = false;
        }
        HARDWARE_BITMAPS_SUPPORTED = z2;
        FD_SIZE_LIST = new File("/proc/self/fd");
        manualOverrideMaxFdCount = -1;
    }

    @VisibleForTesting
    public HardwareConfigState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isFdSizeBelowHardwareLimit = true;
        this.isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
        this.isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
        if (Build.VERSION.SDK_INT >= 28) {
            this.sdkBasedMaxFdCount = 20000;
            this.minHardwareDimension = 0;
            return;
        }
        this.sdkBasedMaxFdCount = 700;
        this.minHardwareDimension = 128;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            synchronized (this) {
                boolean z2 = true;
                int i = this.decodesSinceLastFdCheck + 1;
                this.decodesSinceLastFdCheck = i;
                if (i >= 50) {
                    this.decodesSinceLastFdCheck = 0;
                    int length = FD_SIZE_LIST.list().length;
                    long maxFdCount = getMaxFdCount();
                    if (length >= maxFdCount) {
                        z2 = false;
                    }
                    this.isFdSizeBelowHardwareLimit = z2;
                    if (!z2 && Log.isLoggable(Downsampler.TAG, 5)) {
                        Log.w(Downsampler.TAG, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + maxFdCount);
                    }
                }
                z = this.isFdSizeBelowHardwareLimit;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHardwareConfigDisallowedByB112551574() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT != 26) {
                return false;
            }
            for (String str : Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play")) {
                if (Build.MODEL.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHardwareConfigDisallowedByB147430447() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT != 27) {
                return false;
            }
            return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static HardwareConfigState getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (instance == null) {
                synchronized (HardwareConfigState.class) {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                }
            }
            return instance;
        }
        return (HardwareConfigState) invokeV.objValue;
    }

    private int getMaxFdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (manualOverrideMaxFdCount != -1) {
                return manualOverrideMaxFdCount;
            }
            return this.sdkBasedMaxFdCount;
        }
        return invokeV.intValue;
    }

    public static boolean isHardwareConfigAllowedByDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (!isHardwareConfigDisallowedByB112551574() && !isHardwareConfigDisallowedByB147430447()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean areHardwareBitmapsBlocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Util.assertMainThread();
            return !this.isHardwareConfigAllowedByAppState.get();
        }
        return invokeV.booleanValue;
    }

    public void blockHardwareBitmaps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Util.assertMainThread();
            this.isHardwareConfigAllowedByAppState.set(false);
        }
    }

    public void unblockHardwareBitmaps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Util.assertMainThread();
            this.isHardwareConfigAllowedByAppState.set(true);
        }
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!z) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed by caller");
                }
                return false;
            } else if (!this.isHardwareConfigAllowedByDeviceModel) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed by device model");
                }
                return false;
            } else if (!HARDWARE_BITMAPS_SUPPORTED) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed by sdk");
                }
                return false;
            } else if (areHardwareBitmapsBlockedByAppState()) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed by app state");
                }
                return false;
            } else if (z2) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed because exif orientation is required");
                }
                return false;
            } else {
                int i3 = this.minHardwareDimension;
                if (i < i3) {
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Hardware config disallowed because width is too small");
                    }
                    return false;
                } else if (i2 < i3) {
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Hardware config disallowed because height is too small");
                    }
                    return false;
                } else if (!isFdSizeBelowHardwareLimit()) {
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
                    }
                    return false;
                } else {
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), options, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
            if (isHardwareConfigAllowed) {
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                options.inMutable = false;
            }
            return isHardwareConfigAllowed;
        }
        return invokeCommon.booleanValue;
    }
}
