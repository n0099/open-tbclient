package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x74;
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
public class v94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile v94 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, n94> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195608, "Lcom/baidu/tieba/v94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195608, "Lcom/baidu/tieba/v94;");
                return;
            }
        }
        b = rr1.a;
    }

    public v94() {
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

    public static v94 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (v94.class) {
                    if (c == null) {
                        c = new v94();
                    }
                }
            }
            return c;
        }
        return (v94) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(ri2 ri2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, ri2Var, str) == null) && ri2Var != null && ri2Var.w() != null && !TextUtils.isEmpty(str)) {
            ri2Var.w().b(str);
        }
    }

    public void f(ri2 ri2Var, x74.c cVar) {
        bb4 bb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ri2Var, cVar) == null) && ri2Var != null && cVar != null && (bb4Var = cVar.c) != null && bb4Var.g != null) {
            e();
            ou2.g0().getSwitch("swan_game_resource_preload", 0);
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

    public synchronized n94 d(ri2 ri2Var, o32 o32Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ri2Var, o32Var, i)) == null) {
            synchronized (this) {
                if (o32Var == null) {
                    return null;
                }
                String B = o32Var.B("url");
                String c2 = c(B, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                n94 remove = this.a.remove(c2);
                if (remove != null) {
                    a(ri2Var, "preload used, url = " + B);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
                }
                return remove;
            }
        }
        return (n94) invokeLLI.objValue;
    }
}
