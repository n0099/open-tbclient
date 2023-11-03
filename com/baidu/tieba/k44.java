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
/* loaded from: classes7.dex */
public final class k44 implements vn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public k44() {
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

    @Override // com.baidu.tieba.vn1
    public void a(oy1 oy1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, oy1Var) == null) && oy1Var != null) {
            d(oy1Var.C("action"), oy1Var.C("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.vn1
    public void b(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nc4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nc4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                nc4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(nc4 nc4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nc4Var, str)) == null) {
            Integer a = l44.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (nc4Var != null) {
                    nc4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        d24 d24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                tr2 V = tr2.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                p52 W = V.W();
                nc4 nc4Var = null;
                if (W != null) {
                    d24Var = (d24) W.n(d24.class);
                } else {
                    d24Var = null;
                }
                if (d24Var != null) {
                    nc4Var = d24Var.E3();
                }
                if (nc4Var != null && d24Var != null) {
                    d24Var.Q3(true);
                }
                return c(nc4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
