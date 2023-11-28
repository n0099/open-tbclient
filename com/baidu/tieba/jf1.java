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
public class jf1 extends gf1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, gf1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final jf1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-691861514, "Lcom/baidu/tieba/jf1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-691861514, "Lcom/baidu/tieba/jf1$b;");
                    return;
                }
            }
            a = new jf1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947881268, "Lcom/baidu/tieba/jf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947881268, "Lcom/baidu/tieba/jf1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public jf1() {
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

    public static jf1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (jf1) invokeV.objValue;
    }

    public /* synthetic */ jf1(a aVar) {
        this();
    }

    public void g(gf1 gf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, gf1Var) == null) && gf1Var != null) {
            gf1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.gf1
    public boolean b(Context context, if1 if1Var, cf1 cf1Var) {
        InterceptResult invokeLLL;
        gf1 gf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, if1Var, cf1Var)) == null) {
            String b2 = if1Var.b();
            if (a.get(b2) != null) {
                if1Var.f(b2, a.get(b2));
            }
            String d = if1Var.d(true);
            if (TextUtils.isEmpty(d) || (gf1Var = b.get(d)) == null) {
                return false;
            }
            return gf1Var.b(context, if1Var, cf1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.gf1
    public boolean c(Context context, if1 if1Var, cf1 cf1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, if1Var, cf1Var)) == null) {
            if1Var.i = lf1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, gf1 gf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, gf1Var) == null) && !TextUtils.isEmpty(str) && gf1Var != null) {
            b.put(str, gf1Var);
        }
    }
}
