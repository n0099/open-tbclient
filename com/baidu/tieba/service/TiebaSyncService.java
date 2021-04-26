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
import d.a.i0.f0.h;
import d.a.i0.m0.j;
import d.a.i0.r.k;
import d.a.i0.s.c.b0;
import d.a.i0.s.c.c0;
import d.a.i0.s.c.j0;
import d.a.i0.s.c.t;
import d.a.i0.s.d.d;
import d.a.i0.s.e.e;
import d.a.j0.i1.c;
import d.a.j0.l;
import java.util.Date;
import java.util.Random;
/* loaded from: classes5.dex */
public class TiebaSyncService extends BdBaseService {
    public static String mStatistics;
    public b mSyncTask = null;
    public int mHaveRetry = 0;
    public e mModel = null;
    public Handler mHandler = new Handler();
    public Runnable mRunnable = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TiebaSyncService.this.checkUpdata();
        }
    }

    public static /* synthetic */ int access$1108(TiebaSyncService tiebaSyncService) {
        int i2 = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i2 + 1;
        return i2;
    }

    private void broadcastNewVersion() {
        if (this.mModel == null) {
            return;
        }
        TbadkCoreApplication.getInst().refreshNewVersion(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        b bVar = this.mSyncTask;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(this, null);
        this.mSyncTask = bVar2;
        bVar2.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        t k = this.mModel.k();
        if (k != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        c0 q = this.mModel.q();
        if (q != null) {
            TbadkCoreApplication.getInst().setProfileData(q);
            String b2 = q.b();
            long c2 = q.c();
            long a2 = q.a();
            d.a.i0.r.d0.b.j().x("sync_send_maintab_my_tab_lottie_url", b2);
            d.a.i0.r.d0.b.j().w("sync_send_maintab_my_tab_lottie_start_time", c2);
            d.a.i0.r.d0.b.j().w("sync_send_maintab_my_tab_lottie_end_time", a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
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
                l.e();
            }
            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        j0 t = this.mModel.t();
        if (t != null) {
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
            d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
            if (f2 == null) {
                f2 = "";
            }
            j.x("apply_vip_live_room_pid", f2);
            d.a.i0.r.d0.b.j().x("tail_link", t.Q());
            d.a.i0.r.d0.b.j().x("bubble_link", t.h());
            long T = t.T();
            if (T >= 0 && T != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(t.T());
            }
            long g2 = t.g() * 1000;
            if (g2 > 0) {
                d.a.i0.r.d0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", g2);
            } else {
                long F = t.F() * 1000;
                if (F > 0) {
                    d.a.i0.r.d0.b.j().w("KEY_UPLOAD_LOG_INTERVAL", F);
                }
            }
            XiaoyingUtil.setShowTime(t.V());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(t.t());
            d.a.i0.r.d0.b.j().w("recommend_frs_cache_time", t.I());
            d.a.i0.r.d0.b.j().v("home_page_max_thread_count", t.u());
            d.a.i0.r.d0.b.j().t("localvideo_open", t.z());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            d.a.i0.r.d0.b.j().v("card_show_statistic_max_count", t.w);
            d.a.i0.r.d0.b.j().x("nick_name_activity_link", t.H());
            String p = d.a.i0.r.d0.b.j().p("clean_smart_frs_cookie", "");
            String i2 = t.i();
            if (!TextUtils.equals(p, i2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            d.a.i0.r.d0.b.j().x("clean_smart_frs_cookie", i2);
            d.a.i0.r.d0.b.j().v("recommend_tab_show", t.e());
            d.a.i0.r.d0.b.j().v("ribao_switch", t.L());
            TbConfig.setMaxPhotoMemoryCache(t.J());
            d.a.i0.r.d0.b.j().v("key_card_show_type", t.P());
            TbadkCoreApplication.getInst().setCardShowType(t.P());
            d.a.i0.r.d0.b.j().v("key_card_abstract_switch", t.b());
            b0 E = t.E();
            if (E != null) {
                d.a.i0.r.d0.b.j().t("nani_key_is_show_download_nani_panel", E.f49534a);
                d.a.i0.r.d0.b.j().t("nani_key_is_activate_app", E.f49535b);
                d.a.i0.r.d0.b.j().v("nani_key_download_show_position", E.f49536c);
                d.a.i0.r.d0.b.j().v("nani_key_download_show_rate", E.f49537d);
                d.a.i0.r.d0.b.j().x("nani_key_download_link_url", E.f49538e);
                d.a.i0.r.d0.b.j().x("nani_key_download_txt", E.f49539f);
                d.a.i0.r.d0.b.j().x("nani_key_show_tail_txt", E.f49540g);
                d.a.i0.r.d0.b.j().v("nani_key_show_tail_video_type", E.f49541h);
                d.a.i0.r.d0.b.j().x("nani_key_show_tail_txt", E.f49540g);
                d.a.i0.r.d0.b.j().x("nani_key_pre_h5_link", E.f49542i);
            }
            if (t.N() != null) {
                TbSingleton.getInstance().setShakeData(t.N());
            }
            if (!TextUtils.isEmpty(t.O())) {
                TbSingleton.getInstance().setSharePanelText(t.O());
            }
            d.a.i0.r.d0.b.j().w("key_frs_cache_time", t.q() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(t.j());
            TbSingleton.getInstance().setPushDialogShowTime(t.k());
            TbSingleton.getInstance().setCanShowPermDlg(t.a());
            TbSingleton.getInstance().setAuditPackageSwitch(t.W());
            TbSingleton.getInstance().setProfileGameCenterKey(t.K());
            TbSingleton.getInstance().setMissionEntranceUrl(t.D());
            TbSingleton.getInstance().setMissionEntranceIcon(t.B());
            TbSingleton.getInstance().setMissionEntranceObjSource(t.C());
            TbSingleton.getInstance().setWalletSignLink(t.U());
            TbSingleton.getInstance().setSampleId(t.M());
            TbSingleton.getInstance().setLiveForumMap(t.y());
            TbSingleton.getInstance().setClipboardDelayTime(t.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteYYConfigData() {
        YYLiveConfig u = this.mModel.u();
        if (u != null) {
            TbSingleton.getInstance().setYYLiveConfig(u);
        }
    }

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticForAdvert(String str) {
        d.a.c.e.n.a a2 = j.a();
        a2.c("ad_sdk_priority", Integer.valueOf(d.a.i0.r.d0.b.j().k("splash_ad_strategy_key", 0)));
        a2.c("bear_sid_type", Integer.valueOf(d.a.i0.r.d0.b.j().k("splash_bear_sid_type_key", 0)));
        a2.b("ubs", d.a.i0.r.d0.b.j().p(d.a.i0.b.c.e(), null));
        BdStatisticsManager.getInstance().debug(str, a2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVar = this.mSyncTask;
        if (bVar != null) {
            bVar.cancel();
        }
        this.mHaveRetry = 11;
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        this.mHaveRetry = 0;
        checkUpdata();
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, e> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21182a;

        public b() {
            this.f21182a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public e doInBackground(String... strArr) {
            TiebaSyncService.this.statisticForAdvert("advert_before_sync");
            e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.f21182a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f21182a.addPostData("board", Build.BOARD);
                this.f21182a.addPostData("brand", Build.BRAND);
                this.f21182a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.f21182a.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(d.a.c.e.p.l.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(d.a.c.e.p.l.i(app)));
                this.f21182a.addPostData("_phone_screen", stringBuffer.toString());
                this.f21182a.addPostData("scr_w", String.valueOf(d.a.c.e.p.l.k(app)));
                this.f21182a.addPostData("scr_h", String.valueOf(d.a.c.e.p.l.i(app)));
                this.f21182a.addPostData("scr_dip", String.valueOf(d.a.c.e.p.l.h(app)));
                String str = "0";
                if (d.d().e() > 0) {
                    this.f21182a.addPostData("_msg_status", "0");
                } else {
                    this.f21182a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str = activeVersion;
                    }
                    this.f21182a.addPostData("_active", str);
                }
                this.f21182a.addPostData("_pic_quality", String.valueOf(k.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.f21182a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f21182a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f21182a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f21182a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f21182a.addPostData(PackageTable.MD5, l.a());
                String postNetData = this.f21182a.postNetData();
                if (this.f21182a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.f21182a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar2 = new e();
                    try {
                        eVar2.y(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.i().a() != null && eVar2.i().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar2.i().a());
                            TbadkCoreApplication.setClientId(eVar2.i().a());
                        }
                        if (eVar2.k() != null) {
                            d.a.i0.r.d0.b.j().v("crash_limit_count", eVar2.k().b());
                        }
                        d.a.i0.s.c.d e2 = eVar2.e();
                        if (eVar2.e() != null && !TextUtils.isEmpty(e2.c())) {
                            d.a.i0.r.d0.b.j().x("sync_ad_privacy_url", e2.c());
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
            super.onPostExecute(eVar);
            TiebaSyncService.this.mSyncTask = null;
            if (eVar != null) {
                d.a.i0.z0.b.c().d();
                TiebaSyncService.this.mModel = eVar;
                d.a.j0.b.b(TiebaSyncService.this.mModel.h());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.o());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.m());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.n());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String v = TiebaSyncService.this.mModel.v();
                if (!StringUtils.isNull(v)) {
                    TbadkCoreApplication.getInst().setConfigVersion(v);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                TiebaSyncService.this.onPostExecuteYYConfigData();
                if (TiebaSyncService.this.mModel.p() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.p());
                }
                if (TiebaSyncService.this.mModel.g() != null) {
                    TbSingleton.getInstance().setAdVertiSementData(TiebaSyncService.this.mModel.g());
                }
                if (TiebaSyncService.this.mModel.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.e());
                }
                if (TiebaSyncService.this.mModel.d() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.d());
                }
                if (TiebaSyncService.this.mModel.a() != null) {
                    d.a.i0.z0.a.d().e(TiebaSyncService.this.mModel.a());
                }
                if (TiebaSyncService.this.mModel.b() != null) {
                    d.a.i0.z0.a.d().f(TiebaSyncService.this.mModel.b());
                }
                d.a.i0.b.b.e().i(TiebaSyncService.this.mModel.c());
                d.a.i0.b.c.d().h(TiebaSyncService.this.mModel.r());
                d.a.j0.r0.d.c.e().k(TiebaSyncService.this.mModel.l());
                TbSingleton.getInstance().setAdFloatViewData(TiebaSyncService.this.mModel.f());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                syncDataEvent.sampleId = TiebaSyncService.this.mModel.t() != null ? TiebaSyncService.this.mModel.t().M() : "";
                syncDataEvent.ubsABTest = TiebaSyncService.this.mModel.r() != null ? TiebaSyncService.this.mModel.r().toString() : "[]";
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.b();
                h.i(syncDataEvent);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                TiebaSyncService.this.statisticForAdvert("advert_after_sync");
                TiebaSyncService.this.stopSelf();
                return;
            }
            TiebaSyncService.access$1108(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaSyncService.this.mSyncTask = null;
            NetWork netWork = this.f21182a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        public /* synthetic */ b(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }
    }
}
