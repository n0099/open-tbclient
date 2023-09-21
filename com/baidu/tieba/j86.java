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
import com.baidu.tieba.d66;
import com.baidu.tieba.fl1;
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes6.dex */
public class j86 implements a96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rj1 n;
    public static volatile boolean o;
    public static volatile mj1 p;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public kw4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;
    public boolean l;
    public final k96 m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947837217, "Lcom/baidu/tieba/j86;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947837217, "Lcom/baidu/tieba/j86;");
        }
    }

    @Override // com.baidu.tieba.a96
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements mj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j86 a;

        public a(j86 j86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j86Var;
        }

        @Override // com.baidu.tieba.mj1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，request，handleUrl， s is：" + str);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.mj1
        public void a() {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdClick");
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                boolean z4 = true;
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (j86.n != null && j86.n.b() != null) {
                        if (j86.n.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (j86.n.b().optInt("full_type", 0) != 1) {
                            z4 = false;
                        }
                        z = z3;
                        z2 = z4;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    kw4 kw4Var = this.a.e;
                    j86 j86Var = this.a;
                    kw4Var.e(z, z2, j86Var.b, null, iw5.m(j86Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，request，onAdLoadFailed, reason is: " + str);
                j96.h(j96.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                j96.i(j96.b, "1", str, null, null, null, this.a.g);
                if (a96.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(j96.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                h("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void e(xl1 xl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, xl1Var) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdLoaded");
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(j96.b, true);
                }
                h("advert_load", 1);
                if (this.a.h != null) {
                    if (xl1Var != null) {
                        wj1 a = xl1Var.a();
                        if (a != null) {
                            this.a.k = a.j();
                        }
                        JSONObject b = xl1Var.b();
                        j86 j86Var = this.a;
                        int i = -1;
                        if (b != null) {
                            i = b.optInt("source", -1);
                        }
                        j86Var.i = i;
                        this.a.h.onSplashEvent(65, this.a.i);
                    } else {
                        this.a.h.onSplashEvent(66);
                    }
                }
                j96.h(j96.b, "0", null, iw5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                i96.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.mj1
        public void d() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = 1;
                this.a.l = true;
                this.a.m.e(2);
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, iw5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.f) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.m.f(2);
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                int i = 0;
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    j96.i(j96.b, "0", null, iw5.m(this.a.i), null, null, this.a.g);
                }
                h("advert_show", 1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.e != null) {
                    i = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.mj1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onAdPlayError");
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.b("play error");
                }
            }
        }

        @Override // com.baidu.tieba.mj1
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
                logItem.append("switch", Integer.valueOf(z86.d().c()));
                logItem.append("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, logItem);
            }
        }

        @Override // com.baidu.tieba.mj1
        public void onSkip() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，request，onSkip");
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (a96.a) {
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
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, iw5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (!this.a.f) {
                    i = 1;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j86 a;

        public b(j86 j86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j86Var;
        }

        @Override // com.baidu.tieba.mj1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("IAdSdkSplash", "开屏广告：原生广告，preLoad，handleUrl， s is：" + str);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.mj1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdClick");
                if (j86.p != null) {
                    j86.p.a();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdFinish");
                if (j86.p != null) {
                    j86.p.d();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdPlayError");
                if (j86.p != null) {
                    j86.p.f();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdShow");
                if (j86.p != null) {
                    j86.p.onAdShow();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onSkip");
                if (j86.p != null) {
                    j86.p.onSkip();
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdLoadFailed");
                if (j86.p == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    d66.c().a(this.a.f(), "onAdLoadFailed", hashMap);
                } else if (j86.p != null) {
                    j86.p.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        public void e(xl1 xl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, xl1Var) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，onAdLoaded");
                if (j86.p == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", xl1Var);
                    d66.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (j86.p != null) {
                    j86.p.e(xl1Var);
                }
            }
        }

        @Override // com.baidu.tieba.mj1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，preLoad，getAdViewHolder");
                if (j86.p != null) {
                    return j86.p.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j86 a;

        public c(j86 j86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j86Var;
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
                    this.a.e.onAdDismiss();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    public j86(SplashNativePolicy splashNativePolicy) {
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
        this.m = new k96();
        this.h = splashNativePolicy;
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            q8.f().g();
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !d66.c().d(f()).isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a96
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o = true;
            B(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.a96
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

    @Override // com.baidu.tieba.a96
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return iw5.m(this.i);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a96
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a96
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

    public final void B(mj1 mj1Var, kw4 kw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mj1Var, kw4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                fl1.b bVar = new fl1.b();
                bVar.j(BdUtilHelper.getEquipmentWidth(context));
                bVar.k(BdUtilHelper.getEquipmentHeight(context));
                n = new rj1(context, vj1.l(), bVar.i(), mj1Var);
                this.c = AdLoadState.LOADING;
                n.j();
                if (a96.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
                DefaultLog.getInstance().i("IAdSdkSplash", "开屏广告：原生广告，loadSplash，原生广告开始加载");
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (kw4Var != null) {
                    kw4Var.b("oom");
                }
            }
        }
    }

    @Override // com.baidu.tieba.a96
    public void e(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nw4Var) == null) && nw4Var != null && nw4Var.b() != null && nw4Var.b().getContext() != null) {
            this.e = nw4Var.a();
            this.f = nw4Var.d();
            this.g = nw4Var.c();
            this.d = new WeakReference<>(nw4Var.b());
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

    @Override // com.baidu.tieba.a96
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || n == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        w();
        this.c = AdLoadState.SHOWED;
        if (a96.a) {
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
            if (!d66.c().d(f()).isEmpty()) {
                for (d66.a aVar : d66.c().d(f())) {
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
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && p != null && !d66.c().d(f()).isEmpty()) {
            for (d66.a aVar : d66.c().d(f())) {
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
                        p.b((String) aVar.b.get("data"));
                    }
                } else {
                    p.e((xl1) aVar.b.get("data"));
                }
            }
            d66.c().b(f());
        }
    }
}
