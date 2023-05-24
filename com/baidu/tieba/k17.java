package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.n27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedItem;
import tbclient.FeedKV;
/* loaded from: classes6.dex */
public final class k17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final az6 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            uz6 uz6Var = new uz6();
            uz6Var.l = jSONObject.optString("appid");
            uz6Var.m = item.name;
            uz6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                uz6Var.c = (float) item.icon_ratio.doubleValue();
            }
            uz6Var.n = jSONObject.optString("apk_name");
            uz6Var.o = jSONObject.optString("version");
            uz6Var.p = jSONObject.optInt("version_code");
            uz6Var.q = jSONObject.optLong("size");
            uz6Var.r = item.button_link;
            uz6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                uz6Var.f = (float) item.score.doubleValue();
            }
            uz6Var.g = item.tags;
            uz6Var.s = jSONObject.optString("developer");
            uz6Var.t = jSONObject.optString("publisher");
            uz6Var.u = jSONObject.optString("authority_url");
            uz6Var.v = jSONObject.optString("privacy_url");
            uz6Var.w = jSONObject.optInt("pkg_source");
            uz6Var.h = item.button_name;
            uz6Var.a = j;
            uz6Var.k = forumName;
            h27 h27Var = new h27();
            h27Var.a = tid;
            h27Var.b = pageFrom;
            return new az6(uz6Var, h27Var, false, 4, null);
        }
        return (az6) invokeCommon.objValue;
    }

    public static final ez6 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            s07 s07Var = new s07();
            s07Var.a = j;
            s07Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                s07Var.c = (float) item.icon_ratio.doubleValue();
            }
            s07Var.d = item.name;
            s07Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                s07Var.f = (float) item.score.doubleValue();
            }
            s07Var.g = item.tags;
            s07Var.h = item.button_name;
            s07Var.i = item.button_link;
            s07Var.k = forumName;
            i27 i27Var = new i27();
            i27Var.a = tid;
            i27Var.b = pageFrom;
            return new ez6(s07Var, i27Var, false, 4, null);
        }
        return (ez6) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<g37<?>> dataList, i07 feedExtraData) {
        String str;
        String str2;
        String str3;
        Map<String, String> a;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, feedItem, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedItem, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            n27.a aVar = n27.a;
            List<FeedKV> business_info = feedItem.business_info;
            Intrinsics.checkNotNullExpressionValue(business_info, "business_info");
            HashMap<String, String> a2 = aVar.a(business_info);
            String str5 = a2.get("apk_detail");
            String str6 = feedExtraData.a().a().get("thread_id");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            long g = pg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            j37 j37Var = feedExtraData.d().get(PageInfo.KEY);
            if (j37Var == null || (a = j37Var.a(new vz6())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new h37(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new h37(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
