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
public final class p14 implements zk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public p14() {
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

    @Override // com.baidu.tieba.zk1
    public void a(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sv1Var) == null) || sv1Var == null) {
            return;
        }
        d(sv1Var.B("action"), sv1Var.B("menuItemName"));
    }

    @Override // com.baidu.tieba.zk1
    public void b(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s94Var) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (s94Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                s94Var.l(id.intValue());
            }
        }
    }

    public final boolean c(s94 s94Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s94Var, str)) == null) {
            Integer a = q14.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (s94Var != null) {
                    s94Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                yo2 U = yo2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                u22 V = U.V();
                iz3 iz3Var = V != null ? (iz3) V.n(iz3.class) : null;
                s94 x3 = iz3Var != null ? iz3Var.x3() : null;
                if (x3 != null && iz3Var != null) {
                    iz3Var.J3(true);
                }
                return c(x3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
