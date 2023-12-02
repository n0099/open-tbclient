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
public final class o44 implements zn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public o44() {
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

    @Override // com.baidu.tieba.zn1
    public void a(sy1 sy1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sy1Var) == null) && sy1Var != null) {
            d(sy1Var.C("action"), sy1Var.C("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.zn1
    public void b(rc4 rc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rc4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (rc4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                rc4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(rc4 rc4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rc4Var, str)) == null) {
            Integer a = p44.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (rc4Var != null) {
                    rc4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        h24 h24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                xr2 V = xr2.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                t52 W = V.W();
                rc4 rc4Var = null;
                if (W != null) {
                    h24Var = (h24) W.n(h24.class);
                } else {
                    h24Var = null;
                }
                if (h24Var != null) {
                    rc4Var = h24Var.E3();
                }
                if (rc4Var != null && h24Var != null) {
                    h24Var.Q3(true);
                }
                return c(rc4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
