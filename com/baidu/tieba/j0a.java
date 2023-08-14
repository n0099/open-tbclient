package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.j97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j0a implements j97.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z97 a;
    public final BdUniqueId b;

    public j0a(z97 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.j97.b
    public void a(v97<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            f97 f97Var = (f97) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            m57 m57Var = new m57();
            m57 m57Var2 = f97Var.b;
            if (m57Var2 != null) {
                m57Var = m57Var2;
            }
            if (f97Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(m57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            t67 t67Var = f97Var.a;
            if (t67Var != null && (a = t67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            u9a.g().c(this.b, statisticItem);
            t67 t67Var2 = f97Var.a;
            if (t67Var2 == null || (hashMap = t67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            m57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(m57Var.a().get("is_video_card"), "1")) {
                h1a h1aVar = new h1a();
                ba7.a.a(new d77(h1aVar.getKey(), h1aVar.a(m57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(m57Var.a().get("is_live_card"), "1")) {
                q0a q0aVar = new q0a();
                ba7.a.a(new d77(q0aVar.getKey(), q0aVar.a(m57Var), hashMap, null, null, 24, null));
            } else {
                z0a z0aVar = new z0a();
                ba7.a.a(new d77(z0aVar.getKey(), z0aVar.a(m57Var), hashMap, null, null, 24, null));
            }
            c1a c1aVar = new c1a();
            ba7.a.a(new d77(c1aVar.getKey(), c1aVar.a(m57Var), hashMap, c1aVar.b(), c1aVar.d()));
        }
    }
}
