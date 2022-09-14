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
import com.baidu.tieba.c82;
import com.baidu.tieba.f82;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.tieba.xd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public final class tz2 extends pz2 {
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
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz2 a;

        public b(tz2 tz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz2Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (tz2.h) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (this.a.O() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (tz2.h) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.a.O()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                this.a.c = IProcessBridge.Stub.asInterface(iBinder);
                tz2 tz2Var = this.a;
                tz2Var.Z(13, tz2Var.P());
                if (this.a.d != null) {
                    this.a.d.a();
                }
                oz2.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                this.a.U();
            }
        }

        public /* synthetic */ b(tz2 tz2Var, a aVar) {
            this(tz2Var);
        }
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
                    yz1.k("SwanAppMessengerClient", "Recovery kill self");
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                WeakReference<c> weakReference = this.a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return fm2.q0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull y23 y23Var, d82 d82Var) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, y23Var, d82Var)) == null) {
                SwanAppConfigData Q = y23Var.Q();
                if (Q == null) {
                    if (tz2.h) {
                        Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                        return null;
                    }
                    return null;
                }
                String n1 = vn2.n1(prefetchEvent.schema, Q);
                if (TextUtils.isEmpty(n1)) {
                    if (d82Var.b) {
                        return Q.g(d82Var.c);
                    }
                    return Q.f();
                }
                return n1;
            }
            return (String) invokeLLL.objValue;
        }

        public final void c(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            String string = bundle.getString("ai_apps_data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                o53.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e) {
                if (tz2.h) {
                    e.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (tz2.h) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
                }
                t92.e();
                y23 b0 = y23.b0();
                if (b0 != null) {
                    if (!TextUtils.isEmpty(b0.W().V())) {
                        n92.c(18);
                        return;
                    } else if (b0.I()) {
                        if (!"update_tag_by_activity_on_create".equals(b0.j0())) {
                            if ("update_tag_by_activity_on_new_intent".equals(b0.j0())) {
                                n92.c(17);
                                return;
                            } else {
                                n92.c(6);
                                return;
                            }
                        }
                        n92.c(16);
                        if (!f82.a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    n92.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    n92.c(8);
                } else if (s92.U().m0()) {
                    if (tz2.h) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    qw2.j().m();
                    x23.K().l(bundle2, "update_tag_by_app_launch");
                    y23 b02 = y23.b0();
                    if (b02 != null && ul2.O(b02)) {
                        Set<xd4.a> i = fy2.i(b02.W().f0());
                        b02.M0(i);
                        if (i != null && !i.isEmpty()) {
                            n92.c(19);
                            return;
                        }
                        i82.k().x(bundle2.getString("mAppId", null), false);
                        if (tz2.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        lo2.U().Q(b02.k());
                        s92.U().W0(b02);
                        if (t62.a() && t62.c()) {
                            yz1.i("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            fk2.a();
                        }
                        if (tz2.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                            return;
                        }
                        return;
                    }
                    n92.c(10);
                } else {
                    n92.c(9);
                    s92.U().H0(null);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            y23 b0;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (h52.b().a() == null || (b0 = y23.b0()) == null || b0.I()) {
                    return false;
                }
                int i = message.what;
                if (i == 100) {
                    if (tz2.h) {
                        Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                    }
                    r(b0);
                    x23.K().s();
                } else if (i == 103) {
                    if (tz2.h) {
                        Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                    }
                    b0.e0().i();
                    uu2.g().v();
                    r(b0);
                } else if (i != 106) {
                    return false;
                } else {
                    if (tz2.h) {
                        Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                    }
                    x23.K().s();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                y23 b0 = y23.b0();
                l53 b = l53.b();
                if (bundle == null || b0 == null || b == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), b0.O())) {
                    return;
                }
                b.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (tz2.h) {
                    Log.i("SwanAppMessengerClient", "handleKillActivity");
                }
                if (x23.K().E()) {
                    hf3.j(x23.K().w());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                yz1.k("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + x23.K().E());
                if (x23.K().E()) {
                    x23.K().n("flag_finish_activity", "flag_remove_task");
                    sg3.a0(new a(this));
                    return;
                }
                yz1.k("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                if (tz2.h) {
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
                            x23.K().v("event_messenger_call_in", (Bundle) message.obj);
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
                        if (a(message)) {
                            return;
                        }
                        super.handleMessage(message);
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
                        q91.a((Bundle) message.obj);
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
                        rz2.d(message);
                        return;
                    case 130:
                        n52.i().g((Bundle) message.obj);
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

        public final void i(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                long currentTimeMillis = tz2.h ? System.currentTimeMillis() : 0L;
                String uuid = UUID.randomUUID().toString();
                b82 d = b82.d();
                d.g(uuid);
                d.b(uuid, new UbcFlowEvent("prefetch_start"));
                d.j(uuid, 3000L);
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent == null || !prefetchEvent.isValid()) {
                    return;
                }
                b82 d2 = b82.d();
                c82.b a2 = c82.a();
                a2.h(RecordType.APP_ID);
                a2.f(prefetchEvent.appId);
                d2.f(uuid, a2.e());
                yz1.k("SwanAppMessengerClient", "get prefetch event");
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                boolean z = false;
                if (q(prefetchEvent, bundle)) {
                    b82.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_start"));
                    vn2.a aVar = new vn2.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = va4.i().u(prefetchEvent.appId);
                    }
                    aVar.S0(pMSAppInfo);
                    x23.K().l(aVar.D(), "update_tag_by_prefetch");
                    yz1.k("SwanAppMessengerClient", "shouldUpdateForPrefetch for current Preload");
                    b82.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_end"));
                    z = true;
                }
                y23 q = x23.K().q();
                if (q == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                if (zw2.e()) {
                    wu2.g(true);
                }
                PMSAppInfo f0 = q.W().f0();
                if (f0 != null && !f0.isMaxAgeExpires()) {
                    x62.g().c(prefetchEvent);
                    if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                        o(uuid, q, f0);
                        b82.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start"));
                        d82 a3 = e82.a(f0, vn2.o1(prefetchEvent.schema));
                        if (a3 != null && a3.a()) {
                            File file = new File(a3.a, "app.json");
                            if ((q.Q() == null || z) && !ul2.P(q, a3.a)) {
                                yz1.k("SwanAppMessengerClient", "updateSwanAppConfig failed");
                                if (tz2.h) {
                                    Log.w("SwanAppMessengerClient", "can not find app config file");
                                    return;
                                }
                                return;
                            } else if (q.Q() == null) {
                                yz1.k("SwanAppMessengerClient", "swanApp.getConfig() == null");
                                return;
                            } else {
                                b82.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start_end"));
                                prefetchEvent.appConfig = ul2.m(file);
                                prefetchEvent.appPath = ul2.e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                                String b = b(prefetchEvent, q, a3);
                                prefetchEvent.pageUrl = b;
                                prefetchEvent.rootPath = m92.c(q, b);
                                prefetchEvent.pageType = q.Q().h(prefetchEvent.pageUrl);
                                prefetchEvent.sConsole = String.valueOf(xz1.c());
                                prefetchEvent.version = String.valueOf(f0.versionCode);
                                if (!TextUtils.isEmpty(f0.userActionApis)) {
                                    prefetchEvent.userActionApis = String.valueOf(f0.userActionApis);
                                }
                                u72.c(prefetchEvent);
                                if (y62.p() || TextUtils.equals(prefetchEvent.pageType, "main")) {
                                    if (tz2.h) {
                                        Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                                    }
                                    s92.U().x0(uuid, prefetchEvent, f0);
                                } else {
                                    yz1.k("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                                    return;
                                }
                            }
                        } else {
                            yz1.k("SwanAppMessengerClient", "can not find app.json anywhere");
                            return;
                        }
                    }
                    if (tz2.h) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("SwanAppMessengerClient", "prefetch cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        return;
                    }
                    return;
                }
                yz1.k("SwanAppMessengerClient", "appInfo==null or appInfo isMaxAgeExpires");
            }
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            x23.K().l(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(x23.K().getAppId())) {
                if (tz2.h) {
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
                ExtensionCore T = s92.U().T();
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + T);
                }
                if (T == null || T.extensionCoreVersionCode >= j) {
                    return;
                }
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + T);
                }
                s92.Q0();
            }
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion m;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(x23.K().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (m = gm2.i().m()) == null) {
                return;
            }
            long j2 = m.swanCoreVersionCode;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (tz2.h) {
                Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + m);
            }
            gm2.i().release();
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(x23.K().getAppId())) {
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || s92.U().d0() == null) {
                    return;
                }
                if (tz2.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + s92.U().d0());
                }
                s92.Q0();
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            t91 t91Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (t91Var = mv2.b().d) == null) {
                return;
            }
            t91Var.onPayResult(mv2.a(bundle.getInt(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public final void o(String str, y23 y23Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, y23Var, pMSAppInfo) == null) {
                b82 d = b82.d();
                c82.b a2 = c82.a();
                a2.h(RecordType.APP_ID);
                a2.f(pMSAppInfo.appId);
                d.f(str, a2.e());
                c82.b a3 = c82.a();
                a3.h(RecordType.APP_VERSION);
                a3.f(String.valueOf(pMSAppInfo.versionCode));
                d.f(str, a3.e());
                c82.b a4 = c82.a();
                a4.h(RecordType.PREFETCH_TYPE);
                a4.g(y23Var.I());
                d.f(str, a4.e());
            }
        }

        public void p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
                this.a = new WeakReference<>(cVar);
            }
        }

        public final boolean q(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, prefetchEvent, bundle)) == null) {
                y23 b0 = y23.b0();
                if (b0 == null) {
                    return true;
                }
                if (!b0.I() && TextUtils.isEmpty(b0.W().V())) {
                    if (TextUtils.equals(b0.getAppId(), prefetchEvent.appId)) {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            return false;
                        }
                        PMSAppInfo f0 = b0.W().f0();
                        return f0 == null || f0.versionCode != pMSAppInfo.versionCode;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void r(y23 y23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, y23Var) == null) {
                km1 a2 = y23Var.x().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                lj1 N = y23Var.N();
                N.h(N.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948198429, "Lcom/baidu/tieba/tz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948198429, "Lcom/baidu/tieba/tz2;");
                return;
            }
        }
        h = ij1.a;
        i = TimeUnit.MINUTES.toMillis(5L);
        j = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz2(b33 b33Var) {
        super(b33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new e();
        this.f = new ArrayDeque();
    }

    @Deprecated
    public static tz2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? x23.K().y() : (tz2) invokeV.objValue;
    }

    public void M(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, cVar) == null) {
            this.d = dVar;
            this.b.p(cVar);
            Z(1, P());
            if (this.d == null || !O()) {
                return;
            }
            this.d.a();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f) {
                T("checkRebindable ===>");
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
                boolean z = currentTimeMillis > i;
                T("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c != null : invokeV.booleanValue;
    }

    public final Bundle P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("process_id", SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", m());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Handler R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (Handler) invokeV.objValue;
    }

    public IProcessBridge S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (IProcessBridge) invokeV.objValue;
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
    public void W(@Nullable Bundle bundle, @NonNull Class<? extends yy2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, cls) == null) {
            X(bundle, cls, null);
        }
    }

    @Deprecated
    public void X(@Nullable Bundle bundle, @NonNull Class<? extends yy2> cls, @Nullable fz2 fz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bundle, cls, fz2Var) == null) {
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (fz2Var != null) {
                bundle2.putString("ai_apps_observer_id", fz2Var.b());
                cz2.b().e(fz2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            oz2 e2 = oz2.e();
            qz2 qz2Var = new qz2(obtain);
            qz2Var.p(true);
            e2.h(qz2Var);
        }
    }

    @Deprecated
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            b0(i2, "");
        }
    }

    public void Z(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            oz2.e().h(new qz2(obtain));
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
            oz2.e().h(new qz2(obtain));
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
            oz2.e().h(new qz2(obtain));
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
                    Application c2 = fm2.c();
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
}
