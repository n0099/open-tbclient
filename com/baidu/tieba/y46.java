package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdDestroySwitch;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.kk5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.q88;
import com.baidu.tieba.s26;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes9.dex */
public class y46 implements q56 {
    public static /* synthetic */ Interceptable $ic;
    public static String s;
    public static volatile boolean t;
    public static volatile q88.g u;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ViewGroup> b;
    public ViewGroup c;
    public FrameLayout d;
    public ViewGroup e;
    public AdLoadState f;
    public nr4 g;
    public ViewGroup.OnHierarchyChangeListener h;
    public boolean i;
    public long j;
    public final SplashNativePolicy k;
    public final Handler l;
    public final FunAdDestroySwitch m;
    public boolean n;
    public final a66 o;
    public MutableContextWrapper p;
    public final Runnable q;
    public final q88.h r;

    @Override // com.baidu.tieba.q56
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q56
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class f implements q88.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ int b;

            public a(f fVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str, Integer.valueOf(i)};
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
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && y46.u != null) {
                    y46.u.a(this.a, this.b);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public b(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
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
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && y46.u != null) {
                    y46.u.onError(this.a);
                }
            }
        }

        public f(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // com.baidu.tieba.q88.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (y46.u == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i));
                    s26.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (BdUtilHelper.isMainThread()) {
                    y46.u.a(str, i);
                } else {
                    SafeHandler.getInst().post(new a(this, str, i));
                }
            }
        }

        @Override // com.baidu.tieba.q88.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (y46.u == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    s26.c().a(this.a.f(), GameAssistConstKt.TYPE_CALLBACK_ERROR, hashMap);
                } else if (BdUtilHelper.isMainThread()) {
                    y46.u.onError(str);
                } else {
                    SafeHandler.getInst().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        public a(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.g != null) {
                if (this.a.d.getChildCount() > 0) {
                    this.a.l.postDelayed(this.a.q, 1000L);
                    return;
                }
                this.a.l.removeCallbacks(this.a.q);
                this.a.g.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends q88.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        public b(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // com.baidu.tieba.q88.h
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (q56.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.e(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.tieba.q88.h
        public void onAdClose(String str) {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                int i = 1;
                this.a.n = true;
                this.a.o.e(1);
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.q);
                }
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.g != null) {
                    this.a.g.f();
                }
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1);
                if (this.a.g == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.g.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 6).param("obj_type", "a064").param("obj_param1", 4).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.i) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.j).eventStat();
                if (q56.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // com.baidu.tieba.q88.h
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.q);
                }
                if (q56.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                z56.i(z56.c, "1", null, null, str, null, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.f();
                }
            }
        }

        @Override // com.baidu.tieba.q88.h
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.a.o.f(1);
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.q);
                }
                if (q56.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                int i = 0;
                this.a.g.h(false, false, 6);
                z56.i(z56.c, "0", null, str2, str, str3, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.g != null) {
                    i = this.a.g.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
                if (this.a.m.isOn()) {
                    this.a.l.postDelayed(this.a.q, 1000L);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements kk5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(y46 y46Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.kk5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0918, (ViewGroup) null, false);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements q88.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        public d(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // com.baidu.tieba.q88.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (q56.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.g(z56.c, true);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (q88.m().v(str)) {
                    this.a.f = AdLoadState.SUCCEED;
                    z56.h(z56.c, "0", null, null, 0, i, this.a.i, this.a.j);
                } else {
                    this.a.f = AdLoadState.FAILED;
                    z56.h(z56.c, "1", str, null, 2, i, this.a.i, this.a.j);
                    this.a.E();
                }
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                y56.e(this.a.j);
            }
        }

        @Override // com.baidu.tieba.q88.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (q56.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.g(z56.c, false);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                z56.h(z56.c, "1", str, null, 1, 0, this.a.i, this.a.j);
                this.a.f = AdLoadState.FAILED;
                this.a.E();
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        public e(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((ViewGroup) this.a.b.get()).removeView(this.a.c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
            }
        }

        public g(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) && this.a.e != null && this.a.e.getVisibility() != 0) {
                this.a.e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y46 a;

        public h(y46 y46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：小熊广告 BearAdSdkSplash，adTimeoutTask，isAdClosed is：" + this.a.n + " ，mAdCallBack is：" + this.a.g);
                if (!this.a.n && this.a.g != null) {
                    this.a.g.f();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280238, "Lcom/baidu/tieba/y46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280238, "Lcom/baidu/tieba/y46;");
                return;
            }
        }
        s = q88.p();
        t = false;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return q88.m().v(s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q56
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrameLayout frameLayout = this.d;
            if (frameLayout != null && frameLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q56
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q56
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            q88.m().d(s);
            u = null;
        }
    }

    @Override // com.baidu.tieba.q56
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.b == null || this.f != AdLoadState.SUCCEED) {
            return;
        }
        A();
        this.f = AdLoadState.SHOWED;
        DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：show, showAdIfNeed");
        G();
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.o.b(new h(this), 1);
        }
    }

    public y46(SplashNativePolicy splashNativePolicy) {
        String p;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = AdLoadState.INIT;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = -1L;
        this.l = new Handler(Looper.getMainLooper());
        this.m = new FunAdDestroySwitch();
        this.n = false;
        this.o = new a66();
        this.q = new a(this);
        this.r = new b(this);
        this.k = splashNativePolicy;
        if (SharedPrefHelper.getInstance().getInt("splash_bear_sid_type_key", 0) == 1) {
            p = q88.q();
        } else {
            p = q88.p();
        }
        s = p;
    }

    public static void F(int i) {
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (i == 1) {
                p = q88.q();
            } else {
                p = q88.p();
            }
            s = p;
            SharedPrefHelper.getInstance().putInt("splash_bear_sid_type_key", i);
        }
    }

    public final void A() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (weakReference = this.b) != null && weakReference.get().getParent() != null) {
            ViewGroup.LayoutParams layoutParams = this.b.get().getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.b.get().getContext());
            layoutParams.height = (int) (BdUtilHelper.getEquipmentHeight(this.b.get().getContext()) * 0.85d);
            this.b.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.q56
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            if (this.p == null) {
                this.p = new MutableContextWrapper(context);
            }
            q88 m = q88.m();
            MutableContextWrapper mutableContextWrapper = this.p;
            String str = s;
            int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.85d);
            f fVar = new f(this);
            m.w(mutableContextWrapper, str, equipmentHeight, fVar, q88.b("spalsh", p56.d().c() + ""));
            t = true;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != null && D() && this.f != AdLoadState.FORCESHOW) {
            A();
            this.f = AdLoadState.FORCESHOW;
            DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：forceShow, showAdIfNeed");
            G();
        }
    }

    public final void E() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (weakReference = this.b) != null && weakReference.get() != null) {
            if (BdUtilHelper.isMainThread()) {
                this.b.get().removeView(this.c);
            } else {
                SafeHandler.getInst().post(new e(this));
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && u != null && !s26.c().d(f()).isEmpty()) {
            for (s26.a aVar : s26.c().d(f())) {
                String str = aVar.a;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1349867671) {
                    if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                        c2 = 0;
                    }
                } else if (str.equals(GameAssistConstKt.TYPE_CALLBACK_ERROR)) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        u.onError((String) aVar.b.get("sid"));
                    }
                } else {
                    u.a((String) aVar.b.get("sid"), ((Integer) aVar.b.get("loadSize")).intValue());
                }
            }
            s26.c().b(f());
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：showAdIfNeed，显示小熊广告");
            if (this.c != null && this.d != null) {
                if (this.h == null) {
                    this.h = new g(this);
                }
                this.d.setOnHierarchyChangeListener(this.h);
                if (this.b.get() != null) {
                    Context context = this.b.get().getContext();
                    if (context instanceof Activity) {
                        Logger.addLog("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (q56.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + s);
                        }
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("IAdSdkSplash", "开屏广告：小熊广告 showAdIfNeed, showSplash， splashSid is：" + s);
                        q88.m().F((Activity) context, s, this.d, this.r, q88.b("spalsh", p56.d().c() + ""));
                        y();
                        DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：show，小熊广告开始展示");
                        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q56
    public void e(qr4 qr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qr4Var) == null) {
            Context context = qr4Var.b().getContext();
            if ((context instanceof Activity) && qr4Var.b() != null) {
                this.i = qr4Var.d();
                this.j = qr4Var.c();
                this.b = new WeakReference<>(qr4Var.b());
                ViewGroup viewGroup = (ViewGroup) kk5.e().d(1007, new c(this, context));
                this.c = viewGroup;
                if (viewGroup == null) {
                    return;
                }
                this.d = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f092360);
                z();
                this.g = qr4Var.a();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getEquipmentWidth(context), (int) (BdUtilHelper.getEquipmentHeight(this.b.get().getContext()) * 0.85d));
                layoutParams.addRule(14, -1);
                this.b.get().addView(this.c, layoutParams);
                if (q56.a) {
                    System.out.println("IAdSdkSplash BEAR ad start load");
                }
                u = new d(this);
                MutableContextWrapper mutableContextWrapper = this.p;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(context);
                }
                if (t) {
                    C();
                    t = false;
                } else {
                    q88 m = q88.m();
                    Activity activity = (Activity) context;
                    String str = s;
                    int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.85d);
                    q88.g gVar = u;
                    m.w(activity, str, equipmentHeight, gVar, q88.b("spalsh", p56.d().c() + ""));
                }
                if (this.f == AdLoadState.INIT) {
                    this.f = AdLoadState.LOADING;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f09235f);
            this.e = viewGroup;
            EMManager.from(this.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0608);
            EMManager.from((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092362)).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f092361), R.drawable.obfuscated_res_0x7f080b7f, R.color.CAM_X0201, null);
        }
    }
}
