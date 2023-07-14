package com.baidu.tieba;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ri3;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class oi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final ExecutorService b;
    public static Object c;
    public static final Set<String> d;
    public static final CopyOnWriteArrayList<String> e;
    public transient /* synthetic */ FieldHolder $fh;

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;

        public a(xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(oi3.a());
                ci3.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ NetworkStatRecord k;

        public b(String str, long j, long j2, int i, int i2, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = i;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !SwanAppNetworkUtils.i(null)) {
                return;
            }
            if (oi3.o(this.a)) {
                if (oi3.a) {
                    Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.a);
                    return;
                }
                return;
            }
            long j = this.b - this.c;
            if (this.d == 200) {
                z = true;
            } else {
                z = false;
            }
            if (this.e == 0) {
                if (TextUtils.equals(this.f, "1")) {
                    if (z) {
                        mc2.d().e(lc2.c(this.a, this.c, this.b, this.d, this.g));
                    } else {
                        mc2.d().e(lc2.a(this.a, this.c, this.b, this.d, this.g));
                    }
                } else if (TextUtils.equals(this.f, "0")) {
                    mc2.d().e(lc2.b(this.a, this.c, this.g));
                }
            }
            if (z && j < 5000) {
                if (oi3.a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                    return;
                }
                return;
            }
            oi3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;

        public c(String str, int i, String str2, String str3, String str4, String str5, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            vi3 vi3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = i33.c();
                if (oi3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    vi3Var = new vi3(this.b, this.c, this.d, c);
                } else {
                    vi3Var = new vi3(this.c, c, 0L, 0L);
                }
                new ri3.a(vi3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    vi3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    vi3Var.q(this.f);
                }
                vi3Var.b = "downloadFile";
                if (vb3.M() != null && vb3.M().Y() != null) {
                    vi3Var.c = vb3.M().Y().T();
                }
                vi3Var.f = vb3.g0();
                vi3Var.a = oi3.n(this.g);
                JSONObject f = vi3Var.f();
                ci3.k("834", f);
                v82.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;

        public d(xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui3 a;

        public e(ui3 ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ForbiddenInfo b;

        public f(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wi3 wi3Var = new wi3();
                wi3Var.e = this.a;
                wi3Var.b = "show";
                wi3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                wi3Var.c = forbiddenInfo.launchSource;
                wi3Var.a("path", forbiddenInfo.launchPath);
                wi3Var.a("appkey", this.b.appId);
                ci3.m("1400", wi3Var.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Exception d;

        public g(String str, String str2, int i, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            vb3 b0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (b0 = vb3.b0()) == null) {
                return;
            }
            sw2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            wi3 wi3Var = new wi3();
            wi3Var.b = "login";
            wi3Var.a = oi3.n(W.G());
            wi3Var.f = appId;
            wi3Var.e = this.a;
            wi3Var.a("appName", Z);
            wi3Var.a("invokeFrom", this.b);
            wi3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = wi3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                v82.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                ci3.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                v82.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                ci3.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, "fail") || TextUtils.equals(this.a, "check_fail")) {
                v82.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                ci3.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Exception e;
        public final /* synthetic */ boolean f;

        public h(String str, String str2, String str3, boolean z, Exception exc, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Boolean.valueOf(z), exc, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = exc;
            this.f = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vb3 q = ub3.K().q();
                sw2.a W = q.W();
                String Z = q.Z();
                String appId = q.getAppId();
                wi3 wi3Var = new wi3();
                wi3Var.b = "swanLogin";
                wi3Var.a = oi3.n(W.G());
                wi3Var.f = appId;
                wi3Var.e = this.a;
                wi3Var.a("appName", Z);
                wi3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    wi3Var.a("errorInfo", str);
                }
                JSONObject f = wi3Var.f();
                if (this.d) {
                    v82.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    v82.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    v82.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                ci3.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public i(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xi3 xi3Var = new xi3();
                xi3Var.a = oi3.n(ub3.K().q().k());
                String str = this.a;
                xi3Var.b = str;
                xi3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    xi3Var.e = this.c;
                }
                xi3Var.f = ub3.K().getAppId();
                xi3Var.a("source", ub3.K().q().W().T());
                xi3Var.a("mode", "normal");
                xi3Var.a("from", "login");
                JSONObject f = xi3Var.f();
                if (oi3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                ci3.k("1936", f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public j(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (oi3.c) {
                    try {
                        oi3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;
        public final /* synthetic */ bi3 b;

        public k(xi3 xi3Var, bi3 bi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var, bi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
            this.b = bi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xi3 xi3Var = this.a;
                if (xi3Var != null) {
                    ci3.f(this.b, xi3Var.f().toString());
                }
                ci3.c(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public l(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wi3 wi3Var = new wi3();
                wi3Var.a = oi3.n(ub3.K().q().k());
                wi3Var.f = ub3.K().getAppId();
                if (this.a) {
                    i = 1;
                } else {
                    i = 2;
                }
                wi3Var.a("type", Integer.valueOf(i));
                wi3Var.a("errorCode", Long.valueOf(nr3.c().g()));
                wi3Var.a("degradeUrl", this.b);
                wi3Var.a("appid", ub3.K().getAppId());
                wi3Var.a("hostname", cv2.n().a());
                wi3Var.a("_swebfr", or3.e());
                ci3.i("3863", "3863", wi3Var.f());
                if (this.a) {
                    on3 on3Var = new on3();
                    on3Var.k(1L);
                    on3Var.i(2108L);
                    sn3.a().f(on3Var);
                    wi3 wi3Var2 = new wi3();
                    wi3Var2.p(on3Var);
                    wi3Var2.r(ub3.K().q().W());
                    wi3Var2.q(oi3.n(ub3.K().k()));
                    wi3Var2.m(ub3.K().getAppId());
                    oi3.R(wi3Var2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wi3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(wi3 wi3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wi3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(ub3.K().q().W().V());
                }
                JSONObject f = this.a.f();
                v82.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + jo3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                ci3.k("671", f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;
        public final /* synthetic */ String b;

        public n(xi3 xi3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                ci3.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    mi3.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xi3 c;

        public o(String str, String str2, xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = xi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui3 a;

        public p(ui3 ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui3 a;

        public q(ui3 ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui3 a;

        public r(ui3 ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui3 a;

        public s(ui3 ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948033168, "Lcom/baidu/tieba/oi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948033168, "Lcom/baidu/tieba/oi3;");
                return;
            }
        }
        a = fs1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(p82.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(p82.b() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            t(0, str, i2, null, null, null, "0");
        }
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            U(str, str2, null);
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            b.execute(new l(z, str));
        }
    }

    public static void i(bi3 bi3Var, xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, null, bi3Var, xi3Var) != null) || bi3Var == null) {
            return;
        }
        po3.j(new k(xi3Var, bi3Var), "SwanAppUBCEndFlow");
    }

    @NonNull
    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void w(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65587, null, forbiddenInfo, str) == null) && forbiddenInfo != null && !TextUtils.isEmpty(str)) {
            b.execute(new f(str, forbiddenInfo));
        }
    }

    public static void x(String str, xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65588, null, str, xi3Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        o53.e().d(new n(xi3Var, str), "SwanAppUBCOnEvent", true);
    }

    public static void B(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, networkStatRecord) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, "");
        }
    }

    public static void S(String str, int i2, String str2) {
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            if (TextUtils.equals(str, "fail")) {
                exc = new Exception("stack");
            } else {
                exc = null;
            }
            b.execute(new g(str, str2, i2, exc));
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, str, str2, str3) == null) {
            b.execute(new i(str, str2, str3));
        }
    }

    public static void y(String str, String str2, xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, str, str2, xi3Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            po3.j(new o(str, str2, xi3Var), "SwanAppUbcCeresOnEvent");
        }
    }

    public static void C(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
            M(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord, str2);
        }
    }

    public static void O(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, "");
        }
    }

    public static void D(String str, int i2, NetworkStatRecord networkStatRecord, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, networkStatRecord, str2) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, str2);
        }
    }

    public static void E() {
        sw2.a W;
        Bundle P;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && ub3.K().E() && (P = (W = ub3.K().q().W()).P()) != null && P.getLong("launch_flag_for_statistic") > 0) {
            long l2 = W.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            yi3 yi3Var = new yi3();
            yi3Var.a = n(ub3.K().k());
            yi3Var.f = W.H();
            if (u73.F(W.g0())) {
                yi3Var.c = "remote-debug";
            } else if (u73.D()) {
                yi3Var.c = "local-debug";
            } else {
                yi3Var.c = W.T();
            }
            yi3Var.b = "launch";
            yi3Var.e = "success";
            yi3Var.r = String.valueOf(currentTimeMillis - l2);
            yi3Var.a("status", "0");
            fi3.n(yi3Var, W.W(), W.s0().getString("ubc"));
            P.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = a53.d("startup");
            if (d2 != null) {
                if (!d2.w() && !d2.t()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    d2.E("value", "na_success");
                }
            }
        }
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            ub3 K = ub3.K();
            vb3 q2 = K.q();
            sw2.a W = q2.W();
            if (K.E() && q2.s0()) {
                Bundle s0 = W.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.W().u1());
                    yi3 yi3Var = new yi3();
                    yi3Var.a = n(W.G());
                    yi3Var.b = "launch";
                    yi3Var.e = "cancel";
                    yi3Var.q = valueOf;
                    yi3Var.j(W);
                    yi3Var.d(s0.getString("ubc"));
                    yi3Var.b(k(W.W()));
                    onEvent(yi3Var);
                    yi3 yi3Var2 = new yi3();
                    yi3Var2.a = n(W.G());
                    yi3Var2.b = "launch";
                    yi3Var2.e = "realcancel";
                    yi3Var2.q = valueOf;
                    yi3Var2.j(W);
                    yi3Var2.b(k(W.W()));
                    yi3Var2.a("reason", "cancel");
                    if (W.G() == 1) {
                        yi3Var.a("errorList", dv2.j().a());
                    }
                    yi3Var2.d(s0.getString("ubc"));
                    onEvent(yi3Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static void F(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            xi3 xi3Var = new xi3();
            if (ub3.K().q().I()) {
                xi3Var.d(ub3.K().q().W().s0().getString("ubc"));
            }
            xi3Var.b = "show";
            xi3Var.c = str;
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            xi3Var.e = str2;
            xi3Var.f = vb3.g0();
            o53.e().d(new a(xi3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (ub3.K().q().I()) {
                sw2.a W = ub3.K().q().W();
                i2 = W.G();
                str3 = W.s0().getString("ubc");
            } else {
                i2 = 0;
                str3 = "";
            }
            ui3 ui3Var = new ui3();
            ui3Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            ui3Var.c = str;
            ui3Var.f = vb3.g0();
            ui3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", vb3.M().Z());
                ui3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ui3Var.d(str3);
            }
            ui3Var.b(Z());
            po3.k(new q(ui3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            ui3 ui3Var = new ui3();
            sw2.a W = ub3.K().q().W();
            if (ub3.K().q().I()) {
                ui3Var.d(W.s0().getString("ubc"));
            }
            ui3Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            if (z) {
                str3 = "success";
            } else {
                str3 = "fail";
            }
            ui3Var.e = str3;
            ui3Var.c = str;
            ui3Var.f = vb3.g0();
            ui3Var.a = n(W.G());
            ui3Var.a("money", str2);
            ui3Var.b(Z());
            po3.j(new p(ui3Var), "SwanAppUBCOnPay");
        }
    }

    public static void q(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            xi3 xi3Var = new xi3();
            xi3Var.b = str;
            xi3Var.e = str2;
            xi3Var.f = vb3.g0();
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                xi3Var.c = Y.T();
                xi3Var.a = n(Y.G());
            }
            if (TextUtils.equals("click", str)) {
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "fail";
                }
                xi3Var.a("authorize", str3);
            }
            po3.k(new d(xi3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void z(String str, int i2, String str2) {
        vb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65590, null, str, i2, str2) != null) || (b0 = vb3.b0()) == null) {
            return;
        }
        on3 on3Var = new on3();
        on3Var.k(5L);
        on3Var.i(50L);
        wi3 wi3Var = new wi3();
        wi3Var.p(on3Var);
        wi3Var.r(b0.W());
        wi3Var.q(n(b0.k()));
        wi3Var.m(b0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", b0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        wi3Var.e(jSONObject);
        R(wi3Var);
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && ub3.K().q().I()) {
            sw2.a W = ub3.K().q().W();
            int G = W.G();
            ui3 ui3Var = new ui3();
            ui3Var.b = "paykey";
            ui3Var.a = n(G);
            ui3Var.c = str;
            ui3Var.e = str4;
            ui3Var.a("appid", W.H());
            ui3Var.a("money", str2);
            ui3Var.a("source", W.T());
            ui3Var.a("pmappkey", str3);
            po3.k(new s(ui3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        w13 P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ui3 ui3Var = new ui3();
            sw2.a W = ub3.K().q().W();
            if (ub3.K().q().I()) {
                ui3Var.d(W.s0().getString("ubc"));
            }
            ui3Var.b = "paylogin";
            ui3Var.c = str;
            ui3Var.f = W.I();
            ui3Var.a = n(W.G());
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            ui3Var.e = str2;
            ui3Var.a("nativeAppId", cv2.n().a());
            if (z2) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            ui3Var.a("paylogin", str3);
            db2 H = ix2.T().H();
            if (H == null) {
                P1 = null;
            } else {
                P1 = H.P1();
            }
            if (P1 != null && !TextUtils.isEmpty(P1.i())) {
                ui3Var.a("page", P1.i());
            }
            ui3Var.b(Z());
            po3.j(new e(ui3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && ub3.K().q().I()) {
            sw2.a W = ub3.K().q().W();
            int G = W.G();
            ui3 ui3Var = new ui3();
            ui3Var.b = "payProcess";
            ui3Var.a = n(G);
            ui3Var.c = str;
            ui3Var.a("paymentProcess", str2);
            ui3Var.a("appid", W.H());
            ui3Var.a("source", W.T());
            if (W.j0() != null) {
                ui3Var.a("swan", W.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        ui3Var.a("payResultStatus", "fail");
                    } else {
                        ui3Var.a("payResultStatus", "cancel");
                    }
                } else {
                    ui3Var.a("payResultStatus", "success");
                }
            }
            ui3Var.b(Z());
            po3.k(new r(ui3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            yi3 yi3Var = new yi3();
            yi3Var.b = "launch";
            yi3Var.e = str;
            if (vb3.b0() != null) {
                sw2.a W = vb3.b0().W();
                yi3Var.a = n(W.G());
                yi3Var.f = W.H();
                yi3Var.c = W.T();
            }
            yi3Var.t = str2;
            onEvent(yi3Var);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
                }
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                    }
                } else if (d.contains(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                    }
                } else {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject);
                    }
                    ci3.i("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, jSONObject);
                }
            }
        }
    }

    public static void P(int i2, String str, int i3, String str2, long j2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3), str3}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, str3);
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) != null) || i2 == 200) {
            return;
        }
        b.execute(new c(str5, i2, str, str2, str3, str4, i3));
    }

    public static void Q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5}) == null) {
            M(i2, str, i3, str2, str3, str4, "1", j2, j3, null, str5);
        }
    }

    public static void R(wi3 wi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, wi3Var) != null) || wi3Var == null) {
            return;
        }
        po3.j(new m(wi3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    public static bi3 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return ci3.a(str);
        }
        return (bi3) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            xi3 xi3Var = new xi3();
            xi3Var.a = n(0);
            xi3Var.b = str;
            x("956", xi3Var);
        }
    }

    public static void U(String str, String str2, String str3) {
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, str2, str3) == null) {
            boolean equals = TextUtils.equals(str2, "cancel");
            boolean equals2 = TextUtils.equals(str2, "fail");
            if (!equals && !equals2) {
                exc = null;
            } else {
                exc = new Exception("stack");
            }
            b.execute(new h(str2, str, str3, equals, exc, equals2));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            xi3 xi3Var = new xi3();
            vb3 b0 = vb3.b0();
            String str5 = "";
            if (b0 == null) {
                str3 = "";
                str4 = str3;
            } else {
                str5 = n(b0.k());
                str4 = b0.O();
                str3 = b0.W().T();
            }
            xi3Var.a = str5;
            xi3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            xi3Var.c = str3;
            xi3Var.a("appkey", str4);
            xi3Var.a("url", str);
            xi3Var.a("browser", str2);
            y("3320", "96", xi3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", xi3Var.f()));
            }
        }
    }

    public static void r(int i2, vg3 vg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, vg3Var) == null) {
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            wi3 wi3Var = new wi3();
            wi3Var.o(i2);
            wi3Var.r(b0.Y());
            wi3Var.q(n(b0.k()));
            wi3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", tg3.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, b0.e0().q("cur_request_id", ""));
                if (vg3Var != null) {
                    jSONObject.put("scope", vg3Var.b);
                    jSONObject.put("scopeData", vg3Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            wi3Var.e(jSONObject);
            R(wi3Var);
        }
    }

    public static JSONObject X(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, networkStatRecord)) == null) {
            if (networkStatRecord == null) {
                return null;
            }
            long j2 = networkStatRecord.dnsEndTs;
            long j3 = networkStatRecord.dnsStartTs;
            long j4 = networkStatRecord.connTs;
            long j5 = networkStatRecord.startTs;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_network_start", j5);
                jSONObject.put("request_network_conn", j4);
                jSONObject.put("request_dns_start", j3);
                jSONObject.put("request_dns_end", j2);
                jSONObject.put("request_network_response", networkStatRecord.responseTs);
                jSONObject.put("request_send_header", networkStatRecord.sendHeaderTs);
                jSONObject.put("request_receive_header", networkStatRecord.receiveHeaderTs);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("connectTime", jSONObject);
                return jSONObject2;
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void d(yi3 yi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, yi3Var) == null) && yi3Var != null && vb3.M() != null && vb3.M().Y() != null) {
            sw2.a Y = vb3.M().Y();
            yi3Var.a = n(Y.G());
            yi3Var.f = Y.H();
            yi3Var.a("appkey", Y.I());
            x("1032", yi3Var);
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null) {
                        if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                            return optJSONObject;
                        }
                    }
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        sw2.a Y;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            vb3 M2 = vb3.M();
            if (M2 == null || (Y = M2.Y()) == null || (M = Y.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static /* synthetic */ JSONObject a() {
        return Z();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.oi3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (i23.g()) {
                return "1";
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (c) {
                try {
                    c.notifyAll();
                }
            }
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            xi3 xi3Var = new xi3();
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                xi3Var.a = n(Y.G());
                xi3Var.f = Y.H();
                xi3Var.b = str;
                xi3Var.c = str2;
                xi3Var.e = str3;
                xi3Var.a("appkey", Y.I());
            }
            x("923", xi3Var);
        }
    }

    public static void g(xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, xi3Var) == null) {
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                xi3Var.a = n(Y.G());
                xi3Var.f = Y.H();
                xi3Var.c = Y.T();
            }
            x("936", xi3Var);
        }
    }

    public static void h(xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, xi3Var) == null) {
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                xi3Var.a = n(Y.G());
                xi3Var.f = Y.H();
                xi3Var.c = Y.T();
            }
            x("914", xi3Var);
        }
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        vi3 vi3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = i33.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                vi3Var = new vi3(i2, str, str2, c2, j2, j3);
            } else {
                vi3Var = new vi3(str, c2, j2, j3);
            }
            ri3.a aVar = new ri3.a(vi3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                vi3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                vi3Var.q(str4);
            }
            vi3Var.b = "request";
            vb3 q2 = ub3.K().q();
            if (q2 != null && q2.I()) {
                vi3Var.c = q2.W().T();
                vi3Var.d = q2.W().V();
            }
            vi3Var.f = vb3.g0();
            vi3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                vi3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + vi3Var.f());
            }
            JSONObject f2 = vi3Var.f();
            if (vi3Var.o()) {
                v82.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                v82.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            ci3.k("834", f2);
            N(vi3Var.m(), vi3Var.n(), f2);
        }
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (a) {
                Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = e.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onEvent(yi3 yi3Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, yi3Var) == null) {
            ExtensionCore T2 = pi2.U().T();
            if (T2 != null) {
                yi3Var.a("extension_ver", T2.extensionCoreVersionName);
            }
            if (ub3.K().q().W().c("launch_by_reload")) {
                str = "1";
            } else {
                str = "0";
            }
            yi3Var.a("isReloadApp", str);
            JSONObject jSONObject = new JSONObject();
            vo3.f(jSONObject, "static", Float.valueOf(cv2.m().a()));
            yi3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, yi3Var);
        }
    }

    public static void u(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            t(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void v(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            t(i2, str, i3, str2, str3, str4, "1");
        }
    }
}
