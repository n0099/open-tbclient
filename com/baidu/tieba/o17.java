package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.n27;
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
/* loaded from: classes6.dex */
public final class o17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedOriginComponent feedOriginComponent, List<g37<?>> dataList, i07 feedExtraData) {
        hz6 hz6Var;
        lz6 lz6Var;
        String str;
        az6 az6Var;
        ez6 ez6Var;
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
            zy6 a = g17.a(spannableStringBuilder, _abstract, new i07());
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
                    hz6Var = p17.a(list, str3, new i07());
                } else {
                    hz6Var = null;
                }
                if (feedOriginComponent.video != null) {
                    c17 c17Var = new c17();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    c17Var.g(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    lz6Var = t17.b(video, c17Var, new i07());
                } else {
                    lz6Var = null;
                }
                n27.a aVar = n27.a;
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
                long g = pg.g(a2.get("item_id"), 0L);
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
                        ez6 b = k17.b(item, g, str, "", "");
                        b.a().j = R.color.CAM_X0205;
                        b.d(false);
                        ez6Var = b;
                    } else {
                        ez6Var = null;
                    }
                    az6Var = null;
                } else {
                    FeedItem item2 = feedOriginComponent.item;
                    Intrinsics.checkNotNullExpressionValue(item2, "item");
                    az6 a3 = k17.a(item2, str4, g, str, "", "");
                    a3.a().j = R.color.CAM_X0205;
                    a3.d(false);
                    az6Var = a3;
                    ez6Var = null;
                }
                z07 b2 = j07.b(feedExtraData, "origin_card_click");
                String str7 = feedOriginComponent.schema;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                dataList.add(new h37(new gz6(a, hz6Var, lz6Var, ez6Var, az6Var, str2, b2, null, 128, null), "origin_card"));
            }
        }
    }
}
