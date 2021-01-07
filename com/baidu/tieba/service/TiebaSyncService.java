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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.z;
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
import com.kwad.sdk.collector.AppStatusRules;
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
        z cmJ;

        private a() {
            this.cmJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Z */
        public e doInBackground(String... strArr) {
            e eVar;
            try {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cmJ.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cmJ.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.cmJ.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cmJ.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cmJ.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cmJ.addPostData("_phone_screen", stringBuffer.toString());
                this.cmJ.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cmJ.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cmJ.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bBG().bBJ() > 0) {
                    this.cmJ.addPostData("_msg_status", "0");
                } else {
                    this.cmJ.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cmJ.addPostData("_active", activeVersion);
                }
                this.cmJ.addPostData("_pic_quality", String.valueOf(k.bov().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cmJ.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cmJ.addPostData("package", packageName);
                this.cmJ.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cmJ.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cmJ.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.cmJ.postNetData();
                if (this.cmJ.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bCm().getClientId() != null && eVar.bCm().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bCm().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bCm().getClientId());
                        }
                        if (eVar.bCi() != null) {
                            b.bvr().putInt("crash_limit_count", eVar.bCi().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bvr().putString("sync_ad_privacy_url", adAdSense.getUrl());
                        }
                        String unused = TiebaSyncService.mStatistics = null;
                        return eVar;
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        return eVar;
                    }
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                eVar = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaSyncService.this.mSyncTask = null;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            String str;
            String str2;
            super.onPostExecute(eVar);
            TiebaSyncService.this.mSyncTask = null;
            if (eVar != null) {
                com.baidu.tbadk.util.b.bIv().bIw();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bCp());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bCq());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bCr());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bCs());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bCj = TiebaSyncService.this.mModel.bCj();
                if (!StringUtils.isNull(bCj)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bCj);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bCo() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bCo());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bCt() != null) {
                    com.baidu.tbadk.util.a.bIr().a(TiebaSyncService.this.mModel.bCt());
                }
                if (TiebaSyncService.this.mModel.bCu() != null) {
                    com.baidu.tbadk.util.a.bIr().a(TiebaSyncService.this.mModel.bCu());
                }
                com.baidu.tbadk.a.b.bmn().N(TiebaSyncService.this.mModel.bCv());
                c.bmr().N(TiebaSyncService.this.mModel.bCw());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bCn() != null) {
                    str = TiebaSyncService.this.mModel.bCn().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (TiebaSyncService.this.mModel.bCw() != null) {
                    str2 = TiebaSyncService.this.mModel.bCw().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bCu();
                g.publishEvent(syncDataEvent);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
                TiebaSyncService.this.stopSelf();
                return;
            }
            TiebaSyncService.access$908(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, AppStatusRules.DEFAULT_GRANULARITY);
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
            String bzZ = profileData.bzZ();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bvr().putString("sync_send_maintab_my_tab_lottie_url", bzZ);
            b.bvr().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bvr().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bCi = this.mModel.bCi();
        if (bCi != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bzU = bCi.bzU();
            if (bzU > 0 && nextInt % bzU == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bCi.bzV() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bCi.bzV().bAf());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bCi.bzW());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.dcU().ts(false);
        VersionData bCl = this.mModel.bCl();
        if (bCl != null && bCl.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bCl);
            broadcastNewVersion();
            if (bCl.forceUpdate()) {
                if (this.mModel.bCi() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bCl, this.mModel.bCk())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bCl.getStrategy() == 0 && this.mModel.bCi() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bCl, this.mModel.bCk())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bCn = this.mModel.bCn();
        if (bCn != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bCn.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bCn.bAv());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bCn.bAx());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bCn.bAw());
            TbadkCoreApplication.getInst().setUseNewResign(bCn.bAH());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bCn.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bCn.bAP());
            TbadkCoreApplication.getInst().setGameInfoData(bCn.bAI(), bCn.bAK(), bCn.bAJ());
            ah.bwb().saveOrUpdateImages(bCn.bAq(), bCn.bAr(), bCn.bAs(), bCn.bAt(), bCn.bAu());
            String bAp = bCn.bAp();
            b bvr = b.bvr();
            if (bAp == null) {
                bAp = "";
            }
            bvr.putString("apply_vip_live_room_pid", bAp);
            b.bvr().putString("tail_link", bCn.bAy());
            b.bvr().putString("bubble_link", bCn.bAz());
            long bAA = bCn.bAA();
            if (bAA >= 0 && bAA != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bCn.bAA());
            }
            long bAS = bCn.bAS() * 1000;
            if (bAS > 0) {
                b.bvr().putLong("KEY_UPLOAD_LOG_INTERVAL", bAS);
            } else {
                long bAQ = bCn.bAQ() * 1000;
                if (bAQ > 0) {
                    b.bvr().putLong("KEY_UPLOAD_LOG_INTERVAL", bAQ);
                }
            }
            XiaoyingUtil.setShowTime(bCn.bAB());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bCn.bAC());
            b.bvr().putLong("recommend_frs_cache_time", bCn.bAF());
            b.bvr().putInt("home_page_max_thread_count", bCn.bAG());
            b.bvr().putBoolean("localvideo_open", bCn.bAM());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bvr().putInt("card_show_statistic_max_count", bCn.fur);
            b.bvr().putString("nick_name_activity_link", bCn.bAO());
            String string = b.bvr().getString("clean_smart_frs_cookie", "");
            String bAL = bCn.bAL();
            if (!TextUtils.equals(string, bAL)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bvr().putString("clean_smart_frs_cookie", bAL);
            b.bvr().putInt("recommend_tab_show", bCn.bAD());
            b.bvr().putInt("ribao_switch", bCn.bAE());
            TbConfig.setMaxPhotoMemoryCache(bCn.bAN());
            b.bvr().putInt("key_card_show_type", bCn.bAT());
            TbadkCoreApplication.getInst().setCardShowType(bCn.bAT());
            b.bvr().putInt("key_card_abstract_switch", bCn.bAU());
            ab bAV = bCn.bAV();
            if (bAV != null) {
                b.bvr().putBoolean("nani_key_is_show_download_nani_panel", bAV.ftB);
                b.bvr().putBoolean("nani_key_is_activate_app", bAV.ftC);
                b.bvr().putInt("nani_key_download_show_position", bAV.ftD);
                b.bvr().putInt("nani_key_download_show_rate", bAV.ftE);
                b.bvr().putString("nani_key_download_link_url", bAV.ftF);
                b.bvr().putString("nani_key_download_txt", bAV.ftG);
                b.bvr().putString("nani_key_show_tail_txt", bAV.ftH);
                b.bvr().putInt("nani_key_show_tail_video_type", bAV.ftI);
                b.bvr().putString("nani_key_show_tail_txt", bAV.ftH);
                b.bvr().putString("nani_key_pre_h5_link", bAV.ftJ);
            }
            if (bCn.bBa() != null) {
                TbSingleton.getInstance().setShakeData(bCn.bBa());
            }
            if (!TextUtils.isEmpty(bCn.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bCn.getSharePanelText());
            }
            b.bvr().putLong("key_frs_cache_time", bCn.bAW() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bCn.bAX());
            TbSingleton.getInstance().setPushDialogShowTime(bCn.bAY());
            TbSingleton.getInstance().setCanShowPermDlg(bCn.bAZ());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bCn.bBb());
            TbSingleton.getInstance().setProfileGameCenterKey(bCn.bBc());
            TbSingleton.getInstance().setMissionEntranceUrl(bCn.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bCn.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bCn.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bCn.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bCn.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bCn.bAo());
            TbSingleton.getInstance().setClipboardDelayTime(bCn.bAR());
        }
    }
}
