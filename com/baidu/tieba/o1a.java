package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ac7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o1a implements ac7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qc7 a;
    public final BdUniqueId b;

    public o1a(qc7 statStrategy, BdUniqueId pageId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {statStrategy, pageId};
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
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.a = statStrategy;
        this.b = pageId;
    }

    @Override // com.baidu.tieba.ac7.b
    public void a(mc7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            wb7 wb7Var = (wb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
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
            aba.g().c(this.b, statisticItem);
            k97 k97Var2 = wb7Var.a;
            if (k97Var2 == null || (hashMap = k97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            d87Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(d87Var.a().get("is_video_card"), "1")) {
                m2a m2aVar = new m2a();
                sc7.a.a(new u97(m2aVar.getKey(), m2aVar.a(d87Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(d87Var.a().get("is_live_card"), "1")) {
                v1a v1aVar = new v1a();
                sc7.a.a(new u97(v1aVar.getKey(), v1aVar.a(d87Var), hashMap, null, null, 24, null));
            } else {
                e2a e2aVar = new e2a();
                sc7.a.a(new u97(e2aVar.getKey(), e2aVar.a(d87Var), hashMap, null, null, 24, null));
            }
            h2a h2aVar = new h2a();
            sc7.a.a(new u97(h2aVar.getKey(), h2aVar.a(d87Var), hashMap, h2aVar.b(), h2aVar.d()));
        }
    }
}
