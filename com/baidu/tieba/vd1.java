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
public class vd1 {
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

    public static List c(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<ce1> j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (j = ce1.j(jSONArray)) == null || j.size() == 0) {
                return null;
            }
            if (z) {
                for (ce1 ce1Var : j) {
                    ce1Var.y = true;
                    if (be1.r()) {
                        ae1.k(ce1Var);
                    }
                }
            } else {
                HashMap u = ae1.u();
                if (u != null && u.size() != 0) {
                    ae1.j(j);
                    ae1.E(j);
                } else {
                    ae1.E(j);
                }
                ae1.B(j);
            }
            zd1.m().g();
            return j;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List d(String str, String str2) throws ParseError {
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

    public static List e(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            List arrayList = new ArrayList();
            if (jSONObject != null) {
                int i = 0;
                if (jSONObject.optInt("errno", 0) > 0 || (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) == null) {
                    return null;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                JSONArray optJSONArray = optJSONObject.optJSONArray(LaunchStatsUtils.AD);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("cmd");
                    SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                    be1.J(optJSONObject2.optString("src_ext_info"));
                    if (TextUtils.equals("update", optString)) {
                        be1.I(optJSONObject2.optString("src_ext_info"));
                        arrayList = c(optJSONArray, str, false);
                        String optString2 = optJSONObject2.optString("empty_ext_info");
                        if (!TextUtils.isEmpty(optString2)) {
                            f01.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
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
                            List x = ae1.x();
                            if (x == null) {
                                return arrayList;
                            }
                            Iterator it = x.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ce1 ce1Var = (ce1) it.next();
                                if (TextUtils.equals(ce1Var.c, optString3)) {
                                    xz0.b(arrayList, ce1Var);
                                    break;
                                }
                            }
                            if (arrayList.size() == 0) {
                                BaseVM.h(64);
                            }
                        } else {
                            List c = c(optJSONArray, str, true);
                            if (c == null || c.size() == 0) {
                                BaseVM.h(128);
                            }
                            arrayList = c;
                        }
                        if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                            ce1 ce1Var2 = (ce1) arrayList.get(0);
                            if (optInt == 1) {
                                i = 1;
                            }
                            ce1Var2.D = i;
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
