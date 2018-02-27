package com.baidu.tieba.service;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.d;
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
        /* renamed from: z */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.n("board", Build.BOARD);
                this.mNetWork.n("brand", Build.BRAND);
                this.mNetWork.n("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(l.ar(TbadkCoreApplication.getInst().getApp())));
                if (c.Hp().Hs() > 0) {
                    this.mNetWork.n("_msg_status", "0");
                } else {
                    this.mNetWork.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.n("_active", activeVersion);
                }
                this.mNetWork.n("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.n("package", packageName);
                this.mNetWork.n("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.n("signmd5", ap.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n(com.baidu.ar.util.Constants.HTTP_AR_MD5, g.getTiebaApkMd5());
                String Ca = this.mNetWork.Ca();
                if (this.mNetWork.CB()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(Ca);
                        if (TbadkCoreApplication.getClientId() == null && dVar.HV().getClientId() != null && dVar.HV().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.HV().getClientId());
                            TbadkCoreApplication.setClientId(dVar.HV().getClientId());
                        }
                        if (dVar.HR() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.HR().getCrashLimitCount());
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
                this.mNetWork.mS();
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
                com.baidu.tbadk.util.a.OR().OS();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.HX());
                if (TiebaSyncService.this.mModel.HU().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.HU());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.HU().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.HR() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.HU(), TiebaSyncService.this.mModel.HT())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.HU().getStrategy() == 0 && TiebaSyncService.this.mModel.HR() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.HU(), TiebaSyncService.this.mModel.HT())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.HY());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.HZ());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int FL = dVar.HR().FL();
                if (FL > 0 && nextInt % FL == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String HS = TiebaSyncService.this.mModel.HS();
                if (!StringUtils.isNull(HS)) {
                    TbadkCoreApplication.getInst().setConfigVersion(HS);
                }
                v HW = TiebaSyncService.this.mModel.HW();
                if (HW != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(HW.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().fj(HW.Gl());
                    TbadkCoreApplication.getInst().getListItemRule().fl(HW.Gn());
                    TbadkCoreApplication.getInst().getListItemRule().fk(HW.Gm());
                    TbadkCoreApplication.getInst().setUseNewResign(HW.Gw());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(HW.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(HW.GE());
                    TbadkCoreApplication.getInst().setGameInfoData(HW.Gx(), HW.Gz(), HW.Gy());
                    af.CM().b(HW.Gg(), HW.Gh(), HW.Gi(), HW.Gj(), HW.Gk());
                    String Gf = HW.Gf();
                    b bVar = b.getInstance();
                    if (Gf == null) {
                        Gf = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", Gf);
                    b.getInstance().putString("tail_link", HW.Go());
                    b.getInstance().putString("bubble_link", HW.Gp());
                    long Gq = HW.Gq();
                    if (Gq >= 0 && Gq != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(HW.Gq());
                    }
                    long GF = HW.GF() * 1000;
                    if (GF > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", GF);
                    }
                    XiaoyingUtil.setShowTime(HW.Gr());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(HW.Gs());
                    b.getInstance().putLong("recommend_frs_cache_time", HW.Gu());
                    b.getInstance().putInt("home_page_max_thread_count", HW.Gv());
                    b.getInstance().putBoolean("localvideo_open", HW.GB());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", HW.biv);
                    b.getInstance().putString("nick_name_activity_link", HW.GD());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String GA = HW.GA();
                    if (!TextUtils.equals(string, GA)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", GA);
                    b.getInstance().putInt("recommend_tab_show", HW.Gt());
                    TbConfig.setMaxPhotoMemoryCache(HW.GC());
                    b.getInstance().putInt("key_card_show_type", HW.GG());
                    TbadkCoreApplication.getInst().setCardShowType(HW.GG());
                    q GH = HW.GH();
                    if (GH != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", GH.bhI);
                        b.getInstance().putBoolean("nani_key_is_activate_app", GH.bhJ);
                        b.getInstance().putInt("nani_key_download_show_position", GH.bhK);
                        b.getInstance().putInt("nani_key_download_show_rate", GH.bhL);
                        b.getInstance().putString("nani_key_download_link_url", GH.bhM);
                        b.getInstance().putString("nani_key_download_txt", GH.bhN);
                        b.getInstance().putString("nani_key_show_tail_txt", GH.bhO);
                        b.getInstance().putInt("nani_key_show_tail_video_type", GH.bhP);
                        b.getInstance().putString("nani_key_show_tail_txt", GH.bhO);
                        b.getInstance().putString("nani_key_pre_h5_link", GH.bhQ);
                    }
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.HR() != null && TiebaSyncService.this.mModel.HR().FM() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.HR().FM().FV());
                }
                if (TiebaSyncService.this.mModel.HR() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.HR().FN());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                    return;
                }
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
