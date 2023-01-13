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
public class kf1 extends hf1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, hf1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kf1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-663232363, "Lcom/baidu/tieba/kf1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-663232363, "Lcom/baidu/tieba/kf1$b;");
                    return;
                }
            }
            a = new kf1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947911059, "Lcom/baidu/tieba/kf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947911059, "Lcom/baidu/tieba/kf1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public kf1() {
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

    public static kf1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (kf1) invokeV.objValue;
    }

    public /* synthetic */ kf1(a aVar) {
        this();
    }

    public void g(hf1 hf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hf1Var) == null) && hf1Var != null) {
            hf1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.hf1
    public boolean b(Context context, jf1 jf1Var, df1 df1Var) {
        InterceptResult invokeLLL;
        hf1 hf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, jf1Var, df1Var)) == null) {
            String b2 = jf1Var.b();
            if (a.get(b2) != null) {
                jf1Var.f(b2, a.get(b2));
            }
            String d = jf1Var.d(true);
            if (TextUtils.isEmpty(d) || (hf1Var = b.get(d)) == null) {
                return false;
            }
            return hf1Var.b(context, jf1Var, df1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hf1
    public boolean c(Context context, jf1 jf1Var, df1 df1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jf1Var, df1Var)) == null) {
            jf1Var.i = mf1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, hf1 hf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hf1Var) == null) && !TextUtils.isEmpty(str) && hf1Var != null) {
            b.put(str, hf1Var);
        }
    }
}
