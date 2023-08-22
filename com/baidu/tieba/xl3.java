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
/* loaded from: classes8.dex */
public abstract class xl3 implements yl3, zl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final zl3 d;
    public boolean e;
    public volatile List<wp3<dm3<cm3>>> f;
    public final vl3 g;

    /* loaded from: classes8.dex */
    public class c implements zl3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<wp3<dm3<List<cm3>>>> a;
        public boolean b;
        public List<wp3<dm3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public wl3 h;
        public final /* synthetic */ xl3 i;

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
        public class b implements wl3 {
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

            @Override // com.baidu.tieba.wl3
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

        /* renamed from: com.baidu.tieba.xl3$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0530c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wp3 a;
            public final /* synthetic */ c b;

            public RunnableC0530c(c cVar, wp3 wp3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, wp3Var};
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
                this.a = wp3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(12000, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!xo3.K(this.b.i.a)) {
                        this.b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.b.i.a, com.kuaishou.weapon.p0.h.g) != 0) {
                        this.b.i.g(12012, "no location permission", null, this.a);
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

        public c(xl3 xl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xl3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            xl3Var.c.setScanListener(bVar);
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new cm3(scanResult));
                    }
                }
                List<wp3<dm3<List<cm3>>>> list2 = this.a;
                for (wp3<dm3<List<cm3>>> wp3Var : list2) {
                    this.i.g(0, "success", arrayList, wp3Var);
                }
                List<wp3<dm3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (wp3<dm3<Void>> wp3Var2 : list3) {
                    this.i.g(0, "success", null, wp3Var2);
                    for (wp3<dm3<List<cm3>>> wp3Var3 : list2) {
                        this.i.g(0, "success", arrayList, wp3Var3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zl3
        public boolean b(wp3<dm3<List<cm3>>> wp3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wp3Var)) == null) {
                if (wp3Var == null) {
                    return false;
                }
                List<wp3<dm3<List<cm3>>>> list = this.a;
                if (!list.contains(wp3Var)) {
                    return true;
                }
                return list.remove(wp3Var);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.zl3
        public void c(wp3<dm3<Void>> wp3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp3Var) != null) || wp3Var == null) {
                return;
            }
            xn3.k(new RunnableC0530c(this, wp3Var), "wifiScan");
        }

        @Override // com.baidu.tieba.zl3
        public boolean d(wp3<dm3<List<cm3>>> wp3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wp3Var)) == null) {
                if (wp3Var == null) {
                    return false;
                }
                List<wp3<dm3<List<cm3>>>> list = this.a;
                if (list.contains(wp3Var)) {
                    return true;
                }
                return list.add(wp3Var);
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

    /* loaded from: classes8.dex */
    public class a implements vl3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl3 a;

        public a(xl3 xl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl3Var;
        }

        @Override // com.baidu.tieba.vl3
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

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ xl3 b;

        public b(xl3 xl3Var, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, wp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xl3Var;
            this.a = wp3Var;
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
                } else if (!xo3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, com.kuaishou.weapon.p0.h.g) != 0) {
                    this.b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    xl3 xl3Var = this.b;
                    xl3Var.g(0, "success", new cm3(wifiInfo, fm3.a(em3.b(xl3Var.a, xl3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    public xl3(Context context) {
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

    @Override // com.baidu.tieba.zl3
    public boolean b(wp3<dm3<List<cm3>>> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wp3Var)) == null) {
            return this.d.b(wp3Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zl3
    public void c(wp3<dm3<Void>> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp3Var) == null) {
            this.d.c(wp3Var);
        }
    }

    @Override // com.baidu.tieba.zl3
    public boolean d(wp3<dm3<List<cm3>>> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wp3Var)) == null) {
            return this.d.d(wp3Var);
        }
        return invokeL.booleanValue;
    }

    public void j(wp3<dm3<cm3>> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, wp3Var) != null) || wp3Var == null) {
            return;
        }
        xn3.k(new b(this, wp3Var), "getConnectedWifi");
    }

    public boolean n(wp3<dm3<cm3>> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, wp3Var)) == null) {
            if (wp3Var == null) {
                return false;
            }
            List<wp3<dm3<cm3>>> list = this.f;
            if (list.contains(wp3Var)) {
                return true;
            }
            return list.add(wp3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(wp3<dm3<Void>> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, wp3Var) == null) {
            if (this.e) {
                g(0, "success", null, wp3Var);
                return;
            }
            k();
            g(0, "success", null, wp3Var);
        }
    }

    public void q(wp3<dm3<Void>> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wp3Var) == null) {
            if (!this.e) {
                g(0, "success", null, wp3Var);
                return;
            }
            i();
            g(0, "success", null, wp3Var);
        }
    }

    public boolean r(wp3<dm3<cm3>> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, wp3Var)) == null) {
            if (wp3Var == null) {
                return false;
            }
            List<wp3<dm3<cm3>>> list = this.f;
            if (!list.contains(wp3Var)) {
                return true;
            }
            return list.remove(wp3Var);
        }
        return invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, wp3<dm3<ResultType>> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, wp3Var}) != null) || wp3Var == null) {
            return;
        }
        dm3<ResultType> dm3Var = new dm3<>();
        dm3Var.a = i;
        dm3Var.b = str;
        dm3Var.c = resulttype;
        wp3Var.a(dm3Var);
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
            for (wp3<dm3<cm3>> wp3Var : this.f) {
                g(0, "success", new cm3(wifiInfo, fm3.a(em3.b(this.a, this.b, wifiInfo))), wp3Var);
            }
        }
    }
}
