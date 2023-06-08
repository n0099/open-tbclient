package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.imagepipeline.memory.DefaultByteArrayPoolParams;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes7.dex */
public class reb {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static volatile String b;
    public static BufferedWriter c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948120154, "Lcom/baidu/tieba/reb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948120154, "Lcom/baidu/tieba/reb;");
                return;
            }
        }
        a = new Object();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (a) {
                if (c != null) {
                    try {
                        c.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            new File(str).mkdirs();
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            b = str;
            b += xeb.n() + ".syslog";
            ueb.d("CrashLog", "Log file path : " + b);
            File file = new File(b);
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                c = new BufferedWriter(new FileWriter(b, true), DefaultByteArrayPoolParams.MAX_SIZE_SOFT_CAP);
            } catch (Exception e2) {
                e2.printStackTrace();
                c = null;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            e(str, str2, true);
        }
    }

    public static void e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, str, str2, z) == null) {
            if (z) {
                ueb.d(str, str2);
            }
            try {
                synchronized (a) {
                    if (c == null) {
                        c(xeb.s());
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    new Date(currentTimeMillis);
                    c.write(String.format("%s\n", str2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
