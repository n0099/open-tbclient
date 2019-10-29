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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
        x bVP;

        private a() {
            this.bVP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bVP.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bVP.addPostData("board", Build.BOARD);
                this.bVP.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bVP.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bVP.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bVP.addPostData("_phone_screen", stringBuffer.toString());
                this.bVP.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bVP.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bVP.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().ard() > 0) {
                    this.bVP.addPostData("_msg_status", "0");
                } else {
                    this.bVP.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bVP.addPostData("_active", activeVersion);
                }
                this.bVP.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bVP.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bVP.addPostData("package", packageName);
                this.bVP.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bVP.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bVP.addPostData("md5", f.getTiebaApkMd5());
                String postNetData = this.bVP.postNetData();
                if (this.bVP.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bVP.amr().amS().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.arD().getClientId() != null && dVar.arD().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.arD().getClientId());
                            TbadkCoreApplication.setClientId(dVar.arD().getClientId());
                        }
                        if (dVar.arz() != null) {
                            b.alR().putInt("crash_limit_count", dVar.arz().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.alR().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
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
                com.baidu.tbadk.util.b.axq().axr();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.arF());
                if (TiebaSyncService.this.mModel.arC().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.arC());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.arC().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.arz() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.arC(), TiebaSyncService.this.mModel.arB())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.arC().getStrategy() == 0 && TiebaSyncService.this.mModel.arz() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.arC(), TiebaSyncService.this.mModel.arB())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.arG());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.arH());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int apj = dVar.arz().apj();
                if (apj > 0 && nextInt % apj == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String arA = TiebaSyncService.this.mModel.arA();
                if (!StringUtils.isNull(arA)) {
                    TbadkCoreApplication.getInst().setConfigVersion(arA);
                }
                if (TiebaSyncService.this.mModel.arE() != null && TiebaSyncService.this.mModel.arE().aqp() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.arE().aqp());
                }
                if (TiebaSyncService.this.mModel.arE() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.arE().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.arE().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.arE() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.arE().aqq());
                }
                if (TiebaSyncService.this.mModel.arE() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.arE().aqr());
                }
                if (TiebaSyncService.this.mModel.arE() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.arE().aqs());
                }
                aa arE = TiebaSyncService.this.mModel.arE();
                if (arE != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(arE.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().setMaxCache(arE.apJ());
                    TbadkCoreApplication.getInst().getListItemRule().setFrsPn(arE.apL());
                    TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(arE.apK());
                    TbadkCoreApplication.getInst().setUseNewResign(arE.apX());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(arE.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(arE.aqf());
                    TbadkCoreApplication.getInst().setGameInfoData(arE.apY(), arE.aqa(), arE.apZ());
                    af.amz().saveOrUpdateImages(arE.apE(), arE.apF(), arE.apG(), arE.apH(), arE.apI());
                    String apD = arE.apD();
                    b alR = b.alR();
                    if (apD == null) {
                        apD = "";
                    }
                    alR.putString("apply_vip_live_room_pid", apD);
                    b.alR().putString("tail_link", arE.apM());
                    b.alR().putString("bubble_link", arE.apN());
                    long apO = arE.apO();
                    if (apO >= 0 && apO != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(arE.apO());
                    }
                    long aqh = arE.aqh() * 1000;
                    if (aqh > 0) {
                        b.alR().putLong("KEY_UPLOAD_LOG_INTERVAL", aqh);
                    } else {
                        long aqg = arE.aqg() * 1000;
                        if (aqg > 0) {
                            b.alR().putLong("KEY_UPLOAD_LOG_INTERVAL", aqg);
                        }
                    }
                    XiaoyingUtil.setShowTime(arE.apP());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(arE.apQ());
                    b.alR().putLong("recommend_frs_cache_time", arE.apV());
                    b.alR().putInt("home_page_max_thread_count", arE.apW());
                    b.alR().putBoolean("localvideo_open", arE.aqc());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    b.alR().putInt("card_show_statistic_max_count", arE.cvZ);
                    b.alR().putString("nick_name_activity_link", arE.aqe());
                    String string = b.alR().getString("clean_smart_frs_cookie", "");
                    String aqb = arE.aqb();
                    if (!TextUtils.equals(string, aqb)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    b.alR().putString("clean_smart_frs_cookie", aqb);
                    b.alR().putInt("recommend_tab_show", arE.apR());
                    b.alR().putInt("ribao_switch", arE.apS());
                    b.alR().putInt("home_default_page", arE.apT());
                    b.alR().putInt("home_remember_page", arE.apU());
                    TbConfig.setMaxPhotoMemoryCache(arE.aqd());
                    b.alR().putInt("key_card_show_type", arE.aqi());
                    TbadkCoreApplication.getInst().setCardShowType(arE.aqi());
                    b.alR().putInt("key_card_abstract_switch", arE.aqj());
                    t aqk = arE.aqk();
                    if (aqk != null) {
                        b.alR().putBoolean("nani_key_is_show_download_nani_panel", aqk.cvn);
                        b.alR().putBoolean("nani_key_is_activate_app", aqk.cvo);
                        b.alR().putInt("nani_key_download_show_position", aqk.cvp);
                        b.alR().putInt("nani_key_download_show_rate", aqk.cvq);
                        b.alR().putString("nani_key_download_link_url", aqk.cvr);
                        b.alR().putString("nani_key_download_txt", aqk.cvs);
                        b.alR().putString("nani_key_show_tail_txt", aqk.cvt);
                        b.alR().putInt("nani_key_show_tail_video_type", aqk.cvu);
                        b.alR().putString("nani_key_show_tail_txt", aqk.cvt);
                        b.alR().putString("nani_key_pre_h5_link", aqk.cvv);
                    }
                    b.alR().putLong("key_frs_cache_time", arE.aql() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(arE.aqm());
                    TbSingleton.getInstance().setPushDialogShowTime(arE.aqn());
                    TbSingleton.getInstance().setCanShowPermDlg(arE.aqo());
                    TbSingleton.getInstance().setLiveForumMap(arE.apC());
                    TbSingleton.getInstance().setSampleId(arE.getSampleId());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.arz() != null && TiebaSyncService.this.mModel.arz().apk() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.arz().apk().aps());
                }
                if (TiebaSyncService.this.mModel.arz() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.arz().apl());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String apo = TiebaSyncService.this.mModel.getProfileData().apo();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.alR().putString("sync_send_maintab_my_tab_lottie_url", apo);
                    b.alR().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.alR().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.arI() != null) {
                    com.baidu.tbadk.util.a.axp().a(TiebaSyncService.this.mModel.arI());
                }
                if (TiebaSyncService.this.mModel.arJ() != null) {
                    com.baidu.tbadk.a.b.aeV().C(TiebaSyncService.this.mModel.arJ());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
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
