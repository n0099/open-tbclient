package com.baidu.tieba;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class v62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192663, "Lcom/baidu/tieba/v62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192663, "Lcom/baidu/tieba/v62;");
                return;
            }
        }
        a = gp1.a;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (v62.class) {
                if (a) {
                    Log.d("SwanCpuProperty", "start cpu monitor thread");
                }
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                    try {
                        String c = c(bufferedReader);
                        if (a) {
                            Log.d("SwanCpuProperty", "stop cpu monitor thread , cpu rate is : " + c);
                        }
                        ap4.d(bufferedReader);
                        return c;
                    } catch (IOException e2) {
                        e = e2;
                        if (a) {
                            Log.e("SwanCpuProperty", "error in cpu monitor", e);
                        }
                        ap4.d(bufferedReader);
                        return "";
                    }
                } catch (IOException e3) {
                    bufferedReader = null;
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    ap4.d(null);
                    throw th;
                }
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a2 = a();
            try {
                if (a2.contains("%")) {
                    return Float.parseFloat(a2.replace("%", "").trim());
                }
                return Float.parseFloat(a2);
            } catch (Exception e) {
                if (a) {
                    Log.d("SwanCpuProperty", "解析cpu使用率错误", e);
                    return 0.0f;
                }
                return 0.0f;
            }
        }
        return invokeV.floatValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (com.baidu.tieba.v62.a != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        android.util.Log.e("SwanCpuProperty", "get CPU Fail : " + r11.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        char read;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedReader)) == null) {
            char[] cArr = new char[4];
            int i = 0;
            if (Build.VERSION.SDK_INT >= 26) {
                boolean z2 = true;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    char read2 = (char) bufferedReader.read();
                    if (z2 && read2 != ' ') {
                        i2++;
                    }
                    if (i2 == 9) {
                        if (read2 != '.' && read2 != ' ') {
                            cArr[i3] = read2;
                            i3++;
                        }
                        i = Integer.parseInt(String.valueOf(cArr, 0, i3)) / Runtime.getRuntime().availableProcessors();
                        return i + "%";
                    }
                    if (read2 == ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i2 <= 9 && read2 != 65535 && i3 < 4) {
                        z2 = z;
                    }
                    i = Integer.parseInt(String.valueOf(cArr, 0, i3)) / Runtime.getRuntime().availableProcessors();
                    return i + "%";
                }
            }
            int i4 = 0;
            do {
                read = (char) bufferedReader.read();
                if (read != ' ' && i4 != 4) {
                    cArr[i4] = read;
                    i4++;
                } else {
                    i4 = 0;
                }
                if (read == '%') {
                    break;
                }
            } while (read != 65535);
            return String.valueOf(cArr, 0, i4);
        }
        return (String) invokeL.objValue;
    }
}
