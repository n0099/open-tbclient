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
/* loaded from: classes7.dex */
public abstract class pm3 implements qm3, rm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final rm3 d;
    public boolean e;
    public volatile List<oq3<vm3<um3>>> f;
    public final nm3 g;

    /* loaded from: classes7.dex */
    public class c implements rm3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<oq3<vm3<List<um3>>>> a;
        public boolean b;
        public List<oq3<vm3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public om3 h;
        public final /* synthetic */ pm3 i;

        /* loaded from: classes7.dex */
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

        /* loaded from: classes7.dex */
        public class b implements om3 {
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

            @Override // com.baidu.tieba.om3
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

        /* renamed from: com.baidu.tieba.pm3$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0455c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oq3 a;
            public final /* synthetic */ c b;

            public RunnableC0455c(c cVar, oq3 oq3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, oq3Var};
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
                this.a = oq3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(12000, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!pp3.K(this.b.i.a)) {
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

        public c(pm3 pm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = pm3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            pm3Var.c.setScanListener(bVar);
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new um3(scanResult));
                    }
                }
                List<oq3<vm3<List<um3>>>> list2 = this.a;
                for (oq3<vm3<List<um3>>> oq3Var : list2) {
                    this.i.g(0, "success", arrayList, oq3Var);
                }
                List<oq3<vm3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (oq3<vm3<Void>> oq3Var2 : list3) {
                    this.i.g(0, "success", null, oq3Var2);
                    for (oq3<vm3<List<um3>>> oq3Var3 : list2) {
                        this.i.g(0, "success", arrayList, oq3Var3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.rm3
        public boolean b(oq3<vm3<List<um3>>> oq3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oq3Var)) == null) {
                if (oq3Var == null) {
                    return false;
                }
                List<oq3<vm3<List<um3>>>> list = this.a;
                if (!list.contains(oq3Var)) {
                    return true;
                }
                return list.remove(oq3Var);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.rm3
        public void c(oq3<vm3<Void>> oq3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oq3Var) != null) || oq3Var == null) {
                return;
            }
            po3.k(new RunnableC0455c(this, oq3Var), "wifiScan");
        }

        @Override // com.baidu.tieba.rm3
        public boolean d(oq3<vm3<List<um3>>> oq3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oq3Var)) == null) {
                if (oq3Var == null) {
                    return false;
                }
                List<oq3<vm3<List<um3>>>> list = this.a;
                if (list.contains(oq3Var)) {
                    return true;
                }
                return list.add(oq3Var);
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

    /* loaded from: classes7.dex */
    public class a implements nm3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm3 a;

        public a(pm3 pm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm3Var;
        }

        @Override // com.baidu.tieba.nm3
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

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;
        public final /* synthetic */ pm3 b;

        public b(pm3 pm3Var, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm3Var, oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pm3Var;
            this.a = oq3Var;
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
                } else if (!pp3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, com.kuaishou.weapon.p0.h.g) != 0) {
                    this.b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    pm3 pm3Var = this.b;
                    pm3Var.g(0, "success", new um3(wifiInfo, xm3.a(wm3.b(pm3Var.a, pm3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    public pm3(Context context) {
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

    @Override // com.baidu.tieba.rm3
    public boolean b(oq3<vm3<List<um3>>> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oq3Var)) == null) {
            return this.d.b(oq3Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rm3
    public void c(oq3<vm3<Void>> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oq3Var) == null) {
            this.d.c(oq3Var);
        }
    }

    @Override // com.baidu.tieba.rm3
    public boolean d(oq3<vm3<List<um3>>> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oq3Var)) == null) {
            return this.d.d(oq3Var);
        }
        return invokeL.booleanValue;
    }

    public void j(oq3<vm3<um3>> oq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, oq3Var) != null) || oq3Var == null) {
            return;
        }
        po3.k(new b(this, oq3Var), "getConnectedWifi");
    }

    public boolean n(oq3<vm3<um3>> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, oq3Var)) == null) {
            if (oq3Var == null) {
                return false;
            }
            List<oq3<vm3<um3>>> list = this.f;
            if (list.contains(oq3Var)) {
                return true;
            }
            return list.add(oq3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(oq3<vm3<Void>> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, oq3Var) == null) {
            if (this.e) {
                g(0, "success", null, oq3Var);
                return;
            }
            k();
            g(0, "success", null, oq3Var);
        }
    }

    public void q(oq3<vm3<Void>> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, oq3Var) == null) {
            if (!this.e) {
                g(0, "success", null, oq3Var);
                return;
            }
            i();
            g(0, "success", null, oq3Var);
        }
    }

    public boolean r(oq3<vm3<um3>> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, oq3Var)) == null) {
            if (oq3Var == null) {
                return false;
            }
            List<oq3<vm3<um3>>> list = this.f;
            if (!list.contains(oq3Var)) {
                return true;
            }
            return list.remove(oq3Var);
        }
        return invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, oq3<vm3<ResultType>> oq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, oq3Var}) != null) || oq3Var == null) {
            return;
        }
        vm3<ResultType> vm3Var = new vm3<>();
        vm3Var.a = i;
        vm3Var.b = str;
        vm3Var.c = resulttype;
        oq3Var.a(vm3Var);
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
            for (oq3<vm3<um3>> oq3Var : this.f) {
                g(0, "success", new um3(wifiInfo, xm3.a(wm3.b(this.a, this.b, wifiInfo))), oq3Var);
            }
        }
    }
}
