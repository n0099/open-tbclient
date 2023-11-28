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
public final class l44 implements wn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public l44() {
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

    @Override // com.baidu.tieba.wn1
    public void a(py1 py1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, py1Var) == null) && py1Var != null) {
            d(py1Var.C("action"), py1Var.C("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.wn1
    public void b(oc4 oc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oc4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (oc4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                oc4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(oc4 oc4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, oc4Var, str)) == null) {
            Integer a = m44.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (oc4Var != null) {
                    oc4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        e24 e24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                ur2 V = ur2.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                q52 W = V.W();
                oc4 oc4Var = null;
                if (W != null) {
                    e24Var = (e24) W.n(e24.class);
                } else {
                    e24Var = null;
                }
                if (e24Var != null) {
                    oc4Var = e24Var.E3();
                }
                if (oc4Var != null && e24Var != null) {
                    e24Var.Q3(true);
                }
                return c(oc4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
