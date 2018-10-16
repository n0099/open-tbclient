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
        /* renamed from: D */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.x("board", Build.BOARD);
                this.mNetWork.x("brand", Build.BRAND);
                this.mNetWork.x("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.x("model", Build.MODEL);
                Application app = TbadkCoreApplication.getInst().getApp();
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.aO(app)));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aQ(app)));
                this.mNetWork.x("_phone_screen", stringBuffer.toString());
                this.mNetWork.x("scr_w", String.valueOf(l.aO(app)));
                this.mNetWork.x("scr_h", String.valueOf(l.aQ(app)));
                this.mNetWork.x("scr_dip", String.valueOf(l.aR(app)));
                if (c.Hg().Hj() > 0) {
                    this.mNetWork.x("_msg_status", "0");
                } else {
                    this.mNetWork.x("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.x("_active", activeVersion);
                }
                this.mNetWork.x("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.x("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.x("package", packageName);
                this.mNetWork.x("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.x("signmd5", ar.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.x(ARResourceKey.HTTP_AR_MD5, h.getTiebaApkMd5());
                String BA = this.mNetWork.BA();
                if (this.mNetWork.Cb()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.BY().CX().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(BA);
                        if (TbadkCoreApplication.getClientId() == null && dVar.HN().getClientId() != null && dVar.HN().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.HN().getClientId());
                            TbadkCoreApplication.setClientId(dVar.HN().getClientId());
                        }
                        if (dVar.HJ() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.HJ().getCrashLimitCount());
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
                this.mNetWork.ji();
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
                com.baidu.tbadk.util.b.Ot().Ou();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.HP());
                if (TiebaSyncService.this.mModel.HM().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.HM());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.HM().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.HJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.HM(), TiebaSyncService.this.mModel.HL())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.HM().getStrategy() == 0 && TiebaSyncService.this.mModel.HJ() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.HM(), TiebaSyncService.this.mModel.HL())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.HQ());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.HR());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int Ft = dVar.HJ().Ft();
                if (Ft > 0 && nextInt % Ft == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String HK = TiebaSyncService.this.mModel.HK();
                if (!StringUtils.isNull(HK)) {
                    TbadkCoreApplication.getInst().setConfigVersion(HK);
                }
                com.baidu.tbadk.coreExtra.data.x HO = TiebaSyncService.this.mModel.HO();
                if (HO != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(HO.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().gk(HO.FU());
                    TbadkCoreApplication.getInst().getListItemRule().gm(HO.FW());
                    TbadkCoreApplication.getInst().getListItemRule().gl(HO.FV());
                    TbadkCoreApplication.getInst().setUseNewResign(HO.Gi());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(HO.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(HO.Gq());
                    TbadkCoreApplication.getInst().setGameInfoData(HO.Gj(), HO.Gl(), HO.Gk());
                    af.Cm().b(HO.FP(), HO.FQ(), HO.FR(), HO.FS(), HO.FT());
                    String FO = HO.FO();
                    b bVar = b.getInstance();
                    if (FO == null) {
                        FO = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", FO);
                    b.getInstance().putString("tail_link", HO.FX());
                    b.getInstance().putString("bubble_link", HO.FY());
                    long FZ = HO.FZ();
                    if (FZ >= 0 && FZ != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(HO.FZ());
                    }
                    long Gr = HO.Gr() * 1000;
                    if (Gr > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", Gr);
                    }
                    XiaoyingUtil.setShowTime(HO.Ga());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(HO.Gb());
                    b.getInstance().putLong("recommend_frs_cache_time", HO.Gg());
                    b.getInstance().putInt("home_page_max_thread_count", HO.Gh());
                    b.getInstance().putBoolean("localvideo_open", HO.Gn());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", HO.aKE);
                    b.getInstance().putString("nick_name_activity_link", HO.Gp());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String Gm = HO.Gm();
                    if (!TextUtils.equals(string, Gm)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", Gm);
                    b.getInstance().putInt("recommend_tab_show", HO.Gc());
                    b.getInstance().putInt("ribao_switch", HO.Gd());
                    b.getInstance().putInt("home_default_page", HO.Ge());
                    b.getInstance().putInt("home_remember_page", HO.Gf());
                    TbConfig.setMaxPhotoMemoryCache(HO.Go());
                    b.getInstance().putInt("key_card_show_type", HO.Gs());
                    TbadkCoreApplication.getInst().setCardShowType(HO.Gs());
                    b.getInstance().putInt("key_card_abstract_switch", HO.Gt());
                    r Gu = HO.Gu();
                    if (Gu != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", Gu.aJT);
                        b.getInstance().putBoolean("nani_key_is_activate_app", Gu.aJU);
                        b.getInstance().putInt("nani_key_download_show_position", Gu.aJV);
                        b.getInstance().putInt("nani_key_download_show_rate", Gu.aJW);
                        b.getInstance().putString("nani_key_download_link_url", Gu.aJX);
                        b.getInstance().putString("nani_key_download_txt", Gu.aJY);
                        b.getInstance().putString("nani_key_show_tail_txt", Gu.aJZ);
                        b.getInstance().putInt("nani_key_show_tail_video_type", Gu.aKa);
                        b.getInstance().putString("nani_key_show_tail_txt", Gu.aJZ);
                        b.getInstance().putString("nani_key_pre_h5_link", Gu.aKb);
                    }
                    b.getInstance().putLong("key_frs_cache_time", HO.Gv() * 1000);
                    TbSingleton.getInstance().setPushDialogLoopTime(HO.Gw());
                    TbSingleton.getInstance().setPushDialogShowTime(HO.Gx());
                    TbSingleton.getInstance().setCanShowPermDlg(HO.Gy());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.HJ() != null && TiebaSyncService.this.mModel.HJ().Fu() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.HJ().Fu().FE());
                }
                if (TiebaSyncService.this.mModel.HJ() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.HJ().Fv());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                if (TiebaSyncService.this.mModel.getProfileData() != null) {
                    TbadkCoreApplication.getInst().setProfileData(TiebaSyncService.this.mModel.getProfileData());
                    String FB = TiebaSyncService.this.mModel.getProfileData().FB();
                    long startTime = TiebaSyncService.this.mModel.getProfileData().getStartTime();
                    long endTime = TiebaSyncService.this.mModel.getProfileData().getEndTime();
                    b.getInstance().putString("sync_send_maintab_my_tab_lottie_url", FB);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_start_time", startTime);
                    b.getInstance().putLong("sync_send_maintab_my_tab_lottie_end_time", endTime);
                }
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                }
                if (TiebaSyncService.this.mModel.HS() != null) {
                    com.baidu.tbadk.util.a.Os().a(TiebaSyncService.this.mModel.HS());
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
