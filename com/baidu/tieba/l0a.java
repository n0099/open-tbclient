package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l0a implements i97.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y97 a;
    public final BdUniqueId b;
    public String c;

    public l0a(y97 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.i97.c
    public void a(u97<?> data, t97<?, ?> template, int i) {
        e97 e97Var;
        Map<String, String> hashMap;
        m57<?> m57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof e97) {
                e97Var = (e97) data;
            } else {
                e97Var = null;
            }
            if (e97Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            l57 l57Var = new l57();
            l57 l57Var2 = e97Var.b;
            if (l57Var2 != null) {
                l57Var = l57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(l57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            s67 s67Var = e97Var.a;
            if (s67Var != null && (a = s67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String b = r9a.b(l57Var.a().get("thread_id"), null, null, null);
            t9a.g().d(this.b, b, statisticItem);
            i28.c(b);
            s67 s67Var2 = e97Var.a;
            if (s67Var2 == null || (hashMap = s67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            l57Var.a().put("position_from_1", String.valueOf(i2));
            if (l57Var.a().containsKey("growth_level")) {
                e1a e1aVar = new e1a();
                aa7.a.a(new c77(e1aVar.getKey(), e1aVar.a(l57Var), hashMap, null, null, 24, null));
            }
            if (l57Var.a().containsKey("recommend_info_business_id")) {
                z0a z0aVar = new z0a();
                aa7.a.a(new c77(z0aVar.getKey(), z0aVar.a(l57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(l57Var.a().get("thread_type"), "0")) {
                o0a o0aVar = new o0a();
                aa7.a.a(new c77(o0aVar.getKey(), o0aVar.a(l57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(l57Var.a().get("is_video_card"), "1")) {
                h1a h1aVar = new h1a();
                aa7.a.a(new c77(h1aVar.getKey(), h1aVar.a(l57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(l57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(l57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", l57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", l57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = l57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(l57Var.a().get("is_live_card"), "1")) {
                t0a t0aVar = new t0a();
                Map<String, String> map = hashMap;
                aa7.a.a(new c77(t0aVar.getKey(), t0aVar.a(l57Var), map, null, null, 24, null));
                r0a r0aVar = new r0a();
                aa7.a.a(new c77(r0aVar.getKey(), r0aVar.a(l57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(l57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                c1a.d(l57Var.a());
            }
            if ((data instanceof t57) && (m57Var = ((t57) data).c) != null) {
                for (u97<? extends Object> u97Var : m57Var.b()) {
                    if (u97Var.b() instanceof e57) {
                        for (l57 l57Var3 : ((e57) u97Var.b()).g()) {
                            if (Intrinsics.areEqual(l57Var3.a().get("rich_text_type"), "tie_plus")) {
                                c1a.c(l57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(l57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                c1a.b(l57Var.a());
            }
        }
    }

    @Override // com.baidu.tieba.i97.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            t9a.g().h(this.b, false);
        }
    }
}
