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
        aa bVi;

        private a() {
            this.bVi = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bVi.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bVi.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bVi.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bVi.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bVi.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bVi.addPostData("_phone_screen", stringBuffer.toString());
                this.bVi.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bVi.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bVi.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.btV().btY() > 0) {
                    this.bVi.addPostData("_msg_status", "0");
                } else {
                    this.bVi.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bVi.addPostData("_active", activeVersion);
                }
                this.bVi.addPostData("_pic_quality", String.valueOf(k.bhh().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bVi.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bVi.addPostData("package", packageName);
                this.bVi.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bVi.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bVi.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.bVi.postNetData();
                if (this.bVi.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bVi.bon().boU().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.buB().getClientId() != null && eVar.buB().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.buB().getClientId());
                            TbadkCoreApplication.setClientId(eVar.buB().getClientId());
                        }
                        if (eVar.bux() != null) {
                            b.bnH().putInt("crash_limit_count", eVar.bux().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bnH().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bAG().bAH();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.buE());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.buF());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.buG());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.buH());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String buy = TiebaSyncService.this.mModel.buy();
                if (!StringUtils.isNull(buy)) {
                    TbadkCoreApplication.getInst().setConfigVersion(buy);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.buD() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.buD());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.buI() != null) {
                    com.baidu.tbadk.util.a.bAC().a(TiebaSyncService.this.mModel.buI());
                }
                if (TiebaSyncService.this.mModel.buJ() != null) {
                    com.baidu.tbadk.util.a.bAC().a(TiebaSyncService.this.mModel.buJ());
                }
                com.baidu.tbadk.a.b.beZ().M(TiebaSyncService.this.mModel.buK());
                c.bfd().M(TiebaSyncService.this.mModel.buL());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.buC() != null) {
                    str = TiebaSyncService.this.mModel.buC().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.buJ();
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
            String bso = profileData.bso();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bnH().putString("sync_send_maintab_my_tab_lottie_url", bso);
            b.bnH().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bnH().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s bux = this.mModel.bux();
        if (bux != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bsj = bux.bsj();
            if (bsj > 0 && nextInt % bsj == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bux.bsk() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bux.bsk().bsu());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bux.bsl());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.cVZ().sD(false);
        VersionData buA = this.mModel.buA();
        if (buA != null && buA.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(buA);
            broadcastNewVersion();
            if (buA.forceUpdate()) {
                if (this.mModel.bux() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), buA, this.mModel.buz())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && buA.getStrategy() == 0 && this.mModel.bux() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), buA, this.mModel.buz())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj buC = this.mModel.buC();
        if (buC != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(buC.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(buC.bsK());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(buC.bsM());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(buC.bsL());
            TbadkCoreApplication.getInst().setUseNewResign(buC.bsW());
            TbadkCoreApplication.getInst().setUegVoiceWarning(buC.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(buC.bte());
            TbadkCoreApplication.getInst().setGameInfoData(buC.bsX(), buC.bsZ(), buC.bsY());
            ai.boy().saveOrUpdateImages(buC.bsF(), buC.bsG(), buC.bsH(), buC.bsI(), buC.bsJ());
            String bsE = buC.bsE();
            b bnH = b.bnH();
            if (bsE == null) {
                bsE = "";
            }
            bnH.putString("apply_vip_live_room_pid", bsE);
            b.bnH().putString("tail_link", buC.bsN());
            b.bnH().putString("bubble_link", buC.bsO());
            long bsP = buC.bsP();
            if (bsP >= 0 && bsP != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(buC.bsP());
            }
            long bth = buC.bth() * 1000;
            if (bth > 0) {
                b.bnH().putLong("KEY_UPLOAD_LOG_INTERVAL", bth);
            } else {
                long btf = buC.btf() * 1000;
                if (btf > 0) {
                    b.bnH().putLong("KEY_UPLOAD_LOG_INTERVAL", btf);
                }
            }
            XiaoyingUtil.setShowTime(buC.bsQ());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(buC.bsR());
            b.bnH().putLong("recommend_frs_cache_time", buC.bsU());
            b.bnH().putInt("home_page_max_thread_count", buC.bsV());
            b.bnH().putBoolean("localvideo_open", buC.btb());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bnH().putInt("card_show_statistic_max_count", buC.eYj);
            b.bnH().putString("nick_name_activity_link", buC.btd());
            String string = b.bnH().getString("clean_smart_frs_cookie", "");
            String bta = buC.bta();
            if (!TextUtils.equals(string, bta)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bnH().putString("clean_smart_frs_cookie", bta);
            b.bnH().putInt("recommend_tab_show", buC.bsS());
            b.bnH().putInt("ribao_switch", buC.bsT());
            TbConfig.setMaxPhotoMemoryCache(buC.btc());
            b.bnH().putInt("key_card_show_type", buC.bti());
            TbadkCoreApplication.getInst().setCardShowType(buC.bti());
            b.bnH().putInt("key_card_abstract_switch", buC.btj());
            ab btk = buC.btk();
            if (btk != null) {
                b.bnH().putBoolean("nani_key_is_show_download_nani_panel", btk.eXt);
                b.bnH().putBoolean("nani_key_is_activate_app", btk.eXu);
                b.bnH().putInt("nani_key_download_show_position", btk.eXv);
                b.bnH().putInt("nani_key_download_show_rate", btk.eXw);
                b.bnH().putString("nani_key_download_link_url", btk.eXx);
                b.bnH().putString("nani_key_download_txt", btk.eXy);
                b.bnH().putString("nani_key_show_tail_txt", btk.eXz);
                b.bnH().putInt("nani_key_show_tail_video_type", btk.eXA);
                b.bnH().putString("nani_key_show_tail_txt", btk.eXz);
                b.bnH().putString("nani_key_pre_h5_link", btk.eXB);
            }
            if (buC.btp() != null) {
                TbSingleton.getInstance().setShakeData(buC.btp());
            }
            if (!TextUtils.isEmpty(buC.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(buC.getSharePanelText());
            }
            b.bnH().putLong("key_frs_cache_time", buC.btl() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(buC.btm());
            TbSingleton.getInstance().setPushDialogShowTime(buC.btn());
            TbSingleton.getInstance().setCanShowPermDlg(buC.bto());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(buC.btq());
            TbSingleton.getInstance().setProfileGameCenterKey(buC.btr());
            TbSingleton.getInstance().setMissionEntranceUrl(buC.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(buC.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(buC.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(buC.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(buC.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(buC.bsD());
            TbSingleton.getInstance().setClipboardDelayTime(buC.btg());
        }
    }
}
