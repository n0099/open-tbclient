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
/* loaded from: classes8.dex */
public final class w77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<v97<?>> dataList, b67 feedExtraData) {
        q47 q47Var;
        x47 x47Var;
        n47 n47Var;
        j47 j47Var;
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
            i47 a = p77.a(spannableStringBuilder, _abstract, new b67());
            if (a.i()) {
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
                    q47Var = x77.a(list, str4, new b67());
                } else {
                    q47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    h77 h77Var = new h77();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    h77Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    x47Var = d87.b(video, h77Var, new b67());
                } else {
                    x47Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = a97.a.a(feedItem.business_info);
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
                            n47 b = s77.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            n47Var = b;
                            j47Var = null;
                            d77 b2 = c67.b(feedExtraData, "origin_card_click");
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new w97(new p47(a, q47Var, x47Var, n47Var, j47Var, str2, b2, null, 128, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        j47 a3 = s77.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        j47Var = a3;
                        n47Var = null;
                        d77 b22 = c67.b(feedExtraData, "origin_card_click");
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new w97(new p47(a, q47Var, x47Var, n47Var, j47Var, str2, b22, null, 128, null), "origin_card"));
                    }
                }
                n47Var = null;
                j47Var = null;
                d77 b222 = c67.b(feedExtraData, "origin_card_click");
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new w97(new p47(a, q47Var, x47Var, n47Var, j47Var, str2, b222, null, 128, null), "origin_card"));
            }
        }
    }
}
