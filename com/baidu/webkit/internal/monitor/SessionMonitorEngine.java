package com.baidu.webkit.internal.monitor;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SessionMonitorEngine implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "SessionMonitorEngine";
    public static final int MONITOR_FRAMEWORK_TYPE_ASYNC_SEARCH_EVAJS = 2;
    public static final int MONITOR_FRAMEWORK_TYPE_SEARCH_CLICK = 1;
    public static final int MONITOR_FRAMEWORK_TYPE_SYNC_SEARCH_LOADURL = 3;
    public static final String PUBLIC_DATA_UNDIFNED = "undefined";
    public static final int STATUS_CODE_FAILED = 0;
    public static final int STATUS_CODE_SUCCESS = 1;
    public static SessionMonitorEngine sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Integer, LinkedList<WeakReference<IExtraInfoCollector>>> mExtraInfoCollectors;
    public CopyOnWriteArrayList<PageSessionObserver> mPageSessionObserverList;
    public JSONObject mStaticPublicData;
    public IStatisticsTransmission mStatisticsTransmission;
    public String mWiseSid;
    public b sExtraInterfaceProvider;
    public a sFrameworkBehaviorProvider;
    public WeakReference<IPrototype> sImplement;

    /* loaded from: classes9.dex */
    public interface IExtraInfoCollector extends INoProGuard {
        JSONObject onPageSessionFinished(WebView webView, String str);

        void onPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3);
    }

    /* loaded from: classes9.dex */
    public interface IPrototype extends INoProGuard {
        void OnAppEnterBackground();

        void OnAppEnterForeground();

        void notifyPageActive(String str, WebView webView, boolean z);

        void notifyPageLeave(String str, WebView webView);

        void onWebkitPaused();

        void onWebkitResumed();

        void record(WebView webView, IZeusMonitor iZeusMonitor);

        void record(WebView webView, String str);

        void recordBySourceId(WebView webView, long j2, int i2, JSONObject jSONObject);

        void recordImmediately(String str, String str2);
    }

    /* loaded from: classes9.dex */
    public interface PageSessionObserver extends INoProGuard {
        void onPageSessionDataRecord(WebView webView, String str, String str2, int i2, String str3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-648622035, "Lcom/baidu/webkit/internal/monitor/SessionMonitorEngine;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-648622035, "Lcom/baidu/webkit/internal/monitor/SessionMonitorEngine;");
        }
    }

    public SessionMonitorEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (this.sExtraInterfaceProvider == null) {
            this.sExtraInterfaceProvider = new b();
        }
        if (this.sFrameworkBehaviorProvider == null) {
            this.sFrameworkBehaviorProvider = new a();
        }
        if (this.mPageSessionObserverList == null) {
            this.mPageSessionObserverList = new CopyOnWriteArrayList<>();
        }
    }

    public static SessionMonitorEngine getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new SessionMonitorEngine();
            }
            return sInstance;
        }
        return (SessionMonitorEngine) invokeV.objValue;
    }

    private JSONObject processStaticPublicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
                    int i2 = Build.VERSION.SDK_INT;
                    this.mStaticPublicData.put("product", str3);
                    this.mStaticPublicData.put("brand", str);
                    this.mStaticPublicData.put("model", str2);
                    this.mStaticPublicData.put("version", str4);
                    this.mStaticPublicData.put("sdk", i2);
                    String str5 = LOG_TAG;
                    Log.i(str5, "processStaticPublicData: " + this.mStaticPublicData.toString());
                } catch (Throwable th) {
                    Log.printStackTrace(th);
                }
            }
            return this.mStaticPublicData;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void OnAppEnterBackground() {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().OnAppEnterBackground();
    }

    public void OnAppEnterForeground() {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().OnAppEnterForeground();
    }

    public void addPageSessionObserver(PageSessionObserver pageSessionObserver) {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pageSessionObserver) == null) || (copyOnWriteArrayList = this.mPageSessionObserverList) == null || pageSessionObserver == null) {
            return;
        }
        copyOnWriteArrayList.add(pageSessionObserver);
    }

    public void clearPageSessionObserver() {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (copyOnWriteArrayList = this.mPageSessionObserverList) == null) {
            return;
        }
        copyOnWriteArrayList.clear();
    }

    public void decorateMonitorEngine(IPrototype iPrototype) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iPrototype) == null) || iPrototype == null) {
            return;
        }
        this.sImplement = new WeakReference<>(iPrototype);
    }

    public String getPublicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject processStaticPublicData = processStaticPublicData();
            if (processStaticPublicData == null) {
                return PUBLIC_DATA_UNDIFNED;
            }
            try {
                processStaticPublicData.put("session_id", WebKitFactory.getStatisticsSessionId());
                processStaticPublicData.put(DpStatConstants.KEY_KERNEL_SESSION_ID, WebKitFactory.getKernelSessionId());
                processStaticPublicData.put("network", NetWorkUtils.getNetWorkType() + "_" + NetWorkUtils.getOperatorType());
                IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
                if (abTestInterface != null) {
                    JSONObject rawSwitch = abTestInterface.getRawSwitch();
                    processStaticPublicData.put("searchbox_ab_rsid", rawSwitch);
                    Log.i("linhua-x", "searchbox_ab_rsid is ".concat(String.valueOf(rawSwitch)));
                }
                HashMap<String, String> statisticParams = WebKitFactory.getStatisticParams();
                if (statisticParams != null && !statisticParams.isEmpty()) {
                    for (String str : statisticParams.keySet()) {
                        processStaticPublicData.put(str, statisticParams.get(str));
                    }
                }
                return processStaticPublicData.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeV.objValue;
    }

    public long getRecordNA20SuperFrameTimeStamp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar != null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return -1L;
                        }
                        return bVar.f63447f;
                    }
                    return bVar.f63446e;
                }
                return bVar.f63448g;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    public long getSearchButtonClickedTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar != null) {
                return bVar.f63442a;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public IStatisticsTransmission getStatisticsTransmission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStatisticsTransmission : (IStatisticsTransmission) invokeV.objValue;
    }

    public JSONObject getWebViewTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar != null) {
                return bVar.f63449h;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONArray notifyCollectorPageSessionFinished(WebView webView, String str) {
        InterceptResult invokeLL;
        JSONObject onPageSessionFinished;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, str)) == null) {
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
        return (JSONArray) invokeLL.objValue;
    }

    public final void notifyCollectorPageSessionStarted(WebView webView, String str, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048588, this, str, webView, z) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().notifyPageActive(str, webView, z);
    }

    public void notifyPageLeave(String str, WebView webView) {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, webView) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().notifyPageLeave(str, webView);
    }

    public void onPageKeySectionTimeCost(WebView webView, String str, int i2, long j2) {
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{webView, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (provider = WebViewFactory.getProvider()) == null) {
            return;
        }
        provider.onPageKeySectionTimeCostKeySection(webView, str, i2, j2);
    }

    public void onPageSessionDataRecord(WebView webView, String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{webView, str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) || this.mPageSessionObserverList == null) {
            return;
        }
        Log.i("huqin-ps2", "onPageSessionDataRecord, webView = " + webView.hashCode() + ", url = " + str + ", type = " + i2 + ", status = " + i3 + ", data = " + str2);
        Iterator<PageSessionObserver> it = this.mPageSessionObserverList.iterator();
        while (it.hasNext()) {
            it.next().onPageSessionDataRecord(webView, str, String.valueOf(i2), i3, str2);
        }
    }

    public JSONObject peekFrameworkBehaviorValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.sFrameworkBehaviorProvider.a() : (JSONObject) invokeV.objValue;
    }

    public JSONObject peekNA20SuperFrameTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject peekSearchTimeStamps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b bVar = this.sExtraInterfaceProvider;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void record(WebView webView, String str) {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, webView, str) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().record(webView, str);
    }

    public void recordBySourceId(WebView webView, long j2, int i2, JSONObject jSONObject) {
        WeakReference<IPrototype> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{webView, Long.valueOf(j2), Integer.valueOf(i2), jSONObject}) == null) || (weakReference = this.sImplement) == null || weakReference.get() == null) {
            return;
        }
        this.sImplement.get().recordBySourceId(webView, j2, i2, jSONObject);
    }

    public void recordFrameworkBehaviorValue(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, obj) == null) {
            a aVar = this.sFrameworkBehaviorProvider;
            if (aVar.f63433a == null) {
                aVar.f63433a = new a.C1864a(aVar, (byte) 0);
            }
            if (i2 == 9) {
                aVar.f63433a.a();
                aVar.f63433a.f63439f = true;
            }
            a.C1864a c1864a = aVar.f63433a;
            if (c1864a.f63439f) {
                switch (i2) {
                    case 7:
                        c1864a.f63434a = ((Boolean) obj).booleanValue();
                        return;
                    case 8:
                        c1864a.f63435b = ((Boolean) obj).booleanValue();
                        return;
                    case 9:
                        c1864a.f63436c = ((Long) obj).longValue();
                        return;
                    case 10:
                        c1864a.f63437d = ((Long) obj).longValue();
                        aVar.f63433a.f63439f = true;
                        return;
                    case 11:
                        c1864a.f63438e = ((Boolean) obj).booleanValue();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void recordFrameworkBehaviorValue(String str, long j2) {
        a aVar;
        a.C1864a c1864a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048598, this, str, j2) == null) || (c1864a = (aVar = this.sFrameworkBehaviorProvider).f63433a) == null) {
            return;
        }
        aVar.f63433a.f63440g.put(str, Long.valueOf(j2 + (c1864a.f63440g.containsKey(str) ? aVar.f63433a.f63440g.get(str).longValue() : 0L)));
    }

    public void recordImmediately(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
            WeakReference<IPrototype> weakReference = this.sImplement;
            if (weakReference == null || weakReference.get() == null) {
                uploadRealTimeData(str, str2);
            } else {
                this.sImplement.get().recordImmediately(str, str2);
            }
        }
    }

    public void recordNA20SuperFrameTimeStamp(int i2, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = this.sExtraInterfaceProvider) == null) {
            return;
        }
        if (i2 == 1) {
            bVar.f63448g = j2;
        } else if (i2 == 2) {
            bVar.f63446e = j2;
        } else if (i2 != 3) {
        } else {
            bVar.f63447f = j2;
        }
    }

    public void recordSearchBoxJsBridgeInvoked(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (bVar = this.sExtraInterfaceProvider) != null && !TextUtils.isEmpty(str) && str.startsWith("baiduboxapp://v1/browser/open") && str.contains("isContainer=1")) {
            bVar.f63445d = System.currentTimeMillis();
            Log.d("linhua-x", "recordSearchBoxJsBridgeInvoked: ".concat(String.valueOf(str)));
        }
    }

    public void recordSearchTimeStamp(int i2, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = this.sExtraInterfaceProvider) == null) {
            return;
        }
        if (i2 == 1) {
            bVar.f63442a = j2;
        } else if (i2 == 2) {
            bVar.f63443b = j2;
        } else if (i2 != 3) {
        } else {
            bVar.f63444c = j2;
        }
    }

    public void recordWebViewTimeStamp(String str, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048603, this, str, j2) == null) || (bVar = this.sExtraInterfaceProvider) == null) {
            return;
        }
        if (bVar.f63449h == null) {
            bVar.f63449h = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(str) || bVar.f63449h.has(str)) {
                return;
            }
            bVar.f63449h.put(str, j2);
        } catch (JSONException e2) {
            Log.printStackTrace(e2);
        }
    }

    public final void registerPageSessionExtraCollector(WebView webView, IExtraInfoCollector iExtraInfoCollector) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, webView, iExtraInfoCollector) == null) || iExtraInfoCollector == null || webView == null || webView.isDestroyed()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.sImplement = null;
            this.sExtraInterfaceProvider = null;
            this.sFrameworkBehaviorProvider = null;
            clearPageSessionObserver();
            this.mPageSessionObserverList = null;
            sInstance = null;
        }
    }

    public void removePageSessionObserver(PageSessionObserver pageSessionObserver) {
        CopyOnWriteArrayList<PageSessionObserver> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, pageSessionObserver) == null) || (copyOnWriteArrayList = this.mPageSessionObserverList) == null || pageSessionObserver == null) {
            return;
        }
        copyOnWriteArrayList.remove(pageSessionObserver);
    }

    public void setStatisticsTransmission(IStatisticsTransmission iStatisticsTransmission) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iStatisticsTransmission) == null) {
            this.mStatisticsTransmission = iStatisticsTransmission;
        }
    }

    public void startFrameworkBehaviorMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            a aVar = this.sFrameworkBehaviorProvider;
            if (aVar.f63433a == null) {
                aVar.f63433a = new a.C1864a(aVar, (byte) 0);
            }
            a.C1864a c1864a = aVar.f63433a;
            if (c1864a.f63436c == -1) {
                c1864a.a();
            }
            a.C1864a c1864a2 = aVar.f63433a;
            if (c1864a2.f63439f) {
                return;
            }
            c1864a2.f63439f = true;
        }
    }

    public void updateCuidIfNeeded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.mStaticPublicData == null) {
            return;
        }
        try {
            this.mStaticPublicData.put("cuid", WebKitFactory.getCUIDString());
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public void updateWiseSids(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.mWiseSid = str;
        }
    }

    public void uploadRealTimeData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) {
            uploadRealTimeData(str, str2, true);
        }
    }

    public void uploadRealTimeData(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048612, this, str, str2, z) == null) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
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
