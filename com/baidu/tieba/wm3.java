package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class wm3 extends tm3 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile wm3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public final um3 h;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements um3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public sq3<zm3<ym3>> a;
        public WifiConfiguration b;
        public boolean c;
        public final Handler d;
        public final Lock e;
        public final Runnable f;
        public final qm3 g;
        public final /* synthetic */ wm3 h;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.e.lock();
                    try {
                        if (this.a.a != null) {
                            this.a.h.g(12003, "connection timeout", null, this.a.a);
                        }
                        this.a.l();
                    } finally {
                        this.a.e.unlock();
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.wm3$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0493b implements qm3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0493b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.rm3
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.h.b.getConnectionInfo();
                    }
                    this.a.e.lock();
                    try {
                        if (this.a.b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.b.SSID)) {
                            this.a.h.g(0, "success", new ym3(wifiInfo, bn3.a(an3.b(this.a.h.a, this.a.h.b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.e.unlock();
                    }
                }
            }

            @Override // com.baidu.tieba.qm3
            public void onError(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.e.lock();
                    if (i == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.c) {
                                    this.a.h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, this.a.a);
                                } else {
                                    this.a.h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.e.unlock();
                        }
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sq3 a;
            public final /* synthetic */ xm3 b;
            public final /* synthetic */ b c;

            public c(b bVar, sq3 sq3Var, xm3 xm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, sq3Var, xm3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = sq3Var;
                this.b = xm3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.c.h.g(12001, "not support", null, this.a);
                    } else if (!this.c.h.l()) {
                        this.c.h.g(12000, "not init", null, this.a);
                    } else if (!this.c.h.b.isWifiEnabled()) {
                        this.c.h.g(12005, "wifi is not on", null, this.a);
                    } else if (!tp3.K(this.c.h.a)) {
                        this.c.h.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.c.h.a, com.kuaishou.weapon.p0.h.g) != 0) {
                        this.c.h.g(12012, "no location permission", null, this.a);
                    } else {
                        this.c.e.lock();
                        try {
                            if (this.c.a != null) {
                                this.c.h.g(12004, "is connecting", null, this.a);
                                return;
                            }
                            this.c.a = this.a;
                            this.c.e.unlock();
                            this.c.b = an3.a(this.b);
                            if (this.c.b == null) {
                                this.c.h.g(12008, "invalid ssid", null, this.a);
                                this.c.l();
                            } else if (!TextUtils.isEmpty(this.c.b.preSharedKey) && an3.e(this.c.b.preSharedKey).length() < 8) {
                                b bVar = this.c;
                                bVar.h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                this.c.l();
                            } else {
                                WifiInfo connectionInfo = this.c.h.b.getConnectionInfo();
                                if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                    connectionInfo = null;
                                }
                                boolean z2 = false;
                                if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.c.b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.c.b.BSSID) || (!TextUtils.isEmpty(this.c.b.BSSID) && TextUtils.equals(this.c.b.BSSID, connectionInfo.getBSSID())))) {
                                    wm3 wm3Var = this.c.h;
                                    wm3Var.g(0, "success", new ym3(connectionInfo, bn3.a(an3.b(wm3Var.a, wm3Var.b, connectionInfo))), this.a);
                                    this.c.l();
                                    return;
                                }
                                wm3 wm3Var2 = this.c.h;
                                WifiConfiguration c = an3.c(wm3Var2.a, wm3Var2.b, this.b);
                                if (c != null) {
                                    this.c.b.networkId = c.networkId;
                                }
                                if (this.c.b.networkId > -1) {
                                    b bVar2 = this.c;
                                    addNetwork = bVar2.h.b.updateNetwork(bVar2.b);
                                    if (addNetwork < 0 && c != null && !TextUtils.isEmpty(this.c.b.BSSID) && !TextUtils.equals(this.c.b.BSSID, c.BSSID)) {
                                        this.c.h.g(12013, "wifi config unavailable", null, this.a);
                                        this.c.l();
                                        return;
                                    } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.c.b.BSSID) && !TextUtils.equals(this.c.b.BSSID, connectionInfo.getBSSID())) {
                                        this.c.h.g(12013, "wifi config unavailable", null, this.a);
                                        this.c.l();
                                        return;
                                    }
                                } else {
                                    b bVar3 = this.c;
                                    addNetwork = bVar3.h.b.addNetwork(bVar3.b);
                                }
                                b bVar4 = this.c;
                                if (addNetwork >= 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                bVar4.c = z;
                                if (addNetwork < 0 && this.c.b.networkId > -1) {
                                    addNetwork = this.c.b.networkId;
                                }
                                if (addNetwork >= 0) {
                                    this.c.d.postDelayed(this.c.f, 16000L);
                                    z2 = this.c.h.b.enableNetwork(addNetwork, true);
                                    this.c.h.b.saveConfiguration();
                                }
                                if (!z2) {
                                    this.c.h.g(12013, "wifi config unavailable", null, this.a);
                                    this.c.l();
                                }
                            }
                        } finally {
                            this.c.e.unlock();
                        }
                    }
                }
            }
        }

        public b(wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = wm3Var;
            this.d = new Handler(Looper.getMainLooper());
            this.e = new ReentrantLock();
            this.f = new a(this);
            C0493b c0493b = new C0493b(this);
            this.g = c0493b;
            wm3Var.c.setConnectListener(c0493b);
        }

        @Override // com.baidu.tieba.um3
        public void a(xm3 xm3Var, sq3<zm3<ym3>> sq3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, xm3Var, sq3Var) != null) || sq3Var == null) {
                return;
            }
            to3.k(new c(this, sq3Var, xm3Var), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.lock();
                try {
                    this.d.removeCallbacks(this.f);
                    this.b = null;
                    this.a = null;
                } finally {
                    this.e.unlock();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements um3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm3 a;

        public c(wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wm3Var;
        }

        public /* synthetic */ c(wm3 wm3Var, a aVar) {
            this(wm3Var);
        }

        @Override // com.baidu.tieba.um3
        public void a(xm3 xm3Var, sq3<zm3<ym3>> sq3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, xm3Var, sq3Var) != null) || sq3Var == null) {
                return;
            }
            this.a.g(12001, "not support", null, sq3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm3(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 29) {
            this.h = new b(this);
        } else {
            this.h = new c(this, null);
        }
    }

    public static wm3 s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (i == null) {
                synchronized (wm3.class) {
                    if (i == null) {
                        i = new wm3(context);
                    }
                }
            }
            return i;
        }
        return (wm3) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && i != null) {
            i.h();
            i = null;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.WIFI_SETTINGS");
            if (!(this.a instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            this.a.startActivity(intent);
        }
    }

    @Override // com.baidu.tieba.um3
    public void a(xm3 xm3Var, sq3<zm3<ym3>> sq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, xm3Var, sq3Var) != null) || sq3Var == null) {
            return;
        }
        if (xm3Var != null && xm3Var.e) {
            t();
            g(0, "success", null, sq3Var);
            return;
        }
        this.h.a(xm3Var, sq3Var);
    }
}
