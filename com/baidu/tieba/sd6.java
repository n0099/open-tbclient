package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.core.webview.offline.data.OfflineBridgeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public final class sd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public sd6() {
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

    public final void d(WebView webView, Uri uri, ee6 ee6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, uri, ee6Var) == null) && !ef6.a(ee6Var.b) && webView != null) {
            Map<String, String> a = hc6.a(uri);
            Iterator<String> it = ee6Var.b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Uri parse = Uri.parse(next);
                for (String str : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                        next = next.replace(queryParameter, hc6.c(a, queryParameter));
                    }
                }
                OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
                offlineBridgeData.type = "get";
                offlineBridgeData.url = next;
                offlineBridgeData.module = ee6Var.c;
                offlineBridgeData.begin = System.currentTimeMillis();
                vd6.g().j(webView, offlineBridgeData, null);
            }
        }
    }

    public final void e(String str, String str2, boolean z, String str3, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), str3, str4}) == null) {
            sc6 a = sc6.a(HybridStatisticKey.KEY_OFFLINE_PACKAGE);
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
            a.c(TiebaStatic.Params.OBJ_PARAM2, hf6.a(pairArr));
            a.d();
        }
    }

    public final String f(WebView webView, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            Uri parse = Uri.parse(str);
            ee6 f = xd6.d().f(parse);
            if (f == null) {
                e(str, "without_bundle", false, "", "");
                return null;
            }
            String n = ud6.l().n(f.c);
            if (TextUtils.isEmpty(f.c)) {
                str2 = "none";
            } else {
                str2 = f.c;
            }
            String str3 = str2;
            if (TextUtils.isEmpty(n)) {
                n = "0.0.0.0";
            }
            String str4 = n;
            if (!f.g) {
                e(str, "processing_bundle", f.h, str3, str4);
                return null;
            }
            String str5 = f.d;
            if (!TextUtils.isEmpty(str5) && !str5.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                str5 = f.d + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4)) {
                String str6 = ud6.l().k() + "/" + str3 + "/" + str4 + "/";
                if (!new File(str6, str5).exists()) {
                    f.g = false;
                    e(str, "path_not_found", f.h, str3, str4);
                    return null;
                }
                f.g = true;
                f.e = "file://" + str6;
                xd6.d().a(kf6.c(str), f);
                if (!f.h && !ef6.a(f.b)) {
                    d(webView, parse, f);
                }
                e(str, "success", f.h, str3, str4);
                if (f.h) {
                    return str;
                }
                return a(f.e, str5, parse.getQuery());
            }
            f.g = false;
            e(str, "config_error", f.h, str3, str4);
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
                    xd6.d().g(str);
                    e(str, "close_offline", false, "", "");
                    return Pair.create(Boolean.FALSE, str);
                } else if (b(str)) {
                    xd6.d().g(str);
                    e(str, "dev_mode", false, "", "");
                    return Pair.create(Boolean.FALSE, str);
                } else {
                    String str2 = null;
                    try {
                        str2 = f(webView, str);
                    } catch (Exception unused) {
                        e(str, "exception", false, "", "");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return Pair.create(Boolean.TRUE, str2);
                    }
                    xd6.d().g(str);
                    return Pair.create(Boolean.FALSE, str);
                }
            }
            return Pair.create(Boolean.TRUE, str);
        }
        return (Pair) invokeLL.objValue;
    }
}
