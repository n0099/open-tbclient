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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.h;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private int mHaveRetry = 0;
    private d mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaSyncService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaSyncService.this.checkUpdata();
        }
    };

    static /* synthetic */ int access$608(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        return i;
    }

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mSyncTask = new a();
        this.mSyncTask.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastNewVersion() {
        if (this.mModel != null) {
            TbadkCoreApplication.getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, d> {
        x mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.x("board", Build.BOARD);
                this.mNetWork.x("brand", Build.BRAND);
                this.mNetWork.x("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.x("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.aO(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aQ(app)));
                this.mNetWork.x("_phone_screen", stringBuffer.toString());
                this.mNetWork.x("scr_w", String.valueOf(l.aO(app)));
                this.mNetWork.x("scr_h", String.valueOf(l.aQ(app)));
                this.mNetWork.x("scr_dip", String.valueOf(l.aR(app)));
                if (c.Ix().IA() > 0) {
                    this.mNetWork.x("_msg_status", "0");
                } else {
                    this.mNetWork.x("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.x("_active", activeVersion);
                }
                this.mNetWork.x("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.x("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.x("package", packageName);
                this.mNetWork.x("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.x("signmd5", ar.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.x(ARResourceKey.HTTP_AR_MD5, h.getTiebaApkMd5());
                String CL = this.mNetWork.CL();
                if (this.mNetWork.Dm()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(CL);
                        if (TbadkCoreApplication.getClientId() == null && dVar.Je().getClientId() != null && dVar.Je().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.Je().getClientId());
                            TbadkCoreApplication.setClientId(dVar.Je().getClientId());
                        }
                        if (dVar.Ja() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.Ja().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.getInstance().putString("sync_ad_privacy_url", adAdSense.getUrl());
                        }
                        String unused = TiebaSyncService.mStatistics = null;
                        return dVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        return dVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                dVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaSyncService.this.mSyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            int performSampleCount;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.b.PK().PL();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.Jg());
                if (TiebaSyncService.this.mModel.Jd().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.Jd());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.Jd().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.Ja() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Jd(), TiebaSyncService.this.mModel.Jc())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.Jd().getStrategy() == 0 && TiebaSyncService.this.mModel.Ja() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Jd(), TiebaSyncService.this.mModel.Jc())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.Jh());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.Ji());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int GK = dVar.Ja().GK();
                if (GK > 0 && nextInt % GK == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String Jb = TiebaSyncService.this.mModel.Jb();
                if (!StringUtils.isNull(Jb)) {
                    TbadkCoreApplication.getInst().setConfigVersion(Jb);
                }
                y Jf = TiebaSyncService.this.mModel.Jf();
                if (Jf != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(Jf.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().gF(Jf.Hl());
                    TbadkCoreApplication.getInst().getListItemRule().gH(Jf.Hn());
                    TbadkCoreApplication.getInst().getListItemRule().gG(Jf.Hm());
                    TbadkCoreApplication.getInst().setUseNewResign(Jf.Hz());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(Jf.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(Jf.HH());
                    TbadkCoreApplication.getInst().setGameInfoData(Jf.HA(), Jf.HC(), Jf.HB());
                    af.Dx().b(Jf.Hg(), Jf.Hh(), Jf.Hi(), Jf.Hj(), Jf.Hk());
                    String Hf = Jf.Hf();
                    b bVar = b.getInstance();
                    if (Hf == null) {
                        Hf = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", Hf);
                    b.getInstance().putString("tail_link", Jf.Ho());
                    b.getInstance().putString("bubble_link", Jf.Hp());
                    long Hq = Jf.Hq();
                    if (Hq >= 0 && Hq != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(Jf.Hq());
                    }
                    long HI = Jf.HI() * 1000;
                    if (HI > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", HI);
                    }
                    XiaoyingUtil.setShowTime(Jf.Hr());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(Jf.Hs());
                    b.getInstance().putLong("recommend_frs_cache_time", Jf.Hx());
                    b.getInstance().putInt("home_page_max_thread_count", Jf.Hy());
                    b.getInstance().putBoolean("localvideo_open", Jf.HE());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", Jf.aOV);
                    b.getInstance().putString("nick_name_activity_link", Jf.HG());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String HD = Jf.HD();
                    if (!TextUtils.equals(string, HD)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", HD);
                    b.getInstance().putInt("recommend_tab_show", Jf.Ht());
                    b.getInstance().putInt("ribao_switch", Jf.Hu());
                    b.getInstance().putInt("home_default_page", Jf.Hv());
                    b.getInstance().putInt("home_remember_page", Jf.Hw());
                    TbConfig.setMaxPhotoMemoryCache(Jf.HF());
                    b.getInstance().putInt("key_card_show_type", Jf.HJ());
                    TbadkCoreApplication.getInst().setCardShowType(Jf.HJ());
                    b.getInstance().putInt("key_card_abstract_switch", Jf.HK());
                    s HL = Jf.HL();
                    if (HL != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", HL.aOk);
                        b.getInstance().putBoolean("nani_key_is_activate_app", HL.aOl);
                        b.getInstance().putInt("nani_key_download_show_position", HL.aOm);
                        b.getInstance().putInt("nani_key_download_show_rate", HL.aOn);
                        b.getInstance().putString("nani_key_download_link_url", HL.aOo);
                        b.getInstance().putString("nani_key_download_txt", HL.aOp);
                        b.getInstance().putString("nani_key_show_tail_txt", HL.aOq);
                        b.getInstance().putInt("nani_key_show_tail_video_type", HL.aOr);
                        b.getInstance().putString("nani_key_show_tail_txt", HL.aOq);
                        b.getInstance().putString("nani_key_pre_h5_link", HL.aOs);
                    }
                    b.getInstance().putLong("key_frs_cache_time", Jf.HM() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(Jf.HN());
                    TbSingleton.getInstance().setPushDialogShowTime(Jf.HO());
                    TbSingleton.getInstance().setCanShowPermDlg(Jf.HP());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.Ja() != null && TiebaSyncService.this.mModel.Ja().GL() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.Ja().GL().GV());
                }
                if (TiebaSyncService.this.mModel.Ja() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.Ja().GM());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String GS = TiebaSyncService.this.mModel.getProfileData().GS();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.getInstance().putString("sync_send_maintab_my_tab_lottie_url", GS);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.Jj() != null) {
                    com.baidu.tbadk.util.a.PJ().a(TiebaSyncService.this.mModel.Jj());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                return;
            }
            TiebaSyncService.access$608(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
