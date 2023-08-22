package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
/* loaded from: classes7.dex */
public final class o97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedSocialComponent feedSocialComponent, List<jb7<?>> dataList, p77 feedExtraData, v87 videoSchemaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            p87 p87Var = new p87();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                p87Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                p87Var.f = z;
                p87Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                p87Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                p87Var.i = l2.longValue();
            }
            p87Var.a = feedSocialComponent.share_num.intValue();
            p87Var.b = feedSocialComponent.comment_num.intValue();
            p87Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            p87Var.d = fid.longValue();
            p87Var.l = feedExtraData.a();
            videoSchemaData.h(p87Var.f);
            videoSchemaData.g(p87Var.g);
            String str = p87Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = p87Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            p87Var.j = videoSchemaData;
            dataList.add(new kb7(new u67(p87Var, CollectionsKt__CollectionsKt.listOf((Object[]) new r87[]{q77.b(feedExtraData, "comment_btn_click"), q77.b(feedExtraData, "comment_btn_click2"), q77.b(feedExtraData, "comment_btn_click3")}), null, null, null, 28, null), "social_bar"));
        }
    }
}
