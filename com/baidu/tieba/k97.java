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
/* loaded from: classes6.dex */
public final class k97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<jb7<?>> dataList, p77 feedExtraData) {
        e67 e67Var;
        l67 l67Var;
        b67 b67Var;
        x57 x57Var;
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
            w57 a = d97.a(spannableStringBuilder, _abstract, new p77());
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
                    e67Var = l97.a(list, str4, new p77());
                } else {
                    e67Var = null;
                }
                if (feedOriginComponent.video != null) {
                    v87 v87Var = new v87();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    v87Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    l67Var = r97.b(video, v87Var, new p77());
                } else {
                    l67Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = oa7.a.a(feedItem.business_info);
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
                            b67 b = g97.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            b67Var = b;
                            x57Var = null;
                            r87 b2 = q77.b(feedExtraData, "origin_card_click");
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new kb7(new d67(a, e67Var, l67Var, b67Var, x57Var, str2, b2, null, 128, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        x57 a3 = g97.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        x57Var = a3;
                        b67Var = null;
                        r87 b22 = q77.b(feedExtraData, "origin_card_click");
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new kb7(new d67(a, e67Var, l67Var, b67Var, x57Var, str2, b22, null, 128, null), "origin_card"));
                    }
                }
                b67Var = null;
                x57Var = null;
                r87 b222 = q77.b(feedExtraData, "origin_card_click");
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new kb7(new d67(a, e67Var, l67Var, b67Var, x57Var, str2, b222, null, 128, null), "origin_card"));
            }
        }
    }
}
