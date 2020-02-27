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
        x cLD;

        private a() {
            this.cLD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cLD.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cLD.addPostData("board", Build.BOARD);
                this.cLD.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cLD.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cLD.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cLD.addPostData("_phone_screen", stringBuffer.toString());
                this.cLD.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cLD.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cLD.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLm() > 0) {
                    this.cLD.addPostData("_msg_status", "0");
                } else {
                    this.cLD.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cLD.addPostData("_active", activeVersion);
                }
                this.cLD.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cLD.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cLD.addPostData("package", packageName);
                this.cLD.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cLD.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cLD.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cLD.postNetData();
                if (this.cLD.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cLD.aGe().aGG().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aLN().getClientId() != null && dVar.aLN().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aLN().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aLN().getClientId());
                        }
                        if (dVar.aLJ() != null) {
                            b.aFB().putInt("crash_limit_count", dVar.aLJ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aFB().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
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
                com.baidu.tbadk.util.b.aRL().aRM();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aLP());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aLQ());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aLR());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aLK = TiebaSyncService.this.mModel.aLK();
                if (!StringUtils.isNull(aLK)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aLK);
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
                if (TiebaSyncService.this.mModel.aLS() != null) {
                    com.baidu.tbadk.util.a.aRJ().a(TiebaSyncService.this.mModel.aLS());
                }
                if (TiebaSyncService.this.mModel.aLT() != null) {
                    com.baidu.tbadk.util.a.aRJ().a(TiebaSyncService.this.mModel.aLT());
                }
                if (TiebaSyncService.this.mModel.aLU() != null) {
                    com.baidu.tbadk.a.b.ays().J(TiebaSyncService.this.mModel.aLU());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aLO() != null) {
                    str = TiebaSyncService.this.mModel.aLO().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aLT();
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
            String aJw = profileData.aJw();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aFB().putString("sync_send_maintab_my_tab_lottie_url", aJw);
            b.aFB().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aFB().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aLJ = this.mModel.aLJ();
        if (aLJ != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aJr = aLJ.aJr();
            if (aJr > 0 && nextInt % aJr == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aLJ.aJs() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aLJ.aJs().aJC());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aLJ.aJt());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aLM = this.mModel.aLM();
        if (aLM != null && aLM.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aLM);
            broadcastNewVersion();
            if (aLM.forceUpdate()) {
                if (this.mModel.aLJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLM, this.mModel.aLL())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aLM.getStrategy() == 0 && this.mModel.aLJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLM, this.mModel.aLL())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aLO = this.mModel.aLO();
        if (aLO != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aLO.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aLO.aJS());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aLO.aJU());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aLO.aJT());
            TbadkCoreApplication.getInst().setUseNewResign(aLO.aKg());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aLO.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aLO.aKo());
            TbadkCoreApplication.getInst().setGameInfoData(aLO.aKh(), aLO.aKj(), aLO.aKi());
            af.aGm().saveOrUpdateImages(aLO.aJN(), aLO.aJO(), aLO.aJP(), aLO.aJQ(), aLO.aJR());
            String aJM = aLO.aJM();
            b aFB = b.aFB();
            if (aJM == null) {
                aJM = "";
            }
            aFB.putString("apply_vip_live_room_pid", aJM);
            b.aFB().putString("tail_link", aLO.aJV());
            b.aFB().putString("bubble_link", aLO.aJW());
            long aJX = aLO.aJX();
            if (aJX >= 0 && aJX != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aLO.aJX());
            }
            long aKq = aLO.aKq() * 1000;
            if (aKq > 0) {
                b.aFB().putLong("KEY_UPLOAD_LOG_INTERVAL", aKq);
            } else {
                long aKp = aLO.aKp() * 1000;
                if (aKp > 0) {
                    b.aFB().putLong("KEY_UPLOAD_LOG_INTERVAL", aKp);
                }
            }
            XiaoyingUtil.setShowTime(aLO.aJY());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aLO.aJZ());
            b.aFB().putLong("recommend_frs_cache_time", aLO.aKe());
            b.aFB().putInt("home_page_max_thread_count", aLO.aKf());
            b.aFB().putBoolean("localvideo_open", aLO.aKl());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aFB().putInt("card_show_statistic_max_count", aLO.dnn);
            b.aFB().putString("nick_name_activity_link", aLO.aKn());
            String string = b.aFB().getString("clean_smart_frs_cookie", "");
            String aKk = aLO.aKk();
            if (!TextUtils.equals(string, aKk)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aFB().putString("clean_smart_frs_cookie", aKk);
            b.aFB().putInt("recommend_tab_show", aLO.aKa());
            b.aFB().putInt("ribao_switch", aLO.aKb());
            b.aFB().putInt("home_default_page", aLO.aKc());
            b.aFB().putInt("home_remember_page", aLO.aKd());
            TbConfig.setMaxPhotoMemoryCache(aLO.aKm());
            b.aFB().putInt("key_card_show_type", aLO.aKr());
            TbadkCoreApplication.getInst().setCardShowType(aLO.aKr());
            b.aFB().putInt("key_card_abstract_switch", aLO.aKs());
            u aKt = aLO.aKt();
            if (aKt != null) {
                b.aFB().putBoolean("nani_key_is_show_download_nani_panel", aKt.dmx);
                b.aFB().putBoolean("nani_key_is_activate_app", aKt.dmy);
                b.aFB().putInt("nani_key_download_show_position", aKt.dmz);
                b.aFB().putInt("nani_key_download_show_rate", aKt.dmA);
                b.aFB().putString("nani_key_download_link_url", aKt.dmB);
                b.aFB().putString("nani_key_download_txt", aKt.dmC);
                b.aFB().putString("nani_key_show_tail_txt", aKt.dmD);
                b.aFB().putInt("nani_key_show_tail_video_type", aKt.dmE);
                b.aFB().putString("nani_key_show_tail_txt", aKt.dmD);
                b.aFB().putString("nani_key_pre_h5_link", aKt.dmF);
            }
            if (aLO.aKy() != null) {
                TbSingleton.getInstance().setShakeData(aLO.aKy());
            }
            if (!TextUtils.isEmpty(aLO.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aLO.getSharePanelText());
            }
            b.aFB().putLong("key_frs_cache_time", aLO.aKu() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aLO.aKv());
            TbSingleton.getInstance().setPushDialogShowTime(aLO.aKw());
            TbSingleton.getInstance().setCanShowPermDlg(aLO.aKx());
            TbSingleton.getInstance().setIsPbFold(aLO.aKz());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aLO.aKA());
            TbSingleton.getInstance().setProfileGameCenterKey(aLO.aKB());
            TbSingleton.getInstance().setMissionEntranceUrl(aLO.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aLO.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aLO.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aLO.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aLO.aJL());
        }
    }
}
