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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.messageCenter.b;
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
                stringBuffer.append(String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(l.ar(TbadkCoreApplication.getInst().getApp())));
                if (b.GJ().GM() > 0) {
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
                this.mNetWork.n("signmd5", ao.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n("md5", g.getTiebaApkMd5());
                String BP = this.mNetWork.BP();
                if (this.mNetWork.Cq()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.Cn().Dl().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(BP);
                        if (TbadkCoreApplication.getClientId() == null && dVar.Hq().getClientId() != null && dVar.Hq().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.Hq().getClientId());
                            TbadkCoreApplication.setClientId(dVar.Hq().getClientId());
                        }
                        if (dVar.Hm() != null) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("crash_limit_count", dVar.Hm().getCrashLimitCount());
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
                this.mNetWork.mR();
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
                com.baidu.tbadk.util.a.Ox().Oy();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.Hs());
                if (TiebaSyncService.this.mModel.Hp().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.Hp());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.Hp().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.Hm() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Hp(), TiebaSyncService.this.mModel.Ho())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.Hp().getStrategy() == 0 && TiebaSyncService.this.mModel.Hm() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Hp(), TiebaSyncService.this.mModel.Ho())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.Ht());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.Hu());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int Fx = dVar.Hm().Fx();
                if (Fx > 0 && nextInt % Fx == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String Hn = TiebaSyncService.this.mModel.Hn();
                if (!StringUtils.isNull(Hn)) {
                    TbadkCoreApplication.getInst().setConfigVersion(Hn);
                }
                t Hr = TiebaSyncService.this.mModel.Hr();
                if (Hr != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(Hr.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().eQ(Hr.FR());
                    TbadkCoreApplication.getInst().getListItemRule().eS(Hr.FT());
                    TbadkCoreApplication.getInst().getListItemRule().eR(Hr.FS());
                    TbadkCoreApplication.getInst().setUseNewResign(Hr.Gc());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(Hr.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(Hr.Gk());
                    TbadkCoreApplication.getInst().setGameInfoData(Hr.Gd(), Hr.Gf(), Hr.Ge());
                    af.CB().b(Hr.FM(), Hr.FN(), Hr.FO(), Hr.FP(), Hr.FQ());
                    String FL = Hr.FL();
                    com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
                    if (FL == null) {
                        FL = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", FL);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("tail_link", Hr.FU());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("bubble_link", Hr.FV());
                    long FW = Hr.FW();
                    if (FW >= 0 && FW != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(Hr.FW());
                    }
                    long Gl = Hr.Gl() * 1000;
                    if (Gl > 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", Gl);
                    }
                    XiaoyingUtil.setShowTime(Hr.FX());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(Hr.FY());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_cache_time", Hr.Ga());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_page_max_thread_count", Hr.Gb());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("localvideo_open", Hr.Gh());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("card_show_statistic_max_count", Hr.bgj);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("nick_name_activity_link", Hr.Gj());
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("clean_smart_frs_cookie", "");
                    String Gg = Hr.Gg();
                    if (!TextUtils.equals(string, Gg)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("clean_smart_frs_cookie", Gg);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("recommend_tab_show", Hr.FZ());
                    TbConfig.setMaxPhotoMemoryCache(Hr.Gi());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.Hm() != null && TiebaSyncService.this.mModel.Hm().Fy() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.Hm().Fy().FH());
                }
                if (TiebaSyncService.this.mModel.Hm() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.Hm().Fz());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
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
