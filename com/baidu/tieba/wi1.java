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
public class wi1 extends ti1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, ti1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wi1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-316911988, "Lcom/baidu/tieba/wi1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-316911988, "Lcom/baidu/tieba/wi1$b;");
                    return;
                }
            }
            a = new wi1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948271434, "Lcom/baidu/tieba/wi1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948271434, "Lcom/baidu/tieba/wi1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public wi1() {
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

    public static wi1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (wi1) invokeV.objValue;
    }

    public /* synthetic */ wi1(a aVar) {
        this();
    }

    public void g(ti1 ti1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ti1Var) == null) && ti1Var != null) {
            ti1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.ti1
    public boolean b(Context context, vi1 vi1Var, pi1 pi1Var) {
        InterceptResult invokeLLL;
        ti1 ti1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, vi1Var, pi1Var)) == null) {
            String b2 = vi1Var.b();
            if (a.get(b2) != null) {
                vi1Var.f(b2, a.get(b2));
            }
            String d = vi1Var.d(true);
            if (TextUtils.isEmpty(d) || (ti1Var = b.get(d)) == null) {
                return false;
            }
            return ti1Var.b(context, vi1Var, pi1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ti1
    public boolean c(Context context, vi1 vi1Var, pi1 pi1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vi1Var, pi1Var)) == null) {
            vi1Var.i = yi1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ti1 ti1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ti1Var) == null) && !TextUtils.isEmpty(str) && ti1Var != null) {
            b.put(str, ti1Var);
        }
    }
}
