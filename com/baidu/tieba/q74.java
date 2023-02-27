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
public final class q74 implements ar1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public q74() {
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

    @Override // com.baidu.tieba.ar1
    public void a(t12 t12Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t12Var) == null) && t12Var != null) {
            d(t12Var.B("action"), t12Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.ar1
    public void b(tf4 tf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (tf4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                tf4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(tf4 tf4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tf4Var, str)) == null) {
            Integer a = r74.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (tf4Var != null) {
                    tf4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        j54 j54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                zu2 U = zu2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                v82 V = U.V();
                tf4 tf4Var = null;
                if (V != null) {
                    j54Var = (j54) V.n(j54.class);
                } else {
                    j54Var = null;
                }
                if (j54Var != null) {
                    tf4Var = j54Var.x3();
                }
                if (tf4Var != null && j54Var != null) {
                    j54Var.J3(true);
                }
                return c(tf4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
