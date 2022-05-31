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
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.repackage.a55;
import com.repackage.am4;
import com.repackage.aw4;
import com.repackage.ax4;
import com.repackage.c85;
import com.repackage.eb5;
import com.repackage.eg5;
import com.repackage.ex4;
import com.repackage.fb5;
import com.repackage.fz8;
import com.repackage.kv4;
import com.repackage.li;
import com.repackage.mx4;
import com.repackage.nw4;
import com.repackage.ow4;
import com.repackage.qp6;
import com.repackage.rg;
import com.repackage.wh5;
import com.repackage.x97;
import com.repackage.ys4;
import com.repackage.zh;
import java.util.Date;
import java.util.Random;
/* loaded from: classes3.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public mx4 mModel;
    public Runnable mRunnable;
    public b mSyncTask;

    /* loaded from: classes3.dex */
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
        aw4 k;
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
        ow4 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (q = this.mModel.q()) == null) {
            return;
        }
        String b2 = q.b();
        long c = q.c();
        long a2 = q.a();
        ys4.k().y("sync_send_maintab_my_tab_lottie_url", b2);
        ys4.k().x("sync_send_maintab_my_tab_lottie_start_time", c);
        ys4.k().x("sync_send_maintab_my_tab_lottie_end_time", a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            x97.b().a(false);
            VersionData s = this.mModel.s();
            if (s != null && s.hasNewVer() && TbConfig.COULD_UPDATE) {
                TbadkCoreApplication.getInst().setVersionData(s);
                broadcastNewVersion();
                if (s.forceUpdate()) {
                    if (this.mModel.k() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                        return;
                    }
                    TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), s, this.mModel.j())));
                    return;
                }
                Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                Long valueOf2 = Long.valueOf(new Date().getTime());
                if (valueOf2.longValue() - valueOf.longValue() <= 86400000 || s.getStrategy() != 0 || this.mModel.k() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                    return;
                }
                TbSingleton.getInstance().setSyncModel(this.mModel);
                if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                    TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
                    wh5.d();
                }
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ax4 t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (t = this.mModel.t()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(t.c());
        TbadkCoreApplication.getInst().getListItemRule().f(t.z());
        TbadkCoreApplication.getInst().getListItemRule().e(t.u());
        TbadkCoreApplication.getInst().getListItemRule().d(t.t());
        TbadkCoreApplication.getInst().setUseNewResign(t.F());
        TbadkCoreApplication.getInst().setUegVoiceWarning(t.S());
        TbadkCoreApplication.getInst().setUrlText(t.Y());
        PullViewHelper.getInstance().saveOrUpdateImages(t.o(), t.p(), t.q(), t.m(), t.n());
        String f = t.f();
        ys4.k().w("key_fps_time", t.r());
        ys4.k().w("key_switch_immediately_upload", t.P());
        ys4 k = ys4.k();
        if (f == null) {
            f = "";
        }
        k.y("apply_vip_live_room_pid", f);
        ys4.k().y("tail_link", t.R());
        ys4.k().y("bubble_link", t.i());
        long Z = t.Z();
        if (Z >= 0 && Z != TbadkCoreApplication.getInst().getUseTimeInterval()) {
            TbadkCoreApplication.getInst().setUseTimeInterval(t.Z());
        }
        long h = t.h() * 1000;
        if (h > 0) {
            ys4.k().x("KEY_UPLOAD_LOG_INTERVAL", h);
        } else {
            long E = t.E() * 1000;
            if (E > 0) {
                ys4.k().x("KEY_UPLOAD_LOG_INTERVAL", E);
            }
        }
        ys4.k().x("recommend_frs_cache_time", t.I());
        ys4.k().w("home_page_max_thread_count", t.v());
        ys4.k().u("localvideo_open", t.y());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
        ys4.k().w("card_show_statistic_max_count", t.u);
        ys4.k().y("nick_name_activity_link", t.G());
        String q = ys4.k().q("clean_smart_frs_cookie", "");
        String j = t.j();
        if (!TextUtils.equals(q, j)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
        }
        ys4.k().y("clean_smart_frs_cookie", j);
        ys4.k().w("recommend_tab_show", t.e());
        ys4.k().w("ribao_switch", t.L());
        ys4.k().w("key_upload_pic_max_width", t.W());
        ys4.k().w("key_upload_pic_max_height", t.V());
        ys4.k().w("key_upload_pic_parallel_count", t.X());
        ys4.k().w("key_upload_pic_chunk_size", t.U());
        ys4.k().w("key_upload_pic_chunk_retry", t.T());
        TbConfig.setMaxPhotoMemoryCache(t.J());
        ys4.k().w("key_card_show_type", t.Q());
        TbadkCoreApplication.getInst().setCardShowType(t.Q());
        ys4.k().w("key_card_abstract_switch", t.b());
        TbadkCoreApplication.getInst().setInterestBoardConfigData(t.w());
        nw4 D = t.D();
        if (D != null) {
            ys4.k().u("nani_key_is_show_download_nani_panel", D.a);
            ys4.k().u("nani_key_is_activate_app", D.b);
            ys4.k().w("nani_key_download_show_position", D.c);
            ys4.k().w("nani_key_download_show_rate", D.d);
            ys4.k().y("nani_key_download_link_url", D.e);
            ys4.k().y("nani_key_download_txt", D.f);
            ys4.k().y("nani_key_show_tail_txt", D.g);
            ys4.k().w("nani_key_show_tail_video_type", D.h);
            ys4.k().y("nani_key_show_tail_txt", D.g);
            ys4.k().y("nani_key_pre_h5_link", D.i);
        }
        if (t.N() != null) {
            TbSingleton.getInstance().setShakeData(t.N());
        }
        if (!TextUtils.isEmpty(t.O())) {
            TbSingleton.getInstance().setSharePanelText(t.O());
        }
        ys4.k().x("key_frs_cache_time", t.s() * 1000);
        ys4.k().u("key_baidu_id_cookie_switch", t.g() == 1);
        TbSingleton.getInstance().setPushDialogLoopTime(t.k());
        TbSingleton.getInstance().setPushDialogShowTime(t.l());
        TbSingleton.getInstance().setCanShowPermDlg(t.a());
        TbSingleton.getInstance().setAuditPackageSwitch(t.e0());
        TbSingleton.getInstance().setProfileGameCenterKey(t.K());
        TbSingleton.getInstance().setMissionEntranceUrl(t.C());
        TbSingleton.getInstance().setMissionEntranceIcon(t.A());
        TbSingleton.getInstance().setMissionEntranceObjSource(t.B());
        TbSingleton.getInstance().setWalletSignLink(t.c0());
        TbSingleton.getInstance().setSampleId(t.M());
        TbSingleton.getInstance().setBaiduidCookieSwitch(t.g());
        TbSingleton.getInstance().setLiveForumMap(t.x());
        TbSingleton.getInstance().setClipboardDelayTime(t.d());
        TbSingleton.getInstance().setVideoRedIconInterval(t.b0());
        TbSingleton.getInstance().setWorksAddTopicMaxNum(t.d0());
        if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
        }
        VideoPreloadData a0 = t.a0();
        if (a0 != null) {
            TbConfig.PREFETCH_NEXT_VIDEO_SIZE = a0.getVideoSize();
            TbConfig.PREFETCH_NEXT_VIDEO_NUM = a0.getVideoNum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYConfigData() {
        YYLiveConfig u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (u = this.mModel.u()) == null) {
            return;
        }
        TbSingleton.getInstance().setYYLiveConfig(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYLiveTabConfigData() {
        fz8 v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (v = this.mModel.v()) == null) {
            return;
        }
        TbSingleton.getInstance().setYYLiveTabConfig(v);
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
            rg a2 = c85.a();
            a2.c("ad_sdk_priority", Integer.valueOf(ys4.k().l("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(ys4.k().l("splash_bear_sid_type_key", 0)));
            a2.b("ubs", ys4.k().q(UbsABTestDataManager.getSharedPrefKeyForUbsABTest(), null));
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

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, mx4> {
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
        public mx4 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (mx4) invokeL.objValue;
            }
            this.b.statisticForAdvert("advert_before_sync");
            mx4 mx4Var = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.a = netWork;
                netWork.addPostData("_os_version", Build.VERSION.RELEASE);
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.a.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(li.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(li.i(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(li.k(app)));
                this.a.addPostData("scr_h", String.valueOf(li.i(app)));
                this.a.addPostData("scr_dip", String.valueOf(li.h(app)));
                String str = "0";
                if (ex4.d().f() > 0) {
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
                this.a.addPostData("_pic_quality", String.valueOf(am4.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, wh5.a());
                NetWork netWork3 = this.a;
                boolean a = zh.a();
                String str2 = WebKitFactory.OS_64;
                netWork3.addPostData("running_abi", a ? WebKitFactory.OS_64 : "32");
                NetWork netWork4 = this.a;
                if (!zh.b()) {
                    str2 = "32";
                }
                netWork4.addPostData("support_abi", str2);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    mx4 mx4Var2 = new mx4();
                    try {
                        mx4Var2.z(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && mx4Var2.i().a() != null && mx4Var2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.b, mx4Var2.i().a());
                            TbadkCoreApplication.setClientId(mx4Var2.i().a());
                        }
                        if (mx4Var2.k() != null) {
                            ys4.k().w("crash_limit_count", mx4Var2.k().b());
                        }
                        kv4 e = mx4Var2.e();
                        if (mx4Var2.e() != null && !TextUtils.isEmpty(e.c())) {
                            ys4.k().y("sync_ad_privacy_url", e.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(mx4Var2.r());
                        String unused = TiebaSyncService.mStatistics = null;
                        return mx4Var2;
                    } catch (Exception e2) {
                        e = e2;
                        mx4Var = mx4Var2;
                        BdLog.detailException(e);
                        return mx4Var;
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
        public void onPostExecute(mx4 mx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx4Var) == null) {
                super.onPostExecute(mx4Var);
                this.b.mSyncTask = null;
                if (mx4Var != null) {
                    fb5.j().x();
                    this.b.mModel = mx4Var;
                    eg5.b(this.b.mModel.h());
                    this.b.onPostExecuteUpdateData();
                    TbadkCoreApplication.getInst().setIsNoInterestTag(1 == this.b.mModel.o());
                    TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.b.mModel.m());
                    TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.b.mModel.n());
                    TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                    String w = this.b.mModel.w();
                    if (!StringUtils.isNull(w)) {
                        TbadkCoreApplication.getInst().setConfigVersion(w);
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
                        eb5.d().e(this.b.mModel.a());
                    }
                    if (this.b.mModel.b() != null) {
                        eb5.d().f(this.b.mModel.b());
                    }
                    ABTestSwitchManager.getInstance().parseJSONArray(this.b.mModel.c());
                    UbsABTestDataManager.getInstance().parseJSONArray(this.b.mModel.r());
                    qp6.e().k(this.b.mModel.l());
                    TbSingleton.getInstance().setAdFloatViewData(this.b.mModel.f());
                    SyncDataEvent syncDataEvent = new SyncDataEvent();
                    syncDataEvent.sampleId = this.b.mModel.t() != null ? this.b.mModel.t().M() : "";
                    syncDataEvent.ubsABTest = this.b.mModel.r() != null ? this.b.mModel.r().toString() : "[]";
                    syncDataEvent.abtestExtraData = this.b.mModel.b();
                    a55.i(syncDataEvent);
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
