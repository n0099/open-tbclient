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
public class qj1 extends nj1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, nj1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final qj1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487763373, "Lcom/baidu/tieba/qj1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-487763373, "Lcom/baidu/tieba/qj1$b;");
                    return;
                }
            }
            a = new qj1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948093649, "Lcom/baidu/tieba/qj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948093649, "Lcom/baidu/tieba/qj1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public qj1() {
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

    public static qj1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (qj1) invokeV.objValue;
    }

    public /* synthetic */ qj1(a aVar) {
        this();
    }

    public void g(nj1 nj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nj1Var) == null) && nj1Var != null) {
            nj1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.nj1
    public boolean b(Context context, pj1 pj1Var, jj1 jj1Var) {
        InterceptResult invokeLLL;
        nj1 nj1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, pj1Var, jj1Var)) == null) {
            String b2 = pj1Var.b();
            if (a.get(b2) != null) {
                pj1Var.f(b2, a.get(b2));
            }
            String d = pj1Var.d(true);
            if (TextUtils.isEmpty(d) || (nj1Var = b.get(d)) == null) {
                return false;
            }
            return nj1Var.b(context, pj1Var, jj1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nj1
    public boolean c(Context context, pj1 pj1Var, jj1 jj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pj1Var, jj1Var)) == null) {
            pj1Var.i = sj1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, nj1 nj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, nj1Var) == null) && !TextUtils.isEmpty(str) && nj1Var != null) {
            b.put(str, nj1Var);
        }
    }
}
