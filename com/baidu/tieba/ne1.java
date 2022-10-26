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
public class ne1 extends ke1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public static HashMap b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ne1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-578268431, "Lcom/baidu/tieba/ne1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-578268431, "Lcom/baidu/tieba/ne1$b;");
                    return;
                }
            }
            a = new ne1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947999471, "Lcom/baidu/tieba/ne1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947999471, "Lcom/baidu/tieba/ne1;");
                return;
            }
        }
        a = new HashMap();
        b = new HashMap();
    }

    public ne1() {
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

    public static ne1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ne1) invokeV.objValue;
    }

    public /* synthetic */ ne1(a aVar) {
        this();
    }

    public void g(ke1 ke1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ke1Var) == null) && ke1Var != null) {
            ke1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.ke1
    public boolean b(Context context, me1 me1Var, ge1 ge1Var) {
        InterceptResult invokeLLL;
        ke1 ke1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, me1Var, ge1Var)) == null) {
            String b2 = me1Var.b();
            if (a.get(b2) != null) {
                me1Var.f(b2, (String) a.get(b2));
            }
            String d = me1Var.d(true);
            if (TextUtils.isEmpty(d) || (ke1Var = (ke1) b.get(d)) == null) {
                return false;
            }
            return ke1Var.b(context, me1Var, ge1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ke1
    public boolean c(Context context, me1 me1Var, ge1 ge1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, me1Var, ge1Var)) == null) {
            me1Var.i = pe1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ke1 ke1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ke1Var) == null) && !TextUtils.isEmpty(str) && ke1Var != null) {
            b.put(str, ke1Var);
        }
    }
}
