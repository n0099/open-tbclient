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
        x cLQ;

        private a() {
            this.cLQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cLQ.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cLQ.addPostData("board", Build.BOARD);
                this.cLQ.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cLQ.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cLQ.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cLQ.addPostData("_phone_screen", stringBuffer.toString());
                this.cLQ.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cLQ.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cLQ.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLt() > 0) {
                    this.cLQ.addPostData("_msg_status", "0");
                } else {
                    this.cLQ.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cLQ.addPostData("_active", activeVersion);
                }
                this.cLQ.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cLQ.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cLQ.addPostData("package", packageName);
                this.cLQ.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cLQ.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cLQ.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cLQ.postNetData();
                if (this.cLQ.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aLU().getClientId() != null && dVar.aLU().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aLU().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aLU().getClientId());
                        }
                        if (dVar.aLQ() != null) {
                            b.aFH().putInt("crash_limit_count", dVar.aLQ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aFH().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
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
                com.baidu.tbadk.util.b.aRS().aRT();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aLW());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aLX());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aLY());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aLR = TiebaSyncService.this.mModel.aLR();
                if (!StringUtils.isNull(aLR)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aLR);
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
                if (TiebaSyncService.this.mModel.aLZ() != null) {
                    com.baidu.tbadk.util.a.aRQ().a(TiebaSyncService.this.mModel.aLZ());
                }
                if (TiebaSyncService.this.mModel.aMa() != null) {
                    com.baidu.tbadk.util.a.aRQ().a(TiebaSyncService.this.mModel.aMa());
                }
                if (TiebaSyncService.this.mModel.aMb() != null) {
                    com.baidu.tbadk.a.b.ayx().J(TiebaSyncService.this.mModel.aMb());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aLV() != null) {
                    str = TiebaSyncService.this.mModel.aLV().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aMa();
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
            String aJD = profileData.aJD();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aFH().putString("sync_send_maintab_my_tab_lottie_url", aJD);
            b.aFH().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aFH().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aLQ = this.mModel.aLQ();
        if (aLQ != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aJy = aLQ.aJy();
            if (aJy > 0 && nextInt % aJy == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aLQ.aJz() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aLQ.aJz().aJJ());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aLQ.aJA());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aLT = this.mModel.aLT();
        if (aLT != null && aLT.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aLT);
            broadcastNewVersion();
            if (aLT.forceUpdate()) {
                if (this.mModel.aLQ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLT, this.mModel.aLS())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aLT.getStrategy() == 0 && this.mModel.aLQ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aLT, this.mModel.aLS())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aLV = this.mModel.aLV();
        if (aLV != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aLV.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aLV.aJZ());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aLV.aKb());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aLV.aKa());
            TbadkCoreApplication.getInst().setUseNewResign(aLV.aKn());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aLV.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aLV.aKv());
            TbadkCoreApplication.getInst().setGameInfoData(aLV.aKo(), aLV.aKq(), aLV.aKp());
            af.aGs().saveOrUpdateImages(aLV.aJU(), aLV.aJV(), aLV.aJW(), aLV.aJX(), aLV.aJY());
            String aJT = aLV.aJT();
            b aFH = b.aFH();
            if (aJT == null) {
                aJT = "";
            }
            aFH.putString("apply_vip_live_room_pid", aJT);
            b.aFH().putString("tail_link", aLV.aKc());
            b.aFH().putString("bubble_link", aLV.aKd());
            long aKe = aLV.aKe();
            if (aKe >= 0 && aKe != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aLV.aKe());
            }
            long aKx = aLV.aKx() * 1000;
            if (aKx > 0) {
                b.aFH().putLong("KEY_UPLOAD_LOG_INTERVAL", aKx);
            } else {
                long aKw = aLV.aKw() * 1000;
                if (aKw > 0) {
                    b.aFH().putLong("KEY_UPLOAD_LOG_INTERVAL", aKw);
                }
            }
            XiaoyingUtil.setShowTime(aLV.aKf());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aLV.aKg());
            b.aFH().putLong("recommend_frs_cache_time", aLV.aKl());
            b.aFH().putInt("home_page_max_thread_count", aLV.aKm());
            b.aFH().putBoolean("localvideo_open", aLV.aKs());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aFH().putInt("card_show_statistic_max_count", aLV.dnP);
            b.aFH().putString("nick_name_activity_link", aLV.aKu());
            String string = b.aFH().getString("clean_smart_frs_cookie", "");
            String aKr = aLV.aKr();
            if (!TextUtils.equals(string, aKr)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aFH().putString("clean_smart_frs_cookie", aKr);
            b.aFH().putInt("recommend_tab_show", aLV.aKh());
            b.aFH().putInt("ribao_switch", aLV.aKi());
            b.aFH().putInt("home_default_page", aLV.aKj());
            b.aFH().putInt("home_remember_page", aLV.aKk());
            TbConfig.setMaxPhotoMemoryCache(aLV.aKt());
            b.aFH().putInt("key_card_show_type", aLV.aKy());
            TbadkCoreApplication.getInst().setCardShowType(aLV.aKy());
            b.aFH().putInt("key_card_abstract_switch", aLV.aKz());
            u aKA = aLV.aKA();
            if (aKA != null) {
                b.aFH().putBoolean("nani_key_is_show_download_nani_panel", aKA.dmY);
                b.aFH().putBoolean("nani_key_is_activate_app", aKA.dmZ);
                b.aFH().putInt("nani_key_download_show_position", aKA.dna);
                b.aFH().putInt("nani_key_download_show_rate", aKA.dnb);
                b.aFH().putString("nani_key_download_link_url", aKA.dnc);
                b.aFH().putString("nani_key_download_txt", aKA.dnd);
                b.aFH().putString("nani_key_show_tail_txt", aKA.dne);
                b.aFH().putInt("nani_key_show_tail_video_type", aKA.dnf);
                b.aFH().putString("nani_key_show_tail_txt", aKA.dne);
                b.aFH().putString("nani_key_pre_h5_link", aKA.dng);
            }
            if (aLV.aKF() != null) {
                TbSingleton.getInstance().setShakeData(aLV.aKF());
            }
            if (!TextUtils.isEmpty(aLV.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aLV.getSharePanelText());
            }
            b.aFH().putLong("key_frs_cache_time", aLV.aKB() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aLV.aKC());
            TbSingleton.getInstance().setPushDialogShowTime(aLV.aKD());
            TbSingleton.getInstance().setCanShowPermDlg(aLV.aKE());
            TbSingleton.getInstance().setIsPbFold(aLV.aKG());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aLV.aKH());
            TbSingleton.getInstance().setProfileGameCenterKey(aLV.aKI());
            TbSingleton.getInstance().setMissionEntranceUrl(aLV.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aLV.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aLV.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aLV.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aLV.aJS());
        }
    }
}
