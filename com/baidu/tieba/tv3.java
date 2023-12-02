package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (!z && cv3.b() != null) {
                TreeMap treeMap = new TreeMap();
                treeMap.put("ver", dw3.l());
                treeMap.put("host", cv3.b().a());
                treeMap.put("os", "android");
                int c = NetworkUtils.c(false);
                treeMap.put("net", c + "");
                treeMap.put("phone", dw3.e());
                treeMap.put("osV", dw3.f());
                treeMap.put("slot", str);
                treeMap.put("flow", str2);
                treeMap.put("appid", str3);
                treeMap.put(IAdInterListener.AdReqParam.APID, str4);
                treeMap.put("sdk", cv3.b().getSdkVersion());
                treeMap.put("time", "" + System.currentTimeMillis());
                return treeMap;
            }
            return null;
        }
        return (Map) invokeCommon.objValue;
    }

    public static String b(String str, @Nullable Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (map == null) {
                return "https://mobads-logs.baidu.com/dz.zb?type=mnp&";
            }
            map.put("name", str);
            return bw3.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, bv3Var) == null) {
            bv3Var.e(str);
        }
    }

    public static void g(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            d(e(str, 0, 0), bv3Var);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, map, str) == null) {
            l(map, str, new kv3(AppRuntime.getAppContext()));
        }
    }

    public static void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            n(str, map, new kv3(AppRuntime.getAppContext()));
        }
    }

    public static void p(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getSkipTrackers()) {
            d(e(str, 0, 0), bv3Var);
        }
    }

    public static void q(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getStartTrackers()) {
            d(e(str, 0, 0), bv3Var);
        }
    }

    public static String c(@NonNull Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            return map.get("flow");
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2)) == null) {
            String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
            String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i);
            return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
        }
        return (String) invokeLII.objValue;
    }

    public static void f(String str, String str2, String str3, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, bv3Var) == null) && cv3.b() != null && !dw3.o()) {
            String a = cv3.b().a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizId", 10003);
                jSONObject.put("groupId", 10003);
                jSONObject.put("containerAppName", a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("distribute_channel", 38);
                jSONObject2.put("CTK", str3);
                jSONObject2.put(LokiService.Constant.LOG_TYPE, 2);
                jSONObject2.put("media_id", str);
                jSONObject2.put("PVID", str3);
                jSONObject2.put("tuid", str2);
                jSONObject2.put("time", dw3.j());
                jSONObject2.put("page_type", 1);
                jSONObject2.put("traffic_type", 1);
                jSONObject.put("content", jSONObject2);
                bv3Var.d(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void h(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String a = bw3.a(bw3.a(bw3.c(str, hashSet), BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE"), "da_type", WorkPostNotifyFlutterData.FAIL_POST);
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), bv3Var);
        }
        d(adElementInfo.getClickUrl(), bv3Var);
    }

    public static void i(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String c = bw3.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.getEndFrameUrl())) {
                c = bw3.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.getEndFrameHtml())) {
                c = bw3.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL");
            }
            String a = bw3.a(c, "da_type", "103");
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), bv3Var);
        }
    }

    public static void j(AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, adElementInfo, bv3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            d(e(str, 0, 0), bv3Var);
        }
        for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
            d(e(str2, 0, 0), bv3Var);
        }
    }

    public static void l(@Nullable Map<String, String> map, String str, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65547, null, map, str, bv3Var) != null) || map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put(StatConstants.KEY_EXT_ERR_CODE, str);
            treeMap.put(StatConstants.KEY_EXT_ERR_MSG, xv3.a(str));
        }
        n("error", treeMap, bv3Var);
    }

    public static void n(String str, Map<String, String> map, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65549, null, str, map, bv3Var) != null) || map == null) {
            return;
        }
        d(b(str, map), bv3Var);
    }

    public static void o(int i, int i2, AdElementInfo adElementInfo, bv3 bv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), adElementInfo, bv3Var}) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            d(e(str, i, i2), bv3Var);
        }
    }
}
