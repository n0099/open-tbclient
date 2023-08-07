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
/* loaded from: classes8.dex */
public class zj1 extends wj1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, wj1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zj1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230101014, "Lcom/baidu/tieba/zj1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-230101014, "Lcom/baidu/tieba/zj1$b;");
                    return;
                }
            }
            a = new zj1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948361768, "Lcom/baidu/tieba/zj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948361768, "Lcom/baidu/tieba/zj1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public zj1() {
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

    public static zj1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (zj1) invokeV.objValue;
    }

    public /* synthetic */ zj1(a aVar) {
        this();
    }

    public void g(wj1 wj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wj1Var) == null) && wj1Var != null) {
            wj1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.wj1
    public boolean b(Context context, yj1 yj1Var, sj1 sj1Var) {
        InterceptResult invokeLLL;
        wj1 wj1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, yj1Var, sj1Var)) == null) {
            String b2 = yj1Var.b();
            if (a.get(b2) != null) {
                yj1Var.f(b2, a.get(b2));
            }
            String d = yj1Var.d(true);
            if (TextUtils.isEmpty(d) || (wj1Var = b.get(d)) == null) {
                return false;
            }
            return wj1Var.b(context, yj1Var, sj1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wj1
    public boolean c(Context context, yj1 yj1Var, sj1 sj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yj1Var, sj1Var)) == null) {
            yj1Var.i = bk1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, wj1 wj1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wj1Var) == null) && !TextUtils.isEmpty(str) && wj1Var != null) {
            b.put(str, wj1Var);
        }
    }
}
