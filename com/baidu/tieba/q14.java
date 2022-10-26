package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class q14 implements al1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList a;

    public q14() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    @Override // com.baidu.tieba.al1
    public void a(tv1 tv1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tv1Var) == null) && tv1Var != null) {
            d(tv1Var.B("action"), tv1Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.al1
    public void b(t94 t94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t94Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = (Integer) it.next();
            if (t94Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                t94Var.l(id.intValue());
            }
        }
    }

    public final boolean c(t94 t94Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t94Var, str)) == null) {
            Integer a = r14.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (t94Var != null) {
                    t94Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        jz3 jz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                zo2 U = zo2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                v22 V = U.V();
                t94 t94Var = null;
                if (V != null) {
                    jz3Var = (jz3) V.n(jz3.class);
                } else {
                    jz3Var = null;
                }
                if (jz3Var != null) {
                    t94Var = jz3Var.x3();
                }
                if (t94Var != null && jz3Var != null) {
                    jz3Var.J3(true);
                }
                return c(t94Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
