package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l6a implements dc7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tc7 a;
    public final BdUniqueId b;
    public String c;

    public l6a(tc7 statStrategy, BdUniqueId pageId) {
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
        this.c = "";
    }

    @Override // com.baidu.tieba.dc7.c
    public void a(pc7<?> data, oc7<?, ?> template, int i) {
        zb7 zb7Var;
        Map<String, String> hashMap;
        g87<?> g87Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof zb7) {
                zb7Var = (zb7) data;
            } else {
                zb7Var = null;
            }
            if (zb7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
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
            String b = sfa.b(f87Var.a().get("thread_id"), null, null, null);
            vfa.g().d(this.b, b, statisticItem);
            p58.c(b);
            m97 m97Var2 = zb7Var.a;
            if (m97Var2 == null || (hashMap = m97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            f87Var.a().put("position_from_1", String.valueOf(i2));
            if (f87Var.a().containsKey("growth_level")) {
                e7a e7aVar = new e7a();
                vc7.a.a(new w97(e7aVar.getKey(), e7aVar.a(f87Var), hashMap, null, null, 24, null));
            }
            if (f87Var.a().containsKey("recommend_info_business_id")) {
                z6a z6aVar = new z6a();
                vc7.a.a(new w97(z6aVar.getKey(), z6aVar.a(f87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(f87Var.a().get("thread_type"), "0")) {
                o6a o6aVar = new o6a();
                vc7.a.a(new w97(o6aVar.getKey(), o6aVar.a(f87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(f87Var.a().get("is_video_card"), "1")) {
                h7a h7aVar = new h7a();
                vc7.a.a(new w97(h7aVar.getKey(), h7aVar.a(f87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(f87Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(f87Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", f87Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", f87Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = f87Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(f87Var.a().get("is_live_card"), "1")) {
                t6a t6aVar = new t6a();
                Map<String, String> map = hashMap;
                vc7.a.a(new w97(t6aVar.getKey(), t6aVar.a(f87Var), map, null, null, 24, null));
                r6a r6aVar = new r6a();
                vc7.a.a(new w97(r6aVar.getKey(), r6aVar.a(f87Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(f87Var.a().get("is_tie_plus_ad_thread"), "1")) {
                c7a.d(f87Var.a());
            }
            if ((data instanceof n87) && (g87Var = ((n87) data).c) != null) {
                for (pc7<? extends Object> pc7Var : g87Var.b()) {
                    if (pc7Var.b() instanceof y77) {
                        for (f87 f87Var3 : ((y77) pc7Var.b()).g()) {
                            if (Intrinsics.areEqual(f87Var3.a().get("rich_text_type"), "tie_plus")) {
                                c7a.c(f87Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(f87Var.a().get("has_du_xin_xuan_reply"), "1")) {
                c7a.b(f87Var.a());
            }
        }
    }

    @Override // com.baidu.tieba.dc7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            vfa.g().h(this.b, false);
        }
    }
}
