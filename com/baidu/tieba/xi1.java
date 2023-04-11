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
public class xi1 extends ui1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, ui1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xi1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-288282837, "Lcom/baidu/tieba/xi1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-288282837, "Lcom/baidu/tieba/xi1$b;");
                    return;
                }
            }
            a = new xi1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948301225, "Lcom/baidu/tieba/xi1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948301225, "Lcom/baidu/tieba/xi1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public xi1() {
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

    public static xi1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (xi1) invokeV.objValue;
    }

    public /* synthetic */ xi1(a aVar) {
        this();
    }

    public void g(ui1 ui1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ui1Var) == null) && ui1Var != null) {
            ui1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.ui1
    public boolean b(Context context, wi1 wi1Var, qi1 qi1Var) {
        InterceptResult invokeLLL;
        ui1 ui1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, wi1Var, qi1Var)) == null) {
            String b2 = wi1Var.b();
            if (a.get(b2) != null) {
                wi1Var.f(b2, a.get(b2));
            }
            String d = wi1Var.d(true);
            if (TextUtils.isEmpty(d) || (ui1Var = b.get(d)) == null) {
                return false;
            }
            return ui1Var.b(context, wi1Var, qi1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ui1
    public boolean c(Context context, wi1 wi1Var, qi1 qi1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wi1Var, qi1Var)) == null) {
            wi1Var.i = zi1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ui1 ui1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ui1Var) == null) && !TextUtils.isEmpty(str) && ui1Var != null) {
            b.put(str, ui1Var);
        }
    }
}
