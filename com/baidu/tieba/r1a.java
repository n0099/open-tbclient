package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
public final class r1a implements ac7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qc7 a;
    public final BdUniqueId b;
    public String c;

    public r1a(qc7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.ac7.c
    public void a(mc7<?> data, lc7<?, ?> template, int i) {
        wb7 wb7Var;
        Map<String, String> hashMap;
        e87<?> e87Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof wb7) {
                wb7Var = (wb7) data;
            } else {
                wb7Var = null;
            }
            if (wb7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            d87 d87Var = new d87();
            d87 d87Var2 = wb7Var.b;
            if (d87Var2 != null) {
                d87Var = d87Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(d87Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            k97 k97Var = wb7Var.a;
            if (k97Var != null && (a = k97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String b = yaa.b(d87Var.a().get("thread_id"), null, null, null);
            aba.g().d(this.b, b, statisticItem);
            v48.c(b);
            k97 k97Var2 = wb7Var.a;
            if (k97Var2 == null || (hashMap = k97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            d87Var.a().put("position_from_1", String.valueOf(i2));
            if (d87Var.a().containsKey("growth_level")) {
                k2a k2aVar = new k2a();
                sc7.a.a(new u97(k2aVar.getKey(), k2aVar.a(d87Var), hashMap, null, null, 24, null));
            }
            if (d87Var.a().containsKey("recommend_info_business_id")) {
                f2a f2aVar = new f2a();
                sc7.a.a(new u97(f2aVar.getKey(), f2aVar.a(d87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d87Var.a().get("thread_type"), "0")) {
                u1a u1aVar = new u1a();
                sc7.a.a(new u97(u1aVar.getKey(), u1aVar.a(d87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d87Var.a().get("is_video_card"), "1")) {
                n2a n2aVar = new n2a();
                sc7.a.a(new u97(n2aVar.getKey(), n2aVar.a(d87Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d87Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(d87Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", d87Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", d87Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = d87Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(d87Var.a().get("is_live_card"), "1")) {
                z1a z1aVar = new z1a();
                Map<String, String> map = hashMap;
                sc7.a.a(new u97(z1aVar.getKey(), z1aVar.a(d87Var), map, null, null, 24, null));
                x1a x1aVar = new x1a();
                sc7.a.a(new u97(x1aVar.getKey(), x1aVar.a(d87Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d87Var.a().get("is_tie_plus_ad_thread"), "1")) {
                i2a.d(d87Var.a());
            }
            if ((data instanceof l87) && (e87Var = ((l87) data).c) != null) {
                for (mc7<? extends Object> mc7Var : e87Var.b()) {
                    if (mc7Var.b() instanceof w77) {
                        for (d87 d87Var3 : ((w77) mc7Var.b()).g()) {
                            if (Intrinsics.areEqual(d87Var3.a().get("rich_text_type"), "tie_plus")) {
                                i2a.c(d87Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(d87Var.a().get("has_du_xin_xuan_reply"), "1")) {
                i2a.b(d87Var.a());
            }
        }
    }

    @Override // com.baidu.tieba.ac7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            aba.g().h(this.b, false);
        }
    }
}
