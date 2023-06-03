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
public class zk1 extends wk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, wk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zk1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229177493, "Lcom/baidu/tieba/zk1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-229177493, "Lcom/baidu/tieba/zk1$b;");
                    return;
                }
            }
            a = new zk1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362729, "Lcom/baidu/tieba/zk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362729, "Lcom/baidu/tieba/zk1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public zk1() {
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

    public static zk1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (zk1) invokeV.objValue;
    }

    public /* synthetic */ zk1(a aVar) {
        this();
    }

    public void g(wk1 wk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wk1Var) == null) && wk1Var != null) {
            wk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.wk1
    public boolean b(Context context, yk1 yk1Var, sk1 sk1Var) {
        InterceptResult invokeLLL;
        wk1 wk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, yk1Var, sk1Var)) == null) {
            String b2 = yk1Var.b();
            if (a.get(b2) != null) {
                yk1Var.f(b2, a.get(b2));
            }
            String d = yk1Var.d(true);
            if (TextUtils.isEmpty(d) || (wk1Var = b.get(d)) == null) {
                return false;
            }
            return wk1Var.b(context, yk1Var, sk1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wk1
    public boolean c(Context context, yk1 yk1Var, sk1 sk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yk1Var, sk1Var)) == null) {
            yk1Var.i = bl1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, wk1 wk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wk1Var) == null) && !TextUtils.isEmpty(str) && wk1Var != null) {
            b.put(str, wk1Var);
        }
    }
}
