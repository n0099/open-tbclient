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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.h;
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

    static /* synthetic */ int access$608(TiebaSyncService tiebaSyncService) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastNewVersion() {
        if (this.mModel != null) {
            TbadkCoreApplication.getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, d> {
        x mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.u("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.u("board", Build.BOARD);
                this.mNetWork.u("brand", Build.BRAND);
                this.mNetWork.u("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.u("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.aO(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aQ(app)));
                this.mNetWork.u("_phone_screen", stringBuffer.toString());
                this.mNetWork.u("scr_w", String.valueOf(l.aO(app)));
                this.mNetWork.u("scr_h", String.valueOf(l.aQ(app)));
                this.mNetWork.u("scr_dip", String.valueOf(l.aR(app)));
                if (c.Ff().Fi() > 0) {
                    this.mNetWork.u("_msg_status", "0");
                } else {
                    this.mNetWork.u("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.u("_active", activeVersion);
                }
                this.mNetWork.u("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.u("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.u("package", packageName);
                this.mNetWork.u("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.u("signmd5", ar.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.u(ARResourceKey.HTTP_AR_MD5, h.getTiebaApkMd5());
                String zt = this.mNetWork.zt();
                if (this.mNetWork.zU()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(zt);
                        if (TbadkCoreApplication.getClientId() == null && dVar.FM().getClientId() != null && dVar.FM().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.FM().getClientId());
                            TbadkCoreApplication.setClientId(dVar.FM().getClientId());
                        }
                        if (dVar.FI() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.FI().getCrashLimitCount());
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
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            int performSampleCount;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.b.Mv().Mw();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.FO());
                if (TiebaSyncService.this.mModel.FL().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.FL());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.FL().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.FI() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.FL(), TiebaSyncService.this.mModel.FK())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.FL().getStrategy() == 0 && TiebaSyncService.this.mModel.FI() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.FL(), TiebaSyncService.this.mModel.FK())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.FP());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.FQ());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int Ds = dVar.FI().Ds();
                if (Ds > 0 && nextInt % Ds == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String FJ = TiebaSyncService.this.mModel.FJ();
                if (!StringUtils.isNull(FJ)) {
                    TbadkCoreApplication.getInst().setConfigVersion(FJ);
                }
                com.baidu.tbadk.coreExtra.data.x FN = TiebaSyncService.this.mModel.FN();
                if (FN != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(FN.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().fW(FN.DT());
                    TbadkCoreApplication.getInst().getListItemRule().fY(FN.DV());
                    TbadkCoreApplication.getInst().getListItemRule().fX(FN.DU());
                    TbadkCoreApplication.getInst().setUseNewResign(FN.Eh());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(FN.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(FN.Ep());
                    TbadkCoreApplication.getInst().setGameInfoData(FN.Ei(), FN.Ek(), FN.Ej());
                    af.Af().b(FN.DO(), FN.DP(), FN.DQ(), FN.DR(), FN.DS());
                    String DN = FN.DN();
                    b bVar = b.getInstance();
                    if (DN == null) {
                        DN = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", DN);
                    b.getInstance().putString("tail_link", FN.DW());
                    b.getInstance().putString("bubble_link", FN.DX());
                    long DY = FN.DY();
                    if (DY >= 0 && DY != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(FN.DY());
                    }
                    long Eq = FN.Eq() * 1000;
                    if (Eq > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", Eq);
                    }
                    XiaoyingUtil.setShowTime(FN.DZ());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(FN.Ea());
                    b.getInstance().putLong("recommend_frs_cache_time", FN.Ef());
                    b.getInstance().putInt("home_page_max_thread_count", FN.Eg());
                    b.getInstance().putBoolean("localvideo_open", FN.Em());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", FN.aGb);
                    b.getInstance().putString("nick_name_activity_link", FN.Eo());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String El = FN.El();
                    if (!TextUtils.equals(string, El)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", El);
                    b.getInstance().putInt("recommend_tab_show", FN.Eb());
                    b.getInstance().putInt("ribao_switch", FN.Ec());
                    b.getInstance().putInt("home_default_page", FN.Ed());
                    b.getInstance().putInt("home_remember_page", FN.Ee());
                    TbConfig.setMaxPhotoMemoryCache(FN.En());
                    b.getInstance().putInt("key_card_show_type", FN.Er());
                    TbadkCoreApplication.getInst().setCardShowType(FN.Er());
                    b.getInstance().putInt("key_card_abstract_switch", FN.Es());
                    r Et = FN.Et();
                    if (Et != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", Et.aFq);
                        b.getInstance().putBoolean("nani_key_is_activate_app", Et.aFr);
                        b.getInstance().putInt("nani_key_download_show_position", Et.aFs);
                        b.getInstance().putInt("nani_key_download_show_rate", Et.aFt);
                        b.getInstance().putString("nani_key_download_link_url", Et.aFu);
                        b.getInstance().putString("nani_key_download_txt", Et.aFv);
                        b.getInstance().putString("nani_key_show_tail_txt", Et.aFw);
                        b.getInstance().putInt("nani_key_show_tail_video_type", Et.aFx);
                        b.getInstance().putString("nani_key_show_tail_txt", Et.aFw);
                        b.getInstance().putString("nani_key_pre_h5_link", Et.aFy);
                    }
                    b.getInstance().putLong("key_frs_cache_time", FN.Eu() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(FN.Ev());
                    TbSingleton.getInstance().setPushDialogShowTime(FN.Ew());
                    TbSingleton.getInstance().setCanShowPermDlg(FN.Ex());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.FI() != null && TiebaSyncService.this.mModel.FI().Dt() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.FI().Dt().DD());
                }
                if (TiebaSyncService.this.mModel.FI() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.FI().Du());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String DA = TiebaSyncService.this.mModel.getProfileData().DA();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.getInstance().putString("sync_send_maintab_my_tab_lottie_url", DA);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.FR() != null) {
                    com.baidu.tbadk.util.a.Mu().a(TiebaSyncService.this.mModel.FR());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                return;
            }
            TiebaSyncService.access$608(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
