package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jx3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile jx3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public kx3 a;
    public kx3 b;
    public DownloadManager c;
    public vx3 d;
    public JSONObject e;
    public AppDownloadNetworkStateReceiver f;
    public long g;

    /* loaded from: classes6.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx3 a;

        /* loaded from: classes6.dex */
        public class a implements dy3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Download b;
            public final /* synthetic */ d c;

            public a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.a = str;
                this.b = download;
            }

            @Override // com.baidu.tieba.dy3
            public void b(fy3 fy3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fy3Var) == null) {
                    if (fy3Var != null) {
                        if (fy3Var.d()) {
                            this.c.a.a.b(this.a, new gy3(this.b));
                        } else {
                            this.c.a.a.b(this.a, fy3Var);
                        }
                    }
                    this.c.a.C(this.a);
                }
            }
        }

        public d(jx3 jx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx3Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            String failedReason;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) && download != null && download.getId() != null) {
                String valueOf = String.valueOf(download.getId());
                if (jx3.h) {
                    Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                }
                if (download.getState() == Download.DownloadState.FINISH) {
                    if (!b34.d().a(download)) {
                        ly3.a(download.getKeyByUser(), "startDownload", "success", null, new jy3(this.a.e));
                        ly3.d(2, download.getKeyByUser(), new tx3(download).c(), download.getUrl());
                    }
                    hy3.f().m(download, true, "downloadfinish");
                }
                if (!this.a.a.d(valueOf)) {
                    return;
                }
                int i = h.a[download.getState().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (TextUtils.isEmpty(download.getFailedReason())) {
                                failedReason = "download is failed";
                            } else {
                                failedReason = download.getFailedReason();
                            }
                            this.a.a.b(valueOf, new ey3(download.getFailedType().intValue(), failedReason));
                            this.a.C(valueOf);
                            return;
                        }
                        return;
                    }
                    this.a.a.b(valueOf, new ey3(31015, "download is canceled"));
                    this.a.C(valueOf);
                    return;
                }
                this.a.d.f();
                b34.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                new by3(download, this.a.e).c(new a(this, valueOf, download));
                if (b34.d().a(download)) {
                    b34.d().b(download);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jx3 jx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && vm1.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Download b;
        public final /* synthetic */ jx3 c;

        public b(jx3 jx3Var, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jx3Var;
            this.a = str;
            this.b = download;
        }

        @Override // com.baidu.tieba.dy3
        public void b(fy3 fy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fy3Var) == null) {
                if (fy3Var != null) {
                    if (fy3Var.d()) {
                        this.c.a.b(this.a, new gy3(this.b));
                    } else {
                        this.c.a.b(this.a, fy3Var);
                    }
                }
                this.c.C(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jx3 c;

        public c(jx3 jx3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jx3Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || yr2.a().b()) {
                return;
            }
            if (jx3.h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.b);
            if (this.c.e != null) {
                intent.putExtra("ubc_params", this.c.e.toString());
            }
            intent.setFlags(276824064);
            ti3.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx3 this$0;

        public e(jx3 jx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = jx3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (jx3.h) {
                    Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                }
                Download o = this.this$0.d.o(schemeSpecificPart);
                if (b34.d().a(o)) {
                    b34.d().c(o);
                } else {
                    this.this$0.p(schemeSpecificPart);
                }
                this.this$0.t(schemeSpecificPart);
                this.this$0.b.b(schemeSpecificPart, new gy3((String) null));
                this.this$0.B(schemeSpecificPart, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ jx3 d;

        public f(jx3 jx3Var, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jx3Var;
            this.a = download;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.dy3
        public void b(fy3 fy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fy3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (fy3Var != null) {
                    if (fy3Var.d()) {
                        if (!TextUtils.isEmpty(this.b)) {
                            ly3.c("installSuccess", this.b, this.c);
                        }
                        this.d.a.b(valueOf, new gy3(this.a));
                    } else {
                        this.d.a.b(valueOf, fy3Var);
                    }
                }
                this.d.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements dy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ jx3 b;

        public g(jx3 jx3Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx3Var;
            this.a = download;
        }

        @Override // com.baidu.tieba.dy3
        public void b(fy3 fy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fy3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (fy3Var != null) {
                    if (fy3Var.d()) {
                        this.b.a.b(valueOf, new gy3(this.a));
                    } else {
                        this.b.a.b(valueOf, fy3Var);
                    }
                }
                this.b.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-675178368, "Lcom/baidu/tieba/jx3$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-675178368, "Lcom/baidu/tieba/jx3$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements dy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.dy3
        public void b(fy3 fy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fy3Var) == null) {
            }
        }

        public i(jx3 jx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947898628, "Lcom/baidu/tieba/jx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947898628, "Lcom/baidu/tieba/jx3;");
                return;
            }
        }
        h = vm1.a;
    }

    public static jx3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (jx3.class) {
                    if (i == null) {
                        i = new jx3();
                    }
                }
            }
            return i;
        }
        return (jx3) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.registerOnStateChangeListener(new d(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f == null) {
                this.f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            rp2.c().registerReceiver(this.f, intentFilter);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return !ProcessUtils.isMainProcess();
        }
        return invokeV.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.d.d();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            dz3.c().d();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d.m();
        }
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }

    public jx3() {
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
        this.a = new kx3();
        this.b = new kx3();
        this.g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.c = downloadManager;
        vx3 vx3Var = new vx3(downloadManager);
        this.d = vx3Var;
        vx3Var.e();
        this.d.m();
        A();
        z();
        if (h) {
            this.c.registerOnProgressChangeListener(new a(this));
        }
        hy3.f().j();
        F();
        o();
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.f(str);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && jSONObject != null) {
            this.e = jSONObject;
        }
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new by3(download, this.e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.d.p(str)) {
                if (download != null) {
                    hy3.f().a(download);
                }
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return this.d.v(str);
        }
        return (Download) invokeL.objValue;
    }

    public void B(String str, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dy3Var) == null) {
            this.b.g(str, dy3Var);
        }
    }

    public final void h(Download download, dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, dy3Var) == null) && download.getId() != null) {
            this.a.a(String.valueOf(download.getId()), dy3Var);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x = this.d.x()) != null && !x.isEmpty()) {
            for (Download download : x) {
                this.a.a(String.valueOf(download.getId()), new i(this));
                if (!b34.d().a(download)) {
                    ly3.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new jy3(this.e));
                }
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                dy3Var.b(new ey3(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.d.u(optString, optString2);
                    if (u == null) {
                        wx3.b().e(jSONObject, dy3Var);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), dy3Var);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new by3(u, this.e).c(new b(this, valueOf, u));
                        return;
                    }
                    ly3.a(optString2, com.baidu.mobads.sdk.internal.ap.d, null, null, new jy3(this.e));
                    this.c.resume(u.getId().longValue());
                    return;
                }
                dy3Var.b(new ey3(31007, "invalid params"));
            }
        }
    }

    public boolean j(String str, dy3 dy3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, dy3Var)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g < 1000) {
                if (vm1.a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.g));
                }
                return false;
            }
            this.g = currentTimeMillis;
            Download v = this.d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (vm1.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 4 && i2 != 5) {
                    if (i2 != 6) {
                        this.d.g(str);
                        return true;
                    }
                    h(v, dy3Var);
                    this.c.resume(v.getId().longValue());
                    if (vm1.a) {
                        Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                    }
                    return false;
                }
                h(v, dy3Var);
                if (vm1.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            }
            h(v, dy3Var);
            s(v);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            b34.c().c(optString);
                            break;
                        }
                    }
                    ly3.a(optString2, "deleteDownload", null, null, new jy3(this.e));
                    this.d.h(r);
                    dy3Var.b(new gy3(r));
                    return;
                }
                wx3.b().a(jSONObject, dy3Var);
                return;
            }
            dy3Var.b(new ey3(31007, "invalid params"));
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.d.u(optString, optString2);
                if (u == null) {
                    wx3.b().c(jSONObject, dy3Var);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    dy3Var.b(new ey3(31013, "download is not started"));
                    return;
                } else {
                    ly3.a(optString2, "pauseDownload", null, null, new jy3(this.e));
                    this.c.pause(u.getId().longValue());
                    dy3Var.b(new gy3(u));
                    return;
                }
            }
            dy3Var.b(new ey3(31007, "invalid params"));
        }
    }

    public void H(String str, String str2, String str3, @NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                dy3Var.b(new ey3(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (zx3.h(AppRuntime.getAppContext(), str2)) {
                    dy3Var.b(new ey3(31005, "apk is already installed"));
                } else if (!j(str, dy3Var)) {
                } else {
                    tx3 tx3Var = new tx3();
                    tx3Var.g(str);
                    tx3Var.f(str2);
                    tx3Var.a(str3);
                    Download b2 = tx3Var.b();
                    this.c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), dy3Var);
                    }
                    if (!b34.d().a(b2)) {
                        ly3.a(str2, "startDownload", null, null, new jy3(this.e));
                        ly3.d(1, str2, str3, str);
                    }
                }
            } else {
                dy3Var.b(new ey3(31007, "invalid params"));
            }
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.d.b(str)) {
                String i2 = this.d.i(str);
                if (!TextUtils.isEmpty(i2) && this.d.c(i2)) {
                    ly3.a(str, "installHijack", null, null, new jy3(this.e));
                    return;
                }
                return;
            }
            ly3.a(str, "installApp", "success", null, new jy3(this.e));
            Download o = this.d.o(str);
            if (o != null) {
                ly3.d(3, str, new tx3(o).c(), o.getUrl());
            }
        }
    }

    public void w(@NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.d.n();
            if (n != null && !n.isEmpty()) {
                dy3Var.b(new gy3(n));
            } else {
                dy3Var.b(new ey3(31008, "download is not exist"));
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, str, str2) != null) || (w = this.d.w(str)) == null) {
            return;
        }
        by3 by3Var = new by3(w, this.e);
        if (!TextUtils.isEmpty(str2)) {
            ly3.c("notifyInstall", str2, str);
        }
        by3Var.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull cy3 cy3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, cy3Var)) == null) {
            if (i()) {
                cy3Var.b(new ey3(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                cy3Var.b(new ey3(31007, "invalid params"));
                return null;
            } else {
                Download o = this.d.o(str2);
                if (o == null) {
                    cy3Var.b(new ey3(31008, "download is not exist"));
                    this.d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    cy3Var.b(new ey3(31017, "download is not finished"));
                    this.d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        cy3Var.b(new ey3(31001, "database no package or file name"));
                        this.d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (zx3.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        cy3Var.b(new gy3("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (yj3.c() <= file.length()) {
                            cy3Var.b(new ey3(31020, "not enough space to install"));
                            return null;
                        }
                        cy3Var.setPackageName(str2);
                        cy3Var.a(str3);
                        this.b.a(str2, cy3Var);
                        if (!zx3.j(context, str3, false)) {
                            t(str2);
                            B(str2, cy3Var);
                            cy3Var.b(new ey3(31004, "apk install fail"));
                            this.d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = zx3.c();
                            if (zx3.k(c2)) {
                                j63.M().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    cy3Var.b(new ey3(31002, "file is not exist"));
                    this.d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull dy3 dy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, dy3Var) == null) {
            if (i()) {
                dy3Var.b(new ey3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                dy3Var.b(new ey3(31007, "invalid params"));
                return;
            }
            Download v = this.d.v(optString);
            if (v == null) {
                wx3.b().d(jSONObject, dy3Var);
            } else {
                dy3Var.b(new gy3(v));
            }
        }
    }
}
