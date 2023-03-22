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
/* loaded from: classes6.dex */
public final class x54 implements hp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public x54() {
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

    @Override // com.baidu.tieba.hp1
    public void a(a02 a02Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, a02Var) == null) && a02Var != null) {
            d(a02Var.B("action"), a02Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.hp1
    public void b(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ae4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ae4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ae4 ae4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ae4Var, str)) == null) {
            Integer a = y54.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ae4Var != null) {
                    ae4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        q34 q34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                gt2 U = gt2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                c72 V = U.V();
                ae4 ae4Var = null;
                if (V != null) {
                    q34Var = (q34) V.n(q34.class);
                } else {
                    q34Var = null;
                }
                if (q34Var != null) {
                    ae4Var = q34Var.A3();
                }
                if (ae4Var != null && q34Var != null) {
                    q34Var.M3(true);
                }
                return c(ae4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
