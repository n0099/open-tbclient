package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.browser.proxy.OfflineBridgeData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ul6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az4 a;

    public ul6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void c() {
        az4 az4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (az4Var = this.a) != null) {
            az4Var.h();
            this.a = null;
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return "0".equals(Uri.parse(str).getQueryParameter("useOfflinePackage"));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return str + str2;
            }
            return str + str2 + "?" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public final void d(WebView webView, Uri uri, dm6 dm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, uri, dm6Var) == null) && !mn6.a(dm6Var.b) && webView != null) {
            if (this.a == null) {
                this.a = new az4();
            }
            Map<String, String> a = fk6.a(uri);
            Iterator<String> it = dm6Var.b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Uri parse = Uri.parse(next);
                for (String str : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                        next = next.replace(queryParameter, fk6.c(a, queryParameter));
                    }
                }
                OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
                offlineBridgeData.type = CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE;
                offlineBridgeData.url = next;
                offlineBridgeData.module = dm6Var.c;
                offlineBridgeData.begin = System.currentTimeMillis();
                az4 az4Var = this.a;
                if (az4Var != null) {
                    az4Var.j(webView, offlineBridgeData, null);
                }
            }
        }
    }

    public final void e(String str, String str2, boolean z, String str3, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), str3, str4}) == null) {
            uk6 a = uk6.a(HybridStatisticKey.KEY_OFFLINE_PACKAGE);
            a.c("obj_name", str3);
            a.c("obj_source", str);
            a.c("obj_locate", str2);
            a.c("obj_param1", str4);
            Pair[] pairArr = new Pair[2];
            if (z) {
                str5 = "1";
            } else {
                str5 = "0";
            }
            pairArr[0] = Pair.create("is_proxy", str5);
            pairArr[1] = Pair.create("is_new_hybrid", "1");
            a.c(TiebaStatic.Params.OBJ_PARAM2, pn6.a(pairArr));
            a.d();
        }
    }

    public final String f(WebView webView, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            Uri parse = Uri.parse(str);
            dm6 g = tl6.e().g(parse);
            if (g == null) {
                HybridLog.getInstance().e("Offline", "离线包匹配失败 rule不存在：" + str);
                e(str, "without_bundle", false, "", "");
                return null;
            }
            String p = sl6.n().p(g.c);
            if (TextUtils.isEmpty(g.c)) {
                str2 = "none";
            } else {
                str2 = g.c;
            }
            String str3 = str2;
            if (TextUtils.isEmpty(p)) {
                p = "0.0.0.0";
            }
            String str4 = p;
            if (!g.g) {
                if (!sl6.n().s()) {
                    HybridLog.getInstance().i("Offline", "接口未返回，启用旧的离线包：moduleName: " + str3 + " moduleVersion:" + str4 + " + url+" + str);
                    g.g = true;
                } else {
                    e(str, "processing_bundle", g.h, str3, str4);
                    HybridLog.getInstance().e("Offline", "离线包匹配失败 离线包不可用：" + str3 + " " + str4);
                    return null;
                }
            }
            String str5 = g.d;
            if (!TextUtils.isEmpty(str5) && !str5.endsWith(".html")) {
                str5 = g.d + ".html";
            }
            String str6 = str5;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str4)) {
                String str7 = sl6.n().m() + "/" + str3 + "/" + str4 + "/";
                File file = new File(str7, str6);
                if (!file.exists()) {
                    g.g = false;
                    e(str, "path_not_found", g.h, str3, str4);
                    HybridLog.getInstance().e("Offline", "离线包匹配失败 本地主html文件不存在：" + file);
                    return null;
                }
                g.g = true;
                g.e = "file://" + str7;
                tl6.e().a(rn6.c(str), g);
                if (!g.h && !mn6.a(g.b)) {
                    d(webView, parse, g);
                }
                e(str, "success", g.h, str3, str4);
                if (g.h) {
                    HybridLog.getInstance().i("Offline", "命中代理模式离线包：url: " + str);
                    return str;
                }
                return a(g.e, str6, parse.getQuery());
            }
            g.g = false;
            e(str, "config_error", g.h, str3, str4);
            HybridLog.getInstance().e("Offline", "离线包匹配失败 配置校验失败：" + str3 + " " + str6 + " " + str4);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public Pair<Boolean, String> g(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            if (!URLUtil.isAssetUrl(str) && !URLUtil.isFileUrl(str)) {
                if (!URLUtil.isNetworkUrl(str)) {
                    return Pair.create(Boolean.FALSE, str);
                }
                e(str, "start", false, "", "");
                if (!QuickWebViewSwitch.getInOn()) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("Offline", "离线包开关关闭：" + str);
                    tl6.e().h(str);
                    e(str, "close_offline", false, "", "");
                    return Pair.create(Boolean.FALSE, str);
                } else if (b(str)) {
                    tl6.e().h(str);
                    TbLog hybridLog2 = HybridLog.getInstance();
                    hybridLog2.e("Offline", "强制使用线上：" + str);
                    e(str, "dev_mode", false, "", "");
                    return Pair.create(Boolean.FALSE, str);
                } else {
                    String str2 = null;
                    try {
                        str2 = f(webView, str);
                    } catch (Exception e) {
                        TbLog hybridLog3 = HybridLog.getInstance();
                        hybridLog3.e("Offline", "离线包处理异常 exception：" + e + " " + str);
                        e(str, "exception", false, "", "");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return Pair.create(Boolean.TRUE, str2);
                    }
                    tl6.e().h(str);
                    return Pair.create(Boolean.FALSE, str);
                }
            }
            return Pair.create(Boolean.TRUE, str);
        }
        return (Pair) invokeLL.objValue;
    }
}
