package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.CoinClickDialog;
import com.baidu.swan.game.guide.view.GameGuideView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.tieba.hj3;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class jw3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;
    public static boolean b = false;
    public static long c = 0;
    public static GameGuideConfigInfo d = null;
    public static GameGuideView e = null;
    public static String f = "";
    public static String g = "";
    public static int h = 0;
    public static GameGuideViewContainer i = null;
    public static String j = null;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = true;
    public static jl3 n;
    public static final jw3 o;
    public transient /* synthetic */ FieldHolder $fh;

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements hj3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideConfigInfo a;

        public e(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideConfigInfo;
        }

        /* loaded from: classes6.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                jw3.o.c0(this.a.a);
            }
        }

        @Override // com.baidu.tieba.hj3.b
        public final void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    jw3.o.a0(false);
                    if (vm1.a) {
                        Log.e("GamenowPlaytimeManager", "下载导流view的图片失败， url = " + str);
                    }
                    gx3.n().d("fail", jw3.i(jw3.o), "下发配置中导流view的资源不可用");
                    return;
                }
                bitmap.setDensity(480);
                GameGuideConfigInfo.ViewInfo viewInfo = this.a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconNormalImg = bitmap;
                }
                k63 c0 = k63.c0();
                if (c0 == null) {
                    jw3.o.a0(false);
                    gx3.n().d("fail", jw3.i(jw3.o), "小游戏非法");
                    return;
                }
                SwanAppActivity w = c0.w();
                Intrinsics.checkNotNullExpressionValue(w, "swanApp.swanActivity");
                if (w.isDestroyed()) {
                    jw3.o.a0(false);
                    gx3.n().d("fail", jw3.i(jw3.o), "小游戏非法");
                    return;
                }
                jw3.o.a0(true);
                jw3.o.T(this.a);
                jw3.o.K();
                ek3.e0(new a(this));
                String b = jw3.b(jw3.o);
                if (b != null && !jw3.i(jw3.o) && this.a.expirationTime > 0) {
                    iw3.c().a(c0.P(), b, SystemClock.elapsedRealtime() + this.a.expirationTime);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            String string;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                if (bundle != null && (string = bundle.getString("type", "")) != null) {
                    switch (string.hashCode()) {
                        case -1261832223:
                            if (string.equals("addCoins")) {
                                jw3.h = jw3.g(jw3.o) + bundle.getInt("coinsNum", 0);
                                GameGuideConfigInfo z = jw3.o.z();
                                if (z != null) {
                                    int g = jw3.g(jw3.o);
                                    int i2 = z.maxNums;
                                    if (g > i2) {
                                        jw3 jw3Var = jw3.o;
                                        jw3.h = i2;
                                    }
                                }
                                jw3 jw3Var2 = jw3.o;
                                jw3Var2.S(jw3.g(jw3Var2));
                                break;
                            }
                            break;
                        case -977015124:
                            if (string.equals("setHasShowedTips")) {
                                jw3.o.X(true);
                                break;
                            }
                            break;
                        case -426887517:
                            if (string.equals("setPlayTime")) {
                                jw3.o.Z(bundle.getLong("playTime", 0L));
                                break;
                            }
                            break;
                        case -338307689:
                            if (string.equals("getPlayTime")) {
                                bundle2.putLong("playTime", jw3.d(jw3.o));
                                break;
                            }
                            break;
                        case 45198779:
                            if (string.equals("onGameTimeUsed")) {
                                jw3.o.d0();
                                break;
                            }
                            break;
                        case 142663368:
                            if (string.equals("initGameGuideInfo")) {
                                long F = jw3.o.F();
                                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                                    jw3 jw3Var3 = jw3.o;
                                    jw3.a = F;
                                }
                                int J = jw3.o.J();
                                GameGuideConfigInfo z2 = jw3.o.z();
                                if (z2 != null && J > (i = z2.maxNums)) {
                                    jw3.o.S(i);
                                    J = i;
                                }
                                jw3 jw3Var4 = jw3.o;
                                jw3.h = J;
                                break;
                            }
                            break;
                        case 854427704:
                            if (string.equals("getHasShowedTips")) {
                                bundle2.putBoolean("hasShowedTips", jw3.o.E());
                                break;
                            }
                            break;
                        case 1950665292:
                            if (string.equals("getCoins")) {
                                bundle2.putInt("coinsNum", jw3.g(jw3.o));
                                break;
                            }
                            break;
                    }
                }
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676102075, "Lcom/baidu/tieba/jw3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-676102075, "Lcom/baidu/tieba/jw3$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k63 c0 = k63.c0();
                if (c0 == null) {
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "非法小游戏");
                    }
                    gx3.n().a("小游戏非法");
                    jw3.o.a0(false);
                    return;
                }
                String cacheConfig = iw3.c().e(c0.P());
                if (TextUtils.isEmpty(cacheConfig)) {
                    gx3.n().d("start", jw3.i(jw3.o), "");
                    jw3.o.R();
                    return;
                }
                if (vm1.a) {
                    Log.d("GamenowPlaytimeManager", "展示缓存数据， 小游戏为  " + c0.a0());
                }
                jw3 jw3Var = jw3.o;
                jw3.k = true;
                gx3.n().d("start", jw3.i(jw3.o), "");
                jw3 jw3Var2 = jw3.o;
                Intrinsics.checkNotNullExpressionValue(cacheConfig, "cacheConfig");
                jw3Var2.O(cacheConfig);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<T> implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideConfigInfo a;

        public c(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideConfigInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                GameGuideConfigInfo.ViewInfo viewInfo = this.a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconDoneLottie = lottieComposition;
                }
                jw3.o.y(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d<T> implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676102013, "Lcom/baidu/tieba/jw3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-676102013, "Lcom/baidu/tieba/jw3$d;");
                    return;
                }
            }
            a = new d();
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                jw3.o.a0(false);
                gx3.n().d("fail", jw3.i(jw3.o), "下发配置中导流view的资源不可用");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (vm1.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("请求配置信息失败，err = ");
                    if (exc != null) {
                        str = exc.getMessage();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    Log.e("GamenowPlaytimeManager", sb.toString());
                }
                jw3.o.a0(false);
                gx3.n().d("fail", jw3.i(jw3.o), "网络请求失败");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (vm1.a) {
                        Log.e("GamenowPlaytimeManager", "配置信息下发异常，code = " + i + ",  response = " + str);
                    }
                    jw3.o.a0(false);
                    gx3.n().d("fail", jw3.i(jw3.o), "下发数据非法");
                    return;
                }
                if (vm1.a) {
                    Log.d("GamenowPlaytimeManager", "配置信息 =   " + str);
                }
                jw3.o.O(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676101920, "Lcom/baidu/tieba/jw3$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-676101920, "Lcom/baidu/tieba/jw3$g;");
                    return;
                }
            }
            a = new g();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            jw3.o.N();
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements jl3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jl3
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GameGuideView c = jw3.c(jw3.o);
                if (c != null) {
                    c.p();
                }
                ix3.f.k();
            }
        }

        @Override // com.baidu.tieba.jl3
        public void onViewDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            jw3.o.P();
        }

        @Override // com.baidu.tieba.jl3
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ix3.f.j();
                GameGuideView c = jw3.c(jw3.o);
                if (c != null) {
                    c.o(ix3.f.f());
                }
                xr2.V().c();
                if (jw3.o.C()) {
                    jw3.o.Q();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897667, "Lcom/baidu/tieba/jw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897667, "Lcom/baidu/tieba/jw3;");
                return;
            }
        }
        o = new jw3();
        n = new h();
    }

    public jw3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final GameGuideViewContainer B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return i;
        }
        return (GameGuideViewContainer) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = ye3.a().getBoolean("hasChoiceNotShow", false);
            l = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = ye3.a().getBoolean("hasInstallResult", true);
            m = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ye3.a().getBoolean("key_gt_ths", false);
        }
        return invokeV.booleanValue;
    }

    public final long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ye3.a().getLong("key_l_gt", 0L);
        }
        return invokeV.longValue;
    }

    public final String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return g;
        }
        return (String) invokeV.objValue;
    }

    public final String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return f;
        }
        return (String) invokeV.objValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ye3.a().getInt("coinsNum", 0);
        }
        return invokeV.intValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            e = null;
            i = null;
            k = false;
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            long j2 = a;
            if (j2 < 30000) {
                return;
            }
            long j3 = j2 % 30000;
            a = j3;
            Y(j3);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ej3.k(b.a, "thread_gamenowGuideInitAndCheck");
        }
    }

    public final GameGuideConfigInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return d;
        }
        return (GameGuideConfigInfo) invokeV.objValue;
    }

    public static final /* synthetic */ String b(jw3 jw3Var) {
        return j;
    }

    public static final /* synthetic */ GameGuideView c(jw3 jw3Var) {
        return e;
    }

    public static final /* synthetic */ long d(jw3 jw3Var) {
        return a;
    }

    public static final /* synthetic */ int g(jw3 jw3Var) {
        return h;
    }

    public static final /* synthetic */ boolean i(jw3 jw3Var) {
        return k;
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            ye3.a().putInt("coinsNum", i2);
        }
    }

    public final void T(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gameGuideConfigInfo) == null) {
            d = gameGuideConfigInfo;
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            l = z;
            ye3.a().putBoolean("hasChoiceNotShow", z);
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            m = z;
            ye3.a().putBoolean("hasInstallResult", z);
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            ye3.a().putBoolean("key_gt_ths", z);
        }
    }

    public final void Y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            ye3.a().putLong("key_l_gt", j2);
        }
    }

    public final void Z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            if (j2 < 0) {
                if (vm1.a) {
                    Log.d("GamenowPlaytimeManager", "游戏时长不能为负数");
                    return;
                }
                return;
            }
            if (j2 > SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                j2 = 90000;
            }
            a = j2;
            Y(j2);
        }
    }

    public final void x(GameGuideConfigInfo gameGuideConfigInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, gameGuideConfigInfo) == null) {
            Context appContext = AppRuntime.getAppContext();
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            if (viewInfo != null) {
                str = viewInfo.iconDoneUrl;
            } else {
                str = null;
            }
            LottieCompositionFactory.fromUrl(appContext, str).addListener(new c(gameGuideConfigInfo)).addFailureListener(d.a);
        }
    }

    public final void y(GameGuideConfigInfo gameGuideConfigInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gameGuideConfigInfo) == null) {
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            if (viewInfo != null) {
                str = viewInfo.iconNormalUrl;
            } else {
                str = null;
            }
            hj3.e(str, new e(gameGuideConfigInfo));
        }
    }

    public final long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return a;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getPlayTime");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (!callOnMainWithContentProvider.isOk()) {
                return 0L;
            }
            return callOnMainWithContentProvider.mResult.getLong("playTime", 0L);
        }
        return invokeV.longValue;
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getCoins");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (!callOnMainWithContentProvider.isOk()) {
                return 0;
            }
            return callOnMainWithContentProvider.mResult.getInt("coinsNum", 0);
        }
        return invokeV.intValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                d0();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "onGameTimeUsed");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final void Q() {
        GameGuideViewContainer gameGuideViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (gameGuideViewContainer = i) != null) {
            xr2 V = xr2.V();
            Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
            V.Y().f(n);
            xr2 V2 = xr2.V();
            Intrinsics.checkNotNullExpressionValue(V2, "SwanAppController.getInstance()");
            co1 Y = V2.Y();
            Intrinsics.checkNotNullExpressionValue(Y, "SwanAppController.getIns…swanGameNARootViewManager");
            FrameLayout rootView = Y.getRootView();
            if (rootView != null) {
                rootView.removeView(gameGuideViewContainer);
            }
            o.P();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || b) {
            return;
        }
        b = true;
        if (ProcessUtils.isMainProcess()) {
            X(true);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "setHasShowedTips");
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void K() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                long F = F();
                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                    a = F;
                }
                int J = J();
                GameGuideConfigInfo gameGuideConfigInfo = d;
                if (gameGuideConfigInfo != null && J > (i2 = gameGuideConfigInfo.maxNums)) {
                    o.S(i2);
                    J = i2;
                }
                h = J;
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "initGameGuideInfo");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (b) {
                return true;
            }
            if (ProcessUtils.isMainProcess()) {
                boolean E = E();
                b = E;
                return E;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getHasShowedTips");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (!callOnMainWithContentProvider.isOk()) {
                return false;
            }
            boolean z = callOnMainWithContentProvider.mResult.getBoolean("hasShowedTips", false);
            b = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        GameGuideConfigInfo gameGuideConfigInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (gameGuideConfigInfo = d) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c < 500) {
                if (vm1.a) {
                    Log.d("GamenowPlaytimeManager", "快速点击");
                    return;
                }
                return;
            }
            k63 c0 = k63.c0();
            if (c0 != null) {
                c = currentTimeMillis;
                long f2 = ix3.f.f() / 30000;
                if (f2 <= 0) {
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "时长没有满足一个豆以上");
                    }
                } else if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "没有网络");
                    }
                    c63.g(AppRuntime.getAppContext(), "网络异常，请稍后重试").G();
                } else {
                    int i2 = (int) f2;
                    gx3.n().i(i2);
                    int i3 = gameGuideConfigInfo.perCoinNum * i2;
                    int G = G();
                    if (G >= gameGuideConfigInfo.maxNums) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "before    expectedRewardCoins = " + i3 + " , currentRewardCoinsNum = " + G + ",  isMax = " + z);
                    }
                    int i4 = i3 + G;
                    int i5 = gameGuideConfigInfo.maxNums;
                    if (i4 > i5) {
                        i3 = i5 - G;
                    }
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "after    realRewardCoins = " + i3);
                    }
                    if (!z) {
                        ix3.f.h();
                        GameGuideView gameGuideView = e;
                        if (gameGuideView != null) {
                            gameGuideView.r();
                        }
                        v(i3);
                    }
                    xr2.V().q();
                    Intent intent = new Intent(c0.w(), CoinClickDialog.class);
                    intent.putExtra("isShowMax", z);
                    intent.putExtra("rewardCoinsThisTime", i3);
                    intent.putExtra("totalRewardCoins", G + i3);
                    c0.w().startActivity(intent);
                }
            }
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (vm1.a) {
                        Log.e("GamenowPlaytimeManager", "返回结果异常，errNo = " + optInt + "， response = " + str);
                    }
                    gx3.n().d("fail", k, "下发数据非法");
                    return;
                }
                GameGuideConfigInfo parseData = GameGuideConfigInfo.parseData(jSONObject.optJSONObject("data"));
                if (parseData == null) {
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "配置信息下发异常");
                    }
                    gx3.n().d("fail", k, "下发数据非法");
                    return;
                }
                W(parseData.install_result);
                String str2 = parseData.targetAppPackageId;
                Intrinsics.checkNotNullExpressionValue(str2, "configInfo.targetAppPackageId");
                f = str2;
                String str3 = parseData.targetAppDownloadUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "configInfo.targetAppDownloadUrl");
                g = str3;
                if (parseData.status == 0) {
                    if (vm1.a) {
                        Log.d("GamenowPlaytimeManager", "下发数据 status = 0，不展示");
                    }
                    k63 c0 = k63.c0();
                    if (!k && parseData.expirationTime > 0 && c0 != null) {
                        iw3.c().a(c0.P(), str, SystemClock.elapsedRealtime() + parseData.expirationTime);
                    }
                    gx3.n().d("fail", k, "配置下发不展示");
                    return;
                }
                j = str;
                if (parseData.popupSelection == 2) {
                    d = parseData;
                } else if (C()) {
                    gx3.n().a("hasClosedWithNotShow");
                    d = parseData;
                } else {
                    x(parseData);
                }
                gx3.n().d("success", k, "");
            } catch (Throwable th) {
                if (vm1.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("解析配置信息失败，err = ");
                    th.printStackTrace();
                    sb.append(Unit.INSTANCE);
                    Log.e("GamenowPlaytimeManager", sb.toString());
                }
                gx3.n().d("fail", k, "下发数据非法");
            }
        }
    }

    public final void c0(GameGuideConfigInfo gameGuideConfigInfo) {
        GameGuideConfigInfo.ViewInfo viewInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, gameGuideConfigInfo) == null) && (viewInfo = gameGuideConfigInfo.viewInfo) != null) {
            gx3.n().l();
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
            Resources resources = appContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f2) + resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070176) + bk3.g(10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
            k63 c0 = k63.c0();
            if (c0 != null) {
                i = new GameGuideViewContainer(rp2.c());
                int e2 = tj3.e(c0.w());
                if (tj3.d()) {
                    layoutParams.topMargin = dimensionPixelSize + e2;
                } else {
                    layoutParams.topMargin = dimensionPixelSize;
                }
                xr2 V = xr2.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                co1 Y = V.Y();
                Intrinsics.checkNotNullExpressionValue(Y, "SwanAppController.getIns…swanGameNARootViewManager");
                Y.getRootView().addView(i, layoutParams);
                Context appContext2 = AppRuntime.getAppContext();
                Intrinsics.checkNotNullExpressionValue(appContext2, "AppRuntime.getAppContext()");
                LottieComposition lottieComposition = viewInfo.iconDoneLottie;
                Intrinsics.checkNotNullExpressionValue(lottieComposition, "it.iconDoneLottie");
                Bitmap bitmap = viewInfo.iconNormalImg;
                Intrinsics.checkNotNullExpressionValue(bitmap, "it.iconNormalImg");
                String str = viewInfo.progressColor;
                Intrinsics.checkNotNullExpressionValue(str, "it.progressColor");
                String str2 = viewInfo.tips;
                Intrinsics.checkNotNullExpressionValue(str2, "it.tips");
                GameGuideView gameGuideView = new GameGuideView(appContext2, lottieComposition, bitmap, str, str2);
                e = gameGuideView;
                GameGuideViewContainer gameGuideViewContainer = i;
                if (gameGuideViewContainer != null) {
                    gameGuideViewContainer.addView(gameGuideView);
                }
                xr2 V2 = xr2.V();
                Intrinsics.checkNotNullExpressionValue(V2, "SwanAppController.getInstance()");
                V2.Y().e(n);
                GameGuideView gameGuideView2 = e;
                if (gameGuideView2 != null) {
                    gameGuideView2.setOnClickListener(g.a);
                }
                if (!ix3.f.g()) {
                    ix3.f.j();
                    GameGuideView gameGuideView3 = e;
                    if (gameGuideView3 != null) {
                        gameGuideView3.o(ix3.f.f());
                    }
                }
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            k63 M = k63.M();
            if (M == null) {
                gx3.n().d("fail", k, "小游戏非法");
                return;
            }
            String i2 = rp2.h0().i(AppRuntime.getAppContext());
            if (i2 == null) {
                i2 = "";
            }
            String h2 = pf3.h(1);
            mb3 a2 = rp2.q().a();
            Application c2 = rp2.c();
            Intrinsics.checkNotNullExpressionValue(c2, "SwanAppRuntime.getAppContext()");
            hr2.a X = M.X();
            Intrinsics.checkNotNullExpressionValue(X, "swanApp.info");
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) M.j0().postFormRequest().url("https://gamecenter.baidu.com/api/minigame/get_flowout_config")).cookieManager(a2)).addParam("cuid", i2).addParam("appkey", M.P()).addParam("host", c2.getPackageName()).addParam("from", X.U()).addParam("gamecore_version", h2).requestFrom(16)).requestSubFrom(1602)).build().executeAsync(new f());
        }
    }

    public final void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            if (ProcessUtils.isMainProcess()) {
                Z(j2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "setPlayTime");
            bundle.putLong("playTime", j2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    public final void v(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (ProcessUtils.isMainProcess()) {
                int i4 = h + i2;
                h = i4;
                GameGuideConfigInfo gameGuideConfigInfo = d;
                if (gameGuideConfigInfo != null && i4 > (i3 = gameGuideConfigInfo.maxNums)) {
                    h = i3;
                }
                S(h);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "addCoins");
            bundle.putInt("coinsNum", i2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }
}
