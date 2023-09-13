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
public final class pa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<pc7<?>> dataList, u87 feedExtraData) {
        j77 j77Var;
        q77 q77Var;
        f77 f77Var;
        b77 b77Var;
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
            a77 a = ia7.a(spannableStringBuilder, _abstract, new u87());
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
                    j77Var = ra7.a(list, str4, new u87());
                } else {
                    j77Var = null;
                }
                if (feedOriginComponent.video != null) {
                    aa7 aa7Var = new aa7();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    aa7Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    q77Var = xa7.b(video, aa7Var, new u87());
                } else {
                    q77Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = ub7.a.a(feedItem.business_info);
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
                            f77 b = la7.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            f77Var = b;
                            b77Var = null;
                            w97 b2 = v87.b(feedExtraData, "origin_card_click");
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new qc7(new h77(a, j77Var, q77Var, f77Var, b77Var, str2, b2, null, 128, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        b77 a3 = la7.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        b77Var = a3;
                        f77Var = null;
                        w97 b22 = v87.b(feedExtraData, "origin_card_click");
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new qc7(new h77(a, j77Var, q77Var, f77Var, b77Var, str2, b22, null, 128, null), "origin_card"));
                    }
                }
                f77Var = null;
                b77Var = null;
                w97 b222 = v87.b(feedExtraData, "origin_card_click");
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new qc7(new h77(a, j77Var, q77Var, f77Var, b77Var, str2, b222, null, 128, null), "origin_card"));
            }
        }
    }
}
