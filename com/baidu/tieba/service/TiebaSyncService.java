package com.baidu.tieba.service;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.ABTestSwitchManager;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.aw4;
import com.baidu.tieba.c75;
import com.baidu.tieba.e85;
import com.baidu.tieba.ej;
import com.baidu.tieba.gj;
import com.baidu.tieba.gu7;
import com.baidu.tieba.gw5;
import com.baidu.tieba.k65;
import com.baidu.tieba.k67;
import com.baidu.tieba.lh;
import com.baidu.tieba.lh5;
import com.baidu.tieba.m85;
import com.baidu.tieba.mu5;
import com.baidu.tieba.nc;
import com.baidu.tieba.p35;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.r75;
import com.baidu.tieba.s75;
import com.baidu.tieba.sn5;
import com.baidu.tieba.sn9;
import com.baidu.tieba.ti;
import com.baidu.tieba.tk5;
import com.baidu.tieba.tn5;
import com.baidu.tieba.u85;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Date;
import java.util.Random;
/* loaded from: classes6.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public u85 mModel;
    public Runnable mRunnable;
    public b mSyncTask;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-607503544, "Lcom/baidu/tieba/service/TiebaSyncService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-607503544, "Lcom/baidu/tieba/service/TiebaSyncService;");
        }
    }

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
    public class b extends BdAsyncTask<String, Integer, u85> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ TiebaSyncService b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
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

        public b(TiebaSyncService tiebaSyncService) {
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

        public /* synthetic */ b(TiebaSyncService tiebaSyncService, a aVar) {
            this(tiebaSyncService);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public u85 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.b.statisticForAdvert("advert_before_sync");
                u85 u85Var = null;
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    this.a = netWork;
                    netWork.addPostData("_os_version", gj.k());
                    this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                    this.a.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                    this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                    this.a.addPostData("model", gj.g());
                    Application app = TbadkCoreApplication.getInst().getApp();
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(ej.l(app)));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(ej.j(app)));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    this.a.addPostData("scr_w", String.valueOf(ej.l(app)));
                    this.a.addPostData("scr_h", String.valueOf(ej.j(app)));
                    this.a.addPostData("scr_dip", String.valueOf(ej.i(app)));
                    String str2 = "0";
                    if (m85.d().f() > 0) {
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
                    this.a.addPostData("_pic_quality", String.valueOf(aw4.c().e()));
                    if (TiebaSyncService.mStatistics != null) {
                        this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                    }
                    String packageName = TbadkCoreApplication.getInst().getPackageName();
                    this.a.addPostData("package", packageName);
                    int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                    NetWork netWork2 = this.a;
                    netWork2.addPostData("versioncode", versionCode + "");
                    this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                    this.a.addPostData(PackageTable.MD5, gw5.a());
                    NetWork netWork3 = this.a;
                    String str3 = "64";
                    if (ti.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("running_abi", str);
                    NetWork netWork4 = this.a;
                    if (!ti.b()) {
                        str3 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork4.addPostData("support_abi", str3);
                    String postNetData = this.a.postNetData();
                    if (this.a.isNetSuccess()) {
                        TbadkCoreApplication.getInst().clearActiveVersion();
                    }
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    u85 u85Var2 = new u85();
                    try {
                        u85Var2.B(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && u85Var2.i().a() != null && u85Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, u85Var2.i().a());
                            TbadkCoreApplication.setClientId(u85Var2.i().a());
                        }
                        if (u85Var2.k() != null) {
                            p35.m().z("crash_limit_count", u85Var2.k().b());
                        }
                        k65 e = u85Var2.e();
                        if (u85Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            p35.m().B("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(u85Var2.s());
                        String unused = TiebaSyncService.mStatistics = null;
                        return u85Var2;
                    } catch (Exception e2) {
                        e = e2;
                        u85Var = u85Var2;
                        BdLog.detailException(e);
                        return u85Var;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (u85) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u85 u85Var) {
            boolean z;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u85Var) == null) {
                super.onPostExecute(u85Var);
                this.b.mSyncTask = null;
                if (u85Var != null) {
                    tn5.j().x();
                    this.b.mModel = u85Var;
                    mu5.b(this.b.mModel.h());
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
                        sn5.d().e(this.b.mModel.a());
                    }
                    if (this.b.mModel.b() != null) {
                        sn5.d().f(this.b.mModel.b());
                    }
                    ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                    UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.s());
                    k67.e().k(this.b.mModel.l());
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
                    syncDataEvent.themeIsBlack = p35.m().n(WindowGreySwitch.KEY_SWITCH, 0);
                    if (PraiseSwitch.isOn()) {
                        syncDataEvent.praiseSwitch = 1;
                    } else {
                        syncDataEvent.praiseSwitch = 0;
                    }
                    lh5.i(syncDataEvent);
                    if (LooperBlockSwitch.getIsOn()) {
                        nc.b().a("sync_finish", new a(this));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                    }
                    this.b.statisticForAdvert("advert_after_sync");
                    this.b.stopSelf();
                    return;
                }
                TiebaSyncService.access$1208(this.b);
                if (this.b.mHaveRetry < 10) {
                    this.b.mHandler.removeCallbacks(this.b.mRunnable);
                    this.b.mHandler.postDelayed(this.b.mRunnable, 60000L);
                    return;
                }
                this.b.stopSelf();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.mSyncTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.checkUpdata();
            }
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
        s75 r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (r = this.mModel.r()) != null) {
            String b2 = r.b();
            long c = r.c();
            long a2 = r.a();
            p35.m().B("sync_send_maintab_my_tab_lottie_url", b2);
            p35.m().A("sync_send_maintab_my_tab_lottie_start_time", c);
            p35.m().A("sync_send_maintab_my_tab_lottie_end_time", a2);
        }
    }

    public static /* synthetic */ int access$1208(TiebaSyncService tiebaSyncService) {
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

    private void broadcastNewVersion() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65555, this) != null) || this.mModel == null) {
            return;
        }
        TbadkCoreApplication.getInst().refreshNewVersion(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            b bVar = this.mSyncTask;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.mSyncTask = bVar2;
            bVar2.execute(new String[0]);
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
        sn9 x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && (x = this.mModel.x()) != null) {
            TbSingleton.getInstance().setYYLiveTabConfig(x);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            b bVar = this.mSyncTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mHaveRetry = 11;
            this.mHandler.removeCallbacks(this.mRunnable);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        c75 k;
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
                gu7.b().a(false);
            }
            VersionData u = this.mModel.u();
            if (u != null && u.hasNewVer() && TbConfig.COULD_UPDATE) {
                TbadkCoreApplication.getInst().setVersionData(u);
                broadcastNewVersion();
                if (u.forceUpdate()) {
                    if (this.mModel.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                        TbSingleton.getInstance();
                        TbSingleton.setExceptInsertAdDiaShow(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), u, this.mModel.j())));
                        return;
                    }
                    return;
                }
                Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                Long valueOf2 = Long.valueOf(new Date().getTime());
                if (valueOf2.longValue() - valueOf.longValue() > 86400000 && u.getStrategy() == 0 && this.mModel.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    TbSingleton.getInstance().setSyncModel(this.mModel);
                    if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                        TbSingleton.getInstance();
                        TbSingleton.setExceptInsertAdDiaShow(true);
                        gw5.d();
                    }
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        e85 v;
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
            p35.m().z("key_fps_time", v.r());
            p35.m().z("key_switch_immediately_upload", v.P());
            p35 m = p35.m();
            if (f == null) {
                f = "";
            }
            m.B("apply_vip_live_room_pid", f);
            p35.m().B("tail_link", v.R());
            p35.m().B("bubble_link", v.i());
            long Y = v.Y();
            if (Y >= 0 && Y != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(v.Y());
            }
            long h = v.h() * 1000;
            if (h > 0) {
                p35.m().A("KEY_UPLOAD_LOG_INTERVAL", h);
            } else {
                long E = v.E() * 1000;
                if (E > 0) {
                    p35.m().A("KEY_UPLOAD_LOG_INTERVAL", E);
                }
            }
            p35.m().A("recommend_frs_cache_time", v.I());
            p35.m().z("home_page_max_thread_count", v.v());
            p35.m().w("localvideo_open", v.y());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            p35.m().z("card_show_statistic_max_count", v.u);
            p35.m().B("nick_name_activity_link", v.G());
            String s = p35.m().s("clean_smart_frs_cookie", "");
            String j = v.j();
            if (!TextUtils.equals(s, j)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            p35.m().B("clean_smart_frs_cookie", j);
            p35.m().z("recommend_tab_show", v.e());
            p35.m().z("ribao_switch", v.L());
            p35.m().z("key_upload_pic_max_width", v.W());
            p35.m().z("key_upload_pic_max_height", v.V());
            p35.m().z("key_upload_pic_parallel_count", v.X());
            p35.m().z("key_upload_pic_chunk_size", v.U());
            p35.m().z("key_upload_pic_chunk_retry", v.T());
            TbConfig.setMaxPhotoMemoryCache(v.J());
            p35.m().z("key_card_show_type", v.Q());
            TbadkCoreApplication.getInst().setCardShowType(v.Q());
            p35.m().z("key_card_abstract_switch", v.b());
            TbadkCoreApplication.getInst().setInterestBoardConfigData(v.w());
            r75 D = v.D();
            if (D != null) {
                p35.m().w("nani_key_is_show_download_nani_panel", D.a);
                p35.m().w("nani_key_is_activate_app", D.b);
                p35.m().z("nani_key_download_show_position", D.c);
                p35.m().z("nani_key_download_show_rate", D.d);
                p35.m().B("nani_key_download_link_url", D.e);
                p35.m().B("nani_key_download_txt", D.f);
                p35.m().B("nani_key_show_tail_txt", D.g);
                p35.m().z("nani_key_show_tail_video_type", D.h);
                p35.m().B("nani_key_show_tail_txt", D.g);
                p35.m().B("nani_key_pre_h5_link", D.i);
            }
            if (v.N() != null) {
                TbSingleton.getInstance().setShakeData(v.N());
            }
            if (!TextUtils.isEmpty(v.O())) {
                TbSingleton.getInstance().setSharePanelText(v.O());
            }
            p35.m().A("key_frs_cache_time", v.s() * 1000);
            p35 m2 = p35.m();
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
            lh a2 = tk5.a();
            a2.c("ad_sdk_priority", Integer.valueOf(p35.m().n("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(p35.m().n("splash_bear_sid_type_key", 0)));
            a2.b("ubs", p35.m().s(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
