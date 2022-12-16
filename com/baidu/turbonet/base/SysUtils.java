package com.baidu.turbonet.base;

import android.os.StrictMode;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class SysUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-734283909, "Lcom/baidu/turbonet/base/SysUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-734283909, "Lcom/baidu/turbonet/base/SysUtils;");
        }
    }

    public SysUtils() {
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

    @CalledByNative
    public static boolean isLowEndDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (a == null) {
                a = Boolean.valueOf(b());
            }
            return a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static int a() {
        InterceptResult invokeV;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                try {
                    fileReader = new FileReader(HardwareInfoUtils.MEM_INFO_FILE);
                } catch (Exception e) {
                    Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e);
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            Log.w("SysUtils", "/proc/meminfo lacks a MemTotal entry?");
                            break;
                        }
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.find()) {
                            int parseInt = Integer.parseInt(matcher.group(1));
                            if (parseInt <= 1024) {
                                Log.w("SysUtils", "Invalid /proc/meminfo total size in kB: " + matcher.group(1));
                            } else {
                                bufferedReader.close();
                                return parseInt;
                            }
                        }
                    }
                    bufferedReader.close();
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return 0;
                } finally {
                    fileReader.close();
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (CommandLine.a().b("enable-low-end-device-mode")) {
                return true;
            }
            if (!CommandLine.a().b("disable-low-end-device-mode") && (a2 = a()) > 0 && a2 / 1024 <= 512) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
