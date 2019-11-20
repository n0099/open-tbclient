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
        x bUY;

        private a() {
            this.bUY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bUY.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bUY.addPostData("board", Build.BOARD);
                this.bUY.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bUY.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bUY.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bUY.addPostData("_phone_screen", stringBuffer.toString());
                this.bUY.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bUY.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bUY.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arb() > 0) {
                    this.bUY.addPostData("_msg_status", "0");
                } else {
                    this.bUY.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bUY.addPostData("_active", activeVersion);
                }
                this.bUY.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bUY.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bUY.addPostData("package", packageName);
                this.bUY.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bUY.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bUY.addPostData("md5", f.getTiebaApkMd5());
                String postNetData = this.bUY.postNetData();
                if (this.bUY.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bUY.amp().amQ().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.arB().getClientId() != null && dVar.arB().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.arB().getClientId());
                            TbadkCoreApplication.setClientId(dVar.arB().getClientId());
                        }
                        if (dVar.arx() != null) {
                            b.alP().putInt("crash_limit_count", dVar.arx().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.alP().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
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
                com.baidu.tbadk.util.b.axo().axp();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.arD());
                if (TiebaSyncService.this.mModel.arA().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.arA());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.arA().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.arx() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.arA(), TiebaSyncService.this.mModel.arz())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.arA().getStrategy() == 0 && TiebaSyncService.this.mModel.arx() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.arA(), TiebaSyncService.this.mModel.arz())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.arE());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.arF());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int apg = dVar.arx().apg();
                if (apg > 0 && nextInt % apg == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String ary = TiebaSyncService.this.mModel.ary();
                if (!StringUtils.isNull(ary)) {
                    TbadkCoreApplication.getInst().setConfigVersion(ary);
                }
                if (TiebaSyncService.this.mModel.arC() != null && TiebaSyncService.this.mModel.arC().aqn() != null) {
                    TbSingleton.getInstance().setShakeData(TiebaSyncService.this.mModel.arC().aqn());
                }
                if (TiebaSyncService.this.mModel.arC() != null && !TextUtils.isEmpty(TiebaSyncService.this.mModel.arC().getSharePanelText())) {
                    TbSingleton.getInstance().setSharePanelText(TiebaSyncService.this.mModel.arC().getSharePanelText());
                }
                if (TiebaSyncService.this.mModel.arC() != null) {
                    TbSingleton.getInstance().setIsPbFold(TiebaSyncService.this.mModel.arC().aqo());
                }
                if (TiebaSyncService.this.mModel.arC() != null) {
                    TbSingleton.getInstance().setShowPersonCenterLiteGame(TiebaSyncService.this.mModel.arC().aqp());
                }
                if (TiebaSyncService.this.mModel.arC() != null) {
                    TbSingleton.getInstance().setProfileGameCenterKey(TiebaSyncService.this.mModel.arC().aqq());
                }
                aa arC = TiebaSyncService.this.mModel.arC();
                if (arC != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(arC.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().setMaxCache(arC.apH());
                    TbadkCoreApplication.getInst().getListItemRule().setFrsPn(arC.apJ());
                    TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(arC.apI());
                    TbadkCoreApplication.getInst().setUseNewResign(arC.apV());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(arC.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(arC.aqd());
                    TbadkCoreApplication.getInst().setGameInfoData(arC.apW(), arC.apY(), arC.apX());
                    af.amx().saveOrUpdateImages(arC.apC(), arC.apD(), arC.apE(), arC.apF(), arC.apG());
                    String apB = arC.apB();
                    b alP = b.alP();
                    if (apB == null) {
                        apB = "";
                    }
                    alP.putString("apply_vip_live_room_pid", apB);
                    b.alP().putString("tail_link", arC.apK());
                    b.alP().putString("bubble_link", arC.apL());
                    long apM = arC.apM();
                    if (apM >= 0 && apM != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(arC.apM());
                    }
                    long aqf = arC.aqf() * 1000;
                    if (aqf > 0) {
                        b.alP().putLong("KEY_UPLOAD_LOG_INTERVAL", aqf);
                    } else {
                        long aqe = arC.aqe() * 1000;
                        if (aqe > 0) {
                            b.alP().putLong("KEY_UPLOAD_LOG_INTERVAL", aqe);
                        }
                    }
                    XiaoyingUtil.setShowTime(arC.apN());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(arC.apO());
                    b.alP().putLong("recommend_frs_cache_time", arC.apT());
                    b.alP().putInt("home_page_max_thread_count", arC.apU());
                    b.alP().putBoolean("localvideo_open", arC.aqa());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    b.alP().putInt("card_show_statistic_max_count", arC.cvi);
                    b.alP().putString("nick_name_activity_link", arC.aqc());
                    String string = b.alP().getString("clean_smart_frs_cookie", "");
                    String apZ = arC.apZ();
                    if (!TextUtils.equals(string, apZ)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    b.alP().putString("clean_smart_frs_cookie", apZ);
                    b.alP().putInt("recommend_tab_show", arC.apP());
                    b.alP().putInt("ribao_switch", arC.apQ());
                    b.alP().putInt("home_default_page", arC.apR());
                    b.alP().putInt("home_remember_page", arC.apS());
                    TbConfig.setMaxPhotoMemoryCache(arC.aqb());
                    b.alP().putInt("key_card_show_type", arC.aqg());
                    TbadkCoreApplication.getInst().setCardShowType(arC.aqg());
                    b.alP().putInt("key_card_abstract_switch", arC.aqh());
                    t aqi = arC.aqi();
                    if (aqi != null) {
                        b.alP().putBoolean("nani_key_is_show_download_nani_panel", aqi.cuw);
                        b.alP().putBoolean("nani_key_is_activate_app", aqi.cux);
                        b.alP().putInt("nani_key_download_show_position", aqi.cuy);
                        b.alP().putInt("nani_key_download_show_rate", aqi.cuz);
                        b.alP().putString("nani_key_download_link_url", aqi.cuA);
                        b.alP().putString("nani_key_download_txt", aqi.cuB);
                        b.alP().putString("nani_key_show_tail_txt", aqi.cuC);
                        b.alP().putInt("nani_key_show_tail_video_type", aqi.cuD);
                        b.alP().putString("nani_key_show_tail_txt", aqi.cuC);
                        b.alP().putString("nani_key_pre_h5_link", aqi.cuE);
                    }
                    b.alP().putLong("key_frs_cache_time", arC.aqj() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(arC.aqk());
                    TbSingleton.getInstance().setPushDialogShowTime(arC.aql());
                    TbSingleton.getInstance().setCanShowPermDlg(arC.aqm());
                    TbSingleton.getInstance().setLiveForumMap(arC.apA());
                    TbSingleton.getInstance().setSampleId(arC.getSampleId());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.arx() != null && TiebaSyncService.this.mModel.arx().aph() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.arx().aph().apq());
                }
                if (TiebaSyncService.this.mModel.arx() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.arx().apj());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String apm = TiebaSyncService.this.mModel.getProfileData().apm();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.alP().putString("sync_send_maintab_my_tab_lottie_url", apm);
                    b.alP().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.alP().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.arG() != null) {
                    com.baidu.tbadk.util.a.axn().a(TiebaSyncService.this.mModel.arG());
                }
                if (TiebaSyncService.this.mModel.arH() != null) {
                    com.baidu.tbadk.a.b.aeT().C(TiebaSyncService.this.mModel.arH());
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
