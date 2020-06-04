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
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.data.w;
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
                if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZW() > 0) {
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
                if (this.bth.aUA().aVc().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        if (TbadkCoreApplication.getClientId() == null && dVar.bax().getClientId() != null && dVar.bax().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.bax().getClientId());
                            TbadkCoreApplication.setClientId(dVar.bax().getClientId());
                        }
                        if (dVar.bat() != null) {
                            b.aTX().putInt("crash_limit_count", dVar.bat().getCrashLimitCount());
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
                com.baidu.tbadk.util.b.bgk().bgl();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.b.a(TiebaSyncService.this.mModel.baA());
                TiebaSyncService.this.onPostExecuteUpdateData();
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.baB());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.baC());
                TbadkCoreApplication.getInst().setIsNeedNewUserLead(TiebaSyncService.this.mModel.baD());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                String bau = TiebaSyncService.this.mModel.bau();
                if (!StringUtils.isNull(bau)) {
                    TbadkCoreApplication.getInst().setConfigVersion(bau);
                }
                TiebaSyncService.this.onPostExecuteConfigData();
                TiebaSyncService.this.onPostExecuteWlConfigData();
                TiebaSyncService.this.onPostExecuteProfilData();
                if (TiebaSyncService.this.mModel.baz() != null) {
                    TbSingleton.getInstance().setNewGodData(TiebaSyncService.this.mModel.baz());
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.baE() != null) {
                    com.baidu.tbadk.util.a.bgi().a(TiebaSyncService.this.mModel.baE());
                }
                if (TiebaSyncService.this.mModel.baF() != null) {
                    com.baidu.tbadk.util.a.bgi().a(TiebaSyncService.this.mModel.baF());
                }
                com.baidu.tbadk.a.b.aMb().J(TiebaSyncService.this.mModel.baG());
                c.aMf().J(TiebaSyncService.this.mModel.baH());
                TbadkCoreApplication.getInst().setLastSyncFinishTime(System.currentTimeMillis());
                SyncDataEvent syncDataEvent = new SyncDataEvent();
                if (TiebaSyncService.this.mModel.bay() != null) {
                    str = TiebaSyncService.this.mModel.bay().getSampleId();
                } else {
                    str = "";
                }
                syncDataEvent.sampleId = str;
                syncDataEvent.abtestExtraData = TiebaSyncService.this.mModel.baF();
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
        w profileData = this.mModel.getProfileData();
        if (profileData != null) {
            TbadkCoreApplication.getInst().setProfileData(profileData);
            String aYf = profileData.aYf();
            long startTime = profileData.getStartTime();
            long endTime = profileData.getEndTime();
            b.aTX().putString("sync_send_maintab_my_tab_lottie_url", aYf);
            b.aTX().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
            b.aTX().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteConfigData() {
        int performSampleCount;
        o bat = this.mModel.bat();
        if (bat != null) {
            int nextInt = new Random().nextInt(10000) + 1;
            int aYa = bat.aYa();
            if (aYa > 0 && nextInt % aYa == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (bat.aYb() != null) {
                TbadkCoreApplication.getInst().setCheckUrl(bat.aYb().aYl());
            }
            TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(bat.aYc());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteUpdateData() {
        VersionData baw = this.mModel.baw();
        if (baw != null && baw.hasNewVer() && TbConfig.COULD_UPDATE) {
            TbadkCoreApplication.getInst().setVersionData(baw);
            broadcastNewVersion();
            if (baw.forceUpdate()) {
                if (this.mModel.bat() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), baw, this.mModel.bav())));
                    return;
                }
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000 && baw.getStrategy() == 0 && this.mModel.bat() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), baw, this.mModel.bav())));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecuteWlConfigData() {
        ad bay = this.mModel.bay();
        if (bay != null) {
            TbadkCoreApplication.getInst().setActivityPrizeData(bay.getActivityPrizeData());
            TbadkCoreApplication.getInst().getListItemRule().setMaxCache(bay.aYB());
            TbadkCoreApplication.getInst().getListItemRule().setFrsPn(bay.aYD());
            TbadkCoreApplication.getInst().getListItemRule().setFrsMaxCache(bay.aYC());
            TbadkCoreApplication.getInst().setUseNewResign(bay.aYP());
            TbadkCoreApplication.getInst().setUegVoiceWarning(bay.getUegVoiceWarning());
            TbadkCoreApplication.getInst().setUrlText(bay.aYX());
            TbadkCoreApplication.getInst().setGameInfoData(bay.aYQ(), bay.aYS(), bay.aYR());
            af.aUI().saveOrUpdateImages(bay.aYw(), bay.aYx(), bay.aYy(), bay.aYz(), bay.aYA());
            String aYv = bay.aYv();
            b aTX = b.aTX();
            if (aYv == null) {
                aYv = "";
            }
            aTX.putString("apply_vip_live_room_pid", aYv);
            b.aTX().putString("tail_link", bay.aYE());
            b.aTX().putString("bubble_link", bay.aYF());
            long aYG = bay.aYG();
            if (aYG >= 0 && aYG != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                TbadkCoreApplication.getInst().setUseTimeInterval(bay.aYG());
            }
            long aZa = bay.aZa() * 1000;
            if (aZa > 0) {
                b.aTX().putLong("KEY_UPLOAD_LOG_INTERVAL", aZa);
            } else {
                long aYY = bay.aYY() * 1000;
                if (aYY > 0) {
                    b.aTX().putLong("KEY_UPLOAD_LOG_INTERVAL", aYY);
                }
            }
            XiaoyingUtil.setShowTime(bay.aYH());
            TbadkCoreApplication.getInst().setLastUpdateThemeTime(bay.aYI());
            b.aTX().putLong("recommend_frs_cache_time", bay.aYN());
            b.aTX().putInt("home_page_max_thread_count", bay.aYO());
            b.aTX().putBoolean("localvideo_open", bay.aYU());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
            b.aTX().putInt("card_show_statistic_max_count", bay.ece);
            b.aTX().putString("nick_name_activity_link", bay.aYW());
            String string = b.aTX().getString("clean_smart_frs_cookie", "");
            String aYT = bay.aYT();
            if (!TextUtils.equals(string, aYT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
            }
            b.aTX().putString("clean_smart_frs_cookie", aYT);
            b.aTX().putInt("recommend_tab_show", bay.aYJ());
            b.aTX().putInt("ribao_switch", bay.aYK());
            b.aTX().putInt("home_default_page", bay.aYL());
            b.aTX().putInt("home_remember_page", bay.aYM());
            TbConfig.setMaxPhotoMemoryCache(bay.aYV());
            b.aTX().putInt("key_card_show_type", bay.aZb());
            TbadkCoreApplication.getInst().setCardShowType(bay.aZb());
            b.aTX().putInt("key_card_abstract_switch", bay.aZc());
            v aZd = bay.aZd();
            if (aZd != null) {
                b.aTX().putBoolean("nani_key_is_show_download_nani_panel", aZd.ebo);
                b.aTX().putBoolean("nani_key_is_activate_app", aZd.ebp);
                b.aTX().putInt("nani_key_download_show_position", aZd.ebq);
                b.aTX().putInt("nani_key_download_show_rate", aZd.ebr);
                b.aTX().putString("nani_key_download_link_url", aZd.ebs);
                b.aTX().putString("nani_key_download_txt", aZd.ebt);
                b.aTX().putString("nani_key_show_tail_txt", aZd.ebu);
                b.aTX().putInt("nani_key_show_tail_video_type", aZd.ebv);
                b.aTX().putString("nani_key_show_tail_txt", aZd.ebu);
                b.aTX().putString("nani_key_pre_h5_link", aZd.ebw);
            }
            if (bay.aZi() != null) {
                TbSingleton.getInstance().setShakeData(bay.aZi());
            }
            if (!TextUtils.isEmpty(bay.getSharePanelText())) {
                TbSingleton.getInstance().setSharePanelText(bay.getSharePanelText());
            }
            b.aTX().putLong("key_frs_cache_time", bay.aZe() * 1000);
            TbSingleton.getInstance().setPushDialogLoopTime(bay.aZf());
            TbSingleton.getInstance().setPushDialogShowTime(bay.aZg());
            TbSingleton.getInstance().setCanShowPermDlg(bay.aZh());
            TbSingleton.getInstance().setIsPbFold(bay.aZj());
            TbSingleton.getInstance().setShowPersonCenterLiteGame(bay.aZk());
            TbSingleton.getInstance().setProfileGameCenterKey(bay.aZl());
            TbSingleton.getInstance().setMissionEntranceUrl(bay.getMissionEntranceUrl());
            TbSingleton.getInstance().setMissionEntranceIcon(bay.getMissionEntranceIcon());
            TbSingleton.getInstance().setMissionEntranceObjSource(bay.getMissionEntranceObjSource());
            TbSingleton.getInstance().setWalletSignLink(bay.getWalletSignLink());
            TbSingleton.getInstance().setSampleId(bay.getSampleId());
            TbSingleton.getInstance().setLiveForumMap(bay.aYu());
            TbSingleton.getInstance().setClipboardDelayTime(bay.aYZ());
        }
    }
}
