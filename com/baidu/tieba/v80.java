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
/* loaded from: classes6.dex */
public class v80 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948194523, "Lcom/baidu/tieba/v80;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948194523, "Lcom/baidu/tieba/v80;");
        }
    }

    /* loaded from: classes6.dex */
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
                v80.B(this.a, this.b, this.c);
            }
        }
    }

    public static void A(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, context, str, i) == null) {
            C(context, str, Integer.valueOf(i));
        }
    }

    public static void D(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2) == null) {
            C(context, str, str2);
        }
    }

    public static boolean m(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65553, null, context, str, z)) == null) {
            if (context == null) {
                return false;
            }
            return context.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static int n(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, null, context, str, i)) == null) {
            if (context == null) {
                return -1;
            }
            return context.getSharedPreferences("blcp_sp", 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static String o(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            if (context == null) {
                return "";
            }
            return context.getSharedPreferences("blcp_sp", 0).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void v(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65562, null, context, str, i) == null) {
            D(context, "protocol_priority" + i, str);
        }
    }

    public static void y(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65565, null, context, str, z) == null) {
            C(context, str, Boolean.valueOf(z));
        }
    }

    public static void B(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, sharedPreferences, str, obj) == null) {
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

    public static void C(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, context, str, obj) != null) || context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("blcp_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                r80.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                B(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            u80.b("SpUtils", th.getMessage());
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            return o(context, "blcp_app_id", "");
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return m(context, "bddns_enable", false);
        }
        return invokeL.booleanValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return n(context, "conn_type", 1);
        }
        return invokeL.intValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return o(context, "blcp_cuid", "");
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            return n(context, "key_vip_connect_type", 3);
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            return n(context, "lcp_env_debug", 0);
        }
        return invokeL.intValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            return n(context, "protocols_size", 1);
        }
        return invokeL.intValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            return o(context, "blcp_token", "");
        }
        return (String) invokeL.objValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            return !TextUtils.isEmpty(j(context));
        }
        return invokeL.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            return m(context, "lcp_debug", false);
        }
        return invokeL.booleanValue;
    }

    public static String h(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i)) == null) {
            return o(context, "protocol_priority" + i, " : : ");
        }
        return (String) invokeLI.objValue;
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, str) == null) {
            b = str;
            D(context, "blcp_app_id", str);
        }
    }

    public static void q(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, context, z) == null) {
            y(context, "bddns_enable", z);
        }
    }

    public static void r(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, str) == null) {
            a = str;
            D(context, "blcp_cuid", str);
        }
    }

    public static void s(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65559, null, context, i) == null) {
            A(context, "key_vip_connect_type", i);
        }
    }

    public static void t(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65560, null, context, i) == null) {
            A(context, "lcp_env_debug", i);
        }
    }

    public static void u(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65561, null, context, z) == null) {
            y(context, "lcp_debug", z);
        }
    }

    public static void w(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65563, null, context, i) == null) {
            A(context, "protocols_size", i);
        }
    }

    public static void x(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, context, str) == null) {
            D(context, "blcp_token", str);
        }
    }

    public static void z(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65566, null, context, i) == null) {
            A(context, "conn_type", i);
        }
    }
}
