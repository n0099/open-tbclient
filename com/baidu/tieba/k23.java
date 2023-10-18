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
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.og4;
import com.baidu.tieba.ta2;
import com.baidu.tieba.wa2;
import com.baidu.tieba.wallet.YYPayManager;
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
/* loaded from: classes6.dex */
public final class k23 extends g23 {
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c> a;

        /* loaded from: classes6.dex */
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
                    p22.k("SwanAppMessengerClient", "Recovery kill self");
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
                return wo2.q0().a(message);
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
                f83.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e) {
                if (k23.h) {
                    e.printStackTrace();
                }
            }
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                p53 c0 = p53.c0();
                c83 b = c83.b();
                if (bundle != null && c0 != null && b != null && TextUtils.equals(bundle.getString("ai_apps_key", ""), c0.P())) {
                    b.j();
                }
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            la1 la1Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048590, this, message) != null) || message == null || (bundle = (Bundle) message.obj) == null || (la1Var = dy2.b().d) == null) {
                return;
            }
            la1Var.onPayResult(dy2.a(bundle.getInt(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public final void r(p53 p53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, p53Var) == null) {
                cp1 a2 = p53Var.x().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                dm1 N = p53Var.N();
                N.h(N.c(AppRuntime.getAppContext()));
            }
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull p53 p53Var, ua2 ua2Var) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, p53Var, ua2Var)) == null) {
                SwanAppConfigData R = p53Var.R();
                if (R == null) {
                    if (k23.h) {
                        Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                        return null;
                    }
                    return null;
                }
                String o1 = mq2.o1(prefetchEvent.schema, R);
                if (TextUtils.isEmpty(o1)) {
                    if (ua2Var.b) {
                        return R.g(ua2Var.c);
                    }
                    return R.f();
                }
                return o1;
            }
            return (String) invokeLLL.objValue;
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (k23.h) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
                }
                kc2.e();
                p53 c0 = p53.c0();
                if (c0 != null) {
                    if (!TextUtils.isEmpty(c0.X().W())) {
                        ec2.c(18);
                        return;
                    } else if (c0.I()) {
                        if (!"update_tag_by_activity_on_create".equals(c0.k0())) {
                            if ("update_tag_by_activity_on_new_intent".equals(c0.k0())) {
                                ec2.c(17);
                                return;
                            } else {
                                ec2.c(6);
                                return;
                            }
                        }
                        ec2.c(16);
                        if (!wa2.a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    ec2.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    ec2.c(8);
                } else if (!jc2.V().n0()) {
                    ec2.c(9);
                    jc2.V().I0(null);
                } else {
                    if (k23.h) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    hz2.j().m();
                    o53.K().l(bundle2, "update_tag_by_app_launch");
                    p53 c02 = p53.c0();
                    if (c02 != null && lo2.O(c02)) {
                        Set<og4.a> i = w03.i(c02.X().g0());
                        c02.N0(i);
                        if (i != null && !i.isEmpty()) {
                            ec2.c(19);
                            return;
                        }
                        za2.k().x(bundle2.getString("mAppId", null), false);
                        if (k23.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        cr2.V().R(c02.k());
                        jc2.V().X0(c02);
                        if (k92.a() && k92.c()) {
                            p22.i("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            wm2.a();
                        }
                        if (k23.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                            return;
                        }
                        return;
                    }
                    ec2.c(10);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            p53 c0;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (y72.b().a() == null || (c0 = p53.c0()) == null || c0.I()) {
                    return false;
                }
                int i = message.what;
                if (i != 100) {
                    if (i != 103) {
                        if (i != 106) {
                            return false;
                        }
                        if (k23.h) {
                            Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                        }
                        o53.K().s();
                    } else {
                        if (k23.h) {
                            Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                        }
                        c0.f0().i();
                        lx2.g().v();
                        r(c0);
                    }
                } else {
                    if (k23.h) {
                        Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                    }
                    r(c0);
                    o53.K().s();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion m;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, message) != null) || message == null || !TextUtils.isEmpty(o53.K().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j != 0 && (m = xo2.i().m()) != null) {
                long j2 = m.swanCoreVersionCode;
                if (j2 != 0 && j2 < j) {
                    if (k23.h) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + m);
                    }
                    xo2.i().release();
                }
            }
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(o53.K().getAppId())) {
                if (k23.h) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || jc2.V().e0() == null) {
                    return;
                }
                if (k23.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + jc2.V().e0());
                }
                jc2.R0();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (k23.h) {
                    Log.i("SwanAppMessengerClient", "handleKillActivity");
                }
                if (o53.K().E()) {
                    yh3.j(o53.K().w());
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
            o53.K().l(bundle, null);
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
                p22.k("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + o53.K().E());
                if (o53.K().E()) {
                    o53.K().n("flag_finish_activity", "flag_remove_task");
                    jj3.a0(new a(this));
                    return;
                }
                p22.k("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                if (k23.h) {
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
                            o53.K().v("event_messenger_call_in", (Bundle) message.obj);
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
                        ia1.a((Bundle) message.obj);
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
                        i23.d(message);
                        return;
                    case 130:
                        e82.i().g((Bundle) message.obj);
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
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(o53.K().getAppId())) {
                if (k23.h) {
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
                ExtensionCore U = jc2.V().U();
                if (k23.h) {
                    Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + U);
                }
                if (U != null && U.extensionCoreVersionCode < j) {
                    if (k23.h) {
                        Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + U);
                    }
                    jc2.R0();
                }
            }
        }

        public final void i(Message message) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                if (k23.h) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                String uuid = UUID.randomUUID().toString();
                sa2 d = sa2.d();
                d.g(uuid);
                d.b(uuid, new UbcFlowEvent("prefetch_start"));
                d.j(uuid, 3000L);
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent != null && prefetchEvent.isValid()) {
                    sa2 d2 = sa2.d();
                    ta2.b a2 = ta2.a();
                    a2.h(RecordType.APP_ID);
                    a2.f(prefetchEvent.appId);
                    d2.f(uuid, a2.e());
                    p22.k("SwanAppMessengerClient", "get prefetch event");
                    if (k23.h) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                    }
                    boolean z = false;
                    if (q(prefetchEvent, bundle)) {
                        sa2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_start"));
                        mq2.a aVar = new mq2.a();
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            pMSAppInfo = md4.i().u(prefetchEvent.appId);
                        }
                        aVar.T0(pMSAppInfo);
                        o53.K().l(aVar.D(), "update_tag_by_prefetch");
                        p22.k("SwanAppMessengerClient", "shouldUpdateForPrefetch for current Preload");
                        sa2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_end"));
                        z = true;
                    }
                    p53 q = o53.K().q();
                    if (q == null) {
                        return;
                    }
                    SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                    if (qz2.e()) {
                        nx2.g(true);
                    }
                    PMSAppInfo g0 = q.X().g0();
                    if (g0 != null && !g0.isMaxAgeExpires()) {
                        o92.g().c(prefetchEvent);
                        if (TextUtils.equals(prefetchEvent.appId, g0.appId)) {
                            o(uuid, q, g0);
                            sa2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start"));
                            ua2 a3 = va2.a(g0, mq2.p1(prefetchEvent.schema));
                            if (a3 != null && a3.a()) {
                                File file = new File(a3.a, "app.json");
                                if ((q.R() == null || z) && !lo2.P(q, a3.a)) {
                                    p22.k("SwanAppMessengerClient", "updateSwanAppConfig failed");
                                    if (k23.h) {
                                        Log.w("SwanAppMessengerClient", "can not find app config file");
                                        return;
                                    }
                                    return;
                                } else if (q.R() == null) {
                                    p22.k("SwanAppMessengerClient", "swanApp.getConfig() == null");
                                    return;
                                } else {
                                    sa2.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start_end"));
                                    prefetchEvent.appConfig = lo2.m(file);
                                    prefetchEvent.appPath = lo2.e.i(prefetchEvent.appId, String.valueOf(g0.versionCode)).getPath() + File.separator;
                                    String b = b(prefetchEvent, q, a3);
                                    prefetchEvent.pageUrl = b;
                                    prefetchEvent.rootPath = dc2.c(q, b);
                                    prefetchEvent.pageType = q.R().h(prefetchEvent.pageUrl);
                                    prefetchEvent.sConsole = String.valueOf(o22.c());
                                    prefetchEvent.version = String.valueOf(g0.versionCode);
                                    if (!TextUtils.isEmpty(g0.userActionApis)) {
                                        prefetchEvent.userActionApis = String.valueOf(g0.userActionApis);
                                    }
                                    la2.c(prefetchEvent);
                                    if (!p92.p() && !TextUtils.equals(prefetchEvent.pageType, "main")) {
                                        p22.k("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                                        return;
                                    }
                                    if (k23.h) {
                                        Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                                    }
                                    jc2.V().y0(uuid, prefetchEvent, g0);
                                }
                            } else {
                                p22.k("SwanAppMessengerClient", "can not find app.json anywhere");
                                return;
                            }
                        }
                        if (k23.h) {
                            Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.d("SwanAppMessengerClient", "prefetch cost - " + (currentTimeMillis - j) + "ms");
                            return;
                        }
                        return;
                    }
                    p22.k("SwanAppMessengerClient", "appInfo==null or appInfo isMaxAgeExpires");
                }
            }
        }

        public final void o(String str, p53 p53Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, p53Var, pMSAppInfo) == null) {
                sa2 d = sa2.d();
                ta2.b a2 = ta2.a();
                a2.h(RecordType.APP_ID);
                a2.f(pMSAppInfo.appId);
                d.f(str, a2.e());
                ta2.b a3 = ta2.a();
                a3.h(RecordType.APP_VERSION);
                a3.f(String.valueOf(pMSAppInfo.versionCode));
                d.f(str, a3.e());
                ta2.b a4 = ta2.a();
                a4.h(RecordType.PREFETCH_TYPE);
                a4.g(p53Var.I());
                d.f(str, a4.e());
            }
        }

        public final boolean q(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, prefetchEvent, bundle)) == null) {
                p53 c0 = p53.c0();
                if (c0 == null) {
                    return true;
                }
                if (c0.I() || !TextUtils.isEmpty(c0.X().W())) {
                    return false;
                }
                if (!TextUtils.equals(c0.getAppId(), prefetchEvent.appId)) {
                    return true;
                }
                PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                if (pMSAppInfo == null) {
                    return false;
                }
                PMSAppInfo g0 = c0.X().g0();
                if (g0 == null || g0.versionCode != pMSAppInfo.versionCode) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k23 a;

        public b(k23 k23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k23Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (k23.h) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                this.a.U();
            }
        }

        public /* synthetic */ b(k23 k23Var, a aVar) {
            this(k23Var);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (k23.h) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (this.a.O() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (k23.h) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.a.O()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                this.a.c = IProcessBridge.Stub.asInterface(iBinder);
                k23 k23Var = this.a;
                k23Var.Z(13, k23Var.P());
                if (this.a.d != null) {
                    this.a.d.a();
                }
                f23.e().c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947861149, "Lcom/baidu/tieba/k23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947861149, "Lcom/baidu/tieba/k23;");
                return;
            }
        }
        h = am1.a;
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

    public synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                if (h) {
                    Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
                }
                if (this.e == null) {
                    this.e = new b(this, null);
                    Application c2 = wo2.c();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k23(s53 s53Var) {
        super(s53Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s53Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((s53) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new e();
        this.f = new ArrayDeque();
    }

    @Deprecated
    public static k23 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return o53.K().y();
        }
        return (k23) invokeV.objValue;
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
    public void W(@Nullable Bundle bundle, @NonNull Class<? extends p13> cls) {
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
            f23.e().h(new h23(obtain));
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

    @Deprecated
    public void X(@Nullable Bundle bundle, @NonNull Class<? extends p13> cls, @Nullable w13 w13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bundle, cls, w13Var) == null) {
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (w13Var != null) {
                bundle2.putString("ai_apps_observer_id", w13Var.b());
                t13.b().e(w13Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            f23 e2 = f23.e();
            h23 h23Var = new h23(obtain);
            h23Var.p(true);
            e2.h(h23Var);
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
            f23.e().h(new h23(obtain));
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
            f23.e().h(new h23(obtain));
        }
    }
}
