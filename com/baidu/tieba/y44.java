package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a34;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes9.dex */
public class y44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile y44 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, q44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280176, "Lcom/baidu/tieba/y44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280176, "Lcom/baidu/tieba/y44;");
                return;
            }
        }
        b = vm1.a;
    }

    public y44() {
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

    public static y44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (y44.class) {
                    if (c == null) {
                        c = new y44();
                    }
                }
            }
            return c;
        }
        return (y44) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(ud2 ud2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, ud2Var, str) == null) && ud2Var != null && ud2Var.w() != null && !TextUtils.isEmpty(str)) {
            ud2Var.w().b(str);
        }
    }

    public void f(ud2 ud2Var, a34.c cVar) {
        e64 e64Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ud2Var, cVar) == null) && ud2Var != null && cVar != null && (e64Var = cVar.c) != null && e64Var.g != null) {
            e();
            rp2.g0().getSwitch("swan_game_resource_preload", 0);
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

    public synchronized q44 d(ud2 ud2Var, sy1 sy1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ud2Var, sy1Var, i)) == null) {
            synchronized (this) {
                if (sy1Var == null) {
                    return null;
                }
                String C = sy1Var.C("url");
                String c2 = c(C, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                q44 remove = this.a.remove(c2);
                if (remove != null) {
                    a(ud2Var, "preload used, url = " + C);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + C + ";task:" + remove);
                }
                return remove;
            }
        }
        return (q44) invokeLLI.objValue;
    }
}
