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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.x;
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
        y byb;

        private a() {
            this.byb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.byb.addPostData("_os_version", Build.VERSION.RELEASE);
                this.byb.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.byb.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.byb.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.byb.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.byb.addPostData("_phone_screen", stringBuffer.toString());
                this.byb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.byb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.byb.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bbY() > 0) {
                    this.byb.addPostData("_msg_status", "0");
                } else {
                    this.byb.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.byb.addPostData("_active", activeVersion);
                }
                this.byb.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.byb.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.byb.addPostData("package", packageName);
                this.byb.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.byb.addPostData("signmd5", at.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.byb.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.byb.postNetData();
                if (this.byb.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.byb.aWu().aWW().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.bcz().getClientId() != null && dVar.bcz().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.bcz().getClientId());
                            TbadkCoreApplication.setClientId(dVar.bcz().getClientId());
                        }
                        if (dVar.bcv() != null) {
                            b.aVP().putInt("crash_limit_count", dVar.bcv().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aVP().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.byb != null) {
                this.byb.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bix().biy();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bcC());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bcD());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bcE());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bcF());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bcw = TiebaSyncService.this.mModel.bcw();
                if (!StringUtils.isNull(bcw)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bcw);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bcB() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bcB());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bcG() != null) {
                    com.baidu.tbadk.util.a.biv().a(TiebaSyncService.this.mModel.bcG());
                }
                if (TiebaSyncService.this.mModel.bcH() != null) {
                    com.baidu.tbadk.util.a.biv().a(TiebaSyncService.this.mModel.bcH());
                }
                com.baidu.tbadk.a.b.aNE().J(TiebaSyncService.this.mModel.bcI());
                c.aNI().J(TiebaSyncService.this.mModel.bcJ());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bcA() != null) {
                    str = TiebaSyncService.this.mModel.bcA().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bcH();
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
        com.baidu.tbadk.coreExtra.data.y profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String bak = profileData.bak();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aVP().putString("sync_send_maintab_my_tab_lottie_url", bak);
            b.aVP().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aVP().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o bcv = this.mModel.bcv();
        if (bcv != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int baf = bcv.baf();
            if (baf > 0 && nextInt % baf == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bcv.bag() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bcv.bag().baq());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bcv.bah());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bcy = this.mModel.bcy();
        if (bcy != null && bcy.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bcy);
            broadcastNewVersion();
            if (bcy.forceUpdate()) {
                if (this.mModel.bcv() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bcy, this.mModel.bcx())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bcy.getStrategy() == 0 && this.mModel.bcv() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bcy, this.mModel.bcx())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        af bcA = this.mModel.bcA();
        if (bcA != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bcA.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bcA.baG());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bcA.baI());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bcA.baH());
            TbadkCoreApplication.getInst().setUseNewResign(bcA.baS());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bcA.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bcA.bba());
            TbadkCoreApplication.getInst().setGameInfoData(bcA.baT(), bcA.baV(), bcA.baU());
            ag.aWC().saveOrUpdateImages(bcA.baB(), bcA.baC(), bcA.baD(), bcA.baE(), bcA.baF());
            String baA = bcA.baA();
            b aVP = b.aVP();
            if (baA == null) {
                baA = "";
            }
            aVP.putString("apply_vip_live_room_pid", baA);
            b.aVP().putString("tail_link", bcA.baJ());
            b.aVP().putString("bubble_link", bcA.baK());
            long baL = bcA.baL();
            if (baL >= 0 && baL != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bcA.baL());
            }
            long bbd = bcA.bbd() * 1000;
            if (bbd > 0) {
                b.aVP().putLong("KEY_UPLOAD_LOG_INTERVAL", bbd);
            } else {
                long bbb = bcA.bbb() * 1000;
                if (bbb > 0) {
                    b.aVP().putLong("KEY_UPLOAD_LOG_INTERVAL", bbb);
                }
            }
            XiaoyingUtil.setShowTime(bcA.baM());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bcA.baN());
            b.aVP().putLong("recommend_frs_cache_time", bcA.baQ());
            b.aVP().putInt("home_page_max_thread_count", bcA.baR());
            b.aVP().putBoolean("localvideo_open", bcA.baX());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aVP().putInt("card_show_statistic_max_count", bcA.ekP);
            b.aVP().putString("nick_name_activity_link", bcA.baZ());
            String string = b.aVP().getString("clean_smart_frs_cookie", "");
            String baW = bcA.baW();
            if (!TextUtils.equals(string, baW)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aVP().putString("clean_smart_frs_cookie", baW);
            b.aVP().putInt("recommend_tab_show", bcA.baO());
            b.aVP().putInt("ribao_switch", bcA.baP());
            TbConfig.setMaxPhotoMemoryCache(bcA.baY());
            b.aVP().putInt("key_card_show_type", bcA.bbe());
            TbadkCoreApplication.getInst().setCardShowType(bcA.bbe());
            b.aVP().putInt("key_card_abstract_switch", bcA.bbf());
            x bbg = bcA.bbg();
            if (bbg != null) {
                b.aVP().putBoolean("nani_key_is_show_download_nani_panel", bbg.ejZ);
                b.aVP().putBoolean("nani_key_is_activate_app", bbg.eka);
                b.aVP().putInt("nani_key_download_show_position", bbg.ekb);
                b.aVP().putInt("nani_key_download_show_rate", bbg.ekc);
                b.aVP().putString("nani_key_download_link_url", bbg.ekd);
                b.aVP().putString("nani_key_download_txt", bbg.eke);
                b.aVP().putString("nani_key_show_tail_txt", bbg.ekf);
                b.aVP().putInt("nani_key_show_tail_video_type", bbg.ekg);
                b.aVP().putString("nani_key_show_tail_txt", bbg.ekf);
                b.aVP().putString("nani_key_pre_h5_link", bbg.ekh);
            }
            if (bcA.bbl() != null) {
                TbSingleton.getInstance().setShakeData(bcA.bbl());
            }
            if (!TextUtils.isEmpty(bcA.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bcA.getSharePanelText());
            }
            b.aVP().putLong("key_frs_cache_time", bcA.bbh() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bcA.bbi());
            TbSingleton.getInstance().setPushDialogShowTime(bcA.bbj());
            TbSingleton.getInstance().setCanShowPermDlg(bcA.bbk());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bcA.bbm());
            TbSingleton.getInstance().setProfileGameCenterKey(bcA.bbn());
            TbSingleton.getInstance().setMissionEntranceUrl(bcA.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bcA.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bcA.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bcA.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bcA.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bcA.baz());
            TbSingleton.getInstance().setClipboardDelayTime(bcA.bbc());
        }
    }
}
