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
import com.baidu.tieba.aw2;
import com.baidu.tieba.zh3;
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
/* loaded from: classes8.dex */
public final class wh3 {
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

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        public a(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(wh3.a());
                kh3.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (wh3.o(this.a)) {
                if (wh3.a) {
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
                        ub2.d().e(tb2.c(this.a, this.c, this.b, this.d, this.g));
                    } else {
                        ub2.d().e(tb2.a(this.a, this.c, this.b, this.d, this.g));
                    }
                } else if (TextUtils.equals(this.f, "0")) {
                    ub2.d().e(tb2.b(this.a, this.c, this.g));
                }
            }
            if (z && j < 5000) {
                if (wh3.a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                    return;
                }
                return;
            }
            wh3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
        }
    }

    /* loaded from: classes8.dex */
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
            di3 di3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = q23.c();
                if (wh3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    di3Var = new di3(this.b, this.c, this.d, c);
                } else {
                    di3Var = new di3(this.c, c, 0L, 0L);
                }
                new zh3.a(di3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    di3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    di3Var.q(this.f);
                }
                di3Var.b = "downloadFile";
                if (db3.M() != null && db3.M().Y() != null) {
                    di3Var.c = db3.M().Y().T();
                }
                di3Var.f = db3.g0();
                di3Var.a = wh3.n(this.g);
                JSONObject f = di3Var.f();
                kh3.k("834", f);
                d82.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        public d(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci3 a;

        public e(ci3 ci3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
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
                ei3 ei3Var = new ei3();
                ei3Var.e = this.a;
                ei3Var.b = "show";
                ei3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                ei3Var.c = forbiddenInfo.launchSource;
                ei3Var.a("path", forbiddenInfo.launchPath);
                ei3Var.a("appkey", this.b.appId);
                kh3.m("1400", ei3Var.f());
            }
        }
    }

    /* loaded from: classes8.dex */
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
            db3 b0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (b0 = db3.b0()) == null) {
                return;
            }
            aw2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            ei3 ei3Var = new ei3();
            ei3Var.b = "login";
            ei3Var.a = wh3.n(W.G());
            ei3Var.f = appId;
            ei3Var.e = this.a;
            ei3Var.a("appName", Z);
            ei3Var.a("invokeFrom", this.b);
            ei3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = ei3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                d82.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                kh3.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                d82.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                kh3.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, "fail") || TextUtils.equals(this.a, "check_fail")) {
                d82.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                kh3.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                db3 q = cb3.K().q();
                aw2.a W = q.W();
                String Z = q.Z();
                String appId = q.getAppId();
                ei3 ei3Var = new ei3();
                ei3Var.b = "swanLogin";
                ei3Var.a = wh3.n(W.G());
                ei3Var.f = appId;
                ei3Var.e = this.a;
                ei3Var.a("appName", Z);
                ei3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    ei3Var.a("errorInfo", str);
                }
                JSONObject f = ei3Var.f();
                if (this.d) {
                    d82.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    d82.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    d82.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                kh3.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                fi3 fi3Var = new fi3();
                fi3Var.a = wh3.n(cb3.K().q().k());
                String str = this.a;
                fi3Var.b = str;
                fi3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    fi3Var.e = this.c;
                }
                fi3Var.f = cb3.K().getAppId();
                fi3Var.a("source", cb3.K().q().W().T());
                fi3Var.a("mode", "normal");
                fi3Var.a("from", "login");
                JSONObject f = fi3Var.f();
                if (wh3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                kh3.k("1936", f);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                synchronized (wh3.c) {
                    try {
                        wh3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;
        public final /* synthetic */ jh3 b;

        public k(fi3 fi3Var, jh3 jh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var, jh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
            this.b = jh3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fi3 fi3Var = this.a;
                if (fi3Var != null) {
                    kh3.f(this.b, fi3Var.f().toString());
                }
                kh3.c(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                ei3 ei3Var = new ei3();
                ei3Var.a = wh3.n(cb3.K().q().k());
                ei3Var.f = cb3.K().getAppId();
                if (this.a) {
                    i = 1;
                } else {
                    i = 2;
                }
                ei3Var.a("type", Integer.valueOf(i));
                ei3Var.a("errorCode", Long.valueOf(vq3.c().g()));
                ei3Var.a("degradeUrl", this.b);
                ei3Var.a("appid", cb3.K().getAppId());
                ei3Var.a("hostname", ku2.n().a());
                ei3Var.a("_swebfr", wq3.e());
                kh3.i("3863", "3863", ei3Var.f());
                if (this.a) {
                    wm3 wm3Var = new wm3();
                    wm3Var.k(1L);
                    wm3Var.i(2108L);
                    an3.a().f(wm3Var);
                    ei3 ei3Var2 = new ei3();
                    ei3Var2.p(wm3Var);
                    ei3Var2.r(cb3.K().q().W());
                    ei3Var2.q(wh3.n(cb3.K().k()));
                    ei3Var2.m(cb3.K().getAppId());
                    wh3.R(ei3Var2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(ei3 ei3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ei3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(cb3.K().q().W().V());
                }
                JSONObject f = this.a.f();
                d82.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + rn3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                kh3.k("671", f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;
        public final /* synthetic */ String b;

        public n(fi3 fi3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                kh3.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    uh3.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fi3 c;

        public o(String str, String str2, fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, fi3Var};
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
            this.c = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci3 a;

        public p(ci3 ci3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci3 a;

        public q(ci3 ci3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci3 a;

        public r(ci3 ci3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci3 a;

        public s(ci3 ci3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270535, "Lcom/baidu/tieba/wh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270535, "Lcom/baidu/tieba/wh3;");
                return;
            }
        }
        a = nr1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(x72.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(x72.b() + "/smtapp/recordhandler/getrecordinfo");
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

    public static void i(jh3 jh3Var, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, null, jh3Var, fi3Var) != null) || jh3Var == null) {
            return;
        }
        xn3.j(new k(fi3Var, jh3Var), "SwanAppUBCEndFlow");
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

    public static void x(String str, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65588, null, str, fi3Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        w43.e().d(new n(fi3Var, str), "SwanAppUBCOnEvent", true);
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

    public static void y(String str, String str2, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, str, str2, fi3Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            xn3.j(new o(str, str2, fi3Var), "SwanAppUbcCeresOnEvent");
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
        aw2.a W;
        Bundle P;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && cb3.K().E() && (P = (W = cb3.K().q().W()).P()) != null && P.getLong("launch_flag_for_statistic") > 0) {
            long l2 = W.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            gi3 gi3Var = new gi3();
            gi3Var.a = n(cb3.K().k());
            gi3Var.f = W.H();
            if (c73.F(W.g0())) {
                gi3Var.c = "remote-debug";
            } else if (c73.D()) {
                gi3Var.c = "local-debug";
            } else {
                gi3Var.c = W.T();
            }
            gi3Var.b = "launch";
            gi3Var.e = "success";
            gi3Var.r = String.valueOf(currentTimeMillis - l2);
            gi3Var.a("status", "0");
            nh3.n(gi3Var, W.W(), W.s0().getString("ubc"));
            P.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = i43.d("startup");
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
            cb3 K = cb3.K();
            db3 q2 = K.q();
            aw2.a W = q2.W();
            if (K.E() && q2.s0()) {
                Bundle s0 = W.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.W().u1());
                    gi3 gi3Var = new gi3();
                    gi3Var.a = n(W.G());
                    gi3Var.b = "launch";
                    gi3Var.e = "cancel";
                    gi3Var.q = valueOf;
                    gi3Var.j(W);
                    gi3Var.d(s0.getString("ubc"));
                    gi3Var.b(k(W.W()));
                    onEvent(gi3Var);
                    gi3 gi3Var2 = new gi3();
                    gi3Var2.a = n(W.G());
                    gi3Var2.b = "launch";
                    gi3Var2.e = "realcancel";
                    gi3Var2.q = valueOf;
                    gi3Var2.j(W);
                    gi3Var2.b(k(W.W()));
                    gi3Var2.a("reason", "cancel");
                    if (W.G() == 1) {
                        gi3Var.a("errorList", lu2.j().a());
                    }
                    gi3Var2.d(s0.getString("ubc"));
                    onEvent(gi3Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static void F(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            fi3 fi3Var = new fi3();
            if (cb3.K().q().I()) {
                fi3Var.d(cb3.K().q().W().s0().getString("ubc"));
            }
            fi3Var.b = "show";
            fi3Var.c = str;
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            fi3Var.e = str2;
            fi3Var.f = db3.g0();
            w43.e().d(new a(fi3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (cb3.K().q().I()) {
                aw2.a W = cb3.K().q().W();
                i2 = W.G();
                str3 = W.s0().getString("ubc");
            } else {
                i2 = 0;
                str3 = "";
            }
            ci3 ci3Var = new ci3();
            ci3Var.b = "pay";
            ci3Var.c = str;
            ci3Var.f = db3.g0();
            ci3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", db3.M().Z());
                ci3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ci3Var.d(str3);
            }
            ci3Var.b(Z());
            xn3.k(new q(ci3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            ci3 ci3Var = new ci3();
            aw2.a W = cb3.K().q().W();
            if (cb3.K().q().I()) {
                ci3Var.d(W.s0().getString("ubc"));
            }
            ci3Var.b = "pay";
            if (z) {
                str3 = "success";
            } else {
                str3 = "fail";
            }
            ci3Var.e = str3;
            ci3Var.c = str;
            ci3Var.f = db3.g0();
            ci3Var.a = n(W.G());
            ci3Var.a("money", str2);
            ci3Var.b(Z());
            xn3.j(new p(ci3Var), "SwanAppUBCOnPay");
        }
    }

    public static void q(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            fi3 fi3Var = new fi3();
            fi3Var.b = str;
            fi3Var.e = str2;
            fi3Var.f = db3.g0();
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                fi3Var.c = Y.T();
                fi3Var.a = n(Y.G());
            }
            if (TextUtils.equals("click", str)) {
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "fail";
                }
                fi3Var.a("authorize", str3);
            }
            xn3.k(new d(fi3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void z(String str, int i2, String str2) {
        db3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65590, null, str, i2, str2) != null) || (b0 = db3.b0()) == null) {
            return;
        }
        wm3 wm3Var = new wm3();
        wm3Var.k(5L);
        wm3Var.i(50L);
        ei3 ei3Var = new ei3();
        ei3Var.p(wm3Var);
        ei3Var.r(b0.W());
        ei3Var.q(n(b0.k()));
        ei3Var.m(b0.getAppId());
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
        ei3Var.e(jSONObject);
        R(ei3Var);
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && cb3.K().q().I()) {
            aw2.a W = cb3.K().q().W();
            int G = W.G();
            ci3 ci3Var = new ci3();
            ci3Var.b = "paykey";
            ci3Var.a = n(G);
            ci3Var.c = str;
            ci3Var.e = str4;
            ci3Var.a("appid", W.H());
            ci3Var.a("money", str2);
            ci3Var.a("source", W.T());
            ci3Var.a("pmappkey", str3);
            xn3.k(new s(ci3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        e13 P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ci3 ci3Var = new ci3();
            aw2.a W = cb3.K().q().W();
            if (cb3.K().q().I()) {
                ci3Var.d(W.s0().getString("ubc"));
            }
            ci3Var.b = "paylogin";
            ci3Var.c = str;
            ci3Var.f = W.I();
            ci3Var.a = n(W.G());
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            ci3Var.e = str2;
            ci3Var.a("nativeAppId", ku2.n().a());
            if (z2) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            ci3Var.a("paylogin", str3);
            la2 H = qw2.T().H();
            if (H == null) {
                P1 = null;
            } else {
                P1 = H.P1();
            }
            if (P1 != null && !TextUtils.isEmpty(P1.i())) {
                ci3Var.a("page", P1.i());
            }
            ci3Var.b(Z());
            xn3.j(new e(ci3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && cb3.K().q().I()) {
            aw2.a W = cb3.K().q().W();
            int G = W.G();
            ci3 ci3Var = new ci3();
            ci3Var.b = "payProcess";
            ci3Var.a = n(G);
            ci3Var.c = str;
            ci3Var.a("paymentProcess", str2);
            ci3Var.a("appid", W.H());
            ci3Var.a("source", W.T());
            if (W.j0() != null) {
                ci3Var.a("swan", W.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        ci3Var.a("payResultStatus", "fail");
                    } else {
                        ci3Var.a("payResultStatus", "cancel");
                    }
                } else {
                    ci3Var.a("payResultStatus", "success");
                }
            }
            ci3Var.b(Z());
            xn3.k(new r(ci3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            gi3 gi3Var = new gi3();
            gi3Var.b = "launch";
            gi3Var.e = str;
            if (db3.b0() != null) {
                aw2.a W = db3.b0().W();
                gi3Var.a = n(W.G());
                gi3Var.f = W.H();
                gi3Var.c = W.T();
            }
            gi3Var.t = str2;
            onEvent(gi3Var);
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
                    kh3.i("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, jSONObject);
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

    public static void R(ei3 ei3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, ei3Var) != null) || ei3Var == null) {
            return;
        }
        xn3.j(new m(ei3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    public static jh3 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return kh3.a(str);
        }
        return (jh3) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            fi3 fi3Var = new fi3();
            fi3Var.a = n(0);
            fi3Var.b = str;
            x("956", fi3Var);
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
            fi3 fi3Var = new fi3();
            db3 b0 = db3.b0();
            String str5 = "";
            if (b0 == null) {
                str3 = "";
                str4 = str3;
            } else {
                str5 = n(b0.k());
                str4 = b0.O();
                str3 = b0.W().T();
            }
            fi3Var.a = str5;
            fi3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            fi3Var.c = str3;
            fi3Var.a("appkey", str4);
            fi3Var.a("url", str);
            fi3Var.a("browser", str2);
            y("3320", "96", fi3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", fi3Var.f()));
            }
        }
    }

    public static void r(int i2, dg3 dg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, dg3Var) == null) {
            db3 b0 = db3.b0();
            if (b0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            ei3 ei3Var = new ei3();
            ei3Var.o(i2);
            ei3Var.r(b0.Y());
            ei3Var.q(n(b0.k()));
            ei3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", bg3.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, b0.e0().q("cur_request_id", ""));
                if (dg3Var != null) {
                    jSONObject.put("scope", dg3Var.b);
                    jSONObject.put("scopeData", dg3Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            ei3Var.e(jSONObject);
            R(ei3Var);
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

    public static void d(gi3 gi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, gi3Var) == null) && gi3Var != null && db3.M() != null && db3.M().Y() != null) {
            aw2.a Y = db3.M().Y();
            gi3Var.a = n(Y.G());
            gi3Var.f = Y.H();
            gi3Var.a("appkey", Y.I());
            x("1032", gi3Var);
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
        aw2.a Y;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            db3 M2 = db3.M();
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.wh3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (q13.g()) {
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
            fi3 fi3Var = new fi3();
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                fi3Var.a = n(Y.G());
                fi3Var.f = Y.H();
                fi3Var.b = str;
                fi3Var.c = str2;
                fi3Var.e = str3;
                fi3Var.a("appkey", Y.I());
            }
            x("923", fi3Var);
        }
    }

    public static void g(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, fi3Var) == null) {
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                fi3Var.a = n(Y.G());
                fi3Var.f = Y.H();
                fi3Var.c = Y.T();
            }
            x("936", fi3Var);
        }
    }

    public static void h(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, fi3Var) == null) {
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                fi3Var.a = n(Y.G());
                fi3Var.f = Y.H();
                fi3Var.c = Y.T();
            }
            x("914", fi3Var);
        }
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        di3 di3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = q23.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                di3Var = new di3(i2, str, str2, c2, j2, j3);
            } else {
                di3Var = new di3(str, c2, j2, j3);
            }
            zh3.a aVar = new zh3.a(di3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                di3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                di3Var.q(str4);
            }
            di3Var.b = "request";
            db3 q2 = cb3.K().q();
            if (q2 != null && q2.I()) {
                di3Var.c = q2.W().T();
                di3Var.d = q2.W().V();
            }
            di3Var.f = db3.g0();
            di3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                di3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + di3Var.f());
            }
            JSONObject f2 = di3Var.f();
            if (di3Var.o()) {
                d82.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                d82.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            kh3.k("834", f2);
            N(di3Var.m(), di3Var.n(), f2);
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

    public static void onEvent(gi3 gi3Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, gi3Var) == null) {
            ExtensionCore T2 = xh2.U().T();
            if (T2 != null) {
                gi3Var.a("extension_ver", T2.extensionCoreVersionName);
            }
            if (cb3.K().q().W().c("launch_by_reload")) {
                str = "1";
            } else {
                str = "0";
            }
            gi3Var.a("isReloadApp", str);
            JSONObject jSONObject = new JSONObject();
            do3.f(jSONObject, "static", Float.valueOf(ku2.m().a()));
            gi3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, gi3Var);
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
