package com.baidu.webkit.internal.monitor;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.monitor.a;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SessionMonitorEngine implements INoProGuard {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = SessionMonitorEngine.class.getSimpleName();
    public static final int MONITOR_FRAMEWORK_TYPE_ASYNC_SEARCH_EVAJS = 2;
    public static final int MONITOR_FRAMEWORK_TYPE_SEARCH_CLICK = 1;
    public static final int MONITOR_FRAMEWORK_TYPE_SYNC_SEARCH_LOADURL = 3;
    public static final String PUBLIC_DATA_UNDIFNED = "undefined";
    private static SessionMonitorEngine sInstance;
    private ConcurrentHashMap<Integer, LinkedList<WeakReference<IExtraInfoCollector>>> mExtraInfoCollectors;
    private JSONObject mStaticPublicData;
    private String mWiseSid;
    private b sExtraInterfaceProvider;
    private a sFrameworkBehaviorProvider;
    private WeakReference<IPrototype> sImplement;

    /* loaded from: classes8.dex */
    public interface IExtraInfoCollector extends INoProGuard {
        JSONObject onPageSessionFinished(WebView webView, String str);

        void onPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3);
    }

    /* loaded from: classes8.dex */
    public interface IPrototype extends INoProGuard {
        void notifyPageActive(String str, WebView webView, boolean z);

        void notifyPageLeave(String str, WebView webView);

        void onWebkitPaused();

        void onWebkitResumed();

        void record(WebView webView, IZeusMonitor iZeusMonitor);

        void record(WebView webView, String str);

        void recordImmediately(String str, String str2);
    }

    private SessionMonitorEngine() {
        if (this.sExtraInterfaceProvider == null) {
            this.sExtraInterfaceProvider = new b();
        }
        if (this.sFrameworkBehaviorProvider == null) {
            this.sFrameworkBehaviorProvider = new a();
        }
    }

    public static SessionMonitorEngine getInstance() {
        if (sInstance == null) {
            sInstance = new SessionMonitorEngine();
        }
        return sInstance;
    }

    private JSONObject processStaticPublicData() {
        if (this.mStaticPublicData == null) {
            this.mStaticPublicData = new JSONObject();
            try {
                this.mStaticPublicData.put("cuid", WebKitFactory.getCUIDString());
                this.mStaticPublicData.put("app_name", WebKitFactory.getContext().getApplicationContext().getPackageName());
                this.mStaticPublicData.put("app_version", WebKitFactory.getContext().getApplicationContext().getPackageManager().getPackageInfo(WebKitFactory.getContext().getApplicationContext().getPackageName(), 0).versionName);
                this.mStaticPublicData.put("zeus_version", WebKitFactory.getZeusVersionName());
                String str = Build.BRAND;
                String str2 = Build.MODEL;
                String str3 = Build.MANUFACTURER;
                String str4 = Build.VERSION.RELEASE;
                int i = Build.VERSION.SDK_INT;
                this.mStaticPublicData.put("product", str3);
                this.mStaticPublicData.put(Constants.PHONE_BRAND, str);
                this.mStaticPublicData.put("model", str2);
                this.mStaticPublicData.put("version", str4);
                this.mStaticPublicData.put(CashierData.SDK, i);
                Log.i(LOG_TAG, "processStaticPublicData: " + this.mStaticPublicData.toString());
            } catch (Throwable th) {
                Log.printStackTrace(th);
            }
        }
        return this.mStaticPublicData;
    }

    public void decorateMonitorEngine(IPrototype iPrototype) {
        if (iPrototype != null) {
            this.sImplement = new WeakReference<>(iPrototype);
        }
    }

    public String getPublicData() {
        JSONObject processStaticPublicData = processStaticPublicData();
        if (processStaticPublicData == null) {
            return PUBLIC_DATA_UNDIFNED;
        }
        try {
            processStaticPublicData.put("session_id", WebKitFactory.getStatisticsSessionId());
            processStaticPublicData.put(DpStatConstants.KEY_KERNEL_SESSION_ID, WebKitFactory.getKernelSessionId());
            processStaticPublicData.put("network", NetWorkUtils.getNetWorkType() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + NetWorkUtils.getOperatorType());
            IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
            if (abTestInterface != null) {
                JSONObject rawSwitch = abTestInterface.getRawSwitch();
                processStaticPublicData.put("searchbox_ab_rsid", rawSwitch);
                Log.i("linhua-x", "searchbox_ab_rsid is " + rawSwitch);
            }
            HashMap<String, String> statisticParams = WebKitFactory.getStatisticParams();
            if (statisticParams != null && !statisticParams.isEmpty()) {
                for (String str : statisticParams.keySet()) {
                    processStaticPublicData.put(str, statisticParams.get(str));
                }
            }
            return processStaticPublicData.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return PUBLIC_DATA_UNDIFNED;
        }
    }

    public long getRecordNA20SuperFrameTimeStamp(int i) {
        if (this.sExtraInterfaceProvider != null) {
            b bVar = this.sExtraInterfaceProvider;
            switch (i) {
                case 1:
                    return bVar.g;
                case 2:
                    return bVar.e;
                case 3:
                    return bVar.f;
                default:
                    return -1L;
            }
        }
        return -1L;
    }

    public long getSearchButtonClickedTimeStamp() {
        if (this.sExtraInterfaceProvider != null) {
            return this.sExtraInterfaceProvider.a;
        }
        return -1L;
    }

    public JSONObject getWebViewTimeStamp() {
        if (this.sExtraInterfaceProvider != null) {
            return this.sExtraInterfaceProvider.h;
        }
        return null;
    }

    public final JSONArray notifyCollectorPageSessionFinished(WebView webView, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        Log.i("linhua-collector", "notifyCollectorPageSessionFinished: " + str);
        try {
            if (this.mExtraInfoCollectors != null && !this.mExtraInfoCollectors.isEmpty() && webView != null) {
                Iterator<WeakReference<IExtraInfoCollector>> it = this.mExtraInfoCollectors.get(Integer.valueOf(webView.hashCode())).iterator();
                while (it.hasNext()) {
                    IExtraInfoCollector iExtraInfoCollector = it.next().get();
                    if (iExtraInfoCollector != null) {
                        try {
                            JSONObject onPageSessionFinished = iExtraInfoCollector.onPageSessionFinished(webView, str);
                            if (onPageSessionFinished != null) {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                Log.i("linhua-collector", "get something: " + onPageSessionFinished);
                                jSONArray2.put(onPageSessionFinished);
                            }
                        } catch (Throwable th) {
                            jSONArray = jSONArray2;
                            try {
                                Log.printStackTrace(th);
                            } catch (Throwable th2) {
                                jSONArray2 = jSONArray;
                                th = th2;
                                Log.printStackTrace(th);
                                return jSONArray2;
                            }
                        }
                    } else {
                        jSONArray = jSONArray2;
                    }
                    jSONArray2 = jSONArray;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return jSONArray2;
    }

    public final void notifyCollectorPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3) {
        Log.i("linhua-collector", "notifyCollectorPageSessionStarted: " + str + " isSameDocument: " + z2);
        try {
            if (this.mExtraInfoCollectors == null || this.mExtraInfoCollectors.isEmpty() || webView == null) {
                return;
            }
            Iterator<WeakReference<IExtraInfoCollector>> it = this.mExtraInfoCollectors.get(Integer.valueOf(webView.hashCode())).iterator();
            while (it.hasNext()) {
                IExtraInfoCollector iExtraInfoCollector = it.next().get();
                if (iExtraInfoCollector != null) {
                    iExtraInfoCollector.onPageSessionStarted(webView, str, z, z2, z3);
                }
            }
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        if (this.sImplement == null || this.sImplement.get() == null) {
            return;
        }
        this.sImplement.get().notifyPageActive(str, webView, z);
    }

    public void notifyPageLeave(String str, WebView webView) {
        if (this.sImplement == null || this.sImplement.get() == null) {
            return;
        }
        this.sImplement.get().notifyPageLeave(str, webView);
    }

    public void onPageKeySectionTimeCost(WebView webView, String str, int i, long j) {
        WebViewFactoryProvider provider = WebViewFactory.getProvider();
        if (provider != null) {
            provider.onPageKeySectionTimeCostKeySection(webView, str, i, j);
        }
    }

    public JSONObject peekFrameworkBehaviorValue() {
        return this.sFrameworkBehaviorProvider.a();
    }

    public JSONObject peekNA20SuperFrameTimeStamp() {
        if (this.sExtraInterfaceProvider != null) {
            return this.sExtraInterfaceProvider.a();
        }
        return null;
    }

    public JSONObject peekSearchTimeStamps() {
        if (this.sExtraInterfaceProvider != null) {
            return this.sExtraInterfaceProvider.b();
        }
        return null;
    }

    public void record(WebView webView, IZeusMonitor iZeusMonitor) {
        if (this.sImplement == null || this.sImplement.get() == null) {
            return;
        }
        this.sImplement.get().record(webView, iZeusMonitor);
    }

    public void record(WebView webView, String str) {
        if (this.sImplement == null || this.sImplement.get() == null) {
            return;
        }
        this.sImplement.get().record(webView, str);
    }

    public void recordFrameworkBehaviorValue(int i, Object obj) {
        a aVar = this.sFrameworkBehaviorProvider;
        if (aVar.a == null) {
            aVar.a = new a.C0849a(aVar, (byte) 0);
        }
        if (i == 9) {
            aVar.a.a();
            aVar.a.f = true;
        }
        if (aVar.a.f) {
            switch (i) {
                case 7:
                    aVar.a.a = ((Boolean) obj).booleanValue();
                    return;
                case 8:
                    aVar.a.b = ((Boolean) obj).booleanValue();
                    return;
                case 9:
                    aVar.a.c = ((Long) obj).longValue();
                    return;
                case 10:
                    aVar.a.d = ((Long) obj).longValue();
                    aVar.a.f = true;
                    return;
                case 11:
                    aVar.a.e = ((Boolean) obj).booleanValue();
                    return;
                default:
                    return;
            }
        }
    }

    public void recordFrameworkBehaviorValue(String str, long j) {
        a aVar = this.sFrameworkBehaviorProvider;
        if (aVar.a != null) {
            aVar.a.g.put(str, Long.valueOf((aVar.a.g.containsKey(str) ? aVar.a.g.get(str).longValue() : 0L) + j));
        }
    }

    public void recordImmediately(String str, String str2) {
        if (this.sImplement == null || this.sImplement.get() == null) {
            uploadRealTimeData(str, str2);
        } else {
            this.sImplement.get().recordImmediately(str, str2);
        }
    }

    public void recordNA20SuperFrameTimeStamp(int i, long j) {
        if (this.sExtraInterfaceProvider != null) {
            b bVar = this.sExtraInterfaceProvider;
            switch (i) {
                case 1:
                    bVar.g = j;
                    return;
                case 2:
                    bVar.e = j;
                    return;
                case 3:
                    bVar.f = j;
                    return;
                default:
                    return;
            }
        }
    }

    public void recordSearchBoxJsBridgeInvoked(String str) {
        if (this.sExtraInterfaceProvider != null) {
            b bVar = this.sExtraInterfaceProvider;
            if (!TextUtils.isEmpty(str) && str.startsWith("baiduboxapp://v1/browser/open") && str.contains("isContainer=1")) {
                bVar.d = System.currentTimeMillis();
                Log.d("linhua-x", "recordSearchBoxJsBridgeInvoked: " + str);
            }
        }
    }

    public void recordSearchTimeStamp(int i, long j) {
        if (this.sExtraInterfaceProvider != null) {
            b bVar = this.sExtraInterfaceProvider;
            switch (i) {
                case 1:
                    bVar.a = j;
                    return;
                case 2:
                    bVar.b = j;
                    return;
                case 3:
                    bVar.c = j;
                    return;
                default:
                    return;
            }
        }
    }

    public void recordWebViewTimeStamp(String str, long j) {
        if (this.sExtraInterfaceProvider != null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar.h == null) {
                bVar.h = new JSONObject();
            }
            try {
                if (TextUtils.isEmpty(str) || bVar.h.has(str)) {
                    return;
                }
                bVar.h.put(str, j);
            } catch (JSONException e) {
                Log.printStackTrace(e);
            }
        }
    }

    public final void registerPageSessionExtraCollector(WebView webView, IExtraInfoCollector iExtraInfoCollector) {
        if (iExtraInfoCollector == null || webView == null || webView.isDestroyed()) {
            return;
        }
        if (this.mExtraInfoCollectors == null) {
            this.mExtraInfoCollectors = new ConcurrentHashMap<>();
        }
        int hashCode = webView.hashCode();
        LinkedList<WeakReference<IExtraInfoCollector>> linkedList = this.mExtraInfoCollectors.get(Integer.valueOf(hashCode));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.mExtraInfoCollectors.put(Integer.valueOf(hashCode), linkedList);
        } else {
            Iterator<WeakReference<IExtraInfoCollector>> it = linkedList.iterator();
            while (it.hasNext()) {
                if (it.next().get() == iExtraInfoCollector) {
                    return;
                }
            }
        }
        linkedList.add(new WeakReference<>(iExtraInfoCollector));
    }

    public void release() {
        this.sImplement = null;
        this.sExtraInterfaceProvider = null;
        this.sFrameworkBehaviorProvider = null;
        sInstance = null;
    }

    public void startFrameworkBehaviorMonitor() {
        a aVar = this.sFrameworkBehaviorProvider;
        if (aVar.a == null) {
            aVar.a = new a.C0849a(aVar, (byte) 0);
        }
        if (aVar.a.c == -1) {
            aVar.a.a();
        }
        if (aVar.a.f) {
            return;
        }
        aVar.a.f = true;
    }

    public void updateCuidIfNeeded() {
        if (this.mStaticPublicData == null) {
            return;
        }
        try {
            this.mStaticPublicData.put("cuid", WebKitFactory.getCUIDString());
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public void updateWiseSids(String str) {
        this.mWiseSid = str;
    }

    public void uploadRealTimeData(String str, String str2) {
        uploadRealTimeData(str, str2, true);
    }

    public void uploadRealTimeData(String str, String str2, boolean z) {
        String str3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (WebSettingsGlobalBlink.isSessionDataEnable()) {
                JSONObject jSONObject = new JSONObject(getPublicData());
                jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, "kernel_sailor");
                Log.i("Session1", "uploadRealTimeData mWiseSid = " + this.mWiseSid);
                if (!TextUtils.isEmpty(this.mWiseSid)) {
                    jSONObject.put("wise_sid", this.mWiseSid);
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(str2));
                jSONObject.put("items", jSONArray);
                str3 = jSONObject.toString();
            } else {
                str3 = getPublicData() + "###" + str2;
            }
            new SessionMonitorNetWorker().upload("kernel_sailor", str3, str, z);
        } catch (Throwable th) {
        }
    }
}
