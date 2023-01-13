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
public final class n24 implements xl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public n24() {
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

    @Override // com.baidu.tieba.xl1
    public void a(qw1 qw1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qw1Var) == null) && qw1Var != null) {
            d(qw1Var.B("action"), qw1Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.xl1
    public void b(qa4 qa4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (qa4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                qa4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(qa4 qa4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, qa4Var, str)) == null) {
            Integer a = o24.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (qa4Var != null) {
                    qa4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        g04 g04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                wp2 U = wp2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                s32 V = U.V();
                qa4 qa4Var = null;
                if (V != null) {
                    g04Var = (g04) V.n(g04.class);
                } else {
                    g04Var = null;
                }
                if (g04Var != null) {
                    qa4Var = g04Var.x3();
                }
                if (qa4Var != null && g04Var != null) {
                    g04Var.J3(true);
                }
                return c(qa4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
