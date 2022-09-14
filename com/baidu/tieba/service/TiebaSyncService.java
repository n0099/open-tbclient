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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.ABTestSwitchManager;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ao5;
import com.baidu.tieba.bx4;
import com.baidu.tieba.c15;
import com.baidu.tieba.d15;
import com.baidu.tieba.dg5;
import com.baidu.tieba.ed5;
import com.baidu.tieba.eg5;
import com.baidu.tieba.ej;
import com.baidu.tieba.f25;
import com.baidu.tieba.gf7;
import com.baidu.tieba.gj;
import com.baidu.tieba.hm5;
import com.baidu.tieba.lh;
import com.baidu.tieba.ou6;
import com.baidu.tieba.p05;
import com.baidu.tieba.p15;
import com.baidu.tieba.r79;
import com.baidu.tieba.ti;
import com.baidu.tieba.up4;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.x15;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.Date;
import java.util.Random;
/* loaded from: classes5.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public f25 mModel;
    public Runnable mRunnable;
    public b mSyncTask;

    /* loaded from: classes5.dex */
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

    public static /* synthetic */ int access$1208(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        return i;
    }

    private void broadcastNewVersion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || this.mModel == null) {
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
    public void onPostExecuteConfigData() {
        p05 k;
        int performSampleCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (k = this.mModel.k()) == null) {
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        d15 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (q = this.mModel.q()) == null) {
            return;
        }
        String b2 = q.b();
        long c = q.c();
        long a2 = q.a();
        bx4.k().y("sync_send_maintab_my_tab_lottie_url", b2);
        bx4.k().x("sync_send_maintab_my_tab_lottie_start_time", c);
        bx4.k().x("sync_send_maintab_my_tab_lottie_end_time", a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            gf7.b().a(false);
            VersionData t = this.mModel.t();
            if (t != null && t.hasNewVer() && TbConfig.COULD_UPDATE) {
                TbadkCoreApplication.getInst().setVersionData(t);
                broadcastNewVersion();
                if (t.forceUpdate()) {
                    if (this.mModel.k() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                        return;
                    }
                    TbSingleton.getInstance();
                    TbSingleton.setExceptInsertAdDiaShow(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), t, this.mModel.j())));
                    return;
                }
                Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                Long valueOf2 = Long.valueOf(new Date().getTime());
                if (valueOf2.longValue() - valueOf.longValue() <= 86400000 || t.getStrategy() != 0 || this.mModel.k() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                    return;
                }
                TbSingleton.getInstance().setSyncModel(this.mModel);
                if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                    TbSingleton.getInstance();
                    TbSingleton.setExceptInsertAdDiaShow(true);
                    ao5.d();
                }
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        p15 u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (u = this.mModel.u()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(u.c());
        TbadkCoreApplication.getInst().getListItemRule().f(u.z());
        TbadkCoreApplication.getInst().getListItemRule().e(u.u());
        TbadkCoreApplication.getInst().getListItemRule().d(u.t());
        TbadkCoreApplication.getInst().setUseNewResign(u.F());
        TbadkCoreApplication.getInst().setUegVoiceWarning(u.S());
        PullViewHelper.getInstance().saveOrUpdateImages(u.o(), u.p(), u.q(), u.m(), u.n());
        String f = u.f();
        bx4.k().w("key_fps_time", u.r());
        bx4.k().w("key_switch_immediately_upload", u.P());
        bx4 k = bx4.k();
        if (f == null) {
            f = "";
        }
        k.y("apply_vip_live_room_pid", f);
        bx4.k().y("tail_link", u.R());
        bx4.k().y("bubble_link", u.i());
        long Y = u.Y();
        if (Y >= 0 && Y != TbadkCoreApplication.getInst().getUseTimeInterval()) {
            TbadkCoreApplication.getInst().setUseTimeInterval(u.Y());
        }
        long h = u.h() * 1000;
        if (h > 0) {
            bx4.k().x("KEY_UPLOAD_LOG_INTERVAL", h);
        } else {
            long E = u.E() * 1000;
            if (E > 0) {
                bx4.k().x("KEY_UPLOAD_LOG_INTERVAL", E);
            }
        }
        bx4.k().x("recommend_frs_cache_time", u.I());
        bx4.k().w("home_page_max_thread_count", u.v());
        bx4.k().u("localvideo_open", u.y());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
        bx4.k().w("card_show_statistic_max_count", u.u);
        bx4.k().y("nick_name_activity_link", u.G());
        String q = bx4.k().q("clean_smart_frs_cookie", "");
        String j = u.j();
        if (!TextUtils.equals(q, j)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
        }
        bx4.k().y("clean_smart_frs_cookie", j);
        bx4.k().w("recommend_tab_show", u.e());
        bx4.k().w("ribao_switch", u.L());
        bx4.k().w("key_upload_pic_max_width", u.W());
        bx4.k().w("key_upload_pic_max_height", u.V());
        bx4.k().w("key_upload_pic_parallel_count", u.X());
        bx4.k().w("key_upload_pic_chunk_size", u.U());
        bx4.k().w("key_upload_pic_chunk_retry", u.T());
        TbConfig.setMaxPhotoMemoryCache(u.J());
        bx4.k().w("key_card_show_type", u.Q());
        TbadkCoreApplication.getInst().setCardShowType(u.Q());
        bx4.k().w("key_card_abstract_switch", u.b());
        TbadkCoreApplication.getInst().setInterestBoardConfigData(u.w());
        c15 D = u.D();
        if (D != null) {
            bx4.k().u("nani_key_is_show_download_nani_panel", D.a);
            bx4.k().u("nani_key_is_activate_app", D.b);
            bx4.k().w("nani_key_download_show_position", D.c);
            bx4.k().w("nani_key_download_show_rate", D.d);
            bx4.k().y("nani_key_download_link_url", D.e);
            bx4.k().y("nani_key_download_txt", D.f);
            bx4.k().y("nani_key_show_tail_txt", D.g);
            bx4.k().w("nani_key_show_tail_video_type", D.h);
            bx4.k().y("nani_key_show_tail_txt", D.g);
            bx4.k().y("nani_key_pre_h5_link", D.i);
        }
        if (u.N() != null) {
            TbSingleton.getInstance().setShakeData(u.N());
        }
        if (!TextUtils.isEmpty(u.O())) {
            TbSingleton.getInstance().setSharePanelText(u.O());
        }
        bx4.k().x("key_frs_cache_time", u.s() * 1000);
        bx4.k().u("key_baidu_id_cookie_switch", u.g() == 1);
        TbSingleton.getInstance().setPushDialogLoopTime(u.k());
        TbSingleton.getInstance().setPushDialogShowTime(u.l());
        TbSingleton.getInstance().setCanShowPermDlg(u.a());
        TbSingleton.getInstance().setAuditPackageSwitch(u.d0());
        TbSingleton.getInstance().setProfileGameCenterKey(u.K());
        TbSingleton.getInstance().setMissionEntranceUrl(u.C());
        TbSingleton.getInstance().setMissionEntranceIcon(u.A());
        TbSingleton.getInstance().setMissionEntranceObjSource(u.B());
        TbSingleton.getInstance().setWalletSignLink(u.b0());
        TbSingleton.getInstance().setSampleId(u.M());
        TbSingleton.getInstance().setBaiduidCookieSwitch(u.g());
        TbSingleton.getInstance().setLiveForumMap(u.x());
        TbSingleton.getInstance().setClipboardDelayTime(u.d());
        TbSingleton.getInstance().setVideoRedIconInterval(u.a0());
        TbSingleton.getInstance().setWorksAddTopicMaxNum(u.c0());
        if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725));
        VideoPreloadData Z = u.Z();
        if (Z != null) {
            TbConfig.PREFETCH_NEXT_VIDEO_SIZE = Z.getVideoSize();
            TbConfig.PREFETCH_NEXT_VIDEO_NUM = Z.getVideoNum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYConfigData() {
        YYLiveConfig v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (v = this.mModel.v()) == null) {
            return;
        }
        TbSingleton.getInstance().setYYLiveConfig(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYLiveTabConfigData() {
        r79 w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (w = this.mModel.w()) == null) {
            return;
        }
        TbSingleton.getInstance().setYYLiveTabConfig(w);
    }

    public static void setMsgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            mStatistics = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticForAdvert(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            lh a2 = ed5.a();
            a2.c("ad_sdk_priority", Integer.valueOf(bx4.k().l("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(bx4.k().l("splash_bear_sid_type_key", 0)));
            a2.b("ubs", bx4.k().q(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
            BdStatisticsManager.getInstance().debug(str, a2);
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
            b bVar = this.mSyncTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mHaveRetry = 11;
            this.mHandler.removeCallbacks(this.mRunnable);
            super.onDestroy();
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

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, f25> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f25 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (f25) invokeL.objValue;
            }
            this.b.statisticForAdvert("advert_before_sync");
            f25 f25Var = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/sync");
                this.a = netWork;
                netWork.addPostData("_os_version", gj.k());
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.a.addPostData("model", gj.g());
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(ej.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(ej.i(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(ej.k(app)));
                this.a.addPostData("scr_h", String.valueOf(ej.i(app)));
                this.a.addPostData("scr_dip", String.valueOf(ej.h(app)));
                String str = "0";
                if (x15.d().f() > 0) {
                    this.a.addPostData("_msg_status", "0");
                } else {
                    this.a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str = activeVersion;
                    }
                    this.a.addPostData("_active", str);
                }
                this.a.addPostData("_pic_quality", String.valueOf(up4.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, ao5.a());
                NetWork netWork3 = this.a;
                boolean a = ti.a();
                String str2 = WebKitFactory.OS_64;
                netWork3.addPostData("running_abi", a ? WebKitFactory.OS_64 : "32");
                NetWork netWork4 = this.a;
                if (!ti.b()) {
                    str2 = "32";
                }
                netWork4.addPostData("support_abi", str2);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    f25 f25Var2 = new f25();
                    try {
                        f25Var2.A(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && f25Var2.i().a() != null && f25Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, f25Var2.i().a());
                            TbadkCoreApplication.setClientId(f25Var2.i().a());
                        }
                        if (f25Var2.k() != null) {
                            bx4.k().w("crash_limit_count", f25Var2.k().b());
                        }
                        yz4 e = f25Var2.e();
                        if (f25Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            bx4.k().y("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(f25Var2.r());
                        String unused = TiebaSyncService.mStatistics = null;
                        return f25Var2;
                    } catch (Exception e2) {
                        e = e2;
                        f25Var = f25Var2;
                        BdLog.detailException(e);
                        return f25Var;
                    }
                }
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f25 f25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f25Var) == null) {
                super.onPostExecute(f25Var);
                this.b.mSyncTask = null;
                if (f25Var != null) {
                    eg5.j().x();
                    this.b.mModel = f25Var;
                    hm5.b(this.b.mModel.h());
                    this.b.onPostExecuteUpdateData();
                    TbadkCoreApplication.getInst().setIsNoInterestTag(1 == this.b.mModel.o());
                    TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.b.mModel.m());
                    TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.b.mModel.n());
                    TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                    String x = this.b.mModel.x();
                    if (!StringUtils.isNull(x)) {
                        TbadkCoreApplication.getInst().setConfigVersion(x);
                    }
                    this.b.onPostExecuteConfigData();
                    this.b.onPostExecuteWlConfigData();
                    this.b.onPostExecuteProfilData();
                    this.b.onPostExecuteYYConfigData();
                    this.b.onPostExecuteYYLiveTabConfigData();
                    if (this.b.mModel.p() != null) {
                        TbSingleton.getInstance().setNewGodData(this.b.mModel.p());
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
                        dg5.d().e(this.b.mModel.a());
                    }
                    if (this.b.mModel.b() != null) {
                        dg5.d().f(this.b.mModel.b());
                    }
                    ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                    UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.r());
                    ou6.e().k(this.b.mModel.l());
                    TbSingleton.getInstance().setAdFloatViewData(this.b.mModel.f());
                    SyncDataEvent syncDataEvent = new SyncDataEvent();
                    syncDataEvent.sampleId = this.b.mModel.u() != null ? this.b.mModel.u().M() : "";
                    syncDataEvent.ubsABTest = this.b.mModel.r() != null ? this.b.mModel.r().toString() : "[]";
                    syncDataEvent.abtestExtraData = this.b.mModel.b();
                    syncDataEvent.userGrowthTaskListData = this.b.mModel.s();
                    aa5.i(syncDataEvent);
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
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.mSyncTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        public /* synthetic */ b(TiebaSyncService tiebaSyncService, a aVar) {
            this(tiebaSyncService);
        }
    }
}
