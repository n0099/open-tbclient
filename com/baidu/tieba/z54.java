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
public final class z54 implements jp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public z54() {
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

    @Override // com.baidu.tieba.jp1
    public void a(c02 c02Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c02Var) == null) && c02Var != null) {
            d(c02Var.B("action"), c02Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.jp1
    public void b(ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ce4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ce4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ce4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ce4 ce4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ce4Var, str)) == null) {
            Integer a = a64.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ce4Var != null) {
                    ce4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        s34 s34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                it2 U = it2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                e72 V = U.V();
                ce4 ce4Var = null;
                if (V != null) {
                    s34Var = (s34) V.n(s34.class);
                } else {
                    s34Var = null;
                }
                if (s34Var != null) {
                    ce4Var = s34Var.A3();
                }
                if (ce4Var != null && s34Var != null) {
                    s34Var.M3(true);
                }
                return c(ce4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
