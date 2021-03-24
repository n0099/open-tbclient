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
import d.b.b.e.p.l;
import d.b.h0.f0.g;
import d.b.h0.m0.j;
import d.b.h0.r.k;
import d.b.h0.s.c.a0;
import d.b.h0.s.c.h0;
import d.b.h0.s.c.r;
import d.b.h0.s.c.z;
import d.b.h0.s.d.d;
import d.b.h0.s.e.e;
import d.b.i0.h1.c;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
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

    public static /* synthetic */ int access$1008(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        return i;
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
        r i = this.mModel.i();
        if (i != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int d2 = i.d();
            if (d2 > 0 && nextInt % d2 == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (i.e() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(i.e().a());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(i.c());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        a0 n = this.mModel.n();
        if (n != null) {
            TbadkCoreApplication.getInst().setProfileData(n);
            String b2 = n.b();
            long c2 = n.c();
            long a2 = n.a();
            d.b.h0.r.d0.b.i().w("sync_send_maintab_my_tab_lottie_url", b2);
            d.b.h0.r.d0.b.i().v("sync_send_maintab_my_tab_lottie_start_time", c2);
            d.b.h0.r.d0.b.i().v("sync_send_maintab_my_tab_lottie_end_time", a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        c.b().a(false);
        VersionData p = this.mModel.p();
        if (p != null && p.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(p);
            broadcastNewVersion();
            if (p.forceUpdate()) {
                if (this.mModel.i() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), p, this.mModel.h())));
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() <= 86400000 || p.getStrategy() != 0 || this.mModel.i() == null || TbadkCoreApplication.getInst().getResumeNum() <= 0) {
                return;
            }
            TbSingleton.getInstance().setSyncModel(this.mModel);
            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        h0 q = this.mModel.q();
        if (q != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(q.c());
            TbadkCoreApplication.getInst().getListItemRule().f(q.A());
            TbadkCoreApplication.getInst().getListItemRule().e(q.s());
            TbadkCoreApplication.getInst().getListItemRule().d(q.r());
            TbadkCoreApplication.getInst().setUseNewResign(q.G());
            TbadkCoreApplication.getInst().setUegVoiceWarning(q.R());
            TbadkCoreApplication.getInst().setUrlText(q.S());
            TbadkCoreApplication.getInst().setGameInfoData(q.v(), q.x(), q.w());
            PullViewHelper.getInstance().saveOrUpdateImages(q.n(), q.o(), q.p(), q.l(), q.m());
            String f2 = q.f();
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            if (f2 == null) {
                f2 = "";
            }
            i.w("apply_vip_live_room_pid", f2);
            d.b.h0.r.d0.b.i().w("tail_link", q.Q());
            d.b.h0.r.d0.b.i().w("bubble_link", q.h());
            long T = q.T();
            if (T >= 0 && T != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(q.T());
            }
            long g2 = q.g() * 1000;
            if (g2 > 0) {
                d.b.h0.r.d0.b.i().v("KEY_UPLOAD_LOG_INTERVAL", g2);
            } else {
                long F = q.F() * 1000;
                if (F > 0) {
                    d.b.h0.r.d0.b.i().v("KEY_UPLOAD_LOG_INTERVAL", F);
                }
            }
            XiaoyingUtil.setShowTime(q.V());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(q.t());
            d.b.h0.r.d0.b.i().v("recommend_frs_cache_time", q.I());
            d.b.h0.r.d0.b.i().u("home_page_max_thread_count", q.u());
            d.b.h0.r.d0.b.i().s("localvideo_open", q.z());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
            d.b.h0.r.d0.b.i().u("card_show_statistic_max_count", q.w);
            d.b.h0.r.d0.b.i().w("nick_name_activity_link", q.H());
            String o = d.b.h0.r.d0.b.i().o("clean_smart_frs_cookie", "");
            String i2 = q.i();
            if (!TextUtils.equals(o, i2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
            }
            d.b.h0.r.d0.b.i().w("clean_smart_frs_cookie", i2);
            d.b.h0.r.d0.b.i().u("recommend_tab_show", q.e());
            d.b.h0.r.d0.b.i().u("ribao_switch", q.L());
            TbConfig.setMaxPhotoMemoryCache(q.J());
            d.b.h0.r.d0.b.i().u("key_card_show_type", q.P());
            TbadkCoreApplication.getInst().setCardShowType(q.P());
            d.b.h0.r.d0.b.i().u("key_card_abstract_switch", q.b());
            z E = q.E();
            if (E != null) {
                d.b.h0.r.d0.b.i().s("nani_key_is_show_download_nani_panel", E.f51242a);
                d.b.h0.r.d0.b.i().s("nani_key_is_activate_app", E.f51243b);
                d.b.h0.r.d0.b.i().u("nani_key_download_show_position", E.f51244c);
                d.b.h0.r.d0.b.i().u("nani_key_download_show_rate", E.f51245d);
                d.b.h0.r.d0.b.i().w("nani_key_download_link_url", E.f51246e);
                d.b.h0.r.d0.b.i().w("nani_key_download_txt", E.f51247f);
                d.b.h0.r.d0.b.i().w("nani_key_show_tail_txt", E.f51248g);
                d.b.h0.r.d0.b.i().u("nani_key_show_tail_video_type", E.f51249h);
                d.b.h0.r.d0.b.i().w("nani_key_show_tail_txt", E.f51248g);
                d.b.h0.r.d0.b.i().w("nani_key_pre_h5_link", E.i);
            }
            if (q.N() != null) {
                TbSingleton.getInstance().setShakeData(q.N());
            }
            if (!TextUtils.isEmpty(q.O())) {
                TbSingleton.getInstance().setSharePanelText(q.O());
            }
            d.b.h0.r.d0.b.i().v("key_frs_cache_time", q.q() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(q.j());
            TbSingleton.getInstance().setPushDialogShowTime(q.k());
            TbSingleton.getInstance().setCanShowPermDlg(q.a());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(q.W());
            TbSingleton.getInstance().setProfileGameCenterKey(q.K());
            TbSingleton.getInstance().setMissionEntranceUrl(q.D());
            TbSingleton.getInstance().setMissionEntranceIcon(q.B());
            TbSingleton.getInstance().setMissionEntranceObjSource(q.C());
            TbSingleton.getInstance().setWalletSignLink(q.U());
            TbSingleton.getInstance().setSampleId(q.M());
            TbSingleton.getInstance().setLiveForumMap(q.y());
            TbSingleton.getInstance().setClipboardDelayTime(q.d());
        }
    }

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticForAdvert(String str) {
        d.b.b.e.n.a a2 = j.a();
        a2.c("ad_sdk_priority", Integer.valueOf(d.b.h0.r.d0.b.i().j("splash_ad_strategy_key", 0)));
        a2.c("bear_sid_type", Integer.valueOf(d.b.h0.r.d0.b.i().j("splash_bear_sid_type_key", 0)));
        a2.b("ubs", d.b.h0.r.d0.b.i().o(d.b.h0.b.c.e(), null));
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
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.mHaveRetry = 0;
        checkUpdata();
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, e> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20934a;

        public b() {
            this.f20934a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public e doInBackground(String... strArr) {
            TiebaSyncService.this.statisticForAdvert("advert_before_sync");
            e eVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.f20934a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f20934a.addPostData("board", Build.BOARD);
                this.f20934a.addPostData("brand", Build.BRAND);
                this.f20934a.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.f20934a.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(app)));
                this.f20934a.addPostData("_phone_screen", stringBuffer.toString());
                this.f20934a.addPostData("scr_w", String.valueOf(l.k(app)));
                this.f20934a.addPostData("scr_h", String.valueOf(l.i(app)));
                this.f20934a.addPostData("scr_dip", String.valueOf(l.h(app)));
                String str = "0";
                if (d.d().e() > 0) {
                    this.f20934a.addPostData("_msg_status", "0");
                } else {
                    this.f20934a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str = activeVersion;
                    }
                    this.f20934a.addPostData("_active", str);
                }
                this.f20934a.addPostData("_pic_quality", String.valueOf(k.c().e()));
                if (TiebaSyncService.mStatistics != null) {
                    this.f20934a.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f20934a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f20934a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f20934a.addPostData("signmd5", TbMd5.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f20934a.addPostData(PackageTable.MD5, d.b.i0.l.a());
                String postNetData = this.f20934a.postNetData();
                if (this.f20934a.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.f20934a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar2 = new e();
                    try {
                        eVar2.u(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar2.g().a() != null && eVar2.g().a().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar2.g().a());
                            TbadkCoreApplication.setClientId(eVar2.g().a());
                        }
                        if (eVar2.i() != null) {
                            d.b.h0.r.d0.b.i().u("crash_limit_count", eVar2.i().b());
                        }
                        d.b.h0.s.c.d e2 = eVar2.e();
                        if (eVar2.e() != null && !TextUtils.isEmpty(e2.c())) {
                            d.b.h0.r.d0.b.i().w("sync_ad_privacy_url", e2.c());
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
                d.b.h0.z0.b.c().d();
                TiebaSyncService.this.mModel = eVar;
                d.b.i0.b.b(TiebaSyncService.this.mModel.f());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.l());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.j());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.k());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String r = TiebaSyncService.this.mModel.r();
                if (!StringUtils.isNull(r)) {
                    TbadkCoreApplication.getInst().setConfigVersion(r);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.m() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.m());
                }
                if (TiebaSyncService.this.mModel.e() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.e());
                }
                if (TiebaSyncService.this.mModel.d() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.d());
                }
                if (TiebaSyncService.this.mModel.a() != null) {
                    d.b.h0.z0.a.d().e(TiebaSyncService.this.mModel.a());
                }
                if (TiebaSyncService.this.mModel.b() != null) {
                    d.b.h0.z0.a.d().f(TiebaSyncService.this.mModel.b());
                }
                d.b.h0.b.b.e().i(TiebaSyncService.this.mModel.c());
                d.b.h0.b.c.d().h(TiebaSyncService.this.mModel.o());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                syncDataEvent.sampleId = TiebaSyncService.this.mModel.q() != null ? TiebaSyncService.this.mModel.q().M() : "";
                syncDataEvent.ubsABTest = TiebaSyncService.this.mModel.o() != null ? TiebaSyncService.this.mModel.o().toString() : "[]";
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.b();
                g.g(syncDataEvent);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                TiebaSyncService.this.statisticForAdvert("advert_after_sync");
                TiebaSyncService.this.stopSelf();
                return;
            }
            TiebaSyncService.access$1008(TiebaSyncService.this);
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
            NetWork netWork = this.f20934a;
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
