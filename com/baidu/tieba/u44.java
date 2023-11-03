package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.w24;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class u44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile u44 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, m44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161012, "Lcom/baidu/tieba/u44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161012, "Lcom/baidu/tieba/u44;");
                return;
            }
        }
        b = rm1.a;
    }

    public u44() {
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

    public static u44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (u44.class) {
                    if (c == null) {
                        c = new u44();
                    }
                }
            }
            return c;
        }
        return (u44) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(qd2 qd2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, qd2Var, str) == null) && qd2Var != null && qd2Var.w() != null && !TextUtils.isEmpty(str)) {
            qd2Var.w().b(str);
        }
    }

    public void f(qd2 qd2Var, w24.c cVar) {
        a64 a64Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, qd2Var, cVar) == null) && qd2Var != null && cVar != null && (a64Var = cVar.c) != null && a64Var.g != null) {
            e();
            np2.g0().getSwitch("swan_game_resource_preload", 0);
        }
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

    public synchronized m44 d(qd2 qd2Var, oy1 oy1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qd2Var, oy1Var, i)) == null) {
            synchronized (this) {
                if (oy1Var == null) {
                    return null;
                }
                String C = oy1Var.C("url");
                String c2 = c(C, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                m44 remove = this.a.remove(c2);
                if (remove != null) {
                    a(qd2Var, "preload used, url = " + C);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + C + ";task:" + remove);
                }
                return remove;
            }
        }
        return (m44) invokeLLI.objValue;
    }
}
