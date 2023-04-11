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
public final class y54 implements ip1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public y54() {
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

    @Override // com.baidu.tieba.ip1
    public void a(b02 b02Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, b02Var) == null) && b02Var != null) {
            d(b02Var.B("action"), b02Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.ip1
    public void b(be4 be4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, be4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (be4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                be4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(be4 be4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, be4Var, str)) == null) {
            Integer a = z54.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (be4Var != null) {
                    be4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        r34 r34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                ht2 U = ht2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                d72 V = U.V();
                be4 be4Var = null;
                if (V != null) {
                    r34Var = (r34) V.n(r34.class);
                } else {
                    r34Var = null;
                }
                if (r34Var != null) {
                    be4Var = r34Var.A3();
                }
                if (be4Var != null && r34Var != null) {
                    r34Var.M3(true);
                }
                return c(be4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
