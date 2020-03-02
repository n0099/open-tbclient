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
        x cLE;

        private a() {
            this.cLE = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cLE.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cLE.addPostData("board", Build.BOARD);
                this.cLE.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cLE.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cLE.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cLE.addPostData("_phone_screen", stringBuffer.toString());
                this.cLE.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cLE.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cLE.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLo() > 0) {
                    this.cLE.addPostData("_msg_status", "0");
                } else {
                    this.cLE.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cLE.addPostData("_active", activeVersion);
                }
                this.cLE.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cLE.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cLE.addPostData("package", packageName);
                this.cLE.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cLE.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cLE.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cLE.postNetData();
                if (this.cLE.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cLE.aGg().aGI().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aLP().getClientId() != null && dVar.aLP().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aLP().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aLP().getClientId());
                        }
                        if (dVar.aLL() != null) {
                            b.aFD().putInt("crash_limit_count", dVar.aLL().getCrashLimitCount());
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
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
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
                com.baidu.tbadk.util.b.aRN().aRO();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aLR());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aLS());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aLT());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aLM = TiebaSyncService.this.mModel.aLM();
                if (!StringUtils.isNull(aLM)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aLM);
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
                if (TiebaSyncService.this.mModel.aLU() != null) {
                    com.baidu.tbadk.util.a.aRL().a(TiebaSyncService.this.mModel.aLU());
                }
                if (TiebaSyncService.this.mModel.aLV() != null) {
                    com.baidu.tbadk.util.a.aRL().a(TiebaSyncService.this.mModel.aLV());
                }
                if (TiebaSyncService.this.mModel.aLW() != null) {
                    com.baidu.tbadk.a.b.ayu().J(TiebaSyncService.this.mModel.aLW());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aLQ() != null) {
                    str = TiebaSyncService.this.mModel.aLQ().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aLV();
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
            String aJy = profileData.aJy();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aFD().putString("sync_send_maintab_my_tab_lottie_url", aJy);
            b.aFD().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aFD().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aLL = this.mModel.aLL();
        if (aLL != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aJt = aLL.aJt();
            if (aJt > 0 && nextInt % aJt == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aLL.aJu() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aLL.aJu().aJE());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aLL.aJv());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aLO = this.mModel.aLO();
        if (aLO != null && aLO.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aLO);
            broadcastNewVersion();
            if (aLO.forceUpdate()) {
                if (this.mModel.aLL() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLO, this.mModel.aLN())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aLO.getStrategy() == 0 && this.mModel.aLL() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLO, this.mModel.aLN())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aLQ = this.mModel.aLQ();
        if (aLQ != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aLQ.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aLQ.aJU());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aLQ.aJW());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aLQ.aJV());
            TbadkCoreApplication.getInst().setUseNewResign(aLQ.aKi());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aLQ.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aLQ.aKq());
            TbadkCoreApplication.getInst().setGameInfoData(aLQ.aKj(), aLQ.aKl(), aLQ.aKk());
            af.aGo().saveOrUpdateImages(aLQ.aJP(), aLQ.aJQ(), aLQ.aJR(), aLQ.aJS(), aLQ.aJT());
            String aJO = aLQ.aJO();
            b aFD = b.aFD();
            if (aJO == null) {
                aJO = "";
            }
            aFD.putString("apply_vip_live_room_pid", aJO);
            b.aFD().putString("tail_link", aLQ.aJX());
            b.aFD().putString("bubble_link", aLQ.aJY());
            long aJZ = aLQ.aJZ();
            if (aJZ >= 0 && aJZ != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aLQ.aJZ());
            }
            long aKs = aLQ.aKs() * 1000;
            if (aKs > 0) {
                b.aFD().putLong("KEY_UPLOAD_LOG_INTERVAL", aKs);
            } else {
                long aKr = aLQ.aKr() * 1000;
                if (aKr > 0) {
                    b.aFD().putLong("KEY_UPLOAD_LOG_INTERVAL", aKr);
                }
            }
            XiaoyingUtil.setShowTime(aLQ.aKa());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aLQ.aKb());
            b.aFD().putLong("recommend_frs_cache_time", aLQ.aKg());
            b.aFD().putInt("home_page_max_thread_count", aLQ.aKh());
            b.aFD().putBoolean("localvideo_open", aLQ.aKn());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aFD().putInt("card_show_statistic_max_count", aLQ.dno);
            b.aFD().putString("nick_name_activity_link", aLQ.aKp());
            String string = b.aFD().getString("clean_smart_frs_cookie", "");
            String aKm = aLQ.aKm();
            if (!TextUtils.equals(string, aKm)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aFD().putString("clean_smart_frs_cookie", aKm);
            b.aFD().putInt("recommend_tab_show", aLQ.aKc());
            b.aFD().putInt("ribao_switch", aLQ.aKd());
            b.aFD().putInt("home_default_page", aLQ.aKe());
            b.aFD().putInt("home_remember_page", aLQ.aKf());
            TbConfig.setMaxPhotoMemoryCache(aLQ.aKo());
            b.aFD().putInt("key_card_show_type", aLQ.aKt());
            TbadkCoreApplication.getInst().setCardShowType(aLQ.aKt());
            b.aFD().putInt("key_card_abstract_switch", aLQ.aKu());
            u aKv = aLQ.aKv();
            if (aKv != null) {
                b.aFD().putBoolean("nani_key_is_show_download_nani_panel", aKv.dmy);
                b.aFD().putBoolean("nani_key_is_activate_app", aKv.dmz);
                b.aFD().putInt("nani_key_download_show_position", aKv.dmA);
                b.aFD().putInt("nani_key_download_show_rate", aKv.dmB);
                b.aFD().putString("nani_key_download_link_url", aKv.dmC);
                b.aFD().putString("nani_key_download_txt", aKv.dmD);
                b.aFD().putString("nani_key_show_tail_txt", aKv.dmE);
                b.aFD().putInt("nani_key_show_tail_video_type", aKv.dmF);
                b.aFD().putString("nani_key_show_tail_txt", aKv.dmE);
                b.aFD().putString("nani_key_pre_h5_link", aKv.dmG);
            }
            if (aLQ.aKA() != null) {
                TbSingleton.getInstance().setShakeData(aLQ.aKA());
            }
            if (!TextUtils.isEmpty(aLQ.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aLQ.getSharePanelText());
            }
            b.aFD().putLong("key_frs_cache_time", aLQ.aKw() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aLQ.aKx());
            TbSingleton.getInstance().setPushDialogShowTime(aLQ.aKy());
            TbSingleton.getInstance().setCanShowPermDlg(aLQ.aKz());
            TbSingleton.getInstance().setIsPbFold(aLQ.aKB());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aLQ.aKC());
            TbSingleton.getInstance().setProfileGameCenterKey(aLQ.aKD());
            TbSingleton.getInstance().setMissionEntranceUrl(aLQ.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aLQ.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aLQ.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aLQ.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aLQ.aJN());
        }
    }
}
