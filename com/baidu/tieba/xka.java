package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.bb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xka implements bb7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ub7 a;
    public final BdUniqueId b;

    public xka(ub7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.bb7.b
    public void a(nb7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            xa7 xa7Var = (xa7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            r57 r57Var = new r57();
            r57 r57Var2 = xa7Var.b;
            if (r57Var2 != null) {
                r57Var = r57Var2;
            }
            if (xa7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(r57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            j77 j77Var = xa7Var.a;
            if (j77Var != null && (a = j77Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            qua.g().c(this.b, statisticItem);
            j77 j77Var2 = xa7Var.a;
            if (j77Var2 == null || (hashMap = j77Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            r57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(r57Var.a().get("is_video_card"), "1")) {
                yla ylaVar = new yla();
                wb7.a.b(new a87(ylaVar.getKey(), ylaVar.a(r57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(r57Var.a().get("is_live_card"), "1")) {
                fla flaVar = new fla();
                wb7.a.b(new a87(flaVar.getKey(), flaVar.a(r57Var), hashMap, null, null, 24, null));
            } else {
                qla qlaVar = new qla();
                wb7.a.b(new a87(qlaVar.getKey(), qlaVar.a(r57Var), hashMap, null, null, 24, null));
            }
            tla tlaVar = new tla();
            wb7.a.b(new a87(tlaVar.getKey(), tlaVar.a(r57Var), hashMap, tlaVar.b(), tlaVar.d()));
            if (Intrinsics.areEqual(r57Var.a().get("thread_type"), "74")) {
                lla llaVar = new lla();
                llaVar.b("0");
                wb7.a.b(new a87(llaVar.getKey(), llaVar.a(r57Var), hashMap, null, null, 24, null));
            }
        }
    }
}
