package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tieba.dv7;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.p46;
import com.baidu.tieba.tm5;
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
/* loaded from: classes6.dex */
public class j66 implements a76 {
    public static /* synthetic */ Interceptable $ic;
    public static String p;
    public static volatile boolean q;
    public static volatile dv7.g r;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ViewGroup> b;
    public ViewGroup c;
    public FrameLayout d;
    public ViewGroup e;
    public AdLoadState f;
    public fw4 g;
    public ViewGroup.OnHierarchyChangeListener h;
    public boolean i;
    public long j;
    public final SplashNativePolicy k;
    public final Handler l;
    public final FunAdDestroySwitch m;
    public final Runnable n;
    public final dv7.h o;

    @Override // com.baidu.tieba.a76
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a76
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class f implements dv7.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j66.r != null) {
                    j66.r.a(this.a, this.b);
                }
            }
        }

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j66.r != null) {
                    j66.r.onError(this.a);
                }
            }
        }

        public f(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // com.baidu.tieba.dv7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (j66.r == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i));
                    p46.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (BdUtilHelper.isMainThread()) {
                    j66.r.a(str, i);
                } else {
                    SafeHandler.getInst().post(new a(this, str, i));
                }
            }
        }

        @Override // com.baidu.tieba.dv7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (j66.r == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    p46.c().a(this.a.f(), GameAssistConstKt.TYPE_CALLBACK_ERROR, hashMap);
                } else if (BdUtilHelper.isMainThread()) {
                    j66.r.onError(str);
                } else {
                    SafeHandler.getInst().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        public a(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.g != null) {
                if (this.a.d.getChildCount() > 0) {
                    this.a.l.postDelayed(this.a.n, 1000L);
                    return;
                }
                this.a.l.removeCallbacks(this.a.n);
                this.a.g.onAdDismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends dv7.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        public b(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (a76.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.e(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdClose(String str) {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.n);
                }
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.g != null) {
                    this.a.g.onAdDismiss();
                }
                int i = 1;
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
                if (a76.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.n);
                }
                if (a76.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                g76.i(g76.c, "1", null, null, str, null, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                if (this.a.m.isOn()) {
                    this.a.l.removeCallbacks(this.a.n);
                }
                if (a76.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                int i = 0;
                this.a.g.g(false, false, 6);
                g76.i(g76.c, "0", null, str2, str, str3, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.g != null) {
                    i = this.a.g.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
                if (this.a.m.isOn()) {
                    this.a.l.postDelayed(this.a.n, 1000L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements tm5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(j66 j66Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var, context};
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

        @Override // com.baidu.tieba.tm5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08dc, (ViewGroup) null, false);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dv7.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        public d(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // com.baidu.tieba.dv7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (a76.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.f(g76.c, true);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (dv7.m().v(str)) {
                    this.a.f = AdLoadState.SUCCEED;
                    g76.h(g76.c, "0", null, null, 0, i, this.a.i, this.a.j);
                } else {
                    this.a.f = AdLoadState.FAILED;
                    g76.h(g76.c, "1", str, null, 2, i, this.a.i, this.a.j);
                    this.a.A();
                }
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                f76.e(this.a.j);
            }
        }

        @Override // com.baidu.tieba.dv7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (a76.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.f(g76.c, false);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                g76.h(g76.c, "1", str, null, 1, 0, this.a.i, this.a.j);
                this.a.f = AdLoadState.FAILED;
                this.a.A();
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        public e(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((ViewGroup) this.a.b.get()).removeView(this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j66 a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
            }
        }

        public g(j66 j66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j66Var;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) && this.a.e != null && this.a.e.getVisibility() != 0) {
                this.a.e.setVisibility(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835295, "Lcom/baidu/tieba/j66;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835295, "Lcom/baidu/tieba/j66;");
                return;
            }
        }
        p = dv7.p();
        q = false;
    }

    @Override // com.baidu.tieba.a76
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrameLayout frameLayout = this.d;
            if (frameLayout != null && frameLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a76
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a76
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            dv7.m().d(p);
            r = null;
        }
    }

    @Override // com.baidu.tieba.a76
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null || this.f != AdLoadState.SUCCEED) {
            return;
        }
        w();
        this.f = AdLoadState.SHOWED;
        C();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b != null && z() && this.f != AdLoadState.FORCESHOW) {
            w();
            this.f = AdLoadState.FORCESHOW;
            C();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return dv7.m().v(p);
        }
        return invokeV.booleanValue;
    }

    public j66(SplashNativePolicy splashNativePolicy) {
        String p2;
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
        this.n = new a(this);
        this.o = new b(this);
        this.k = splashNativePolicy;
        if (SharedPrefHelper.getInstance().getInt("splash_bear_sid_type_key", 0) == 1) {
            p2 = dv7.q();
        } else {
            p2 = dv7.p();
        }
        p = p2;
    }

    public static void B(int i) {
        String p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (i == 1) {
                p2 = dv7.q();
            } else {
                p2 = dv7.p();
            }
            p = p2;
            SharedPrefHelper.getInstance().putInt("splash_bear_sid_type_key", i);
        }
    }

    public final void A() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (weakReference = this.b) != null && weakReference.get() != null) {
            if (BdUtilHelper.isMainThread()) {
                this.b.get().removeView(this.c);
            } else {
                SafeHandler.getInst().post(new e(this));
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c != null && this.d != null) {
                if (this.h == null) {
                    this.h = new g(this);
                }
                this.d.setOnHierarchyChangeListener(this.h);
                if (this.b.get() != null) {
                    Context context = this.b.get().getContext();
                    if (context instanceof Activity) {
                        Logger.addLog("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (a76.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + p);
                        }
                        dv7.m().F((Activity) context, p, this.d, this.o, dv7.b("spalsh", z66.d().c() + ""));
                        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && r != null && !p46.c().d(f()).isEmpty()) {
            for (p46.a aVar : p46.c().d(f())) {
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
                        r.onError((String) aVar.b.get("sid"));
                    }
                } else {
                    r.a((String) aVar.b.get("sid"), ((Integer) aVar.b.get("loadSize")).intValue());
                }
            }
            p46.c().b(f());
        }
    }

    @Override // com.baidu.tieba.a76
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            f fVar = new f(this);
            dv7.m().w(context, p, (int) (BdUtilHelper.getEquipmentHeight(context) * 0.85d), fVar, dv7.b("spalsh", z66.d().c() + ""));
            q = true;
        }
    }

    public final void w() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (weakReference = this.b) != null && weakReference.get().getParent() != null) {
            ViewGroup.LayoutParams layoutParams = this.b.get().getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.b.get().getContext());
            layoutParams.height = (int) (BdUtilHelper.getEquipmentHeight(this.b.get().getContext()) * 0.85d);
            this.b.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.a76
    public void e(iw4 iw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iw4Var) == null) {
            Context context = iw4Var.b().getContext();
            if ((context instanceof Activity) && iw4Var.b() != null) {
                this.i = iw4Var.d();
                this.j = iw4Var.c();
                this.b = new WeakReference<>(iw4Var.b());
                ViewGroup viewGroup = (ViewGroup) tm5.e().d(1007, new c(this, context));
                this.c = viewGroup;
                if (viewGroup == null) {
                    return;
                }
                this.d = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f092258);
                v();
                this.g = iw4Var.a();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getEquipmentWidth(context), (int) (BdUtilHelper.getEquipmentHeight(this.b.get().getContext()) * 0.85d));
                layoutParams.addRule(14, -1);
                this.b.get().addView(this.c, layoutParams);
                if (a76.a) {
                    System.out.println("IAdSdkSplash BEAR ad start load");
                }
                r = new d(this);
                if (q) {
                    y();
                    q = false;
                } else {
                    dv7 m = dv7.m();
                    Activity activity = (Activity) context;
                    String str = p;
                    int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.85d);
                    dv7.g gVar = r;
                    m.w(activity, str, equipmentHeight, gVar, dv7.b("spalsh", z66.d().c() + ""));
                }
                if (this.f == AdLoadState.INIT) {
                    this.f = AdLoadState.LOADING;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f092257);
            this.e = viewGroup;
            EMManager.from(this.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0608);
            EMManager.from((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09225a)).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f092259), R.drawable.obfuscated_res_0x7f080b4a, R.color.CAM_X0201, null);
        }
    }
}
