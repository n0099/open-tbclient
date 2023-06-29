package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (!z && u04.b() != null) {
                TreeMap treeMap = new TreeMap();
                treeMap.put("ver", v14.l());
                treeMap.put("host", u04.b().a());
                treeMap.put("os", "android");
                int c = NetworkUtils.c(false);
                treeMap.put("net", c + "");
                treeMap.put("phone", v14.e());
                treeMap.put("osV", v14.f());
                treeMap.put("slot", str);
                treeMap.put("flow", str2);
                treeMap.put("appid", str3);
                treeMap.put("apid", str4);
                treeMap.put("sdk", u04.b().getSdkVersion());
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
            return t14.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, t04 t04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, t04Var) == null) {
            t04Var.e(str);
        }
    }

    public static void g(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            d(e(str, 0, 0), t04Var);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, map, str) == null) {
            l(map, str, new c14(AppRuntime.getAppContext()));
        }
    }

    public static void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            n(str, map, new c14(AppRuntime.getAppContext()));
        }
    }

    public static void p(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getSkipTrackers()) {
            d(e(str, 0, 0), t04Var);
        }
    }

    public static void q(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getStartTrackers()) {
            d(e(str, 0, 0), t04Var);
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

    public static void f(String str, String str2, String str3, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, t04Var) == null) && u04.b() != null && !v14.o()) {
            String a = u04.b().a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizId", 10003);
                jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
                jSONObject.put("containerAppName", a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("distribute_channel", 38);
                jSONObject2.put("CTK", str3);
                jSONObject2.put("logtype", 2);
                jSONObject2.put("media_id", str);
                jSONObject2.put("PVID", str3);
                jSONObject2.put("tuid", str2);
                jSONObject2.put("time", v14.j());
                jSONObject2.put("page_type", 1);
                jSONObject2.put("traffic_type", 1);
                jSONObject.put("content", jSONObject2);
                t04Var.d(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void h(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String a = t14.a(t14.a(t14.c(str, hashSet), BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE"), "da_type", WorkPostNotifyFlutterData.FAIL_POST);
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), t04Var);
        }
        d(adElementInfo.getClickUrl(), t04Var);
    }

    public static void i(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String c = t14.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.getEndFrameUrl())) {
                c = t14.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.getEndFrameHtml())) {
                c = t14.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL");
            }
            String a = t14.a(c, "da_type", "103");
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), t04Var);
        }
    }

    public static void j(AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, adElementInfo, t04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            d(e(str, 0, 0), t04Var);
        }
        for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
            d(e(str2, 0, 0), t04Var);
        }
    }

    public static void l(@Nullable Map<String, String> map, String str, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65547, null, map, str, t04Var) != null) || map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put(StatConstants.KEY_EXT_ERR_CODE, str);
            treeMap.put(StatConstants.KEY_EXT_ERR_MSG, p14.a(str));
        }
        n("error", treeMap, t04Var);
    }

    public static void n(String str, Map<String, String> map, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65549, null, str, map, t04Var) != null) || map == null) {
            return;
        }
        d(b(str, map), t04Var);
    }

    public static void o(int i, int i2, AdElementInfo adElementInfo, t04 t04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), adElementInfo, t04Var}) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            d(e(str, i, i2), t04Var);
        }
    }
}
