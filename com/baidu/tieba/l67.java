package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.o77;
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
public final class l67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final b47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            v47 v47Var = new v47();
            v47Var.l = jSONObject.optString("appid");
            v47Var.m = item.name;
            v47Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                v47Var.c = (float) item.icon_ratio.doubleValue();
            }
            v47Var.n = jSONObject.optString("apk_name");
            v47Var.o = jSONObject.optString("version");
            v47Var.p = jSONObject.optInt("version_code");
            v47Var.q = jSONObject.optLong("size");
            v47Var.r = item.button_link;
            v47Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                v47Var.f = (float) item.score.doubleValue();
            }
            v47Var.g = item.tags;
            v47Var.s = jSONObject.optString("developer");
            v47Var.t = jSONObject.optString("publisher");
            v47Var.u = jSONObject.optString("authority_url");
            v47Var.v = jSONObject.optString("privacy_url");
            v47Var.w = jSONObject.optInt("pkg_source");
            v47Var.h = item.button_name;
            v47Var.a = j;
            v47Var.k = forumName;
            i77 i77Var = new i77();
            i77Var.a = tid;
            i77Var.b = pageFrom;
            return new b47(v47Var, i77Var, false, 4, null);
        }
        return (b47) invokeCommon.objValue;
    }

    public static final f47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            t57 t57Var = new t57();
            t57Var.a = j;
            t57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                t57Var.c = (float) item.icon_ratio.doubleValue();
            }
            t57Var.d = item.name;
            t57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                t57Var.f = (float) item.score.doubleValue();
            }
            t57Var.g = item.tags;
            t57Var.h = item.button_name;
            t57Var.i = item.button_link;
            t57Var.k = forumName;
            j77 j77Var = new j77();
            j77Var.a = tid;
            j77Var.b = pageFrom;
            return new f47(t57Var, j77Var, false, 4, null);
        }
        return (f47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<h87<?>> dataList, j57 feedExtraData) {
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
            o77.a aVar = o77.a;
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
            k87 k87Var = feedExtraData.d().get(PageInfo.KEY);
            if (k87Var == null || (a = k87Var.a(new w47())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new i87(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new i87(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
