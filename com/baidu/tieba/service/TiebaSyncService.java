package com.baidu.tieba.service;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.ABTestSwitchManager;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.ad5;
import com.baidu.tieba.b05;
import com.baidu.tieba.b0b;
import com.baidu.tieba.b26;
import com.baidu.tieba.bd5;
import com.baidu.tieba.de5;
import com.baidu.tieba.ev9;
import com.baidu.tieba.jv7;
import com.baidu.tieba.ke5;
import com.baidu.tieba.lc5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nd5;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sh;
import com.baidu.tieba.tja;
import com.baidu.tieba.tu5;
import com.baidu.tieba.uja;
import com.baidu.tieba.uu5;
import com.baidu.tieba.v36;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.xw8;
import com.baidu.tieba.yc5;
import com.baidu.tieba.zc5;
import com.baidu.tieba.zj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Random;
/* loaded from: classes7.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public static final Runnable notifyRunnable;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public ke5 mModel;
    public Runnable mRunnable;
    public c mSyncTask;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<String, Integer, ke5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ TiebaSyncService b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ke5 a;
            public final /* synthetic */ c b;

            public a(c cVar, ke5 ke5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, ke5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = ke5Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.d(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921815));
                    } catch (Exception e) {
                        DefaultLog.getInstance().e("TiebaSyncService$SyncAsyncTask dispatch error", e.getMessage());
                        new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "syncDispatchError").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("cuid", TbadkCoreApplication.getInst().getCuid()).eventStat();
                    }
                }
            }
        }

        public c(TiebaSyncService tiebaSyncService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaSyncService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tiebaSyncService;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ke5 ke5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ke5Var) == null) {
                super.onPostExecute(ke5Var);
                IdleHandlerManager.getInstance().addOrRunTask(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, new a(this, ke5Var));
            }
        }

        public /* synthetic */ c(TiebaSyncService tiebaSyncService, a aVar) {
            this(tiebaSyncService);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ke5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (ke5) invokeL.objValue;
            }
            this.b.statisticForAdvert("advert_before_sync");
            ke5 ke5Var = null;
            try {
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                if (ev9.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                    this.a.addPostData("brand", Build.BRAND);
                    this.a.addPostData("model", DeviceInfoHelper.getModel());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, ev9.c());
                    String g = ev9.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, ev9.j());
                    }
                    String g2 = ev9.g("brand");
                    if (!TextUtils.isEmpty(g2)) {
                        this.a.addPostData(g2, ev9.e());
                    }
                    String g3 = ev9.g("model");
                    if (!TextUtils.isEmpty(g3)) {
                        this.a.addPostData(g3, ev9.h());
                    }
                }
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(BdUtilHelper.getEquipmentHeight(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(BdUtilHelper.getEquipmentWidth(app)));
                this.a.addPostData("scr_h", String.valueOf(BdUtilHelper.getEquipmentHeight(app)));
                this.a.addPostData("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(app)));
                String str2 = "0";
                if (de5.d().f() > 0) {
                    this.a.addPostData("_msg_status", "0");
                } else {
                    this.a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str2 = activeVersion;
                    }
                    this.a.addPostData("_active", str2);
                }
                this.a.addPostData("_pic_quality", String.valueOf(b05.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork = this.a;
                netWork.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, v36.a());
                NetWork netWork2 = this.a;
                String str3 = "64";
                if (sh.a()) {
                    str = "64";
                } else {
                    str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork2.addPostData("running_abi", str);
                NetWork netWork3 = this.a;
                if (!sh.b()) {
                    str3 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork3.addPostData("support_abi", str3);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    ke5 ke5Var2 = new ke5();
                    try {
                        ke5Var2.C(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && ke5Var2.i().a() != null && ke5Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, ke5Var2.i().a());
                            TbadkCoreApplication.setClientId(ke5Var2.i().a());
                        }
                        if (ke5Var2.l() != null) {
                            SharedPrefHelper.getInstance().putInt("crash_limit_count", ke5Var2.l().b());
                        }
                        sb5 e = ke5Var2.e();
                        if (ke5Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            SharedPrefHelper.getInstance().putString("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(ke5Var2.t());
                        e();
                        String unused = TiebaSyncService.mStatistics = null;
                        zj.a().i(Config.DEVICE_PART, "sync success");
                        return ke5Var2;
                    } catch (Exception e2) {
                        e = e2;
                        ke5Var = ke5Var2;
                        BdLog.detailException(e);
                        TbLog a2 = zj.a();
                        a2.e(Config.DEVICE_PART, "sync exception: " + e.getMessage());
                        return ke5Var;
                    }
                }
                zj.a().e(Config.DEVICE_PART, "sync fail");
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        public void d(ke5 ke5Var) {
            boolean z;
            String str;
            String str2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, ke5Var) != null) {
                return;
            }
            this.b.mSyncTask = null;
            if (ke5Var != null) {
                uu5.j().x();
                this.b.mModel = ke5Var;
                b26.b(this.b.mModel.h());
                this.b.onPostExecuteUpdateData();
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (1 == this.b.mModel.q()) {
                    z = true;
                } else {
                    z = false;
                }
                inst.setIsNoInterestTag(z);
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.b.mModel.o());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.b.mModel.p());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String z2 = this.b.mModel.z();
                if (!StringUtils.isNull(z2)) {
                    TbadkCoreApplication.getInst().setConfigVersion(z2);
                }
                this.b.onPostExecuteConfigData();
                this.b.onPostExecuteWlConfigData();
                this.b.onPostExecuteProfilData();
                this.b.onPostExecuteYYConfigData();
                this.b.onPostExecuteYYLiveTabConfigData();
                if (this.b.mModel.r() != null) {
                    TbSingleton.getInstance().setNewGodData(this.b.mModel.r());
                }
                if (this.b.mModel.g() != null) {
                    TbSingleton.getInstance().setAdVertiSementData(this.b.mModel.g());
                }
                if (this.b.mModel.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(this.b.mModel.e());
                }
                if (this.b.mModel.d() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(this.b.mModel.d());
                }
                if (this.b.mModel.a() != null) {
                    tu5.d().e(this.b.mModel.a());
                }
                if (this.b.mModel.b() != null) {
                    tu5.d().f(this.b.mModel.b());
                }
                ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.t());
                jv7.e().k(this.b.mModel.m());
                TbSingleton.getInstance().setAdFloatViewData(this.b.mModel.f());
                TbSingleton.getInstance().setHotNotifyConfig(this.b.mModel.n());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                String str3 = "";
                if (this.b.mModel.w() == null) {
                    str = "";
                } else {
                    str = this.b.mModel.w().N();
                }
                syncDataEvent.sampleId = str;
                if (this.b.mModel.t() != null) {
                    str2 = this.b.mModel.t().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = this.b.mModel.b();
                syncDataEvent.userGrowthTaskListData = this.b.mModel.u();
                syncDataEvent.profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                syncDataEvent.themeIsBlack = SharedPrefHelper.getInstance().getInt(WindowGreySwitch.KEY_SWITCH, 0);
                syncDataEvent.switches = SwitchManager.getInstance().getBaseSwitchs();
                if (this.b.mModel.w() != null) {
                    i = this.b.mModel.w().d();
                } else {
                    i = 0;
                }
                syncDataEvent.aiAvailableStatus = i;
                if (this.b.mModel.k() != null) {
                    str3 = this.b.mModel.k().a();
                }
                syncDataEvent.aiWriteScheme = str3;
                if (PraiseSwitch.isOn()) {
                    syncDataEvent.praiseSwitch = 1;
                } else {
                    syncDataEvent.praiseSwitch = 0;
                }
                MutiProcessManager.publishEvent(syncDataEvent);
                IdleHandlerManager.getInstance().addOrRunTask("sync_finish", TiebaSyncService.notifyRunnable);
                this.b.statisticForAdvert("advert_after_sync");
                this.b.stopSelf();
                return;
            }
            TiebaSyncService.access$1308(this.b);
            if (this.b.mHaveRetry < 10) {
                this.b.mHandler.removeCallbacks(this.b.mRunnable);
                this.b.mHandler.postDelayed(this.b.mRunnable, 60000L);
                return;
            }
            this.b.stopSelf();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.mSyncTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        public final void e() {
            zc5 b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                yc5 mainTabPopConfig = TbSingleton.getInstance().getMainTabPopConfig();
                if (mainTabPopConfig != null && (b2 = mainTabPopConfig.b("source_from_theme")) != null && SharedPrefHelper.getInstance().getInt("setThemeSuit", 0) >= JavaTypesHelper.toInt(b2.c(), 0)) {
                    DefaultLog.getInstance().i("MainTabTip", "首页引导展示sync判断不展示：source_from_theme");
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921802, "source_from_theme");
                    MessageManager.getInstance().registerStickyMode(2921802);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                SafeHandler.getInst().post(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaSyncService a;

        public a(TiebaSyncService tiebaSyncService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaSyncService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaSyncService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.checkUpdata();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607503544, "Lcom/baidu/tieba/service/TiebaSyncService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-607503544, "Lcom/baidu/tieba/service/TiebaSyncService;");
                return;
            }
        }
        notifyRunnable = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            c cVar = this.mSyncTask;
            if (cVar != null) {
                cVar.cancel();
            }
            c cVar2 = new c(this, null);
            this.mSyncTask = cVar2;
            cVar2.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYConfigData() {
        YYLiveConfig x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && (x = this.mModel.x()) != null) {
            TbSingleton.getInstance().setYYLiveConfig(x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYLiveTabConfigData() {
        b0b y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && (y = this.mModel.y()) != null) {
            TbSingleton.getInstance().setYYLiveTabConfig(y);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.mSyncTask;
            if (cVar != null) {
                cVar.cancel();
            }
            this.mHaveRetry = 11;
            this.mHandler.removeCallbacks(this.mRunnable);
            super.onDestroy();
        }
    }

    public TiebaSyncService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSyncTask = null;
        this.mHaveRetry = 0;
        this.mModel = null;
        this.mHandler = new Handler();
        this.mRunnable = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        bd5 s;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (s = this.mModel.s()) != null) {
            String b2 = s.b();
            long c2 = s.c();
            long a2 = s.a();
            SharedPrefHelper.getInstance().putString("sync_send_maintab_my_tab_lottie_url", b2);
            SharedPrefHelper.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", c2);
            SharedPrefHelper.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", a2);
        }
    }

    public static /* synthetic */ int access$1308(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        return i;
    }

    public static void setMsgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            mStatistics = str;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, intent, i) == null) {
            super.onStart(intent, i);
            this.mHaveRetry = 0;
            checkUpdata();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        lc5 l;
        int performSampleCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && (l = this.mModel.l()) != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int d = l.d();
            if (d > 0 && nextInt % d == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (l.e() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(l.e().a());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(l.c());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if (!PermissionUtil.isBrowseMode()) {
                xw8.b().a(false);
            }
            VersionData v = this.mModel.v();
            if (v != null && v.hasNewVer() && TbConfig.COULD_UPDATE) {
                if (TbSingleton.getInstance().isSplashShowing()) {
                    tja.c().e(this.mModel);
                } else {
                    uja.b(this.mModel);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        nd5 w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && (w = this.mModel.w()) != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(w.c());
            TbadkCoreApplication.getInst().getListItemRule().f(w.A());
            TbadkCoreApplication.getInst().getListItemRule().e(w.v());
            TbadkCoreApplication.getInst().getListItemRule().d(w.u());
            TbadkCoreApplication.getInst().setUseNewResign(w.G());
            TbadkCoreApplication.getInst().setUegVoiceWarning(w.T());
            PullViewHelper.getInstance().saveOrUpdateImages(w.p(), w.q(), w.r(), w.n(), w.o());
            String g = w.g();
            SharedPrefHelper.getInstance().putInt("key_fps_time", w.s());
            SharedPrefHelper.getInstance().putInt("key_switch_immediately_upload", w.Q());
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            if (g == null) {
                g = "";
            }
            sharedPrefHelper.putString("apply_vip_live_room_pid", g);
            SharedPrefHelper.getInstance().putString("tail_link", w.S());
            SharedPrefHelper.getInstance().putString("bubble_link", w.j());
            long Z = w.Z();
            if (Z >= 0 && Z != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(w.Z());
            }
            long i = w.i() * 1000;
            if (i > 0) {
                SharedPrefHelper.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", i);
            } else {
                long F = w.F() * 1000;
                if (F > 0) {
                    SharedPrefHelper.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", F);
                }
            }
            SharedPrefHelper.getInstance().putLong("recommend_frs_cache_time", w.J());
            SharedPrefHelper.getInstance().putInt("home_page_max_thread_count", w.w());
            SharedPrefHelper.getInstance().putBoolean("localvideo_open", w.z());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            SharedPrefHelper.getInstance().putInt("card_show_statistic_max_count", w.u);
            SharedPrefHelper.getInstance().putString("nick_name_activity_link", w.H());
            String string = SharedPrefHelper.getInstance().getString("clean_smart_frs_cookie", "");
            String k = w.k();
            if (!TextUtils.equals(string, k)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            SharedPrefHelper.getInstance().putString("clean_smart_frs_cookie", k);
            SharedPrefHelper.getInstance().putInt("recommend_tab_show", w.f());
            SharedPrefHelper.getInstance().putInt("ribao_switch", w.M());
            SharedPrefHelper.getInstance().putInt("key_upload_pic_max_width", w.X());
            SharedPrefHelper.getInstance().putInt("key_upload_pic_max_height", w.W());
            SharedPrefHelper.getInstance().putInt("key_upload_pic_parallel_count", w.Y());
            SharedPrefHelper.getInstance().putInt("key_upload_pic_chunk_size", w.V());
            SharedPrefHelper.getInstance().putInt("key_upload_pic_chunk_retry", w.U());
            TbConfig.setMaxPhotoMemoryCache(w.K());
            SharedPrefHelper.getInstance().putInt("key_card_show_type", w.R());
            TbadkCoreApplication.getInst().setCardShowType(w.R());
            SharedPrefHelper.getInstance().putInt("key_card_abstract_switch", w.b());
            TbadkCoreApplication.getInst().setInterestBoardConfigData(w.x());
            ad5 E = w.E();
            if (E != null) {
                SharedPrefHelper.getInstance().putBoolean("nani_key_is_show_download_nani_panel", E.a);
                SharedPrefHelper.getInstance().putBoolean("nani_key_is_activate_app", E.b);
                SharedPrefHelper.getInstance().putInt("nani_key_download_show_position", E.c);
                SharedPrefHelper.getInstance().putInt("nani_key_download_show_rate", E.d);
                SharedPrefHelper.getInstance().putString("nani_key_download_link_url", E.e);
                SharedPrefHelper.getInstance().putString("nani_key_download_txt", E.f);
                SharedPrefHelper.getInstance().putString("nani_key_show_tail_txt", E.g);
                SharedPrefHelper.getInstance().putInt("nani_key_show_tail_video_type", E.h);
                SharedPrefHelper.getInstance().putString("nani_key_show_tail_txt", E.g);
                SharedPrefHelper.getInstance().putString("nani_key_pre_h5_link", E.i);
            }
            if (w.O() != null) {
                TbSingleton.getInstance().setShakeData(w.O());
            }
            if (!TextUtils.isEmpty(w.P())) {
                TbSingleton.getInstance().setSharePanelText(w.P());
            }
            SharedPrefHelper.getInstance().putLong("key_frs_cache_time", w.t() * 1000);
            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
            boolean z = true;
            if (w.h() != 1) {
                z = false;
            }
            sharedPrefHelper2.putBoolean("key_baidu_id_cookie_switch", z);
            TbSingleton.getInstance().setPushDialogLoopTime(w.l());
            TbSingleton.getInstance().setPushDialogShowTime(w.m());
            TbSingleton.getInstance().setCanShowPermDlg(w.a());
            TbSingleton.getInstance().setAuditPackageSwitch(w.f0());
            TbSingleton.getInstance().setProfileGameCenterKey(w.L());
            TbSingleton.getInstance().setMissionEntranceUrl(w.D());
            TbSingleton.getInstance().setMissionEntranceIcon(w.B());
            TbSingleton.getInstance().setMissionEntranceObjSource(w.C());
            TbSingleton.getInstance().setWalletSignLink(w.c0());
            TbSingleton.getInstance().setSampleId(w.N());
            TbSingleton.getInstance().setBaiduidCookieSwitch(w.h());
            TbSingleton.getInstance().setLiveForumMap(w.y());
            TbSingleton.getInstance().setClipboardDelayTime(w.e());
            TbSingleton.getInstance().setVideoRedIconInterval(w.b0());
            TbSingleton.getInstance().setWorksAddTopicMaxNum(w.d0());
            if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725));
            VideoPreloadData a0 = w.a0();
            if (a0 != null) {
                TbConfig.PREFETCH_NEXT_VIDEO_SIZE = a0.getVideoSize();
                TbConfig.PREFETCH_NEXT_VIDEO_NUM = a0.getVideoNum();
            }
            TbSingleton.getInstance().setWorldCupSponsorFlag(w.e0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticForAdvert(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("ad_sdk_priority", Integer.valueOf(SharedPrefHelper.getInstance().getInt("splash_ad_strategy_key", 0)));
            logItem.append("bear_sid_type", Integer.valueOf(SharedPrefHelper.getInstance().getInt("splash_bear_sid_type_key", 0)));
            logItem.append("ubs", SharedPrefHelper.getInstance().getString(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, logItem);
        }
    }
}
