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
/* loaded from: classes7.dex */
public class re1 extends oe1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, oe1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final re1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-463751827, "Lcom/baidu/tieba/re1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-463751827, "Lcom/baidu/tieba/re1$b;");
                    return;
                }
            }
            a = new re1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118635, "Lcom/baidu/tieba/re1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118635, "Lcom/baidu/tieba/re1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public re1() {
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

    public static re1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (re1) invokeV.objValue;
    }

    public /* synthetic */ re1(a aVar) {
        this();
    }

    public void g(oe1 oe1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, oe1Var) == null) && oe1Var != null) {
            oe1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.oe1
    public boolean b(Context context, qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLLL;
        oe1 oe1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, qe1Var, ke1Var)) == null) {
            String b2 = qe1Var.b();
            if (a.get(b2) != null) {
                qe1Var.f(b2, a.get(b2));
            }
            String d = qe1Var.d(true);
            if (TextUtils.isEmpty(d) || (oe1Var = b.get(d)) == null) {
                return false;
            }
            return oe1Var.b(context, qe1Var, ke1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.oe1
    public boolean c(Context context, qe1 qe1Var, ke1 ke1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qe1Var, ke1Var)) == null) {
            qe1Var.i = te1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, oe1 oe1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, oe1Var) == null) && !TextUtils.isEmpty(str) && oe1Var != null) {
            b.put(str, oe1Var);
        }
    }
}
