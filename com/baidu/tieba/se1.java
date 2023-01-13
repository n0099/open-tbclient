package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class se1 {
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
                if (!TextUtils.isEmpty(optJSONObject.optString("ukey"))) {
                    return 1;
                }
                if (optJSONObject.optInt("isCPC") == 1) {
                    return 3;
                }
                if (optJSONObject.optInt("realTimeLoading") != 1) {
                    return 0;
                }
                return 2;
            } catch (JSONException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        ze1 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                JSONObject optJSONObject3 = new JSONObject(str).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject3 == null || !optJSONObject3.has(SpeedStatsUtils.UBC_VALUE_SPLASH) || (optJSONObject = optJSONObject3.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH)) == null) {
                    return "";
                }
                if (!TextUtils.isEmpty(optJSONObject.optString("ukey"))) {
                    ze1 p = xe1.p(optJSONObject.optString("ukey"));
                    if (p == null) {
                        return "";
                    }
                    return p.O;
                } else if (optJSONObject.optInt("isCPC") == 1 || optJSONObject.optInt("realTimeLoading") != 1 || (optJSONArray = optJSONObject3.optJSONArray("ad")) == null || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null || (c = ze1.c(optJSONObject2)) == null) {
                    return "";
                } else {
                    return c.O;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<ze1> d(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<ze1> k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (k = ze1.k(jSONArray)) == null || k.size() == 0) {
                return null;
            }
            if (z) {
                for (ze1 ze1Var : k) {
                    ze1Var.y = true;
                    if (ye1.s()) {
                        xe1.j(ze1Var);
                    }
                }
            } else {
                HashMap<String, ze1> t = xe1.t();
                if (t != null && t.size() != 0) {
                    xe1.i(k);
                    xe1.E(k);
                } else {
                    xe1.E(k);
                }
                xe1.B(k);
            }
            we1.m().g();
            return k;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<ze1> e(String str, String str2) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return f(new JSONObject(str), str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    throw new ParseError(1, "afd/entry retun invalid json");
                }
            }
            throw new ParseError(1, "afd/entry retun null");
        }
        return (List) invokeLL.objValue;
    }

    public static List<ze1> f(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            List<ze1> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                int i = 0;
                if (jSONObject.optInt("errno", 0) > 0 || (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) == null) {
                    return null;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("cmd");
                    SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                    ye1.K(optJSONObject2.optString("src_ext_info"));
                    if (TextUtils.equals(StickerDataChangeType.UPDATE, optString)) {
                        ye1.J(optJSONObject2.optString("src_ext_info"));
                        arrayList = d(optJSONArray, str, false);
                        String optString2 = optJSONObject2.optString("empty_ext_info");
                        if (!TextUtils.isEmpty(optString2)) {
                            b11.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
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
                            List<ze1> w = xe1.w();
                            if (w == null) {
                                return arrayList;
                            }
                            Iterator<ze1> it = w.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ze1 next = it.next();
                                if (TextUtils.equals(next.c, optString3)) {
                                    t01.b(arrayList, next);
                                    break;
                                }
                            }
                            if (arrayList.size() == 0) {
                                BaseVM.h(64);
                            }
                        } else {
                            List<ze1> d = d(optJSONArray, str, true);
                            if (d == null || d.size() == 0) {
                                BaseVM.h(128);
                            }
                            arrayList = d;
                        }
                        if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                            ze1 ze1Var = arrayList.get(0);
                            if (optInt == 1) {
                                i = 1;
                            }
                            ze1Var.D = i;
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
