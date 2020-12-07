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
import com.baidu.tbadk.a.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private int mHaveRetry = 0;
    private e mModel = null;
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
    public class a extends BdAsyncTask<String, Integer, e> {
        aa cfI;

        private a() {
            this.cfI = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: T */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cfI.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cfI.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.cfI.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cfI.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cfI.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cfI.addPostData("_phone_screen", stringBuffer.toString());
                this.cfI.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cfI.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cfI.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bzl().bzo() > 0) {
                    this.cfI.addPostData("_msg_status", "0");
                } else {
                    this.cfI.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cfI.addPostData("_active", activeVersion);
                }
                this.cfI.addPostData("_pic_quality", String.valueOf(k.blV().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cfI.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cfI.addPostData("package", packageName);
                this.cfI.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cfI.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cfI.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.cfI.postNetData();
                if (this.cfI.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bzR().getClientId() != null && eVar.bzR().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bzR().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bzR().getClientId());
                        }
                        if (eVar.bzN() != null) {
                            b.bsO().putInt("crash_limit_count", eVar.bzN().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bsO().putString("sync_ad_privacy_url", adAdSense.getUrl());
                        }
                        String unused = TiebaSyncService.mStatistics = null;
                        return eVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        return eVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                eVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaSyncService.this.mSyncTask = null;
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            String str;
            super.onPostExecute(eVar);
            TiebaSyncService.this.mSyncTask = null;
            if (eVar != null) {
                com.baidu.tbadk.util.b.bFZ().bGa();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bzU());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bzV());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bzW());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bzX());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bzO = TiebaSyncService.this.mModel.bzO();
                if (!StringUtils.isNull(bzO)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bzO);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bzT() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bzT());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bzY() != null) {
                    com.baidu.tbadk.util.a.bFV().a(TiebaSyncService.this.mModel.bzY());
                }
                if (TiebaSyncService.this.mModel.bzZ() != null) {
                    com.baidu.tbadk.util.a.bFV().a(TiebaSyncService.this.mModel.bzZ());
                }
                com.baidu.tbadk.a.b.bjX().N(TiebaSyncService.this.mModel.bAa());
                c.bkb().N(TiebaSyncService.this.mModel.bAb());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bzS() != null) {
                    str = TiebaSyncService.this.mModel.bzS().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bzZ();
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
        ac profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String bxE = profileData.bxE();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bsO().putString("sync_send_maintab_my_tab_lottie_url", bxE);
            b.bsO().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bsO().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bzN = this.mModel.bzN();
        if (bzN != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bxz = bzN.bxz();
            if (bxz > 0 && nextInt % bxz == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bzN.bxA() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bzN.bxA().bxK());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bzN.bxB());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.ddh().tr(false);
        VersionData bzQ = this.mModel.bzQ();
        if (bzQ != null && bzQ.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bzQ);
            broadcastNewVersion();
            if (bzQ.forceUpdate()) {
                if (this.mModel.bzN() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bzQ, this.mModel.bzP())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bzQ.getStrategy() == 0 && this.mModel.bzN() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bzQ, this.mModel.bzP())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bzS = this.mModel.bzS();
        if (bzS != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bzS.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bzS.bya());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bzS.byc());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bzS.byb());
            TbadkCoreApplication.getInst().setUseNewResign(bzS.bym());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bzS.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bzS.byu());
            TbadkCoreApplication.getInst().setGameInfoData(bzS.byn(), bzS.byp(), bzS.byo());
            ai.btG().saveOrUpdateImages(bzS.bxV(), bzS.bxW(), bzS.bxX(), bzS.bxY(), bzS.bxZ());
            String bxU = bzS.bxU();
            b bsO = b.bsO();
            if (bxU == null) {
                bxU = "";
            }
            bsO.putString("apply_vip_live_room_pid", bxU);
            b.bsO().putString("tail_link", bzS.byd());
            b.bsO().putString("bubble_link", bzS.bye());
            long byf = bzS.byf();
            if (byf >= 0 && byf != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bzS.byf());
            }
            long byx = bzS.byx() * 1000;
            if (byx > 0) {
                b.bsO().putLong("KEY_UPLOAD_LOG_INTERVAL", byx);
            } else {
                long byv = bzS.byv() * 1000;
                if (byv > 0) {
                    b.bsO().putLong("KEY_UPLOAD_LOG_INTERVAL", byv);
                }
            }
            XiaoyingUtil.setShowTime(bzS.byg());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bzS.byh());
            b.bsO().putLong("recommend_frs_cache_time", bzS.byk());
            b.bsO().putInt("home_page_max_thread_count", bzS.byl());
            b.bsO().putBoolean("localvideo_open", bzS.byr());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bsO().putInt("card_show_statistic_max_count", bzS.fkG);
            b.bsO().putString("nick_name_activity_link", bzS.byt());
            String string = b.bsO().getString("clean_smart_frs_cookie", "");
            String byq = bzS.byq();
            if (!TextUtils.equals(string, byq)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bsO().putString("clean_smart_frs_cookie", byq);
            b.bsO().putInt("recommend_tab_show", bzS.byi());
            b.bsO().putInt("ribao_switch", bzS.byj());
            TbConfig.setMaxPhotoMemoryCache(bzS.bys());
            b.bsO().putInt("key_card_show_type", bzS.byy());
            TbadkCoreApplication.getInst().setCardShowType(bzS.byy());
            b.bsO().putInt("key_card_abstract_switch", bzS.byz());
            ab byA = bzS.byA();
            if (byA != null) {
                b.bsO().putBoolean("nani_key_is_show_download_nani_panel", byA.fjQ);
                b.bsO().putBoolean("nani_key_is_activate_app", byA.fjR);
                b.bsO().putInt("nani_key_download_show_position", byA.fjS);
                b.bsO().putInt("nani_key_download_show_rate", byA.fjT);
                b.bsO().putString("nani_key_download_link_url", byA.fjU);
                b.bsO().putString("nani_key_download_txt", byA.fjV);
                b.bsO().putString("nani_key_show_tail_txt", byA.fjW);
                b.bsO().putInt("nani_key_show_tail_video_type", byA.fjX);
                b.bsO().putString("nani_key_show_tail_txt", byA.fjW);
                b.bsO().putString("nani_key_pre_h5_link", byA.fjY);
            }
            if (bzS.byF() != null) {
                TbSingleton.getInstance().setShakeData(bzS.byF());
            }
            if (!TextUtils.isEmpty(bzS.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bzS.getSharePanelText());
            }
            b.bsO().putLong("key_frs_cache_time", bzS.byB() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bzS.byC());
            TbSingleton.getInstance().setPushDialogShowTime(bzS.byD());
            TbSingleton.getInstance().setCanShowPermDlg(bzS.byE());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bzS.byG());
            TbSingleton.getInstance().setProfileGameCenterKey(bzS.byH());
            TbSingleton.getInstance().setMissionEntranceUrl(bzS.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bzS.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bzS.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bzS.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bzS.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bzS.bxT());
            TbSingleton.getInstance().setClipboardDelayTime(bzS.byw());
        }
    }
}
