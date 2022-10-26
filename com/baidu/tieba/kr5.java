package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.pyramid.runtime.service.ServiceManager;
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
/* loaded from: classes4.dex */
public class kr5 {
    public static /* synthetic */ Interceptable $ic;
    public static kr5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public vo4 f;
    public final ArrayList g;

    public kr5() {
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
        this.g = new ArrayList();
        this.a = ux4.k().l("splash_ad_strategy_key", 0);
        m();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                lr5 lr5Var = (lr5) it.next();
                if (lr5Var != null) {
                    lr5Var.destroy();
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

    public static kr5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (kr5.class) {
                    if (h == null) {
                        h = new kr5();
                    }
                }
            }
            return h;
        }
        return (kr5) invokeV.objValue;
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
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                lr5 lr5Var = (lr5) it.next();
                if (lr5Var != null && lr5Var.b()) {
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
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                lr5 lr5Var = (lr5) it.next();
                if (lr5Var instanceof uq5) {
                    uq5 uq5Var = (uq5) lr5Var;
                    boolean v = uq5Var.v();
                    if (v && BearTimeoutTryShowSwitch.isOn()) {
                        int i = 1;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(lr5Var)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1);
                        if (this.c) {
                            i = 2;
                        }
                        StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                        if (!StringUtils.isNull(lr5Var.c())) {
                            param2.param(TiebaStatic.Params.OBJ_TO, lr5Var.c());
                        }
                        param2.eventStat();
                        uq5Var.t();
                        return;
                    }
                    StatisticItem make = StatisticItem.make("fail_splash");
                    if (v) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    make.param("obj_param1", str).eventStat();
                }
            }
            vo4 vo4Var = this.f;
            if (vo4Var != null) {
                vo4Var.b("");
            }
        }
    }

    public final byte e(lr5 lr5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lr5Var)) == null) {
            if (lr5Var == null) {
                return (byte) 0;
            }
            String f = lr5Var.f();
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
                vq5 vq5Var = new vq5(this.e);
                uq5 uq5Var = new uq5(this.e);
                this.g.clear();
                if (xg5.w()) {
                    this.g.add(vq5Var);
                } else {
                    BaseVM.m(27);
                }
                if (xg5.q()) {
                    this.g.add(uq5Var);
                }
                if (ux4.k().h("key_is_jump_splash_ad", false)) {
                    h();
                    this.g.clear();
                }
            }
        }
    }

    public void i(int i) {
        vo4 vo4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (vo4Var = this.f) != null) {
            vo4Var.a(i);
        }
    }

    public void j(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                lr5 lr5Var = (lr5) it.next();
                if (i == 5 && (lr5Var instanceof vq5)) {
                    if (qr5.g()) {
                        BaseVM.m(29);
                    } else {
                        lr5Var.a();
                        return;
                    }
                } else if (i == 6 && (lr5Var instanceof uq5)) {
                    Iterator it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        lr5 lr5Var2 = (lr5) it2.next();
                        if (lr5Var2 instanceof vq5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            vq5 vq5Var = (vq5) lr5Var2;
                            String str2 = "1";
                            if (vq5Var.v()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            statisticItem.param("obj_param1", str);
                            if (!vq5Var.w()) {
                                str2 = "0";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    lr5Var.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(yo4 yo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yo4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = yo4Var.c();
                this.f = yo4Var.a();
                this.c = yo4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                pr5.c();
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    lr5 lr5Var = (lr5) it.next();
                    if ((lr5Var instanceof vq5) && qr5.g()) {
                        BaseVM.m(29);
                    } else {
                        lr5Var.e(yo4Var);
                    }
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
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    lr5 lr5Var = (lr5) it.next();
                    if (lr5Var != null) {
                        if (z) {
                            z2 = lr5Var instanceof uq5;
                        } else {
                            z2 = lr5Var instanceof vq5;
                        }
                        if (z2 && lr5Var.d() == AdLoadState.SUCCEED) {
                            int i = 1;
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(lr5Var)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                            if (this.c) {
                                i = 2;
                            }
                            StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(lr5Var.c())) {
                                param2.param(TiebaStatic.Params.OBJ_TO, lr5Var.c());
                            }
                            param2.eventStat();
                            if (String.valueOf((int) e(lr5Var)).equals(qr5.c)) {
                                BaseVM.m(28);
                            }
                            zp8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                String str = null;
                                if (lr5Var instanceof vq5) {
                                    str = ((vq5) lr5Var).k;
                                }
                                this.f.c(str);
                            }
                            lr5Var.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(lr5Var)));
                            }
                            pr5.d(String.valueOf((int) e(lr5Var)));
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
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(xg5.u(), xg5.w(), xg5.v(), xg5.k(), xg5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (!initSplashPolicy) {
                    this.e = null;
                    return;
                }
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(xg5.u(), xg5.w(), xg5.v(), xg5.k(), xg5.l());
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
            this.a = eh.e(jSONObject.optString("ad_sdk_priority"), 0);
            ux4.k().w("splash_ad_strategy_key", this.a);
            ux4.k().w("splash_origin_ad_strategy_key", eh.e(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e = eh.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e2 = eh.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e3 = eh.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e4 = eh.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e5 = eh.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                ux4.k().w("key_splash_new_policy_bear_enable", e3);
                ux4.k().w("key_splash_new_policy_plg_enable", e4);
                ux4.k().w("key_splash_new_policy_plg_cpc_enable", e5);
                ux4.k().w("key_splash_new_policy_first_timeout", e);
                ux4.k().w("key_splash_new_policy_second_timeout", e2);
            }
            uq5.x(eh.e(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
