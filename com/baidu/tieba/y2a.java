package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.v67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class y2a implements v67.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l77 a;
    public final BdUniqueId b;

    public y2a(l77 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.v67.b
    public void a(h77<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            r67 r67Var = (r67) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            v27 v27Var = new v27();
            v27 v27Var2 = r67Var.b;
            if (v27Var2 != null) {
                v27Var = v27Var2;
            }
            if (r67Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(v27Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            c47 c47Var = r67Var.a;
            if (c47Var != null && (a = c47Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            rca.g().c(this.b, statisticItem);
            c47 c47Var2 = r67Var.a;
            if (c47Var2 == null || (hashMap = c47Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            v27Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(v27Var.a().get("is_video_card"), "1")) {
                z3a z3aVar = new z3a();
                n77.a.a(new n47(z3aVar.getKey(), z3aVar.a(v27Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(v27Var.a().get("is_live_card"), "1")) {
                g3a g3aVar = new g3a();
                n77.a.a(new n47(g3aVar.getKey(), g3aVar.a(v27Var), hashMap, null, null, 24, null));
            } else {
                r3a r3aVar = new r3a();
                n77.a.a(new n47(r3aVar.getKey(), r3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
            u3a u3aVar = new u3a();
            n77.a.a(new n47(u3aVar.getKey(), u3aVar.a(v27Var), hashMap, u3aVar.b(), u3aVar.d()));
            if (Intrinsics.areEqual(v27Var.a().get("thread_type"), "74")) {
                m3a m3aVar = new m3a();
                m3aVar.b("0");
                n77.a.a(new n47(m3aVar.getKey(), m3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
        }
    }
}
