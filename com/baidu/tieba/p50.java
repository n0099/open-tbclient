package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p50 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948012894, "Lcom/baidu/tieba/p50;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948012894, "Lcom/baidu/tieba/p50;");
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SharedPreferences a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPreferences, str, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sharedPreferences;
            this.b = str;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p50.T(this.a, this.b, this.c);
            }
        }
    }

    public static void A(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            a = str;
            V(context, "blcp_cuid", str);
        }
    }

    public static void B(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, context, i) == null) {
            R(context, "key_vip_connect_type", i);
        }
    }

    public static void C(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) {
            R(context, "lcp_env_debug", i);
        }
    }

    public static void D(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z) == null) {
            P(context, "lcp_debug", z);
        }
    }

    public static void E(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            V(context, "lcp_connection_cache", str);
        }
    }

    public static void F(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, context, z) == null) {
            P(context, "lcp_is_ping", z);
        }
    }

    public static void G(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i) == null) {
            R(context, "lcp_body_size", i);
        }
    }

    public static void H(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, null, context, j) == null) {
            S(context, "lcp_ping_dealine", j);
        }
    }

    public static void I(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, context, j) == null) {
            S(context, "lcp_ping_interval", j);
        }
    }

    public static void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            V(context, "lcp_ping_url", str);
        }
    }

    public static void K(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, context, j) == null) {
            S(context, "lcp_ping_timeout", j);
        }
    }

    public static void L(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, context, i) == null) {
            R(context, "lcp_ping_times", i);
        }
    }

    public static void N(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, context, i) == null) {
            R(context, "protocols_size", i);
        }
    }

    public static void O(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            V(context, "blcp_token", str);
        }
    }

    public static void Q(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, context, i) == null) {
            R(context, "conn_type", i);
        }
    }

    public static String o(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65573, null, context, i)) == null) {
            return x(context, "protocol_priority" + i, " : : ");
        }
        return (String) invokeLI.objValue;
    }

    public static void y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, context, str) == null) {
            b = str;
            V(context, "blcp_app_id", str);
        }
    }

    public static void z(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65584, null, context, z) == null) {
            P(context, "bddns_enable", z);
        }
    }

    public static void M(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, null, context, str, i) == null) {
            V(context, "protocol_priority" + i, str);
        }
    }

    public static void P(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65552, null, context, str, z) == null) {
            U(context, str, Boolean.valueOf(z));
        }
    }

    public static void R(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, null, context, str, i) == null) {
            U(context, str, Integer.valueOf(i));
        }
    }

    public static void S(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            U(context, str, Long.valueOf(j));
        }
    }

    public static void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, str, str2) == null) {
            U(context, str, str2);
        }
    }

    public static boolean u(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65579, null, context, str, z)) == null) {
            if (context == null) {
                return false;
            }
            return context.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static int v(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65580, null, context, str, i)) == null) {
            if (context == null) {
                return -1;
            }
            return context.getSharedPreferences("blcp_sp", 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static String x(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, null, context, str, str2)) == null) {
            if (context == null) {
                return "";
            }
            return context.getSharedPreferences("blcp_sp", 0).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void T(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, sharedPreferences, str, obj) == null) {
            if (obj instanceof Boolean) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            } else if (obj instanceof Integer) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof String) {
                sharedPreferences.edit().putString(str, (String) obj).apply();
            }
        }
    }

    public static void U(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65557, null, context, str, obj) != null) || context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("blcp_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                l50.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                T(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            o50.b("SpUtils", th.getMessage());
        }
    }

    public static long w(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            if (context == null) {
                return -1L;
            }
            return context.getSharedPreferences("blcp_sp", 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            return x(context, "blcp_app_id", "");
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            return u(context, "bddns_enable", false);
        }
        return invokeL.booleanValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            return v(context, "conn_type", 1);
        }
        return invokeL.intValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return x(context, "blcp_cuid", "");
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            return v(context, "key_vip_connect_type", 3);
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            return v(context, "lcp_env_debug", 0);
        }
        return invokeL.intValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            return x(context, "lcp_connection_cache", "");
        }
        return (String) invokeL.objValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            return v(context, "lcp_body_size", 0);
        }
        return invokeL.intValue;
    }

    public static long j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            return w(context, "lcp_ping_dealine", 0L);
        }
        return invokeL.longValue;
    }

    public static long k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            return w(context, "lcp_ping_interval", 0L);
        }
        return invokeL.longValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return x(context, "lcp_ping_url", "");
        }
        return (String) invokeL.objValue;
    }

    public static long m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            return w(context, "lcp_ping_timeout", 0L);
        }
        return invokeL.longValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            return v(context, "lcp_ping_times", 0);
        }
        return invokeL.intValue;
    }

    public static int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            return v(context, "protocols_size", 1);
        }
        return invokeL.intValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            return x(context, "blcp_token", "");
        }
        return (String) invokeL.objValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            return !TextUtils.isEmpty(q(context));
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            return u(context, "lcp_debug", false);
        }
        return invokeL.booleanValue;
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            return u(context, "lcp_is_ping", false);
        }
        return invokeL.booleanValue;
    }
}
