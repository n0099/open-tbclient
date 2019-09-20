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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.t;
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
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoB() > 0) {
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
                this.mNetWork.o("md5", g.getTiebaApkMd5());
                String aim = this.mNetWork.aim();
                if (this.mNetWork.aiN()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(aim);
                        if (TbadkCoreApplication.getClientId() == null && dVar.apg().getClientId() != null && dVar.apg().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.apg().getClientId());
                            TbadkCoreApplication.setClientId(dVar.apg().getClientId());
                        }
                        if (dVar.apc() != null) {
                            b.ahU().putInt("crash_limit_count", dVar.apc().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.ahU().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
                com.baidu.tbadk.util.b.awl().awm();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.apj());
                if (TiebaSyncService.this.mModel.apf().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.apf());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.apf().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.apc() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.apf(), TiebaSyncService.this.mModel.ape())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.apf().getStrategy() == 0 && TiebaSyncService.this.mModel.apc() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.apf(), TiebaSyncService.this.mModel.ape())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.apk());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.apl());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int amF = dVar.apc().amF();
                if (amF > 0 && nextInt % amF == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String apd = TiebaSyncService.this.mModel.apd();
                if (!StringUtils.isNull(apd)) {
                    TbadkCoreApplication.getInst().setConfigVersion(apd);
                }
                if (TiebaSyncService.this.mModel.aph() != null && TiebaSyncService.this.mModel.aph().anN() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.aph().anN());
                }
                if (TiebaSyncService.this.mModel.aph() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.aph().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.aph().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.aph() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.aph().anO());
                }
                if (TiebaSyncService.this.mModel.aph() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.aph().anP());
                }
                if (TiebaSyncService.this.mModel.aph() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.aph().anQ());
                }
                aa aph = TiebaSyncService.this.mModel.aph();
                if (aph != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(aph.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().pq(aph.anh());
                    TbadkCoreApplication.getInst().getListItemRule().ps(aph.anj());
                    TbadkCoreApplication.getInst().getListItemRule().pr(aph.ani());
                    TbadkCoreApplication.getInst().setUseNewResign(aph.anv());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(aph.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(aph.anD());
                    TbadkCoreApplication.getInst().setGameInfoData(aph.anw(), aph.any(), aph.anx());
                    af.aiY().e(aph.anc(), aph.and(), aph.ane(), aph.anf(), aph.ang());
                    String anb = aph.anb();
                    b ahU = b.ahU();
                    if (anb == null) {
                        anb = "";
                    }
                    ahU.putString("apply_vip_live_room_pid", anb);
                    b.ahU().putString("tail_link", aph.ank());
                    b.ahU().putString("bubble_link", aph.anl());
                    long anm = aph.anm();
                    if (anm >= 0 && anm != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(aph.anm());
                    }
                    long anF = aph.anF() * 1000;
                    if (anF > 0) {
                        b.ahU().putLong("KEY_UPLOAD_LOG_INTERVAL", anF);
                    } else {
                        long anE = aph.anE() * 1000;
                        if (anE > 0) {
                            b.ahU().putLong("KEY_UPLOAD_LOG_INTERVAL", anE);
                        }
                    }
                    XiaoyingUtil.setShowTime(aph.ann());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(aph.ano());
                    b.ahU().putLong("recommend_frs_cache_time", aph.ant());
                    b.ahU().putInt("home_page_max_thread_count", aph.anu());
                    b.ahU().putBoolean("localvideo_open", aph.anA());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.ahU().putInt("card_show_statistic_max_count", aph.cif);
                    b.ahU().putString("nick_name_activity_link", aph.anC());
                    String string = b.ahU().getString("clean_smart_frs_cookie", "");
                    String anz = aph.anz();
                    if (!TextUtils.equals(string, anz)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.ahU().putString("clean_smart_frs_cookie", anz);
                    b.ahU().putInt("recommend_tab_show", aph.anp());
                    b.ahU().putInt("ribao_switch", aph.anq());
                    b.ahU().putInt("home_default_page", aph.anr());
                    b.ahU().putInt("home_remember_page", aph.ans());
                    TbConfig.setMaxPhotoMemoryCache(aph.anB());
                    b.ahU().putInt("key_card_show_type", aph.anG());
                    TbadkCoreApplication.getInst().setCardShowType(aph.anG());
                    b.ahU().putInt("key_card_abstract_switch", aph.anH());
                    t anI = aph.anI();
                    if (anI != null) {
                        b.ahU().putBoolean("nani_key_is_show_download_nani_panel", anI.chs);
                        b.ahU().putBoolean("nani_key_is_activate_app", anI.cht);
                        b.ahU().putInt("nani_key_download_show_position", anI.chu);
                        b.ahU().putInt("nani_key_download_show_rate", anI.chv);
                        b.ahU().putString("nani_key_download_link_url", anI.chw);
                        b.ahU().putString("nani_key_download_txt", anI.chx);
                        b.ahU().putString("nani_key_show_tail_txt", anI.chy);
                        b.ahU().putInt("nani_key_show_tail_video_type", anI.chz);
                        b.ahU().putString("nani_key_show_tail_txt", anI.chy);
                        b.ahU().putString("nani_key_pre_h5_link", anI.chA);
                    }
                    b.ahU().putLong("key_frs_cache_time", aph.anJ() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(aph.anK());
                    TbSingleton.getInstance().setPushDialogShowTime(aph.anL());
                    TbSingleton.getInstance().setCanShowPermDlg(aph.anM());
                    TbSingleton.getInstance().setSampleId(aph.getSampleId());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.apc() != null && TiebaSyncService.this.mModel.apc().amG() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.apc().amG().amR());
                }
                if (TiebaSyncService.this.mModel.apc() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.apc().amH());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String amN = TiebaSyncService.this.mModel.getProfileData().amN();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.ahU().putString("sync_send_maintab_my_tab_lottie_url", amN);
                    b.ahU().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.ahU().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.apm() != null) {
                    com.baidu.tbadk.util.a.awk().a(TiebaSyncService.this.mModel.apm());
                }
                if (TiebaSyncService.this.mModel.apn() != null) {
                    com.baidu.tbadk.a.b.aah().u(TiebaSyncService.this.mModel.apn());
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
