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
        aa bZh;

        private a() {
            this.bZh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: T */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bZh.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bZh.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bZh.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bZh.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bZh.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bZh.addPostData("_phone_screen", stringBuffer.toString());
                this.bZh.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bZh.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bZh.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bvL().bvO() > 0) {
                    this.bZh.addPostData("_msg_status", "0");
                } else {
                    this.bZh.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bZh.addPostData("_active", activeVersion);
                }
                this.bZh.addPostData("_pic_quality", String.valueOf(k.biL().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bZh.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bZh.addPostData("package", packageName);
                this.bZh.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bZh.addPostData("signmd5", aw.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bZh.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.bZh.postNetData();
                if (this.bZh.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bZh.bqa().bqI().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bwr().getClientId() != null && eVar.bwr().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bwr().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bwr().getClientId());
                        }
                        if (eVar.bwn() != null) {
                            b.bpu().putInt("crash_limit_count", eVar.bwn().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bpu().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bCy().bCz();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bwu());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bwv());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bww());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bwx());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bwo = TiebaSyncService.this.mModel.bwo();
                if (!StringUtils.isNull(bwo)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bwo);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bwt() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bwt());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bwy() != null) {
                    com.baidu.tbadk.util.a.bCu().a(TiebaSyncService.this.mModel.bwy());
                }
                if (TiebaSyncService.this.mModel.bwz() != null) {
                    com.baidu.tbadk.util.a.bCu().a(TiebaSyncService.this.mModel.bwz());
                }
                com.baidu.tbadk.a.b.bgS().M(TiebaSyncService.this.mModel.bwA());
                c.bgW().M(TiebaSyncService.this.mModel.bwB());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bws() != null) {
                    str = TiebaSyncService.this.mModel.bws().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bwz();
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
            String bue = profileData.bue();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bpu().putString("sync_send_maintab_my_tab_lottie_url", bue);
            b.bpu().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bpu().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bwn = this.mModel.bwn();
        if (bwn != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int btZ = bwn.btZ();
            if (btZ > 0 && nextInt % btZ == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bwn.bua() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bwn.bua().buk());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bwn.bub());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.cXW().sP(false);
        VersionData bwq = this.mModel.bwq();
        if (bwq != null && bwq.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bwq);
            broadcastNewVersion();
            if (bwq.forceUpdate()) {
                if (this.mModel.bwn() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bwq, this.mModel.bwp())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bwq.getStrategy() == 0 && this.mModel.bwn() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bwq, this.mModel.bwp())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bws = this.mModel.bws();
        if (bws != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bws.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bws.buA());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bws.buC());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bws.buB());
            TbadkCoreApplication.getInst().setUseNewResign(bws.buM());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bws.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bws.buU());
            TbadkCoreApplication.getInst().setGameInfoData(bws.buN(), bws.buP(), bws.buO());
            ai.bql().saveOrUpdateImages(bws.buv(), bws.buw(), bws.bux(), bws.buy(), bws.buz());
            String buu = bws.buu();
            b bpu = b.bpu();
            if (buu == null) {
                buu = "";
            }
            bpu.putString("apply_vip_live_room_pid", buu);
            b.bpu().putString("tail_link", bws.buD());
            b.bpu().putString("bubble_link", bws.buE());
            long buF = bws.buF();
            if (buF >= 0 && buF != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bws.buF());
            }
            long buX = bws.buX() * 1000;
            if (buX > 0) {
                b.bpu().putLong("KEY_UPLOAD_LOG_INTERVAL", buX);
            } else {
                long buV = bws.buV() * 1000;
                if (buV > 0) {
                    b.bpu().putLong("KEY_UPLOAD_LOG_INTERVAL", buV);
                }
            }
            XiaoyingUtil.setShowTime(bws.buG());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bws.buH());
            b.bpu().putLong("recommend_frs_cache_time", bws.buK());
            b.bpu().putInt("home_page_max_thread_count", bws.buL());
            b.bpu().putBoolean("localvideo_open", bws.buR());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bpu().putInt("card_show_statistic_max_count", bws.fdh);
            b.bpu().putString("nick_name_activity_link", bws.buT());
            String string = b.bpu().getString("clean_smart_frs_cookie", "");
            String buQ = bws.buQ();
            if (!TextUtils.equals(string, buQ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bpu().putString("clean_smart_frs_cookie", buQ);
            b.bpu().putInt("recommend_tab_show", bws.buI());
            b.bpu().putInt("ribao_switch", bws.buJ());
            TbConfig.setMaxPhotoMemoryCache(bws.buS());
            b.bpu().putInt("key_card_show_type", bws.buY());
            TbadkCoreApplication.getInst().setCardShowType(bws.buY());
            b.bpu().putInt("key_card_abstract_switch", bws.buZ());
            ab bva = bws.bva();
            if (bva != null) {
                b.bpu().putBoolean("nani_key_is_show_download_nani_panel", bva.fcr);
                b.bpu().putBoolean("nani_key_is_activate_app", bva.fcs);
                b.bpu().putInt("nani_key_download_show_position", bva.fct);
                b.bpu().putInt("nani_key_download_show_rate", bva.fcu);
                b.bpu().putString("nani_key_download_link_url", bva.fcv);
                b.bpu().putString("nani_key_download_txt", bva.fcw);
                b.bpu().putString("nani_key_show_tail_txt", bva.fcx);
                b.bpu().putInt("nani_key_show_tail_video_type", bva.fcy);
                b.bpu().putString("nani_key_show_tail_txt", bva.fcx);
                b.bpu().putString("nani_key_pre_h5_link", bva.fcz);
            }
            if (bws.bvf() != null) {
                TbSingleton.getInstance().setShakeData(bws.bvf());
            }
            if (!TextUtils.isEmpty(bws.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bws.getSharePanelText());
            }
            b.bpu().putLong("key_frs_cache_time", bws.bvb() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bws.bvc());
            TbSingleton.getInstance().setPushDialogShowTime(bws.bvd());
            TbSingleton.getInstance().setCanShowPermDlg(bws.bve());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bws.bvg());
            TbSingleton.getInstance().setProfileGameCenterKey(bws.bvh());
            TbSingleton.getInstance().setMissionEntranceUrl(bws.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bws.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bws.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bws.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bws.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bws.but());
            TbSingleton.getInstance().setClipboardDelayTime(bws.buW());
        }
    }
}
