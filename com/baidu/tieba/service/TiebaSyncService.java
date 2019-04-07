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
import com.baidu.tieba.g;
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
        /* renamed from: E */
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
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.aQ(app)));
                this.mNetWork.x("_phone_screen", stringBuffer.toString());
                this.mNetWork.x("scr_w", String.valueOf(l.aO(app)));
                this.mNetWork.x("scr_h", String.valueOf(l.aQ(app)));
                this.mNetWork.x("scr_dip", String.valueOf(l.aR(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aih() > 0) {
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
                this.mNetWork.x("signmd5", as.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.x("md5", g.getTiebaApkMd5());
                String acg = this.mNetWork.acg();
                if (this.mNetWork.acH()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.acE().adD().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(acg);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aiM().getClientId() != null && dVar.aiM().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aiM().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aiM().getClientId());
                        }
                        if (dVar.aiI() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.aiI().getCrashLimitCount());
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
                this.mNetWork.ji();
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
                com.baidu.tbadk.util.b.apK().apL();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.aiO());
                if (TiebaSyncService.this.mModel.aiL().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.aiL());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.aiL().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.aiI() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aiL(), TiebaSyncService.this.mModel.aiK())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.aiL().getStrategy() == 0 && TiebaSyncService.this.mModel.aiI() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aiL(), TiebaSyncService.this.mModel.aiK())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aiP());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aiQ());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int agn = dVar.aiI().agn();
                if (agn > 0 && nextInt % agn == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String aiJ = TiebaSyncService.this.mModel.aiJ();
                if (!StringUtils.isNull(aiJ)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aiJ);
                }
                if (TiebaSyncService.this.mModel.aiN() != null && TiebaSyncService.this.mModel.aiN().ahv() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.aiN().ahv());
                }
                if (TiebaSyncService.this.mModel.aiN() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.aiN().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.aiN().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.aiN() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.aiN().ahw());
                }
                z aiN = TiebaSyncService.this.mModel.aiN();
                if (aiN != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(aiN.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().nF(aiN.agP());
                    TbadkCoreApplication.getInst().getListItemRule().nH(aiN.agR());
                    TbadkCoreApplication.getInst().getListItemRule().nG(aiN.agQ());
                    TbadkCoreApplication.getInst().setUseNewResign(aiN.ahd());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(aiN.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(aiN.ahl());
                    TbadkCoreApplication.getInst().setGameInfoData(aiN.ahe(), aiN.ahg(), aiN.ahf());
                    af.acS().b(aiN.agK(), aiN.agL(), aiN.agM(), aiN.agN(), aiN.agO());
                    String agJ = aiN.agJ();
                    b bVar = b.getInstance();
                    if (agJ == null) {
                        agJ = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", agJ);
                    b.getInstance().putString("tail_link", aiN.agS());
                    b.getInstance().putString("bubble_link", aiN.agT());
                    long agU = aiN.agU();
                    if (agU >= 0 && agU != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(aiN.agU());
                    }
                    long ahn = aiN.ahn() * 1000;
                    if (ahn > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", ahn);
                    } else {
                        long ahm = aiN.ahm() * 1000;
                        if (ahm > 0) {
                            b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", ahm);
                        }
                    }
                    XiaoyingUtil.setShowTime(aiN.agV());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(aiN.agW());
                    b.getInstance().putLong("recommend_frs_cache_time", aiN.ahb());
                    b.getInstance().putInt("home_page_max_thread_count", aiN.ahc());
                    b.getInstance().putBoolean("localvideo_open", aiN.ahi());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", aiN.bYa);
                    b.getInstance().putString("nick_name_activity_link", aiN.ahk());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String ahh = aiN.ahh();
                    if (!TextUtils.equals(string, ahh)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", ahh);
                    b.getInstance().putInt("recommend_tab_show", aiN.agX());
                    b.getInstance().putInt("ribao_switch", aiN.agY());
                    b.getInstance().putInt("home_default_page", aiN.agZ());
                    b.getInstance().putInt("home_remember_page", aiN.aha());
                    TbConfig.setMaxPhotoMemoryCache(aiN.ahj());
                    b.getInstance().putInt("key_card_show_type", aiN.aho());
                    TbadkCoreApplication.getInst().setCardShowType(aiN.aho());
                    b.getInstance().putInt("key_card_abstract_switch", aiN.ahp());
                    s ahq = aiN.ahq();
                    if (ahq != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", ahq.bXo);
                        b.getInstance().putBoolean("nani_key_is_activate_app", ahq.bXp);
                        b.getInstance().putInt("nani_key_download_show_position", ahq.bXq);
                        b.getInstance().putInt("nani_key_download_show_rate", ahq.bXr);
                        b.getInstance().putString("nani_key_download_link_url", ahq.bXs);
                        b.getInstance().putString("nani_key_download_txt", ahq.bXt);
                        b.getInstance().putString("nani_key_show_tail_txt", ahq.bXu);
                        b.getInstance().putInt("nani_key_show_tail_video_type", ahq.bXv);
                        b.getInstance().putString("nani_key_show_tail_txt", ahq.bXu);
                        b.getInstance().putString("nani_key_pre_h5_link", ahq.bXw);
                    }
                    b.getInstance().putLong("key_frs_cache_time", aiN.ahr() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(aiN.ahs());
                    TbSingleton.getInstance().setPushDialogShowTime(aiN.aht());
                    TbSingleton.getInstance().setCanShowPermDlg(aiN.ahu());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.aiI() != null && TiebaSyncService.this.mModel.aiI().ago() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.aiI().ago().agz());
                }
                if (TiebaSyncService.this.mModel.aiI() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.aiI().agp());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String agv = TiebaSyncService.this.mModel.getProfileData().agv();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.getInstance().putString("sync_send_maintab_my_tab_lottie_url", agv);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aiR() != null) {
                    com.baidu.tbadk.util.a.apJ().a(TiebaSyncService.this.mModel.aiR());
                }
                if (TiebaSyncService.this.mModel.aiS() != null) {
                    com.baidu.tbadk.a.b.UA().v(TiebaSyncService.this.mModel.aiS());
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
