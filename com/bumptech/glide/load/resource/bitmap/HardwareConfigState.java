package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes3.dex */
public final class HardwareConfigState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final File FD_SIZE_LIST;
    public static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    public static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    public static final int MIN_HARDWARE_DIMENSION = 128;
    public static volatile HardwareConfigState instance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int decodesSinceLastFdCheck;
    public volatile boolean isHardwareConfigAllowed;

    static {
        InterceptResult invokeClinit;
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
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    public HardwareConfigState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isHardwareConfigAllowed = true;
    }

    public static HardwareConfigState getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                boolean z2 = true;
                int i2 = this.decodesSinceLastFdCheck + 1;
                this.decodesSinceLastFdCheck = i2;
                if (i2 >= 50) {
                    this.decodesSinceLastFdCheck = 0;
                    int length = FD_SIZE_LIST.list().length;
                    if (length >= 700) {
                        z2 = false;
                    }
                    this.isHardwareConfigAllowed = z2;
                    if (!this.isHardwareConfigAllowed && Log.isLoggable(Downsampler.TAG, 5)) {
                        String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700";
                    }
                }
                z = this.isHardwareConfigAllowed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), options, decodeFormat, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!z || Build.VERSION.SDK_INT < 26 || z2) {
                return false;
            }
            boolean z3 = i2 >= 128 && i3 >= 128 && isFdSizeBelowHardwareLimit();
            if (z3) {
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                options.inMutable = false;
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }
}
