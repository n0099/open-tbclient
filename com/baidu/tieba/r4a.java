package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
public final class r4a implements xa7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nb7 a;
    public final BdUniqueId b;
    public String c;

    public r4a(nb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.xa7.c
    public void a(jb7<?> data, ib7<?, ?> template, int i) {
        ta7 ta7Var;
        Map<String, String> hashMap;
        b77<?> b77Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ta7) {
                ta7Var = (ta7) data;
            } else {
                ta7Var = null;
            }
            if (ta7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            a77 a77Var = new a77();
            a77 a77Var2 = ta7Var.b;
            if (a77Var2 != null) {
                a77Var = a77Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(a77Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            h87 h87Var = ta7Var.a;
            if (h87Var != null && (a = h87Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String b = zda.b(a77Var.a().get("thread_id"), null, null, null);
            cea.g().d(this.b, b, statisticItem);
            e48.c(b);
            h87 h87Var2 = ta7Var.a;
            if (h87Var2 == null || (hashMap = h87Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            a77Var.a().put("position_from_1", String.valueOf(i2));
            if (a77Var.a().containsKey("growth_level")) {
                k5a k5aVar = new k5a();
                pb7.a.a(new r87(k5aVar.getKey(), k5aVar.a(a77Var), hashMap, null, null, 24, null));
            }
            if (a77Var.a().containsKey("recommend_info_business_id")) {
                f5a f5aVar = new f5a();
                pb7.a.a(new r87(f5aVar.getKey(), f5aVar.a(a77Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(a77Var.a().get("thread_type"), "0")) {
                u4a u4aVar = new u4a();
                pb7.a.a(new r87(u4aVar.getKey(), u4aVar.a(a77Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(a77Var.a().get("is_video_card"), "1")) {
                n5a n5aVar = new n5a();
                pb7.a.a(new r87(n5aVar.getKey(), n5aVar.a(a77Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(a77Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(a77Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", a77Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", a77Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = a77Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(a77Var.a().get("is_live_card"), "1")) {
                z4a z4aVar = new z4a();
                Map<String, String> map = hashMap;
                pb7.a.a(new r87(z4aVar.getKey(), z4aVar.a(a77Var), map, null, null, 24, null));
                x4a x4aVar = new x4a();
                pb7.a.a(new r87(x4aVar.getKey(), x4aVar.a(a77Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(a77Var.a().get("is_tie_plus_ad_thread"), "1")) {
                i5a.d(a77Var.a());
            }
            if ((data instanceof i77) && (b77Var = ((i77) data).c) != null) {
                for (jb7<? extends Object> jb7Var : b77Var.b()) {
                    if (jb7Var.b() instanceof t67) {
                        for (a77 a77Var3 : ((t67) jb7Var.b()).g()) {
                            if (Intrinsics.areEqual(a77Var3.a().get("rich_text_type"), "tie_plus")) {
                                i5a.c(a77Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(a77Var.a().get("has_du_xin_xuan_reply"), "1")) {
                i5a.b(a77Var.a());
            }
        }
    }

    @Override // com.baidu.tieba.xa7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            cea.g().h(this.b, false);
        }
    }
}
