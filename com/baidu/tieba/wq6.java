package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wq6 extends qq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<Integer> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wq6() {
        super(8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new LinkedHashSet();
    }

    @Override // com.baidu.tieba.qq6
    public boolean b(zp6 item, cs6 timer, tp6 config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, timer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(timer, "timer");
            Intrinsics.checkNotNullParameter(config, "config");
            aq6 e = item.e();
            if ((!this.b.isEmpty()) && !this.b.contains(Integer.valueOf(c(e)))) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final int c(aq6 aq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aq6Var)) == null) {
            return aq6Var.n() & 16777215;
        }
        return invokeL.intValue;
    }
}
