package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ud1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                JSONObject optJSONObject2 = new JSONObject(str).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject2 != null && optJSONObject2.has(SpeedStatsUtils.UBC_VALUE_SPLASH) && (optJSONObject = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH)) != null && optJSONObject.has("src_ext_info")) {
                    return new JSONObject(optJSONObject.optString("src_ext_info")).has("query_ret_code");
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                JSONObject optJSONObject2 = new JSONObject(str).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject2 == null || !optJSONObject2.has(SpeedStatsUtils.UBC_VALUE_SPLASH) || (optJSONObject = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH)) == null) {
                    return 0;
                }
                if (TextUtils.isEmpty(optJSONObject.optString("ukey"))) {
                    if (optJSONObject.optInt("isCPC") == 1) {
                        return 3;
                    }
                    return optJSONObject.optInt("realTimeLoading") == 1 ? 2 : 0;
                }
                return 1;
            } catch (JSONException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static List<be1> c(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<be1> j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (j = be1.j(jSONArray)) == null || j.size() == 0) {
                return null;
            }
            if (z) {
                for (be1 be1Var : j) {
                    be1Var.y = true;
                    if (ae1.r()) {
                        zd1.k(be1Var);
                    }
                }
            } else {
                HashMap<String, be1> u = zd1.u();
                if (u != null && u.size() != 0) {
                    zd1.j(j);
                    zd1.E(j);
                } else {
                    zd1.E(j);
                }
                zd1.B(j);
            }
            yd1.m().g();
            return j;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<be1> d(String str, String str2) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return e(new JSONObject(str), str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    throw new ParseError(1, "afd/entry retun invalid json");
                }
            }
            throw new ParseError(1, "afd/entry retun null");
        }
        return (List) invokeLL.objValue;
    }

    public static List<be1> e(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            List<be1> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                if (jSONObject.optInt("errno", 0) <= 0 && (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(LaunchStatsUtils.AD);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("cmd");
                        SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                        ae1.J(optJSONObject2.optString("src_ext_info"));
                        if (TextUtils.equals("update", optString)) {
                            ae1.I(optJSONObject2.optString("src_ext_info"));
                            arrayList = c(optJSONArray, str, false);
                            String optString2 = optJSONObject2.optString("empty_ext_info");
                            if (!TextUtils.isEmpty(optString2)) {
                                e01.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
                            }
                        } else if (TextUtils.equals("query", optString)) {
                            int optInt = optJSONObject2.optInt("realTimeLoading");
                            int optInt2 = optJSONObject2.optInt("isCPC");
                            if (optInt != 1 && optInt2 != 1) {
                                String optString3 = optJSONObject2.optString("ukey");
                                if (TextUtils.isEmpty(optString3)) {
                                    BaseVM.h(32);
                                    return arrayList;
                                }
                                List<be1> x = zd1.x();
                                if (x == null) {
                                    return arrayList;
                                }
                                Iterator<be1> it = x.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    be1 next = it.next();
                                    if (TextUtils.equals(next.c, optString3)) {
                                        wz0.b(arrayList, next);
                                        break;
                                    }
                                }
                                if (arrayList.size() == 0) {
                                    BaseVM.h(64);
                                }
                            } else {
                                List<be1> c = c(optJSONArray, str, true);
                                if (c == null || c.size() == 0) {
                                    BaseVM.h(128);
                                }
                                arrayList = c;
                            }
                            if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                                arrayList.get(0).D = optInt == 1 ? 1 : 0;
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
