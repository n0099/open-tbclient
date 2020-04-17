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
import com.baidu.ar.constants.HttpConstants;
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
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
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
        x blF;

        private a() {
            this.blF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.blF.addPostData("_os_version", Build.VERSION.RELEASE);
                this.blF.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.blF.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.blF.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.blF.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.blF.addPostData("_phone_screen", stringBuffer.toString());
                this.blF.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.blF.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.blF.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTQ() > 0) {
                    this.blF.addPostData("_msg_status", "0");
                } else {
                    this.blF.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.blF.addPostData("_active", activeVersion);
                }
                this.blF.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.blF.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.blF.addPostData("package", packageName);
                this.blF.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.blF.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.blF.addPostData("md5", f.getTiebaApkMd5());
                String postNetData = this.blF.postNetData();
                if (this.blF.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.blF.aOy().aPa().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aUr().getClientId() != null && dVar.aUr().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aUr().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aUr().getClientId());
                        }
                        if (dVar.aUn() != null) {
                            b.aNV().putInt("crash_limit_count", dVar.aUn().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aNV().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.blF != null) {
                this.blF.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bab().bac();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aUt());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aUu());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aUv());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aUo = TiebaSyncService.this.mModel.aUo();
                if (!StringUtils.isNull(aUo)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aUo);
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
                if (TiebaSyncService.this.mModel.aUw() != null) {
                    com.baidu.tbadk.util.a.aZZ().a(TiebaSyncService.this.mModel.aUw());
                }
                if (TiebaSyncService.this.mModel.aUx() != null) {
                    com.baidu.tbadk.util.a.aZZ().a(TiebaSyncService.this.mModel.aUx());
                }
                if (TiebaSyncService.this.mModel.aUy() != null) {
                    com.baidu.tbadk.a.b.aGI().K(TiebaSyncService.this.mModel.aUy());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aUs() != null) {
                    str = TiebaSyncService.this.mModel.aUs().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aUx();
                g.publishEvent(syncDataEvent);
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
            String aSa = profileData.aSa();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aNV().putString("sync_send_maintab_my_tab_lottie_url", aSa);
            b.aNV().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aNV().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aUn = this.mModel.aUn();
        if (aUn != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aRV = aUn.aRV();
            if (aRV > 0 && nextInt % aRV == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aUn.aRW() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aUn.aRW().aSg());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aUn.aRX());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aUq = this.mModel.aUq();
        if (aUq != null && aUq.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aUq);
            broadcastNewVersion();
            if (aUq.forceUpdate()) {
                if (this.mModel.aUn() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aUq, this.mModel.aUp())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aUq.getStrategy() == 0 && this.mModel.aUn() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aUq, this.mModel.aUp())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aUs = this.mModel.aUs();
        if (aUs != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aUs.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aUs.aSw());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aUs.aSy());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aUs.aSx());
            TbadkCoreApplication.getInst().setUseNewResign(aUs.aSK());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aUs.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aUs.aSS());
            TbadkCoreApplication.getInst().setGameInfoData(aUs.aSL(), aUs.aSN(), aUs.aSM());
            af.aOG().saveOrUpdateImages(aUs.aSr(), aUs.aSs(), aUs.aSt(), aUs.aSu(), aUs.aSv());
            String aSq = aUs.aSq();
            b aNV = b.aNV();
            if (aSq == null) {
                aSq = "";
            }
            aNV.putString("apply_vip_live_room_pid", aSq);
            b.aNV().putString("tail_link", aUs.aSz());
            b.aNV().putString("bubble_link", aUs.aSA());
            long aSB = aUs.aSB();
            if (aSB >= 0 && aSB != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aUs.aSB());
            }
            long aSU = aUs.aSU() * 1000;
            if (aSU > 0) {
                b.aNV().putLong("KEY_UPLOAD_LOG_INTERVAL", aSU);
            } else {
                long aST = aUs.aST() * 1000;
                if (aST > 0) {
                    b.aNV().putLong("KEY_UPLOAD_LOG_INTERVAL", aST);
                }
            }
            XiaoyingUtil.setShowTime(aUs.aSC());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aUs.aSD());
            b.aNV().putLong("recommend_frs_cache_time", aUs.aSI());
            b.aNV().putInt("home_page_max_thread_count", aUs.aSJ());
            b.aNV().putBoolean("localvideo_open", aUs.aSP());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aNV().putInt("card_show_statistic_max_count", aUs.dNJ);
            b.aNV().putString("nick_name_activity_link", aUs.aSR());
            String string = b.aNV().getString("clean_smart_frs_cookie", "");
            String aSO = aUs.aSO();
            if (!TextUtils.equals(string, aSO)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aNV().putString("clean_smart_frs_cookie", aSO);
            b.aNV().putInt("recommend_tab_show", aUs.aSE());
            b.aNV().putInt("ribao_switch", aUs.aSF());
            b.aNV().putInt("home_default_page", aUs.aSG());
            b.aNV().putInt("home_remember_page", aUs.aSH());
            TbConfig.setMaxPhotoMemoryCache(aUs.aSQ());
            b.aNV().putInt("key_card_show_type", aUs.aSV());
            TbadkCoreApplication.getInst().setCardShowType(aUs.aSV());
            b.aNV().putInt("key_card_abstract_switch", aUs.aSW());
            u aSX = aUs.aSX();
            if (aSX != null) {
                b.aNV().putBoolean("nani_key_is_show_download_nani_panel", aSX.dMT);
                b.aNV().putBoolean("nani_key_is_activate_app", aSX.dMU);
                b.aNV().putInt("nani_key_download_show_position", aSX.dMV);
                b.aNV().putInt("nani_key_download_show_rate", aSX.dMW);
                b.aNV().putString("nani_key_download_link_url", aSX.dMX);
                b.aNV().putString("nani_key_download_txt", aSX.dMY);
                b.aNV().putString("nani_key_show_tail_txt", aSX.dMZ);
                b.aNV().putInt("nani_key_show_tail_video_type", aSX.dNa);
                b.aNV().putString("nani_key_show_tail_txt", aSX.dMZ);
                b.aNV().putString("nani_key_pre_h5_link", aSX.dNb);
            }
            if (aUs.aTc() != null) {
                TbSingleton.getInstance().setShakeData(aUs.aTc());
            }
            if (!TextUtils.isEmpty(aUs.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aUs.getSharePanelText());
            }
            b.aNV().putLong("key_frs_cache_time", aUs.aSY() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aUs.aSZ());
            TbSingleton.getInstance().setPushDialogShowTime(aUs.aTa());
            TbSingleton.getInstance().setCanShowPermDlg(aUs.aTb());
            TbSingleton.getInstance().setIsPbFold(aUs.aTd());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aUs.aTe());
            TbSingleton.getInstance().setProfileGameCenterKey(aUs.aTf());
            TbSingleton.getInstance().setMissionEntranceUrl(aUs.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aUs.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aUs.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aUs.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aUs.aSp());
        }
    }
}
