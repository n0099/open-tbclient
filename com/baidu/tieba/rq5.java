package com.baidu.tieba;

import android.app.Activity;
import android.os.CountDownTimer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.jt5;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class rq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ApkDownloadInfoData> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq5 a;

        /* renamed from: com.baidu.tieba.rq5$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0460a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ApkDownloadInfoData a;
            public final /* synthetic */ a b;

            public RunnableC0460a(a aVar, ApkDownloadInfoData apkDownloadInfoData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, apkDownloadInfoData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = apkDownloadInfoData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof yga) && ((yga) this.b.a.b).e0().hasDialog()) {
                        return;
                    }
                    this.b.a.q(this.a);
                }
            }
        }

        public a(rq5 rq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.a.n();
                if (ListUtils.isEmpty(this.a.a)) {
                    return null;
                }
                TbSingleton.getInstance();
                if (TbSingleton.getExceptInsertAdDiaShow()) {
                    return null;
                }
                if ((this.a.b instanceof yga) && ((yga) this.a.b).e0().hasDialog()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ApkDownloadInfoData apkDownloadInfoData = (ApkDownloadInfoData) it.next();
                    if (apkDownloadInfoData != null && apkDownloadInfoData.getStatus() == AdDownloadStatus.COMPLETED && this.a.l(apkDownloadInfoData)) {
                        SafeHandler.getInst().post(new RunnableC0460a(this, apkDownloadInfoData));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements jt5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ApkDownloadInfoData a;
        public final /* synthetic */ jt5 b;
        public final /* synthetic */ rq5 c;

        public b(rq5 rq5Var, ApkDownloadInfoData apkDownloadInfoData, jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq5Var, apkDownloadInfoData, jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rq5Var;
            this.a = apkDownloadInfoData;
            this.b = jt5Var;
        }

        @Override // com.baidu.tieba.jt5.h
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    ApkDownloadInfoData apkDownloadInfoData = this.a;
                    if (apkDownloadInfoData != null && apkDownloadInfoData.getAdDownloadBean() != null) {
                        AdAppStateManager.instance().register(this.a.getAdDownloadBean());
                    }
                    ApkDownloadInfoData apkDownloadInfoData2 = this.a;
                    if (apkDownloadInfoData2 != null) {
                        AdApkInstallHelper.a(apkDownloadInfoData2.getApkPath(), new DownloadData(this.a.getTitle()));
                    }
                    this.b.l();
                }
                this.c.j(this.a, i, System.currentTimeMillis() - this.c.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements jt5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq5 a;

        public c(rq5 rq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq5Var;
        }

        @Override // com.baidu.tieba.jt5.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.cancel();
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;
        public final /* synthetic */ rq5 b;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(rq5 rq5Var, long j, long j2, jt5 jt5Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq5Var, Long.valueOf(j), Long.valueOf(j2), jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rq5Var;
            this.a = jt5Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
                this.b.c = null;
            }
        }
    }

    public rq5(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.b = activity;
    }

    public final boolean k(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apkDownloadInfoData)) == null) {
            if (apkDownloadInfoData == null || apkDownloadInfoData.getApkFile() == null || !apkDownloadInfoData.getApkFile().exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void r(jt5 jt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jt5Var) == null) && this.c == null) {
            d dVar = new d(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, jt5Var);
            this.c = dVar;
            dVar.start();
        }
    }

    public final void o(jt5 jt5Var, ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jt5Var, apkDownloadInfoData) == null) {
            jt5Var.t(new b(this, apkDownloadInfoData, jt5Var));
            jt5Var.q(new c(this));
        }
    }

    public final void j(ApkDownloadInfoData apkDownloadInfoData, int i, long j) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{apkDownloadInfoData, Integer.valueOf(i), Long.valueOf(j)}) != null) || apkDownloadInfoData == null) {
            return;
        }
        if (UbsABTestHelper.isAdNotInstallRemindA()) {
            str = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
        } else {
            str = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_CLICK);
        statisticItem.param("obj_source", apkDownloadInfoData.getApkName()).param("obj_type", i).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_URL, apkDownloadInfoData.getDownloadUrl()).param("obj_name", apkDownloadInfoData.getApkPackageName()).param(TiebaStatic.Params.OBJ_PARAM3, str).param(TiebaStatic.Params.OBJ_PARAM4, apkDownloadInfoData.getItemSource());
        TiebaStatic.log(statisticItem);
        if (apkDownloadInfoData != null && apkDownloadInfoData.isFromBusiness()) {
            String str2 = null;
            if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null) {
                str2 = apkDownloadInfoData.getAdDownloadBean().p.a;
            }
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (i == 1) {
                v.i(ClogBuilder.Area.INSTALL_NOW_BUTTON);
            } else if (i == 2) {
                v.i(ClogBuilder.Area.CLOSE_BTN);
            } else if (i == 3) {
                v.i(ClogBuilder.Area.HOTAREA);
            }
            v.k(String.valueOf(j));
            v.l(String.valueOf(5000L));
            if (!StringUtils.isNull(str2)) {
                v.p(str2);
            }
            jy0.e(v);
        }
    }

    public final boolean l(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, apkDownloadInfoData)) == null) {
            if (apkDownloadInfoData == null) {
                return false;
            }
            int i = SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(SharedPrefHelper.getInstance().getLong("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                SharedPrefHelper.getInstance().putInt("key_ad_retarget_tips_day_count", 0);
                i = 0;
            }
            if (i >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            if (SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_app_count_" + apkDownloadInfoData.getApkPackageName(), 0) >= TbSingleton.getInstance().mAdFloatTipsAppLimitCount || UtilHelper.isInstallApk(this.b, apkDownloadInfoData.getApkPackageName()) || !k(apkDownloadInfoData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new a(this).execute(new String[0]);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = yr5.d().a(-1);
        }
    }

    public final void p(ApkDownloadInfoData apkDownloadInfoData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, apkDownloadInfoData) != null) || apkDownloadInfoData == null) {
            return;
        }
        if (UbsABTestHelper.isAdNotInstallRemindA()) {
            str = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
        } else {
            str = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_SHOW);
        statisticItem.param("obj_source", apkDownloadInfoData.getApkName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_URL, apkDownloadInfoData.getDownloadUrl()).param("obj_name", apkDownloadInfoData.getApkPackageName()).param(TiebaStatic.Params.OBJ_PARAM3, str).param(TiebaStatic.Params.OBJ_PARAM4, apkDownloadInfoData.getItemSource());
        TiebaStatic.log(statisticItem);
        if (apkDownloadInfoData != null && apkDownloadInfoData.isFromBusiness()) {
            String str2 = null;
            if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null) {
                str2 = apkDownloadInfoData.getAdDownloadBean().p.a;
            }
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (!StringUtils.isNull(str2)) {
                v.p(str2);
            }
            jy0.e(v);
        }
    }

    public final void q(ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, apkDownloadInfoData) == null) {
            jt5 jt5Var = new jt5(this.b, 48);
            jt5Var.u(apkDownloadInfoData.getApkName());
            jt5Var.p(TbadkCoreApplication.getInst().getString(R.string.not_install_apk_tips));
            jt5Var.s(TbadkCoreApplication.getInst().getString(R.string.downloaded_install));
            jt5Var.r(apkDownloadInfoData.getApkIcon());
            jt5Var.o(8);
            if (jt5Var.v()) {
                this.d = System.currentTimeMillis();
                r(jt5Var);
                s(apkDownloadInfoData);
                o(jt5Var, apkDownloadInfoData);
                p(apkDownloadInfoData);
            }
        }
    }

    public final void s(ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, apkDownloadInfoData) == null) {
            SharedPrefHelper.getInstance().putInt("key_ad_retarget_tips_day_count", SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_day_count", 0) + 1);
            SharedPrefHelper.getInstance().putLong("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + apkDownloadInfoData.getApkPackageName();
            SharedPrefHelper.getInstance().putInt(str, SharedPrefHelper.getInstance().getInt(str, 0) + 1);
        }
    }
}
