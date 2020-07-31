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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.data.y;
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
        z byq;

        private a() {
            this.byq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.byq.addPostData("_os_version", Build.VERSION.RELEASE);
                this.byq.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.byq.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.byq.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.byq.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.byq.addPostData("_phone_screen", stringBuffer.toString());
                this.byq.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.byq.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.byq.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() > 0) {
                    this.byq.addPostData("_msg_status", "0");
                } else {
                    this.byq.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.byq.addPostData("_active", activeVersion);
                }
                this.byq.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.byq.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.byq.addPostData("package", packageName);
                this.byq.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.byq.addPostData("signmd5", au.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.byq.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.byq.postNetData();
                if (this.byq.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.byq.bav().baX().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.bgs().getClientId() != null && dVar.bgs().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.bgs().getClientId());
                            TbadkCoreApplication.setClientId(dVar.bgs().getClientId());
                        }
                        if (dVar.bgo() != null) {
                            b.aZP().putInt("crash_limit_count", dVar.bgo().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aZP().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.byq != null) {
                this.byq.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bml().bmm();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.bgv());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.bgw());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.bgx());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.bgy());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bgp = TiebaSyncService.this.mModel.bgp();
                if (!StringUtils.isNull(bgp)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bgp);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bgu() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bgu());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.bgz() != null) {
                    com.baidu.tbadk.util.a.bmh().a(TiebaSyncService.this.mModel.bgz());
                }
                if (TiebaSyncService.this.mModel.bgA() != null) {
                    com.baidu.tbadk.util.a.bmh().a(TiebaSyncService.this.mModel.bgA());
                }
                com.baidu.tbadk.a.b.aRs().K(TiebaSyncService.this.mModel.bgB());
                c.aRw().K(TiebaSyncService.this.mModel.bgC());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bgt() != null) {
                    str = TiebaSyncService.this.mModel.bgt().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.bgA();
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
        y profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String beh = profileData.beh();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aZP().putString("sync_send_maintab_my_tab_lottie_url", beh);
            b.aZP().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aZP().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o bgo = this.mModel.bgo();
        if (bgo != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int bec = bgo.bec();
            if (bec > 0 && nextInt % bec == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bgo.bed() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bgo.bed().ben());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bgo.bee());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bgr = this.mModel.bgr();
        if (bgr != null && bgr.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bgr);
            broadcastNewVersion();
            if (bgr.forceUpdate()) {
                if (this.mModel.bgo() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bgr, this.mModel.bgq())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bgr.getStrategy() == 0 && this.mModel.bgo() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bgr, this.mModel.bgq())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        af bgt = this.mModel.bgt();
        if (bgt != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bgt.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bgt.beD());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bgt.beF());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bgt.beE());
            TbadkCoreApplication.getInst().setUseNewResign(bgt.beP());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bgt.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bgt.beX());
            TbadkCoreApplication.getInst().setGameInfoData(bgt.beQ(), bgt.beS(), bgt.beR());
            ah.baD().saveOrUpdateImages(bgt.bey(), bgt.bez(), bgt.beA(), bgt.beB(), bgt.beC());
            String bex = bgt.bex();
            b aZP = b.aZP();
            if (bex == null) {
                bex = "";
            }
            aZP.putString("apply_vip_live_room_pid", bex);
            b.aZP().putString("tail_link", bgt.beG());
            b.aZP().putString("bubble_link", bgt.beH());
            long beI = bgt.beI();
            if (beI >= 0 && beI != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bgt.beI());
            }
            long bfa = bgt.bfa() * 1000;
            if (bfa > 0) {
                b.aZP().putLong("KEY_UPLOAD_LOG_INTERVAL", bfa);
            } else {
                long beY = bgt.beY() * 1000;
                if (beY > 0) {
                    b.aZP().putLong("KEY_UPLOAD_LOG_INTERVAL", beY);
                }
            }
            XiaoyingUtil.setShowTime(bgt.beJ());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bgt.beK());
            b.aZP().putLong("recommend_frs_cache_time", bgt.beN());
            b.aZP().putInt("home_page_max_thread_count", bgt.beO());
            b.aZP().putBoolean("localvideo_open", bgt.beU());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aZP().putInt("card_show_statistic_max_count", bgt.erd);
            b.aZP().putString("nick_name_activity_link", bgt.beW());
            String string = b.aZP().getString("clean_smart_frs_cookie", "");
            String beT = bgt.beT();
            if (!TextUtils.equals(string, beT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aZP().putString("clean_smart_frs_cookie", beT);
            b.aZP().putInt("recommend_tab_show", bgt.beL());
            b.aZP().putInt("ribao_switch", bgt.beM());
            TbConfig.setMaxPhotoMemoryCache(bgt.beV());
            b.aZP().putInt("key_card_show_type", bgt.bfb());
            TbadkCoreApplication.getInst().setCardShowType(bgt.bfb());
            b.aZP().putInt("key_card_abstract_switch", bgt.bfc());
            x bfd = bgt.bfd();
            if (bfd != null) {
                b.aZP().putBoolean("nani_key_is_show_download_nani_panel", bfd.eqn);
                b.aZP().putBoolean("nani_key_is_activate_app", bfd.eqo);
                b.aZP().putInt("nani_key_download_show_position", bfd.eqp);
                b.aZP().putInt("nani_key_download_show_rate", bfd.eqq);
                b.aZP().putString("nani_key_download_link_url", bfd.eqr);
                b.aZP().putString("nani_key_download_txt", bfd.eqs);
                b.aZP().putString("nani_key_show_tail_txt", bfd.eqt);
                b.aZP().putInt("nani_key_show_tail_video_type", bfd.equ);
                b.aZP().putString("nani_key_show_tail_txt", bfd.eqt);
                b.aZP().putString("nani_key_pre_h5_link", bfd.eqv);
            }
            if (bgt.bfi() != null) {
                TbSingleton.getInstance().setShakeData(bgt.bfi());
            }
            if (!TextUtils.isEmpty(bgt.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bgt.getSharePanelText());
            }
            b.aZP().putLong("key_frs_cache_time", bgt.bfe() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bgt.bff());
            TbSingleton.getInstance().setPushDialogShowTime(bgt.bfg());
            TbSingleton.getInstance().setCanShowPermDlg(bgt.bfh());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bgt.bfj());
            TbSingleton.getInstance().setProfileGameCenterKey(bgt.bfk());
            TbSingleton.getInstance().setMissionEntranceUrl(bgt.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bgt.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bgt.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bgt.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bgt.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bgt.bew());
            TbSingleton.getInstance().setClipboardDelayTime(bgt.beZ());
        }
    }
}
