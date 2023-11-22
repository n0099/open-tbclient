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
public final class q87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final v37 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            y47 y47Var = new y47();
            y47Var.l = jSONObject.optString("appid");
            y47Var.m = item.name;
            y47Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                y47Var.c = (float) item.icon_ratio.doubleValue();
            }
            y47Var.n = jSONObject.optString("apk_name");
            y47Var.o = jSONObject.optString("version");
            y47Var.p = jSONObject.optInt("version_code");
            y47Var.q = jSONObject.optLong("size");
            y47Var.r = item.button_link;
            y47Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                y47Var.f = (float) item.score.doubleValue();
            }
            y47Var.g = item.tags;
            y47Var.s = jSONObject.optString("developer");
            y47Var.t = jSONObject.optString("publisher");
            y47Var.u = jSONObject.optString("authority_url");
            y47Var.v = jSONObject.optString("privacy_url");
            y47Var.w = jSONObject.optInt("pkg_source");
            y47Var.h = item.button_name;
            y47Var.a = j;
            y47Var.k = forumName;
            v97 v97Var = new v97();
            v97Var.a = tid;
            v97Var.b = pageFrom;
            return new v37(y47Var, v97Var, false, 4, null);
        }
        return (v37) invokeCommon.objValue;
    }

    public static final z37 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            x67 x67Var = new x67();
            x67Var.a = j;
            x67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                x67Var.c = (float) item.icon_ratio.doubleValue();
            }
            x67Var.d = item.name;
            x67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                x67Var.f = (float) item.score.doubleValue();
            }
            x67Var.g = item.tags;
            x67Var.h = item.button_name;
            x67Var.i = item.button_link;
            x67Var.k = forumName;
            w97 w97Var = new w97();
            w97Var.a = tid;
            w97Var.b = pageFrom;
            return new z37(x67Var, w97Var, false, 4, null);
        }
        return (z37) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<ab7<?>> dataList, a67 feedExtraData) {
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
            HashMap<String, String> a2 = ea7.a.a(feedItem.business_info);
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
            hb7 hb7Var = feedExtraData.e().get(PageInfo.KEY);
            if (hb7Var == null || (a = hb7Var.a(new e57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new bb7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new bb7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
