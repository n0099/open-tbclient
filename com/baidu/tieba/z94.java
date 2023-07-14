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
/* loaded from: classes8.dex */
public final class z94 implements jt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public z94() {
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

    @Override // com.baidu.tieba.jt1
    public void a(c42 c42Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c42Var) == null) && c42Var != null) {
            d(c42Var.B("action"), c42Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.jt1
    public void b(ci4 ci4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ci4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ci4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ci4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ci4 ci4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ci4Var, str)) == null) {
            Integer a = aa4.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ci4Var != null) {
                    ci4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        s74 s74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                ix2 T2 = ix2.T();
                Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
                eb2 U = T2.U();
                ci4 ci4Var = null;
                if (U != null) {
                    s74Var = (s74) U.n(s74.class);
                } else {
                    s74Var = null;
                }
                if (s74Var != null) {
                    ci4Var = s74Var.z3();
                }
                if (ci4Var != null && s74Var != null) {
                    s74Var.L3(true);
                }
                return c(ci4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
