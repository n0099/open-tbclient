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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.f0.h;
import d.a.r0.m0.j;
import d.a.r0.r.k;
import d.a.r0.s.c.c0;
import d.a.r0.s.c.d0;
import d.a.r0.s.c.k0;
import d.a.r0.s.c.t;
import d.a.r0.s.d.d;
import d.a.r0.s.e.e;
import d.a.s0.m1.c;
import d.a.s0.n;
import java.util.Date;
import java.util.Random;
/* loaded from: classes5.dex */
public class TiebaSyncService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public int mHaveRetry;
    public e mModel;
    public Runnable mRunnable;
    public b mSyncTask;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaSyncService f20653e;

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
            this.f20653e = tiebaSyncService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20653e.checkUpdata();
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
        t k;
        int performSampleCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (k = this.mModel.k()) == null) {
            return;
        }
        int nextInt = new Random().nextInt(10000) + 1;
        int d2 = k.d();
        if (d2 > 0 && nextInt % d2 == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
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
        d0 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (q = this.mModel.q()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setProfileData(q);
        String b2 = q.b();
        long c2 = q.c();
        long a2 = q.a();
        d.a.r0.r.d0.b.j().x("sync_send_maintab_my_tab_lottie_url", b2);
        d.a.r0.r.d0.b.j().w("sync_send_maintab_my_tab_lottie_start_time", c2);
        d.a.r0.r.d0.b.j().w("sync_send_maintab_my_tab_lottie_end_time", a2);
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
                    n.e();
                }
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        k0 t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (t = this.mModel.t()) == null) {
            return;
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(t.c());
        TbadkCoreApplication.getInst().getListItemRule().f(t.A());
        TbadkCoreApplication.getInst().getListItemRule().e(t.s());
        TbadkCoreApplication.getInst().getListItemRule().d(t.r());
        TbadkCoreApplication.getInst().setUseNewResign(t.G());
        TbadkCoreApplication.getInst().setUegVoiceWarning(t.R());
        TbadkCoreApplication.getInst().setUrlText(t.S());
        TbadkCoreApplication.getInst().setGameInfoData(t.v(), t.x(), t.w());
        PullViewHelper.getInstance().saveOrUpdateImages(t.n(), t.o(), t.p(), t.l(), t.m());
        String f2 = t.f();
        d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
        if (f2 == null) {
            f2 = "";
        }
        j.x("apply_vip_live_room_pid", f2);
        d.a.r0.r.d0.b.j().x("tail_link", t.Q());
        d.a.r0.r.d0.b.j().x("bubble_link", t.h());
        long T = t.T();
        if (T >= 0 && T != TbadkCoreApplication.getInst().getUseTimeInterval()) {
            TbadkCoreApplication.getInst().setUseTimeInterval(t.T());
        }
        long g2 = t.g() * 1000;
        if (g2 > 0) {
            d.a.r0.r.d0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", g2);
        } else {
            long F = t.F() * 1000;
            if (F > 0) {
                d.a.r0.r.d0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", F);
            }
        }
        XiaoyingUtil.setShowTime(t.W());
        TbadkCoreApplication.getInst().setLastUpdateThemeTime(t.t());
        d.a.r0.r.d0.b.j().w("recommend_frs_cache_time", t.I());
        d.a.r0.r.d0.b.j().v("home_page_max_thread_count", t.u());
        d.a.r0.r.d0.b.j().t("localvideo_open", t.z());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
        d.a.r0.r.d0.b.j().v("card_show_statistic_max_count", t.w);
        d.a.r0.r.d0.b.j().x("nick_name_activity_link", t.H());
        String p = d.a.r0.r.d0.b.j().p("clean_smart_frs_cookie", "");
        String i2 = t.i();
        if (!TextUtils.equals(p, i2)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
        }
        d.a.r0.r.d0.b.j().x("clean_smart_frs_cookie", i2);
        d.a.r0.r.d0.b.j().v("recommend_tab_show", t.e());
        d.a.r0.r.d0.b.j().v("ribao_switch", t.L());
        TbConfig.setMaxPhotoMemoryCache(t.J());
        d.a.r0.r.d0.b.j().v("key_card_show_type", t.P());
        TbadkCoreApplication.getInst().setCardShowType(t.P());
        d.a.r0.r.d0.b.j().v("key_card_abstract_switch", t.b());
        c0 E = t.E();
        if (E != null) {
            d.a.r0.r.d0.b.j().t("nani_key_is_show_download_nani_panel", E.f56345a);
            d.a.r0.r.d0.b.j().t("nani_key_is_activate_app", E.f56346b);
            d.a.r0.r.d0.b.j().v("nani_key_download_show_position", E.f56347c);
            d.a.r0.r.d0.b.j().v("nani_key_download_show_rate", E.f56348d);
            d.a.r0.r.d0.b.j().x("nani_key_download_link_url", E.f56349e);
            d.a.r0.r.d0.b.j().x("nani_key_download_txt", E.f56350f);
            d.a.r0.r.d0.b.j().x("nani_key_show_tail_txt", E.f56351g);
            d.a.r0.r.d0.b.j().v("nani_key_show_tail_video_type", E.f56352h);
            d.a.r0.r.d0.b.j().x("nani_key_show_tail_txt", E.f56351g);
            d.a.r0.r.d0.b.j().x("nani_key_pre_h5_link", E.f56353i);
        }
        if (t.N() != null) {
            TbSingleton.getInstance().setShakeData(t.N());
        }
        if (!TextUtils.isEmpty(t.O())) {
            TbSingleton.getInstance().setSharePanelText(t.O());
        }
        d.a.r0.r.d0.b.j().w("key_frs_cache_time", t.q() * 1000);
        TbSingleton.getInstance().setPushDialogLoopTime(t.j());
        TbSingleton.getInstance().setPushDialogShowTime(t.k());
        TbSingleton.getInstance().setCanShowPermDlg(t.a());
        TbSingleton.getInstance().setAuditPackageSwitch(t.X());
        TbSingleton.getInstance().setProfileGameCenterKey(t.K());
        TbSingleton.getInstance().setMissionEntranceUrl(t.D());
        TbSingleton.getInstance().setMissionEntranceIcon(t.B());
        TbSingleton.getInstance().setMissionEntranceObjSource(t.C());
        TbSingleton.getInstance().setWalletSignLink(t.V());
        TbSingleton.getInstance().setSampleId(t.M());
        TbSingleton.getInstance().setLiveForumMap(t.y());
        TbSingleton.getInstance().setClipboardDelayTime(t.d());
        TbSingleton.getInstance().setVideoRedIconInterval(t.U());
        if (TbSingleton.getInstance().getVideoRedIconInterval() > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, Integer.valueOf(TbSingleton.getInstance().getVideoRedIconInterval())));
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
        d.a.s0.c4.a v;
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
            d.a.c.e.n.a a2 = j.a();
            a2.c("ad_sdk_priority", Integer.valueOf(d.a.r0.r.d0.b.j().k("splash_ad_strategy_key", 0)));
            a2.c("bear_sid_type", Integer.valueOf(d.a.r0.r.d0.b.j().k("splash_bear_sid_type_key", 0)));
            a2.b("ubs", d.a.r0.r.d0.b.j().p(d.a.r0.b.c.e(), null));
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

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20654a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaSyncService f20655b;

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
            this.f20655b = tiebaSyncService;
            this.f20654a = null;
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
            this.f20655b.statisticForAdvert("advert_before_sync");
            e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.f20654a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f20654a.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.f20654a.addPostData("brand", Build.BRAND);
                this.f20654a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.f20654a.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(app)));
                this.f20654a.addPostData("_phone_screen", stringBuffer.toString());
                this.f20654a.addPostData("scr_w", String.valueOf(l.k(app)));
                this.f20654a.addPostData("scr_h", String.valueOf(l.i(app)));
                this.f20654a.addPostData("scr_dip", String.valueOf(l.h(app)));
                String str = "0";
                if (d.d().e() > 0) {
                    this.f20654a.addPostData("_msg_status", "0");
                } else {
                    this.f20654a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str = activeVersion;
                    }
                    this.f20654a.addPostData("_active", str);
                }
                this.f20654a.addPostData("_pic_quality", String.valueOf(k.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.f20654a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f20654a.addPostData(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f20654a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f20654a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f20654a.addPostData(PackageTable.MD5, n.a());
                String postNetData = this.f20654a.postNetData();
                if (this.f20654a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.f20654a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar2 = new e();
                    try {
                        eVar2.z(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.i().a() != null && eVar2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(this.f20655b, eVar2.i().a());
                            TbadkCoreApplication.setClientId(eVar2.i().a());
                        }
                        if (eVar2.k() != null) {
                            d.a.r0.r.d0.b.j().v("crash_limit_count", eVar2.k().b());
                        }
                        d.a.r0.s.c.d e2 = eVar2.e();
                        if (eVar2.e() != null && !TextUtils.isEmpty(e2.c())) {
                            d.a.r0.r.d0.b.j().x("sync_ad_privacy_url", e2.c());
                        }
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
                this.f20655b.mSyncTask = null;
                if (eVar != null) {
                    d.a.r0.z0.b.c().d();
                    this.f20655b.mModel = eVar;
                    d.a.s0.b.b(this.f20655b.mModel.h());
                    this.f20655b.onPostExecuteUpdateData();
                    TbadkCoreApplication.getInst().setIsNoInterestTag(1 == this.f20655b.mModel.o());
                    TbadkCoreApplication.getInst().setIsFirstTimeMotivate(this.f20655b.mModel.m());
                    TbadkCoreApplication.getInst().setIsNeedNewUserLead(this.f20655b.mModel.n());
                    TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                    String w = this.f20655b.mModel.w();
                    if (!StringUtils.isNull(w)) {
                        TbadkCoreApplication.getInst().setConfigVersion(w);
                    }
                    this.f20655b.onPostExecuteConfigData();
                    this.f20655b.onPostExecuteWlConfigData();
                    this.f20655b.onPostExecuteProfilData();
                    this.f20655b.onPostExecuteYYConfigData();
                    this.f20655b.onPostExecuteYYLiveTabConfigData();
                    if (this.f20655b.mModel.p() != null) {
                        TbSingleton.getInstance().setNewGodData(this.f20655b.mModel.p());
                    }
                    if (this.f20655b.mModel.g() != null) {
                        TbSingleton.getInstance().setAdVertiSementData(this.f20655b.mModel.g());
                    }
                    if (this.f20655b.mModel.e() != null) {
                        TbadkCoreApplication.getInst().setAdAdSense(this.f20655b.mModel.e());
                    }
                    if (this.f20655b.mModel.d() != null) {
                        TbadkCoreApplication.getInst().setActivitySwitch(this.f20655b.mModel.d());
                    }
                    if (this.f20655b.mModel.a() != null) {
                        d.a.r0.z0.a.d().e(this.f20655b.mModel.a());
                    }
                    if (this.f20655b.mModel.b() != null) {
                        d.a.r0.z0.a.d().f(this.f20655b.mModel.b());
                    }
                    d.a.r0.b.b.e().i(this.f20655b.mModel.c());
                    d.a.r0.b.c.d().h(this.f20655b.mModel.r());
                    d.a.s0.v0.d.c.e().k(this.f20655b.mModel.l());
                    TbSingleton.getInstance().setAdFloatViewData(this.f20655b.mModel.f());
                    TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                    SyncDataEvent syncDataEvent = new SyncDataEvent();
                    syncDataEvent.sampleId = this.f20655b.mModel.t() != null ? this.f20655b.mModel.t().M() : "";
                    syncDataEvent.ubsABTest = this.f20655b.mModel.r() != null ? this.f20655b.mModel.r().toString() : "[]";
                    syncDataEvent.abtestExtraData = this.f20655b.mModel.b();
                    h.i(syncDataEvent);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                    this.f20655b.statisticForAdvert("advert_after_sync");
                    this.f20655b.stopSelf();
                    return;
                }
                TiebaSyncService.access$1208(this.f20655b);
                if (this.f20655b.mHaveRetry < 10) {
                    this.f20655b.mHandler.removeCallbacks(this.f20655b.mRunnable);
                    this.f20655b.mHandler.postDelayed(this.f20655b.mRunnable, 60000L);
                    return;
                }
                this.f20655b.stopSelf();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f20655b.mSyncTask = null;
                NetWork netWork = this.f20654a;
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
