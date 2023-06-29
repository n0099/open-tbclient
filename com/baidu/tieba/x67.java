package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.a87;
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
/* loaded from: classes8.dex */
public final class x67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final n47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            h57 h57Var = new h57();
            h57Var.l = jSONObject.optString("appid");
            h57Var.m = item.name;
            h57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                h57Var.c = (float) item.icon_ratio.doubleValue();
            }
            h57Var.n = jSONObject.optString("apk_name");
            h57Var.o = jSONObject.optString("version");
            h57Var.p = jSONObject.optInt("version_code");
            h57Var.q = jSONObject.optLong("size");
            h57Var.r = item.button_link;
            h57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                h57Var.f = (float) item.score.doubleValue();
            }
            h57Var.g = item.tags;
            h57Var.s = jSONObject.optString("developer");
            h57Var.t = jSONObject.optString("publisher");
            h57Var.u = jSONObject.optString("authority_url");
            h57Var.v = jSONObject.optString("privacy_url");
            h57Var.w = jSONObject.optInt("pkg_source");
            h57Var.h = item.button_name;
            h57Var.a = j;
            h57Var.k = forumName;
            u77 u77Var = new u77();
            u77Var.a = tid;
            u77Var.b = pageFrom;
            return new n47(h57Var, u77Var, false, 4, null);
        }
        return (n47) invokeCommon.objValue;
    }

    public static final r47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            f67 f67Var = new f67();
            f67Var.a = j;
            f67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                f67Var.c = (float) item.icon_ratio.doubleValue();
            }
            f67Var.d = item.name;
            f67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                f67Var.f = (float) item.score.doubleValue();
            }
            f67Var.g = item.tags;
            f67Var.h = item.button_name;
            f67Var.i = item.button_link;
            f67Var.k = forumName;
            v77 v77Var = new v77();
            v77Var.a = tid;
            v77Var.b = pageFrom;
            return new r47(f67Var, v77Var, false, 4, null);
        }
        return (r47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<t87<?>> dataList, v57 feedExtraData) {
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
            a87.a aVar = a87.a;
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
            long g = vg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            w87 w87Var = feedExtraData.d().get(PageInfo.KEY);
            if (w87Var == null || (a = w87Var.a(new i57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new u87(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new u87(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
