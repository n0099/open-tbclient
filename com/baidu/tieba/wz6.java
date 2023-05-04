package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.z07;
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
public final class wz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final mx6 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            gy6 gy6Var = new gy6();
            gy6Var.l = jSONObject.optString("appid");
            gy6Var.m = item.name;
            gy6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                gy6Var.c = (float) item.icon_ratio.doubleValue();
            }
            gy6Var.n = jSONObject.optString("apk_name");
            gy6Var.o = jSONObject.optString("version");
            gy6Var.p = jSONObject.optInt("version_code");
            gy6Var.q = jSONObject.optLong("size");
            gy6Var.r = item.button_link;
            gy6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                gy6Var.f = (float) item.score.doubleValue();
            }
            gy6Var.g = item.tags;
            gy6Var.s = jSONObject.optString("developer");
            gy6Var.t = jSONObject.optString("publisher");
            gy6Var.u = jSONObject.optString("authority_url");
            gy6Var.v = jSONObject.optString("privacy_url");
            gy6Var.w = jSONObject.optInt("pkg_source");
            gy6Var.h = item.button_name;
            gy6Var.a = j;
            gy6Var.k = forumName;
            t07 t07Var = new t07();
            t07Var.a = tid;
            t07Var.b = pageFrom;
            return new mx6(gy6Var, t07Var, false, 4, null);
        }
        return (mx6) invokeCommon.objValue;
    }

    public static final qx6 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            ez6 ez6Var = new ez6();
            ez6Var.a = j;
            ez6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                ez6Var.c = (float) item.icon_ratio.doubleValue();
            }
            ez6Var.d = item.name;
            ez6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                ez6Var.f = (float) item.score.doubleValue();
            }
            ez6Var.g = item.tags;
            ez6Var.h = item.button_name;
            ez6Var.i = item.button_link;
            ez6Var.k = forumName;
            u07 u07Var = new u07();
            u07Var.a = tid;
            u07Var.b = pageFrom;
            return new qx6(ez6Var, u07Var, false, 4, null);
        }
        return (qx6) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<s17<?>> dataList, uy6 feedExtraData) {
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
            z07.a aVar = z07.a;
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
            long g = gg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            v17 v17Var = feedExtraData.d().get(PageInfo.KEY);
            if (v17Var == null || (a = v17Var.a(new hy6())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new t17(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new t17(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
