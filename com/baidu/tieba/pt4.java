package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.nw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.util.Base64Encoder;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
/* loaded from: classes6.dex */
public class pt4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948073561, "Lcom/baidu/tieba/pt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948073561, "Lcom/baidu/tieba/pt4;");
                return;
            }
        }
        a = new String[]{"/mo/q/priforum/create/info", "/mo/q/forumtarget"};
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65555, null) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        new PvThread("open_webview", true).start();
    }

    public static void A(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            B(context, str, str2, z, z2, z3, z4, z5, z6, false);
        }
    }

    public static void B(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            C(context, str, str2, z, z2, z3, z4, z5, z6, z7, false, null);
        }
    }

    public static void C(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Bundle bundle) {
        boolean z9;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), bundle}) == null) {
            m();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                if (bundle != null && !bundle.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) {
                    z9 = false;
                } else {
                    z9 = z5;
                }
                if (z9) {
                    str3 = c(f(d(str2)));
                } else {
                    str3 = str2;
                }
                TbWebViewActivityConfig h = h(context, str, str3, z, z2, z3);
                h.setNeedImmerSiveSticky(z6);
                h.setFixTitle(z7);
                h.setAutoPlay(z8);
                h.setBundle(bundle);
                if (bundle != null) {
                    if (bundle.getBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false)) {
                        h.setTextAutoSize(true);
                    }
                    String string = bundle.getString(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT, "");
                    if (!TextUtils.isEmpty(string)) {
                        h.setPageTranslucent(string);
                    }
                    if (bundle.getBoolean(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false)) {
                        h.setTranslucentAutoClose(true);
                    }
                    String string2 = bundle.getString(WebViewActivityConfig.TAG_WEB_DIALOG_NAME, "");
                    if (!TextUtils.isEmpty(string2)) {
                        h.setWebDialogName(string2);
                    }
                    if ("1".equals(bundle.getString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE))) {
                        h.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        h.setLoadingSwitch(1);
                        h.setLoadingStyle(1);
                    }
                }
                if (c) {
                    h.setUseCustomHistoryStack(true);
                    c = false;
                }
                if (bundle != null && bundle.getBoolean(WebViewActivityConfig.FROM_SCHEMA)) {
                    h.setIsFromSchema(true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, h));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void D(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            z(context, "", str, true, true, true, true, z);
        }
    }

    public static void t(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, context, str, str2) == null) {
            z(context, str, str2, true, true, true, true, true);
        }
    }

    public static void E(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            z(context, str2, str, true, true, true, true, z);
        }
    }

    public static void F(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), context, str, str2}) == null) {
            B(context, str, str2, true, true, true, true, true, false, z);
        }
    }

    public static TbWebViewActivityConfig g(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            return h(context, str, str2, true, z, true);
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static void v(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            z(context, str, str2, true, z, true, true, true);
        }
    }

    public static void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, webSettings) == null) {
            CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return tf6.e(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            for (String str2 : a) {
                if (str2.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            b = str;
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!k(str) && !hi.isEmpty(str) && str.contains("_client_type=")) {
                return str;
            }
            return str + "&_client_type=2";
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (!hi.isEmpty(str) && str.indexOf("_client_version=") > -1) {
                return str;
            }
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (!hi.isEmpty(str) && str.indexOf("cuid=") <= -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (str.indexOf("?") > 0) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                if (!UtilHelper.isNativeAdURL(str)) {
                    sb.append("cuid=");
                    sb.append(TbadkCoreApplication.getInst().getCuid());
                    sb.append("&cuid_galaxy2=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    sb.append("&cuid_gid=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGid());
                }
                sb.append("&timestamp=");
                sb.append(Long.toString(System.currentTimeMillis()));
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, list)) == null) {
            if (!hi.isEmpty(str) && list != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (str.indexOf("?") < 0) {
                    sb.append("?");
                }
                for (Pair<String, String> pair : list) {
                    if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                        sb.append("&");
                        sb.append((String) pair.first);
                        sb.append("=");
                        sb.append((String) pair.second);
                    }
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static TbWebViewActivityConfig h(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            Context context2 = context;
            if (b(str2)) {
                rf6.c(str2);
                return new TbWebContainerActivityConfig(context2, str, str2, z, z2, z3);
            }
            return new TbWebViewActivityConfig(context2, str, str2, z, z2, z3);
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static String i() {
        CookieManager cookieManager;
        String[] split;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager == null) {
                return "";
            }
            String cookie = cookieManager.getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = b;
            }
            if (cookie == null) {
                return "";
            }
            for (String str : cookie.split(ParamableElem.DIVIDE_PARAM)) {
                if (str.contains("BAIDUID=")) {
                    return str.trim().substring(8);
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void j(Context context) {
        CookieManager cookieManager;
        nw4.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            try {
                CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                BdLog.e(th);
                cookieManager = null;
            }
            if (cookieManager == null) {
                return;
            }
            cookieManager.setAcceptCookie(true);
            if (nw4.b() != null) {
                bVar = nw4.b().c(TbadkCoreApplication.getCurrentBduss());
            } else {
                bVar = null;
            }
            if (bVar != null) {
                String a2 = mw4.a(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(a2)) {
                    sb.append("STOKEN=");
                    sb.append(a2);
                    sb.append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.removeAllCookies(null);
                        CookieManager.getInstance().flush();
                    } else {
                        cookieManager.removeAllCookie();
                        CookieSyncManager.createInstance(context);
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie(".baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + ParamableElem.DIVIDE_PARAM);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                str = new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes()));
            } else {
                str = "";
            }
            cookieManager.setCookie(".baidu.com", "BAIDUCUID=" + str + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", "need_cookie_decrypt=0" + ParamableElem.DIVIDE_PARAM);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TBBRAND");
            sb2.append("=");
            sb2.append(ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", sb2.toString());
            cookieManager.setCookie(".baidu.com", "DNARBBT=" + ParamableElem.DIVIDE_PARAM);
            if (dc9.b()) {
                cookieManager.setCookie(".baidu.com", "TBBRAND=" + ki.g() + ParamableElem.DIVIDE_PARAM);
            } else {
                cookieManager.setCookie(".baidu.com", "need_cookie_decrypt=" + dc9.c() + ParamableElem.DIVIDE_PARAM);
                String d = dc9.d("TBBRAND");
                if (!TextUtils.isEmpty(d)) {
                    cookieManager.setCookie(".baidu.com", d + "=" + dc9.e() + ParamableElem.DIVIDE_PARAM);
                }
            }
            cookieManager.setCookie(".baidu.com", "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti() + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", "cuid_galaxy2=" + cuidGalaxy2 + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie(".baidu.com", "BDUSS=" + TbadkCoreApplication.getCurrentBduss() + ParamableElem.DIVIDE_PARAM + "HttpOnly");
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
                SapiAccountManager.getInstance().getAccountService().webLogin(context);
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
        }
    }

    public static String l(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                str = "http://".concat(str);
            }
            if (str.contains("?")) {
                str3 = "&st_type=" + str2;
            } else {
                str3 = "?st_type=" + str2;
            }
            return str.concat(str3);
        }
        return (String) invokeLL.objValue;
    }

    public static void o(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, str) == null) {
            p(context, str, true);
        }
    }

    public static void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, str) == null) {
            s(context, str);
        }
    }

    public static void r(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, uri) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context);
            tbWebViewActivityConfig.setUri(uri);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public static void s(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, context, str) == null) {
            D(context, true, str);
        }
    }

    public static void p(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65558, null, context, str, z) == null) {
            if (z) {
                str = f(d(str));
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void u(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, null, context, str, str2, bundle) == null) {
            C(context, str, str2, true, true, true, true, true, false, false, false, bundle);
        }
    }

    public static void w(Context context, String str, String str2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, str, str2, Boolean.valueOf(z), bundle}) == null) {
            C(context, str, str2, true, z, true, true, true, false, false, false, bundle);
        }
    }

    public static void x(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            z(context, str, str2, z, z2, z3, true, true);
        }
    }

    public static void y(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle}) == null) {
            C(context, str, str2, z, z2, z3, true, true, false, false, false, bundle);
        }
    }

    public static void z(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            B(context, str, str2, z, z2, z3, z4, z5, false, false);
        }
    }
}
