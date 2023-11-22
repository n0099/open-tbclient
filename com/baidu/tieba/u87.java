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
public final class u87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<ab7<?>> dataList, a67 feedExtraData) {
        d47 d47Var;
        k47 k47Var;
        z37 z37Var;
        v37 v37Var;
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
            u37 a = n87.a(spannableStringBuilder, _abstract, new a67());
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
                    d47Var = w87.b(list, str4, new a67());
                } else {
                    d47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    v77 v77Var = new v77();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    v77Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    k47Var = b97.b(video, v77Var, new a67());
                } else {
                    k47Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = ea7.a.a(feedItem.business_info);
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
                            z37 b = q87.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            z37Var = b;
                            v37Var = null;
                            n77 d = b67.d(feedExtraData, "origin_card_click", null, 2, null);
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new bb7(new b47(a, d47Var, k47Var, z37Var, v37Var, str2, d, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        v37 a3 = q87.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        v37Var = a3;
                        z37Var = null;
                        n77 d2 = b67.d(feedExtraData, "origin_card_click", null, 2, null);
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new bb7(new b47(a, d47Var, k47Var, z37Var, v37Var, str2, d2, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
                    }
                }
                z37Var = null;
                v37Var = null;
                n77 d22 = b67.d(feedExtraData, "origin_card_click", null, 2, null);
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new bb7(new b47(a, d47Var, k47Var, z37Var, v37Var, str2, d22, feedExtraData.a().a(), feedExtraData.c().a(), null, 512, null), "origin_card"));
            }
        }
    }
}
