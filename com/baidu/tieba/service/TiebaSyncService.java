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
import com.baidu.tbadk.core.util.av;
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
        aa caS;

        private a() {
            this.caS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.caS.addPostData("_os_version", Build.VERSION.RELEASE);
                this.caS.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.caS.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.caS.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.caS.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.caS.addPostData("_phone_screen", stringBuffer.toString());
                this.caS.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.caS.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.caS.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bwv().bwy() > 0) {
                    this.caS.addPostData("_msg_status", "0");
                } else {
                    this.caS.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.caS.addPostData("_active", activeVersion);
                }
                this.caS.addPostData("_pic_quality", String.valueOf(k.bjH().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.caS.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.caS.addPostData("package", packageName);
                this.caS.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.caS.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.caS.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.caS.postNetData();
                if (this.caS.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.caS.bqN().bru().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bxb().getClientId() != null && eVar.bxb().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bxb().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bxb().getClientId());
                        }
                        if (eVar.bwX() != null) {
                            b.bqh().putInt("crash_limit_count", eVar.bwX().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bqh().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.caS != null) {
                this.caS.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bDf().bDg();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bxe());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bxf());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bxg());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bxh());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bwY = TiebaSyncService.this.mModel.bwY();
                if (!StringUtils.isNull(bwY)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bwY);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bxd() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bxd());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bxi() != null) {
                    com.baidu.tbadk.util.a.bDb().a(TiebaSyncService.this.mModel.bxi());
                }
                if (TiebaSyncService.this.mModel.bxj() != null) {
                    com.baidu.tbadk.util.a.bDb().a(TiebaSyncService.this.mModel.bxj());
                }
                com.baidu.tbadk.a.b.bhz().M(TiebaSyncService.this.mModel.bxk());
                c.bhD().M(TiebaSyncService.this.mModel.bxl());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bxc() != null) {
                    str = TiebaSyncService.this.mModel.bxc().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bxj();
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
            String buO = profileData.buO();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bqh().putString("sync_send_maintab_my_tab_lottie_url", buO);
            b.bqh().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bqh().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bwX = this.mModel.bwX();
        if (bwX != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int buJ = bwX.buJ();
            if (buJ > 0 && nextInt % buJ == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bwX.buK() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bwX.buK().buU());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bwX.buL());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.cYA().sM(false);
        VersionData bxa = this.mModel.bxa();
        if (bxa != null && bxa.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bxa);
            broadcastNewVersion();
            if (bxa.forceUpdate()) {
                if (this.mModel.bwX() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bxa, this.mModel.bwZ())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bxa.getStrategy() == 0 && this.mModel.bwX() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bxa, this.mModel.bwZ())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bxc = this.mModel.bxc();
        if (bxc != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bxc.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bxc.bvk());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bxc.bvm());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bxc.bvl());
            TbadkCoreApplication.getInst().setUseNewResign(bxc.bvw());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bxc.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bxc.bvE());
            TbadkCoreApplication.getInst().setGameInfoData(bxc.bvx(), bxc.bvz(), bxc.bvy());
            ai.bqY().saveOrUpdateImages(bxc.bvf(), bxc.bvg(), bxc.bvh(), bxc.bvi(), bxc.bvj());
            String bve = bxc.bve();
            b bqh = b.bqh();
            if (bve == null) {
                bve = "";
            }
            bqh.putString("apply_vip_live_room_pid", bve);
            b.bqh().putString("tail_link", bxc.bvn());
            b.bqh().putString("bubble_link", bxc.bvo());
            long bvp = bxc.bvp();
            if (bvp >= 0 && bvp != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bxc.bvp());
            }
            long bvH = bxc.bvH() * 1000;
            if (bvH > 0) {
                b.bqh().putLong("KEY_UPLOAD_LOG_INTERVAL", bvH);
            } else {
                long bvF = bxc.bvF() * 1000;
                if (bvF > 0) {
                    b.bqh().putLong("KEY_UPLOAD_LOG_INTERVAL", bvF);
                }
            }
            XiaoyingUtil.setShowTime(bxc.bvq());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bxc.bvr());
            b.bqh().putLong("recommend_frs_cache_time", bxc.bvu());
            b.bqh().putInt("home_page_max_thread_count", bxc.bvv());
            b.bqh().putBoolean("localvideo_open", bxc.bvB());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bqh().putInt("card_show_statistic_max_count", bxc.fdZ);
            b.bqh().putString("nick_name_activity_link", bxc.bvD());
            String string = b.bqh().getString("clean_smart_frs_cookie", "");
            String bvA = bxc.bvA();
            if (!TextUtils.equals(string, bvA)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bqh().putString("clean_smart_frs_cookie", bvA);
            b.bqh().putInt("recommend_tab_show", bxc.bvs());
            b.bqh().putInt("ribao_switch", bxc.bvt());
            TbConfig.setMaxPhotoMemoryCache(bxc.bvC());
            b.bqh().putInt("key_card_show_type", bxc.bvI());
            TbadkCoreApplication.getInst().setCardShowType(bxc.bvI());
            b.bqh().putInt("key_card_abstract_switch", bxc.bvJ());
            ab bvK = bxc.bvK();
            if (bvK != null) {
                b.bqh().putBoolean("nani_key_is_show_download_nani_panel", bvK.fdj);
                b.bqh().putBoolean("nani_key_is_activate_app", bvK.fdk);
                b.bqh().putInt("nani_key_download_show_position", bvK.fdl);
                b.bqh().putInt("nani_key_download_show_rate", bvK.fdm);
                b.bqh().putString("nani_key_download_link_url", bvK.fdn);
                b.bqh().putString("nani_key_download_txt", bvK.fdo);
                b.bqh().putString("nani_key_show_tail_txt", bvK.fdp);
                b.bqh().putInt("nani_key_show_tail_video_type", bvK.fdq);
                b.bqh().putString("nani_key_show_tail_txt", bvK.fdp);
                b.bqh().putString("nani_key_pre_h5_link", bvK.fdr);
            }
            if (bxc.bvP() != null) {
                TbSingleton.getInstance().setShakeData(bxc.bvP());
            }
            if (!TextUtils.isEmpty(bxc.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bxc.getSharePanelText());
            }
            b.bqh().putLong("key_frs_cache_time", bxc.bvL() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bxc.bvM());
            TbSingleton.getInstance().setPushDialogShowTime(bxc.bvN());
            TbSingleton.getInstance().setCanShowPermDlg(bxc.bvO());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bxc.bvQ());
            TbSingleton.getInstance().setProfileGameCenterKey(bxc.bvR());
            TbSingleton.getInstance().setMissionEntranceUrl(bxc.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bxc.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bxc.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bxc.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bxc.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bxc.bvd());
            TbSingleton.getInstance().setClipboardDelayTime(bxc.bvG());
        }
    }
}
