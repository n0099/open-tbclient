package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
/* loaded from: classes7.dex */
public final class o8a implements mc7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cd7 a;
    public final BdUniqueId b;
    public String c;

    public o8a(cd7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.mc7.c
    public void a(yc7<?> data, xc7<?, ?> template, int i) {
        ic7 ic7Var;
        Map<String, String> hashMap;
        n87<?> n87Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ic7) {
                ic7Var = (ic7) data;
            } else {
                ic7Var = null;
            }
            if (ic7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            m87 m87Var = new m87();
            m87 m87Var2 = ic7Var.b;
            if (m87Var2 != null) {
                m87Var = m87Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(m87Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            t97 t97Var = ic7Var.a;
            if (t97Var != null && (a = t97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = yha.d(m87Var.a().get("thread_id"), null, null, null);
            bia.g().d(this.b, d, statisticItem);
            r58.c(d);
            t97 t97Var2 = ic7Var.a;
            if (t97Var2 == null || (hashMap = t97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            m87Var.a().put("position_from_1", String.valueOf(i2));
            if (m87Var.a().containsKey("growth_level")) {
                k9a k9aVar = new k9a();
                ed7.a.a(new ea7(k9aVar.getKey(), k9aVar.a(m87Var), hashMap, null, null, 24, null));
            }
            if (m87Var.a().containsKey("recommend_info_business_id")) {
                f9a f9aVar = new f9a();
                ed7.a.a(new ea7(f9aVar.getKey(), f9aVar.a(m87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m87Var.a().get("thread_type"), "0")) {
                s8a s8aVar = new s8a();
                ed7.a.a(new ea7(s8aVar.getKey(), s8aVar.a(m87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m87Var.a().get("is_video_card"), "1")) {
                n9a n9aVar = new n9a();
                ed7.a.a(new ea7(n9aVar.getKey(), n9aVar.a(m87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m87Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(m87Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", m87Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", m87Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = m87Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(m87Var.a().get("is_live_card"), "1")) {
                x8a x8aVar = new x8a();
                Map<String, String> map = hashMap;
                ed7.a.a(new ea7(x8aVar.getKey(), x8aVar.a(m87Var), map, null, null, 24, null));
                v8a v8aVar = new v8a();
                ed7.a.a(new ea7(v8aVar.getKey(), v8aVar.a(m87Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(m87Var.a().get("is_tie_plus_ad_thread"), "1")) {
                i9a.d(m87Var.a());
            }
            if ((data instanceof u87) && (n87Var = ((u87) data).c) != null) {
                for (yc7<? extends Object> yc7Var : n87Var.b()) {
                    if (yc7Var.b() instanceof f87) {
                        for (m87 m87Var3 : ((f87) yc7Var.b()).g()) {
                            if (Intrinsics.areEqual(m87Var3.a().get("rich_text_type"), "tie_plus")) {
                                i9a.c(m87Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(m87Var.a().get("has_du_xin_xuan_reply"), "1")) {
                i9a.b(m87Var.a());
            }
            if (Intrinsics.areEqual(m87Var.a().get("thread_type"), "74")) {
                a9a a9aVar = new a9a();
                ed7.a.a(new ea7(a9aVar.getKey(), a9aVar.a(m87Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.mc7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            bia.g().h(this.b, false);
        }
    }
}
