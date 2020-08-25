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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.Random;
/* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, e> {
        aa bDY;

        private a() {
            this.bDY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bDY.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bDY.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bDY.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bDY.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bDY.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bDY.addPostData("_phone_screen", stringBuffer.toString());
                this.bDY.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bDY.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bDY.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.boy().boB() > 0) {
                    this.bDY.addPostData("_msg_status", "0");
                } else {
                    this.bDY.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bDY.addPostData("_active", activeVersion);
                }
                this.bDY.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bDY.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bDY.addPostData("package", packageName);
                this.bDY.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bDY.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bDY.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.bDY.postNetData();
                if (this.bDY.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bDY.biQ().bjw().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bpd().getClientId() != null && eVar.bpd().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bpd().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bpd().getClientId());
                        }
                        if (eVar.boZ() != null) {
                            b.bik().putInt("crash_limit_count", eVar.boZ().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.bik().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
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
                com.baidu.tbadk.util.b.buY().buZ();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bpg());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bph());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bpi());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bpj());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bpa = TiebaSyncService.this.mModel.bpa();
                if (!StringUtils.isNull(bpa)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bpa);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bpf() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bpf());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bpk() != null) {
                    com.baidu.tbadk.util.a.buU().a(TiebaSyncService.this.mModel.bpk());
                }
                if (TiebaSyncService.this.mModel.bpl() != null) {
                    com.baidu.tbadk.util.a.buU().a(TiebaSyncService.this.mModel.bpl());
                }
                com.baidu.tbadk.a.b.aZJ().M(TiebaSyncService.this.mModel.bpm());
                c.aZN().M(TiebaSyncService.this.mModel.bpn());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bpe() != null) {
                    str = TiebaSyncService.this.mModel.bpe().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bpl();
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
        ab profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String bmR = profileData.bmR();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.bik().putString("sync_send_maintab_my_tab_lottie_url", bmR);
            b.bik().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.bik().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        r boZ = this.mModel.boZ();
        if (boZ != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bmM = boZ.bmM();
            if (bmM > 0 && nextInt % bmM == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (boZ.bmN() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(boZ.bmN().bmX());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(boZ.bmO());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bpc = this.mModel.bpc();
        if (bpc != null && bpc.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bpc);
            broadcastNewVersion();
            if (bpc.forceUpdate()) {
                if (this.mModel.boZ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpc, this.mModel.bpb())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bpc.getStrategy() == 0 && this.mModel.boZ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpc, this.mModel.bpb())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ai bpe = this.mModel.bpe();
        if (bpe != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bpe.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bpe.bnn());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bpe.bnp());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bpe.bno());
            TbadkCoreApplication.getInst().setUseNewResign(bpe.bnz());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bpe.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bpe.bnH());
            TbadkCoreApplication.getInst().setGameInfoData(bpe.bnA(), bpe.bnC(), bpe.bnB());
            com.baidu.tbadk.core.util.ai.bjb().saveOrUpdateImages(bpe.bni(), bpe.bnj(), bpe.bnk(), bpe.bnl(), bpe.bnm());
            String bnh = bpe.bnh();
            b bik = b.bik();
            if (bnh == null) {
                bnh = "";
            }
            bik.putString("apply_vip_live_room_pid", bnh);
            b.bik().putString("tail_link", bpe.bnq());
            b.bik().putString("bubble_link", bpe.bnr());
            long bns = bpe.bns();
            if (bns >= 0 && bns != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bpe.bns());
            }
            long bnK = bpe.bnK() * 1000;
            if (bnK > 0) {
                b.bik().putLong("KEY_UPLOAD_LOG_INTERVAL", bnK);
            } else {
                long bnI = bpe.bnI() * 1000;
                if (bnI > 0) {
                    b.bik().putLong("KEY_UPLOAD_LOG_INTERVAL", bnI);
                }
            }
            XiaoyingUtil.setShowTime(bpe.bnt());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bpe.bnu());
            b.bik().putLong("recommend_frs_cache_time", bpe.bnx());
            b.bik().putInt("home_page_max_thread_count", bpe.bny());
            b.bik().putBoolean("localvideo_open", bpe.bnE());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bik().putInt("card_show_statistic_max_count", bpe.eBx);
            b.bik().putString("nick_name_activity_link", bpe.bnG());
            String string = b.bik().getString("clean_smart_frs_cookie", "");
            String bnD = bpe.bnD();
            if (!TextUtils.equals(string, bnD)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bik().putString("clean_smart_frs_cookie", bnD);
            b.bik().putInt("recommend_tab_show", bpe.bnv());
            b.bik().putInt("ribao_switch", bpe.bnw());
            TbConfig.setMaxPhotoMemoryCache(bpe.bnF());
            b.bik().putInt("key_card_show_type", bpe.bnL());
            TbadkCoreApplication.getInst().setCardShowType(bpe.bnL());
            b.bik().putInt("key_card_abstract_switch", bpe.bnM());
            com.baidu.tbadk.coreExtra.data.aa bnN = bpe.bnN();
            if (bnN != null) {
                b.bik().putBoolean("nani_key_is_show_download_nani_panel", bnN.eAH);
                b.bik().putBoolean("nani_key_is_activate_app", bnN.eAI);
                b.bik().putInt("nani_key_download_show_position", bnN.eAJ);
                b.bik().putInt("nani_key_download_show_rate", bnN.eAK);
                b.bik().putString("nani_key_download_link_url", bnN.eAL);
                b.bik().putString("nani_key_download_txt", bnN.eAM);
                b.bik().putString("nani_key_show_tail_txt", bnN.eAN);
                b.bik().putInt("nani_key_show_tail_video_type", bnN.eAO);
                b.bik().putString("nani_key_show_tail_txt", bnN.eAN);
                b.bik().putString("nani_key_pre_h5_link", bnN.eAP);
            }
            if (bpe.bnS() != null) {
                TbSingleton.getInstance().setShakeData(bpe.bnS());
            }
            if (!TextUtils.isEmpty(bpe.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bpe.getSharePanelText());
            }
            b.bik().putLong("key_frs_cache_time", bpe.bnO() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bpe.bnP());
            TbSingleton.getInstance().setPushDialogShowTime(bpe.bnQ());
            TbSingleton.getInstance().setCanShowPermDlg(bpe.bnR());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bpe.bnT());
            TbSingleton.getInstance().setProfileGameCenterKey(bpe.bnU());
            TbSingleton.getInstance().setMissionEntranceUrl(bpe.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bpe.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bpe.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bpe.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bpe.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bpe.bng());
            TbSingleton.getInstance().setClipboardDelayTime(bpe.bnJ());
        }
    }
}
