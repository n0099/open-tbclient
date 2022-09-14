package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qe2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        String optString;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            y23 b0 = y23.b0();
            JSONObject jSONObject = new JSONObject();
            if (b0 != null) {
                jSONObject = b0.W().M();
            }
            return (jSONObject == null || (optString = jSONObject.optString("keyfeed")) == null || (indexOf = optString.indexOf("_")) < 0 || !TextUtils.equals("miniapp", optString.substring(0, indexOf))) ? "" : optString.substring(indexOf + 1);
        }
        return (String) invokeV.objValue;
    }

    public static Map<String, Object> b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GameGuideConfigInfo.KEY_APP_KEY, str);
            hashMap.put("op_type", str2);
            String a = a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("nid", a);
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, Object> c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GameGuideConfigInfo.KEY_APP_KEY, str);
            hashMap.put(QuickPersistConfigConst.KEY_SPLASH_SORT, Integer.valueOf(i));
            hashMap.put("op_type", "add");
            return hashMap;
        }
        return (Map) invokeLI.objValue;
    }
}
