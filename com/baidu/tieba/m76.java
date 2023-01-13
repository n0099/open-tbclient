package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.WebViewTrackerEnableSwitch;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.core.jscore.jsinterface.AbsJsInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class m76 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public volatile boolean b;
    public String c;
    public Runnable d;

    public m76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = WebViewTrackerEnableSwitch.isOn();
        this.b = false;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d != null) {
            g76.a().e(this.d);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.browser.core.jscore.jsinterface.AbsJsInterface
    public void deAttachWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
            super.deAttachWebView();
        }
    }

    public final void a(final String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !this.b && this.d == null) {
            this.d = new Runnable() { // from class: com.baidu.tieba.l76
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        m76.this.b(str);
                    }
                }
            };
            g76.a().d(this.d, 10000L);
        }
    }

    public /* synthetic */ void b(String str) {
        d(str, 1);
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            d(str, 2);
        }
    }

    public final synchronized void d(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            synchronized (this) {
                c();
                if (this.a && !this.b && !TextUtils.isEmpty(str)) {
                    this.b = true;
                    o76.b("lt-log", str);
                    UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager != null) {
                        uBCManager.onEvent("5607", str);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.optString("logId", this.c);
                        String optString = jSONObject.optString("url", "");
                        boolean optBoolean = jSONObject.optBoolean("isOfflinePackage", false);
                        long optLong = jSONObject.optLong(com.kuaishou.weapon.p0.u.x, -1L);
                        long optLong2 = jSONObject.optLong("wvst", -1L);
                        long optLong3 = jSONObject.optLong("wvft", -1L);
                        long optLong4 = jSONObject.optLong("lst", -1L);
                        long optLong5 = jSONObject.optLong("navigationStart", -1L);
                        long optLong6 = jSONObject.optLong("fetchStart", -1L);
                        long optLong7 = jSONObject.optLong("domainLookupStart", -1L);
                        long optLong8 = jSONObject.optLong("domainLookupEnd", -1L);
                        long optLong9 = jSONObject.optLong("connectStart", -1L);
                        long optLong10 = jSONObject.optLong("connectEnd", -1L);
                        long optLong11 = jSONObject.optLong("requestStart", -1L);
                        long optLong12 = jSONObject.optLong("responseStart", -1L);
                        long optLong13 = jSONObject.optLong("responseEnd", -1L);
                        long optLong14 = jSONObject.optLong("ds", -1L);
                        long optLong15 = jSONObject.optLong("df", -1L);
                        long optLong16 = jSONObject.optLong("drt", -1L);
                        long optLong17 = jSONObject.optLong("dt", -1L);
                        long optLong18 = jSONObject.optLong("autoFMP", -1L);
                        long optLong19 = jSONObject.optLong("autoFP", -1L);
                        long optLong20 = jSONObject.optLong("autoFCP", -1L);
                        int optInt = jSONObject.optInt("autoWVLCP", -1);
                        int optInt2 = jSONObject.optInt("autoWVFCP", -1);
                        long optLong21 = jSONObject.optLong("fp", -1L);
                        long optLong22 = jSONObject.optLong("fmp", -1L);
                        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.WEBVIEW_PERF_DATA_KEY).param("obj_param1", str).param(TiebaStatic.Params.OBJ_PARAM2, str);
                        if (optBoolean) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        TiebaStatic.log(param.param("obj_id", str2).param("obj_type", i).param("obj_locate", 1).param("obj_source", 1).param(TiebaStatic.Params.OBJ_PARAM3, optLong22 - optLong).param(com.kuaishou.weapon.p0.u.x, optLong).param("wvst", optLong2).param("wvft", optLong3).param("lst", optLong4).param("navigationStart", optLong5).param("fetchStart", optLong6).param("domainLookupStart", optLong7).param("domainLookupEnd", optLong8).param("connectStart", optLong9).param("connectEnd", optLong10).param("requestStart", optLong11).param("responseStart", optLong12).param("responseEnd", optLong13).param("ds", optLong14).param("df", optLong15).param("drt", optLong16).param("dt", optLong17).param("autoFMP", optLong18).param("autoFP", optLong19).param("autoFCP", optLong20).param("autoWVLCP", optInt).param("autoWVFCP", optInt2).param("fp", optLong21).param("fmp", optLong22).param("url", optString));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            w76 w76Var = null;
            try {
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView)) {
                    w76Var = ((TbWebView) this.mWebView.getParent()).getPerfData();
                }
                if (w76Var != null && this.a && !this.b && w76.g(w76Var.d())) {
                    String d = w76Var.d();
                    JSONObject jSONObject = new JSONObject();
                    String b = w76Var.b();
                    this.c = b;
                    jSONObject.put("logId", b);
                    jSONObject.put("url", d);
                    jSONObject.put("clientType", "Android");
                    if (!URLUtil.isNetworkUrl(d)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    jSONObject.put("isOfflinePackage", z);
                    jSONObject.put(com.kuaishou.weapon.p0.u.x, w76Var.c());
                    jSONObject.put("wvst", w76Var.f());
                    jSONObject.put("wvft", w76Var.e());
                    jSONObject.put("lst", w76Var.a());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("perfData", jSONObject);
                    a(jSONObject.toString());
                    return jSONObject2.toString();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
