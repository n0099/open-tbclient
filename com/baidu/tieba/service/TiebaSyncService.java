package com.baidu.tieba.service;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import c.a.d.f.p.l;
import c.a.q0.k0.h;
import c.a.q0.r0.j;
import c.a.q0.s.k;
import c.a.q0.t.c.f0;
import c.a.q0.t.c.g0;
import c.a.q0.t.c.q0;
import c.a.q0.t.c.u;
import c.a.q0.t.d.d;
import c.a.q0.t.e.e;
import c.a.r0.s;
import c.a.r0.v1.c;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Random;
/* loaded from: classes11.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public e mModel;
    public Runnable mRunnable;
    public b mSyncTask;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaSyncService f48890e;

        public a(TiebaSyncService tiebaSyncService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaSyncService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48890e = tiebaSyncService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48890e.checkUpdata();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        int i2 = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i2 + 1;
        return i2;
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
        u k2;
        int performSampleCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (k2 = this.mModel.k()) == null) {
            return;
        }
        int nextInt = new Random().nextInt(10000) + 1;
        int d2 = k2.d();
        if (d2 > 0 && nextInt % d2 == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
            TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
        }
        if (k2.e() != null) {
            TbadkCoreApplication.getInst().setCheckUrl(k2.e().a());
        }
        TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(k2.c());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        g0 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (q = this.mModel.q()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setProfileData(q);
        String b2 = q.b();
        long c2 = q.c();
        long a2 = q.a();
        c.a.q0.s.e0.b.j().x("sync_send_maintab_my_tab_lottie_url", b2);
        c.a.q0.s.e0.b.j().w("sync_send_maintab_my_tab_lottie_start_time", c2);
        c.a.q0.s.e0.b.j().w("sync_send_maintab_my_tab_lottie_end_time", a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            c.b().a(false);
            VersionData s = this.mModel.s();
            if (s != null && s.hasNewVer() && TbConfig.COULD_UPDATE) {
                TbadkCoreApplication.getInst().setVersionData(s);
                broadcastNewVersion();
                if (s.forceUpdate()) {
                    if (this.mModel.k() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                        return;
                    }
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
                    s.d();
                }
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        q0 t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (t = this.mModel.t()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(t.c());
        TbadkCoreApplication.getInst().getListItemRule().f(t.C());
        TbadkCoreApplication.getInst().getListItemRule().e(t.t());
        TbadkCoreApplication.getInst().getListItemRule().d(t.s());
        TbadkCoreApplication.getInst().setUseNewResign(t.I());
        TbadkCoreApplication.getInst().setUegVoiceWarning(t.U());
        TbadkCoreApplication.getInst().setUrlText(t.a0());
        TbadkCoreApplication.getInst().setGameInfoData(t.w(), t.y(), t.x());
        PullViewHelper.getInstance().saveOrUpdateImages(t.n(), t.o(), t.p(), t.l(), t.m());
        String f2 = t.f();
        c.a.q0.s.e0.b.j().v("key_fps_time", t.q());
        c.a.q0.s.e0.b.j().v("key_switch_immediately_upload", t.R());
        c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
        if (f2 == null) {
            f2 = "";
        }
        j2.x("apply_vip_live_room_pid", f2);
        c.a.q0.s.e0.b.j().x("tail_link", t.T());
        c.a.q0.s.e0.b.j().x("bubble_link", t.h());
        long b0 = t.b0();
        if (b0 >= 0 && b0 != TbadkCoreApplication.getInst().getUseTimeInterval()) {
            TbadkCoreApplication.getInst().setUseTimeInterval(t.b0());
        }
        long g2 = t.g() * 1000;
        if (g2 > 0) {
            c.a.q0.s.e0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", g2);
        } else {
            long H = t.H() * 1000;
            if (H > 0) {
                c.a.q0.s.e0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", H);
            }
        }
        TbadkCoreApplication.getInst().setLastUpdateThemeTime(t.u());
        c.a.q0.s.e0.b.j().w("recommend_frs_cache_time", t.K());
        c.a.q0.s.e0.b.j().v("home_page_max_thread_count", t.v());
        c.a.q0.s.e0.b.j().t("localvideo_open", t.B());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
        c.a.q0.s.e0.b.j().v("card_show_statistic_max_count", t.x);
        c.a.q0.s.e0.b.j().x("nick_name_activity_link", t.J());
        String p = c.a.q0.s.e0.b.j().p("clean_smart_frs_cookie", "");
        String i2 = t.i();
        if (!TextUtils.equals(p, i2)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
        }
        c.a.q0.s.e0.b.j().x("clean_smart_frs_cookie", i2);
        c.a.q0.s.e0.b.j().v("recommend_tab_show", t.e());
        c.a.q0.s.e0.b.j().v("ribao_switch", t.N());
        c.a.q0.s.e0.b.j().v("key_upload_pic_max_width", t.Y());
        c.a.q0.s.e0.b.j().v("key_upload_pic_max_height", t.X());
        c.a.q0.s.e0.b.j().v("key_upload_pic_parallel_count", t.Z());
        c.a.q0.s.e0.b.j().v("key_upload_pic_chunk_size", t.W());
        c.a.q0.s.e0.b.j().v("key_upload_pic_chunk_retry", t.V());
        TbConfig.setMaxPhotoMemoryCache(t.L());
        c.a.q0.s.e0.b.j().v("key_card_show_type", t.S());
        TbadkCoreApplication.getInst().setCardShowType(t.S());
        c.a.q0.s.e0.b.j().v("key_card_abstract_switch", t.b());
        TbadkCoreApplication.getInst().setInterestBoardConfigData(t.z());
        f0 G = t.G();
        if (G != null) {
            c.a.q0.s.e0.b.j().t("nani_key_is_show_download_nani_panel", G.a);
            c.a.q0.s.e0.b.j().t("nani_key_is_activate_app", G.f13331b);
            c.a.q0.s.e0.b.j().v("nani_key_download_show_position", G.f13332c);
            c.a.q0.s.e0.b.j().v("nani_key_download_show_rate", G.f13333d);
            c.a.q0.s.e0.b.j().x("nani_key_download_link_url", G.f13334e);
            c.a.q0.s.e0.b.j().x("nani_key_download_txt", G.f13335f);
            c.a.q0.s.e0.b.j().x("nani_key_show_tail_txt", G.f13336g);
            c.a.q0.s.e0.b.j().v("nani_key_show_tail_video_type", G.f13337h);
            c.a.q0.s.e0.b.j().x("nani_key_show_tail_txt", G.f13336g);
            c.a.q0.s.e0.b.j().x("nani_key_pre_h5_link", G.f13338i);
        }
        if (t.P() != null) {
            TbSingleton.getInstance().setShakeData(t.P());
        }
        if (!TextUtils.isEmpty(t.Q())) {
            TbSingleton.getInstance().setSharePanelText(t.Q());
        }
        c.a.q0.s.e0.b.j().w("key_frs_cache_time", t.r() * 1000);
        TbSingleton.getInstance().setPushDialogLoopTime(t.j());
        TbSingleton.getInstance().setPushDialogShowTime(t.k());
        TbSingleton.getInstance().setCanShowPermDlg(t.a());
        TbSingleton.getInstance().setAuditPackageSwitch(t.g0());
        TbSingleton.getInstance().setProfileGameCenterKey(t.M());
        TbSingleton.getInstance().setMissionEntranceUrl(t.F());
        TbSingleton.getInstance().setMissionEntranceIcon(t.D());
        TbSingleton.getInstance().setMissionEntranceObjSource(t.E());
        TbSingleton.getInstance().setWalletSignLink(t.e0());
        TbSingleton.getInstance().setSampleId(t.O());
        TbSingleton.getInstance().setLiveForumMap(t.A());
        TbSingleton.getInstance().setClipboardDelayTime(t.d());
        TbSingleton.getInstance().setVideoRedIconInterval(t.d0());
        TbSingleton.getInstance().setWorksAddTopicMaxNum(t.f0());
        if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
        }
        VideoPreloadData c0 = t.c0();
        if (c0 != null) {
            TbConfig.PREFETCH_NEXT_VIDEO_SIZE = c0.getVideoSize();
            TbConfig.PREFETCH_NEXT_VIDEO_NUM = c0.getVideoNum();
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
        c.a.r0.n4.a v;
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
            c.a.d.f.n.a a2 = j.a();
            a2.c("ad_sdk_priority", Integer.valueOf(c.a.q0.s.e0.b.j().k("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(c.a.q0.s.e0.b.j().k("splash_bear_sid_type_key", 0)));
            a2.b("ubs", c.a.q0.s.e0.b.j().p(c.a.q0.b.c.e(), null));
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
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, intent, i2) == null) {
            super.onStart(intent, i2);
            this.mHaveRetry = 0;
            checkUpdata();
        }
    }

    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaSyncService f48891b;

        public b(TiebaSyncService tiebaSyncService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaSyncService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48891b = tiebaSyncService;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public e doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (e) invokeL.objValue;
            }
            this.f48891b.statisticForAdvert("advert_before_sync");
            e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.a.addPostData("brand", Build.BRAND);
                this.a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.a.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(app)));
                this.a.addPostData("_phone_screen", stringBuffer.toString());
                this.a.addPostData("scr_w", String.valueOf(l.k(app)));
                this.a.addPostData("scr_h", String.valueOf(l.i(app)));
                this.a.addPostData("scr_dip", String.valueOf(l.h(app)));
                String str = "0";
                if (d.d().e() > 0) {
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
                this.a.addPostData("_pic_quality", String.valueOf(k.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.a.addPostData(PackageTable.MD5, s.a());
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar2 = new e();
                    try {
                        eVar2.z(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.i().a() != null && eVar2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.f48891b, eVar2.i().a());
                            TbadkCoreApplication.setClientId(eVar2.i().a());
                        }
                        if (eVar2.k() != null) {
                            c.a.q0.s.e0.b.j().v("crash_limit_count", eVar2.k().b());
                        }
                        c.a.q0.t.c.d e2 = eVar2.e();
                        if (eVar2.e() != null && !TextUtils.isEmpty(e2.c())) {
                            c.a.q0.s.e0.b.j().x("sync_ad_privacy_url", e2.c());
                        }
                        TbSingleton.getInstance().setUbsABTestJsonArray(eVar2.r());
                        String unused = TiebaSyncService.mStatistics = null;
                        return eVar2;
                    } catch (Exception e3) {
                        e = e3;
                        eVar = eVar2;
                        BdLog.detailException(e);
                        return eVar;
                    }
                }
                return null;
            } catch (Exception e4) {
                e = e4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                super.onPostExecute(eVar);
                this.f48891b.mSyncTask = null;
                if (eVar != null) {
                    c.a.q0.d1.d.c().d();
                    this.f48891b.mModel = eVar;
                    c.a.r0.b.b(this.f48891b.mModel.h());
                    this.f48891b.onPostExecuteUpdateData();
                    TbadkCoreApplication.getInst().setIsNoInterestTag(1 == this.f48891b.mModel.o());
                    TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.f48891b.mModel.m());
                    TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.f48891b.mModel.n());
                    TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                    String w = this.f48891b.mModel.w();
                    if (!StringUtils.isNull(w)) {
                        TbadkCoreApplication.getInst().setConfigVersion(w);
                    }
                    this.f48891b.onPostExecuteConfigData();
                    this.f48891b.onPostExecuteWlConfigData();
                    this.f48891b.onPostExecuteProfilData();
                    this.f48891b.onPostExecuteYYConfigData();
                    this.f48891b.onPostExecuteYYLiveTabConfigData();
                    if (this.f48891b.mModel.p() != null) {
                        TbSingleton.getInstance().setNewGodData(this.f48891b.mModel.p());
                    }
                    if (this.f48891b.mModel.g() != null) {
                        TbSingleton.getInstance().setAdVertiSementData(this.f48891b.mModel.g());
                    }
                    if (this.f48891b.mModel.e() != null) {
                        TbadkCoreApplication.getInst().setAdAdSense(this.f48891b.mModel.e());
                    }
                    if (this.f48891b.mModel.d() != null) {
                        TbadkCoreApplication.getInst().setActivitySwitch(this.f48891b.mModel.d());
                    }
                    if (this.f48891b.mModel.a() != null) {
                        c.a.q0.d1.c.d().e(this.f48891b.mModel.a());
                    }
                    if (this.f48891b.mModel.b() != null) {
                        c.a.q0.d1.c.d().f(this.f48891b.mModel.b());
                    }
                    c.a.q0.b.b.e().i(this.f48891b.mModel.c());
                    c.a.q0.b.c.d().h(this.f48891b.mModel.r());
                    c.a.r0.e1.e.c.e().k(this.f48891b.mModel.l());
                    TbSingleton.getInstance().setAdFloatViewData(this.f48891b.mModel.f());
                    TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                    SyncDataEvent syncDataEvent = new SyncDataEvent();
                    syncDataEvent.sampleId = this.f48891b.mModel.t() != null ? this.f48891b.mModel.t().O() : "";
                    syncDataEvent.ubsABTest = this.f48891b.mModel.r() != null ? this.f48891b.mModel.r().toString() : "[]";
                    syncDataEvent.abtestExtraData = this.f48891b.mModel.b();
                    h.i(syncDataEvent);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                    this.f48891b.statisticForAdvert("advert_after_sync");
                    this.f48891b.stopSelf();
                    return;
                }
                TiebaSyncService.access$1208(this.f48891b);
                if (this.f48891b.mHaveRetry < 10) {
                    this.f48891b.mHandler.removeCallbacks(this.f48891b.mRunnable);
                    this.f48891b.mHandler.postDelayed(this.f48891b.mRunnable, 60000L);
                    return;
                }
                this.f48891b.stopSelf();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f48891b.mSyncTask = null;
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
