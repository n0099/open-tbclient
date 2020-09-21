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
        aa bGb;

        private a() {
            this.bGb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bGb.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bGb.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bGb.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bGb.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bGb.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bGb.addPostData("_phone_screen", stringBuffer.toString());
                this.bGb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bGb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bGb.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bps().bpv() > 0) {
                    this.bGb.addPostData("_msg_status", "0");
                } else {
                    this.bGb.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bGb.addPostData("_active", activeVersion);
                }
                this.bGb.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bGb.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bGb.addPostData("package", packageName);
                this.bGb.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bGb.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bGb.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.bGb.postNetData();
                if (this.bGb.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bGb.bjL().bkr().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bpY().getClientId() != null && eVar.bpY().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bpY().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bpY().getClientId());
                        }
                        if (eVar.bpU() != null) {
                            b.bjf().putInt("crash_limit_count", eVar.bpU().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bjf().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bwd().bwe();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bqb());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bqc());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bqd());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bqe());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bpV = TiebaSyncService.this.mModel.bpV();
                if (!StringUtils.isNull(bpV)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bpV);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bqa() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bqa());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bqf() != null) {
                    com.baidu.tbadk.util.a.bvZ().a(TiebaSyncService.this.mModel.bqf());
                }
                if (TiebaSyncService.this.mModel.bqg() != null) {
                    com.baidu.tbadk.util.a.bvZ().a(TiebaSyncService.this.mModel.bqg());
                }
                com.baidu.tbadk.a.b.bay().M(TiebaSyncService.this.mModel.bqh());
                c.baC().M(TiebaSyncService.this.mModel.bqi());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bpZ() != null) {
                    str = TiebaSyncService.this.mModel.bpZ().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bqg();
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
            String bnL = profileData.bnL();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bjf().putString("sync_send_maintab_my_tab_lottie_url", bnL);
            b.bjf().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bjf().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bpU = this.mModel.bpU();
        if (bpU != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bnG = bpU.bnG();
            if (bnG > 0 && nextInt % bnG == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bpU.bnH() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bpU.bnH().bnR());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bpU.bnI());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bpX = this.mModel.bpX();
        if (bpX != null && bpX.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bpX);
            broadcastNewVersion();
            if (bpX.forceUpdate()) {
                if (this.mModel.bpU() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpX, this.mModel.bpW())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bpX.getStrategy() == 0 && this.mModel.bpU() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpX, this.mModel.bpW())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bpZ = this.mModel.bpZ();
        if (bpZ != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bpZ.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bpZ.boh());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bpZ.boj());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bpZ.boi());
            TbadkCoreApplication.getInst().setUseNewResign(bpZ.bot());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bpZ.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bpZ.boB());
            TbadkCoreApplication.getInst().setGameInfoData(bpZ.bou(), bpZ.bow(), bpZ.bov());
            ai.bjW().saveOrUpdateImages(bpZ.boc(), bpZ.bod(), bpZ.boe(), bpZ.bof(), bpZ.bog());
            String bob = bpZ.bob();
            b bjf = b.bjf();
            if (bob == null) {
                bob = "";
            }
            bjf.putString("apply_vip_live_room_pid", bob);
            b.bjf().putString("tail_link", bpZ.bok());
            b.bjf().putString("bubble_link", bpZ.bol());
            long bom = bpZ.bom();
            if (bom >= 0 && bom != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bpZ.bom());
            }
            long boE = bpZ.boE() * 1000;
            if (boE > 0) {
                b.bjf().putLong("KEY_UPLOAD_LOG_INTERVAL", boE);
            } else {
                long boC = bpZ.boC() * 1000;
                if (boC > 0) {
                    b.bjf().putLong("KEY_UPLOAD_LOG_INTERVAL", boC);
                }
            }
            XiaoyingUtil.setShowTime(bpZ.bon());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bpZ.boo());
            b.bjf().putLong("recommend_frs_cache_time", bpZ.bor());
            b.bjf().putInt("home_page_max_thread_count", bpZ.bos());
            b.bjf().putBoolean("localvideo_open", bpZ.boy());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bjf().putInt("card_show_statistic_max_count", bpZ.eDG);
            b.bjf().putString("nick_name_activity_link", bpZ.boA());
            String string = b.bjf().getString("clean_smart_frs_cookie", "");
            String box = bpZ.box();
            if (!TextUtils.equals(string, box)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bjf().putString("clean_smart_frs_cookie", box);
            b.bjf().putInt("recommend_tab_show", bpZ.bop());
            b.bjf().putInt("ribao_switch", bpZ.boq());
            TbConfig.setMaxPhotoMemoryCache(bpZ.boz());
            b.bjf().putInt("key_card_show_type", bpZ.boF());
            TbadkCoreApplication.getInst().setCardShowType(bpZ.boF());
            b.bjf().putInt("key_card_abstract_switch", bpZ.boG());
            ab boH = bpZ.boH();
            if (boH != null) {
                b.bjf().putBoolean("nani_key_is_show_download_nani_panel", boH.eCQ);
                b.bjf().putBoolean("nani_key_is_activate_app", boH.eCR);
                b.bjf().putInt("nani_key_download_show_position", boH.eCS);
                b.bjf().putInt("nani_key_download_show_rate", boH.eCT);
                b.bjf().putString("nani_key_download_link_url", boH.eCU);
                b.bjf().putString("nani_key_download_txt", boH.eCV);
                b.bjf().putString("nani_key_show_tail_txt", boH.eCW);
                b.bjf().putInt("nani_key_show_tail_video_type", boH.eCX);
                b.bjf().putString("nani_key_show_tail_txt", boH.eCW);
                b.bjf().putString("nani_key_pre_h5_link", boH.eCY);
            }
            if (bpZ.boM() != null) {
                TbSingleton.getInstance().setShakeData(bpZ.boM());
            }
            if (!TextUtils.isEmpty(bpZ.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bpZ.getSharePanelText());
            }
            b.bjf().putLong("key_frs_cache_time", bpZ.boI() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bpZ.boJ());
            TbSingleton.getInstance().setPushDialogShowTime(bpZ.boK());
            TbSingleton.getInstance().setCanShowPermDlg(bpZ.boL());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bpZ.boN());
            TbSingleton.getInstance().setProfileGameCenterKey(bpZ.boO());
            TbSingleton.getInstance().setMissionEntranceUrl(bpZ.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bpZ.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bpZ.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bpZ.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bpZ.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bpZ.boa());
            TbSingleton.getInstance().setClipboardDelayTime(bpZ.boD());
        }
    }
}
