package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.m27;
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
public final class j17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final zy6 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            tz6 tz6Var = new tz6();
            tz6Var.l = jSONObject.optString("appid");
            tz6Var.m = item.name;
            tz6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                tz6Var.c = (float) item.icon_ratio.doubleValue();
            }
            tz6Var.n = jSONObject.optString("apk_name");
            tz6Var.o = jSONObject.optString("version");
            tz6Var.p = jSONObject.optInt("version_code");
            tz6Var.q = jSONObject.optLong("size");
            tz6Var.r = item.button_link;
            tz6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                tz6Var.f = (float) item.score.doubleValue();
            }
            tz6Var.g = item.tags;
            tz6Var.s = jSONObject.optString("developer");
            tz6Var.t = jSONObject.optString("publisher");
            tz6Var.u = jSONObject.optString("authority_url");
            tz6Var.v = jSONObject.optString("privacy_url");
            tz6Var.w = jSONObject.optInt("pkg_source");
            tz6Var.h = item.button_name;
            tz6Var.a = j;
            tz6Var.k = forumName;
            g27 g27Var = new g27();
            g27Var.a = tid;
            g27Var.b = pageFrom;
            return new zy6(tz6Var, g27Var, false, 4, null);
        }
        return (zy6) invokeCommon.objValue;
    }

    public static final dz6 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            r07 r07Var = new r07();
            r07Var.a = j;
            r07Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                r07Var.c = (float) item.icon_ratio.doubleValue();
            }
            r07Var.d = item.name;
            r07Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                r07Var.f = (float) item.score.doubleValue();
            }
            r07Var.g = item.tags;
            r07Var.h = item.button_name;
            r07Var.i = item.button_link;
            r07Var.k = forumName;
            h27 h27Var = new h27();
            h27Var.a = tid;
            h27Var.b = pageFrom;
            return new dz6(r07Var, h27Var, false, 4, null);
        }
        return (dz6) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<f37<?>> dataList, h07 feedExtraData) {
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
            m27.a aVar = m27.a;
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
            long g = pg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            i37 i37Var = feedExtraData.d().get(PageInfo.KEY);
            if (i37Var == null || (a = i37Var.a(new uz6())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new g37(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new g37(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
