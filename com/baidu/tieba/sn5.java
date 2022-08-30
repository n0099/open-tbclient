package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.jd1;
import com.baidu.tieba.km5;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sn5 implements ho5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mb1 l;
    public static volatile boolean m;
    public static volatile hb1 n;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public gm4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;

    /* loaded from: classes5.dex */
    public class a implements hb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn5 a;

        public a(sn5 sn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn5Var;
        }

        @Override // com.baidu.tieba.hb1
        public void a() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (sn5.l == null || sn5.l.b() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = sn5.l.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = sn5.l.b().optInt("full_type", 0) == 1;
                    }
                    gm4 gm4Var = this.a.e;
                    sn5 sn5Var = this.a;
                    gm4Var.e(z, z2, sn5Var.b, null, be5.m(sn5Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.hb1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                mo5.k(mo5.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                mo5.l(mo5.b, "1", str, null, null, null, this.a.g);
                if (ho5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(mo5.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                h("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.hb1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.hb1
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, be5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.hb1
        public void e(be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, be1Var) == null) {
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(mo5.b, true);
                }
                h("advert_load", 1);
                if (this.a.h != null) {
                    if (be1Var == null) {
                        this.a.h.onSplashEvent(66);
                    } else {
                        rb1 a = be1Var.a();
                        if (a != null) {
                            this.a.k = a.e();
                        }
                        JSONObject b = be1Var.b();
                        this.a.i = b != null ? b.optInt("source", -1) : -1;
                        this.a.h.onSplashEvent(65, this.a.i);
                    }
                }
                mo5.k(mo5.b, "0", null, be5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                lo5.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.hb1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.b("play error");
                }
            }
        }

        @Override // com.baidu.tieba.hb1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (ViewGroup) this.a.d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                xg a = xa5.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(go5.d().c()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // com.baidu.tieba.hb1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                mo5.a();
                if (!this.a.j) {
                    this.a.j = true;
                    mo5.l(mo5.b, "0", null, be5.m(this.a.i), null, null, this.a.g);
                }
                h("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e != null ? this.a.e.hashCode() : 0));
            }
        }

        @Override // com.baidu.tieba.hb1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, be5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn5 a;

        public b(sn5 sn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn5Var;
        }

        @Override // com.baidu.tieba.hb1
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || sn5.n == null) {
                return;
            }
            sn5.n.a();
        }

        @Override // com.baidu.tieba.hb1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (sn5.n != null) {
                    if (sn5.n != null) {
                        sn5.n.b(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                km5.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // com.baidu.tieba.hb1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.hb1
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || sn5.n == null) {
                return;
            }
            sn5.n.d();
        }

        @Override // com.baidu.tieba.hb1
        public void e(be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, be1Var) == null) {
                if (sn5.n != null) {
                    if (sn5.n != null) {
                        sn5.n.e(be1Var);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", be1Var);
                km5.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // com.baidu.tieba.hb1
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || sn5.n == null) {
                return;
            }
            sn5.n.f();
        }

        @Override // com.baidu.tieba.hb1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (sn5.n != null) {
                    return sn5.n.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.baidu.tieba.hb1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || sn5.n == null) {
                return;
            }
            sn5.n.onAdShow();
        }

        @Override // com.baidu.tieba.hb1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || sn5.n == null) {
                return;
            }
            sn5.n.onSkip();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948157199, "Lcom/baidu/tieba/sn5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948157199, "Lcom/baidu/tieba/sn5;");
        }
    }

    public sn5(SplashNativePolicy splashNativePolicy) {
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
        this.b = 5;
        this.c = AdLoadState.INIT;
        this.e = null;
        this.f = false;
        this.g = -1L;
        this.i = -1;
        this.j = false;
        this.k = null;
        this.h = splashNativePolicy;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            w8.f().g();
        }
    }

    @Override // com.baidu.tieba.ho5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m = true;
            x(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.ho5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.get() != null && this.d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ho5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? be5.m(this.i) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ho5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ho5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l != null) {
                l.h();
                l = null;
            }
            n = null;
        }
    }

    @Override // com.baidu.tieba.ho5
    public void e(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jm4Var) == null) || jm4Var == null || jm4Var.b() == null || jm4Var.b().getContext() == null) {
            return;
        }
        this.e = jm4Var.a();
        this.f = jm4Var.d();
        this.g = jm4Var.c();
        this.d = new WeakReference<>(jm4Var.b());
        a aVar = new a(this);
        n = aVar;
        if (m) {
            t();
            m = false;
            return;
        }
        x(aVar, this.e);
    }

    @Override // com.baidu.tieba.ho5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.d) == null || weakReference.get().getParent() == null || !(this.d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.d.get().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ho5
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || l == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (ho5.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        l.n(this.d.get());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || n == null || km5.c().d(f()).isEmpty()) {
            return;
        }
        for (km5.a aVar : km5.c().d(f())) {
            String str = aVar.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -610376507) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c = 0;
                }
            } else if (str.equals("onAdLoadFailed")) {
                c = 1;
            }
            if (c == 0) {
                n.e((be1) aVar.b.get("data"));
            } else if (c == 1) {
                n.b((String) aVar.b.get("data"));
            }
        }
        km5.c().b(f());
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (km5.c().d(f()).isEmpty()) {
                return false;
            }
            for (km5.a aVar : km5.c().d(f())) {
                if ("onAdLoaded".equals(aVar.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !km5.c().d(f()).isEmpty() : invokeV.booleanValue;
    }

    public final void x(hb1 hb1Var, gm4 gm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, hb1Var, gm4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                jd1.b bVar = new jd1.b();
                bVar.j(ri.k(context));
                bVar.k(ri.i(context));
                l = new mb1(context, qb1.l(), bVar.i(), hb1Var);
                this.c = AdLoadState.LOADING;
                l.i();
                if (ho5.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (gm4Var != null) {
                    gm4Var.b("oom");
                }
            }
        }
    }
}
