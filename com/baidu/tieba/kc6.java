package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.browser.core.webview.offline.data.OfflineBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public final class kc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public nc6 d;

    public kc6() {
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

    public void b() {
        nc6 nc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (nc6Var = this.d) != null) {
            nc6Var.h();
            this.d = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = 0;
            this.b = "none";
            this.c = "0.0.0.0";
        }
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

    public final void d(WebView webView, Uri uri, vc6 vc6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, webView, uri, vc6Var) == null) && !vd6.a(vc6Var.b) && webView != null) {
            if (this.d == null) {
                this.d = new nc6();
            }
            Map<String, String> a = ab6.a(uri, null);
            Iterator<String> it = vc6Var.b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                for (String str : Uri.parse(next).getQueryParameterNames()) {
                    next = next.replace("{" + str + "}", ab6.c(a, str));
                }
                OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
                offlineBridgeData.type = "get";
                offlineBridgeData.url = next;
                offlineBridgeData.module = vc6Var.c;
                offlineBridgeData.begin = System.currentTimeMillis();
                nc6 nc6Var = this.d;
                if (nc6Var != null) {
                    nc6Var.j(webView, offlineBridgeData, null);
                }
            }
        }
    }

    public final String e(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            try {
                Uri parse = Uri.parse(str);
                vc6 e = pc6.b().e(parse.getPath());
                if (e == null) {
                    if (pc6.b().d() != null) {
                        this.a = 3;
                    }
                    return null;
                }
                try {
                    if (!e.g) {
                        this.a = 4;
                        b35.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", e.c, "hybridVersion", this.c, "hybridResult", "processing bundle");
                        return null;
                    }
                    String i = mc6.h().i(e.c);
                    if (!TextUtils.isEmpty(e.c) && !TextUtils.isEmpty(e.d) && !TextUtils.isEmpty(i)) {
                        this.b = mc6.t(true, e.c);
                        this.c = mc6.t(false, i);
                        String str2 = mc6.h().g() + "/" + this.b + "/" + this.c + "/";
                        String str3 = e.d;
                        if (!TextUtils.isEmpty(str3) && !str3.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                            str3 = e.d + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                        }
                        if (!new File(str2, str3).exists()) {
                            this.a = 2;
                            b35.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.b, "hybridVersion", this.c, "hybridResult", "path not found");
                            e.g = false;
                            return null;
                        }
                        e.g = true;
                        e.e = "file://" + str2;
                        pc6.b().a(zd6.c(str), e);
                        if (!e.h && !vd6.a(e.b)) {
                            d(webView, parse, e);
                        } else if (e.h) {
                            vd6.a(e.a);
                        }
                        if (e.h) {
                            return str;
                        }
                        return a(e.e, str3, parse.getQuery());
                    }
                    e.g = false;
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public Pair<Boolean, String> f(WebView webView, String str) {
        InterceptResult invokeLL;
        String e;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            if (!URLUtil.isAssetUrl(str) && !URLUtil.isFileUrl(str)) {
                if (URLUtil.isNetworkUrl(str)) {
                    c();
                    b35.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str);
                    if (mc6.m(str)) {
                        this.a = 5;
                        pc6.b().f(str);
                        e = "";
                    } else {
                        e = e(webView, str);
                        if (TextUtils.isEmpty(e)) {
                            pc6.b().f(str);
                        } else {
                            b35.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", e, "hybridName", this.b, "hybridVersion", this.c, "hybridResult", "success");
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
                    if (!TextUtils.isEmpty(e)) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    TiebaStatic.log(statisticItem.param("obj_locate", str2).param("obj_source", str).param("obj_type", this.a).param("obj_name", mc6.h).param("obj_param1", this.b).param("obj_id", this.c));
                    b35.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    if (!TextUtils.isEmpty(e)) {
                        return Pair.create(Boolean.TRUE, e);
                    }
                    return Pair.create(Boolean.FALSE, str);
                }
                return Pair.create(Boolean.FALSE, str);
            }
            return Pair.create(Boolean.TRUE, str);
        }
        return (Pair) invokeLL.objValue;
    }
}
