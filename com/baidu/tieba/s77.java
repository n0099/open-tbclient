package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedItem;
/* loaded from: classes7.dex */
public final class s77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final j47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            k57 k57Var = new k57();
            k57Var.l = jSONObject.optString("appid");
            k57Var.m = item.name;
            k57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                k57Var.c = (float) item.icon_ratio.doubleValue();
            }
            k57Var.n = jSONObject.optString("apk_name");
            k57Var.o = jSONObject.optString("version");
            k57Var.p = jSONObject.optInt("version_code");
            k57Var.q = jSONObject.optLong("size");
            k57Var.r = item.button_link;
            k57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                k57Var.f = (float) item.score.doubleValue();
            }
            k57Var.g = item.tags;
            k57Var.s = jSONObject.optString("developer");
            k57Var.t = jSONObject.optString("publisher");
            k57Var.u = jSONObject.optString("authority_url");
            k57Var.v = jSONObject.optString("privacy_url");
            k57Var.w = jSONObject.optInt("pkg_source");
            k57Var.h = item.button_name;
            k57Var.a = j;
            k57Var.k = forumName;
            t87 t87Var = new t87();
            t87Var.a = tid;
            t87Var.b = pageFrom;
            return new j47(k57Var, t87Var, false, 4, null);
        }
        return (j47) invokeCommon.objValue;
    }

    public static final n47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            u67 u67Var = new u67();
            u67Var.a = j;
            u67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                u67Var.c = (float) item.icon_ratio.doubleValue();
            }
            u67Var.d = item.name;
            u67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                u67Var.f = (float) item.score.doubleValue();
            }
            u67Var.g = item.tags;
            u67Var.h = item.button_name;
            u67Var.i = item.button_link;
            u67Var.k = forumName;
            u87 u87Var = new u87();
            u87Var.a = tid;
            u87Var.b = pageFrom;
            return new n47(u67Var, u87Var, false, 4, null);
        }
        return (n47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<v97<?>> dataList, b67 feedExtraData) {
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
            HashMap<String, String> a2 = a97.a.a(feedItem.business_info);
            String str5 = a2.get("apk_detail");
            String str6 = feedExtraData.a().a().get("thread_id");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            long j = JavaTypesHelper.toLong(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            z97 z97Var = feedExtraData.e().get(PageInfo.KEY);
            if (z97Var == null || (a = z97Var.a(new m57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new w97(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new w97(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
