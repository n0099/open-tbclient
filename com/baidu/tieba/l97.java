package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.FeedItem;
import tbclient.FeedOriginComponent;
import tbclient.FeedOriginPic;
import tbclient.PicInfo;
import tbclient.VideoField;
/* loaded from: classes7.dex */
public final class l97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<sb7<?>> dataList, r67 feedExtraData) {
        u47 u47Var;
        b57 b57Var;
        q47 q47Var;
        m47 m47Var;
        String str;
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedOriginComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedOriginComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<FeedContentResource> _abstract = feedOriginComponent._abstract;
            Intrinsics.checkNotNullExpressionValue(_abstract, "_abstract");
            l47 a = e97.a(spannableStringBuilder, _abstract, new r67());
            if (a.k()) {
                FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
                if (feedOriginPic != null && feedOriginPic.pics != null) {
                    String str4 = feedOriginPic.schema;
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "pic_info.schema ?: \"\"");
                    }
                    List<PicInfo> list = feedOriginComponent.pic_info.pics;
                    Intrinsics.checkNotNullExpressionValue(list, "pic_info.pics");
                    u47Var = n97.b(list, str4, new r67());
                } else {
                    u47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    m87 m87Var = new m87();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    m87Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    b57Var = s97.b(video, m87Var, new r67());
                } else {
                    b57Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = wa7.a.a(feedItem.business_info);
                    String str5 = a2.get("apk_detail");
                    String str6 = feedExtraData.a().a().get("origin_thread_id");
                    if (str6 == null) {
                        str3 = "";
                    } else {
                        str3 = str6;
                    }
                    long j = JavaTypesHelper.toLong(a2.get("item_id"), 0L);
                    if (str5 == null) {
                        String str7 = feedOriginComponent.item.name;
                        if (str7 != null && str7.length() != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            FeedItem item = feedOriginComponent.item;
                            Intrinsics.checkNotNullExpressionValue(item, "item");
                            q47 b = h97.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            q47Var = b;
                            m47Var = null;
                            e87 e = s67.e(feedExtraData, "origin_card_click", null, 2, null);
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new tb7(new s47(a, u47Var, b57Var, q47Var, m47Var, str2, e, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        m47 a3 = h97.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        m47Var = a3;
                        q47Var = null;
                        e87 e2 = s67.e(feedExtraData, "origin_card_click", null, 2, null);
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new tb7(new s47(a, u47Var, b57Var, q47Var, m47Var, str2, e2, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                    }
                }
                q47Var = null;
                m47Var = null;
                e87 e22 = s67.e(feedExtraData, "origin_card_click", null, 2, null);
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new tb7(new s47(a, u47Var, b57Var, q47Var, m47Var, str2, e22, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
            }
        }
    }
}
