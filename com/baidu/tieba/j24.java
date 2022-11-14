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
/* loaded from: classes4.dex */
public final class j24 implements tl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public j24() {
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

    @Override // com.baidu.tieba.tl1
    public void a(mw1 mw1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, mw1Var) == null) && mw1Var != null) {
            d(mw1Var.B("action"), mw1Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.tl1
    public void b(ma4 ma4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ma4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ma4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ma4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ma4 ma4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ma4Var, str)) == null) {
            Integer a = k24.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ma4Var != null) {
                    ma4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        c04 c04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                sp2 U = sp2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                o32 V = U.V();
                ma4 ma4Var = null;
                if (V != null) {
                    c04Var = (c04) V.n(c04.class);
                } else {
                    c04Var = null;
                }
                if (c04Var != null) {
                    ma4Var = c04Var.x3();
                }
                if (ma4Var != null && c04Var != null) {
                    c04Var.J3(true);
                }
                return c(ma4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
