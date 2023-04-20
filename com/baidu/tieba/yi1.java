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
public class yi1 extends vi1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, vi1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final yi1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-259653686, "Lcom/baidu/tieba/yi1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-259653686, "Lcom/baidu/tieba/yi1$b;");
                    return;
                }
            }
            a = new yi1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948331016, "Lcom/baidu/tieba/yi1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948331016, "Lcom/baidu/tieba/yi1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public yi1() {
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

    public static yi1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (yi1) invokeV.objValue;
    }

    public /* synthetic */ yi1(a aVar) {
        this();
    }

    public void g(vi1 vi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, vi1Var) == null) && vi1Var != null) {
            vi1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.vi1
    public boolean b(Context context, xi1 xi1Var, ri1 ri1Var) {
        InterceptResult invokeLLL;
        vi1 vi1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, xi1Var, ri1Var)) == null) {
            String b2 = xi1Var.b();
            if (a.get(b2) != null) {
                xi1Var.f(b2, a.get(b2));
            }
            String d = xi1Var.d(true);
            if (TextUtils.isEmpty(d) || (vi1Var = b.get(d)) == null) {
                return false;
            }
            return vi1Var.b(context, xi1Var, ri1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vi1
    public boolean c(Context context, xi1 xi1Var, ri1 ri1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xi1Var, ri1Var)) == null) {
            xi1Var.i = aj1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, vi1 vi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, vi1Var) == null) && !TextUtils.isEmpty(str) && vi1Var != null) {
            b.put(str, vi1Var);
        }
    }
}
