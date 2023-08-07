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
public final class r77 {
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
            j57 j57Var = new j57();
            j57Var.l = jSONObject.optString("appid");
            j57Var.m = item.name;
            j57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                j57Var.c = (float) item.icon_ratio.doubleValue();
            }
            j57Var.n = jSONObject.optString("apk_name");
            j57Var.o = jSONObject.optString("version");
            j57Var.p = jSONObject.optInt("version_code");
            j57Var.q = jSONObject.optLong("size");
            j57Var.r = item.button_link;
            j57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                j57Var.f = (float) item.score.doubleValue();
            }
            j57Var.g = item.tags;
            j57Var.s = jSONObject.optString("developer");
            j57Var.t = jSONObject.optString("publisher");
            j57Var.u = jSONObject.optString("authority_url");
            j57Var.v = jSONObject.optString("privacy_url");
            j57Var.w = jSONObject.optInt("pkg_source");
            j57Var.h = item.button_name;
            j57Var.a = j;
            j57Var.k = forumName;
            s87 s87Var = new s87();
            s87Var.a = tid;
            s87Var.b = pageFrom;
            return new i47(j57Var, s87Var, false, 4, null);
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
            t67 t67Var = new t67();
            t67Var.a = j;
            t67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                t67Var.c = (float) item.icon_ratio.doubleValue();
            }
            t67Var.d = item.name;
            t67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                t67Var.f = (float) item.score.doubleValue();
            }
            t67Var.g = item.tags;
            t67Var.h = item.button_name;
            t67Var.i = item.button_link;
            t67Var.k = forumName;
            t87 t87Var = new t87();
            t87Var.a = tid;
            t87Var.b = pageFrom;
            return new m47(t67Var, t87Var, false, 4, null);
        }
        return (m47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<u97<?>> dataList, a67 feedExtraData) {
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
            HashMap<String, String> a2 = z87.a.a(feedItem.business_info);
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
            y97 y97Var = feedExtraData.e().get(PageInfo.KEY);
            if (y97Var == null || (a = y97Var.a(new l57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new v97(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new v97(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
