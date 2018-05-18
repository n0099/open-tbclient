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
import com.baidu.tbadk.core.util.aq;
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
        /* renamed from: B */
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
                stringBuffer.append(String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(l.ai(TbadkCoreApplication.getInst().getApp())));
                if (c.Ad().Ag() > 0) {
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
                this.mNetWork.n("signmd5", aq.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n(com.baidu.ar.util.Constants.HTTP_AR_MD5, g.getTiebaApkMd5());
                String uK = this.mNetWork.uK();
                if (this.mNetWork.vl()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.vi().wi().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(uK);
                        if (TbadkCoreApplication.getClientId() == null && dVar.AI().getClientId() != null && dVar.AI().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.AI().getClientId());
                            TbadkCoreApplication.setClientId(dVar.AI().getClientId());
                        }
                        if (dVar.AE() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.AE().getCrashLimitCount());
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
                this.mNetWork.eW();
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
                com.baidu.tbadk.util.a.Ht().Hu();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.AK());
                if (TiebaSyncService.this.mModel.AH().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.AH());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.AH().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.AE() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.AH(), TiebaSyncService.this.mModel.AG())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.AH().getStrategy() == 0 && TiebaSyncService.this.mModel.AE() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.AH(), TiebaSyncService.this.mModel.AG())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.AL());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.AM());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int yy = dVar.AE().yy();
                if (yy > 0 && nextInt % yy == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String AF = TiebaSyncService.this.mModel.AF();
                if (!StringUtils.isNull(AF)) {
                    TbadkCoreApplication.getInst().setConfigVersion(AF);
                }
                v AJ = TiebaSyncService.this.mModel.AJ();
                if (AJ != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(AJ.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().fb(AJ.yY());
                    TbadkCoreApplication.getInst().getListItemRule().fd(AJ.za());
                    TbadkCoreApplication.getInst().getListItemRule().fc(AJ.yZ());
                    TbadkCoreApplication.getInst().setUseNewResign(AJ.zj());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(AJ.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(AJ.zr());
                    TbadkCoreApplication.getInst().setGameInfoData(AJ.zk(), AJ.zm(), AJ.zl());
                    af.vw().b(AJ.yT(), AJ.yU(), AJ.yV(), AJ.yW(), AJ.yX());
                    String yS = AJ.yS();
                    b bVar = b.getInstance();
                    if (yS == null) {
                        yS = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", yS);
                    b.getInstance().putString("tail_link", AJ.zb());
                    b.getInstance().putString("bubble_link", AJ.zc());
                    long zd = AJ.zd();
                    if (zd >= 0 && zd != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(AJ.zd());
                    }
                    long zs = AJ.zs() * 1000;
                    if (zs > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", zs);
                    }
                    XiaoyingUtil.setShowTime(AJ.ze());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(AJ.zf());
                    b.getInstance().putLong("recommend_frs_cache_time", AJ.zh());
                    b.getInstance().putInt("home_page_max_thread_count", AJ.zi());
                    b.getInstance().putBoolean("localvideo_open", AJ.zo());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", AJ.auc);
                    b.getInstance().putString("nick_name_activity_link", AJ.zq());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String zn = AJ.zn();
                    if (!TextUtils.equals(string, zn)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", zn);
                    b.getInstance().putInt("recommend_tab_show", AJ.zg());
                    TbConfig.setMaxPhotoMemoryCache(AJ.zp());
                    b.getInstance().putInt("key_card_show_type", AJ.zt());
                    TbadkCoreApplication.getInst().setCardShowType(AJ.zt());
                    b.getInstance().putInt("key_card_abstract_switch", AJ.zu());
                    com.baidu.tieba.a.d.MF().gs(b.getInstance().getInt("key_abtest_channel", 0));
                    q zv = AJ.zv();
                    if (zv != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", zv.atr);
                        b.getInstance().putBoolean("nani_key_is_activate_app", zv.ats);
                        b.getInstance().putInt("nani_key_download_show_position", zv.att);
                        b.getInstance().putInt("nani_key_download_show_rate", zv.atu);
                        b.getInstance().putString("nani_key_download_link_url", zv.atv);
                        b.getInstance().putString("nani_key_download_txt", zv.atw);
                        b.getInstance().putString("nani_key_show_tail_txt", zv.atx);
                        b.getInstance().putInt("nani_key_show_tail_video_type", zv.aty);
                        b.getInstance().putString("nani_key_show_tail_txt", zv.atx);
                        b.getInstance().putString("nani_key_pre_h5_link", zv.atz);
                    }
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.AE() != null && TiebaSyncService.this.mModel.AE().yz() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.AE().yz().yI());
                }
                if (TiebaSyncService.this.mModel.AE() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.AE().yA());
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
