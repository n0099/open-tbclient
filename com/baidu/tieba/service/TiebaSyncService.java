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
        aa bML;

        private a() {
            this.bML = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bML.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bML.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bML.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bML.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bML.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bML.addPostData("_phone_screen", stringBuffer.toString());
                this.bML.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bML.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bML.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bsc().bsf() > 0) {
                    this.bML.addPostData("_msg_status", "0");
                } else {
                    this.bML.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bML.addPostData("_active", activeVersion);
                }
                this.bML.addPostData("_pic_quality", String.valueOf(k.bfo().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bML.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bML.addPostData("package", packageName);
                this.bML.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bML.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bML.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.bML.postNetData();
                if (this.bML.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bML.bmu().bnb().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bsI().getClientId() != null && eVar.bsI().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bsI().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bsI().getClientId());
                        }
                        if (eVar.bsE() != null) {
                            b.blO().putInt("crash_limit_count", eVar.bsE().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.blO().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bML != null) {
                this.bML.cancelNetConnect();
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
                com.baidu.tbadk.util.b.byN().byO();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bsL());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bsM());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bsN());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bsO());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bsF = TiebaSyncService.this.mModel.bsF();
                if (!StringUtils.isNull(bsF)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bsF);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bsK() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bsK());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bsP() != null) {
                    com.baidu.tbadk.util.a.byJ().a(TiebaSyncService.this.mModel.bsP());
                }
                if (TiebaSyncService.this.mModel.bsQ() != null) {
                    com.baidu.tbadk.util.a.byJ().a(TiebaSyncService.this.mModel.bsQ());
                }
                com.baidu.tbadk.a.b.bdg().M(TiebaSyncService.this.mModel.bsR());
                c.bdk().M(TiebaSyncService.this.mModel.bsS());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bsJ() != null) {
                    str = TiebaSyncService.this.mModel.bsJ().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bsQ();
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
            String bqv = profileData.bqv();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.blO().putString("sync_send_maintab_my_tab_lottie_url", bqv);
            b.blO().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.blO().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bsE = this.mModel.bsE();
        if (bsE != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bqq = bsE.bqq();
            if (bqq > 0 && nextInt % bqq == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bsE.bqr() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bsE.bqr().bqB());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bsE.bqs());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.cSS().sl(false);
        VersionData bsH = this.mModel.bsH();
        if (bsH != null && bsH.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bsH);
            broadcastNewVersion();
            if (bsH.forceUpdate()) {
                if (this.mModel.bsE() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bsH, this.mModel.bsG())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bsH.getStrategy() == 0 && this.mModel.bsE() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bsH, this.mModel.bsG())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj bsJ = this.mModel.bsJ();
        if (bsJ != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bsJ.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bsJ.bqR());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bsJ.bqT());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bsJ.bqS());
            TbadkCoreApplication.getInst().setUseNewResign(bsJ.brd());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bsJ.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bsJ.brl());
            TbadkCoreApplication.getInst().setGameInfoData(bsJ.bre(), bsJ.brg(), bsJ.brf());
            ai.bmF().saveOrUpdateImages(bsJ.bqM(), bsJ.bqN(), bsJ.bqO(), bsJ.bqP(), bsJ.bqQ());
            String bqL = bsJ.bqL();
            b blO = b.blO();
            if (bqL == null) {
                bqL = "";
            }
            blO.putString("apply_vip_live_room_pid", bqL);
            b.blO().putString("tail_link", bsJ.bqU());
            b.blO().putString("bubble_link", bsJ.bqV());
            long bqW = bsJ.bqW();
            if (bqW >= 0 && bqW != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bsJ.bqW());
            }
            long bro = bsJ.bro() * 1000;
            if (bro > 0) {
                b.blO().putLong("KEY_UPLOAD_LOG_INTERVAL", bro);
            } else {
                long brm = bsJ.brm() * 1000;
                if (brm > 0) {
                    b.blO().putLong("KEY_UPLOAD_LOG_INTERVAL", brm);
                }
            }
            XiaoyingUtil.setShowTime(bsJ.bqX());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bsJ.bqY());
            b.blO().putLong("recommend_frs_cache_time", bsJ.brb());
            b.blO().putInt("home_page_max_thread_count", bsJ.brc());
            b.blO().putBoolean("localvideo_open", bsJ.bri());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.blO().putInt("card_show_statistic_max_count", bsJ.ePN);
            b.blO().putString("nick_name_activity_link", bsJ.brk());
            String string = b.blO().getString("clean_smart_frs_cookie", "");
            String brh = bsJ.brh();
            if (!TextUtils.equals(string, brh)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.blO().putString("clean_smart_frs_cookie", brh);
            b.blO().putInt("recommend_tab_show", bsJ.bqZ());
            b.blO().putInt("ribao_switch", bsJ.bra());
            TbConfig.setMaxPhotoMemoryCache(bsJ.brj());
            b.blO().putInt("key_card_show_type", bsJ.brp());
            TbadkCoreApplication.getInst().setCardShowType(bsJ.brp());
            b.blO().putInt("key_card_abstract_switch", bsJ.brq());
            ab brr = bsJ.brr();
            if (brr != null) {
                b.blO().putBoolean("nani_key_is_show_download_nani_panel", brr.eOX);
                b.blO().putBoolean("nani_key_is_activate_app", brr.eOY);
                b.blO().putInt("nani_key_download_show_position", brr.eOZ);
                b.blO().putInt("nani_key_download_show_rate", brr.ePa);
                b.blO().putString("nani_key_download_link_url", brr.ePb);
                b.blO().putString("nani_key_download_txt", brr.ePc);
                b.blO().putString("nani_key_show_tail_txt", brr.ePd);
                b.blO().putInt("nani_key_show_tail_video_type", brr.ePe);
                b.blO().putString("nani_key_show_tail_txt", brr.ePd);
                b.blO().putString("nani_key_pre_h5_link", brr.ePf);
            }
            if (bsJ.brw() != null) {
                TbSingleton.getInstance().setShakeData(bsJ.brw());
            }
            if (!TextUtils.isEmpty(bsJ.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bsJ.getSharePanelText());
            }
            b.blO().putLong("key_frs_cache_time", bsJ.brs() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bsJ.brt());
            TbSingleton.getInstance().setPushDialogShowTime(bsJ.bru());
            TbSingleton.getInstance().setCanShowPermDlg(bsJ.brv());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bsJ.brx());
            TbSingleton.getInstance().setProfileGameCenterKey(bsJ.bry());
            TbSingleton.getInstance().setMissionEntranceUrl(bsJ.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bsJ.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bsJ.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bsJ.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bsJ.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bsJ.bqK());
            TbSingleton.getInstance().setClipboardDelayTime(bsJ.brn());
        }
    }
}
