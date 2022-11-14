package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static List<Pair<String, Pair<String, String>>> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948346423, "Lcom/baidu/tieba/yy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948346423, "Lcom/baidu/tieba/yy2;");
                return;
            }
        }
        boolean z = pk1.a;
        a = z;
        if (z) {
            ArrayList arrayList = new ArrayList();
            b = arrayList;
            arrayList.add(new Pair("总时长", new Pair("na_pms_start_req", "na_end_update_db")));
            b.add(new Pair<>("PMS信息获取时长", new Pair("na_pms_start_req", "na_pms_end_req")));
            b.add(new Pair<>("包下载时长", new Pair("na_pms_start_download", "na_pms_end_download")));
            b.add(new Pair<>("Icon下载时长", new Pair("na_pms_start_icon", "na_pms_end_icon")));
            b.add(new Pair<>("签名校验时长", new Pair("na_pms_start_check_sign", "na_pms_end_check_sign")));
            b.add(new Pair<>("包解压时长", new Pair("na_package_start_unzip", "na_package_end_unzip")));
            b.add(new Pair<>("包解密时长", new Pair("na_package_start_decrypt", "na_package_end_decrypt")));
            b.add(new Pair<>("更新数据库时长", new Pair("na_start_update_db", "na_end_update_db")));
        }
    }

    public static void a(String str, String str2, List<UbcFlowEvent> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, list, str3) == null) && !TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            la3 c = ya3.c("770");
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (ubcFlowEvent != null) {
                    ma3.e(c, ubcFlowEvent.a, ubcFlowEvent.j(), ubcFlowEvent.g());
                }
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", str2);
                jSONObject2.put("appid", str);
                jSONObject2.put("mobile", vg3.c());
                jSONObject2.put("net", SwanAppNetworkUtils.f().type);
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                jSONObject2.put("scene", str3);
                xa3.a(jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ma3.f(c, jSONObject.toString());
            ma3.c(c);
            b(str, list, b);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public static void b(String str, List<UbcFlowEvent> list, List<Pair<String, Pair<String, String>>> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, list, list2) == null) && a && list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("小程序PMS下载耗时Log：");
            sb.append("\n");
            sb.append("小程序ID：");
            sb.append(str);
            sb.append("\n");
            sb.append("小程序ID：");
            sb.append(str);
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (ubcFlowEvent != null) {
                    sb.append("\n");
                    sb.append(ubcFlowEvent.g());
                    sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                    sb.append(ubcFlowEvent.a);
                    hashMap.put(ubcFlowEvent.a, Long.valueOf(ubcFlowEvent.g()));
                }
            }
            sb.append("\n");
            sb.append("耗时计算开始：>>>>>>>>>>>>");
            for (Pair<String, Pair<String, String>> pair : list2) {
                if (pair != null) {
                    String str2 = (String) pair.first;
                    Object obj = pair.second;
                    String str3 = (String) ((Pair) obj).first;
                    String str4 = (String) ((Pair) obj).second;
                    if (hashMap.get(str3) != null && hashMap.get(str4) != null) {
                        long longValue = ((Long) hashMap.get(str3)).longValue();
                        String format = String.format(Locale.CHINA, "%-13d", Long.valueOf(((Long) hashMap.get(str4)).longValue() - longValue));
                        sb.append("\n");
                        sb.append("耗时：");
                        sb.append(format);
                        sb.append(" >>> ");
                        sb.append(str2);
                        sb.append("，计算方式：");
                        sb.append(str4);
                        sb.append(" - ");
                        sb.append(str3);
                    }
                }
            }
            Log.i("SwanAppPMS", sb.toString());
        }
    }
}
