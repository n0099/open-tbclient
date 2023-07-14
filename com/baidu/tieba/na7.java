package com.baidu.tieba;

import android.text.SpannableStringBuilder;
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
public final class na7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<mc7<?>> dataList, s87 feedExtraData) {
        h77 h77Var;
        o77 o77Var;
        e77 e77Var;
        a77 a77Var;
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
            z67 a = ga7.a(spannableStringBuilder, _abstract, new s87());
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
                    h77Var = oa7.a(list, str4, new s87());
                } else {
                    h77Var = null;
                }
                if (feedOriginComponent.video != null) {
                    y97 y97Var = new y97();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    y97Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    o77Var = ua7.b(video, y97Var, new s87());
                } else {
                    o77Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = rb7.a.a(feedItem.business_info);
                    String str5 = a2.get("apk_detail");
                    String str6 = feedExtraData.a().a().get("origin_thread_id");
                    if (str6 == null) {
                        str3 = "";
                    } else {
                        str3 = str6;
                    }
                    long g = wg.g(a2.get("item_id"), 0L);
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
                            e77 b = ja7.b(item, g, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            e77Var = b;
                            a77Var = null;
                            u97 b2 = t87.b(feedExtraData, "origin_card_click");
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new nc7(new g77(a, h77Var, o77Var, e77Var, a77Var, str2, b2, null, 128, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        a77 a3 = ja7.a(item2, str5, g, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        a77Var = a3;
                        e77Var = null;
                        u97 b22 = t87.b(feedExtraData, "origin_card_click");
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new nc7(new g77(a, h77Var, o77Var, e77Var, a77Var, str2, b22, null, 128, null), "origin_card"));
                    }
                }
                e77Var = null;
                a77Var = null;
                u97 b222 = t87.b(feedExtraData, "origin_card_click");
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new nc7(new g77(a, h77Var, o77Var, e77Var, a77Var, str2, b222, null, 128, null), "origin_card"));
            }
        }
    }
}
