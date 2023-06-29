package com.baidu.tieba;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.install.GameNowInstallAntiBlockingActivity;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile o24 l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;
    public n24 a;
    public n24 b;
    public n24 c;
    public DownloadManager d;
    public l24 e;
    public s24 f;
    public BroadcastReceiver g;
    public JSONObject h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ o24 e;

        public a(o24 o24Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o24Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o24Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y24.n().h(this.a, new x24(this.e.h), this.b, this.c, this.d);
                if (qx2.a().b()) {
                    return;
                }
                if (o24.k) {
                    Log.d("GameNowAppManager", "start InstallAntiBlockingActivity");
                }
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.a);
                intent.putExtra("packageName", this.b);
                if (this.e.h != null) {
                    intent.putExtra("ubc_params", this.e.h.toString());
                }
                intent.setFlags(276824064);
                lo3.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o24 a;

        public b(o24 o24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o24Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
                if (ms1.a) {
                    Log.d("GameNowAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
                if (!this.a.c.d(String.valueOf(j))) {
                    return;
                }
                this.a.c.b(String.valueOf(j), new r24(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o24 a;

        public c(o24 o24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o24Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) && download != null && download.getId() != null) {
                String valueOf = String.valueOf(download.getId());
                download.getKeyByUser();
                if (o24.k) {
                    Log.d("GameNowAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                }
                if (download.getState() != Download.DownloadState.FINISH || !download.getMimetype().equals("application/zip")) {
                    if (!this.a.a.d(valueOf)) {
                        return;
                    }
                    this.a.a.b(valueOf, new r24(download));
                    k24 k24Var = new k24(download);
                    int i = f.a[download.getState().ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                y24.n().h("reallyDownloadFail", new x24(this.a.h), k24Var.m(), k24Var.j(), k24Var.l());
                                this.a.F(valueOf);
                                this.a.E(valueOf);
                                return;
                            }
                            return;
                        }
                        String j2 = k24Var.j();
                        if (this.a.w(download)) {
                            this.a.L(download.getUrl(), download.getKeyByUser(), j2);
                            y24.n().f("reallyDownloaded", new x24(this.a.h), k24Var.m(), k24Var.j(), k24Var.l());
                            if (TextUtils.equals(k24Var.m(), g24.a)) {
                                y24.n().p(12, k24Var.m(), k24Var.h(), k24Var.l());
                            }
                            this.a.F(valueOf);
                            this.a.E(valueOf);
                            return;
                        }
                        k24Var.p("download_current_bytes", download.getCurrentbytes());
                        k24Var.p("download_total_bytes", download.getTotalbytes());
                        y24.n().h("analysisFailed", new x24(this.a.h), k24Var.m(), k24Var.j(), k24Var.l());
                        String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            str = is4.b(new File(str2), true);
                        } else {
                            str = "";
                        }
                        y24.n().q(1001, download.getKeyByUser(), download.getUrl(), this.a.j, str, download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                        ub3.g(jv2.c(), jv2.c().getString(R.string.obfuscated_res_0x7f0f01b2)).G();
                        this.a.s(download.getKeyByUser());
                        if (this.a.i < 2) {
                            this.a.J(download.getUrl(), download.getKeyByUser(), download.getFromParam());
                            return;
                        }
                        this.a.F(valueOf);
                        this.a.E(valueOf);
                        return;
                    }
                    y24.n().f("reallyPause", new x24(this.a.h), k24Var.m(), k24Var.j(), k24Var.l());
                    return;
                }
                this.a.M(download);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o24 this$0;

        public d(o24 o24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = o24Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (o24.k) {
                    Log.d("GameNowAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                }
                if (this.this$0.b.d(schemeSpecificPart)) {
                    this.this$0.b.b(schemeSpecificPart, new r24(true));
                    this.this$0.D(schemeSpecificPart, null);
                }
                Download g = this.this$0.e.g(schemeSpecificPart);
                if (g != null) {
                    k24 k24Var = new k24(g);
                    String h = k24Var.h();
                    if (TextUtils.equals(k24Var.m(), g24.a) || TextUtils.isEmpty(h)) {
                        y24.n().h("reallyInstalled", new x24(this.this$0.h), k24Var.m(), k24Var.j(), k24Var.l());
                        this.this$0.n(g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;

        public e(o24 o24Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o24Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = download;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    gs4.M(this.a.getFromParam());
                    String str = this.a.getFromParam() + File.separator + this.a.getFileName().replace(".zip", "");
                    String str2 = k24.n() + File.separator + this.a.getFileName();
                    if (o24.k) {
                        Log.d("GameNowAppManager", "unzip: " + str + " zip:  " + str2);
                    }
                    gs4.U(str2, str);
                    gs4.M(str2);
                } catch (Exception e) {
                    if (o24.k) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-596649354, "Lcom/baidu/tieba/o24$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-596649354, "Lcom/baidu/tieba/o24$f;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947980344, "Lcom/baidu/tieba/o24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947980344, "Lcom/baidu/tieba/o24;");
                return;
            }
        }
        k = ms1.a;
        m = Executors.newSingleThreadExecutor();
    }

    public static o24 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (l == null) {
                synchronized (o24.class) {
                    if (l == null) {
                        l = new o24();
                    }
                }
            }
            return l;
        }
        return (o24) invokeV.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.registerOnStateChangeListener(new c(this));
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return !ProcessUtils.isMainProcess();
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.e.b();
            }
        }
    }

    public o24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new n24();
        this.b = new n24();
        this.c = new n24();
        this.i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.d = downloadManager;
        this.e = new l24(downloadManager);
        B();
        C();
        A();
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c.f(str);
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.a.f(str);
        }
    }

    public void H(s24 s24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, s24Var) == null) {
            this.f = s24Var;
        }
    }

    public void I(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) && jSONObject != null) {
            this.h = jSONObject;
        }
    }

    public final void M(Download download) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, download) == null) && download != null && !TextUtils.isEmpty(download.getFileName())) {
            wo3.j(new e(this, download), "unzipRes");
        }
    }

    public void D(String str, v24 v24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, v24Var) == null) {
            this.b.g(str, v24Var);
        }
    }

    public final synchronized void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                this.g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.g, intentFilter);
            }
        }
    }

    public void G(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && !o() && SwanAppNetworkUtils.i(null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Download g = this.e.g(str2);
            if (g == null) {
                J(str, str2, str3);
            } else if (g.getState() == Download.DownloadState.FINISH) {
                y24.n().h("resumeDownloadInstall", new x24(this.h), str2, str3, str);
                L(str, str2, str3);
            } else {
                this.a.a(String.valueOf(g.getId()), this.f);
                this.c.a(String.valueOf(g.getId()), this.f);
                this.d.resume(g.getId().longValue());
            }
        }
    }

    public void p(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && !o() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Download h = this.e.h(str2);
            if (h != null) {
                k24 k24Var = new k24(h);
                long k2 = k24Var.k();
                k24Var.p("download_status", h.getState());
                String j2 = k24Var.j();
                if (k2 != 0 && System.currentTimeMillis() - k2 > j) {
                    s(str2);
                    y24.n().h("package_expired", new x24(this.h), str2, j2, str);
                    return;
                }
                z(str2);
                return;
            }
            s24 s24Var = this.f;
            if (s24Var != null) {
                s24Var.a(new q24(DownloadState.NOT_START.name()));
            }
        }
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) && !o() && SwanAppNetworkUtils.i(null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (u24.g(AppRuntime.getAppContext(), str2)) {
                s24 s24Var = this.f;
                if (s24Var != null) {
                    s24Var.a(new r24(true));
                    return;
                }
                return;
            }
            this.e.c(str2);
            qk3.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
            JSONObject d2 = cp3.d(str3);
            String optString = d2.optString("apk_id");
            String optString2 = d2.optString("from_view");
            String optString3 = d2.optString("from_value");
            String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            k24 k24Var = new k24();
            k24Var.r(str);
            k24Var.o(str2);
            k24Var.a(optString);
            k24Var.g(optString2);
            k24Var.f(optString3);
            k24Var.d(optString4);
            Download b2 = k24Var.b();
            this.d.start(b2);
            if (b2.getId() != null) {
                this.a.a(String.valueOf(b2.getId()), this.f);
                this.c.a(String.valueOf(b2.getId()), this.f);
            }
            if (TextUtils.equals(str2, g24.a)) {
                y24.n().p(11, str2, optString, str);
            }
            y24.n().f("reallyBeginDownload", new x24(this.h), str2, b2.getFromParam(), str);
        }
    }

    public void K(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) && !o() && SwanAppNetworkUtils.i(null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.e.c(str2);
            k24 k24Var = new k24();
            k24Var.r(str);
            k24Var.o(str2);
            k24Var.e(str2);
            k24Var.q(str3);
            this.d.start(k24Var.c());
        }
    }

    public void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String m2 = m(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new x24(this.h).a());
            bundle.putString(DownloadConstants.DOWNLOAD_PARAMS, m2);
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtras(bundle);
            AppRuntime.getAppContext().startActivity(intent);
        }
    }

    public final <T> String m(String str, String str2, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, t)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put(str2, t);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public final void n(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, download) == null) {
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (!TextUtils.isEmpty(realDownloadDir) && !TextUtils.isEmpty(fileName)) {
                r(realDownloadDir + File.separator + fileName);
            }
            q();
        }
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (k) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(String str) {
        Download g;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || o() || TextUtils.isEmpty(str) || (g = this.e.g(str)) == null) {
            return;
        }
        this.e.c(str);
        s24 s24Var = this.f;
        if (s24Var != null) {
            s24Var.a(new r24(g, true));
        }
    }

    public void z(String str) {
        Download g;
        s24 s24Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && !o() && !TextUtils.isEmpty(str) && (g = this.e.g(str)) != null && (s24Var = this.f) != null) {
            s24Var.a(new r24(g));
        }
    }

    public boolean u(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, str, str2, str3)) == null) {
            if (o()) {
                y24.n().h("checkIllegalProcess", new x24(this.h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download g = this.e.g(str2);
                if (g == null) {
                    y24.n().h("nullDownload", new x24(this.h), str2, str3, str);
                    J(str, str2, str3);
                    return false;
                }
                String realDownloadDir = g.getRealDownloadDir();
                String fileName = g.getFileName();
                if (k) {
                    Log.d("GameNowAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.e.c(str2);
                }
                String str4 = realDownloadDir + File.separator + fileName;
                if (u24.g(AppRuntime.getAppContext(), str2)) {
                    y24.n().h("hasInstalled", new x24(this.h), str2, str3, str);
                    s24 s24Var = this.f;
                    if (s24Var != null) {
                        s24Var.a(new r24(true));
                    }
                    r(str4);
                    return false;
                }
                File file = new File(str4);
                if (file.isFile() && file.exists()) {
                    this.b.a(str2, this.f);
                    if (u24.i(activity, str4, false)) {
                        new k24(g).p("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        y24.n().h("showInstallView", new x24(this.h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = u24.c();
                        if (u24.j(c2)) {
                            bc3.M().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    y24.n().h("showInstallViewFailed", new x24(this.h), str2, str3, str);
                    D(str2, this.f);
                    this.e.c(str2);
                    return false;
                }
                y24.n().h("nullGamenowFile", new x24(this.h), str2, str3, str);
                J(str, str2, str3);
                return false;
            } else {
                y24.n().h("nullPackagenameOrUrl", new x24(this.h), str2, str3, str);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean v(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, str, j)) == null) {
            if (new File(str).length() < j) {
                this.j = 3;
                return false;
            }
            try {
                ZipFile zipFile = new ZipFile(str);
                if (zipFile.getEntry("AndroidManifest.xml") != null) {
                    z = true;
                } else {
                    z = false;
                }
                zipFile.close();
                return z;
            } catch (Exception e2) {
                if (k) {
                    Log.e("GameNowAppManager", "解析APK出错:" + e2.getMessage());
                }
                this.j = 4;
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public void x(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) && !o() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Download g = this.e.g(str2);
            if (g != null) {
                str3 = g.getFromParam();
            } else {
                str3 = "";
            }
            String str4 = str3;
            if (u24.k(AppRuntime.getAppContext(), str2)) {
                y24.n().h("manualOpen", new x24(this.h), str2, str4, str);
            }
        }
    }

    public final boolean w(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, download)) == null) {
            this.i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.j = 2;
                    return false;
                }
                return v(str, longValue);
            }
            if (k) {
                Log.e("GameNowAppManager", "apk文件找不到");
            }
            this.j = 1;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(String str) {
        Download g;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, str) != null) || o() || TextUtils.isEmpty(str) || (g = this.e.g(str)) == null) {
            return;
        }
        if (g.getState() != Download.DownloadState.WAITING && g.getState() != Download.DownloadState.DOWNLOADING) {
            return;
        }
        this.d.pause(g.getId().longValue());
        s24 s24Var = this.f;
        if (s24Var != null) {
            s24Var.a(new r24(g));
        }
    }
}
