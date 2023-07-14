package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class wk1 extends tk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, tk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wk1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-315064946, "Lcom/baidu/tieba/wk1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-315064946, "Lcom/baidu/tieba/wk1$b;");
                    return;
                }
            }
            a = new wk1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948273356, "Lcom/baidu/tieba/wk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948273356, "Lcom/baidu/tieba/wk1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public wk1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static wk1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (wk1) invokeV.objValue;
    }

    public /* synthetic */ wk1(a aVar) {
        this();
    }

    public void g(tk1 tk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, tk1Var) == null) && tk1Var != null) {
            tk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.tk1
    public boolean b(Context context, vk1 vk1Var, pk1 pk1Var) {
        InterceptResult invokeLLL;
        tk1 tk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, vk1Var, pk1Var)) == null) {
            String b2 = vk1Var.b();
            if (a.get(b2) != null) {
                vk1Var.f(b2, a.get(b2));
            }
            String d = vk1Var.d(true);
            if (TextUtils.isEmpty(d) || (tk1Var = b.get(d)) == null) {
                return false;
            }
            return tk1Var.b(context, vk1Var, pk1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.tk1
    public boolean c(Context context, vk1 vk1Var, pk1 pk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vk1Var, pk1Var)) == null) {
            vk1Var.i = yk1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, tk1 tk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, tk1Var) == null) && !TextUtils.isEmpty(str) && tk1Var != null) {
            b.put(str, tk1Var);
        }
    }
}
