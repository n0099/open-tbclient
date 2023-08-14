package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.p46;
import com.baidu.tieba.xk1;
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
/* loaded from: classes6.dex */
public class k66 implements a76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jj1 l;
    public static volatile boolean m;
    public static volatile ej1 n;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public fw4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947865086, "Lcom/baidu/tieba/k66;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947865086, "Lcom/baidu/tieba/k66;");
        }
    }

    @Override // com.baidu.tieba.a76
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ej1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k66 a;

        @Override // com.baidu.tieba.ej1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(k66 k66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k66Var;
        }

        @Override // com.baidu.tieba.ej1
        public void a() {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                boolean z4 = true;
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (k66.l != null && k66.l.b() != null) {
                        if (k66.l.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (k66.l.b().optInt("full_type", 0) != 1) {
                            z4 = false;
                        }
                        z = z3;
                        z2 = z4;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    fw4 fw4Var = this.a.e;
                    k66 k66Var = this.a;
                    fw4Var.e(z, z2, k66Var.b, null, uu5.m(k66Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.ej1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                g76.h(g76.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                g76.i(g76.b, "1", str, null, null, null, this.a.g);
                if (a76.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(g76.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                h("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.ej1
        public void d() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                int i = 1;
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, uu5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.f) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.ej1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                int i = 0;
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    g76.i(g76.b, "0", null, uu5.m(this.a.i), null, null, this.a.g);
                }
                h("advert_show", 1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.e != null) {
                    i = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.ej1
        public void onSkip() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                int i = 2;
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, uu5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (!this.a.f) {
                    i = 1;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }

        @Override // com.baidu.tieba.ej1
        public void e(pl1 pl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, pl1Var) == null) {
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(g76.b, true);
                }
                h("advert_load", 1);
                if (this.a.h != null) {
                    if (pl1Var != null) {
                        oj1 a = pl1Var.a();
                        if (a != null) {
                            this.a.k = a.j();
                        }
                        JSONObject b = pl1Var.b();
                        k66 k66Var = this.a;
                        int i = -1;
                        if (b != null) {
                            i = b.optInt("source", -1);
                        }
                        k66Var.i = i;
                        this.a.h.onSplashEvent(65, this.a.i);
                    } else {
                        this.a.h.onSplashEvent(66);
                    }
                }
                g76.h(g76.b, "0", null, uu5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                f76.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.ej1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.b("play error");
                }
            }
        }

        @Override // com.baidu.tieba.ej1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return (ViewGroup) this.a.d.get();
            }
            return (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                BdStatsItem logItem = PerformanceLogger.getLogItem();
                logItem.append("type", "prologue");
                logItem.append("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                logItem.append("switch", Integer.valueOf(z66.d().c()));
                logItem.append("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, logItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ej1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k66 a;

        @Override // com.baidu.tieba.ej1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public b(k66 k66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k66Var;
        }

        @Override // com.baidu.tieba.ej1
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k66.n != null) {
                k66.n.a();
            }
        }

        @Override // com.baidu.tieba.ej1
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && k66.n != null) {
                k66.n.d();
            }
        }

        @Override // com.baidu.tieba.ej1
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && k66.n != null) {
                k66.n.f();
            }
        }

        @Override // com.baidu.tieba.ej1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (k66.n != null) {
                    return k66.n.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ej1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && k66.n != null) {
                k66.n.onAdShow();
            }
        }

        @Override // com.baidu.tieba.ej1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k66.n != null) {
                k66.n.onSkip();
            }
        }

        @Override // com.baidu.tieba.ej1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (k66.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    p46.c().a(this.a.f(), "onAdLoadFailed", hashMap);
                } else if (k66.n != null) {
                    k66.n.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.ej1
        public void e(pl1 pl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, pl1Var) == null) {
                if (k66.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", pl1Var);
                    p46.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (k66.n != null) {
                    k66.n.e(pl1Var);
                }
            }
        }
    }

    public k66(SplashNativePolicy splashNativePolicy) {
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

    @Override // com.baidu.tieba.a76
    public void e(iw4 iw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iw4Var) == null) && iw4Var != null && iw4Var.b() != null && iw4Var.b().getContext() != null) {
            this.e = iw4Var.a();
            this.f = iw4Var.d();
            this.g = iw4Var.c();
            this.d = new WeakReference<>(iw4Var.b());
            if (n == null) {
                n = new a(this);
            }
            if (m) {
                t();
                m = false;
                return;
            }
            x(n, this.e);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            p8.f().g();
        }
    }

    @Override // com.baidu.tieba.a76
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m = true;
            x(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.a76
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.d.get() != null && this.d.get().getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a76
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return uu5.m(this.i);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a76
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a76
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l != null) {
                l.i();
                l = null;
            }
            n = null;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !p46.c().d(f()).isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (weakReference = this.d) != null && weakReference.get().getParent() != null && (this.d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.get().getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.d.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.a76
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || l == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (a76.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        try {
            l.o(this.d.get());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!p46.c().d(f()).isEmpty()) {
                for (p46.a aVar : p46.c().d(f())) {
                    if ("onAdLoaded".equals(aVar.a)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && n != null && !p46.c().d(f()).isEmpty()) {
            for (p46.a aVar : p46.c().d(f())) {
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
                if (c != 0) {
                    if (c == 1) {
                        n.b((String) aVar.b.get("data"));
                    }
                } else {
                    n.e((pl1) aVar.b.get("data"));
                }
            }
            p46.c().b(f());
        }
    }

    public final void x(ej1 ej1Var, fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, ej1Var, fw4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                xk1.b bVar = new xk1.b();
                bVar.j(BdUtilHelper.getEquipmentWidth(context));
                bVar.k(BdUtilHelper.getEquipmentHeight(context));
                l = new jj1(context, nj1.l(), bVar.i(), ej1Var);
                this.c = AdLoadState.LOADING;
                l.j();
                if (a76.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (fw4Var != null) {
                    fw4Var.b("oom");
                }
            }
        }
    }
}
