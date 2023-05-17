package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ak4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PMSAppInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appKey = jSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
            pMSAppInfo.appName = jSONObject.optString("app_name");
            pMSAppInfo.description = jSONObject.optString("app_desc");
            pMSAppInfo.appStatus = jSONObject.optInt("app_status");
            pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
            pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
            pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
            pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
            pMSAppInfo.maxAge = jSONObject.optLong("max_age");
            pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
            pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
            pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
            pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
            pMSAppInfo.domainConfig = jSONObject.optString("domain_config");
            pMSAppInfo.webAction = jSONObject.optString("web_action");
            pMSAppInfo.domains = jSONObject.optString("domains");
            pMSAppInfo.serverExt = jSONObject.optString("ext");
            pMSAppInfo.appSign = jSONObject.optLong("app_sign");
            pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
            pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
            pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.paNumber = jSONObject.optString("pa_number");
            String optString = p(pMSAppInfo.serverExt).optString("quick_app_key");
            if (!TextUtils.isEmpty(optString)) {
                pMSAppInfo.quickAppKey = optString;
            }
            JSONObject optJSONObject = p(pMSAppInfo.serverExt).optJSONObject(SwanAppBearInfo.BEAR_INFO);
            if (optJSONObject != null) {
                pMSAppInfo.bearInfo = optJSONObject.toString();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
            if (optJSONArray != null) {
                pMSAppInfo.pluginInfo = optJSONArray.toString();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("brand");
            if (optJSONObject2 != null) {
                pMSAppInfo.brandsInfo = optJSONObject2.toString();
            }
            rg4.b().k(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("scope_list");
            boolean z = false;
            if (jSONObject.optInt("service_degrade", 0) != 0) {
                z = true;
            }
            rg4.b().s(pMSAppInfo, optJSONObject3, z);
            pMSAppInfo.webUrl = jSONObject.optString("web_url");
            pMSAppInfo.rank = jSONObject.optInt(MultiRatePlayUrlHelper.RANK);
            pMSAppInfo.webPermit = jSONObject.optInt("web_permit");
            pMSAppInfo.csProtocolVersion = PMSConstants.a.a();
            pMSAppInfo.userActionApis = jSONObject.optString("user_action_apis");
            return pMSAppInfo;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public static boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null || 1 != jSONObject.optInt("reset_env", 0)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static bi4 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (bi4) j(jSONObject, new bi4());
        }
        return (bi4) invokeL.objValue;
    }

    public static di4 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (di4) j(jSONObject, new di4());
        }
        return (di4) invokeL.objValue;
    }

    public static ck4 h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ck4 ck4Var = new ck4();
            ck4Var.a = o(jSONObject);
            return ck4Var;
        }
        return (ck4) invokeL.objValue;
    }

    public static hi4 o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            hi4 hi4Var = new hi4();
            j(jSONObject, hi4Var);
            long optLong = jSONObject.optLong("max_age");
            if (optLong < 0) {
                optLong = 0;
            }
            hi4Var.o = optLong;
            return hi4Var;
        }
        return (hi4) invokeL.objValue;
    }

    public static JSONObject p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static zj4 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            zj4 zj4Var = new zj4();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            List<hi4> l = l(optJSONArray);
            zj4Var.c = l;
            if (l != null && l.contains(null)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                k(zj4Var, optJSONArray);
            } else {
                zj4Var.a = 0;
            }
            return zj4Var;
        }
        return (zj4) invokeL.objValue;
    }

    public static fi4 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            fi4 fi4Var = (fi4) j(jSONObject, new fi4());
            fi4Var.o = jSONObject.optInt("pkg_type");
            fi4Var.p = jSONObject.optString("ext");
            return fi4Var;
        }
        return (fi4) invokeL.objValue;
    }

    public static ek4 q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ek4 ek4Var = new ek4();
            ek4Var.a = jSONObject.optLong("max_age");
            long optLong = jSONObject.optLong("lastsynctime");
            if (optLong > 0) {
                ml4.c = optLong;
            }
            ek4Var.b = jSONObject;
            return ek4Var;
        }
        return (ek4) invokeL.objValue;
    }

    public static ak4 f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ak4 ak4Var = new ak4();
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ak4.a aVar = new ak4.a();
                    aVar.a = optJSONObject.optInt("errno");
                    aVar.b = optJSONObject.optString("bundle_id");
                    aVar.c = optJSONObject.optInt("category");
                    aVar.d = m(optJSONObject.optJSONObject("main"));
                    aVar.e = n(optJSONObject.optJSONArray("sub"));
                    aVar.f = l(optJSONObject.optJSONArray("dep"));
                    aVar.g = a(optJSONObject.optJSONObject("app_info"));
                    rg4.b().p(aVar.b, optJSONObject, aVar.d, aVar.e);
                    arrayList.add(aVar);
                }
            }
            ak4Var.a = arrayList;
            return ak4Var;
        }
        return (ak4) invokeL.objValue;
    }

    public static bk4 g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            bk4 bk4Var = new bk4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                bk4Var.a = m(optJSONObject.optJSONObject("main"));
                bk4Var.b = n(optJSONObject.optJSONArray("sub"));
                bk4Var.c = l(optJSONObject.optJSONArray("dep"));
                rg4.b().p(str, optJSONObject, bk4Var.a, bk4Var.b);
            }
            bk4Var.d = d(jSONObject.optJSONObject("framework"));
            bk4Var.f = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            bk4Var.e = a(jSONObject.optJSONObject("app_info"));
            return bk4Var;
        }
        return (bk4) invokeLL.objValue;
    }

    public static dk4 i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            dk4 dk4Var = new dk4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                dk4Var.a = n(optJSONObject.optJSONArray("sub"));
                rg4.b().p(str, optJSONObject, null, dk4Var.a);
            }
            return dk4Var;
        }
        return (dk4) invokeLL.objValue;
    }

    public static void k(zj4 zj4Var, JSONArray jSONArray) {
        int optInt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65546, null, zj4Var, jSONArray) != null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("errno", 0)) != 0) {
                String optString = optJSONObject.optString("bundle_id");
                zj4Var.a = optInt;
                zj4Var.b = String.format("%s : Not Exist.", optString);
                return;
            }
        }
    }

    public static <T extends ei4> T j(JSONObject jSONObject, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, t)) == null) {
            if (jSONObject != null && t != null) {
                t.g = jSONObject.optString("bundle_id");
                t.h = jSONObject.optInt("category");
                t.j = jSONObject.optString("version_name");
                t.i = jSONObject.optLong("version_code");
                t.k = jSONObject.optLong("size");
                t.l = jSONObject.optString(PackageTable.MD5);
                t.m = jSONObject.optString("sign");
                t.n = jSONObject.optString("download_url");
                return t;
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public static List<hi4> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("main");
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("app_info");
                    hi4 o = o(optJSONObject2);
                    if (o != null && optJSONObject3 != null) {
                        o.r = optJSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        o.s = optJSONObject3.optString("app_name");
                        o.q = optJSONObject3.optString("domains");
                    }
                    arrayList.add(o);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<gi4> n(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                gi4 gi4Var = (gi4) j(optJSONObject, new gi4());
                gi4Var.q = optJSONObject.optInt("pkg_type");
                gi4Var.p = optJSONObject.optString("sub_path");
                gi4Var.r = optJSONObject.optBoolean("independent");
                gi4Var.s = optJSONObject.optString("ext");
                arrayList.add(gi4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
