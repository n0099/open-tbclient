package com.baidu.tieba;

import android.content.res.Configuration;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yqa implements pqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qqa a;
    public final rqa b;
    public nr4 c;
    public ViewGroup d;
    public boolean e;
    public long f;
    public boolean g;
    public final Runnable h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yqa a;

        public a(yqa yqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yqaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("ThirdPartySplashController", "开屏广告：mTimeOutRunnable, hasLoadBesFinish is: " + this.a.e + " ,besSplashHolder is: " + this.a.d);
                if (!this.a.e && this.a.d != null) {
                    SpeedStatsManager.getInstance().setIsTimeout(true);
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
                    if (runTask != null && runTask.getData() != null && ((Boolean) runTask.getData()).booleanValue()) {
                        DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：mTimeOutRunnable, showResMsg.getData() is true");
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_RD_USE);
                        statisticItem.addParam("obj_source", "tb_kpgg").addParam("obj_param1", "class_ThirdPartySplashController").addParam("obj_type", "mTimeOutRunnable");
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    zya.a("ThirdPartySplashController mTimeOutRunnable");
                    TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064");
                    if (this.a.a.h()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    param.param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_param1", 1).eventStat();
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        Log.d("IAdSdkSplash", "兜底time out and jump maintab");
                    }
                    this.a.a.getRootView().removeView(this.a.d);
                    this.a.b.a();
                    DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：mTimeOutRunnable, closeSplash");
                    BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", YYOption.IsLive.VALUE_TRUE);
                }
            }
        }
    }

    public yqa(qqa qqaVar, rqa rqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qqaVar, rqaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = -1L;
        this.g = false;
        this.h = new a(this);
        this.a = qqaVar;
        this.b = rqaVar;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.tieba.pqa
    public void onConfigurationChanged(Configuration configuration) {
        nr4 nr4Var;
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (nr4Var = this.c) != null && (lr4Var = nr4Var.c) != null) {
            lr4Var.a();
        }
    }

    @Override // com.baidu.tieba.pqa
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
            nr4 nr4Var = this.c;
            if (nr4Var != null) {
                nr4Var.f(null);
                this.c.e(null);
            }
        }
    }

    @Override // com.baidu.tieba.pqa
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l();
            return true;
        }
        return invokeV.booleanValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public ViewGroup h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：invokeTimeoutTask, postDelayed mTimeOutRunnable");
            SafeHandler.getInst().postDelayed(this.h, 500L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：releaseTimeout");
            this.g = true;
            SafeHandler.getInst().removeCallbacks(this.h);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：showADView, bes is null, closeSplash");
                this.b.a();
            } else {
                m();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：showBesAdView");
            this.g = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f = System.currentTimeMillis();
            this.c = new nr4(this.a.h(), this.a.i());
            this.d = new RelativeLayout(this.a.getActivity());
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.d);
            this.c.f(this.d);
            this.c.e(new xqa(this.a, this.b, this));
            MessageManager.getInstance().runTask(2016555, Long.class, this.c);
            if (!this.g) {
                DefaultLog.getInstance().i("ThirdPartySplashController", "开屏广告：showBesAdView, postDelayed mTimeOutRunnable");
                rp5.a().i(System.currentTimeMillis() - currentTimeMillis);
                SafeHandler.getInst().postDelayed(this.h, ss5.l() + 500);
            }
        }
    }
}
