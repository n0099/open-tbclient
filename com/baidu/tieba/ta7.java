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
/* loaded from: classes8.dex */
public final class ta7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final i77 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            k87 k87Var = new k87();
            k87Var.l = jSONObject.optString("appid");
            k87Var.m = item.name;
            k87Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                k87Var.c = (float) item.icon_ratio.doubleValue();
            }
            k87Var.n = jSONObject.optString("apk_name");
            k87Var.o = jSONObject.optString("version");
            k87Var.p = jSONObject.optInt("version_code");
            k87Var.q = jSONObject.optLong("size");
            k87Var.r = item.button_link;
            k87Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                k87Var.f = (float) item.score.doubleValue();
            }
            k87Var.g = item.tags;
            k87Var.s = jSONObject.optString("developer");
            k87Var.t = jSONObject.optString("publisher");
            k87Var.u = jSONObject.optString("authority_url");
            k87Var.v = jSONObject.optString("privacy_url");
            k87Var.w = jSONObject.optInt("pkg_source");
            k87Var.h = item.button_name;
            k87Var.a = j;
            k87Var.k = forumName;
            vb7 vb7Var = new vb7();
            vb7Var.a = tid;
            vb7Var.b = pageFrom;
            return new i77(k87Var, vb7Var, false, 4, null);
        }
        return (i77) invokeCommon.objValue;
    }

    public static final m77 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            u97 u97Var = new u97();
            u97Var.a = j;
            u97Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                u97Var.c = (float) item.icon_ratio.doubleValue();
            }
            u97Var.d = item.name;
            u97Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                u97Var.f = (float) item.score.doubleValue();
            }
            u97Var.g = item.tags;
            u97Var.h = item.button_name;
            u97Var.i = item.button_link;
            u97Var.k = forumName;
            wb7 wb7Var = new wb7();
            wb7Var.a = tid;
            wb7Var.b = pageFrom;
            return new m77(u97Var, wb7Var, false, 4, null);
        }
        return (m77) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<yc7<?>> dataList, b97 feedExtraData) {
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
            HashMap<String, String> a2 = dc7.a.a(feedItem.business_info);
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
            cd7 cd7Var = feedExtraData.e().get(PageInfo.KEY);
            if (cd7Var == null || (a = cd7Var.a(new m87())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new zc7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new zc7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
