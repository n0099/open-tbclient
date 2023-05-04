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
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.ax9;
import com.baidu.tieba.b85;
import com.baidu.tieba.dj8;
import com.baidu.tieba.dq5;
import com.baidu.tieba.en5;
import com.baidu.tieba.eq5;
import com.baidu.tieba.f55;
import com.baidu.tieba.fc9;
import com.baidu.tieba.fm7;
import com.baidu.tieba.ga5;
import com.baidu.tieba.gg;
import com.baidu.tieba.h95;
import com.baidu.tieba.i95;
import com.baidu.tieba.ii;
import com.baidu.tieba.ik;
import com.baidu.tieba.iw4;
import com.baidu.tieba.j95;
import com.baidu.tieba.k95;
import com.baidu.tieba.ki;
import com.baidu.tieba.kz5;
import com.baidu.tieba.oa5;
import com.baidu.tieba.og;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.qb;
import com.baidu.tieba.qx5;
import com.baidu.tieba.t85;
import com.baidu.tieba.vj5;
import com.baidu.tieba.w95;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.wf8;
import com.baidu.tieba.xca;
import com.baidu.tieba.xh;
import com.baidu.tieba.zw9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Random;
/* loaded from: classes6.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public static final Runnable notifyRunnable;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public oa5 mModel;
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

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<String, Integer, oa5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ TiebaSyncService b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oa5 a;
            public final /* synthetic */ c b;

            public a(c cVar, oa5 oa5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, oa5Var};
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
                this.a = oa5Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.d(this.a);
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
        public void onPostExecute(oa5 oa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oa5Var) == null) {
                super.onPostExecute(oa5Var);
                qb.b().a(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, new a(this, oa5Var));
            }
        }

        public /* synthetic */ c(TiebaSyncService tiebaSyncService, a aVar) {
            this(tiebaSyncService);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public oa5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (oa5) invokeL.objValue;
            }
            this.b.statisticForAdvert("advert_before_sync");
            oa5 oa5Var = null;
            try {
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                if (fc9.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, ki.k());
                    this.a.addPostData("brand", Build.BRAND);
                    this.a.addPostData("model", ki.g());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, fc9.c());
                    String g = fc9.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, fc9.j());
                    }
                    String g2 = fc9.g("brand");
                    if (!TextUtils.isEmpty(g2)) {
                        this.a.addPostData(g2, fc9.e());
                    }
                    String g3 = fc9.g("model");
                    if (!TextUtils.isEmpty(g3)) {
                        this.a.addPostData(g3, fc9.h());
                    }
                }
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(ii.l(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(ii.j(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(ii.l(app)));
                this.a.addPostData("scr_h", String.valueOf(ii.j(app)));
                this.a.addPostData("scr_dip", String.valueOf(ii.i(app)));
                String str2 = "0";
                if (ga5.d().f() > 0) {
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
                this.a.addPostData("_pic_quality", String.valueOf(iw4.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork = this.a;
                netWork.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, kz5.a());
                NetWork netWork2 = this.a;
                String str3 = "64";
                if (xh.a()) {
                    str = "64";
                } else {
                    str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork2.addPostData("running_abi", str);
                NetWork netWork3 = this.a;
                if (!xh.b()) {
                    str3 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                netWork3.addPostData("support_abi", str3);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    oa5 oa5Var2 = new oa5();
                    try {
                        oa5Var2.B(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && oa5Var2.i().a() != null && oa5Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, oa5Var2.i().a());
                            TbadkCoreApplication.setClientId(oa5Var2.i().a());
                        }
                        if (oa5Var2.k() != null) {
                            f55.m().z("crash_limit_count", oa5Var2.k().b());
                        }
                        b85 e = oa5Var2.e();
                        if (oa5Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            f55.m().B("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(oa5Var2.s());
                        e();
                        String unused = TiebaSyncService.mStatistics = null;
                        ik.a().c(Config.DEVICE_PART, "sync success");
                        return oa5Var2;
                    } catch (Exception e2) {
                        e = e2;
                        oa5Var = oa5Var2;
                        BdLog.detailException(e);
                        dj8 a2 = ik.a();
                        a2.b(Config.DEVICE_PART, "sync exception: " + e.getMessage());
                        return oa5Var;
                    }
                }
                ik.a().b(Config.DEVICE_PART, "sync fail");
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        public void d(oa5 oa5Var) {
            boolean z;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, oa5Var) != null) {
                return;
            }
            this.b.mSyncTask = null;
            if (oa5Var != null) {
                eq5.j().x();
                this.b.mModel = oa5Var;
                qx5.b(this.b.mModel.h());
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
                    dq5.d().e(this.b.mModel.a());
                }
                if (this.b.mModel.b() != null) {
                    dq5.d().f(this.b.mModel.b());
                }
                ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.s());
                fm7.e().k(this.b.mModel.l());
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
                syncDataEvent.themeIsBlack = f55.m().n(WindowGreySwitch.KEY_SWITCH, 0);
                syncDataEvent.switches = SwitchManager.getInstance().getBaseSwitchs();
                if (PraiseSwitch.isOn()) {
                    syncDataEvent.praiseSwitch = 1;
                } else {
                    syncDataEvent.praiseSwitch = 0;
                }
                vj5.i(syncDataEvent);
                qb.b().a("sync_finish", TiebaSyncService.notifyRunnable);
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
            h95 mainTabPopConfig;
            i95 b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (mainTabPopConfig = TbSingleton.getInstance().getMainTabPopConfig()) != null && (b = mainTabPopConfig.b("source_from_theme")) != null && f55.m().n("setThemeSuit", 0) >= gg.e(b.c(), 0)) {
                DefaultLog.getInstance().c("MainTabTip", "首页引导展示sync判断不展示：source_from_theme");
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921802, "source_from_theme");
                MessageManager.getInstance().registerStickyMode(2921802);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
        xca x;
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
        k95 r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (r = this.mModel.r()) != null) {
            String b2 = r.b();
            long c2 = r.c();
            long a2 = r.a();
            f55.m().B("sync_send_maintab_my_tab_lottie_url", b2);
            f55.m().A("sync_send_maintab_my_tab_lottie_start_time", c2);
            f55.m().A("sync_send_maintab_my_tab_lottie_end_time", a2);
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
        t85 k;
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
                wf8.b().a(false);
            }
            VersionData u = this.mModel.u();
            if (u != null && u.hasNewVer() && TbConfig.COULD_UPDATE) {
                if (TbSingleton.getInstance().isSplashShowing()) {
                    zw9.c().e(this.mModel);
                } else {
                    ax9.b(this.mModel);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        w95 v;
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
            f55.m().z("key_fps_time", v.r());
            f55.m().z("key_switch_immediately_upload", v.P());
            f55 m = f55.m();
            if (f == null) {
                f = "";
            }
            m.B("apply_vip_live_room_pid", f);
            f55.m().B("tail_link", v.R());
            f55.m().B("bubble_link", v.i());
            long Y = v.Y();
            if (Y >= 0 && Y != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(v.Y());
            }
            long h = v.h() * 1000;
            if (h > 0) {
                f55.m().A("KEY_UPLOAD_LOG_INTERVAL", h);
            } else {
                long E = v.E() * 1000;
                if (E > 0) {
                    f55.m().A("KEY_UPLOAD_LOG_INTERVAL", E);
                }
            }
            f55.m().A("recommend_frs_cache_time", v.I());
            f55.m().z("home_page_max_thread_count", v.v());
            f55.m().w("localvideo_open", v.y());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            f55.m().z("card_show_statistic_max_count", v.u);
            f55.m().B("nick_name_activity_link", v.G());
            String s = f55.m().s("clean_smart_frs_cookie", "");
            String j = v.j();
            if (!TextUtils.equals(s, j)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            f55.m().B("clean_smart_frs_cookie", j);
            f55.m().z("recommend_tab_show", v.e());
            f55.m().z("ribao_switch", v.L());
            f55.m().z("key_upload_pic_max_width", v.W());
            f55.m().z("key_upload_pic_max_height", v.V());
            f55.m().z("key_upload_pic_parallel_count", v.X());
            f55.m().z("key_upload_pic_chunk_size", v.U());
            f55.m().z("key_upload_pic_chunk_retry", v.T());
            TbConfig.setMaxPhotoMemoryCache(v.J());
            f55.m().z("key_card_show_type", v.Q());
            TbadkCoreApplication.getInst().setCardShowType(v.Q());
            f55.m().z("key_card_abstract_switch", v.b());
            TbadkCoreApplication.getInst().setInterestBoardConfigData(v.w());
            j95 D = v.D();
            if (D != null) {
                f55.m().w("nani_key_is_show_download_nani_panel", D.a);
                f55.m().w("nani_key_is_activate_app", D.b);
                f55.m().z("nani_key_download_show_position", D.c);
                f55.m().z("nani_key_download_show_rate", D.d);
                f55.m().B("nani_key_download_link_url", D.e);
                f55.m().B("nani_key_download_txt", D.f);
                f55.m().B("nani_key_show_tail_txt", D.g);
                f55.m().z("nani_key_show_tail_video_type", D.h);
                f55.m().B("nani_key_show_tail_txt", D.g);
                f55.m().B("nani_key_pre_h5_link", D.i);
            }
            if (v.N() != null) {
                TbSingleton.getInstance().setShakeData(v.N());
            }
            if (!TextUtils.isEmpty(v.O())) {
                TbSingleton.getInstance().setSharePanelText(v.O());
            }
            f55.m().A("key_frs_cache_time", v.s() * 1000);
            f55 m2 = f55.m();
            boolean z = true;
            if (v.g() != 1) {
                z = false;
            }
            m2.w("key_baidu_id_cookie_switch", z);
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
            og a2 = en5.a();
            a2.c("ad_sdk_priority", Integer.valueOf(f55.m().n("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(f55.m().n("splash_bear_sid_type_key", 0)));
            a2.b("ubs", f55.m().s(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
