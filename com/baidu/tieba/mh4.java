package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ze4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mh4 {
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
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PHONE_BRAND);
            if (optJSONObject2 != null) {
                pMSAppInfo.brandsInfo = optJSONObject2.toString();
            }
            qb4.b().k(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("scope_list");
            boolean z = false;
            if (jSONObject.optInt("service_degrade", 0) != 0) {
                z = true;
            }
            qb4.b().s(pMSAppInfo, optJSONObject3, z);
            pMSAppInfo.webUrl = jSONObject.optString("web_url");
            pMSAppInfo.rank = jSONObject.optInt("rank");
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

    public static ad4 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (ad4) j(jSONObject, new ad4());
        }
        return (ad4) invokeL.objValue;
    }

    public static cd4 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (cd4) j(jSONObject, new cd4());
        }
        return (cd4) invokeL.objValue;
    }

    public static bf4 h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            bf4 bf4Var = new bf4();
            bf4Var.a = o(jSONObject);
            return bf4Var;
        }
        return (bf4) invokeL.objValue;
    }

    public static gd4 o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            gd4 gd4Var = new gd4();
            j(jSONObject, gd4Var);
            long optLong = jSONObject.optLong("max_age");
            if (optLong < 0) {
                optLong = 0;
            }
            gd4Var.o = optLong;
            return gd4Var;
        }
        return (gd4) invokeL.objValue;
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

    public static ye4 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ye4 ye4Var = new ye4();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            List<gd4> l = l(optJSONArray);
            ye4Var.c = l;
            if (l != null && l.contains(null)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                k(ye4Var, optJSONArray);
            } else {
                ye4Var.a = 0;
            }
            return ye4Var;
        }
        return (ye4) invokeL.objValue;
    }

    public static ed4 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ed4 ed4Var = (ed4) j(jSONObject, new ed4());
            ed4Var.o = jSONObject.optInt("pkg_type");
            ed4Var.p = jSONObject.optString("ext");
            return ed4Var;
        }
        return (ed4) invokeL.objValue;
    }

    public static df4 q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            df4 df4Var = new df4();
            df4Var.a = jSONObject.optLong("max_age");
            long optLong = jSONObject.optLong("lastsynctime");
            if (optLong > 0) {
                lg4.c = optLong;
            }
            df4Var.b = jSONObject;
            return df4Var;
        }
        return (df4) invokeL.objValue;
    }

    public static ze4 f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ze4 ze4Var = new ze4();
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ze4.a aVar = new ze4.a();
                    aVar.a = optJSONObject.optInt("errno");
                    aVar.b = optJSONObject.optString("bundle_id");
                    aVar.c = optJSONObject.optInt("category");
                    aVar.d = m(optJSONObject.optJSONObject("main"));
                    aVar.e = n(optJSONObject.optJSONArray("sub"));
                    aVar.f = l(optJSONObject.optJSONArray("dep"));
                    aVar.g = a(optJSONObject.optJSONObject("app_info"));
                    qb4.b().p(aVar.b, optJSONObject, aVar.d, aVar.e);
                    arrayList.add(aVar);
                }
            }
            ze4Var.a = arrayList;
            return ze4Var;
        }
        return (ze4) invokeL.objValue;
    }

    public static af4 g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            af4 af4Var = new af4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                af4Var.a = m(optJSONObject.optJSONObject("main"));
                af4Var.b = n(optJSONObject.optJSONArray("sub"));
                af4Var.c = l(optJSONObject.optJSONArray("dep"));
                qb4.b().p(str, optJSONObject, af4Var.a, af4Var.b);
            }
            af4Var.d = d(jSONObject.optJSONObject("framework"));
            af4Var.f = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            af4Var.e = a(jSONObject.optJSONObject("app_info"));
            return af4Var;
        }
        return (af4) invokeLL.objValue;
    }

    public static cf4 i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            cf4 cf4Var = new cf4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                cf4Var.a = n(optJSONObject.optJSONArray("sub"));
                qb4.b().p(str, optJSONObject, null, cf4Var.a);
            }
            return cf4Var;
        }
        return (cf4) invokeLL.objValue;
    }

    public static void k(ye4 ye4Var, JSONArray jSONArray) {
        int optInt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65546, null, ye4Var, jSONArray) != null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("errno", 0)) != 0) {
                String optString = optJSONObject.optString("bundle_id");
                ye4Var.a = optInt;
                ye4Var.b = String.format("%s : Not Exist.", optString);
                return;
            }
        }
    }

    public static <T extends dd4> T j(JSONObject jSONObject, T t) {
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

    public static List<gd4> l(JSONArray jSONArray) {
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
                    gd4 o = o(optJSONObject2);
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

    public static List<fd4> n(JSONArray jSONArray) {
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
                fd4 fd4Var = (fd4) j(optJSONObject, new fd4());
                fd4Var.q = optJSONObject.optInt("pkg_type");
                fd4Var.p = optJSONObject.optString("sub_path");
                fd4Var.r = optJSONObject.optBoolean("independent");
                fd4Var.s = optJSONObject.optString("ext");
                arrayList.add(fd4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
