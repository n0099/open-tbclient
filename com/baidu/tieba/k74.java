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
public final class k74 implements uq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public k74() {
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

    @Override // com.baidu.tieba.uq1
    public void a(n12 n12Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, n12Var) == null) && n12Var != null) {
            d(n12Var.B("action"), n12Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.uq1
    public void b(nf4 nf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nf4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nf4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                nf4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(nf4 nf4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nf4Var, str)) == null) {
            Integer a = l74.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (nf4Var != null) {
                    nf4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        d54 d54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                tu2 U = tu2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                p82 V = U.V();
                nf4 nf4Var = null;
                if (V != null) {
                    d54Var = (d54) V.n(d54.class);
                } else {
                    d54Var = null;
                }
                if (d54Var != null) {
                    nf4Var = d54Var.A3();
                }
                if (nf4Var != null && d54Var != null) {
                    d54Var.M3(true);
                }
                return c(nf4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
