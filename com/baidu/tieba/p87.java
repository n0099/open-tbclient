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
public final class p87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final u37 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            x47 x47Var = new x47();
            x47Var.l = jSONObject.optString("appid");
            x47Var.m = item.name;
            x47Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                x47Var.c = (float) item.icon_ratio.doubleValue();
            }
            x47Var.n = jSONObject.optString("apk_name");
            x47Var.o = jSONObject.optString("version");
            x47Var.p = jSONObject.optInt("version_code");
            x47Var.q = jSONObject.optLong("size");
            x47Var.r = item.button_link;
            x47Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                x47Var.f = (float) item.score.doubleValue();
            }
            x47Var.g = item.tags;
            x47Var.s = jSONObject.optString("developer");
            x47Var.t = jSONObject.optString("publisher");
            x47Var.u = jSONObject.optString("authority_url");
            x47Var.v = jSONObject.optString("privacy_url");
            x47Var.w = jSONObject.optInt("pkg_source");
            x47Var.h = item.button_name;
            x47Var.a = j;
            x47Var.k = forumName;
            u97 u97Var = new u97();
            u97Var.a = tid;
            u97Var.b = pageFrom;
            return new u37(x47Var, u97Var, false, 4, null);
        }
        return (u37) invokeCommon.objValue;
    }

    public static final y37 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            w67 w67Var = new w67();
            w67Var.a = j;
            w67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                w67Var.c = (float) item.icon_ratio.doubleValue();
            }
            w67Var.d = item.name;
            w67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                w67Var.f = (float) item.score.doubleValue();
            }
            w67Var.g = item.tags;
            w67Var.h = item.button_name;
            w67Var.i = item.button_link;
            w67Var.k = forumName;
            v97 v97Var = new v97();
            v97Var.a = tid;
            v97Var.b = pageFrom;
            return new y37(w67Var, v97Var, false, 4, null);
        }
        return (y37) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<za7<?>> dataList, z57 feedExtraData) {
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
            HashMap<String, String> a2 = da7.a.a(feedItem.business_info);
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
            gb7 gb7Var = feedExtraData.e().get(PageInfo.KEY);
            if (gb7Var == null || (a = gb7Var.a(new d57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new ab7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new ab7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
