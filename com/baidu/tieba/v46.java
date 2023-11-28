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
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tieba.hg1;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.o26;
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
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v46 implements m56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile te1 n;
    public static volatile boolean o;
    public static volatile oe1 p;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public kr4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;
    public boolean l;
    public final w56 m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948190865, "Lcom/baidu/tieba/v46;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948190865, "Lcom/baidu/tieba/v46;");
        }
    }

    @Override // com.baidu.tieba.m56
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements oe1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        public a(v46 v46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v46Var;
        }

        @Override // com.baidu.tieba.oe1
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，request，handleUrl， s is：" + str);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.oe1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，request，onAdLoadFailed, reason is: " + str);
                v56.h(v56.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                v56.i(v56.b, "1", str, null, null, null, this.a.g);
                if (m56.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.g(v56.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                g("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void d(zg1 zg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, zg1Var) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdLoaded");
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.g(v56.b, true);
                }
                g("advert_load", 1);
                if (this.a.h != null) {
                    if (zg1Var != null) {
                        ye1 a = zg1Var.a();
                        if (a != null) {
                            this.a.k = a.j();
                        }
                        JSONObject b = zg1Var.b();
                        v46 v46Var = this.a;
                        int i = -1;
                        if (b != null) {
                            i = b.optInt("source", -1);
                        }
                        v46Var.i = i;
                        this.a.h.onSplashEvent(65, this.a.i);
                    } else {
                        this.a.h.onSplashEvent(66);
                    }
                }
                v56.h(v56.b, "0", null, ss5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                u56.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.oe1
        public void c() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = 1;
                this.a.l = true;
                this.a.m.e(2);
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, ss5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.f) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.f();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.m.f(2);
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                int i = 0;
                if (this.a.e != null) {
                    this.a.e.h(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    v56.i(v56.b, "0", null, ss5.m(this.a.i), null, null, this.a.g);
                }
                g("advert_show", 1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.e != null) {
                    i = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.oe1
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdPlayError");
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.a("play error");
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return (ViewGroup) this.a.d.get();
            }
            return (ViewGroup) invokeV.objValue;
        }

        public final void g(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
                BdStatsItem logItem = PerformanceLogger.getLogItem();
                logItem.append("type", "prologue");
                logItem.append("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                logItem.append("switch", Integer.valueOf(l56.d().c()));
                logItem.append("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, logItem);
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onAdClick() {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdClick");
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                boolean z4 = true;
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (v46.n != null && v46.n.b() != null) {
                        if (v46.n.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (v46.n.b().optInt("full_type", 0) != 1) {
                            z4 = false;
                        }
                        z = z3;
                        z2 = z4;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    kr4 kr4Var = this.a.e;
                    v46 v46Var = this.a;
                    kr4Var.e(z, z2, v46Var.b, null, ss5.m(v46Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onSkip() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onSkip");
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (m56.a) {
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
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, ss5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (!this.a.f) {
                    i = 1;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements oe1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        public b(v46 v46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v46Var;
        }

        @Override // com.baidu.tieba.oe1
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，preLoad，handleUrl， s is：" + str);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.oe1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdLoadFailed");
                if (v46.p == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    o26.c().a(this.a.f(), "onAdLoadFailed", hashMap);
                } else if (v46.p != null) {
                    v46.p.a(str);
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void d(zg1 zg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, zg1Var) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdLoaded");
                if (v46.p == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", zg1Var);
                    o26.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (v46.p != null) {
                    v46.p.d(zg1Var);
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdFinish");
                if (v46.p != null) {
                    v46.p.c();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdPlayError");
                if (v46.p != null) {
                    v46.p.e();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdClick");
                if (v46.p != null) {
                    v46.p.onAdClick();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdShow");
                if (v46.p != null) {
                    v46.p.onAdShow();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onSkip");
                if (v46.p != null) {
                    v46.p.onSkip();
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，getAdViewHolder");
                if (v46.p != null) {
                    return v46.p.f();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        public c(v46 v46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告 PrologueAdSdkSplash，adTimeoutTask，isAdClosed is：" + this.a.l + " ，adCallBack is：" + this.a.e);
                if (!this.a.l && this.a.e != null) {
                    this.a.e.f();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    public v46(SplashNativePolicy splashNativePolicy) {
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
        this.l = false;
        this.m = new w56();
        this.h = splashNativePolicy;
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            e4.f().g();
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !o26.c().d(f()).isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m56
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o = true;
            B(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.m56
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.get() != null && this.d.get().getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m56
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ss5.m(this.i);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m56
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m56
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (n != null) {
                n.i();
                n = null;
            }
            p = null;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.m.b(new c(this), 2);
        }
    }

    public final void B(oe1 oe1Var, kr4 kr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oe1Var, kr4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                hg1.b bVar = new hg1.b();
                bVar.j(BdUtilHelper.getEquipmentWidth(context));
                bVar.k(BdUtilHelper.getEquipmentHeight(context));
                n = new te1(context, xe1.l(), bVar.i(), oe1Var);
                this.c = AdLoadState.LOADING;
                n.j();
                if (m56.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，loadSplash，原生广告开始加载");
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (kr4Var != null) {
                    kr4Var.a("oom");
                }
            }
        }
    }

    @Override // com.baidu.tieba.m56
    public void e(nr4 nr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nr4Var) == null) && nr4Var != null && nr4Var.b() != null && nr4Var.b().getContext() != null) {
            this.e = nr4Var.a();
            this.f = nr4Var.d();
            this.g = nr4Var.c();
            this.d = new WeakReference<>(nr4Var.b());
            if (p == null) {
                p = new a(this);
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，request，hasPreLoad is：" + o);
            if (o) {
                x();
                o = false;
                return;
            }
            B(p, this.e);
        }
    }

    @Override // com.baidu.tieba.m56
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || n == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        w();
        this.c = AdLoadState.SHOWED;
        if (m56.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        try {
            n.o(this.d.get());
            v();
            DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：show，原生广告开始展示");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public final void w() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (weakReference = this.d) != null && weakReference.get().getParent() != null && (this.d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.get().getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.d.get().setLayoutParams(layoutParams);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!o26.c().d(f()).isEmpty()) {
                for (o26.a aVar : o26.c().d(f())) {
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

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && p != null && !o26.c().d(f()).isEmpty()) {
            for (o26.a aVar : o26.c().d(f())) {
                String str = aVar.a;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -610376507) {
                    if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                        c2 = 0;
                    }
                } else if (str.equals("onAdLoadFailed")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        p.a((String) aVar.b.get("data"));
                    }
                } else {
                    p.d((zg1) aVar.b.get("data"));
                }
            }
            o26.c().b(f());
        }
    }
}
