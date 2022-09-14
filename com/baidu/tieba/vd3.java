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
/* loaded from: classes6.dex */
public class vd3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile vd3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public final td3 h;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements td3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rh3<yd3<xd3>> a;
        public WifiConfiguration b;
        public boolean c;
        public final Handler d;
        public final Lock e;
        public final Runnable f;
        public final pd3 g;
        public final /* synthetic */ vd3 h;

        /* loaded from: classes6.dex */
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

        /* renamed from: com.baidu.tieba.vd3$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0436b implements pd3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0436b(b bVar) {
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

            @Override // com.baidu.tieba.qd3
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.h.b.getConnectionInfo();
                    }
                    this.a.e.lock();
                    try {
                        if (this.a.b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.b.SSID)) {
                            this.a.h.g(0, "success", new xd3(wifiInfo, ae3.a(zd3.b(this.a.h.a, this.a.h.b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.e.unlock();
                    }
                }
            }

            @Override // com.baidu.tieba.pd3
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

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rh3 a;
            public final /* synthetic */ wd3 b;
            public final /* synthetic */ b c;

            public c(b bVar, rh3 rh3Var, wd3 wd3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, rh3Var, wd3Var};
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
                this.a = rh3Var;
                this.b = wd3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.c.h.g(12001, "not support", null, this.a);
                    } else if (!this.c.h.l()) {
                        this.c.h.g(12000, "not init", null, this.a);
                    } else if (!this.c.h.b.isWifiEnabled()) {
                        this.c.h.g(12005, "wifi is not on", null, this.a);
                    } else if (!sg3.K(this.c.h.a)) {
                        this.c.h.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.c.h.a, com.kuaishou.weapon.p0.h.g) == 0) {
                        this.c.e.lock();
                        try {
                            if (this.c.a == null) {
                                this.c.a = this.a;
                                this.c.e.unlock();
                                this.c.b = zd3.a(this.b);
                                if (this.c.b != null) {
                                    if (!TextUtils.isEmpty(this.c.b.preSharedKey) && zd3.e(this.c.b.preSharedKey).length() < 8) {
                                        b bVar = this.c;
                                        bVar.h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                        this.c.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.c.h.b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.c.b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.c.b.BSSID) || (!TextUtils.isEmpty(this.c.b.BSSID) && TextUtils.equals(this.c.b.BSSID, connectionInfo.getBSSID())))) {
                                        vd3 vd3Var = this.c.h;
                                        vd3Var.g(0, "success", new xd3(connectionInfo, ae3.a(zd3.b(vd3Var.a, vd3Var.b, connectionInfo))), this.a);
                                        this.c.l();
                                        return;
                                    }
                                    vd3 vd3Var2 = this.c.h;
                                    WifiConfiguration c = zd3.c(vd3Var2.a, vd3Var2.b, this.b);
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
                                    this.c.c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.c.b.networkId > -1) {
                                        addNetwork = this.c.b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.c.d.postDelayed(this.c.f, 16000L);
                                        z = this.c.h.b.enableNetwork(addNetwork, true);
                                        this.c.h.b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.c.h.g(12013, "wifi config unavailable", null, this.a);
                                    this.c.l();
                                    return;
                                }
                                this.c.h.g(12008, "invalid ssid", null, this.a);
                                this.c.l();
                                return;
                            }
                            this.c.h.g(12004, "is connecting", null, this.a);
                        } finally {
                            this.c.e.unlock();
                        }
                    } else {
                        this.c.h.g(12012, "no location permission", null, this.a);
                    }
                }
            }
        }

        public b(vd3 vd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = vd3Var;
            this.d = new Handler(Looper.getMainLooper());
            this.e = new ReentrantLock();
            this.f = new a(this);
            C0436b c0436b = new C0436b(this);
            this.g = c0436b;
            vd3Var.c.setConnectListener(c0436b);
        }

        @Override // com.baidu.tieba.td3
        public void a(wd3 wd3Var, rh3<yd3<xd3>> rh3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, wd3Var, rh3Var) == null) || rh3Var == null) {
                return;
            }
            sf3.k(new c(this, rh3Var, wd3Var), "connectWifi");
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

    /* loaded from: classes6.dex */
    public class c implements td3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd3 a;

        public c(vd3 vd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd3Var;
        }

        @Override // com.baidu.tieba.td3
        public void a(wd3 wd3Var, rh3<yd3<xd3>> rh3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, wd3Var, rh3Var) == null) || rh3Var == null) {
                return;
            }
            this.a.g(12001, "not support", null, rh3Var);
        }

        public /* synthetic */ c(vd3 vd3Var, a aVar) {
            this(vd3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vd3(Context context) {
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

    public static vd3 s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (i == null) {
                synchronized (vd3.class) {
                    if (i == null) {
                        i = new vd3(context);
                    }
                }
            }
            return i;
        }
        return (vd3) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || i == null) {
            return;
        }
        i.h();
        i = null;
    }

    @Override // com.baidu.tieba.td3
    public void a(wd3 wd3Var, rh3<yd3<xd3>> rh3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, wd3Var, rh3Var) == null) || rh3Var == null) {
            return;
        }
        if (wd3Var != null && wd3Var.e) {
            t();
            g(0, "success", null, rh3Var);
            return;
        }
        this.h.a(wd3Var, rh3Var);
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
}
