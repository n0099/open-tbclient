package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.xa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o4a implements xa7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nb7 a;
    public final BdUniqueId b;

    public o4a(nb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.xa7.b
    public void a(jb7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ta7 ta7Var = (ta7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
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
            cea.g().c(this.b, statisticItem);
            h87 h87Var2 = ta7Var.a;
            if (h87Var2 == null || (hashMap = h87Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            a77Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(a77Var.a().get("is_video_card"), "1")) {
                m5a m5aVar = new m5a();
                pb7.a.a(new r87(m5aVar.getKey(), m5aVar.a(a77Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(a77Var.a().get("is_live_card"), "1")) {
                v4a v4aVar = new v4a();
                pb7.a.a(new r87(v4aVar.getKey(), v4aVar.a(a77Var), hashMap, null, null, 24, null));
            } else {
                e5a e5aVar = new e5a();
                pb7.a.a(new r87(e5aVar.getKey(), e5aVar.a(a77Var), hashMap, null, null, 24, null));
            }
            h5a h5aVar = new h5a();
            pb7.a.a(new r87(h5aVar.getKey(), h5aVar.a(a77Var), hashMap, h5aVar.b(), h5aVar.d()));
        }
    }
}
