package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SessionMonitorEngine implements INoProGuard {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = SessionMonitorEngine.class.getSimpleName();
    public static final int MONITOR_FRAMEWORK_TYPE_ASYNC_SEARCH_EVAJS = 2;
    public static final int MONITOR_FRAMEWORK_TYPE_SEARCH_CLICK = 1;
    public static final int MONITOR_FRAMEWORK_TYPE_SYNC_SEARCH_LOADURL = 3;
    private static a sExtraInterfaceProvider;
    private static WeakReference<IPrototype> sImplement;
    private static SessionMonitorEngine sInstance;

    /* loaded from: classes2.dex */
    public interface IPrototype extends INoProGuard {
        void onWebkitPaused();

        void onWebkitResumed();

        void record(WebView webView, IZeusMonitor iZeusMonitor);

        void record(WebView webView, String str);

        void recordImmediately(String str, String str2);
    }

    private SessionMonitorEngine() {
        if (sExtraInterfaceProvider == null) {
            sExtraInterfaceProvider = new a();
        }
        com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new b());
    }

    public static SessionMonitorEngine getInstance() {
        if (sInstance == null) {
            sInstance = new SessionMonitorEngine();
        }
        return sInstance;
    }

    private String getPublicData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cuid", WebKitFactory.getCUIDString());
            jSONObject.put(AiAppsApsUtils.APP_NAME, WebKitFactory.getContext().getApplicationContext().getPackageName());
            jSONObject.put("app_version", WebKitFactory.getContext().getApplicationContext().getPackageManager().getPackageInfo(WebKitFactory.getContext().getApplicationContext().getPackageName(), 0).versionName);
            jSONObject.put("zeus_version", WebKitFactory.getZeusVersionName());
            jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, WebKitFactory.getStatisticsSessionId());
            jSONObject.put("k_id", WebKitFactory.getKernelSessionId());
            jSONObject.put("network", NetWorkUtils.getNetWorkType() + BaseRequestAction.SPLITE + NetWorkUtils.getOperatorType());
            HashMap<String, String> statisticParams = WebKitFactory.getStatisticParams();
            if (statisticParams != null && !statisticParams.isEmpty()) {
                for (String str : statisticParams.keySet()) {
                    jSONObject.put(str, statisticParams.get(str));
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
            return null;
        }
    }

    public static void release() {
        if (sInstance != null) {
            sImplement = null;
        }
        if (sExtraInterfaceProvider != null) {
            sExtraInterfaceProvider = null;
        }
        sInstance = null;
    }

    public void decorateMonitorEngine(IPrototype iPrototype) {
        if (iPrototype != null) {
            sImplement = new WeakReference<>(iPrototype);
        }
    }

    public JSONObject peekSearchTimeStamps() {
        if (sExtraInterfaceProvider != null) {
            return sExtraInterfaceProvider.a();
        }
        return null;
    }

    public void record(WebView webView, IZeusMonitor iZeusMonitor) {
        if (sImplement == null || sImplement.get() == null) {
            return;
        }
        sImplement.get().record(webView, iZeusMonitor);
    }

    public void record(WebView webView, String str) {
        if (sImplement == null || sImplement.get() == null) {
            return;
        }
        sImplement.get().record(webView, str);
    }

    public void recordImmediately(String str, String str2) {
        if (sImplement == null || sImplement.get() == null) {
            uploadRealTimeData(str, str2);
        } else {
            sImplement.get().recordImmediately(str, str2);
        }
    }

    public void recordSearchTimeStamp(int i, long j) {
        if (sExtraInterfaceProvider != null) {
            a aVar = sExtraInterfaceProvider;
            switch (i) {
                case 1:
                    aVar.a = j;
                    return;
                case 2:
                    aVar.b = j;
                    return;
                case 3:
                    aVar.c = j;
                    return;
                default:
                    return;
            }
        }
    }

    public void uploadRealTimeData(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (WebSettingsGlobalBlink.isSessionDataEnable()) {
                JSONObject jSONObject = new JSONObject(getPublicData());
                jSONObject.put("server_type", "kernel_sailor");
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(str2));
                jSONObject.put("items", jSONArray);
                str3 = jSONObject.toString();
            } else {
                str3 = getPublicData() + "###" + str2;
            }
            new SessionMonitorNetWorker().upload("kernel_sailor", str3, str);
        } catch (Throwable th) {
        }
    }
}
