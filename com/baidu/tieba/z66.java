package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BearTimeoutTryShowSwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class z66 {
    public static /* synthetic */ Interceptable $ic;
    public static z66 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public fw4 f;
    public final ArrayList<a76> g;

    public z66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = -1L;
        this.f = null;
        this.g = new ArrayList<>();
        this.a = SharedPrefHelper.getInstance().getInt("splash_ad_strategy_key", 0);
        m();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<a76> it = this.g.iterator();
            while (it.hasNext()) {
                a76 next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.g.clear();
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.e = null;
            }
        }
    }

    public static z66 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (z66.class) {
                    if (h == null) {
                        h = new z66();
                    }
                }
            }
            return h;
        }
        return (z66) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<a76> it = this.g.iterator();
            while (it.hasNext()) {
                a76 next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            uBCManager.onEvent("5088");
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<a76> it = this.g.iterator();
            while (it.hasNext()) {
                a76 next = it.next();
                if (next instanceof j66) {
                    j66 j66Var = (j66) next;
                    boolean z = j66Var.z();
                    cea.a("AdSdkStretagyManager failSplashAd isBearAdReady:" + z);
                    if (z && BearTimeoutTryShowSwitch.isOn()) {
                        int i = 1;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1);
                        if (this.c) {
                            i = 2;
                        }
                        StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                        if (!StringUtils.isNull(next.c())) {
                            param2.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param2.eventStat();
                        j66Var.x();
                        return;
                    }
                    StatisticItem make = StatisticItem.make("fail_splash");
                    if (z) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    make.param("obj_param1", str).eventStat();
                }
            }
            fw4 fw4Var = this.f;
            if (fw4Var != null) {
                fw4Var.b("");
            }
        }
    }

    public final byte e(a76 a76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, a76Var)) == null) {
            if (a76Var == null) {
                return (byte) 0;
            }
            String f = a76Var.f();
            char c = 65535;
            int hashCode = f.hashCode();
            if (hashCode != -1348168235) {
                if (hashCode == 3019700 && f.equals("bear")) {
                    c = 0;
                }
            } else if (f.equals("prologue_gd")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    return (byte) 0;
                }
                return (byte) 5;
            }
            return (byte) 6;
        }
        return invokeL.byteValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.g.isEmpty()) {
                    return;
                }
                k66 k66Var = new k66(this.e);
                j66 j66Var = new j66(this.e);
                this.g.clear();
                if (uu5.w()) {
                    this.g.add(k66Var);
                } else {
                    BaseVM.m(27);
                }
                if (uu5.q()) {
                    this.g.add(j66Var);
                }
                if (SharedPrefHelper.getInstance().getBoolean("key_is_jump_splash_ad", false)) {
                    h();
                    this.g.clear();
                }
            }
        }
    }

    public void i(int i) {
        fw4 fw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (fw4Var = this.f) != null) {
            fw4Var.a(i);
        }
    }

    public void j(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<a76> it = this.g.iterator();
            while (it.hasNext()) {
                a76 next = it.next();
                if (i == 5 && (next instanceof k66)) {
                    next.a();
                    return;
                } else if (i == 6 && (next instanceof j66)) {
                    Iterator<a76> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        a76 next2 = it2.next();
                        if (next2 instanceof k66) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            k66 k66Var = (k66) next2;
                            String str2 = "1";
                            if (k66Var.v()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            statisticItem.param("obj_param1", str);
                            if (!k66Var.w()) {
                                str2 = "0";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(iw4 iw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iw4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = iw4Var.c();
                this.f = iw4Var.a();
                this.c = iw4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                f76.c();
                Iterator<a76> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next().e(iw4Var);
                }
            }
        }
    }

    public synchronized void l(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                Iterator<a76> it = this.g.iterator();
                while (it.hasNext()) {
                    a76 next = it.next();
                    if (next != null) {
                        if (z) {
                            z2 = next instanceof j66;
                        } else {
                            z2 = next instanceof k66;
                        }
                        if (z2 && next.d() == AdLoadState.SUCCEED) {
                            int i = 1;
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                            if (this.c) {
                                i = 2;
                            }
                            StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(next.c())) {
                                param2.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param2.eventStat();
                            if (String.valueOf((int) e(next)).equals(g76.c)) {
                                BaseVM.m(28);
                            }
                            dea.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                String str = null;
                                if (next instanceof k66) {
                                    str = ((k66) next).k;
                                }
                                this.f.c(str);
                            }
                            next.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            f76.d(String.valueOf((int) e(next)));
                            return;
                        }
                    }
                }
                if (this.f != null) {
                    this.f.b("");
                }
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy == null) {
                SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                this.e = splashNativePolicy2;
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(uu5.u(), uu5.w(), uu5.v(), uu5.k(), uu5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (!initSplashPolicy) {
                    this.e = null;
                    return;
                }
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(uu5.u(), uu5.w(), uu5.v(), uu5.k(), uu5.l());
            PrintStream printStream2 = System.out;
            printStream2.println("SplashPolicy update result = " + updateSplashConfig);
            if (!updateSplashConfig) {
                this.e = null;
            }
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.a = JavaTypesHelper.toInt(jSONObject.optString("ad_sdk_priority"), 0);
            SharedPrefHelper.getInstance().putInt("splash_ad_strategy_key", this.a);
            SharedPrefHelper.getInstance().putInt("splash_origin_ad_strategy_key", JavaTypesHelper.toInt(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int i = JavaTypesHelper.toInt(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int i2 = JavaTypesHelper.toInt(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int i3 = JavaTypesHelper.toInt(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int i4 = JavaTypesHelper.toInt(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int i5 = JavaTypesHelper.toInt(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                SharedPrefHelper.getInstance().putInt("key_splash_new_policy_bear_enable", i3);
                SharedPrefHelper.getInstance().putInt("key_splash_new_policy_plg_enable", i4);
                SharedPrefHelper.getInstance().putInt("key_splash_new_policy_plg_cpc_enable", i5);
                SharedPrefHelper.getInstance().putInt("key_splash_new_policy_first_timeout", i);
                SharedPrefHelper.getInstance().putInt("key_splash_new_policy_second_timeout", i2);
            }
            j66.B(JavaTypesHelper.toInt(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
