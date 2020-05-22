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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.data.v;
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
        x bth;

        private a() {
            this.bth = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.bth.addPostData("_os_version", Build.VERSION.RELEASE);
                this.bth.addPostData(HttpConstants.HTTP_BOARD, Build.BOARD);
                this.bth.addPostData(Constants.PHONE_BRAND, Build.BRAND);
                this.bth.addPostData("incremental", Build.VERSION.INCREMENTAL);
                this.bth.addPostData("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(app)));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(app)));
                this.bth.addPostData("_phone_screen", stringBuffer.toString());
                this.bth.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(app)));
                this.bth.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(app)));
                this.bth.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(app)));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZV() > 0) {
                    this.bth.addPostData("_msg_status", "0");
                } else {
                    this.bth.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bth.addPostData("_active", activeVersion);
                }
                this.bth.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.bth.addPostData("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bth.addPostData("package", packageName);
                this.bth.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bth.addPostData("signmd5", as.creatSignInt(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bth.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.bth.postNetData();
                if (this.bth.isNetSuccess()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.bth.aUA().aVb().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.baw().getClientId() != null && dVar.baw().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.baw().getClientId());
                            TbadkCoreApplication.setClientId(dVar.baw().getClientId());
                        }
                        if (dVar.bas() != null) {
                            b.aTX().putInt("crash_limit_count", dVar.bas().getCrashLimitCount());
                        }
                        com.baidu.tbadk.coreExtra.data.d adAdSense = dVar.getAdAdSense();
                        if (dVar.getAdAdSense() != null && !TextUtils.isEmpty(adAdSense.getUrl())) {
                            b.aTX().putString("sync_ad_privacy_url", adAdSense.getUrl());
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
            if (this.bth != null) {
                this.bth.cancelNetConnect();
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
                com.baidu.tbadk.util.b.bgj().bgk();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.baz());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.baA());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.baB());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.baC());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bat = TiebaSyncService.this.mModel.bat();
                if (!StringUtils.isNull(bat)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bat);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.bay() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.bay());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.baD() != null) {
                    com.baidu.tbadk.util.a.bgh().a(TiebaSyncService.this.mModel.baD());
                }
                if (TiebaSyncService.this.mModel.baE() != null) {
                    com.baidu.tbadk.util.a.bgh().a(TiebaSyncService.this.mModel.baE());
                }
                com.baidu.tbadk.a.b.aMb().J(TiebaSyncService.this.mModel.baF());
                c.aMf().J(TiebaSyncService.this.mModel.baG());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bax() != null) {
                    str = TiebaSyncService.this.mModel.bax().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.baE();
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
        v profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String aYe = profileData.aYe();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aTX().putString("sync_send_maintab_my_tab_lottie_url", aYe);
            b.aTX().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aTX().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o bas = this.mModel.bas();
        if (bas != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aXZ = bas.aXZ();
            if (aXZ > 0 && nextInt % aXZ == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bas.aYa() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bas.aYa().aYk());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bas.aYb());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData bav = this.mModel.bav();
        if (bav != null && bav.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(bav);
            broadcastNewVersion();
            if (bav.forceUpdate()) {
                if (this.mModel.bas() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bav, this.mModel.bau())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && bav.getStrategy() == 0 && this.mModel.bas() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), bav, this.mModel.bau())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ac bax = this.mModel.bax();
        if (bax != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bax.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bax.aYA());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bax.aYC());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bax.aYB());
            TbadkCoreApplication.getInst().setUseNewResign(bax.aYO());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bax.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bax.aYW());
            TbadkCoreApplication.getInst().setGameInfoData(bax.aYP(), bax.aYR(), bax.aYQ());
            af.aUI().saveOrUpdateImages(bax.aYv(), bax.aYw(), bax.aYx(), bax.aYy(), bax.aYz());
            String aYu = bax.aYu();
            b aTX = b.aTX();
            if (aYu == null) {
                aYu = "";
            }
            aTX.putString("apply_vip_live_room_pid", aYu);
            b.aTX().putString("tail_link", bax.aYD());
            b.aTX().putString("bubble_link", bax.aYE());
            long aYF = bax.aYF();
            if (aYF >= 0 && aYF != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bax.aYF());
            }
            long aYZ = bax.aYZ() * 1000;
            if (aYZ > 0) {
                b.aTX().putLong("KEY_UPLOAD_LOG_INTERVAL", aYZ);
            } else {
                long aYX = bax.aYX() * 1000;
                if (aYX > 0) {
                    b.aTX().putLong("KEY_UPLOAD_LOG_INTERVAL", aYX);
                }
            }
            XiaoyingUtil.setShowTime(bax.aYG());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bax.aYH());
            b.aTX().putLong("recommend_frs_cache_time", bax.aYM());
            b.aTX().putInt("home_page_max_thread_count", bax.aYN());
            b.aTX().putBoolean("localvideo_open", bax.aYT());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aTX().putInt("card_show_statistic_max_count", bax.ece);
            b.aTX().putString("nick_name_activity_link", bax.aYV());
            String string = b.aTX().getString("clean_smart_frs_cookie", "");
            String aYS = bax.aYS();
            if (!TextUtils.equals(string, aYS)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aTX().putString("clean_smart_frs_cookie", aYS);
            b.aTX().putInt("recommend_tab_show", bax.aYI());
            b.aTX().putInt("ribao_switch", bax.aYJ());
            b.aTX().putInt("home_default_page", bax.aYK());
            b.aTX().putInt("home_remember_page", bax.aYL());
            TbConfig.setMaxPhotoMemoryCache(bax.aYU());
            b.aTX().putInt("key_card_show_type", bax.aZa());
            TbadkCoreApplication.getInst().setCardShowType(bax.aZa());
            b.aTX().putInt("key_card_abstract_switch", bax.aZb());
            u aZc = bax.aZc();
            if (aZc != null) {
                b.aTX().putBoolean("nani_key_is_show_download_nani_panel", aZc.ebo);
                b.aTX().putBoolean("nani_key_is_activate_app", aZc.ebp);
                b.aTX().putInt("nani_key_download_show_position", aZc.ebq);
                b.aTX().putInt("nani_key_download_show_rate", aZc.ebr);
                b.aTX().putString("nani_key_download_link_url", aZc.ebs);
                b.aTX().putString("nani_key_download_txt", aZc.ebt);
                b.aTX().putString("nani_key_show_tail_txt", aZc.ebu);
                b.aTX().putInt("nani_key_show_tail_video_type", aZc.ebv);
                b.aTX().putString("nani_key_show_tail_txt", aZc.ebu);
                b.aTX().putString("nani_key_pre_h5_link", aZc.ebw);
            }
            if (bax.aZh() != null) {
                TbSingleton.getInstance().setShakeData(bax.aZh());
            }
            if (!TextUtils.isEmpty(bax.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bax.getSharePanelText());
            }
            b.aTX().putLong("key_frs_cache_time", bax.aZd() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bax.aZe());
            TbSingleton.getInstance().setPushDialogShowTime(bax.aZf());
            TbSingleton.getInstance().setCanShowPermDlg(bax.aZg());
            TbSingleton.getInstance().setIsPbFold(bax.aZi());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bax.aZj());
            TbSingleton.getInstance().setProfileGameCenterKey(bax.aZk());
            TbSingleton.getInstance().setMissionEntranceUrl(bax.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bax.getMissionEntranceIcon());
            TbSingleton.getInstance().setWalletSignLink(bax.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bax.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bax.aYt());
            TbSingleton.getInstance().setClipboardDelayTime(bax.aYY());
        }
    }
}
