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
/* loaded from: classes5.dex */
public class me1 extends je1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, je1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final me1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-606897582, "Lcom/baidu/tieba/me1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-606897582, "Lcom/baidu/tieba/me1$b;");
                    return;
                }
            }
            a = new me1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969680, "Lcom/baidu/tieba/me1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969680, "Lcom/baidu/tieba/me1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public /* synthetic */ me1(a aVar) {
        this();
    }

    public static me1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (me1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.je1
    public boolean b(Context context, le1 le1Var, fe1 fe1Var) {
        InterceptResult invokeLLL;
        je1 je1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, le1Var, fe1Var)) == null) {
            String b2 = le1Var.b();
            if (a.get(b2) != null) {
                le1Var.f(b2, a.get(b2));
            }
            String d = le1Var.d(true);
            if (TextUtils.isEmpty(d) || (je1Var = b.get(d)) == null) {
                return false;
            }
            return je1Var.b(context, le1Var, fe1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.je1
    public boolean c(Context context, le1 le1Var, fe1 fe1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, le1Var, fe1Var)) == null) {
            le1Var.i = oe1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, je1 je1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, je1Var) == null) || TextUtils.isEmpty(str) || je1Var == null) {
            return;
        }
        b.put(str, je1Var);
    }

    public void g(je1 je1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, je1Var) == null) || je1Var == null) {
            return;
        }
        je1Var.a(a);
    }

    public me1() {
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
}
