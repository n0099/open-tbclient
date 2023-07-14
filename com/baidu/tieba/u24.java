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
/* loaded from: classes8.dex */
public class u24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile u24 i;
    public transient /* synthetic */ FieldHolder $fh;
    public v24 a;
    public v24 b;
    public DownloadManager c;
    public g34 d;
    public JSONObject e;
    public AppDownloadNetworkStateReceiver f;
    public long g;

    /* loaded from: classes8.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u24 a;

        /* loaded from: classes8.dex */
        public class a implements o34 {
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

            @Override // com.baidu.tieba.o34
            public void a(q34 q34Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q34Var) == null) {
                    if (q34Var != null) {
                        if (q34Var.d()) {
                            this.c.a.a.b(this.a, new r34(this.b));
                        } else {
                            this.c.a.a.b(this.a, q34Var);
                        }
                    }
                    this.c.a.C(this.a);
                }
            }
        }

        public d(u24 u24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u24Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            String failedReason;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) && download != null && download.getId() != null) {
                String valueOf = String.valueOf(download.getId());
                if (u24.h) {
                    Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                }
                if (download.getState() == Download.DownloadState.FINISH) {
                    if (!m84.d().a(download)) {
                        w34.a(download.getKeyByUser(), "startDownload", "success", null, new u34(this.a.e));
                        w34.d(2, download.getKeyByUser(), new e34(download).c(), download.getUrl());
                    }
                    s34.f().m(download, true, "downloadfinish");
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
                            this.a.a.b(valueOf, new p34(download.getFailedType().intValue(), failedReason));
                            this.a.C(valueOf);
                            return;
                        }
                        return;
                    }
                    this.a.a.b(valueOf, new p34(31015, "download is canceled"));
                    this.a.C(valueOf);
                    return;
                }
                this.a.d.f();
                m84.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                new m34(download, this.a.e).c(new a(this, valueOf, download));
                if (m84.d().a(download)) {
                    m84.d().b(download);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(u24 u24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var};
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && fs1.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements o34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Download b;
        public final /* synthetic */ u24 c;

        public b(u24 u24Var, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u24Var;
            this.a = str;
            this.b = download;
        }

        @Override // com.baidu.tieba.o34
        public void a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q34Var) == null) {
                if (q34Var != null) {
                    if (q34Var.d()) {
                        this.c.a.b(this.a, new r34(this.b));
                    } else {
                        this.c.a.b(this.a, q34Var);
                    }
                }
                this.c.C(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u24 c;

        public c(u24 u24Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u24Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || jx2.a().b()) {
                return;
            }
            if (u24.h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.b);
            if (this.c.e != null) {
                intent.putExtra("ubc_params", this.c.e.toString());
            }
            intent.setFlags(276824064);
            eo3.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u24 this$0;

        public e(u24 u24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = u24Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (u24.h) {
                    Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                }
                Download o = this.this$0.d.o(schemeSpecificPart);
                if (m84.d().a(o)) {
                    m84.d().c(o);
                } else {
                    this.this$0.p(schemeSpecificPart);
                }
                this.this$0.t(schemeSpecificPart);
                this.this$0.b.b(schemeSpecificPart, new r34((String) null));
                this.this$0.B(schemeSpecificPart, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements o34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ u24 d;

        public f(u24 u24Var, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = u24Var;
            this.a = download;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.o34
        public void a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q34Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (q34Var != null) {
                    if (q34Var.d()) {
                        if (!TextUtils.isEmpty(this.b)) {
                            w34.c("installSuccess", this.b, this.c);
                        }
                        this.d.a.b(valueOf, new r34(this.a));
                    } else {
                        this.d.a.b(valueOf, q34Var);
                    }
                }
                this.d.C(valueOf);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements o34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ u24 b;

        public g(u24 u24Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u24Var;
            this.a = download;
        }

        @Override // com.baidu.tieba.o34
        public void a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q34Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (q34Var != null) {
                    if (q34Var.d()) {
                        this.b.a.b(valueOf, new r34(this.a));
                    } else {
                        this.b.a.b(valueOf, q34Var);
                    }
                }
                this.b.C(valueOf);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-424874386, "Lcom/baidu/tieba/u24$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-424874386, "Lcom/baidu/tieba/u24$h;");
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

    /* loaded from: classes8.dex */
    public class i implements o34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.o34
        public void a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q34Var) == null) {
            }
        }

        public i(u24 u24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u24Var};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159090, "Lcom/baidu/tieba/u24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159090, "Lcom/baidu/tieba/u24;");
                return;
            }
        }
        h = fs1.a;
    }

    public static u24 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (u24.class) {
                    if (i == null) {
                        i = new u24();
                    }
                }
            }
            return i;
        }
        return (u24) invokeV.objValue;
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
            cv2.c().registerReceiver(this.f, intentFilter);
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
            o44.c().d();
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

    public u24() {
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
        this.a = new v24();
        this.b = new v24();
        this.g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.c = downloadManager;
        g34 g34Var = new g34(downloadManager);
        this.d = g34Var;
        g34Var.e();
        this.d.m();
        A();
        z();
        if (h) {
            this.c.registerOnProgressChangeListener(new a(this));
        }
        s34.f().j();
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
            new m34(download, this.e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.d.p(str)) {
                if (download != null) {
                    s34.f().a(download);
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

    public void B(String str, o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, o34Var) == null) {
            this.b.g(str, o34Var);
        }
    }

    public final void h(Download download, o34 o34Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, o34Var) == null) && download.getId() != null) {
            this.a.a(String.valueOf(download.getId()), o34Var);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x = this.d.x()) != null && !x.isEmpty()) {
            for (Download download : x) {
                this.a.a(String.valueOf(download.getId()), new i(this));
                if (!m84.d().a(download)) {
                    w34.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new u34(this.e));
                }
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                o34Var.a(new p34(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.d.u(optString, optString2);
                    if (u == null) {
                        h34.b().e(jSONObject, o34Var);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), o34Var);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new m34(u, this.e).c(new b(this, valueOf, u));
                        return;
                    }
                    w34.a(optString2, "resumeDownload", null, null, new u34(this.e));
                    this.c.resume(u.getId().longValue());
                    return;
                }
                o34Var.a(new p34(31007, "invalid params"));
            }
        }
    }

    public boolean j(String str, o34 o34Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, o34Var)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g < 1000) {
                if (fs1.a) {
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
            if (fs1.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 4 && i2 != 5) {
                    if (i2 != 6) {
                        this.d.g(str);
                        return true;
                    }
                    h(v, o34Var);
                    this.c.resume(v.getId().longValue());
                    if (fs1.a) {
                        Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                    }
                    return false;
                }
                h(v, o34Var);
                if (fs1.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            }
            h(v, o34Var);
            s(v);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
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
                            m84.c().c(optString);
                            break;
                        }
                    }
                    w34.a(optString2, "deleteDownload", null, null, new u34(this.e));
                    this.d.h(r);
                    o34Var.a(new r34(r));
                    return;
                }
                h34.b().a(jSONObject, o34Var);
                return;
            }
            o34Var.a(new p34(31007, "invalid params"));
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.d.u(optString, optString2);
                if (u == null) {
                    h34.b().c(jSONObject, o34Var);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    o34Var.a(new p34(31013, "download is not started"));
                    return;
                } else {
                    w34.a(optString2, "pauseDownload", null, null, new u34(this.e));
                    this.c.pause(u.getId().longValue());
                    o34Var.a(new r34(u));
                    return;
                }
            }
            o34Var.a(new p34(31007, "invalid params"));
        }
    }

    public void H(String str, String str2, String str3, @NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                o34Var.a(new p34(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (k34.h(AppRuntime.getAppContext(), str2)) {
                    o34Var.a(new p34(31005, "apk is already installed"));
                } else if (!j(str, o34Var)) {
                } else {
                    e34 e34Var = new e34();
                    e34Var.g(str);
                    e34Var.f(str2);
                    e34Var.a(str3);
                    Download b2 = e34Var.b();
                    this.c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), o34Var);
                    }
                    if (!m84.d().a(b2)) {
                        w34.a(str2, "startDownload", null, null, new u34(this.e));
                        w34.d(1, str2, str3, str);
                    }
                }
            } else {
                o34Var.a(new p34(31007, "invalid params"));
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
                    w34.a(str, "installHijack", null, null, new u34(this.e));
                    return;
                }
                return;
            }
            w34.a(str, "installApp", "success", null, new u34(this.e));
            Download o = this.d.o(str);
            if (o != null) {
                w34.d(3, str, new e34(o).c(), o.getUrl());
            }
        }
    }

    public void w(@NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.d.n();
            if (n != null && !n.isEmpty()) {
                o34Var.a(new r34(n));
            } else {
                o34Var.a(new p34(31008, "download is not exist"));
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, str, str2) != null) || (w = this.d.w(str)) == null) {
            return;
        }
        m34 m34Var = new m34(w, this.e);
        if (!TextUtils.isEmpty(str2)) {
            w34.c("notifyInstall", str2, str);
        }
        m34Var.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull n34 n34Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, n34Var)) == null) {
            if (i()) {
                n34Var.a(new p34(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                n34Var.a(new p34(31007, "invalid params"));
                return null;
            } else {
                Download o = this.d.o(str2);
                if (o == null) {
                    n34Var.a(new p34(31008, "download is not exist"));
                    this.d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    n34Var.a(new p34(31017, "download is not finished"));
                    this.d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        n34Var.a(new p34(31001, "database no package or file name"));
                        this.d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (k34.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        n34Var.a(new r34("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (jp3.c() <= file.length()) {
                            n34Var.a(new p34(31020, "not enough space to install"));
                            return null;
                        }
                        n34Var.setPackageName(str2);
                        n34Var.setFilePath(str3);
                        this.b.a(str2, n34Var);
                        if (!k34.j(context, str3, false)) {
                            t(str2);
                            B(str2, n34Var);
                            n34Var.a(new p34(31004, "apk install fail"));
                            this.d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = k34.c();
                            if (k34.k(c2)) {
                                ub3.M().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    n34Var.a(new p34(31002, "file is not exist"));
                    this.d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, o34Var) == null) {
            if (i()) {
                o34Var.a(new p34(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                o34Var.a(new p34(31007, "invalid params"));
                return;
            }
            Download v = this.d.v(optString);
            if (v == null) {
                h34.b().d(jSONObject, o34Var);
            } else {
                o34Var.a(new r34(v));
            }
        }
    }
}
