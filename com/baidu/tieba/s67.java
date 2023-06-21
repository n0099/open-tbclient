package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.v77;
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
/* loaded from: classes7.dex */
public final class s67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final i47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            c57 c57Var = new c57();
            c57Var.l = jSONObject.optString("appid");
            c57Var.m = item.name;
            c57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                c57Var.c = (float) item.icon_ratio.doubleValue();
            }
            c57Var.n = jSONObject.optString("apk_name");
            c57Var.o = jSONObject.optString("version");
            c57Var.p = jSONObject.optInt("version_code");
            c57Var.q = jSONObject.optLong("size");
            c57Var.r = item.button_link;
            c57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                c57Var.f = (float) item.score.doubleValue();
            }
            c57Var.g = item.tags;
            c57Var.s = jSONObject.optString("developer");
            c57Var.t = jSONObject.optString("publisher");
            c57Var.u = jSONObject.optString("authority_url");
            c57Var.v = jSONObject.optString("privacy_url");
            c57Var.w = jSONObject.optInt("pkg_source");
            c57Var.h = item.button_name;
            c57Var.a = j;
            c57Var.k = forumName;
            p77 p77Var = new p77();
            p77Var.a = tid;
            p77Var.b = pageFrom;
            return new i47(c57Var, p77Var, false, 4, null);
        }
        return (i47) invokeCommon.objValue;
    }

    public static final m47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            a67 a67Var = new a67();
            a67Var.a = j;
            a67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                a67Var.c = (float) item.icon_ratio.doubleValue();
            }
            a67Var.d = item.name;
            a67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                a67Var.f = (float) item.score.doubleValue();
            }
            a67Var.g = item.tags;
            a67Var.h = item.button_name;
            a67Var.i = item.button_link;
            a67Var.k = forumName;
            q77 q77Var = new q77();
            q77Var.a = tid;
            q77Var.b = pageFrom;
            return new m47(a67Var, q77Var, false, 4, null);
        }
        return (m47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<o87<?>> dataList, q57 feedExtraData) {
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
            v77.a aVar = v77.a;
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
            long g = ug.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            r87 r87Var = feedExtraData.d().get(PageInfo.KEY);
            if (r87Var == null || (a = r87Var.a(new d57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new p87(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new p87(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
