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
import com.baidu.tbadk.core.util.at;
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
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aon() > 0) {
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
                this.mNetWork.o("signmd5", at.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.o("md5", f.getTiebaApkMd5());
                String aig = this.mNetWork.aig();
                if (this.mNetWork.aiH()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(aig);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aoS().getClientId() != null && dVar.aoS().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aoS().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aoS().getClientId());
                        }
                        if (dVar.aoO() != null) {
                            b.ahO().putInt("crash_limit_count", dVar.aoO().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.ahO().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
                this.mNetWork.ik();
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
                com.baidu.tbadk.util.b.avX().avY();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.aoU());
                if (TiebaSyncService.this.mModel.aoR().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.aoR());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.aoR().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.aoO() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aoR(), TiebaSyncService.this.mModel.aoQ())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.aoR().getStrategy() == 0 && TiebaSyncService.this.mModel.aoO() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aoR(), TiebaSyncService.this.mModel.aoQ())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aoV());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aoW());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int amr = dVar.aoO().amr();
                if (amr > 0 && nextInt % amr == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String aoP = TiebaSyncService.this.mModel.aoP();
                if (!StringUtils.isNull(aoP)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aoP);
                }
                if (TiebaSyncService.this.mModel.aoT() != null && TiebaSyncService.this.mModel.aoT().anz() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.aoT().anz());
                }
                if (TiebaSyncService.this.mModel.aoT() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.aoT().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.aoT().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.aoT() != null) {
                    TbSingleton.getInstance().setMissionEntranceUrl(TiebaSyncService.this.mModel.aoT().getMissionEntranceUrl());
                    TbSingleton.getInstance().setMissionEntranceIcon(TiebaSyncService.this.mModel.aoT().getMissionEntranceIcon());
                }
                if (TiebaSyncService.this.mModel.aoT() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.aoT().anA());
                }
                if (TiebaSyncService.this.mModel.aoT() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.aoT().anB());
                }
                if (TiebaSyncService.this.mModel.aoT() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.aoT().anC());
                }
                z aoT = TiebaSyncService.this.mModel.aoT();
                if (aoT != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(aoT.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().pf(aoT.amT());
                    TbadkCoreApplication.getInst().getListItemRule().ph(aoT.amV());
                    TbadkCoreApplication.getInst().getListItemRule().pg(aoT.amU());
                    TbadkCoreApplication.getInst().setUseNewResign(aoT.anh());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(aoT.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(aoT.anp());
                    TbadkCoreApplication.getInst().setGameInfoData(aoT.ani(), aoT.ank(), aoT.anj());
                    af.aiS().e(aoT.amO(), aoT.amP(), aoT.amQ(), aoT.amR(), aoT.amS());
                    String amN = aoT.amN();
                    b ahO = b.ahO();
                    if (amN == null) {
                        amN = "";
                    }
                    ahO.putString("apply_vip_live_room_pid", amN);
                    b.ahO().putString("tail_link", aoT.amW());
                    b.ahO().putString("bubble_link", aoT.amX());
                    long amY = aoT.amY();
                    if (amY >= 0 && amY != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(aoT.amY());
                    }
                    long anr = aoT.anr() * 1000;
                    if (anr > 0) {
                        b.ahO().putLong("KEY_UPLOAD_LOG_INTERVAL", anr);
                    } else {
                        long anq = aoT.anq() * 1000;
                        if (anq > 0) {
                            b.ahO().putLong("KEY_UPLOAD_LOG_INTERVAL", anq);
                        }
                    }
                    XiaoyingUtil.setShowTime(aoT.amZ());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(aoT.ana());
                    b.ahO().putLong("recommend_frs_cache_time", aoT.anf());
                    b.ahO().putInt("home_page_max_thread_count", aoT.ang());
                    b.ahO().putBoolean("localvideo_open", aoT.anm());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.ahO().putInt("card_show_statistic_max_count", aoT.chc);
                    b.ahO().putString("nick_name_activity_link", aoT.ano());
                    String string = b.ahO().getString("clean_smart_frs_cookie", "");
                    String anl = aoT.anl();
                    if (!TextUtils.equals(string, anl)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.ahO().putString("clean_smart_frs_cookie", anl);
                    b.ahO().putInt("recommend_tab_show", aoT.anb());
                    b.ahO().putInt("ribao_switch", aoT.anc());
                    b.ahO().putInt("home_default_page", aoT.and());
                    b.ahO().putInt("home_remember_page", aoT.ane());
                    TbConfig.setMaxPhotoMemoryCache(aoT.ann());
                    b.ahO().putInt("key_card_show_type", aoT.ans());
                    TbadkCoreApplication.getInst().setCardShowType(aoT.ans());
                    b.ahO().putInt("key_card_abstract_switch", aoT.ant());
                    s anu = aoT.anu();
                    if (anu != null) {
                        b.ahO().putBoolean("nani_key_is_show_download_nani_panel", anu.cgq);
                        b.ahO().putBoolean("nani_key_is_activate_app", anu.cgr);
                        b.ahO().putInt("nani_key_download_show_position", anu.cgs);
                        b.ahO().putInt("nani_key_download_show_rate", anu.cgt);
                        b.ahO().putString("nani_key_download_link_url", anu.cgu);
                        b.ahO().putString("nani_key_download_txt", anu.cgv);
                        b.ahO().putString("nani_key_show_tail_txt", anu.cgw);
                        b.ahO().putInt("nani_key_show_tail_video_type", anu.cgx);
                        b.ahO().putString("nani_key_show_tail_txt", anu.cgw);
                        b.ahO().putString("nani_key_pre_h5_link", anu.cgy);
                    }
                    b.ahO().putLong("key_frs_cache_time", aoT.anv() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(aoT.anw());
                    TbSingleton.getInstance().setPushDialogShowTime(aoT.anx());
                    TbSingleton.getInstance().setCanShowPermDlg(aoT.any());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.aoO() != null && TiebaSyncService.this.mModel.aoO().ams() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.aoO().ams().amD());
                }
                if (TiebaSyncService.this.mModel.aoO() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.aoO().amt());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String amz = TiebaSyncService.this.mModel.getProfileData().amz();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.ahO().putString("sync_send_maintab_my_tab_lottie_url", amz);
                    b.ahO().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.ahO().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aoX() != null) {
                    com.baidu.tbadk.util.a.avW().a(TiebaSyncService.this.mModel.aoX());
                }
                if (TiebaSyncService.this.mModel.aoY() != null) {
                    com.baidu.tbadk.a.b.aad().u(TiebaSyncService.this.mModel.aoY());
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
