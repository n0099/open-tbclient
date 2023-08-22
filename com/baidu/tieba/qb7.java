package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.xa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qb7 implements xa7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nb7 a;

    public qb7(nb7 statStrategy) {
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

    @Override // com.baidu.tieba.xa7.b
    public void a(jb7<?> data, int i) {
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ta7 ta7Var = (ta7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            a77 a77Var = new a77();
            a77 a77Var2 = ta7Var.b;
            if (a77Var2 != null) {
                a77Var = a77Var2;
            }
            if (ta7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(a77Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            h87 h87Var = ta7Var.a;
            if (h87Var != null && (a = h87Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
