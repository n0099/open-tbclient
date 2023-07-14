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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.a15;
import com.baidu.tieba.aj;
import com.baidu.tieba.ay7;
import com.baidu.tieba.az8;
import com.baidu.tieba.bc;
import com.baidu.tieba.da5;
import com.baidu.tieba.ed5;
import com.baidu.tieba.eh;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fu5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.h29;
import com.baidu.tieba.ke5;
import com.baidu.tieba.le5;
import com.baidu.tieba.lw9;
import com.baidu.tieba.me5;
import com.baidu.tieba.n66;
import com.baidu.tieba.ne5;
import com.baidu.tieba.ni;
import com.baidu.tieba.nka;
import com.baidu.tieba.oka;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pf5;
import com.baidu.tieba.t46;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.wd5;
import com.baidu.tieba.wg;
import com.baidu.tieba.wq5;
import com.baidu.tieba.x0b;
import com.baidu.tieba.yf5;
import com.baidu.tieba.yi;
import com.baidu.tieba.yk;
import com.baidu.tieba.ze5;
import com.baidu.tieba.zg;
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
    public yf5 mModel;
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
    public class c extends BdAsyncTask<String, Integer, yf5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ TiebaSyncService b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yf5 a;
            public final /* synthetic */ c b;

            public a(c cVar, yf5 yf5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, yf5Var};
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
                this.a = yf5Var;
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
                        DefaultLog.getInstance().b("TiebaSyncService$SyncAsyncTask dispatch error", e.getMessage());
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
        public void onPostExecute(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yf5Var) == null) {
                super.onPostExecute(yf5Var);
                bc.b().a(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, new a(this, yf5Var));
            }
        }

        public /* synthetic */ c(TiebaSyncService tiebaSyncService, a aVar) {
            this(tiebaSyncService);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public yf5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (yf5) invokeL.objValue;
            }
            this.b.statisticForAdvert("advert_before_sync");
            yf5 yf5Var = null;
            try {
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                if (lw9.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, aj.k());
                    this.a.addPostData("brand", Build.BRAND);
                    this.a.addPostData("model", aj.g());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, lw9.c());
                    String g = lw9.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, lw9.j());
                    }
                    String g2 = lw9.g("brand");
                    if (!TextUtils.isEmpty(g2)) {
                        this.a.addPostData(g2, lw9.e());
                    }
                    String g3 = lw9.g("model");
                    if (!TextUtils.isEmpty(g3)) {
                        this.a.addPostData(g3, lw9.h());
                    }
                }
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(yi.l(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(yi.j(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(yi.l(app)));
                this.a.addPostData("scr_h", String.valueOf(yi.j(app)));
                this.a.addPostData("scr_dip", String.valueOf(yi.i(app)));
                String str2 = "0";
                if (pf5.d().f() > 0) {
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
                this.a.addPostData("_pic_quality", String.valueOf(a15.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork = this.a;
                netWork.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, n66.a());
                NetWork netWork2 = this.a;
                String str3 = "64";
                if (ni.a()) {
                    str = "64";
                } else {
                    str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork2.addPostData("running_abi", str);
                NetWork netWork3 = this.a;
                if (!ni.b()) {
                    str3 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork3.addPostData("support_abi", str3);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    yf5 yf5Var2 = new yf5();
                    try {
                        yf5Var2.B(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && yf5Var2.i().a() != null && yf5Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, yf5Var2.i().a());
                            TbadkCoreApplication.setClientId(yf5Var2.i().a());
                        }
                        if (yf5Var2.k() != null) {
                            da5.p().F("crash_limit_count", yf5Var2.k().b());
                        }
                        ed5 e = yf5Var2.e();
                        if (yf5Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            da5.p().J("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(yf5Var2.s());
                        e();
                        String unused = TiebaSyncService.mStatistics = null;
                        yk.a().c(Config.DEVICE_PART, "sync success");
                        return yf5Var2;
                    } catch (Exception e2) {
                        e = e2;
                        yf5Var = yf5Var2;
                        BdLog.detailException(e);
                        h29 a2 = yk.a();
                        a2.b(Config.DEVICE_PART, "sync exception: " + e.getMessage());
                        return yf5Var;
                    }
                }
                yk.a().b(Config.DEVICE_PART, "sync fail");
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        public void d(yf5 yf5Var) {
            boolean z;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, yf5Var) != null) {
                return;
            }
            this.b.mSyncTask = null;
            if (yf5Var != null) {
                fx5.j().x();
                this.b.mModel = yf5Var;
                t46.b(this.b.mModel.h());
                this.b.onPostExecuteUpdateData();
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (1 == this.b.mModel.p()) {
                    z = true;
                } else {
                    z = false;
                }
                inst.setIsNoInterestTag(z);
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.b.mModel.n());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.b.mModel.o());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String y = this.b.mModel.y();
                if (!StringUtils.isNull(y)) {
                    TbadkCoreApplication.getInst().setConfigVersion(y);
                }
                this.b.onPostExecuteConfigData();
                this.b.onPostExecuteWlConfigData();
                this.b.onPostExecuteProfilData();
                this.b.onPostExecuteYYConfigData();
                this.b.onPostExecuteYYLiveTabConfigData();
                if (this.b.mModel.q() != null) {
                    TbSingleton.getInstance().setNewGodData(this.b.mModel.q());
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
                    ex5.d().e(this.b.mModel.a());
                }
                if (this.b.mModel.b() != null) {
                    ex5.d().f(this.b.mModel.b());
                }
                ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.s());
                ay7.e().k(this.b.mModel.l());
                TbSingleton.getInstance().setAdFloatViewData(this.b.mModel.f());
                TbSingleton.getInstance().setHotNotifyConfig(this.b.mModel.m());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (this.b.mModel.v() != null) {
                    str = this.b.mModel.v().M();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (this.b.mModel.s() != null) {
                    str2 = this.b.mModel.s().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = this.b.mModel.b();
                syncDataEvent.userGrowthTaskListData = this.b.mModel.t();
                syncDataEvent.profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                syncDataEvent.themeIsBlack = da5.p().q(WindowGreySwitch.KEY_SWITCH, 0);
                syncDataEvent.switches = SwitchManager.getInstance().getBaseSwitchs();
                if (PraiseSwitch.isOn()) {
                    syncDataEvent.praiseSwitch = 1;
                } else {
                    syncDataEvent.praiseSwitch = 0;
                }
                wq5.i(syncDataEvent);
                bc.b().a("sync_finish", TiebaSyncService.notifyRunnable);
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
            le5 b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                ke5 mainTabPopConfig = TbSingleton.getInstance().getMainTabPopConfig();
                if (mainTabPopConfig != null && (b2 = mainTabPopConfig.b("source_from_theme")) != null && da5.p().q("setThemeSuit", 0) >= wg.e(b2.c(), 0)) {
                    DefaultLog.getInstance().c("MainTabTip", "首页引导展示sync判断不展示：source_from_theme");
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921802, "source_from_theme");
                    MessageManager.getInstance().registerStickyMode(2921802);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                zg.a().post(new b(this));
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
        YYLiveConfig w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && (w = this.mModel.w()) != null) {
            TbSingleton.getInstance().setYYLiveConfig(w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYLiveTabConfigData() {
        x0b x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && (x = this.mModel.x()) != null) {
            TbSingleton.getInstance().setYYLiveTabConfig(x);
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
        ne5 r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (r = this.mModel.r()) != null) {
            String b2 = r.b();
            long c2 = r.c();
            long a2 = r.a();
            da5.p().J("sync_send_maintab_my_tab_lottie_url", b2);
            da5.p().H("sync_send_maintab_my_tab_lottie_start_time", c2);
            da5.p().H("sync_send_maintab_my_tab_lottie_end_time", a2);
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
        wd5 k;
        int performSampleCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && (k = this.mModel.k()) != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int d = k.d();
            if (d > 0 && nextInt % d == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (k.e() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(k.e().a());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(k.c());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if (!PermissionUtil.isBrowseMode()) {
                az8.b().a(false);
            }
            VersionData u = this.mModel.u();
            if (u != null && u.hasNewVer() && TbConfig.COULD_UPDATE) {
                if (TbSingleton.getInstance().isSplashShowing()) {
                    nka.c().e(this.mModel);
                } else {
                    oka.b(this.mModel);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ze5 v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && (v = this.mModel.v()) != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(v.c());
            TbadkCoreApplication.getInst().getListItemRule().f(v.z());
            TbadkCoreApplication.getInst().getListItemRule().e(v.u());
            TbadkCoreApplication.getInst().getListItemRule().d(v.t());
            TbadkCoreApplication.getInst().setUseNewResign(v.F());
            TbadkCoreApplication.getInst().setUegVoiceWarning(v.S());
            PullViewHelper.getInstance().saveOrUpdateImages(v.o(), v.p(), v.q(), v.m(), v.n());
            String f = v.f();
            da5.p().F("key_fps_time", v.r());
            da5.p().F("key_switch_immediately_upload", v.P());
            da5 p = da5.p();
            if (f == null) {
                f = "";
            }
            p.J("apply_vip_live_room_pid", f);
            da5.p().J("tail_link", v.R());
            da5.p().J("bubble_link", v.i());
            long Y = v.Y();
            if (Y >= 0 && Y != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(v.Y());
            }
            long h = v.h() * 1000;
            if (h > 0) {
                da5.p().H("KEY_UPLOAD_LOG_INTERVAL", h);
            } else {
                long E = v.E() * 1000;
                if (E > 0) {
                    da5.p().H("KEY_UPLOAD_LOG_INTERVAL", E);
                }
            }
            da5.p().H("recommend_frs_cache_time", v.I());
            da5.p().F("home_page_max_thread_count", v.v());
            da5.p().A("localvideo_open", v.y());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            da5.p().F("card_show_statistic_max_count", v.u);
            da5.p().J("nick_name_activity_link", v.G());
            String w = da5.p().w("clean_smart_frs_cookie", "");
            String j = v.j();
            if (!TextUtils.equals(w, j)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            da5.p().J("clean_smart_frs_cookie", j);
            da5.p().F("recommend_tab_show", v.e());
            da5.p().F("ribao_switch", v.L());
            da5.p().F("key_upload_pic_max_width", v.W());
            da5.p().F("key_upload_pic_max_height", v.V());
            da5.p().F("key_upload_pic_parallel_count", v.X());
            da5.p().F("key_upload_pic_chunk_size", v.U());
            da5.p().F("key_upload_pic_chunk_retry", v.T());
            TbConfig.setMaxPhotoMemoryCache(v.J());
            da5.p().F("key_card_show_type", v.Q());
            TbadkCoreApplication.getInst().setCardShowType(v.Q());
            da5.p().F("key_card_abstract_switch", v.b());
            TbadkCoreApplication.getInst().setInterestBoardConfigData(v.w());
            me5 D = v.D();
            if (D != null) {
                da5.p().A("nani_key_is_show_download_nani_panel", D.a);
                da5.p().A("nani_key_is_activate_app", D.b);
                da5.p().F("nani_key_download_show_position", D.c);
                da5.p().F("nani_key_download_show_rate", D.d);
                da5.p().J("nani_key_download_link_url", D.e);
                da5.p().J("nani_key_download_txt", D.f);
                da5.p().J("nani_key_show_tail_txt", D.g);
                da5.p().F("nani_key_show_tail_video_type", D.h);
                da5.p().J("nani_key_show_tail_txt", D.g);
                da5.p().J("nani_key_pre_h5_link", D.i);
            }
            if (v.N() != null) {
                TbSingleton.getInstance().setShakeData(v.N());
            }
            if (!TextUtils.isEmpty(v.O())) {
                TbSingleton.getInstance().setSharePanelText(v.O());
            }
            da5.p().H("key_frs_cache_time", v.s() * 1000);
            da5 p2 = da5.p();
            boolean z = true;
            if (v.g() != 1) {
                z = false;
            }
            p2.A("key_baidu_id_cookie_switch", z);
            TbSingleton.getInstance().setPushDialogLoopTime(v.k());
            TbSingleton.getInstance().setPushDialogShowTime(v.l());
            TbSingleton.getInstance().setCanShowPermDlg(v.a());
            TbSingleton.getInstance().setAuditPackageSwitch(v.e0());
            TbSingleton.getInstance().setProfileGameCenterKey(v.K());
            TbSingleton.getInstance().setMissionEntranceUrl(v.C());
            TbSingleton.getInstance().setMissionEntranceIcon(v.A());
            TbSingleton.getInstance().setMissionEntranceObjSource(v.B());
            TbSingleton.getInstance().setWalletSignLink(v.b0());
            TbSingleton.getInstance().setSampleId(v.M());
            TbSingleton.getInstance().setBaiduidCookieSwitch(v.g());
            TbSingleton.getInstance().setLiveForumMap(v.x());
            TbSingleton.getInstance().setClipboardDelayTime(v.d());
            TbSingleton.getInstance().setVideoRedIconInterval(v.a0());
            TbSingleton.getInstance().setWorksAddTopicMaxNum(v.c0());
            if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725));
            VideoPreloadData Z = v.Z();
            if (Z != null) {
                TbConfig.PREFETCH_NEXT_VIDEO_SIZE = Z.getVideoSize();
                TbConfig.PREFETCH_NEXT_VIDEO_NUM = Z.getVideoNum();
            }
            TbSingleton.getInstance().setWorldCupSponsorFlag(v.d0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticForAdvert(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            eh a2 = fu5.a();
            a2.c("ad_sdk_priority", Integer.valueOf(da5.p().q("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(da5.p().q("splash_bear_sid_type_key", 0)));
            a2.b("ubs", da5.p().w(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
