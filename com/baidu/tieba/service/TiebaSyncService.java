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
        aa bEb;

        private a() {
            this.bEb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public e doInBackground(String... strArr) {
            e eVar;
            Exception e;
            try {
                this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bEb.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bEb.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bEb.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bEb.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bEb.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bEb.addPostData("_phone_screen", stringBuffer.toString());
                this.bEb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bEb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bEb.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.boy().boB() > 0) {
                    this.bEb.addPostData("_msg_status", "0");
                } else {
                    this.bEb.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bEb.addPostData("_active", activeVersion);
                }
                this.bEb.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bEb.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bEb.addPostData("package", packageName);
                this.bEb.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bEb.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bEb.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.bEb.postNetData();
                if (this.bEb.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bEb.biQ().bjw().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bpe().getClientId() != null && eVar.bpe().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bpe().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bpe().getClientId());
                        }
                        if (eVar.bpa() != null) {
                            b.bik().putInt("crash_limit_count", eVar.bpa().getCrashLimitCount());
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
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
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
                com.baidu.tbadk.util.b.buZ().bva();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bph());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bpi());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bpj());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bpk());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bpb = TiebaSyncService.this.mModel.bpb();
                if (!StringUtils.isNull(bpb)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bpb);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bpg() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bpg());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bpl() != null) {
                    com.baidu.tbadk.util.a.buV().a(TiebaSyncService.this.mModel.bpl());
                }
                if (TiebaSyncService.this.mModel.bpm() != null) {
                    com.baidu.tbadk.util.a.buV().a(TiebaSyncService.this.mModel.bpm());
                }
                com.baidu.tbadk.a.b.aZJ().M(TiebaSyncService.this.mModel.bpn());
                c.aZN().M(TiebaSyncService.this.mModel.bpo());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bpf() != null) {
                    str = TiebaSyncService.this.mModel.bpf().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bpm();
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
        r bpa = this.mModel.bpa();
        if (bpa != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bmM = bpa.bmM();
            if (bmM > 0 && nextInt % bmM == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bpa.bmN() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bpa.bmN().bmX());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bpa.bmO());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bpd = this.mModel.bpd();
        if (bpd != null && bpd.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bpd);
            broadcastNewVersion();
            if (bpd.forceUpdate()) {
                if (this.mModel.bpa() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpd, this.mModel.bpc())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bpd.getStrategy() == 0 && this.mModel.bpa() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bpd, this.mModel.bpc())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ai bpf = this.mModel.bpf();
        if (bpf != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bpf.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bpf.bnn());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bpf.bnp());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bpf.bno());
            TbadkCoreApplication.getInst().setUseNewResign(bpf.bnz());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bpf.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bpf.bnH());
            TbadkCoreApplication.getInst().setGameInfoData(bpf.bnA(), bpf.bnC(), bpf.bnB());
            com.baidu.tbadk.core.util.ai.bjb().saveOrUpdateImages(bpf.bni(), bpf.bnj(), bpf.bnk(), bpf.bnl(), bpf.bnm());
            String bnh = bpf.bnh();
            b bik = b.bik();
            if (bnh == null) {
                bnh = "";
            }
            bik.putString("apply_vip_live_room_pid", bnh);
            b.bik().putString("tail_link", bpf.bnq());
            b.bik().putString("bubble_link", bpf.bnr());
            long bns = bpf.bns();
            if (bns >= 0 && bns != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bpf.bns());
            }
            long bnK = bpf.bnK() * 1000;
            if (bnK > 0) {
                b.bik().putLong("KEY_UPLOAD_LOG_INTERVAL", bnK);
            } else {
                long bnI = bpf.bnI() * 1000;
                if (bnI > 0) {
                    b.bik().putLong("KEY_UPLOAD_LOG_INTERVAL", bnI);
                }
            }
            XiaoyingUtil.setShowTime(bpf.bnt());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bpf.bnu());
            b.bik().putLong("recommend_frs_cache_time", bpf.bnx());
            b.bik().putInt("home_page_max_thread_count", bpf.bny());
            b.bik().putBoolean("localvideo_open", bpf.bnE());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.bik().putInt("card_show_statistic_max_count", bpf.eBB);
            b.bik().putString("nick_name_activity_link", bpf.bnG());
            String string = b.bik().getString("clean_smart_frs_cookie", "");
            String bnD = bpf.bnD();
            if (!TextUtils.equals(string, bnD)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.bik().putString("clean_smart_frs_cookie", bnD);
            b.bik().putInt("recommend_tab_show", bpf.bnv());
            b.bik().putInt("ribao_switch", bpf.bnw());
            TbConfig.setMaxPhotoMemoryCache(bpf.bnF());
            b.bik().putInt("key_card_show_type", bpf.bnL());
            TbadkCoreApplication.getInst().setCardShowType(bpf.bnL());
            b.bik().putInt("key_card_abstract_switch", bpf.bnM());
            com.baidu.tbadk.coreExtra.data.aa bnN = bpf.bnN();
            if (bnN != null) {
                b.bik().putBoolean("nani_key_is_show_download_nani_panel", bnN.eAL);
                b.bik().putBoolean("nani_key_is_activate_app", bnN.eAM);
                b.bik().putInt("nani_key_download_show_position", bnN.eAN);
                b.bik().putInt("nani_key_download_show_rate", bnN.eAO);
                b.bik().putString("nani_key_download_link_url", bnN.eAP);
                b.bik().putString("nani_key_download_txt", bnN.eAQ);
                b.bik().putString("nani_key_show_tail_txt", bnN.eAR);
                b.bik().putInt("nani_key_show_tail_video_type", bnN.eAS);
                b.bik().putString("nani_key_show_tail_txt", bnN.eAR);
                b.bik().putString("nani_key_pre_h5_link", bnN.eAT);
            }
            if (bpf.bnS() != null) {
                TbSingleton.getInstance().setShakeData(bpf.bnS());
            }
            if (!TextUtils.isEmpty(bpf.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bpf.getSharePanelText());
            }
            b.bik().putLong("key_frs_cache_time", bpf.bnO() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bpf.bnP());
            TbSingleton.getInstance().setPushDialogShowTime(bpf.bnQ());
            TbSingleton.getInstance().setCanShowPermDlg(bpf.bnR());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bpf.bnT());
            TbSingleton.getInstance().setProfileGameCenterKey(bpf.bnU());
            TbSingleton.getInstance().setMissionEntranceUrl(bpf.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bpf.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bpf.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bpf.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bpf.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bpf.bng());
            TbSingleton.getInstance().setClipboardDelayTime(bpf.bnJ());
        }
    }
}
