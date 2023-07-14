package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.ac7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class uc7 implements ac7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qc7 a;

    public uc7(qc7 statStrategy) {
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

    @Override // com.baidu.tieba.ac7.c
    public void a(mc7<?> data, lc7<?, ?> template, int i) {
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            wb7 wb7Var = (wb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            d87 d87Var = new d87();
            d87 d87Var2 = wb7Var.b;
            if (d87Var2 != null) {
                d87Var = d87Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(d87Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            k97 k97Var = wb7Var.a;
            if (k97Var != null && (a = k97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            np6.b().a(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ac7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            np6.b().c();
        }
    }
}
