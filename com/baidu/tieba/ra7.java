package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
/* loaded from: classes7.dex */
public final class ra7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedSocialComponent feedSocialComponent, List<mc7<?>> dataList, s87 feedExtraData, y97 videoSchemaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            s97 s97Var = new s97();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                s97Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                s97Var.f = z;
                s97Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                s97Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                s97Var.i = l2.longValue();
            }
            s97Var.a = feedSocialComponent.share_num.intValue();
            s97Var.b = feedSocialComponent.comment_num.intValue();
            s97Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            s97Var.d = fid.longValue();
            s97Var.l = feedExtraData.a();
            videoSchemaData.h(s97Var.f);
            videoSchemaData.g(s97Var.g);
            String str = s97Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = s97Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            s97Var.j = videoSchemaData;
            dataList.add(new nc7(new x77(s97Var, CollectionsKt__CollectionsKt.listOf((Object[]) new u97[]{t87.b(feedExtraData, "comment_btn_click"), t87.b(feedExtraData, "comment_btn_click2"), t87.b(feedExtraData, "comment_btn_click3")}), null, null, null, 28, null), "social_bar"));
        }
    }
}
