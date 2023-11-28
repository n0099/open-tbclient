package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes7.dex */
public class l56 {
    public static /* synthetic */ Interceptable $ic;
    public static l56 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public kr4 f;
    public final ArrayList<m56> g;

    public l56() {
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
            Iterator<m56> it = this.g.iterator();
            while (it.hasNext()) {
                m56 next = it.next();
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

    public static l56 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (l56.class) {
                    if (h == null) {
                        h = new l56();
                    }
                }
            }
            return h;
        }
        return (l56) invokeV.objValue;
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
            Iterator<m56> it = this.g.iterator();
            while (it.hasNext()) {
                m56 next = it.next();
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
            Iterator<m56> it = this.g.iterator();
            while (it.hasNext()) {
                m56 next = it.next();
                if (next instanceof u46) {
                    u46 u46Var = (u46) next;
                    boolean D = u46Var.D();
                    zya.a("AdSdkStretagyManager failSplashAd isBearAdReady:" + D);
                    if (D && BearTimeoutTryShowSwitch.isOn()) {
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
                        u46Var.B();
                        return;
                    }
                    StatisticItem make = StatisticItem.make("fail_splash");
                    if (D) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    make.param("obj_param1", str).eventStat();
                }
            }
            kr4 kr4Var = this.f;
            if (kr4Var != null) {
                kr4Var.a("");
            }
        }
    }

    public final byte e(m56 m56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, m56Var)) == null) {
            if (m56Var == null) {
                return (byte) 0;
            }
            String f = m56Var.f();
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
                v46 v46Var = new v46(this.e);
                u46 u46Var = new u46(this.e);
                this.g.clear();
                if (ss5.w()) {
                    this.g.add(v46Var);
                } else {
                    BaseVM.m(27);
                }
                if (ss5.q()) {
                    this.g.add(u46Var);
                }
                if (SharedPrefHelper.getInstance().getBoolean("key_is_jump_splash_ad", false)) {
                    h();
                    this.g.clear();
                }
            }
        }
    }

    public void i(int i) {
        kr4 kr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (kr4Var = this.f) != null) {
            kr4Var.b(i);
        }
    }

    public void j(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<m56> it = this.g.iterator();
            while (it.hasNext()) {
                m56 next = it.next();
                if (i == 5 && (next instanceof v46)) {
                    next.a();
                    return;
                } else if (i == 6 && (next instanceof u46)) {
                    Iterator<m56> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        m56 next2 = it2.next();
                        if (next2 instanceof v46) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            v46 v46Var = (v46) next2;
                            String str2 = "1";
                            if (v46Var.z()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            statisticItem.param("obj_param1", str);
                            if (!v46Var.A()) {
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

    public synchronized void k(nr4 nr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nr4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = nr4Var.c();
                this.f = nr4Var.a();
                this.c = nr4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                u56.c();
                Iterator<m56> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next().e(nr4Var);
                }
            }
        }
    }

    public synchronized void l(boolean z) {
        boolean z2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                Iterator<m56> it = this.g.iterator();
                while (it.hasNext()) {
                    m56 next = it.next();
                    if (next != null) {
                        if (z) {
                            z2 = next instanceof u46;
                        } else {
                            z2 = next instanceof v46;
                        }
                        if (z2 && next.d() == AdLoadState.SUCCEED) {
                            int i2 = 1;
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                            if (this.c) {
                                i = 2;
                            } else {
                                i = 1;
                            }
                            StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(next.c())) {
                                param2.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param2.eventStat();
                            if (String.valueOf((int) e(next)).equals(v56.c)) {
                                BaseVM.m(28);
                            }
                            aza.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                String str = null;
                                if (next instanceof v46) {
                                    str = ((v46) next).k;
                                }
                                this.f.c(str);
                            }
                            next.show();
                            TbLog defaultLog = DefaultLog.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("开屏广告：showSplashAd, 广告渠道(5.序章GD; 6.小熊SDK): ");
                            sb.append((int) e(next));
                            sb.append(" ，启动类型(1=冷启动 2=热启动)：");
                            if (this.c) {
                                i2 = 2;
                            }
                            sb.append(i2);
                            defaultLog.i("AdSdkStretagyManager", sb.toString());
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            u56.d(String.valueOf((int) e(next)));
                            return;
                        }
                    }
                }
                if (this.f != null) {
                    this.f.a("");
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
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(ss5.u(), ss5.w(), ss5.v(), ss5.k(), ss5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (!initSplashPolicy) {
                    this.e = null;
                    return;
                }
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(ss5.u(), ss5.w(), ss5.v(), ss5.k(), ss5.l());
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
            u46.F(JavaTypesHelper.toInt(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
