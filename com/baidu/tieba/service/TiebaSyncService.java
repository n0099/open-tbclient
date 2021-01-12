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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.z;
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
        z chV;

        private a() {
            this.chV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Z */
        public e doInBackground(String... strArr) {
            e eVar;
            try {
                this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.chV.addPostData("_os_version", Build.VERSION.RELEASE);
                this.chV.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.chV.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.chV.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.chV.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.chV.addPostData("_phone_screen", stringBuffer.toString());
                this.chV.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.chV.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.chV.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (d.bxM().bxP() > 0) {
                    this.chV.addPostData("_msg_status", "0");
                } else {
                    this.chV.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.chV.addPostData("_active", activeVersion);
                }
                this.chV.addPostData("_pic_quality", String.valueOf(k.bkB().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.chV.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.chV.addPostData("package", packageName);
                this.chV.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.chV.addPostData("signmd5", av.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.chV.addPostData("md5", i.getTiebaApkMd5());
                String postNetData = this.chV.postNetData();
                if (this.chV.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.chV.brX().bsH().isRequestSuccess()) {
                    eVar = new e();
                    try {
                        eVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && eVar.bys().getClientId() != null && eVar.bys().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, eVar.bys().getClientId());
                            TbadkCoreApplication.setClientId(eVar.bys().getClientId());
                        }
                        if (eVar.byo() != null) {
                            b.brx().putInt("crash_limit_count", eVar.byo().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = eVar.getAdAdSense();
                        if (eVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.brx().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.chV != null) {
                this.chV.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bED().bEE();
                TiebaSyncService.this.mModel = eVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.byv());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.byw());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.byx());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.byy());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String byp = TiebaSyncService.this.mModel.byp();
                if (!StringUtils.isNull(byp)) {
                    TbadkCoreApplication.getInst().setConfigVersion(byp);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.byu() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.byu());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.byz() != null) {
                    com.baidu.tbadk.util.a.bEz().a(TiebaSyncService.this.mModel.byz());
                }
                if (TiebaSyncService.this.mModel.byA() != null) {
                    com.baidu.tbadk.util.a.bEz().a(TiebaSyncService.this.mModel.byA());
                }
                com.baidu.tbadk.a.b.bit().N(TiebaSyncService.this.mModel.byB());
                c.bix().N(TiebaSyncService.this.mModel.byC());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.byt() != null) {
                    str = TiebaSyncService.this.mModel.byt().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                if (TiebaSyncService.this.mModel.byC() != null) {
                    str2 = TiebaSyncService.this.mModel.byC().toString();
                } else {
                    str2 = "[]";
                }
                syncDataEvent.ubsABTest = str2;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.byA();
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
            String bwf = profileData.bwf();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.brx().putString("sync_send_maintab_my_tab_lottie_url", bwf);
            b.brx().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.brx().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        s byo = this.mModel.byo();
        if (byo != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bwa = byo.bwa();
            if (bwa > 0 && nextInt % bwa == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (byo.bwb() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(byo.bwb().bwl());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(byo.bwc());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        com.baidu.tieba.lc.c.cZc().to(false);
        VersionData byr = this.mModel.byr();
        if (byr != null && byr.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(byr);
            broadcastNewVersion();
            if (byr.forceUpdate()) {
                if (this.mModel.byo() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byr, this.mModel.byq())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && byr.getStrategy() == 0 && this.mModel.byo() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), byr, this.mModel.byq())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        aj byt = this.mModel.byt();
        if (byt != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(byt.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(byt.bwB());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(byt.bwD());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(byt.bwC());
            TbadkCoreApplication.getInst().setUseNewResign(byt.bwN());
            TbadkCoreApplication.getInst().setUegVoiceWarning(byt.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(byt.bwV());
            TbadkCoreApplication.getInst().setGameInfoData(byt.bwO(), byt.bwQ(), byt.bwP());
            ah.bsh().saveOrUpdateImages(byt.bww(), byt.bwx(), byt.bwy(), byt.bwz(), byt.bwA());
            String bwv = byt.bwv();
            b brx = b.brx();
            if (bwv == null) {
                bwv = "";
            }
            brx.putString("apply_vip_live_room_pid", bwv);
            b.brx().putString("tail_link", byt.bwE());
            b.brx().putString("bubble_link", byt.bwF());
            long bwG = byt.bwG();
            if (bwG >= 0 && bwG != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(byt.bwG());
            }
            long bwY = byt.bwY() * 1000;
            if (bwY > 0) {
                b.brx().putLong("KEY_UPLOAD_LOG_INTERVAL", bwY);
            } else {
                long bwW = byt.bwW() * 1000;
                if (bwW > 0) {
                    b.brx().putLong("KEY_UPLOAD_LOG_INTERVAL", bwW);
                }
            }
            XiaoyingUtil.setShowTime(byt.bwH());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(byt.bwI());
            b.brx().putLong("recommend_frs_cache_time", byt.bwL());
            b.brx().putInt("home_page_max_thread_count", byt.bwM());
            b.brx().putBoolean("localvideo_open", byt.bwS());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.brx().putInt("card_show_statistic_max_count", byt.fpG);
            b.brx().putString("nick_name_activity_link", byt.bwU());
            String string = b.brx().getString("clean_smart_frs_cookie", "");
            String bwR = byt.bwR();
            if (!TextUtils.equals(string, bwR)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.brx().putString("clean_smart_frs_cookie", bwR);
            b.brx().putInt("recommend_tab_show", byt.bwJ());
            b.brx().putInt("ribao_switch", byt.bwK());
            TbConfig.setMaxPhotoMemoryCache(byt.bwT());
            b.brx().putInt("key_card_show_type", byt.bwZ());
            TbadkCoreApplication.getInst().setCardShowType(byt.bwZ());
            b.brx().putInt("key_card_abstract_switch", byt.bxa());
            ab bxb = byt.bxb();
            if (bxb != null) {
                b.brx().putBoolean("nani_key_is_show_download_nani_panel", bxb.foP);
                b.brx().putBoolean("nani_key_is_activate_app", bxb.foQ);
                b.brx().putInt("nani_key_download_show_position", bxb.foR);
                b.brx().putInt("nani_key_download_show_rate", bxb.foS);
                b.brx().putString("nani_key_download_link_url", bxb.foT);
                b.brx().putString("nani_key_download_txt", bxb.foU);
                b.brx().putString("nani_key_show_tail_txt", bxb.foV);
                b.brx().putInt("nani_key_show_tail_video_type", bxb.foW);
                b.brx().putString("nani_key_show_tail_txt", bxb.foV);
                b.brx().putString("nani_key_pre_h5_link", bxb.foX);
            }
            if (byt.bxg() != null) {
                TbSingleton.getInstance().setShakeData(byt.bxg());
            }
            if (!TextUtils.isEmpty(byt.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(byt.getSharePanelText());
            }
            b.brx().putLong("key_frs_cache_time", byt.bxc() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(byt.bxd());
            TbSingleton.getInstance().setPushDialogShowTime(byt.bxe());
            TbSingleton.getInstance().setCanShowPermDlg(byt.bxf());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(byt.bxh());
            TbSingleton.getInstance().setProfileGameCenterKey(byt.bxi());
            TbSingleton.getInstance().setMissionEntranceUrl(byt.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(byt.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(byt.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(byt.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(byt.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(byt.bwu());
            TbSingleton.getInstance().setClipboardDelayTime(byt.bwX());
        }
    }
}
