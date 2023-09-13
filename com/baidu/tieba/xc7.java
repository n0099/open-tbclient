package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.dc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xc7 implements dc7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tc7 a;

    public xc7(tc7 statStrategy) {
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

    @Override // com.baidu.tieba.dc7.c
    public void a(pc7<?> data, oc7<?, ?> template, int i) {
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            zb7 zb7Var = (zb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            f87 f87Var = new f87();
            f87 f87Var2 = zb7Var.b;
            if (f87Var2 != null) {
                f87Var = f87Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(f87Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            m97 m97Var = zb7Var.a;
            if (m97Var != null && (a = m97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            ep6.b().a(statisticItem);
        }
    }

    @Override // com.baidu.tieba.dc7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            ep6.b().c();
        }
    }
}
