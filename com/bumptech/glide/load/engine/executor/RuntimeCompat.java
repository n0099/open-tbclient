package com.bumptech.glide.load.engine.executor;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class RuntimeCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    public static final String CPU_NAME_REGEX = "cpu[0-9]+";
    public static final String TAG = "GlideRuntimeCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public RuntimeCompat() {
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

    public static int availableProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            return Build.VERSION.SDK_INT < 17 ? Math.max(getCoreCountPre17(), availableProcessors) : availableProcessors;
        }
        return invokeV.intValue;
    }

    public static int getCoreCountPre17() {
        InterceptResult invokeV;
        File[] fileArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                fileArr = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter(Pattern.compile(CPU_NAME_REGEX)) { // from class: com.bumptech.glide.load.engine.executor.RuntimeCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Pattern val$cpuNamePattern;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r6};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$cpuNamePattern = r6;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? this.val$cpuNamePattern.matcher(str).matches() : invokeLL.booleanValue;
                    }
                });
            } catch (Throwable th) {
                try {
                    if (Log.isLoggable(TAG, 6)) {
                        Log.e(TAG, "Failed to calculate accurate cpu count", th);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    fileArr = null;
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return Math.max(1, fileArr != null ? fileArr.length : 0);
        }
        return invokeV.intValue;
    }
}
