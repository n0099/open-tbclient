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
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
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

    static /* synthetic */ int access$908(TiebaSyncService tiebaSyncService) {
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

    private void broadcastNewVersion() {
        if (this.mModel != null) {
            TbadkCoreApplication.getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, d> {
        x cLF;

        private a() {
            this.cLF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cLF.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cLF.addPostData("board", Build.BOARD);
                this.cLF.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cLF.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cLF.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cLF.addPostData("_phone_screen", stringBuffer.toString());
                this.cLF.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cLF.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cLF.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLp() > 0) {
                    this.cLF.addPostData("_msg_status", "0");
                } else {
                    this.cLF.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cLF.addPostData("_active", activeVersion);
                }
                this.cLF.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cLF.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cLF.addPostData("package", packageName);
                this.cLF.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cLF.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cLF.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cLF.postNetData();
                if (this.cLF.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cLF.aGg().aGI().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aLQ().getClientId() != null && dVar.aLQ().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aLQ().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aLQ().getClientId());
                        }
                        if (dVar.aLM() != null) {
                            b.aFD().putInt("crash_limit_count", dVar.aLM().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aFD().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            String str;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.b.aRO().aRP();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aLS());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aLT());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aLU());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aLN = TiebaSyncService.this.mModel.aLN();
                if (!StringUtils.isNull(aLN)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aLN);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aLV() != null) {
                    com.baidu.tbadk.util.a.aRM().a(TiebaSyncService.this.mModel.aLV());
                }
                if (TiebaSyncService.this.mModel.aLW() != null) {
                    com.baidu.tbadk.util.a.aRM().a(TiebaSyncService.this.mModel.aLW());
                }
                if (TiebaSyncService.this.mModel.aLX() != null) {
                    com.baidu.tbadk.a.b.ayu().J(TiebaSyncService.this.mModel.aLX());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aLR() != null) {
                    str = TiebaSyncService.this.mModel.aLR().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aLW();
                com.baidu.tbadk.mutiprocess.g.publishEvent(syncDataEvent);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
                TiebaSyncService.this.stopSelf();
                return;
            }
            TiebaSyncService.access$908(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteProfilData() {
        v profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String aJz = profileData.aJz();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aFD().putString("sync_send_maintab_my_tab_lottie_url", aJz);
            b.aFD().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aFD().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aLM = this.mModel.aLM();
        if (aLM != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aJu = aLM.aJu();
            if (aJu > 0 && nextInt % aJu == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aLM.aJv() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aLM.aJv().aJF());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aLM.aJw());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aLP = this.mModel.aLP();
        if (aLP != null && aLP.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aLP);
            broadcastNewVersion();
            if (aLP.forceUpdate()) {
                if (this.mModel.aLM() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLP, this.mModel.aLO())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aLP.getStrategy() == 0 && this.mModel.aLM() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLP, this.mModel.aLO())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aLR = this.mModel.aLR();
        if (aLR != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aLR.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aLR.aJV());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aLR.aJX());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aLR.aJW());
            TbadkCoreApplication.getInst().setUseNewResign(aLR.aKj());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aLR.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aLR.aKr());
            TbadkCoreApplication.getInst().setGameInfoData(aLR.aKk(), aLR.aKm(), aLR.aKl());
            af.aGo().saveOrUpdateImages(aLR.aJQ(), aLR.aJR(), aLR.aJS(), aLR.aJT(), aLR.aJU());
            String aJP = aLR.aJP();
            b aFD = b.aFD();
            if (aJP == null) {
                aJP = "";
            }
            aFD.putString("apply_vip_live_room_pid", aJP);
            b.aFD().putString("tail_link", aLR.aJY());
            b.aFD().putString("bubble_link", aLR.aJZ());
            long aKa = aLR.aKa();
            if (aKa >= 0 && aKa != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aLR.aKa());
            }
            long aKt = aLR.aKt() * 1000;
            if (aKt > 0) {
                b.aFD().putLong("KEY_UPLOAD_LOG_INTERVAL", aKt);
            } else {
                long aKs = aLR.aKs() * 1000;
                if (aKs > 0) {
                    b.aFD().putLong("KEY_UPLOAD_LOG_INTERVAL", aKs);
                }
            }
            XiaoyingUtil.setShowTime(aLR.aKb());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aLR.aKc());
            b.aFD().putLong("recommend_frs_cache_time", aLR.aKh());
            b.aFD().putInt("home_page_max_thread_count", aLR.aKi());
            b.aFD().putBoolean("localvideo_open", aLR.aKo());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aFD().putInt("card_show_statistic_max_count", aLR.dnC);
            b.aFD().putString("nick_name_activity_link", aLR.aKq());
            String string = b.aFD().getString("clean_smart_frs_cookie", "");
            String aKn = aLR.aKn();
            if (!TextUtils.equals(string, aKn)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aFD().putString("clean_smart_frs_cookie", aKn);
            b.aFD().putInt("recommend_tab_show", aLR.aKd());
            b.aFD().putInt("ribao_switch", aLR.aKe());
            b.aFD().putInt("home_default_page", aLR.aKf());
            b.aFD().putInt("home_remember_page", aLR.aKg());
            TbConfig.setMaxPhotoMemoryCache(aLR.aKp());
            b.aFD().putInt("key_card_show_type", aLR.aKu());
            TbadkCoreApplication.getInst().setCardShowType(aLR.aKu());
            b.aFD().putInt("key_card_abstract_switch", aLR.aKv());
            u aKw = aLR.aKw();
            if (aKw != null) {
                b.aFD().putBoolean("nani_key_is_show_download_nani_panel", aKw.dmL);
                b.aFD().putBoolean("nani_key_is_activate_app", aKw.dmM);
                b.aFD().putInt("nani_key_download_show_position", aKw.dmN);
                b.aFD().putInt("nani_key_download_show_rate", aKw.dmO);
                b.aFD().putString("nani_key_download_link_url", aKw.dmP);
                b.aFD().putString("nani_key_download_txt", aKw.dmQ);
                b.aFD().putString("nani_key_show_tail_txt", aKw.dmR);
                b.aFD().putInt("nani_key_show_tail_video_type", aKw.dmS);
                b.aFD().putString("nani_key_show_tail_txt", aKw.dmR);
                b.aFD().putString("nani_key_pre_h5_link", aKw.dmT);
            }
            if (aLR.aKB() != null) {
                TbSingleton.getInstance().setShakeData(aLR.aKB());
            }
            if (!TextUtils.isEmpty(aLR.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aLR.getSharePanelText());
            }
            b.aFD().putLong("key_frs_cache_time", aLR.aKx() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aLR.aKy());
            TbSingleton.getInstance().setPushDialogShowTime(aLR.aKz());
            TbSingleton.getInstance().setCanShowPermDlg(aLR.aKA());
            TbSingleton.getInstance().setIsPbFold(aLR.aKC());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aLR.aKD());
            TbSingleton.getInstance().setProfileGameCenterKey(aLR.aKE());
            TbSingleton.getInstance().setMissionEntranceUrl(aLR.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aLR.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aLR.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aLR.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aLR.aJO());
        }
    }
}
