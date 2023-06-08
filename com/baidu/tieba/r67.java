package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.q77;
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
/* loaded from: classes7.dex */
public final class r67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedOriginComponent feedOriginComponent, List<j87<?>> dataList, l57 feedExtraData) {
        k47 k47Var;
        o47 o47Var;
        String str;
        d47 d47Var;
        h47 h47Var;
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
            c47 a = j67.a(spannableStringBuilder, _abstract, new l57());
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
                    k47Var = s67.a(list, str3, new l57());
                } else {
                    k47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    f67 f67Var = new f67();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    f67Var.g(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    o47Var = w67.b(video, f67Var, new l57());
                } else {
                    o47Var = null;
                }
                q77.a aVar = q77.a;
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
                long g = tg.g(a2.get("item_id"), 0L);
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
                        h47 b = n67.b(item, g, str, "", "");
                        b.a().j = R.color.CAM_X0205;
                        b.d(false);
                        h47Var = b;
                    } else {
                        h47Var = null;
                    }
                    d47Var = null;
                } else {
                    FeedItem item2 = feedOriginComponent.item;
                    Intrinsics.checkNotNullExpressionValue(item2, "item");
                    d47 a3 = n67.a(item2, str4, g, str, "", "");
                    a3.a().j = R.color.CAM_X0205;
                    a3.d(false);
                    d47Var = a3;
                    h47Var = null;
                }
                c67 b2 = m57.b(feedExtraData, "origin_card_click");
                String str7 = feedOriginComponent.schema;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                dataList.add(new k87(new j47(a, k47Var, o47Var, h47Var, d47Var, str2, b2, null, 128, null), "origin_card"));
            }
        }
    }
}
