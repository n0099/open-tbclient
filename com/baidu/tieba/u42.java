package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Date;
/* loaded from: classes6.dex */
public class u42 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948160950, "Lcom/baidu/tieba/u42;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948160950, "Lcom/baidu/tieba/u42;");
        }
    }

    public static String a(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) && eo1.a && objArr != null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            Log.d(str, sb.toString());
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            m("error", str, str2);
            br2.p0().e(str, str2);
            if (eo1.a) {
                Log.e(str, str2);
            }
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            m("info", str, str2);
            br2.p0().i(str, str2);
            if (eo1.a) {
                Log.i(str, str2);
            }
        }
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            br2.p0().i(str, str2);
            if (eo1.a) {
                Log.i(str, str2);
            }
        }
    }

    public static void o(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            m("warn", str, str2);
            br2.p0().w(str, str2);
            if (eo1.a) {
                Log.w(str, str2);
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) {
            if (th != null) {
                str3 = "Exception:" + th.getMessage() + "\n" + str2;
            } else {
                str3 = str2;
            }
            m("error", str, str3);
            br2.p0().e(str, str2, th);
            if (eo1.a) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            br2.p0().e(str, a2, th);
            if (z) {
                m("error", str, a2);
            }
        }
    }

    public static void p(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            br2.p0().w(str, a2, th);
            if (z) {
                m("warn", str, a2);
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 5) {
                return stackTrace[5].getLineNumber();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 5) {
                return stackTrace[5].getFileName();
            }
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f015c);
        }
        return (String) invokeV.objValue;
    }

    public static void j(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            br2.p0().i(str, a2);
            if (z) {
                m("info", str, a2);
            }
        }
    }

    public static void l(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, th) == null) {
            br2.p0().e(str, str2, th);
            if (eo1.a) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void m(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65549, null, str, str2, str3) == null) && a && !TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            String b = ik3.b(new Date(), "yyyy-MM-dd HH:mm:ss");
            String g = g();
            int h = h();
            sb.append(b);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append(g);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append("line:");
            sb.append(h);
            sb.append("\n");
            sb.append("module:");
            sb.append(str2);
            sb.append("\n");
            sb.append(str3);
            ht2.U().q().g0(str, sb.toString());
        }
    }

    public static void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            a = z;
        }
    }
}
