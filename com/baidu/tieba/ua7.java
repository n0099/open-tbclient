package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
/* loaded from: classes8.dex */
public final class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedSocialComponent feedSocialComponent, List<pc7<?>> dataList, u87 feedExtraData, aa7 videoSchemaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            u97 u97Var = new u97();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                u97Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                u97Var.f = z;
                u97Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                u97Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                u97Var.i = l2.longValue();
            }
            u97Var.a = feedSocialComponent.share_num.intValue();
            u97Var.b = feedSocialComponent.comment_num.intValue();
            u97Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            u97Var.d = fid.longValue();
            u97Var.l = feedExtraData.a();
            videoSchemaData.h(u97Var.f);
            videoSchemaData.g(u97Var.g);
            String str = u97Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = u97Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            u97Var.j = videoSchemaData;
            dataList.add(new qc7(new z77(u97Var, CollectionsKt__CollectionsKt.listOf((Object[]) new w97[]{v87.b(feedExtraData, "comment_btn_click"), v87.b(feedExtraData, "comment_btn_click2"), v87.b(feedExtraData, "comment_btn_click3")}), null, null, null, 28, null), "social_bar"));
        }
    }
}
