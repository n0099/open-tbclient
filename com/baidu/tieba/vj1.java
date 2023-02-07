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
/* loaded from: classes6.dex */
public class vj1 extends sj1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, sj1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final vj1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-344617618, "Lcom/baidu/tieba/vj1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-344617618, "Lcom/baidu/tieba/vj1$b;");
                    return;
                }
            }
            a = new vj1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242604, "Lcom/baidu/tieba/vj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242604, "Lcom/baidu/tieba/vj1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public vj1() {
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

    public static vj1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (vj1) invokeV.objValue;
    }

    public /* synthetic */ vj1(a aVar) {
        this();
    }

    public void g(sj1 sj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, sj1Var) == null) && sj1Var != null) {
            sj1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.sj1
    public boolean b(Context context, uj1 uj1Var, oj1 oj1Var) {
        InterceptResult invokeLLL;
        sj1 sj1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, uj1Var, oj1Var)) == null) {
            String b2 = uj1Var.b();
            if (a.get(b2) != null) {
                uj1Var.f(b2, a.get(b2));
            }
            String d = uj1Var.d(true);
            if (TextUtils.isEmpty(d) || (sj1Var = b.get(d)) == null) {
                return false;
            }
            return sj1Var.b(context, uj1Var, oj1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.sj1
    public boolean c(Context context, uj1 uj1Var, oj1 oj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uj1Var, oj1Var)) == null) {
            uj1Var.i = xj1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, sj1 sj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sj1Var) == null) && !TextUtils.isEmpty(str) && sj1Var != null) {
            b.put(str, sj1Var);
        }
    }
}
