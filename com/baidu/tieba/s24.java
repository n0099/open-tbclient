package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u04;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes5.dex */
public class s24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile s24 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, k24> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099508, "Lcom/baidu/tieba/s24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099508, "Lcom/baidu/tieba/s24;");
                return;
            }
        }
        b = ok1.a;
    }

    public s24() {
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

    public static s24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (s24.class) {
                    if (c == null) {
                        c = new s24();
                    }
                }
            }
            return c;
        }
        return (s24) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(ob2 ob2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, ob2Var, str) == null) && ob2Var != null && ob2Var.y() != null && !TextUtils.isEmpty(str)) {
            ob2Var.y().b(str);
        }
    }

    public void f(ob2 ob2Var, u04.c cVar) {
        y34 y34Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ob2Var, cVar) == null) && ob2Var != null && cVar != null && (y34Var = cVar.c) != null && y34Var.g != null) {
            e();
            ln2.g0().getSwitch("swan_game_resource_preload", 0);
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

    public synchronized k24 d(ob2 ob2Var, lw1 lw1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ob2Var, lw1Var, i)) == null) {
            synchronized (this) {
                if (lw1Var == null) {
                    return null;
                }
                String B = lw1Var.B("url");
                String c2 = c(B, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                k24 remove = this.a.remove(c2);
                if (remove != null) {
                    a(ob2Var, "preload used, url = " + B);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
                }
                return remove;
            }
        }
        return (k24) invokeLLI.objValue;
    }
}
