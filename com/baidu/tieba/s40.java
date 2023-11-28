package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class s40 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static int b = 10;
    public static int c = 56;
    public static long d = 400;
    public static long e = 5000;
    public static String f = "www.baidu.com";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948101306, "Lcom/baidu/tieba/s40;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948101306, "Lcom/baidu/tieba/s40;");
        }
    }

    public static void a(Context context, String str, String str2) {
        Process exec;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) && a && !TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            BufferedReader bufferedReader = null;
            String str3 = "ping -c " + b + " -w " + (((int) e) / 1000) + " -i " + (((float) d) / 1000.0f) + " -s " + c + " " + str;
            try {
                try {
                    if (n50.a) {
                        o50.b("LcpPingImpl", str3);
                    }
                    exec = Runtime.getRuntime().exec(str3);
                } catch (Throwable unused) {
                }
                if (exec == null) {
                    return;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder("\n");
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    exec.destroy();
                    c(context, str2, sb.toString(), currentTimeMillis, str);
                    bufferedReader2.close();
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    try {
                        if (n50.a) {
                            o50.b("LcpPingImpl", "ping exception");
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            a(context, f, str);
        }
    }

    public static void d(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z) == null) {
            a = z;
            p50.F(context, z);
        }
    }

    public static void e(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, context, i) == null) {
            c = i;
            p50.G(context, i);
        }
    }

    public static void g(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, context, j) == null) {
            e = j;
            p50.H(context, j);
        }
    }

    public static void h(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, null, context, j) == null) {
            d = j;
            p50.I(context, j);
        }
    }

    public static void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            f = str;
            p50.J(context, str);
        }
    }

    public static void j(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, context, j) == null) {
            p50.K(context, j);
        }
    }

    public static void k(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, context, i) == null) {
            b = i;
            p50.L(context, i);
        }
    }

    public static void c(Context context, String str, String str2, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Long.valueOf(j), str3}) == null) {
            f40 b2 = e40.h(context).b(601112);
            b2.d(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, str);
            b2.b("ping_times", b);
            b2.d("ping_target", str3);
            b2.d("original_ping_result", str2);
            b2.c("start_time_ms", j);
            b2.c("end_time_ms", System.currentTimeMillis());
            b2.b("ping_request_size", c);
            b2.e();
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            boolean t = p50.t(context);
            a = t;
            if (!t) {
                return;
            }
            b = p50.n(context);
            c = p50.i(context);
            p50.m(context);
            d = p50.k(context);
            e = p50.j(context);
            f = p50.l(context);
            i40.h(context, 601112, 1);
        }
    }
}
