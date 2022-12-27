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
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.aj;
import com.baidu.tieba.br5;
import com.baidu.tieba.by6;
import com.baidu.tieba.de9;
import com.baidu.tieba.dr4;
import com.baidu.tieba.e25;
import com.baidu.tieba.fh;
import com.baidu.tieba.h35;
import com.baidu.tieba.hp5;
import com.baidu.tieba.m15;
import com.baidu.tieba.mc5;
import com.baidu.tieba.ni;
import com.baidu.tieba.p35;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.ry4;
import com.baidu.tieba.si5;
import com.baidu.tieba.tf5;
import com.baidu.tieba.ti5;
import com.baidu.tieba.u25;
import com.baidu.tieba.v25;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.x35;
import com.baidu.tieba.yi;
import com.baidu.tieba.zk7;
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
    public x35 mModel;
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

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, x35> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ TiebaSyncService b;

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
        public x35 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.b.statisticForAdvert("advert_before_sync");
                x35 x35Var = null;
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                    this.a = netWork;
                    netWork.addPostData("_os_version", aj.k());
                    this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                    this.a.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                    this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                    this.a.addPostData("model", aj.g());
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
                    if (p35.d().f() > 0) {
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
                    this.a.addPostData("_pic_quality", String.valueOf(dr4.c().e()));
                    if (TiebaSyncService.mStatistics != null) {
                        this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                    }
                    String packageName = TbadkCoreApplication.getInst().getPackageName();
                    this.a.addPostData("package", packageName);
                    int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                    NetWork netWork2 = this.a;
                    netWork2.addPostData("versioncode", versionCode + "");
                    this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                    this.a.addPostData(PackageTable.MD5, br5.a());
                    NetWork netWork3 = this.a;
                    String str3 = "64";
                    if (ni.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("running_abi", str);
                    NetWork netWork4 = this.a;
                    if (!ni.b()) {
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
                    x35 x35Var2 = new x35();
                    try {
                        x35Var2.B(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && x35Var2.i().a() != null && x35Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, x35Var2.i().a());
                            TbadkCoreApplication.setClientId(x35Var2.i().a());
                        }
                        if (x35Var2.k() != null) {
                            ry4.l().x("crash_limit_count", x35Var2.k().b());
                        }
                        m15 e = x35Var2.e();
                        if (x35Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            ry4.l().z("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(x35Var2.s());
                        String unused = TiebaSyncService.mStatistics = null;
                        return x35Var2;
                    } catch (Exception e2) {
                        e = e2;
                        x35Var = x35Var2;
                        BdLog.detailException(e);
                        return x35Var;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                return (x35) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(x35 x35Var) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x35Var) == null) {
                super.onPostExecute(x35Var);
                this.b.mSyncTask = null;
                if (x35Var != null) {
                    ti5.j().x();
                    this.b.mModel = x35Var;
                    hp5.b(this.b.mModel.h());
                    this.b.onPostExecuteUpdateData();
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    boolean z = true;
                    if (1 != this.b.mModel.p()) {
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
                        si5.d().e(this.b.mModel.a());
                    }
                    if (this.b.mModel.b() != null) {
                        si5.d().f(this.b.mModel.b());
                    }
                    ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                    UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.s());
                    by6.e().k(this.b.mModel.l());
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
                    syncDataEvent.themeIsBlack = ry4.l().m(WindowGreySwitch.KEY_SWITCH, 0);
                    mc5.i(syncDataEvent);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
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
        v25 r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (r = this.mModel.r()) != null) {
            String b2 = r.b();
            long c = r.c();
            long a2 = r.a();
            ry4.l().z("sync_send_maintab_my_tab_lottie_url", b2);
            ry4.l().y("sync_send_maintab_my_tab_lottie_start_time", c);
            ry4.l().y("sync_send_maintab_my_tab_lottie_end_time", a2);
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
        de9 x;
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
        e25 k;
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
                zk7.b().a(false);
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
                        br5.d();
                    }
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        h35 v;
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
            ry4.l().x("key_fps_time", v.r());
            ry4.l().x("key_switch_immediately_upload", v.P());
            ry4 l = ry4.l();
            if (f == null) {
                f = "";
            }
            l.z("apply_vip_live_room_pid", f);
            ry4.l().z("tail_link", v.R());
            ry4.l().z("bubble_link", v.i());
            long Y = v.Y();
            if (Y >= 0 && Y != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(v.Y());
            }
            long h = v.h() * 1000;
            if (h > 0) {
                ry4.l().y("KEY_UPLOAD_LOG_INTERVAL", h);
            } else {
                long E = v.E() * 1000;
                if (E > 0) {
                    ry4.l().y("KEY_UPLOAD_LOG_INTERVAL", E);
                }
            }
            ry4.l().y("recommend_frs_cache_time", v.I());
            ry4.l().x("home_page_max_thread_count", v.v());
            ry4.l().v("localvideo_open", v.y());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            ry4.l().x("card_show_statistic_max_count", v.u);
            ry4.l().z("nick_name_activity_link", v.G());
            String r = ry4.l().r("clean_smart_frs_cookie", "");
            String j = v.j();
            if (!TextUtils.equals(r, j)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            ry4.l().z("clean_smart_frs_cookie", j);
            ry4.l().x("recommend_tab_show", v.e());
            ry4.l().x("ribao_switch", v.L());
            ry4.l().x("key_upload_pic_max_width", v.W());
            ry4.l().x("key_upload_pic_max_height", v.V());
            ry4.l().x("key_upload_pic_parallel_count", v.X());
            ry4.l().x("key_upload_pic_chunk_size", v.U());
            ry4.l().x("key_upload_pic_chunk_retry", v.T());
            TbConfig.setMaxPhotoMemoryCache(v.J());
            ry4.l().x("key_card_show_type", v.Q());
            TbadkCoreApplication.getInst().setCardShowType(v.Q());
            ry4.l().x("key_card_abstract_switch", v.b());
            TbadkCoreApplication.getInst().setInterestBoardConfigData(v.w());
            u25 D = v.D();
            if (D != null) {
                ry4.l().v("nani_key_is_show_download_nani_panel", D.a);
                ry4.l().v("nani_key_is_activate_app", D.b);
                ry4.l().x("nani_key_download_show_position", D.c);
                ry4.l().x("nani_key_download_show_rate", D.d);
                ry4.l().z("nani_key_download_link_url", D.e);
                ry4.l().z("nani_key_download_txt", D.f);
                ry4.l().z("nani_key_show_tail_txt", D.g);
                ry4.l().x("nani_key_show_tail_video_type", D.h);
                ry4.l().z("nani_key_show_tail_txt", D.g);
                ry4.l().z("nani_key_pre_h5_link", D.i);
            }
            if (v.N() != null) {
                TbSingleton.getInstance().setShakeData(v.N());
            }
            if (!TextUtils.isEmpty(v.O())) {
                TbSingleton.getInstance().setSharePanelText(v.O());
            }
            ry4.l().y("key_frs_cache_time", v.s() * 1000);
            ry4 l2 = ry4.l();
            boolean z = true;
            if (v.g() != 1) {
                z = false;
            }
            l2.v("key_baidu_id_cookie_switch", z);
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
            fh a2 = tf5.a();
            a2.c("ad_sdk_priority", Integer.valueOf(ry4.l().m("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(ry4.l().m("splash_bear_sid_type_key", 0)));
            a2.b("ubs", ry4.l().r(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
