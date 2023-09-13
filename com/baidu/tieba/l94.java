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
/* loaded from: classes6.dex */
public final class l94 implements vs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public l94() {
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
        this.a = new ArrayList<>();
    }

    @Override // com.baidu.tieba.vs1
    public void a(o32 o32Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, o32Var) == null) && o32Var != null) {
            d(o32Var.B("action"), o32Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.vs1
    public void b(oh4 oh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oh4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (oh4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                oh4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(oh4 oh4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, oh4Var, str)) == null) {
            Integer a = m94.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (oh4Var != null) {
                    oh4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                uw2 T2 = uw2.T();
                Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
                qa2 U = T2.U();
                oh4 oh4Var = null;
                if (U != null) {
                    e74Var = (e74) U.n(e74.class);
                } else {
                    e74Var = null;
                }
                if (e74Var != null) {
                    oh4Var = e74Var.z3();
                }
                if (oh4Var != null && e74Var != null) {
                    e74Var.L3(true);
                }
                return c(oh4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
