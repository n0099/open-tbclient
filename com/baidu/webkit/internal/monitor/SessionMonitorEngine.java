package com.baidu.webkit.internal.monitor;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.monitor.a;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SessionMonitorEngine implements INoProGuard {
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "SessionMonitorEngine";
    public static final int MONITOR_FRAMEWORK_TYPE_ASYNC_SEARCH_EVAJS = 2;
    public static final int MONITOR_FRAMEWORK_TYPE_SEARCH_CLICK = 1;
    public static final int MONITOR_FRAMEWORK_TYPE_SYNC_SEARCH_LOADURL = 3;
    public static final String PUBLIC_DATA_UNDIFNED = "undefined";
    public static final int STATUS_CODE_FAILED = 0;
    public static final int STATUS_CODE_SUCCESS = 1;
    public static SessionMonitorEngine sInstance;
    public BusinessSessionEventHandler mBusinessEventHandler;
    public ConcurrentHashMap<Integer, LinkedList<WeakReference<IExtraInfoCollector>>> mExtraInfoCollectors;
    public CopyOnWriteArrayList<PageSessionObserver> mPageSessionObserverList;
    public JSONObject mStaticPublicData;
    public IStatisticsTransmission mStatisticsTransmission;
    public String mWiseSid;
    public b sExtraInterfaceProvider;
    public a sFrameworkBehaviorProvider;
    public WeakReference<IPrototype> sImplement;

    /* loaded from: classes7.dex */
    public interface IExtraInfoCollector extends INoProGuard {
        JSONObject onPageSessionFinished(WebView webView, String str);

        void onPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3);
    }

    /* loaded from: classes7.dex */
    public interface IPrototype extends INoProGuard {
        void OnAppEnterBackground();

        void OnAppEnterForeground();

        void notifyPageActive(String str, WebView webView, boolean z);

        void notifyPageLeave(String str, WebView webView);

        void onWebkitPaused();

        void onWebkitResumed();

        void record(WebView webView, IZeusMonitor iZeusMonitor);

        void record(WebView webView, String str);

        void recordBySourceId(WebView webView, long j, int i, JSONObject jSONObject);

        void recordImmediately(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public interface PageSessionObserver extends INoProGuard {
        void onPageSessionDataRecord(WebView webView, String str, String str2, int i, String str3);
    }

    public SessionMonitorEngine() {
        if (this.sExtraInterfaceProvider == null) {
            this.sExtraInterfaceProvider = new b();
        }
        if (this.sFrameworkBehaviorProvider == null) {
            this.sFrameworkBehaviorProvider = new a();
        }
        if (this.mPageSessionObserverList == null) {
            this.mPageSessionObserverList = new CopyOnWriteArrayList<>();
        }
        this.mBusinessEventHandler = new BusinessSessionEventHandler();
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
                this.mStaticPublicData.put("sdk", i);
                String str5 = LOG_TAG;
                Log.i(str5, "processStaticPublicData: " + this.mStaticPublicData.toString());
            } catch (Throwable th) {
                Log.printStackTrace(th);
            }
        }
        return this.mStaticPublicData;
    }

    public void OnAppEnterBackground() {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().OnAppEnterBackground();
    }

    public void OnAppEnterForeground() {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().OnAppEnterForeground();
    }

    public void addPageSessionObserver(PageSessionObserver pageSessionObserver) {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList = this.mPageSessionObserverList;
        if (copyOnWriteArrayList == null || pageSessionObserver == null) {
            return;
        }
        copyOnWriteArrayList.add(pageSessionObserver);
    }

    public void clearPageSessionObserver() {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList = this.mPageSessionObserverList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    public void decorateMonitorEngine(IPrototype iPrototype) {
        if (iPrototype != null) {
            this.sImplement = new WeakReference<>(iPrototype);
        }
    }

    public BusinessSessionEventHandler getBusinessEventHandler() {
        return this.mBusinessEventHandler;
    }

    public String getPublicData() {
        JSONObject processStaticPublicData = processStaticPublicData();
        if (processStaticPublicData == null) {
            return PUBLIC_DATA_UNDIFNED;
        }
        try {
            processStaticPublicData.put("session_id", WebKitFactory.getStatisticsSessionId());
            processStaticPublicData.put(DpStatConstants.KEY_KERNEL_SESSION_ID, WebKitFactory.getKernelSessionId());
            processStaticPublicData.put("network", NetWorkUtils.getNetWorkType() + "_" + NetWorkUtils.getOperatorType());
            String rawSwitches = ABTestSDK.getRawSwitches();
            if (rawSwitches != null) {
                JSONObject jSONObject = new JSONObject(rawSwitches);
                processStaticPublicData.put("searchbox_ab_rsid", jSONObject);
                Log.i("linhua-x", "searchbox_ab_rsid is ".concat(String.valueOf(jSONObject)));
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
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return -1L;
                    }
                    return bVar.f;
                }
                return bVar.e;
            }
            return bVar.g;
        }
        return -1L;
    }

    public long getSearchButtonClickedTimeStamp() {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            return bVar.a;
        }
        return -1L;
    }

    public IStatisticsTransmission getStatisticsTransmission() {
        return this.mStatisticsTransmission;
    }

    public JSONObject getWebViewTimeStamp() {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            return bVar.h;
        }
        return null;
    }

    public final JSONArray notifyCollectorPageSessionFinished(WebView webView, String str) {
        JSONObject onPageSessionFinished;
        Log.i("linhua-collector", "notifyCollectorPageSessionFinished: ".concat(String.valueOf(str)));
        JSONArray jSONArray = null;
        try {
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
        if (this.mExtraInfoCollectors != null && !this.mExtraInfoCollectors.isEmpty() && webView != null) {
            Iterator<WeakReference<IExtraInfoCollector>> it = this.mExtraInfoCollectors.get(Integer.valueOf(webView.hashCode())).iterator();
            while (it.hasNext()) {
                IExtraInfoCollector iExtraInfoCollector = it.next().get();
                if (iExtraInfoCollector != null && (onPageSessionFinished = iExtraInfoCollector.onPageSessionFinished(webView, str)) != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    Log.i("linhua-collector", "get something: ".concat(String.valueOf(onPageSessionFinished)));
                    jSONArray.put(onPageSessionFinished);
                }
            }
            return jSONArray;
        }
        return null;
    }

    public final void notifyCollectorPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3) {
        Log.i("linhua-collector", "notifyCollectorPageSessionStarted: " + str + " isSameDocument: " + z2);
        try {
            if (this.mExtraInfoCollectors != null && !this.mExtraInfoCollectors.isEmpty() && webView != null) {
                Iterator<WeakReference<IExtraInfoCollector>> it = this.mExtraInfoCollectors.get(Integer.valueOf(webView.hashCode())).iterator();
                while (it.hasNext()) {
                    IExtraInfoCollector iExtraInfoCollector = it.next().get();
                    if (iExtraInfoCollector != null) {
                        iExtraInfoCollector.onPageSessionStarted(webView, str, z, z2, z3);
                    }
                }
            }
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().notifyPageActive(str, webView, z);
    }

    public void notifyPageLeave(String str, WebView webView) {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
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

    public void onPageSessionDataRecord(WebView webView, String str, int i, int i2, String str2) {
        if (this.mPageSessionObserverList != null) {
            Log.i("huqin-ps2", "onPageSessionDataRecord, webView = " + webView.hashCode() + ", url = " + str + ", type = " + i + ", status = " + i2 + ", data = " + str2);
            Iterator<PageSessionObserver> it = this.mPageSessionObserverList.iterator();
            while (it.hasNext()) {
                it.next().onPageSessionDataRecord(webView, str, String.valueOf(i), i2, str2);
            }
        }
    }

    public JSONObject peekFrameworkBehaviorValue() {
        return this.sFrameworkBehaviorProvider.a();
    }

    public JSONObject peekNA20SuperFrameTimeStamp() {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public JSONObject peekSearchTimeStamps() {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public void record(WebView webView, String str) {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().record(webView, str);
    }

    public void recordBySourceId(WebView webView, long j, int i, JSONObject jSONObject) {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().recordBySourceId(webView, j, i, jSONObject);
    }

    public void recordFrameworkBehaviorValue(int i, Object obj) {
        a aVar = this.sFrameworkBehaviorProvider;
        if (aVar.a == null) {
            aVar.a = new a.C0510a(aVar, (byte) 0);
        }
        if (i == 9) {
            aVar.a.a();
            aVar.a.f = true;
        }
        a.C0510a c0510a = aVar.a;
        if (c0510a.f) {
            switch (i) {
                case 7:
                    c0510a.a = ((Boolean) obj).booleanValue();
                    return;
                case 8:
                    c0510a.b = ((Boolean) obj).booleanValue();
                    return;
                case 9:
                    c0510a.c = ((Long) obj).longValue();
                    return;
                case 10:
                    c0510a.d = ((Long) obj).longValue();
                    aVar.a.f = true;
                    return;
                case 11:
                    c0510a.e = ((Boolean) obj).booleanValue();
                    return;
                default:
                    return;
            }
        }
    }

    public void recordFrameworkBehaviorValue(String str, long j) {
        a aVar = this.sFrameworkBehaviorProvider;
        a.C0510a c0510a = aVar.a;
        if (c0510a != null) {
            aVar.a.g.put(str, Long.valueOf(j + (c0510a.g.containsKey(str) ? aVar.a.g.get(str).longValue() : 0L)));
        }
    }

    public void recordImmediately(String str, String str2) {
        WeakReference<IPrototype> weakReference = this.sImplement;
        if (weakReference == null || weakReference.get() == null) {
            uploadRealTimeData(str, str2);
        } else {
            this.sImplement.get().recordImmediately(str, str2);
        }
    }

    public void recordNA20SuperFrameTimeStamp(int i, long j) {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            if (i == 1) {
                bVar.g = j;
            } else if (i == 2) {
                bVar.e = j;
            } else if (i != 3) {
            } else {
                bVar.f = j;
            }
        }
    }

    public void recordSearchBoxJsBridgeInvoked(String str) {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar == null || TextUtils.isEmpty(str) || !str.startsWith("baiduboxapp://v1/browser/open") || !str.contains("isContainer=1")) {
            return;
        }
        bVar.d = System.currentTimeMillis();
        Log.d("linhua-x", "recordSearchBoxJsBridgeInvoked: ".concat(String.valueOf(str)));
    }

    public void recordSearchTimeStamp(int i, long j) {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
            if (i == 1) {
                bVar.a = j;
            } else if (i == 2) {
                bVar.b = j;
            } else if (i != 3) {
            } else {
                bVar.c = j;
            }
        }
    }

    public void recordWebViewTimeStamp(String str, long j) {
        b bVar = this.sExtraInterfaceProvider;
        if (bVar != null) {
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
        clearPageSessionObserver();
        this.mPageSessionObserverList = null;
        this.mBusinessEventHandler = null;
        sInstance = null;
    }

    public void removePageSessionObserver(PageSessionObserver pageSessionObserver) {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList = this.mPageSessionObserverList;
        if (copyOnWriteArrayList == null || pageSessionObserver == null) {
            return;
        }
        copyOnWriteArrayList.remove(pageSessionObserver);
    }

    public void setStatisticsTransmission(IStatisticsTransmission iStatisticsTransmission) {
        this.mStatisticsTransmission = iStatisticsTransmission;
    }

    public void startFrameworkBehaviorMonitor() {
        a aVar = this.sFrameworkBehaviorProvider;
        if (aVar.a == null) {
            aVar.a = new a.C0510a(aVar, (byte) 0);
        }
        a.C0510a c0510a = aVar.a;
        if (c0510a.c == -1) {
            c0510a.a();
        }
        a.C0510a c0510a2 = aVar.a;
        if (c0510a2.f) {
            return;
        }
        c0510a2.f = true;
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
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
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
            } catch (Throwable unused) {
            }
        }
    }
}
