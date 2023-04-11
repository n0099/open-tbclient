package com.baidu.tieba;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bd2;
import com.baidu.tieba.qq2;
import com.baidu.tieba.rs2;
import com.baidu.tieba.ti4;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.tieba.yc2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class p43 extends l43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static final long i;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final e b;
    public IProcessBridge c;
    public d d;
    public ServiceConnection e;
    public final Deque<Long> f;
    public List<Runnable> g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c> a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    u42.k("SwanAppMessengerClient", "Recovery kill self");
                    Process.killProcess(Process.myPid());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final boolean a(Message message) {
            InterceptResult invokeL;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                WeakReference<c> weakReference = this.a;
                if (weakReference != null) {
                    cVar = weakReference.get();
                } else {
                    cVar = null;
                }
                if ((cVar != null && cVar.a(message)) || e(message)) {
                    return true;
                }
                return br2.q0().a(message);
            }
            return invokeL.booleanValue;
        }

        public final void c(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) != null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            String string = bundle.getString("ai_apps_data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                ka3.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e) {
                if (p43.h) {
                    e.printStackTrace();
                }
            }
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                u73 b0 = u73.b0();
                ha3 b = ha3.b();
                if (bundle != null && b0 != null && b != null && TextUtils.equals(bundle.getString("ai_apps_key", ""), b0.O())) {
                    b.j();
                }
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            re1 re1Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048590, this, message) != null) || message == null || (bundle = (Bundle) message.obj) == null || (re1Var = i03.b().d) == null) {
                return;
            }
            re1Var.onPayResult(i03.a(bundle.getInt(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public final void r(u73 u73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, u73Var) == null) {
                gr1 a2 = u73Var.x().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                ho1 N = u73Var.N();
                N.h(N.c(AppRuntime.getAppContext()));
            }
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull u73 u73Var, zc2 zc2Var) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, u73Var, zc2Var)) == null) {
                SwanAppConfigData Q = u73Var.Q();
                if (Q == null) {
                    if (p43.h) {
                        Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                        return null;
                    }
                    return null;
                }
                String n1 = rs2.n1(prefetchEvent.schema, Q);
                if (TextUtils.isEmpty(n1)) {
                    if (zc2Var.b) {
                        return Q.g(zc2Var.c);
                    }
                    return Q.f();
                }
                return n1;
            }
            return (String) invokeLLL.objValue;
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (p43.h) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
                }
                pe2.e();
                u73 b0 = u73.b0();
                if (b0 != null) {
                    if (!TextUtils.isEmpty(b0.W().V())) {
                        je2.c(18);
                        return;
                    } else if (b0.I()) {
                        if (!"update_tag_by_activity_on_create".equals(b0.j0())) {
                            if ("update_tag_by_activity_on_new_intent".equals(b0.j0())) {
                                je2.c(17);
                                return;
                            } else {
                                je2.c(6);
                                return;
                            }
                        }
                        je2.c(16);
                        if (!bd2.a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    je2.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    je2.c(8);
                } else if (!oe2.U().m0()) {
                    je2.c(9);
                    oe2.U().H0(null);
                } else {
                    if (p43.h) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    m13.j().m();
                    t73.K().l(bundle2, "update_tag_by_app_launch");
                    u73 b02 = u73.b0();
                    if (b02 != null && qq2.O(b02)) {
                        Set<ti4.a> i = b33.i(b02.W().f0());
                        b02.M0(i);
                        if (i != null && !i.isEmpty()) {
                            je2.c(19);
                            return;
                        }
                        ed2.k().x(bundle2.getString("mAppId", null), false);
                        if (p43.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        ht2.U().Q(b02.k());
                        oe2.U().W0(b02);
                        if (pb2.a() && pb2.c()) {
                            u42.i("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            bp2.a();
                        }
                        if (p43.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                            return;
                        }
                        return;
                    }
                    je2.c(10);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            u73 b0;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (da2.b().a() == null || (b0 = u73.b0()) == null || b0.I()) {
                    return false;
                }
                int i = message.what;
                if (i != 100) {
                    if (i != 103) {
                        if (i != 106) {
                            return false;
                        }
                        if (p43.h) {
                            Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                        }
                        t73.K().s();
                    } else {
                        if (p43.h) {
                            Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                        }
                        b0.e0().i();
                        qz2.g().v();
                        r(b0);
                    }
                } else {
                    if (p43.h) {
                        Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                    }
                    r(b0);
                    t73.K().s();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion m;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, message) != null) || message == null || !TextUtils.isEmpty(t73.K().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j != 0 && (m = cr2.i().m()) != null) {
                long j2 = m.swanCoreVersionCode;
                if (j2 != 0 && j2 < j) {
                    if (p43.h) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + m);
                    }
                    cr2.i().release();
                }
            }
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(t73.K().getAppId())) {
                if (p43.h) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || oe2.U().d0() == null) {
                    return;
                }
                if (p43.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + oe2.U().d0());
                }
                oe2.Q0();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (p43.h) {
                    Log.i("SwanAppMessengerClient", "handleKillActivity");
                }
                if (t73.K().E()) {
                    dk3.j(t73.K().w());
                }
            }
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048586, this, message) != null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            t73.K().l(bundle, null);
        }

        public void p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
                this.a = new WeakReference<>(cVar);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                u42.k("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + t73.K().E());
                if (t73.K().E()) {
                    t73.K().n("flag_finish_activity", "flag_remove_task");
                    ol3.a0(new a(this));
                    return;
                }
                u42.k("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                if (p43.h) {
                    Log.i("SwanAppMessengerClient", "handleMessage => " + message);
                }
                switch (message.what) {
                    case 109:
                        return;
                    case 110:
                        g(message);
                        return;
                    case 111:
                        if (message.obj instanceof Bundle) {
                            t73.K().v("event_messenger_call_in", (Bundle) message.obj);
                            return;
                        }
                        return;
                    case 112:
                    case 113:
                    case 123:
                    case 124:
                    case 125:
                    case 127:
                    case 128:
                    case 129:
                    default:
                        if (!a(message)) {
                            super.handleMessage(message);
                            return;
                        }
                        return;
                    case 114:
                        m(message);
                        return;
                    case 115:
                        n(message);
                        return;
                    case 116:
                        c(message);
                        return;
                    case 117:
                        l(message);
                        return;
                    case 118:
                        j(message);
                        return;
                    case 119:
                        oe1.a((Bundle) message.obj);
                        return;
                    case 120:
                        i(message);
                        return;
                    case 121:
                        k(message);
                        return;
                    case 122:
                        d(message);
                        return;
                    case 126:
                        n43.d(message);
                        return;
                    case 130:
                        ja2.i().g((Bundle) message.obj);
                        return;
                    case 131:
                        f(message);
                        return;
                    case 132:
                        h();
                        return;
                }
            }
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(t73.K().getAppId())) {
                if (p43.h) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0) {
                    return;
                }
                ExtensionCore T = oe2.U().T();
                if (p43.h) {
                    Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + T);
                }
                if (T != null && T.extensionCoreVersionCode < j) {
                    if (p43.h) {
                        Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + T);
                    }
                    oe2.Q0();
                }
            }
        }

        public final void i(Message message) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                if (p43.h) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                String uuid = UUID.randomUUID().toString();
                xc2 d = xc2.d();
                d.g(uuid);
                d.b(uuid, new UbcFlowEvent("prefetch_start"));
                d.j(uuid, 3000L);
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent != null && prefetchEvent.isValid()) {
                    xc2 d2 = xc2.d();
                    yc2.b a2 = yc2.a();
                    a2.h(RecordType.APP_ID);
                    a2.f(prefetchEvent.appId);
                    d2.f(uuid, a2.e());
                    u42.k("SwanAppMessengerClient", "get prefetch event");
                    if (p43.h) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                    }
                    boolean z = false;
                    if (q(prefetchEvent, bundle)) {
                        xc2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_start"));
                        rs2.a aVar = new rs2.a();
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            pMSAppInfo = rf4.i().u(prefetchEvent.appId);
                        }
                        aVar.S0(pMSAppInfo);
                        t73.K().l(aVar.D(), "update_tag_by_prefetch");
                        u42.k("SwanAppMessengerClient", "shouldUpdateForPrefetch for current Preload");
                        xc2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_end"));
                        z = true;
                    }
                    u73 q = t73.K().q();
                    if (q == null) {
                        return;
                    }
                    SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                    if (v13.e()) {
                        sz2.g(true);
                    }
                    PMSAppInfo f0 = q.W().f0();
                    if (f0 != null && !f0.isMaxAgeExpires()) {
                        tb2.g().c(prefetchEvent);
                        if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                            o(uuid, q, f0);
                            xc2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start"));
                            zc2 a3 = ad2.a(f0, rs2.o1(prefetchEvent.schema));
                            if (a3 != null && a3.a()) {
                                File file = new File(a3.a, "app.json");
                                if ((q.Q() == null || z) && !qq2.P(q, a3.a)) {
                                    u42.k("SwanAppMessengerClient", "updateSwanAppConfig failed");
                                    if (p43.h) {
                                        Log.w("SwanAppMessengerClient", "can not find app config file");
                                        return;
                                    }
                                    return;
                                } else if (q.Q() == null) {
                                    u42.k("SwanAppMessengerClient", "swanApp.getConfig() == null");
                                    return;
                                } else {
                                    xc2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start_end"));
                                    prefetchEvent.appConfig = qq2.m(file);
                                    prefetchEvent.appPath = qq2.e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                                    String b = b(prefetchEvent, q, a3);
                                    prefetchEvent.pageUrl = b;
                                    prefetchEvent.rootPath = ie2.c(q, b);
                                    prefetchEvent.pageType = q.Q().h(prefetchEvent.pageUrl);
                                    prefetchEvent.sConsole = String.valueOf(t42.c());
                                    prefetchEvent.version = String.valueOf(f0.versionCode);
                                    if (!TextUtils.isEmpty(f0.userActionApis)) {
                                        prefetchEvent.userActionApis = String.valueOf(f0.userActionApis);
                                    }
                                    qc2.c(prefetchEvent);
                                    if (!ub2.p() && !TextUtils.equals(prefetchEvent.pageType, "main")) {
                                        u42.k("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                                        return;
                                    }
                                    if (p43.h) {
                                        Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                                    }
                                    oe2.U().x0(uuid, prefetchEvent, f0);
                                }
                            } else {
                                u42.k("SwanAppMessengerClient", "can not find app.json anywhere");
                                return;
                            }
                        }
                        if (p43.h) {
                            Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.d("SwanAppMessengerClient", "prefetch cost - " + (currentTimeMillis - j) + "ms");
                            return;
                        }
                        return;
                    }
                    u42.k("SwanAppMessengerClient", "appInfo==null or appInfo isMaxAgeExpires");
                }
            }
        }

        public final void o(String str, u73 u73Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, u73Var, pMSAppInfo) == null) {
                xc2 d = xc2.d();
                yc2.b a2 = yc2.a();
                a2.h(RecordType.APP_ID);
                a2.f(pMSAppInfo.appId);
                d.f(str, a2.e());
                yc2.b a3 = yc2.a();
                a3.h(RecordType.APP_VERSION);
                a3.f(String.valueOf(pMSAppInfo.versionCode));
                d.f(str, a3.e());
                yc2.b a4 = yc2.a();
                a4.h(RecordType.PREFETCH_TYPE);
                a4.g(u73Var.I());
                d.f(str, a4.e());
            }
        }

        public final boolean q(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, prefetchEvent, bundle)) == null) {
                u73 b0 = u73.b0();
                if (b0 == null) {
                    return true;
                }
                if (b0.I() || !TextUtils.isEmpty(b0.W().V())) {
                    return false;
                }
                if (!TextUtils.equals(b0.getAppId(), prefetchEvent.appId)) {
                    return true;
                }
                PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                if (pMSAppInfo == null) {
                    return false;
                }
                PMSAppInfo f0 = b0.W().f0();
                if (f0 == null || f0.versionCode != pMSAppInfo.versionCode) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p43 a;

        public b(p43 p43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p43Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (p43.h) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                this.a.U();
            }
        }

        public /* synthetic */ b(p43 p43Var, a aVar) {
            this(p43Var);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (p43.h) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (this.a.O() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (p43.h) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.a.O()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                this.a.c = IProcessBridge.Stub.asInterface(iBinder);
                p43 p43Var = this.a;
                p43Var.Z(13, p43Var.P());
                if (this.a.d != null) {
                    this.a.d.a();
                }
                k43.e().c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948012026, "Lcom/baidu/tieba/p43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948012026, "Lcom/baidu/tieba/p43;");
                return;
            }
        }
        h = eo1.a;
        i = TimeUnit.MINUTES.toMillis(5L);
        j = new Object();
    }

    public final Bundle P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(CrashHianalyticsData.PROCESS_ID, SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", m());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p43(x73 x73Var) {
        super(x73Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x73Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((x73) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new e();
        this.f = new ArrayDeque();
    }

    @Deprecated
    public static p43 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return t73.K().y();
        }
        return (p43) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Handler R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (Handler) invokeV.objValue;
    }

    public IProcessBridge S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (IProcessBridge) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.f) {
                if (N()) {
                    this.f.offer(Long.valueOf(System.currentTimeMillis()));
                    c0();
                }
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Y(2);
        }
    }

    public void M(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, cVar) == null) {
            this.d = dVar;
            this.b.p(cVar);
            Z(1, P());
            if (this.d != null && O()) {
                this.d.a();
            }
        }
    }

    @Deprecated
    public void W(@Nullable Bundle bundle, @NonNull Class<? extends u33> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, cls) == null) {
            X(bundle, cls, null);
        }
    }

    public void Z(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            k43.e().h(new m43(obtain));
        }
    }

    public void V(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (j) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(runnable);
            }
        }
    }

    @Deprecated
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            b0(i2, "");
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f) {
                T("checkRebindable ===>");
                boolean z = false;
                if (this.f.size() < 3) {
                    T(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.f.size()), 3));
                    return true;
                }
                int size = this.f.size() - 3;
                T("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        T("purge: " + this.f.poll());
                    }
                }
                T("after purge");
                Long peek = this.f.peek();
                if (peek == null) {
                    T("allowRebind by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                if (currentTimeMillis > i) {
                    z = true;
                }
                T("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && h) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public synchronized void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.e = null;
                this.c = null;
                if (this.d != null) {
                    this.d.b();
                }
                d0();
                if (this.g != null) {
                    synchronized (j) {
                        for (Runnable runnable : this.g) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                        this.g.clear();
                    }
                }
            }
        }
    }

    public synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                if (h) {
                    Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
                }
                if (this.e == null) {
                    this.e = new b(this, null);
                    Application c2 = br2.c();
                    try {
                        c2.bindService(new Intent(c2, SwanAppMessengerService.class), this.e, 1);
                    } catch (Exception e2) {
                        if (h) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Deprecated
    public void X(@Nullable Bundle bundle, @NonNull Class<? extends u33> cls, @Nullable b43 b43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bundle, cls, b43Var) == null) {
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (b43Var != null) {
                bundle2.putString("ai_apps_observer_id", b43Var.b());
                y33.b().e(b43Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            k43 e2 = k43.e();
            m43 m43Var = new m43(obtain);
            m43Var.p(true);
            e2.h(m43Var);
        }
    }

    @Deprecated
    public void a0(int i2, SwanAppIPCData swanAppIPCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, swanAppIPCData) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i2 + " ipcData: " + swanAppIPCData);
            }
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.arg1 = current.index;
            Bundle bundle = new Bundle();
            if (swanAppIPCData != null) {
                bundle.putParcelable("ai_apps_data", swanAppIPCData);
            }
            bundle.putString("ai_apps_id", getAppId());
            obtain.obj = bundle;
            k43.e().h(new m43(obtain));
        }
    }

    @Deprecated
    public void b0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i2 + " strData: " + str);
            }
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.arg1 = current.index;
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ai_apps_data", str);
            }
            bundle.putString("ai_apps_id", getAppId());
            obtain.obj = bundle;
            k43.e().h(new m43(obtain));
        }
    }
}
