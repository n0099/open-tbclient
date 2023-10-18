package com.baidu.tieba;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public abstract class jg3 implements kg3, lg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final lg3 d;
    public boolean e;
    public volatile List<ik3<pg3<og3>>> f;
    public final hg3 g;

    /* loaded from: classes6.dex */
    public class c implements lg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<ik3<pg3<List<og3>>>> a;
        public boolean b;
        public List<ik3<pg3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public ig3 h;
        public final /* synthetic */ jg3 i;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d.lock();
                    try {
                        if (!this.a.b) {
                            return;
                        }
                        this.a.m(this.a.f);
                        this.a.b = false;
                    } finally {
                        this.a.d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ig3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.ig3
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.f = list;
                this.a.d.lock();
                try {
                    if (!this.a.b) {
                        return;
                    }
                    this.a.e.removeCallbacks(this.a.g);
                    this.a.m(list);
                    this.a.b = false;
                } finally {
                    this.a.d.unlock();
                }
            }
        }

        /* renamed from: com.baidu.tieba.jg3$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0359c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ik3 a;
            public final /* synthetic */ c b;

            public RunnableC0359c(c cVar, ik3 ik3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, ik3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = ik3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(12000, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!jj3.K(this.b.i.a)) {
                        this.b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.b.i.a, com.kuaishou.weapon.p0.h.g) != 0) {
                        this.b.i.g(CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission", null, this.a);
                    } else {
                        this.b.d.lock();
                        try {
                            if (this.b.b) {
                                this.b.c.add(this.a);
                                return;
                            }
                            this.b.b = true;
                            this.b.d.unlock();
                            this.b.e.postDelayed(this.b.g, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
                            this.b.i.b.startScan();
                            this.b.i.g(0, "success", null, this.a);
                        } finally {
                            this.b.d.unlock();
                        }
                    }
                }
            }
        }

        public c(jg3 jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = jg3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            jg3Var.c.setScanListener(bVar);
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new og3(scanResult));
                    }
                }
                List<ik3<pg3<List<og3>>>> list2 = this.a;
                for (ik3<pg3<List<og3>>> ik3Var : list2) {
                    this.i.g(0, "success", arrayList, ik3Var);
                }
                List<ik3<pg3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (ik3<pg3<Void>> ik3Var2 : list3) {
                    this.i.g(0, "success", null, ik3Var2);
                    for (ik3<pg3<List<og3>>> ik3Var3 : list2) {
                        this.i.g(0, "success", arrayList, ik3Var3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.lg3
        public boolean b(ik3<pg3<List<og3>>> ik3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik3Var)) == null) {
                if (ik3Var == null) {
                    return false;
                }
                List<ik3<pg3<List<og3>>>> list = this.a;
                if (!list.contains(ik3Var)) {
                    return true;
                }
                return list.remove(ik3Var);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.lg3
        public void c(ik3<pg3<Void>> ik3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik3Var) != null) || ik3Var == null) {
                return;
            }
            ji3.k(new RunnableC0359c(this, ik3Var), "wifiScan");
        }

        @Override // com.baidu.tieba.lg3
        public boolean d(ik3<pg3<List<og3>>> ik3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ik3Var)) == null) {
                if (ik3Var == null) {
                    return false;
                }
                List<ik3<pg3<List<og3>>>> list = this.a;
                if (list.contains(ik3Var)) {
                    return true;
                }
                return list.add(ik3Var);
            }
            return invokeL.booleanValue;
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = new CopyOnWriteArrayList();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements hg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg3 a;

        public a(jg3 jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jg3Var;
        }

        @Override // com.baidu.tieba.hg3
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.b.getConnectionInfo();
                }
                this.a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;
        public final /* synthetic */ jg3 b;

        public b(jg3 jg3Var, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg3Var, ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jg3Var;
            this.a = ik3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.b.e) {
                    this.b.g(12000, "not init", null, this.a);
                } else if (!this.b.b.isWifiEnabled()) {
                    this.b.g(12005, "wifi is not on", null, this.a);
                } else if (!jj3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, com.kuaishou.weapon.p0.h.g) != 0) {
                    this.b.g(CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    jg3 jg3Var = this.b;
                    jg3Var.g(0, "success", new og3(wifiInfo, rg3.a(qg3.b(jg3Var.a, jg3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    public jg3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = new CopyOnWriteArrayList();
        this.g = new a(this);
        this.a = context;
        this.b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.b);
        this.c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.g);
        this.d = new c(this);
    }

    @Override // com.baidu.tieba.lg3
    public boolean b(ik3<pg3<List<og3>>> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik3Var)) == null) {
            return this.d.b(ik3Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lg3
    public void c(ik3<pg3<Void>> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik3Var) == null) {
            this.d.c(ik3Var);
        }
    }

    @Override // com.baidu.tieba.lg3
    public boolean d(ik3<pg3<List<og3>>> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ik3Var)) == null) {
            return this.d.d(ik3Var);
        }
        return invokeL.booleanValue;
    }

    public void j(ik3<pg3<og3>> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ik3Var) != null) || ik3Var == null) {
            return;
        }
        ji3.k(new b(this, ik3Var), "getConnectedWifi");
    }

    public boolean n(ik3<pg3<og3>> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ik3Var)) == null) {
            if (ik3Var == null) {
                return false;
            }
            List<ik3<pg3<og3>>> list = this.f;
            if (list.contains(ik3Var)) {
                return true;
            }
            return list.add(ik3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(ik3<pg3<Void>> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ik3Var) == null) {
            if (this.e) {
                g(0, "success", null, ik3Var);
                return;
            }
            k();
            g(0, "success", null, ik3Var);
        }
    }

    public void q(ik3<pg3<Void>> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ik3Var) == null) {
            if (!this.e) {
                g(0, "success", null, ik3Var);
                return;
            }
            i();
            g(0, "success", null, ik3Var);
        }
    }

    public boolean r(ik3<pg3<og3>> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ik3Var)) == null) {
            if (ik3Var == null) {
                return false;
            }
            List<ik3<pg3<og3>>> list = this.f;
            if (!list.contains(ik3Var)) {
                return true;
            }
            return list.remove(ik3Var);
        }
        return invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, ik3<pg3<ResultType>> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, ik3Var}) != null) || ik3Var == null) {
            return;
        }
        pg3<ResultType> pg3Var = new pg3<>();
        pg3Var.a = i;
        pg3Var.b = str;
        pg3Var.c = resulttype;
        ik3Var.a(pg3Var);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.unregisterSelf(this.a);
            this.f = new CopyOnWriteArrayList();
            ((c) this.d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (ik3<pg3<og3>> ik3Var : this.f) {
                g(0, "success", new og3(wifiInfo, rg3.a(qg3.b(this.a, this.b, wifiInfo))), ik3Var);
            }
        }
    }
}
