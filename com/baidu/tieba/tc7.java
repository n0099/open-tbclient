package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ac7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tc7 implements ac7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qc7 a;

    public tc7(qc7 statStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {statStrategy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(statStrategy, "statStrategy");
        this.a = statStrategy;
    }

    @Override // com.baidu.tieba.ac7.b
    public void a(mc7<?> data, int i) {
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            wb7 wb7Var = (wb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            d87 d87Var = new d87();
            d87 d87Var2 = wb7Var.b;
            if (d87Var2 != null) {
                d87Var = d87Var2;
            }
            if (wb7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(d87Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            k97 k97Var = wb7Var.a;
            if (k97Var != null && (a = k97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
