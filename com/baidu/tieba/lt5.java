package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.ta5;
import com.baidu.tieba.ur5;
import com.baidu.tieba.vx6;
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
/* loaded from: classes5.dex */
public class lt5 implements cu5 {
    public static /* synthetic */ Interceptable $ic;
    public static String m;
    public static volatile boolean n;
    public static volatile vx6.h o;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ViewGroup> b;
    public ViewGroup c;
    public FrameLayout d;
    public ViewGroup e;
    public AdLoadState f;
    public np4 g;
    public ViewGroup.OnHierarchyChangeListener h;
    public boolean i;
    public long j;
    public final SplashNativePolicy k;
    public final vx6.i l;

    @Override // com.baidu.tieba.cu5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cu5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class e implements vx6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt5 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ int b;

            public a(e eVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, str, Integer.valueOf(i)};
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && lt5.o != null) {
                    lt5.o.a(this.a, this.b);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public b(e eVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, str};
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && lt5.o != null) {
                    lt5.o.onError(this.a);
                }
            }
        }

        public e(lt5 lt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt5Var;
        }

        @Override // com.baidu.tieba.vx6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (lt5.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i));
                    ur5.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (yi.E()) {
                    lt5.o.a(str, i);
                } else {
                    ah.a().post(new a(this, str, i));
                }
            }
        }

        @Override // com.baidu.tieba.vx6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (lt5.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    ur5.c().a(this.a.f(), "onError", hashMap);
                } else if (yi.E()) {
                    lt5.o.onError(str);
                } else {
                    ah.a().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends vx6.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt5 a;

        public a(lt5 lt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt5Var;
        }

        @Override // com.baidu.tieba.vx6.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (cu5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.e(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.tieba.vx6.i
        public void onAdClose(String str) {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
                if (cu5.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // com.baidu.tieba.vx6.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (cu5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                hu5.l(hu5.c, "1", null, null, str, null, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.vx6.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                if (cu5.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                int i = 0;
                this.a.g.g(false, false, 6);
                hu5.l(hu5.c, "0", null, str2, str, str3, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.g != null) {
                    i = this.a.g.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ta5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(lt5 lt5Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var, context};
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

        @Override // com.baidu.tieba.ta5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0811, (ViewGroup) null, false);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements vx6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt5 a;

        public c(lt5 lt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt5Var;
        }

        @Override // com.baidu.tieba.vx6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (cu5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.f(hu5.c, true);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (vx6.m().v(str)) {
                    this.a.f = AdLoadState.SUCCEED;
                    hu5.k(hu5.c, "0", null, null, 0, i, this.a.i, this.a.j);
                } else {
                    this.a.f = AdLoadState.FAILED;
                    hu5.k(hu5.c, "1", str, null, 2, i, this.a.i, this.a.j);
                    this.a.w();
                }
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                gu5.e(this.a.j);
            }
        }

        @Override // com.baidu.tieba.vx6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (cu5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                if (this.a.f == AdLoadState.FORCESHOW) {
                    return;
                }
                if (this.a.g != null) {
                    this.a.g.f(hu5.c, false);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                hu5.k(hu5.c, "1", str, null, 1, 0, this.a.i, this.a.j);
                this.a.f = AdLoadState.FAILED;
                this.a.w();
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt5 a;

        public d(lt5 lt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((ViewGroup) this.a.b.get()).removeView(this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt5 a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
            }
        }

        public f(lt5 lt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt5Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947954428, "Lcom/baidu/tieba/lt5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947954428, "Lcom/baidu/tieba/lt5;");
                return;
            }
        }
        m = vx6.p();
        n = false;
    }

    @Override // com.baidu.tieba.cu5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = this.d;
            if (frameLayout != null && frameLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cu5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cu5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            vx6.m().d(m);
            o = null;
        }
    }

    @Override // com.baidu.tieba.cu5
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null || this.f != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.f = AdLoadState.SHOWED;
        y();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.b != null && v() && this.f != AdLoadState.FORCESHOW) {
            s();
            this.f = AdLoadState.FORCESHOW;
            y();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return vx6.m().v(m);
        }
        return invokeV.booleanValue;
    }

    public lt5(SplashNativePolicy splashNativePolicy) {
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
        this.l = new a(this);
        this.k = splashNativePolicy;
        if (ry4.l().m("splash_bear_sid_type_key", 0) == 1) {
            p = vx6.q();
        } else {
            p = vx6.p();
        }
        m = p;
    }

    public static void x(int i) {
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            if (i == 1) {
                p = vx6.q();
            } else {
                p = vx6.p();
            }
            m = p;
            ry4.l().x("splash_bear_sid_type_key", i);
        }
    }

    @Override // com.baidu.tieba.cu5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            e eVar = new e(this);
            vx6.m().w(context, m, (int) (yi.j(context) * 0.85d), eVar, vx6.b("spalsh", bu5.d().c() + ""));
            n = true;
        }
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (weakReference = this.b) != null && weakReference.get().getParent() != null) {
            ViewGroup.LayoutParams layoutParams = this.b.get().getLayoutParams();
            layoutParams.width = yi.l(this.b.get().getContext());
            layoutParams.height = (int) (yi.j(this.b.get().getContext()) * 0.85d);
            this.b.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.cu5
    public void e(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qp4Var) == null) {
            Context context = qp4Var.b().getContext();
            if ((context instanceof Activity) && qp4Var.b() != null) {
                this.i = qp4Var.d();
                this.j = qp4Var.c();
                this.b = new WeakReference<>(qp4Var.b());
                ViewGroup viewGroup = (ViewGroup) ta5.e().d(1007, new b(this, context));
                this.c = viewGroup;
                if (viewGroup == null) {
                    return;
                }
                this.d = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091ffc);
                r();
                this.g = qp4Var.a();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.l(context), (int) (yi.j(this.b.get().getContext()) * 0.85d));
                layoutParams.addRule(14, -1);
                this.b.get().addView(this.c, layoutParams);
                if (cu5.a) {
                    System.out.println("IAdSdkSplash BEAR ad start load");
                }
                o = new c(this);
                if (n) {
                    u();
                    n = false;
                } else {
                    vx6 m2 = vx6.m();
                    Activity activity = (Activity) context;
                    String str = m;
                    int j = (int) (yi.j(context) * 0.85d);
                    vx6.h hVar = o;
                    m2.w(activity, str, j, hVar, vx6.b("spalsh", bu5.d().c() + ""));
                }
                if (this.f == AdLoadState.INIT) {
                    this.f = AdLoadState.LOADING;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f091ffb);
            this.e = viewGroup;
            rw4 d2 = rw4.d(this.e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            rw4 d3 = rw4.d((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091ffe));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091ffd), R.drawable.obfuscated_res_0x7f08099d, R.color.CAM_X0201, null);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && o != null && !ur5.c().d(f()).isEmpty()) {
            for (ur5.a aVar : ur5.c().d(f())) {
                String str = aVar.a;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1349867671) {
                    if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                        c2 = 0;
                    }
                } else if (str.equals("onError")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        o.onError((String) aVar.b.get("sid"));
                    }
                } else {
                    o.a((String) aVar.b.get("sid"), ((Integer) aVar.b.get("loadSize")).intValue());
                }
            }
            ur5.c().b(f());
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.c != null && this.d != null) {
                if (this.h == null) {
                    this.h = new f(this);
                }
                this.d.setOnHierarchyChangeListener(this.h);
                if (this.b.get() != null) {
                    Context context = this.b.get().getContext();
                    if (context instanceof Activity) {
                        gy4.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (cu5.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + m);
                        }
                        vx6.m().G((Activity) context, m, this.d, this.l, vx6.b("spalsh", bu5.d().c() + ""));
                        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (weakReference = this.b) != null && weakReference.get() != null) {
            if (yi.E()) {
                this.b.get().removeView(this.c);
            } else {
                ah.a().post(new d(this));
            }
        }
    }
}
