package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.q77;
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
public final class n67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final d47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
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
            k77 k77Var = new k77();
            k77Var.a = tid;
            k77Var.b = pageFrom;
            return new d47(x47Var, k77Var, false, 4, null);
        }
        return (d47) invokeCommon.objValue;
    }

    public static final h47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            v57 v57Var = new v57();
            v57Var.a = j;
            v57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                v57Var.c = (float) item.icon_ratio.doubleValue();
            }
            v57Var.d = item.name;
            v57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                v57Var.f = (float) item.score.doubleValue();
            }
            v57Var.g = item.tags;
            v57Var.h = item.button_name;
            v57Var.i = item.button_link;
            v57Var.k = forumName;
            l77 l77Var = new l77();
            l77Var.a = tid;
            l77Var.b = pageFrom;
            return new h47(v57Var, l77Var, false, 4, null);
        }
        return (h47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<j87<?>> dataList, l57 feedExtraData) {
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
            q77.a aVar = q77.a;
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
            long g = tg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            m87 m87Var = feedExtraData.d().get(PageInfo.KEY);
            if (m87Var == null || (a = m87Var.a(new y47())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new k87(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new k87(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
