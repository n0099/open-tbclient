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
/* loaded from: classes6.dex */
public final class la7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final b77 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            d87 d87Var = new d87();
            d87Var.l = jSONObject.optString("appid");
            d87Var.m = item.name;
            d87Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                d87Var.c = (float) item.icon_ratio.doubleValue();
            }
            d87Var.n = jSONObject.optString("apk_name");
            d87Var.o = jSONObject.optString("version");
            d87Var.p = jSONObject.optInt("version_code");
            d87Var.q = jSONObject.optLong("size");
            d87Var.r = item.button_link;
            d87Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                d87Var.f = (float) item.score.doubleValue();
            }
            d87Var.g = item.tags;
            d87Var.s = jSONObject.optString("developer");
            d87Var.t = jSONObject.optString("publisher");
            d87Var.u = jSONObject.optString("authority_url");
            d87Var.v = jSONObject.optString("privacy_url");
            d87Var.w = jSONObject.optInt("pkg_source");
            d87Var.h = item.button_name;
            d87Var.a = j;
            d87Var.k = forumName;
            nb7 nb7Var = new nb7();
            nb7Var.a = tid;
            nb7Var.b = pageFrom;
            return new b77(d87Var, nb7Var, false, 4, null);
        }
        return (b77) invokeCommon.objValue;
    }

    public static final f77 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            n97 n97Var = new n97();
            n97Var.a = j;
            n97Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                n97Var.c = (float) item.icon_ratio.doubleValue();
            }
            n97Var.d = item.name;
            n97Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                n97Var.f = (float) item.score.doubleValue();
            }
            n97Var.g = item.tags;
            n97Var.h = item.button_name;
            n97Var.i = item.button_link;
            n97Var.k = forumName;
            ob7 ob7Var = new ob7();
            ob7Var.a = tid;
            ob7Var.b = pageFrom;
            return new f77(n97Var, ob7Var, false, 4, null);
        }
        return (f77) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<pc7<?>> dataList, u87 feedExtraData) {
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
            HashMap<String, String> a2 = ub7.a.a(feedItem.business_info);
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
            tc7 tc7Var = feedExtraData.e().get(PageInfo.KEY);
            if (tc7Var == null || (a = tc7Var.a(new f87())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new qc7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new qc7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
