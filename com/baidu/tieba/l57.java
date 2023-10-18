package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
/* loaded from: classes7.dex */
public final class l57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedSocialComponent feedSocialComponent, List<h77<?>> dataList, k37 feedExtraData, r47 videoSchemaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            l47 l47Var = new l47();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                l47Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                l47Var.f = z;
                l47Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                l47Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                l47Var.i = l2.longValue();
            }
            l47Var.a = feedSocialComponent.share_num.intValue();
            l47Var.b = feedSocialComponent.comment_num.intValue();
            l47Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            l47Var.d = fid.longValue();
            l47Var.l = feedExtraData.a();
            videoSchemaData.h(l47Var.f);
            videoSchemaData.g(l47Var.g);
            String str = l47Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = l47Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            l47Var.j = videoSchemaData;
            List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new n47[]{l37.d(feedExtraData, "comment_btn_click", null, 2, null), l37.d(feedExtraData, "comment_btn_click2", null, 2, null), l37.d(feedExtraData, "comment_btn_click3", null, 2, null), l37.d(feedExtraData, "bottom_comment_click_selector1", null, 2, null)});
            List listOf2 = CollectionsKt__CollectionsJVMKt.listOf(l37.d(feedExtraData, "bottom_share_click_selector1", null, 2, null));
            List listOf3 = CollectionsKt__CollectionsJVMKt.listOf(l37.d(feedExtraData, "bottom_agree_click_selector1", null, 2, null));
            p27 p27Var = new p27(l47Var, null, null, null, null, null, null, 126, null);
            p27Var.o(CollectionsKt___CollectionsKt.plus((Collection) p27Var.h(), (Iterable) listOf));
            p27Var.q(CollectionsKt___CollectionsKt.plus((Collection) p27Var.n(), (Iterable) listOf2));
            p27Var.p(CollectionsKt___CollectionsKt.plus((Collection) p27Var.m(), (Iterable) listOf3));
            dataList.add(new i77(p27Var, "social_bar"));
        }
    }
}
