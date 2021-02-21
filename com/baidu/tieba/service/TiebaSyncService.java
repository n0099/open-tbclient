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
        aa cml;

        private a() {
            this.cml = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Z */
        public e doInBackground(String... strArr) {
            e eVar;
            try {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.cml.addPostData("_os_version", Build.VERSION.RELEASE);
                this.cml.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.cml.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.cml.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.cml.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.cml.addPostData("_phone_screen", stringBuffer.toString());
                this.cml.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.cml.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.cml.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bye().byh() > 0) {
                    this.cml.addPostData("_msg_status", "0");
                } else {
                    this.cml.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.cml.addPostData("_active", activeVersion);
                }
                this.cml.addPostData("_pic_quality", String.valueOf(k.bkT().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.cml.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.cml.addPostData("package", packageName);
                this.cml.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.cml.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.cml.addPostData("md5", j.getTiebaApkMd5());
                String postNetData = this.cml.postNetData();
                if (this.cml.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.byK().getClientId() != null && eVar.byK().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.byK().getClientId());
                            TbadkCoreApplication.setClientId(eVar.byK().getClientId());
                        }
                        if (eVar.byG() != null) {
                            b.brQ().putInt("crash_limit_count", eVar.byG().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.brQ().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.cml != null) {
                this.cml.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bEW().bEX();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.byN());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.byO());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.byP());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.byQ());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String byH = TiebaSyncService.this.mModel.byH();
                if (!StringUtils.isNull(byH)) {
                    TbadkCoreApplication.getInst().setConfigVersion(byH);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.byM() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.byM());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.byR() != null) {
                    com.baidu.tbadk.util.a.bES().a(TiebaSyncService.this.mModel.byR());
                }
                if (TiebaSyncService.this.mModel.byS() != null) {
                    com.baidu.tbadk.util.a.bES().a(TiebaSyncService.this.mModel.byS());
                }
                com.baidu.tbadk.a.b.biF().M(TiebaSyncService.this.mModel.byT());
                c.biJ().M(TiebaSyncService.this.mModel.byU());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.byL() != null) {
                    str = TiebaSyncService.this.mModel.byL().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (TiebaSyncService.this.mModel.byU() != null) {
                    str2 = TiebaSyncService.this.mModel.byU().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.byS();
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
            String bwx = profileData.bwx();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.brQ().putString("sync_send_maintab_my_tab_lottie_url", bwx);
            b.brQ().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.brQ().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s byG = this.mModel.byG();
        if (byG != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bws = byG.bws();
            if (bws > 0 && nextInt % bws == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (byG.bwt() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(byG.bwt().bwD());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(byG.bwu());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.dbh().tB(false);
        VersionData byJ = this.mModel.byJ();
        if (byJ != null && byJ.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(byJ);
            broadcastNewVersion();
            if (byJ.forceUpdate()) {
                if (this.mModel.byG() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byJ, this.mModel.byI())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && byJ.getStrategy() == 0 && this.mModel.byG() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byJ, this.mModel.byI())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj byL = this.mModel.byL();
        if (byL != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(byL.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(byL.bwT());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(byL.bwV());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(byL.bwU());
            TbadkCoreApplication.getInst().setUseNewResign(byL.bxf());
            TbadkCoreApplication.getInst().setUegVoiceWarning(byL.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(byL.bxn());
            TbadkCoreApplication.getInst().setGameInfoData(byL.bxg(), byL.bxi(), byL.bxh());
            ai.bsB().saveOrUpdateImages(byL.bwO(), byL.bwP(), byL.bwQ(), byL.bwR(), byL.bwS());
            String bwN = byL.bwN();
            b brQ = b.brQ();
            if (bwN == null) {
                bwN = "";
            }
            brQ.putString("apply_vip_live_room_pid", bwN);
            b.brQ().putString("tail_link", byL.bwW());
            b.brQ().putString("bubble_link", byL.bwX());
            long bwY = byL.bwY();
            if (bwY >= 0 && bwY != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(byL.bwY());
            }
            long bxq = byL.bxq() * 1000;
            if (bxq > 0) {
                b.brQ().putLong("KEY_UPLOAD_LOG_INTERVAL", bxq);
            } else {
                long bxo = byL.bxo() * 1000;
                if (bxo > 0) {
                    b.brQ().putLong("KEY_UPLOAD_LOG_INTERVAL", bxo);
                }
            }
            XiaoyingUtil.setShowTime(byL.bwZ());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(byL.bxa());
            b.brQ().putLong("recommend_frs_cache_time", byL.bxd());
            b.brQ().putInt("home_page_max_thread_count", byL.bxe());
            b.brQ().putBoolean("localvideo_open", byL.bxk());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.brQ().putInt("card_show_statistic_max_count", byL.frZ);
            b.brQ().putString("nick_name_activity_link", byL.bxm());
            String string = b.brQ().getString("clean_smart_frs_cookie", "");
            String bxj = byL.bxj();
            if (!TextUtils.equals(string, bxj)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.brQ().putString("clean_smart_frs_cookie", bxj);
            b.brQ().putInt("recommend_tab_show", byL.bxb());
            b.brQ().putInt("ribao_switch", byL.bxc());
            TbConfig.setMaxPhotoMemoryCache(byL.bxl());
            b.brQ().putInt("key_card_show_type", byL.bxr());
            TbadkCoreApplication.getInst().setCardShowType(byL.bxr());
            b.brQ().putInt("key_card_abstract_switch", byL.bxs());
            ab bxt = byL.bxt();
            if (bxt != null) {
                b.brQ().putBoolean("nani_key_is_show_download_nani_panel", bxt.fri);
                b.brQ().putBoolean("nani_key_is_activate_app", bxt.frj);
                b.brQ().putInt("nani_key_download_show_position", bxt.frk);
                b.brQ().putInt("nani_key_download_show_rate", bxt.frl);
                b.brQ().putString("nani_key_download_link_url", bxt.frm);
                b.brQ().putString("nani_key_download_txt", bxt.frn);
                b.brQ().putString("nani_key_show_tail_txt", bxt.fro);
                b.brQ().putInt("nani_key_show_tail_video_type", bxt.frp);
                b.brQ().putString("nani_key_show_tail_txt", bxt.fro);
                b.brQ().putString("nani_key_pre_h5_link", bxt.frq);
            }
            if (byL.bxy() != null) {
                TbSingleton.getInstance().setShakeData(byL.bxy());
            }
            if (!TextUtils.isEmpty(byL.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(byL.getSharePanelText());
            }
            b.brQ().putLong("key_frs_cache_time", byL.bxu() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(byL.bxv());
            TbSingleton.getInstance().setPushDialogShowTime(byL.bxw());
            TbSingleton.getInstance().setCanShowPermDlg(byL.bxx());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(byL.bxz());
            TbSingleton.getInstance().setProfileGameCenterKey(byL.bxA());
            TbSingleton.getInstance().setMissionEntranceUrl(byL.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(byL.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(byL.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(byL.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(byL.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(byL.bwM());
            TbSingleton.getInstance().setClipboardDelayTime(byL.bxp());
        }
    }
}
