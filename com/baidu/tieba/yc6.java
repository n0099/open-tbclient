package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.WebViewTrackerEnableSwitch;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.facebook.common.util.UriUtil;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class yc6 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public volatile boolean b;
    public String c;
    public Runnable d;
    public vf6 e;

    public yc6() {
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
        this.e = null;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d != null) {
            ke6.a().e(this.d);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface
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
            this.d = new Runnable() { // from class: com.baidu.tieba.wc6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        yc6.this.c(str);
                    }
                }
            };
            ke6.a().d(this.d, 10000L);
        }
    }

    public /* synthetic */ void c(String str) {
        e(str, 1);
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            e(str, 2);
        }
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                if (this.e != null && !df6.a(this.e.e())) {
                    Map<String, Pair<Long, Long>> f = this.e.f();
                    JSONArray jSONArray = new JSONArray();
                    for (Pair<String, Long> pair : this.e.e()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", pair.first);
                        jSONObject2.put("req", pair.second);
                        Pair<Long, Long> pair2 = f.get(pair.first);
                        if (pair2 != null) {
                            jSONObject2.put(UriUtil.LOCAL_RESOURCE_SCHEME, pair2.first);
                            jSONObject2.put("hit", pair2.second);
                        } else {
                            jSONObject2.put(UriUtil.LOCAL_RESOURCE_SCHEME, -1);
                            jSONObject2.put("hit", -1);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    if (!df6.c(jSONArray)) {
                        jSONObject.put(PrefetchEvent.MODULE, jSONArray);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void e(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            synchronized (this) {
                try {
                    d();
                    if (this.a && !this.b && !TextUtils.isEmpty(str)) {
                        this.b = true;
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
                            try {
                                long optLong16 = jSONObject.optLong("drt", -1L);
                                long optLong17 = jSONObject.optLong("dt", -1L);
                                long optLong18 = jSONObject.optLong("autoFMP", -1L);
                                long optLong19 = jSONObject.optLong("autoFP", -1L);
                                long optLong20 = jSONObject.optLong("autoFCP", -1L);
                                int optInt = jSONObject.optInt("autoWVLCP", -1);
                                int optInt2 = jSONObject.optInt("autoWVFCP", -1);
                                long optLong21 = jSONObject.optLong("fp", -1L);
                                long optLong22 = jSONObject.optLong("fmp", -1L);
                                StringBuilder sb = new StringBuilder();
                                sb.append("是否离线包：");
                                sb.append(optBoolean);
                                sb.append(",总耗时");
                                long j = optLong22 - optLong;
                                sb.append(j);
                                sb.append("-初始化:");
                                sb.append(optLong4 - optLong);
                                sb.append(",加载:");
                                sb.append(optLong14 - optLong4);
                                sb.append(",解析:");
                                sb.append(optLong15 - optLong14);
                                sb.append("，渲染:");
                                sb.append(optLong22 - optLong15);
                                xe6.b("lt-log", sb.toString());
                                try {
                                    b(jSONObject);
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.WEBVIEW_PERF_DATA_KEY).param("obj_param1", jSONObject.toString()).param(TiebaStatic.Params.OBJ_PARAM2, jSONObject.toString());
                                    if (optBoolean) {
                                        str2 = "0";
                                    } else {
                                        str2 = "1";
                                    }
                                    TiebaStatic.log(param.param("obj_id", str2).param("obj_type", i).param("obj_locate", 1).param("obj_source", 1).param(TiebaStatic.Params.OBJ_PARAM3, j).param(com.kuaishou.weapon.p0.u.x, optLong).param("wvst", optLong2).param("wvft", optLong3).param("lst", optLong4).param("navigationStart", optLong5).param("fetchStart", optLong6).param("domainLookupStart", optLong7).param("domainLookupEnd", optLong8).param("connectStart", optLong9).param("connectEnd", optLong10).param("requestStart", optLong11).param("responseStart", optLong12).param("responseEnd", optLong13).param("ds", optLong14).param("df", optLong15).param("drt", optLong16).param("dt", optLong17).param("autoFMP", optLong18).param("autoFP", optLong19).param("autoFCP", optLong20).param("autoWVLCP", optInt).param("autoWVFCP", optInt2).param("fp", optLong21).param("fmp", optLong22).param("url", optString));
                                } catch (Exception unused) {
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } catch (Exception unused2) {
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView)) {
                    this.e = ((TbWebView) this.mWebView.getParent()).getPerfData();
                }
                if (this.e != null && this.a && !this.b && vf6.k(this.e.g())) {
                    String g = this.e.g();
                    JSONObject jSONObject = new JSONObject();
                    String c = this.e.c();
                    this.c = c;
                    jSONObject.put("logId", c);
                    jSONObject.put("url", g);
                    jSONObject.put("clientType", "Android");
                    jSONObject.put("isOfflinePackage", this.e.j());
                    jSONObject.put(com.kuaishou.weapon.p0.u.x, this.e.d());
                    jSONObject.put("wvst", this.e.i());
                    jSONObject.put("wvft", this.e.h());
                    jSONObject.put("lst", this.e.b());
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
