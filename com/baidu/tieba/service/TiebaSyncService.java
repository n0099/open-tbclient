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
import com.baidu.tbadk.plugin.PluginErrorTipActivity;
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
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aik() > 0) {
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
                String acj = this.mNetWork.acj();
                if (this.mNetWork.acK()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.acH().adG().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(acj);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aiP().getClientId() != null && dVar.aiP().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aiP().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aiP().getClientId());
                        }
                        if (dVar.aiL() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.aiL().getCrashLimitCount());
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
                com.baidu.tbadk.util.b.apN().apO();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.aiR());
                if (TiebaSyncService.this.mModel.aiO().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.aiO());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.aiO().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.aiL() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aiO(), TiebaSyncService.this.mModel.aiN())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.aiO().getStrategy() == 0 && TiebaSyncService.this.mModel.aiL() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aiO(), TiebaSyncService.this.mModel.aiN())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aiS());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aiT());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int agq = dVar.aiL().agq();
                if (agq > 0 && nextInt % agq == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String aiM = TiebaSyncService.this.mModel.aiM();
                if (!StringUtils.isNull(aiM)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aiM);
                }
                if (TiebaSyncService.this.mModel.aiQ() != null && TiebaSyncService.this.mModel.aiQ().ahy() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.aiQ().ahy());
                }
                if (TiebaSyncService.this.mModel.aiQ() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.aiQ().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.aiQ().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.aiQ() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.aiQ().ahz());
                }
                PluginErrorTipActivity.crD = TiebaSyncService.this.mModel.aiV();
                z aiQ = TiebaSyncService.this.mModel.aiQ();
                if (aiQ != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(aiQ.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().nE(aiQ.agS());
                    TbadkCoreApplication.getInst().getListItemRule().nG(aiQ.agU());
                    TbadkCoreApplication.getInst().getListItemRule().nF(aiQ.agT());
                    TbadkCoreApplication.getInst().setUseNewResign(aiQ.ahg());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(aiQ.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(aiQ.aho());
                    TbadkCoreApplication.getInst().setGameInfoData(aiQ.ahh(), aiQ.ahj(), aiQ.ahi());
                    af.acV().b(aiQ.agN(), aiQ.agO(), aiQ.agP(), aiQ.agQ(), aiQ.agR());
                    String agM = aiQ.agM();
                    b bVar = b.getInstance();
                    if (agM == null) {
                        agM = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", agM);
                    b.getInstance().putString("tail_link", aiQ.agV());
                    b.getInstance().putString("bubble_link", aiQ.agW());
                    long agX = aiQ.agX();
                    if (agX >= 0 && agX != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(aiQ.agX());
                    }
                    long ahq = aiQ.ahq() * 1000;
                    if (ahq > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", ahq);
                    } else {
                        long ahp = aiQ.ahp() * 1000;
                        if (ahp > 0) {
                            b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", ahp);
                        }
                    }
                    XiaoyingUtil.setShowTime(aiQ.agY());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(aiQ.agZ());
                    b.getInstance().putLong("recommend_frs_cache_time", aiQ.ahe());
                    b.getInstance().putInt("home_page_max_thread_count", aiQ.ahf());
                    b.getInstance().putBoolean("localvideo_open", aiQ.ahl());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", aiQ.bXX);
                    b.getInstance().putString("nick_name_activity_link", aiQ.ahn());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String ahk = aiQ.ahk();
                    if (!TextUtils.equals(string, ahk)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", ahk);
                    b.getInstance().putInt("recommend_tab_show", aiQ.aha());
                    b.getInstance().putInt("ribao_switch", aiQ.ahb());
                    b.getInstance().putInt("home_default_page", aiQ.ahc());
                    b.getInstance().putInt("home_remember_page", aiQ.ahd());
                    TbConfig.setMaxPhotoMemoryCache(aiQ.ahm());
                    b.getInstance().putInt("key_card_show_type", aiQ.ahr());
                    TbadkCoreApplication.getInst().setCardShowType(aiQ.ahr());
                    b.getInstance().putInt("key_card_abstract_switch", aiQ.ahs());
                    s aht = aiQ.aht();
                    if (aht != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", aht.bXl);
                        b.getInstance().putBoolean("nani_key_is_activate_app", aht.bXm);
                        b.getInstance().putInt("nani_key_download_show_position", aht.bXn);
                        b.getInstance().putInt("nani_key_download_show_rate", aht.bXo);
                        b.getInstance().putString("nani_key_download_link_url", aht.bXp);
                        b.getInstance().putString("nani_key_download_txt", aht.bXq);
                        b.getInstance().putString("nani_key_show_tail_txt", aht.bXr);
                        b.getInstance().putInt("nani_key_show_tail_video_type", aht.bXs);
                        b.getInstance().putString("nani_key_show_tail_txt", aht.bXr);
                        b.getInstance().putString("nani_key_pre_h5_link", aht.bXt);
                    }
                    b.getInstance().putLong("key_frs_cache_time", aiQ.ahu() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(aiQ.ahv());
                    TbSingleton.getInstance().setPushDialogShowTime(aiQ.ahw());
                    TbSingleton.getInstance().setCanShowPermDlg(aiQ.ahx());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.aiL() != null && TiebaSyncService.this.mModel.aiL().agr() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.aiL().agr().agC());
                }
                if (TiebaSyncService.this.mModel.aiL() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.aiL().ags());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String agy = TiebaSyncService.this.mModel.getProfileData().agy();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.getInstance().putString("sync_send_maintab_my_tab_lottie_url", agy);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aiU() != null) {
                    com.baidu.tbadk.util.a.apM().a(TiebaSyncService.this.mModel.aiU());
                }
                if (TiebaSyncService.this.mModel.aiW() != null) {
                    com.baidu.tbadk.a.b.UD().v(TiebaSyncService.this.mModel.aiW());
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
