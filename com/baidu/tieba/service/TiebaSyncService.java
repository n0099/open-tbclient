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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.f;
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
        x blK;

        private a() {
            this.blK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.blK.addPostData("_os_version", Build.VERSION.RELEASE);
                this.blK.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.blK.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.blK.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.blK.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.blK.addPostData("_phone_screen", stringBuffer.toString());
                this.blK.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.blK.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.blK.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTO() > 0) {
                    this.blK.addPostData("_msg_status", "0");
                } else {
                    this.blK.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.blK.addPostData("_active", activeVersion);
                }
                this.blK.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.blK.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.blK.addPostData("package", packageName);
                this.blK.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.blK.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.blK.addPostData("md5", f.getTiebaApkMd5());
                String postNetData = this.blK.postNetData();
                if (this.blK.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.blK.aOw().aOX().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.aUp().getClientId() != null && dVar.aUp().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.aUp().getClientId());
                            TbadkCoreApplication.setClientId(dVar.aUp().getClientId());
                        }
                        if (dVar.aUl() != null) {
                            b.aNT().putInt("crash_limit_count", dVar.aUl().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aNT().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.blK != null) {
                this.blK.cancelNetConnect();
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
                com.baidu.tbadk.util.b.aZZ().baa();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.aUr());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.aUs());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.aUt());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String aUm = TiebaSyncService.this.mModel.aUm();
                if (!StringUtils.isNull(aUm)) {
                    TbadkCoreApplication.getInst().setConfigVersion(aUm);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.aUu() != null) {
                    com.baidu.tbadk.util.a.aZX().a(TiebaSyncService.this.mModel.aUu());
                }
                if (TiebaSyncService.this.mModel.aUv() != null) {
                    com.baidu.tbadk.util.a.aZX().a(TiebaSyncService.this.mModel.aUv());
                }
                if (TiebaSyncService.this.mModel.aUw() != null) {
                    com.baidu.tbadk.a.b.aGG().K(TiebaSyncService.this.mModel.aUw());
                }
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.aUq() != null) {
                    str = TiebaSyncService.this.mModel.aUq().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.aUv();
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
        v profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String aRX = profileData.aRX();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aNT().putString("sync_send_maintab_my_tab_lottie_url", aRX);
            b.aNT().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aNT().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o aUl = this.mModel.aUl();
        if (aUl != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aRS = aUl.aRS();
            if (aRS > 0 && nextInt % aRS == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (aUl.aRT() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(aUl.aRT().aSd());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(aUl.aRU());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData aUo = this.mModel.aUo();
        if (aUo != null && aUo.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(aUo);
            broadcastNewVersion();
            if (aUo.forceUpdate()) {
                if (this.mModel.aUl() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aUo, this.mModel.aUn())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && aUo.getStrategy() == 0 && this.mModel.aUl() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), aUo, this.mModel.aUn())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac aUq = this.mModel.aUq();
        if (aUq != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(aUq.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(aUq.aSt());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(aUq.aSv());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(aUq.aSu());
            TbadkCoreApplication.getInst().setUseNewResign(aUq.aSH());
            TbadkCoreApplication.getInst().setUegVoiceWarning(aUq.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(aUq.aSP());
            TbadkCoreApplication.getInst().setGameInfoData(aUq.aSI(), aUq.aSK(), aUq.aSJ());
            af.aOE().saveOrUpdateImages(aUq.aSo(), aUq.aSp(), aUq.aSq(), aUq.aSr(), aUq.aSs());
            String aSn = aUq.aSn();
            b aNT = b.aNT();
            if (aSn == null) {
                aSn = "";
            }
            aNT.putString("apply_vip_live_room_pid", aSn);
            b.aNT().putString("tail_link", aUq.aSw());
            b.aNT().putString("bubble_link", aUq.aSx());
            long aSy = aUq.aSy();
            if (aSy >= 0 && aSy != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(aUq.aSy());
            }
            long aSS = aUq.aSS() * 1000;
            if (aSS > 0) {
                b.aNT().putLong("KEY_UPLOAD_LOG_INTERVAL", aSS);
            } else {
                long aSQ = aUq.aSQ() * 1000;
                if (aSQ > 0) {
                    b.aNT().putLong("KEY_UPLOAD_LOG_INTERVAL", aSQ);
                }
            }
            XiaoyingUtil.setShowTime(aUq.aSz());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(aUq.aSA());
            b.aNT().putLong("recommend_frs_cache_time", aUq.aSF());
            b.aNT().putInt("home_page_max_thread_count", aUq.aSG());
            b.aNT().putBoolean("localvideo_open", aUq.aSM());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aNT().putInt("card_show_statistic_max_count", aUq.dNN);
            b.aNT().putString("nick_name_activity_link", aUq.aSO());
            String string = b.aNT().getString("clean_smart_frs_cookie", "");
            String aSL = aUq.aSL();
            if (!TextUtils.equals(string, aSL)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aNT().putString("clean_smart_frs_cookie", aSL);
            b.aNT().putInt("recommend_tab_show", aUq.aSB());
            b.aNT().putInt("ribao_switch", aUq.aSC());
            b.aNT().putInt("home_default_page", aUq.aSD());
            b.aNT().putInt("home_remember_page", aUq.aSE());
            TbConfig.setMaxPhotoMemoryCache(aUq.aSN());
            b.aNT().putInt("key_card_show_type", aUq.aST());
            TbadkCoreApplication.getInst().setCardShowType(aUq.aST());
            b.aNT().putInt("key_card_abstract_switch", aUq.aSU());
            u aSV = aUq.aSV();
            if (aSV != null) {
                b.aNT().putBoolean("nani_key_is_show_download_nani_panel", aSV.dMX);
                b.aNT().putBoolean("nani_key_is_activate_app", aSV.dMY);
                b.aNT().putInt("nani_key_download_show_position", aSV.dMZ);
                b.aNT().putInt("nani_key_download_show_rate", aSV.dNa);
                b.aNT().putString("nani_key_download_link_url", aSV.dNb);
                b.aNT().putString("nani_key_download_txt", aSV.dNc);
                b.aNT().putString("nani_key_show_tail_txt", aSV.dNd);
                b.aNT().putInt("nani_key_show_tail_video_type", aSV.dNe);
                b.aNT().putString("nani_key_show_tail_txt", aSV.dNd);
                b.aNT().putString("nani_key_pre_h5_link", aSV.dNf);
            }
            if (aUq.aTa() != null) {
                TbSingleton.getInstance().setShakeData(aUq.aTa());
            }
            if (!TextUtils.isEmpty(aUq.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(aUq.getSharePanelText());
            }
            b.aNT().putLong("key_frs_cache_time", aUq.aSW() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(aUq.aSX());
            TbSingleton.getInstance().setPushDialogShowTime(aUq.aSY());
            TbSingleton.getInstance().setCanShowPermDlg(aUq.aSZ());
            TbSingleton.getInstance().setIsPbFold(aUq.aTb());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(aUq.aTc());
            TbSingleton.getInstance().setProfileGameCenterKey(aUq.aTd());
            TbSingleton.getInstance().setMissionEntranceUrl(aUq.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(aUq.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(aUq.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(aUq.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(aUq.aSm());
            TbSingleton.getInstance().setClipboardDelayTime(aUq.aSR());
        }
    }
}
