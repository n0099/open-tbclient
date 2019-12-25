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
import com.baidu.tbadk.coreExtra.data.aa;
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
        x cHo;

        private a() {
            this.cHo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cHo.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cHo.addPostData("board", Build.BOARD);
                this.cHo.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cHo.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cHo.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cHo.addPostData("_phone_screen", stringBuffer.toString());
                this.cHo.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cHo.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cHo.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIz() > 0) {
                    this.cHo.addPostData("_msg_status", "0");
                } else {
                    this.cHo.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cHo.addPostData("_active", activeVersion);
                }
                this.cHo.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cHo.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cHo.addPostData("package", packageName);
                this.cHo.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cHo.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cHo.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.cHo.postNetData();
                if (this.cHo.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cHo.aDB().aEc().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aJa().getClientId() != null && dVar.aJa().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aJa().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aJa().getClientId());
                        }
                        if (dVar.aIW() != null) {
                            b.aCY().putInt("crash_limit_count", dVar.aIW().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aCY().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
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
                com.baidu.tbadk.util.b.aPb().aPc();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aJc());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aJd());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aJe());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aIX = TiebaSyncService.this.mModel.aIX();
                if (!StringUtils.isNull(aIX)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aIX);
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
                if (TiebaSyncService.this.mModel.aJf() != null) {
                    com.baidu.tbadk.util.a.aPa().a(TiebaSyncService.this.mModel.aJf());
                }
                if (TiebaSyncService.this.mModel.aJg() != null) {
                    com.baidu.tbadk.a.b.avM().I(TiebaSyncService.this.mModel.aJg());
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
            String aGL = profileData.aGL();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aCY().putString("sync_send_maintab_my_tab_lottie_url", aGL);
            b.aCY().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aCY().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        n aIW = this.mModel.aIW();
        if (aIW != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aGG = aIW.aGG();
            if (aGG > 0 && nextInt % aGG == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aIW.aGH() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aIW.aGH().aGP());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aIW.aGI());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aIZ = this.mModel.aIZ();
        if (aIZ != null && aIZ.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aIZ);
            broadcastNewVersion();
            if (aIZ.forceUpdate()) {
                if (this.mModel.aIW() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aIZ, this.mModel.aIY())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aIZ.getStrategy() == 0 && this.mModel.aIW() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aIZ, this.mModel.aIY())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aa aJb = this.mModel.aJb();
        if (aJb != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aJb.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aJb.aHf());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aJb.aHh());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aJb.aHg());
            TbadkCoreApplication.getInst().setUseNewResign(aJb.aHt());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aJb.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aJb.aHB());
            TbadkCoreApplication.getInst().setGameInfoData(aJb.aHu(), aJb.aHw(), aJb.aHv());
            af.aDJ().saveOrUpdateImages(aJb.aHa(), aJb.aHb(), aJb.aHc(), aJb.aHd(), aJb.aHe());
            String aGZ = aJb.aGZ();
            b aCY = b.aCY();
            if (aGZ == null) {
                aGZ = "";
            }
            aCY.putString("apply_vip_live_room_pid", aGZ);
            b.aCY().putString("tail_link", aJb.aHi());
            b.aCY().putString("bubble_link", aJb.aHj());
            long aHk = aJb.aHk();
            if (aHk >= 0 && aHk != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aJb.aHk());
            }
            long aHD = aJb.aHD() * 1000;
            if (aHD > 0) {
                b.aCY().putLong("KEY_UPLOAD_LOG_INTERVAL", aHD);
            } else {
                long aHC = aJb.aHC() * 1000;
                if (aHC > 0) {
                    b.aCY().putLong("KEY_UPLOAD_LOG_INTERVAL", aHC);
                }
            }
            XiaoyingUtil.setShowTime(aJb.aHl());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aJb.aHm());
            b.aCY().putLong("recommend_frs_cache_time", aJb.aHr());
            b.aCY().putInt("home_page_max_thread_count", aJb.aHs());
            b.aCY().putBoolean("localvideo_open", aJb.aHy());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aCY().putInt("card_show_statistic_max_count", aJb.diT);
            b.aCY().putString("nick_name_activity_link", aJb.aHA());
            String string = b.aCY().getString("clean_smart_frs_cookie", "");
            String aHx = aJb.aHx();
            if (!TextUtils.equals(string, aHx)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aCY().putString("clean_smart_frs_cookie", aHx);
            b.aCY().putInt("recommend_tab_show", aJb.aHn());
            b.aCY().putInt("ribao_switch", aJb.aHo());
            b.aCY().putInt("home_default_page", aJb.aHp());
            b.aCY().putInt("home_remember_page", aJb.aHq());
            TbConfig.setMaxPhotoMemoryCache(aJb.aHz());
            b.aCY().putInt("key_card_show_type", aJb.aHE());
            TbadkCoreApplication.getInst().setCardShowType(aJb.aHE());
            b.aCY().putInt("key_card_abstract_switch", aJb.aHF());
            t aHG = aJb.aHG();
            if (aHG != null) {
                b.aCY().putBoolean("nani_key_is_show_download_nani_panel", aHG.dif);
                b.aCY().putBoolean("nani_key_is_activate_app", aHG.dig);
                b.aCY().putInt("nani_key_download_show_position", aHG.dih);
                b.aCY().putInt("nani_key_download_show_rate", aHG.dii);
                b.aCY().putString("nani_key_download_link_url", aHG.dij);
                b.aCY().putString("nani_key_download_txt", aHG.dik);
                b.aCY().putString("nani_key_show_tail_txt", aHG.dil);
                b.aCY().putInt("nani_key_show_tail_video_type", aHG.dim);
                b.aCY().putString("nani_key_show_tail_txt", aHG.dil);
                b.aCY().putString("nani_key_pre_h5_link", aHG.din);
            }
            if (aJb.aHL() != null) {
                TbSingleton.getInstance().setShakeData(aJb.aHL());
            }
            if (!TextUtils.isEmpty(aJb.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aJb.getSharePanelText());
            }
            b.aCY().putLong("key_frs_cache_time", aJb.aHH() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aJb.aHI());
            TbSingleton.getInstance().setPushDialogShowTime(aJb.aHJ());
            TbSingleton.getInstance().setCanShowPermDlg(aJb.aHK());
            TbSingleton.getInstance().setIsPbFold(aJb.aHM());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aJb.aHN());
            TbSingleton.getInstance().setProfileGameCenterKey(aJb.aHO());
            TbSingleton.getInstance().setMissionEntranceUrl(aJb.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aJb.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aJb.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aJb.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aJb.aGY());
        }
    }
}
