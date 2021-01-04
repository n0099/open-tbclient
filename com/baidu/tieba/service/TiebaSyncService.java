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
                if (d.bBF().bBI() > 0) {
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
                this.cmJ.addPostData("_pic_quality", String.valueOf(k.bou().getViewImageQuality()));
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
                if (this.cmJ.bvQ().bwA().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bCl().getClientId() != null && eVar.bCl().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bCl().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bCl().getClientId());
                        }
                        if (eVar.bCh() != null) {
                            b.bvq().putInt("crash_limit_count", eVar.bCh().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bvq().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
                com.baidu.tbadk.util.b.bIu().bIv();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bCo());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bCp());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bCq());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bCr());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bCi = TiebaSyncService.this.mModel.bCi();
                if (!StringUtils.isNull(bCi)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bCi);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bCn() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bCn());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bCs() != null) {
                    com.baidu.tbadk.util.a.bIq().a(TiebaSyncService.this.mModel.bCs());
                }
                if (TiebaSyncService.this.mModel.bCt() != null) {
                    com.baidu.tbadk.util.a.bIq().a(TiebaSyncService.this.mModel.bCt());
                }
                com.baidu.tbadk.a.b.bmm().N(TiebaSyncService.this.mModel.bCu());
                c.bmq().N(TiebaSyncService.this.mModel.bCv());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bCm() != null) {
                    str = TiebaSyncService.this.mModel.bCm().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (TiebaSyncService.this.mModel.bCv() != null) {
                    str2 = TiebaSyncService.this.mModel.bCv().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bCt();
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
            String bzY = profileData.bzY();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bvq().putString("sync_send_maintab_my_tab_lottie_url", bzY);
            b.bvq().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bvq().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bCh = this.mModel.bCh();
        if (bCh != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bzT = bCh.bzT();
            if (bzT > 0 && nextInt % bzT == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bCh.bzU() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bCh.bzU().bAe());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bCh.bzV());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.dcT().ts(false);
        VersionData bCk = this.mModel.bCk();
        if (bCk != null && bCk.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bCk);
            broadcastNewVersion();
            if (bCk.forceUpdate()) {
                if (this.mModel.bCh() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bCk, this.mModel.bCj())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bCk.getStrategy() == 0 && this.mModel.bCh() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bCk, this.mModel.bCj())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bCm = this.mModel.bCm();
        if (bCm != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bCm.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bCm.bAu());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bCm.bAw());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bCm.bAv());
            TbadkCoreApplication.getInst().setUseNewResign(bCm.bAG());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bCm.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bCm.bAO());
            TbadkCoreApplication.getInst().setGameInfoData(bCm.bAH(), bCm.bAJ(), bCm.bAI());
            ah.bwa().saveOrUpdateImages(bCm.bAp(), bCm.bAq(), bCm.bAr(), bCm.bAs(), bCm.bAt());
            String bAo = bCm.bAo();
            b bvq = b.bvq();
            if (bAo == null) {
                bAo = "";
            }
            bvq.putString("apply_vip_live_room_pid", bAo);
            b.bvq().putString("tail_link", bCm.bAx());
            b.bvq().putString("bubble_link", bCm.bAy());
            long bAz = bCm.bAz();
            if (bAz >= 0 && bAz != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bCm.bAz());
            }
            long bAR = bCm.bAR() * 1000;
            if (bAR > 0) {
                b.bvq().putLong("KEY_UPLOAD_LOG_INTERVAL", bAR);
            } else {
                long bAP = bCm.bAP() * 1000;
                if (bAP > 0) {
                    b.bvq().putLong("KEY_UPLOAD_LOG_INTERVAL", bAP);
                }
            }
            XiaoyingUtil.setShowTime(bCm.bAA());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bCm.bAB());
            b.bvq().putLong("recommend_frs_cache_time", bCm.bAE());
            b.bvq().putInt("home_page_max_thread_count", bCm.bAF());
            b.bvq().putBoolean("localvideo_open", bCm.bAL());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bvq().putInt("card_show_statistic_max_count", bCm.fur);
            b.bvq().putString("nick_name_activity_link", bCm.bAN());
            String string = b.bvq().getString("clean_smart_frs_cookie", "");
            String bAK = bCm.bAK();
            if (!TextUtils.equals(string, bAK)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bvq().putString("clean_smart_frs_cookie", bAK);
            b.bvq().putInt("recommend_tab_show", bCm.bAC());
            b.bvq().putInt("ribao_switch", bCm.bAD());
            TbConfig.setMaxPhotoMemoryCache(bCm.bAM());
            b.bvq().putInt("key_card_show_type", bCm.bAS());
            TbadkCoreApplication.getInst().setCardShowType(bCm.bAS());
            b.bvq().putInt("key_card_abstract_switch", bCm.bAT());
            ab bAU = bCm.bAU();
            if (bAU != null) {
                b.bvq().putBoolean("nani_key_is_show_download_nani_panel", bAU.ftB);
                b.bvq().putBoolean("nani_key_is_activate_app", bAU.ftC);
                b.bvq().putInt("nani_key_download_show_position", bAU.ftD);
                b.bvq().putInt("nani_key_download_show_rate", bAU.ftE);
                b.bvq().putString("nani_key_download_link_url", bAU.ftF);
                b.bvq().putString("nani_key_download_txt", bAU.ftG);
                b.bvq().putString("nani_key_show_tail_txt", bAU.ftH);
                b.bvq().putInt("nani_key_show_tail_video_type", bAU.ftI);
                b.bvq().putString("nani_key_show_tail_txt", bAU.ftH);
                b.bvq().putString("nani_key_pre_h5_link", bAU.ftJ);
            }
            if (bCm.bAZ() != null) {
                TbSingleton.getInstance().setShakeData(bCm.bAZ());
            }
            if (!TextUtils.isEmpty(bCm.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bCm.getSharePanelText());
            }
            b.bvq().putLong("key_frs_cache_time", bCm.bAV() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bCm.bAW());
            TbSingleton.getInstance().setPushDialogShowTime(bCm.bAX());
            TbSingleton.getInstance().setCanShowPermDlg(bCm.bAY());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bCm.bBa());
            TbSingleton.getInstance().setProfileGameCenterKey(bCm.bBb());
            TbSingleton.getInstance().setMissionEntranceUrl(bCm.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bCm.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bCm.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bCm.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bCm.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bCm.bAn());
            TbSingleton.getInstance().setClipboardDelayTime(bCm.bAQ());
        }
    }
}
