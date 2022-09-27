package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b04;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes6.dex */
public class z14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile z14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, r14> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307084, "Lcom/baidu/tieba/z14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307084, "Lcom/baidu/tieba/z14;");
                return;
            }
        }
        b = vj1.a;
    }

    public z14() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static void a(va2 va2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, va2Var, str) == null) || va2Var == null || va2Var.y() == null || TextUtils.isEmpty(str)) {
            return;
        }
        va2Var.y().b(str);
    }

    public static z14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (z14.class) {
                    if (c == null) {
                        c = new z14();
                    }
                }
            }
            return c;
        }
        return (z14) invokeV.objValue;
    }

    public final String c(String str, int i) {
        InterceptResult invokeLI;
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
                return null;
            }
            return parse.url().toString() + i;
        }
        return (String) invokeLI.objValue;
    }

    public synchronized r14 d(va2 va2Var, sv1 sv1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, va2Var, sv1Var, i)) == null) {
            synchronized (this) {
                if (sv1Var == null) {
                    return null;
                }
                String B = sv1Var.B("url");
                String c2 = c(B, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                r14 remove = this.a.remove(c2);
                if (remove != null) {
                    a(va2Var, "preload used, url = " + B);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
                }
                return remove;
            }
        }
        return (r14) invokeLLI.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public void f(va2 va2Var, b04.c cVar) {
        f34 f34Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, va2Var, cVar) == null) || va2Var == null || cVar == null || (f34Var = cVar.c) == null || f34Var.g == null) {
            return;
        }
        e();
        sm2.g0().getSwitch("swan_game_resource_preload", 0);
    }
}
