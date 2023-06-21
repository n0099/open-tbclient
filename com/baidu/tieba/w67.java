package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.v77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.FeedItem;
import tbclient.FeedKV;
import tbclient.FeedOriginComponent;
import tbclient.FeedOriginPic;
import tbclient.PicInfo;
import tbclient.VideoField;
/* loaded from: classes8.dex */
public final class w67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedOriginComponent feedOriginComponent, List<o87<?>> dataList, q57 feedExtraData) {
        p47 p47Var;
        t47 t47Var;
        String str;
        i47 i47Var;
        m47 m47Var;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedOriginComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedOriginComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<FeedContentResource> _abstract = feedOriginComponent._abstract;
            Intrinsics.checkNotNullExpressionValue(_abstract, "_abstract");
            h47 a = o67.a(spannableStringBuilder, _abstract, new q57());
            if (a.g()) {
                FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
                if (feedOriginPic != null && feedOriginPic.pics != null) {
                    String str3 = feedOriginPic.schema;
                    if (str3 == null) {
                        str3 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str3, "pic_info.schema ?: \"\"");
                    }
                    List<PicInfo> list = feedOriginComponent.pic_info.pics;
                    Intrinsics.checkNotNullExpressionValue(list, "pic_info.pics");
                    p47Var = x67.a(list, str3, new q57());
                } else {
                    p47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    k67 k67Var = new k67();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    k67Var.g(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    t47Var = b77.b(video, k67Var, new q57());
                } else {
                    t47Var = null;
                }
                v77.a aVar = v77.a;
                List<FeedKV> list2 = feedOriginComponent.item.business_info;
                Intrinsics.checkNotNullExpressionValue(list2, "item.business_info");
                HashMap<String, String> a2 = aVar.a(list2);
                String str4 = a2.get("apk_detail");
                String str5 = feedExtraData.a().a().get("origin_thread_id");
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                long g = ug.g(a2.get("item_id"), 0L);
                if (str4 == null) {
                    String str6 = feedOriginComponent.item.name;
                    if (str6 != null && str6.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        FeedItem item = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        m47 b = s67.b(item, g, str, "", "");
                        b.a().j = R.color.CAM_X0205;
                        b.d(false);
                        m47Var = b;
                    } else {
                        m47Var = null;
                    }
                    i47Var = null;
                } else {
                    FeedItem item2 = feedOriginComponent.item;
                    Intrinsics.checkNotNullExpressionValue(item2, "item");
                    i47 a3 = s67.a(item2, str4, g, str, "", "");
                    a3.a().j = R.color.CAM_X0205;
                    a3.d(false);
                    i47Var = a3;
                    m47Var = null;
                }
                h67 b2 = r57.b(feedExtraData, "origin_card_click");
                String str7 = feedOriginComponent.schema;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                dataList.add(new p87(new o47(a, p47Var, t47Var, m47Var, i47Var, str2, b2, null, 128, null), "origin_card"));
            }
        }
    }
}
