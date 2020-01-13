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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.data.u;
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
        x cHA;

        private a() {
            this.cHA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cHA.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cHA.addPostData("board", Build.BOARD);
                this.cHA.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cHA.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cHA.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cHA.addPostData("_phone_screen", stringBuffer.toString());
                this.cHA.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cHA.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cHA.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIT() > 0) {
                    this.cHA.addPostData("_msg_status", "0");
                } else {
                    this.cHA.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cHA.addPostData("_active", activeVersion);
                }
                this.cHA.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cHA.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cHA.addPostData("package", packageName);
                this.cHA.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cHA.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cHA.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cHA.postNetData();
                if (this.cHA.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cHA.aDU().aEv().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aJu().getClientId() != null && dVar.aJu().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aJu().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aJu().getClientId());
                        }
                        if (dVar.aJq() != null) {
                            b.aDr().putInt("crash_limit_count", dVar.aJq().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aDr().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.b.aPu().aPv();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aJw());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aJx());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aJy());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aJr = TiebaSyncService.this.mModel.aJr();
                if (!StringUtils.isNull(aJr)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aJr);
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
                if (TiebaSyncService.this.mModel.aJz() != null) {
                    com.baidu.tbadk.util.a.aPt().a(TiebaSyncService.this.mModel.aJz());
                }
                if (TiebaSyncService.this.mModel.aJA() != null) {
                    com.baidu.tbadk.a.b.awf().J(TiebaSyncService.this.mModel.aJA());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
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
        u profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String aHe = profileData.aHe();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aDr().putString("sync_send_maintab_my_tab_lottie_url", aHe);
            b.aDr().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aDr().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        n aJq = this.mModel.aJq();
        if (aJq != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aGZ = aJq.aGZ();
            if (aGZ > 0 && nextInt % aGZ == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aJq.aHa() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aJq.aHa().aHj());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aJq.aHb());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aJt = this.mModel.aJt();
        if (aJt != null && aJt.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aJt);
            broadcastNewVersion();
            if (aJt.forceUpdate()) {
                if (this.mModel.aJq() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aJt, this.mModel.aJs())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aJt.getStrategy() == 0 && this.mModel.aJq() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aJt, this.mModel.aJs())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ab aJv = this.mModel.aJv();
        if (aJv != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aJv.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aJv.aHz());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aJv.aHB());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aJv.aHA());
            TbadkCoreApplication.getInst().setUseNewResign(aJv.aHN());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aJv.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aJv.aHV());
            TbadkCoreApplication.getInst().setGameInfoData(aJv.aHO(), aJv.aHQ(), aJv.aHP());
            af.aEc().saveOrUpdateImages(aJv.aHu(), aJv.aHv(), aJv.aHw(), aJv.aHx(), aJv.aHy());
            String aHt = aJv.aHt();
            b aDr = b.aDr();
            if (aHt == null) {
                aHt = "";
            }
            aDr.putString("apply_vip_live_room_pid", aHt);
            b.aDr().putString("tail_link", aJv.aHC());
            b.aDr().putString("bubble_link", aJv.aHD());
            long aHE = aJv.aHE();
            if (aHE >= 0 && aHE != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aJv.aHE());
            }
            long aHX = aJv.aHX() * 1000;
            if (aHX > 0) {
                b.aDr().putLong("KEY_UPLOAD_LOG_INTERVAL", aHX);
            } else {
                long aHW = aJv.aHW() * 1000;
                if (aHW > 0) {
                    b.aDr().putLong("KEY_UPLOAD_LOG_INTERVAL", aHW);
                }
            }
            XiaoyingUtil.setShowTime(aJv.aHF());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aJv.aHG());
            b.aDr().putLong("recommend_frs_cache_time", aJv.aHL());
            b.aDr().putInt("home_page_max_thread_count", aJv.aHM());
            b.aDr().putBoolean("localvideo_open", aJv.aHS());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aDr().putInt("card_show_statistic_max_count", aJv.djj);
            b.aDr().putString("nick_name_activity_link", aJv.aHU());
            String string = b.aDr().getString("clean_smart_frs_cookie", "");
            String aHR = aJv.aHR();
            if (!TextUtils.equals(string, aHR)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aDr().putString("clean_smart_frs_cookie", aHR);
            b.aDr().putInt("recommend_tab_show", aJv.aHH());
            b.aDr().putInt("ribao_switch", aJv.aHI());
            b.aDr().putInt("home_default_page", aJv.aHJ());
            b.aDr().putInt("home_remember_page", aJv.aHK());
            TbConfig.setMaxPhotoMemoryCache(aJv.aHT());
            b.aDr().putInt("key_card_show_type", aJv.aHY());
            TbadkCoreApplication.getInst().setCardShowType(aJv.aHY());
            b.aDr().putInt("key_card_abstract_switch", aJv.aHZ());
            t aIa = aJv.aIa();
            if (aIa != null) {
                b.aDr().putBoolean("nani_key_is_show_download_nani_panel", aIa.dit);
                b.aDr().putBoolean("nani_key_is_activate_app", aIa.diu);
                b.aDr().putInt("nani_key_download_show_position", aIa.div);
                b.aDr().putInt("nani_key_download_show_rate", aIa.diw);
                b.aDr().putString("nani_key_download_link_url", aIa.dix);
                b.aDr().putString("nani_key_download_txt", aIa.diy);
                b.aDr().putString("nani_key_show_tail_txt", aIa.diz);
                b.aDr().putInt("nani_key_show_tail_video_type", aIa.diA);
                b.aDr().putString("nani_key_show_tail_txt", aIa.diz);
                b.aDr().putString("nani_key_pre_h5_link", aIa.diB);
            }
            if (aJv.aIf() != null) {
                TbSingleton.getInstance().setShakeData(aJv.aIf());
            }
            if (!TextUtils.isEmpty(aJv.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aJv.getSharePanelText());
            }
            b.aDr().putLong("key_frs_cache_time", aJv.aIb() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aJv.aIc());
            TbSingleton.getInstance().setPushDialogShowTime(aJv.aId());
            TbSingleton.getInstance().setCanShowPermDlg(aJv.aIe());
            TbSingleton.getInstance().setIsPbFold(aJv.aIg());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aJv.aIh());
            TbSingleton.getInstance().setProfileGameCenterKey(aJv.aIi());
            TbSingleton.getInstance().setMissionEntranceUrl(aJv.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aJv.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aJv.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aJv.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aJv.aHs());
        }
    }
}
