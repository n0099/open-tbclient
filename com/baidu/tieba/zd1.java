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
public class zd1 extends wd1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, wd1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zd1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235642140, "Lcom/baidu/tieba/zd1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235642140, "Lcom/baidu/tieba/zd1$b;");
                    return;
                }
            }
            a = new zd1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356002, "Lcom/baidu/tieba/zd1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356002, "Lcom/baidu/tieba/zd1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public /* synthetic */ zd1(a aVar) {
        this();
    }

    public static zd1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (zd1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wd1
    public boolean b(Context context, yd1 yd1Var, sd1 sd1Var) {
        InterceptResult invokeLLL;
        wd1 wd1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, yd1Var, sd1Var)) == null) {
            String b2 = yd1Var.b();
            if (a.get(b2) != null) {
                yd1Var.f(b2, a.get(b2));
            }
            String d = yd1Var.d(true);
            if (TextUtils.isEmpty(d) || (wd1Var = b.get(d)) == null) {
                return false;
            }
            return wd1Var.b(context, yd1Var, sd1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wd1
    public boolean c(Context context, yd1 yd1Var, sd1 sd1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yd1Var, sd1Var)) == null) {
            yd1Var.i = be1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, wd1 wd1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wd1Var) == null) || TextUtils.isEmpty(str) || wd1Var == null) {
            return;
        }
        b.put(str, wd1Var);
    }

    public void g(wd1 wd1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, wd1Var) == null) || wd1Var == null) {
            return;
        }
        wd1Var.a(a);
    }

    public zd1() {
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
