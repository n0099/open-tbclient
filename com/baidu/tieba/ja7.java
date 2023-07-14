package com.baidu.tieba;

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
/* loaded from: classes6.dex */
public final class ja7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final a77 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            b87 b87Var = new b87();
            b87Var.l = jSONObject.optString("appid");
            b87Var.m = item.name;
            b87Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                b87Var.c = (float) item.icon_ratio.doubleValue();
            }
            b87Var.n = jSONObject.optString("apk_name");
            b87Var.o = jSONObject.optString("version");
            b87Var.p = jSONObject.optInt("version_code");
            b87Var.q = jSONObject.optLong("size");
            b87Var.r = item.button_link;
            b87Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                b87Var.f = (float) item.score.doubleValue();
            }
            b87Var.g = item.tags;
            b87Var.s = jSONObject.optString("developer");
            b87Var.t = jSONObject.optString("publisher");
            b87Var.u = jSONObject.optString("authority_url");
            b87Var.v = jSONObject.optString("privacy_url");
            b87Var.w = jSONObject.optInt("pkg_source");
            b87Var.h = item.button_name;
            b87Var.a = j;
            b87Var.k = forumName;
            kb7 kb7Var = new kb7();
            kb7Var.a = tid;
            kb7Var.b = pageFrom;
            return new a77(b87Var, kb7Var, false, 4, null);
        }
        return (a77) invokeCommon.objValue;
    }

    public static final e77 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            l97 l97Var = new l97();
            l97Var.a = j;
            l97Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                l97Var.c = (float) item.icon_ratio.doubleValue();
            }
            l97Var.d = item.name;
            l97Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                l97Var.f = (float) item.score.doubleValue();
            }
            l97Var.g = item.tags;
            l97Var.h = item.button_name;
            l97Var.i = item.button_link;
            l97Var.k = forumName;
            lb7 lb7Var = new lb7();
            lb7Var.a = tid;
            lb7Var.b = pageFrom;
            return new e77(l97Var, lb7Var, false, 4, null);
        }
        return (e77) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<mc7<?>> dataList, s87 feedExtraData) {
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
            HashMap<String, String> a2 = rb7.a.a(feedItem.business_info);
            String str5 = a2.get("apk_detail");
            String str6 = feedExtraData.a().a().get("thread_id");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            long g = wg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            qc7 qc7Var = feedExtraData.e().get(PageInfo.KEY);
            if (qc7Var == null || (a = qc7Var.a(new d87())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new nc7(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new nc7(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
