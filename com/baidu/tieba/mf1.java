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
public class mf1 extends jf1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, jf1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final mf1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-605974061, "Lcom/baidu/tieba/mf1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-605974061, "Lcom/baidu/tieba/mf1$b;");
                    return;
                }
            }
            a = new mf1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947970641, "Lcom/baidu/tieba/mf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947970641, "Lcom/baidu/tieba/mf1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public mf1() {
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

    public static mf1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (mf1) invokeV.objValue;
    }

    public /* synthetic */ mf1(a aVar) {
        this();
    }

    public void g(jf1 jf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jf1Var) == null) && jf1Var != null) {
            jf1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.jf1
    public boolean b(Context context, lf1 lf1Var, ff1 ff1Var) {
        InterceptResult invokeLLL;
        jf1 jf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, lf1Var, ff1Var)) == null) {
            String b2 = lf1Var.b();
            if (a.get(b2) != null) {
                lf1Var.f(b2, a.get(b2));
            }
            String d = lf1Var.d(true);
            if (TextUtils.isEmpty(d) || (jf1Var = b.get(d)) == null) {
                return false;
            }
            return jf1Var.b(context, lf1Var, ff1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.jf1
    public boolean c(Context context, lf1 lf1Var, ff1 ff1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lf1Var, ff1Var)) == null) {
            lf1Var.i = of1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, jf1 jf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jf1Var) == null) && !TextUtils.isEmpty(str) && jf1Var != null) {
            b.put(str, jf1Var);
        }
    }
}
