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
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aop() > 0) {
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
                String aii = this.mNetWork.aii();
                if (this.mNetWork.aiJ()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(aii);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aoU().getClientId() != null && dVar.aoU().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aoU().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aoU().getClientId());
                        }
                        if (dVar.aoQ() != null) {
                            b.ahQ().putInt("crash_limit_count", dVar.aoQ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.ahQ().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
                com.baidu.tbadk.util.b.avZ().awa();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.aoW());
                if (TiebaSyncService.this.mModel.aoT().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.aoT());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.aoT().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.aoQ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aoT(), TiebaSyncService.this.mModel.aoS())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.aoT().getStrategy() == 0 && TiebaSyncService.this.mModel.aoQ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.aoT(), TiebaSyncService.this.mModel.aoS())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aoX());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aoY());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int amt = dVar.aoQ().amt();
                if (amt > 0 && nextInt % amt == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String aoR = TiebaSyncService.this.mModel.aoR();
                if (!StringUtils.isNull(aoR)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aoR);
                }
                if (TiebaSyncService.this.mModel.aoV() != null && TiebaSyncService.this.mModel.aoV().anB() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.aoV().anB());
                }
                if (TiebaSyncService.this.mModel.aoV() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.aoV().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.aoV().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.aoV() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.aoV().anC());
                }
                if (TiebaSyncService.this.mModel.aoV() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.aoV().anD());
                }
                if (TiebaSyncService.this.mModel.aoV() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.aoV().anE());
                }
                z aoV = TiebaSyncService.this.mModel.aoV();
                if (aoV != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(aoV.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().pf(aoV.amV());
                    TbadkCoreApplication.getInst().getListItemRule().ph(aoV.amX());
                    TbadkCoreApplication.getInst().getListItemRule().pg(aoV.amW());
                    TbadkCoreApplication.getInst().setUseNewResign(aoV.anj());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(aoV.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(aoV.anr());
                    TbadkCoreApplication.getInst().setGameInfoData(aoV.ank(), aoV.anm(), aoV.anl());
                    af.aiU().e(aoV.amQ(), aoV.amR(), aoV.amS(), aoV.amT(), aoV.amU());
                    String amP = aoV.amP();
                    b ahQ = b.ahQ();
                    if (amP == null) {
                        amP = "";
                    }
                    ahQ.putString("apply_vip_live_room_pid", amP);
                    b.ahQ().putString("tail_link", aoV.amY());
                    b.ahQ().putString("bubble_link", aoV.amZ());
                    long ana = aoV.ana();
                    if (ana >= 0 && ana != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(aoV.ana());
                    }
                    long ant = aoV.ant() * 1000;
                    if (ant > 0) {
                        b.ahQ().putLong("KEY_UPLOAD_LOG_INTERVAL", ant);
                    } else {
                        long ans = aoV.ans() * 1000;
                        if (ans > 0) {
                            b.ahQ().putLong("KEY_UPLOAD_LOG_INTERVAL", ans);
                        }
                    }
                    XiaoyingUtil.setShowTime(aoV.anb());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(aoV.anc());
                    b.ahQ().putLong("recommend_frs_cache_time", aoV.anh());
                    b.ahQ().putInt("home_page_max_thread_count", aoV.ani());
                    b.ahQ().putBoolean("localvideo_open", aoV.ano());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.ahQ().putInt("card_show_statistic_max_count", aoV.chj);
                    b.ahQ().putString("nick_name_activity_link", aoV.anq());
                    String string = b.ahQ().getString("clean_smart_frs_cookie", "");
                    String ann = aoV.ann();
                    if (!TextUtils.equals(string, ann)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.ahQ().putString("clean_smart_frs_cookie", ann);
                    b.ahQ().putInt("recommend_tab_show", aoV.and());
                    b.ahQ().putInt("ribao_switch", aoV.ane());
                    b.ahQ().putInt("home_default_page", aoV.anf());
                    b.ahQ().putInt("home_remember_page", aoV.ang());
                    TbConfig.setMaxPhotoMemoryCache(aoV.anp());
                    b.ahQ().putInt("key_card_show_type", aoV.anu());
                    TbadkCoreApplication.getInst().setCardShowType(aoV.anu());
                    b.ahQ().putInt("key_card_abstract_switch", aoV.anv());
                    s anw = aoV.anw();
                    if (anw != null) {
                        b.ahQ().putBoolean("nani_key_is_show_download_nani_panel", anw.cgx);
                        b.ahQ().putBoolean("nani_key_is_activate_app", anw.cgy);
                        b.ahQ().putInt("nani_key_download_show_position", anw.cgz);
                        b.ahQ().putInt("nani_key_download_show_rate", anw.cgA);
                        b.ahQ().putString("nani_key_download_link_url", anw.cgB);
                        b.ahQ().putString("nani_key_download_txt", anw.cgC);
                        b.ahQ().putString("nani_key_show_tail_txt", anw.cgD);
                        b.ahQ().putInt("nani_key_show_tail_video_type", anw.cgE);
                        b.ahQ().putString("nani_key_show_tail_txt", anw.cgD);
                        b.ahQ().putString("nani_key_pre_h5_link", anw.cgF);
                    }
                    b.ahQ().putLong("key_frs_cache_time", aoV.anx() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(aoV.any());
                    TbSingleton.getInstance().setPushDialogShowTime(aoV.anz());
                    TbSingleton.getInstance().setCanShowPermDlg(aoV.anA());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.aoQ() != null && TiebaSyncService.this.mModel.aoQ().amu() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.aoQ().amu().amF());
                }
                if (TiebaSyncService.this.mModel.aoQ() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.aoQ().amv());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String amB = TiebaSyncService.this.mModel.getProfileData().amB();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.ahQ().putString("sync_send_maintab_my_tab_lottie_url", amB);
                    b.ahQ().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.ahQ().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aoZ() != null) {
                    com.baidu.tbadk.util.a.avY().a(TiebaSyncService.this.mModel.aoZ());
                }
                if (TiebaSyncService.this.mModel.apa() != null) {
                    com.baidu.tbadk.a.b.aad().u(TiebaSyncService.this.mModel.apa());
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
