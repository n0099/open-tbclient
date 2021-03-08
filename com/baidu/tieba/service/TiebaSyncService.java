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
import com.baidu.tieba.j;
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
        aa cnM;

        private a() {
            this.cnM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Z */
        public e doInBackground(String... strArr) {
            e eVar;
            try {
                this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cnM.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cnM.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.cnM.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cnM.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cnM.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cnM.addPostData("_phone_screen", stringBuffer.toString());
                this.cnM.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cnM.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cnM.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.byh().byk() > 0) {
                    this.cnM.addPostData("_msg_status", "0");
                } else {
                    this.cnM.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cnM.addPostData("_active", activeVersion);
                }
                this.cnM.addPostData("_pic_quality", String.valueOf(k.bkV().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cnM.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cnM.addPostData("package", packageName);
                this.cnM.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cnM.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cnM.addPostData("md5", j.getTiebaApkMd5());
                String postNetData = this.cnM.postNetData();
                if (this.cnM.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cnM.bsu().bte().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.byN().getClientId() != null && eVar.byN().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.byN().getClientId());
                            TbadkCoreApplication.setClientId(eVar.byN().getClientId());
                        }
                        if (eVar.byJ() != null) {
                            b.brR().putInt("crash_limit_count", eVar.byJ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.brR().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bFa().bFb();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.byQ());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.byR());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.byS());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.byT());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String byK = TiebaSyncService.this.mModel.byK();
                if (!StringUtils.isNull(byK)) {
                    TbadkCoreApplication.getInst().setConfigVersion(byK);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.byP() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.byP());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.byU() != null) {
                    com.baidu.tbadk.util.a.bEW().a(TiebaSyncService.this.mModel.byU());
                }
                if (TiebaSyncService.this.mModel.byV() != null) {
                    com.baidu.tbadk.util.a.bEW().a(TiebaSyncService.this.mModel.byV());
                }
                com.baidu.tbadk.a.b.biH().M(TiebaSyncService.this.mModel.byW());
                c.biL().M(TiebaSyncService.this.mModel.byX());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.byO() != null) {
                    str = TiebaSyncService.this.mModel.byO().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (TiebaSyncService.this.mModel.byX() != null) {
                    str2 = TiebaSyncService.this.mModel.byX().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.byV();
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
            String bwA = profileData.bwA();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.brR().putString("sync_send_maintab_my_tab_lottie_url", bwA);
            b.brR().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.brR().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s byJ = this.mModel.byJ();
        if (byJ != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bwv = byJ.bwv();
            if (bwv > 0 && nextInt % bwv == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (byJ.bww() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(byJ.bww().bwG());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(byJ.bwx());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.dbq().tB(false);
        VersionData byM = this.mModel.byM();
        if (byM != null && byM.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(byM);
            broadcastNewVersion();
            if (byM.forceUpdate()) {
                if (this.mModel.byJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byM, this.mModel.byL())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && byM.getStrategy() == 0 && this.mModel.byJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byM, this.mModel.byL())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj byO = this.mModel.byO();
        if (byO != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(byO.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(byO.bwW());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(byO.bwY());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(byO.bwX());
            TbadkCoreApplication.getInst().setUseNewResign(byO.bxi());
            TbadkCoreApplication.getInst().setUegVoiceWarning(byO.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(byO.bxq());
            TbadkCoreApplication.getInst().setGameInfoData(byO.bxj(), byO.bxl(), byO.bxk());
            ai.bsE().saveOrUpdateImages(byO.bwR(), byO.bwS(), byO.bwT(), byO.bwU(), byO.bwV());
            String bwQ = byO.bwQ();
            b brR = b.brR();
            if (bwQ == null) {
                bwQ = "";
            }
            brR.putString("apply_vip_live_room_pid", bwQ);
            b.brR().putString("tail_link", byO.bwZ());
            b.brR().putString("bubble_link", byO.bxa());
            long bxb = byO.bxb();
            if (bxb >= 0 && bxb != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(byO.bxb());
            }
            long bxt = byO.bxt() * 1000;
            if (bxt > 0) {
                b.brR().putLong("KEY_UPLOAD_LOG_INTERVAL", bxt);
            } else {
                long bxr = byO.bxr() * 1000;
                if (bxr > 0) {
                    b.brR().putLong("KEY_UPLOAD_LOG_INTERVAL", bxr);
                }
            }
            XiaoyingUtil.setShowTime(byO.bxc());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(byO.bxd());
            b.brR().putLong("recommend_frs_cache_time", byO.bxg());
            b.brR().putInt("home_page_max_thread_count", byO.bxh());
            b.brR().putBoolean("localvideo_open", byO.bxn());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.brR().putInt("card_show_statistic_max_count", byO.ftz);
            b.brR().putString("nick_name_activity_link", byO.bxp());
            String string = b.brR().getString("clean_smart_frs_cookie", "");
            String bxm = byO.bxm();
            if (!TextUtils.equals(string, bxm)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.brR().putString("clean_smart_frs_cookie", bxm);
            b.brR().putInt("recommend_tab_show", byO.bxe());
            b.brR().putInt("ribao_switch", byO.bxf());
            TbConfig.setMaxPhotoMemoryCache(byO.bxo());
            b.brR().putInt("key_card_show_type", byO.bxu());
            TbadkCoreApplication.getInst().setCardShowType(byO.bxu());
            b.brR().putInt("key_card_abstract_switch", byO.bxv());
            ab bxw = byO.bxw();
            if (bxw != null) {
                b.brR().putBoolean("nani_key_is_show_download_nani_panel", bxw.fsI);
                b.brR().putBoolean("nani_key_is_activate_app", bxw.fsJ);
                b.brR().putInt("nani_key_download_show_position", bxw.fsK);
                b.brR().putInt("nani_key_download_show_rate", bxw.fsL);
                b.brR().putString("nani_key_download_link_url", bxw.fsM);
                b.brR().putString("nani_key_download_txt", bxw.fsN);
                b.brR().putString("nani_key_show_tail_txt", bxw.fsO);
                b.brR().putInt("nani_key_show_tail_video_type", bxw.fsP);
                b.brR().putString("nani_key_show_tail_txt", bxw.fsO);
                b.brR().putString("nani_key_pre_h5_link", bxw.fsQ);
            }
            if (byO.bxB() != null) {
                TbSingleton.getInstance().setShakeData(byO.bxB());
            }
            if (!TextUtils.isEmpty(byO.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(byO.getSharePanelText());
            }
            b.brR().putLong("key_frs_cache_time", byO.bxx() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(byO.bxy());
            TbSingleton.getInstance().setPushDialogShowTime(byO.bxz());
            TbSingleton.getInstance().setCanShowPermDlg(byO.bxA());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(byO.bxC());
            TbSingleton.getInstance().setProfileGameCenterKey(byO.bxD());
            TbSingleton.getInstance().setMissionEntranceUrl(byO.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(byO.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(byO.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(byO.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(byO.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(byO.bwP());
            TbSingleton.getInstance().setClipboardDelayTime(byO.bxs());
        }
    }
}
