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
public final class t87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<za7<?>> dataList, z57 feedExtraData) {
        c47 c47Var;
        j47 j47Var;
        y37 y37Var;
        u37 u37Var;
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
            t37 a = m87.a(spannableStringBuilder, _abstract, new z57());
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
                    c47Var = v87.b(list, str4, new z57());
                } else {
                    c47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    u77 u77Var = new u77();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    u77Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    j47Var = a97.b(video, u77Var, new z57());
                } else {
                    j47Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = da7.a.a(feedItem.business_info);
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
                            y37 b = p87.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            y37Var = b;
                            u37Var = null;
                            m77 d = a67.d(feedExtraData, "origin_card_click", null, 2, null);
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new ab7(new a47(a, c47Var, j47Var, y37Var, u37Var, str2, d, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        u37 a3 = p87.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        u37Var = a3;
                        y37Var = null;
                        m77 d2 = a67.d(feedExtraData, "origin_card_click", null, 2, null);
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new ab7(new a47(a, c47Var, j47Var, y37Var, u37Var, str2, d2, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                    }
                }
                y37Var = null;
                u37Var = null;
                m77 d22 = a67.d(feedExtraData, "origin_card_click", null, 2, null);
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new ab7(new a47(a, c47Var, j47Var, y37Var, u37Var, str2, d22, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
            }
        }
    }
}
