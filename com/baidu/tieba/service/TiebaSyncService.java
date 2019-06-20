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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.f;
import com.xiaomi.mipush.sdk.Constants;
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
        /* renamed from: D */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.o("board", Build.BOARD);
                this.mNetWork.o(Constants.PHONE_BRAND, Build.BRAND);
                this.mNetWork.o("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.o("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.af(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.ah(app)));
                this.mNetWork.o("_phone_screen", stringBuffer.toString());
                this.mNetWork.o("scr_w", String.valueOf(l.af(app)));
                this.mNetWork.o("scr_h", String.valueOf(l.ah(app)));
                this.mNetWork.o("scr_dip", String.valueOf(l.ai(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().ani() > 0) {
                    this.mNetWork.o("_msg_status", "0");
                } else {
                    this.mNetWork.o("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.o("_active", activeVersion);
                }
                this.mNetWork.o("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.o("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.o("package", packageName);
                this.mNetWork.o("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.o("signmd5", as.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.o("md5", f.getTiebaApkMd5());
                String ahe = this.mNetWork.ahe();
                if (this.mNetWork.ahF()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(ahe);
                        if (TbadkCoreApplication.getClientId() == null && dVar.anN().getClientId() != null && dVar.anN().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.anN().getClientId());
                            TbadkCoreApplication.setClientId(dVar.anN().getClientId());
                        }
                        if (dVar.anJ() != null) {
                            b.agM().putInt("crash_limit_count", dVar.anJ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.agM().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
                this.mNetWork.ia();
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
                com.baidu.tbadk.util.b.auO().auP();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.anP());
                if (TiebaSyncService.this.mModel.anM().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.anM());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.anM().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.anJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.anM(), TiebaSyncService.this.mModel.anL())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.anM().getStrategy() == 0 && TiebaSyncService.this.mModel.anJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.anM(), TiebaSyncService.this.mModel.anL())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.anQ());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.anR());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int alm = dVar.anJ().alm();
                if (alm > 0 && nextInt % alm == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String anK = TiebaSyncService.this.mModel.anK();
                if (!StringUtils.isNull(anK)) {
                    TbadkCoreApplication.getInst().setConfigVersion(anK);
                }
                if (TiebaSyncService.this.mModel.anO() != null && TiebaSyncService.this.mModel.anO().amu() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.anO().amu());
                }
                if (TiebaSyncService.this.mModel.anO() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.anO().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.anO().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.anO() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.anO().amv());
                }
                if (TiebaSyncService.this.mModel.anO() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.anO().amw());
                }
                if (TiebaSyncService.this.mModel.anO() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.anO().amx());
                }
                z anO = TiebaSyncService.this.mModel.anO();
                if (anO != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(anO.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().oO(anO.alO());
                    TbadkCoreApplication.getInst().getListItemRule().oQ(anO.alQ());
                    TbadkCoreApplication.getInst().getListItemRule().oP(anO.alP());
                    TbadkCoreApplication.getInst().setUseNewResign(anO.amc());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(anO.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(anO.amk());
                    TbadkCoreApplication.getInst().setGameInfoData(anO.amd(), anO.amf(), anO.ame());
                    af.ahQ().e(anO.alJ(), anO.alK(), anO.alL(), anO.alM(), anO.alN());
                    String alI = anO.alI();
                    b agM = b.agM();
                    if (alI == null) {
                        alI = "";
                    }
                    agM.putString("apply_vip_live_room_pid", alI);
                    b.agM().putString("tail_link", anO.alR());
                    b.agM().putString("bubble_link", anO.alS());
                    long alT = anO.alT();
                    if (alT >= 0 && alT != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(anO.alT());
                    }
                    long amm = anO.amm() * 1000;
                    if (amm > 0) {
                        b.agM().putLong("KEY_UPLOAD_LOG_INTERVAL", amm);
                    } else {
                        long aml = anO.aml() * 1000;
                        if (aml > 0) {
                            b.agM().putLong("KEY_UPLOAD_LOG_INTERVAL", aml);
                        }
                    }
                    XiaoyingUtil.setShowTime(anO.alU());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(anO.alV());
                    b.agM().putLong("recommend_frs_cache_time", anO.ama());
                    b.agM().putInt("home_page_max_thread_count", anO.amb());
                    b.agM().putBoolean("localvideo_open", anO.amh());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.agM().putInt("card_show_statistic_max_count", anO.cfX);
                    b.agM().putString("nick_name_activity_link", anO.amj());
                    String string = b.agM().getString("clean_smart_frs_cookie", "");
                    String amg = anO.amg();
                    if (!TextUtils.equals(string, amg)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.agM().putString("clean_smart_frs_cookie", amg);
                    b.agM().putInt("recommend_tab_show", anO.alW());
                    b.agM().putInt("ribao_switch", anO.alX());
                    b.agM().putInt("home_default_page", anO.alY());
                    b.agM().putInt("home_remember_page", anO.alZ());
                    TbConfig.setMaxPhotoMemoryCache(anO.ami());
                    b.agM().putInt("key_card_show_type", anO.amn());
                    TbadkCoreApplication.getInst().setCardShowType(anO.amn());
                    b.agM().putInt("key_card_abstract_switch", anO.amo());
                    s amp = anO.amp();
                    if (amp != null) {
                        b.agM().putBoolean("nani_key_is_show_download_nani_panel", amp.cfl);
                        b.agM().putBoolean("nani_key_is_activate_app", amp.cfm);
                        b.agM().putInt("nani_key_download_show_position", amp.cfn);
                        b.agM().putInt("nani_key_download_show_rate", amp.cfo);
                        b.agM().putString("nani_key_download_link_url", amp.cfp);
                        b.agM().putString("nani_key_download_txt", amp.cfq);
                        b.agM().putString("nani_key_show_tail_txt", amp.cfr);
                        b.agM().putInt("nani_key_show_tail_video_type", amp.cfs);
                        b.agM().putString("nani_key_show_tail_txt", amp.cfr);
                        b.agM().putString("nani_key_pre_h5_link", amp.cft);
                    }
                    b.agM().putLong("key_frs_cache_time", anO.amq() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(anO.amr());
                    TbSingleton.getInstance().setPushDialogShowTime(anO.ams());
                    TbSingleton.getInstance().setCanShowPermDlg(anO.amt());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.anJ() != null && TiebaSyncService.this.mModel.anJ().aln() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.anJ().aln().aly());
                }
                if (TiebaSyncService.this.mModel.anJ() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.anJ().alo());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String alu = TiebaSyncService.this.mModel.getProfileData().alu();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.agM().putString("sync_send_maintab_my_tab_lottie_url", alu);
                    b.agM().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.agM().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.anS() != null) {
                    com.baidu.tbadk.util.a.auN().a(TiebaSyncService.this.mModel.anS());
                }
                if (TiebaSyncService.this.mModel.anT() != null) {
                    com.baidu.tbadk.a.b.Ze().u(TiebaSyncService.this.mModel.anT());
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
