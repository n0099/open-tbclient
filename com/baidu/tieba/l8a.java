package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l8a implements mc7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cd7 a;
    public final BdUniqueId b;

    public l8a(cd7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.mc7.b
    public void a(yc7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ic7 ic7Var = (ic7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            m87 m87Var = new m87();
            m87 m87Var2 = ic7Var.b;
            if (m87Var2 != null) {
                m87Var = m87Var2;
            }
            if (ic7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(m87Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            t97 t97Var = ic7Var.a;
            if (t97Var != null && (a = t97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            bia.g().c(this.b, statisticItem);
            t97 t97Var2 = ic7Var.a;
            if (t97Var2 == null || (hashMap = t97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            m87Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(m87Var.a().get("is_video_card"), "1")) {
                m9a m9aVar = new m9a();
                ed7.a.a(new ea7(m9aVar.getKey(), m9aVar.a(m87Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(m87Var.a().get("is_live_card"), "1")) {
                t8a t8aVar = new t8a();
                ed7.a.a(new ea7(t8aVar.getKey(), t8aVar.a(m87Var), hashMap, null, null, 24, null));
            } else {
                e9a e9aVar = new e9a();
                ed7.a.a(new ea7(e9aVar.getKey(), e9aVar.a(m87Var), hashMap, null, null, 24, null));
            }
            h9a h9aVar = new h9a();
            ed7.a.a(new ea7(h9aVar.getKey(), h9aVar.a(m87Var), hashMap, h9aVar.b(), h9aVar.d()));
            if (Intrinsics.areEqual(m87Var.a().get("thread_type"), "74")) {
                z8a z8aVar = new z8a();
                z8aVar.b("0");
                ed7.a.a(new ea7(z8aVar.getKey(), z8aVar.a(m87Var), hashMap, null, null, 24, null));
            }
        }
    }
}
