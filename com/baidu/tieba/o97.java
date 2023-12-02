package com.baidu.tieba;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedContentResource;
import tbclient.FeedPostExpose;
import tbclient.PostExposeHead;
/* loaded from: classes7.dex */
public final class o97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedPostExpose feedPostExpose, List<rb7<?>> dataList, r67 feedExtraData) {
        boolean z;
        PostExposeHead postExposeHead;
        String str;
        String str2;
        PostExposeHead postExposeHead2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        PostExposeHead postExposeHead3;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedPostExpose, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedPostExpose, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> list = feedPostExpose.floor;
            if (list != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                p97.a(list, spannableStringBuilder, new r67(), new j57(null, null, 3, null));
                long j = 0;
                Agree head_agree = feedPostExpose.head_agree;
                if (head_agree != null) {
                    Intrinsics.checkNotNullExpressionValue(head_agree, "head_agree");
                    Long l = head_agree.agree_num;
                    Intrinsics.checkNotNullExpressionValue(l, "agree.agree_num");
                    j = l.longValue();
                    Integer num = head_agree.has_agree;
                    if (num != null && num.intValue() == 1) {
                        z = true;
                        v57 v57Var = new v57();
                        v57Var.b(va7.a.a(feedPostExpose.business_info));
                        p67 p67Var = new p67(j, z, v57Var);
                        postExposeHead = feedPostExpose.head_img;
                        if (postExposeHead == null) {
                            str = postExposeHead.img_url;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            str2 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str, "head_img?.img_url ?: \"\"");
                            str2 = str;
                        }
                        postExposeHead2 = feedPostExpose.head_img;
                        if (postExposeHead2 == null) {
                            str3 = postExposeHead2.corner_url;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            str4 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str3, "head_img?.corner_url ?: \"\"");
                            str4 = str3;
                        }
                        str5 = feedPostExpose.head_text;
                        if (str5 != null) {
                            str6 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str5, "head_text ?: \"\"");
                            str6 = str5;
                        }
                        str7 = feedPostExpose.stamp_url;
                        if (str7 != null) {
                            str8 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str7, "stamp_url ?: \"\"");
                            str8 = str7;
                        }
                        a87 a87Var = new a87(str2, str4, str6, str8, new SpannableString(spannableStringBuilder), p67Var, v57Var.a().get("toutiao_card_tag"), v57Var.a().get("toutiao_card_tag_color"), Intrinsics.areEqual(v57Var.a().get("shield_icon"), "1"));
                        postExposeHead3 = feedPostExpose.head_img;
                        if (postExposeHead3 == null) {
                            str9 = postExposeHead3.schema;
                        } else {
                            str9 = null;
                        }
                        if (str9 != null) {
                            str10 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str9, "head_img?.schema ?: \"\"");
                            str10 = str9;
                        }
                        str11 = feedPostExpose.schema;
                        if (str11 != null) {
                            str12 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str11, "schema ?: \"\"");
                            str12 = str11;
                        }
                        dataList.add(new sb7(new w47(a87Var, str10, str12, v57Var.a(), feedExtraData.c().a(), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_user_head_click1", null, 2, null), s67.e(feedExtraData, "reply_user_head_click2", null, 2, null)}), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_user_name_click1", null, 2, null), s67.e(feedExtraData, "reply_user_name_click2", null, 2, null)}), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_card_click1", null, 2, null), s67.e(feedExtraData, "reply_card_click2", null, 2, null)}), null, 256, null), "reply"));
                    }
                }
                z = false;
                v57 v57Var2 = new v57();
                v57Var2.b(va7.a.a(feedPostExpose.business_info));
                p67 p67Var2 = new p67(j, z, v57Var2);
                postExposeHead = feedPostExpose.head_img;
                if (postExposeHead == null) {
                }
                if (str != null) {
                }
                postExposeHead2 = feedPostExpose.head_img;
                if (postExposeHead2 == null) {
                }
                if (str3 != null) {
                }
                str5 = feedPostExpose.head_text;
                if (str5 != null) {
                }
                str7 = feedPostExpose.stamp_url;
                if (str7 != null) {
                }
                a87 a87Var2 = new a87(str2, str4, str6, str8, new SpannableString(spannableStringBuilder), p67Var2, v57Var2.a().get("toutiao_card_tag"), v57Var2.a().get("toutiao_card_tag_color"), Intrinsics.areEqual(v57Var2.a().get("shield_icon"), "1"));
                postExposeHead3 = feedPostExpose.head_img;
                if (postExposeHead3 == null) {
                }
                if (str9 != null) {
                }
                str11 = feedPostExpose.schema;
                if (str11 != null) {
                }
                dataList.add(new sb7(new w47(a87Var2, str10, str12, v57Var2.a(), feedExtraData.c().a(), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_user_head_click1", null, 2, null), s67.e(feedExtraData, "reply_user_head_click2", null, 2, null)}), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_user_name_click1", null, 2, null), s67.e(feedExtraData, "reply_user_name_click2", null, 2, null)}), CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "reply_card_click1", null, 2, null), s67.e(feedExtraData, "reply_card_click2", null, 2, null)}), null, 256, null), "reply"));
            }
        }
    }
}
