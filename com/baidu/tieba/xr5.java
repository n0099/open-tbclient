package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ir4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public class xr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (!xi.isEmpty(str) && str.indexOf("cuid=") <= -1) {
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
                    sb.append("&c3_aid=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGalaxy3());
                    sb.append("&cuid_gid=");
                    sb.append(TbadkCoreApplication.getInst().getCuidGid());
                }
                sb.append("&timestamp=");
                sb.append(System.currentTimeMillis());
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!xi.isEmpty(str) && str.indexOf("_client_version=") > -1) {
                return str;
            }
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return (String) invokeL.objValue;
    }

    public static void c(Context context) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            ir4.b c = ir4.b().c(TbadkCoreApplication.getCurrentBduss());
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
            if (c != null) {
                cookieManager.setAcceptCookie(true);
                cookieManager.setCookie(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE, "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com; cuid_galaxy2=" + TbadkCoreApplication.getInst().getCuidGalaxy2() + "; c3_aid=" + TbadkCoreApplication.getInst().getCuidGalaxy3() + "; cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
                String a = hr4.a(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(a)) {
                    sb.append("STOKEN=");
                    sb.append(a);
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
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
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

    public static void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        new PvThread("open_webview", true).start();
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            String b = b(a(str));
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(b));
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void g(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, str, str2, bundle) == null) {
            h(context, str2, str, true, true, true, bundle);
        }
    }

    public static void h(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle}) == null) {
            e();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdWebViewActivityConfig(context, str, str2, z, z2, z3, bundle)));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
