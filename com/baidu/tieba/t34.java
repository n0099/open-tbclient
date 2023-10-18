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
public final class t34 implements en1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public t34() {
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

    @Override // com.baidu.tieba.en1
    public void a(xx1 xx1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, xx1Var) == null) && xx1Var != null) {
            d(xx1Var.C("action"), xx1Var.C("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.en1
    public void b(wb4 wb4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wb4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (wb4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                wb4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(wb4 wb4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wb4Var, str)) == null) {
            Integer a = u34.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (wb4Var != null) {
                    wb4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        m14 m14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                cr2 V = cr2.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                y42 W = V.W();
                wb4 wb4Var = null;
                if (W != null) {
                    m14Var = (m14) W.n(m14.class);
                } else {
                    m14Var = null;
                }
                if (m14Var != null) {
                    wb4Var = m14Var.E3();
                }
                if (wb4Var != null && m14Var != null) {
                    m14Var.Q3(true);
                }
                return c(wb4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
