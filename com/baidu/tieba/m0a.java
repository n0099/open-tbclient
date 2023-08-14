package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
public final class m0a implements j97.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z97 a;
    public final BdUniqueId b;
    public String c;

    public m0a(z97 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.j97.c
    public void a(v97<?> data, u97<?, ?> template, int i) {
        f97 f97Var;
        Map<String, String> hashMap;
        n57<?> n57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof f97) {
                f97Var = (f97) data;
            } else {
                f97Var = null;
            }
            if (f97Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            m57 m57Var = new m57();
            m57 m57Var2 = f97Var.b;
            if (m57Var2 != null) {
                m57Var = m57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(m57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            t67 t67Var = f97Var.a;
            if (t67Var != null && (a = t67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String b = s9a.b(m57Var.a().get("thread_id"), null, null, null);
            u9a.g().d(this.b, b, statisticItem);
            j28.c(b);
            t67 t67Var2 = f97Var.a;
            if (t67Var2 == null || (hashMap = t67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            m57Var.a().put("position_from_1", String.valueOf(i2));
            if (m57Var.a().containsKey("growth_level")) {
                f1a f1aVar = new f1a();
                ba7.a.a(new d77(f1aVar.getKey(), f1aVar.a(m57Var), hashMap, null, null, 24, null));
            }
            if (m57Var.a().containsKey("recommend_info_business_id")) {
                a1a a1aVar = new a1a();
                ba7.a.a(new d77(a1aVar.getKey(), a1aVar.a(m57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m57Var.a().get("thread_type"), "0")) {
                p0a p0aVar = new p0a();
                ba7.a.a(new d77(p0aVar.getKey(), p0aVar.a(m57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m57Var.a().get("is_video_card"), "1")) {
                i1a i1aVar = new i1a();
                ba7.a.a(new d77(i1aVar.getKey(), i1aVar.a(m57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(m57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", m57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", m57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = m57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(m57Var.a().get("is_live_card"), "1")) {
                u0a u0aVar = new u0a();
                Map<String, String> map = hashMap;
                ba7.a.a(new d77(u0aVar.getKey(), u0aVar.a(m57Var), map, null, null, 24, null));
                s0a s0aVar = new s0a();
                ba7.a.a(new d77(s0aVar.getKey(), s0aVar.a(m57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                d1a.d(m57Var.a());
            }
            if ((data instanceof u57) && (n57Var = ((u57) data).c) != null) {
                for (v97<? extends Object> v97Var : n57Var.b()) {
                    if (v97Var.b() instanceof f57) {
                        for (m57 m57Var3 : ((f57) v97Var.b()).g()) {
                            if (Intrinsics.areEqual(m57Var3.a().get("rich_text_type"), "tie_plus")) {
                                d1a.c(m57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(m57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                d1a.b(m57Var.a());
            }
        }
    }

    @Override // com.baidu.tieba.j97.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            u9a.g().h(this.b, false);
        }
    }
}
