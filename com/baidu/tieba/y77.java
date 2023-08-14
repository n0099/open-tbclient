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
/* loaded from: classes8.dex */
public final class y77 {
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
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedPostExpose feedPostExpose, List<v97<?>> dataList, b67 feedExtraData) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedPostExpose, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedPostExpose, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> list = feedPostExpose.floor;
            if (list != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String str12 = null;
                z77.a(list, spannableStringBuilder, new b67(), new f57(null, null, 3, null));
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
                        m57 m57Var = new m57();
                        m57Var.b(a97.a.a(feedPostExpose.business_info));
                        z57 z57Var = new z57(j, z, m57Var);
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
                        z67 z67Var = new z67(str2, str4, str6, str8, new SpannableString(spannableStringBuilder), z57Var);
                        postExposeHead3 = feedPostExpose.head_img;
                        if (postExposeHead3 != null) {
                            str12 = postExposeHead3.schema;
                        }
                        if (str12 != null) {
                            str9 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str12, "head_img?.schema ?: \"\"");
                            str9 = str12;
                        }
                        str10 = feedPostExpose.schema;
                        if (str10 != null) {
                            str11 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str10, "schema ?: \"\"");
                            str11 = str10;
                        }
                        dataList.add(new w97(new s47(z67Var, str9, str11, CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_user_head_click1"), c67.b(feedExtraData, "reply_user_head_click2")}), CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_user_name_click1"), c67.b(feedExtraData, "reply_user_name_click2")}), CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_card_click1"), c67.b(feedExtraData, "reply_card_click2")})), "reply"));
                    }
                }
                z = false;
                m57 m57Var2 = new m57();
                m57Var2.b(a97.a.a(feedPostExpose.business_info));
                z57 z57Var2 = new z57(j, z, m57Var2);
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
                z67 z67Var2 = new z67(str2, str4, str6, str8, new SpannableString(spannableStringBuilder), z57Var2);
                postExposeHead3 = feedPostExpose.head_img;
                if (postExposeHead3 != null) {
                }
                if (str12 != null) {
                }
                str10 = feedPostExpose.schema;
                if (str10 != null) {
                }
                dataList.add(new w97(new s47(z67Var2, str9, str11, CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_user_head_click1"), c67.b(feedExtraData, "reply_user_head_click2")}), CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_user_name_click1"), c67.b(feedExtraData, "reply_user_name_click2")}), CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "reply_card_click1"), c67.b(feedExtraData, "reply_card_click2")})), "reply"));
            }
        }
    }
}
