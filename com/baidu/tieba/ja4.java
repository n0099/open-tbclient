package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l84;
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
public class ja4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile ja4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ba4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947876556, "Lcom/baidu/tieba/ja4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947876556, "Lcom/baidu/tieba/ja4;");
                return;
            }
        }
        b = fs1.a;
    }

    public ja4() {
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

    public static ja4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ja4.class) {
                    if (c == null) {
                        c = new ja4();
                    }
                }
            }
            return c;
        }
        return (ja4) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(fj2 fj2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, fj2Var, str) == null) && fj2Var != null && fj2Var.w() != null && !TextUtils.isEmpty(str)) {
            fj2Var.w().b(str);
        }
    }

    public void f(fj2 fj2Var, l84.c cVar) {
        pb4 pb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, fj2Var, cVar) == null) && fj2Var != null && cVar != null && (pb4Var = cVar.c) != null && pb4Var.g != null) {
            e();
            cv2.g0().getSwitch("swan_game_resource_preload", 0);
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

    public synchronized ba4 d(fj2 fj2Var, c42 c42Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fj2Var, c42Var, i)) == null) {
            synchronized (this) {
                if (c42Var == null) {
                    return null;
                }
                String B = c42Var.B("url");
                String c2 = c(B, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                ba4 remove = this.a.remove(c2);
                if (remove != null) {
                    a(fj2Var, "preload used, url = " + B);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
                }
                return remove;
            }
        }
        return (ba4) invokeLLI.objValue;
    }
}
