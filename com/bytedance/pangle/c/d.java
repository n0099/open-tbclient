package com.bytedance.pangle.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294229903, "Lcom/bytedance/pangle/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294229903, "Lcom/bytedance/pangle/c/d;");
                return;
            }
        }
        b = new CopyOnWriteArrayList();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String processName = Application.getProcessName();
                    if (!TextUtils.isEmpty(processName)) {
                        a = processName;
                    }
                    return a;
                }
            } catch (Throwable unused) {
            }
            try {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
                if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                    a = (String) invokeStaticMethod;
                }
                return a;
            } catch (Exception e) {
                e.printStackTrace();
                String b2 = b();
                a = b2;
                return b2;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String a2 = a();
            return (a2 == null || !a2.contains(":")) && a2 != null && a2.equals(context.getPackageName());
        }
        return invokeL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1] : (String) invokeL.objValue;
    }
}
