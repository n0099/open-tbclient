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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.messageCenter.b;
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
        /* renamed from: C */
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
                stringBuffer.append(String.valueOf(k.ae(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(k.af(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(k.ae(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(k.af(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(k.ag(TbadkCoreApplication.getInst().getApp())));
                if (b.zA().zD() > 0) {
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
                String uM = this.mNetWork.uM();
                if (this.mNetWork.vm()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.vj().wg().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(uM);
                        if (TbadkCoreApplication.getClientId() == null && dVar.Af().getClientId() != null && dVar.Af().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.Af().getClientId());
                            TbadkCoreApplication.setClientId(dVar.Af().getClientId());
                        }
                        if (dVar.Ab() != null) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("crash_limit_count", dVar.Ab().getCrashLimitCount());
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
                this.mNetWork.fp();
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
                com.baidu.tbadk.util.a.GU().GV();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.Ah());
                if (TiebaSyncService.this.mModel.Ae().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.Ae());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.Ae().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.Ab() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Ae(), TiebaSyncService.this.mModel.Ad())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.Ae().getStrategy() == 0 && TiebaSyncService.this.mModel.Ab() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Ae(), TiebaSyncService.this.mModel.Ad())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.Ai());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.Aj());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int yp = dVar.Ab().yp();
                if (yp > 0 && nextInt % yp == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String Ac = TiebaSyncService.this.mModel.Ac();
                if (!StringUtils.isNull(Ac)) {
                    TbadkCoreApplication.getInst().setConfigVersion(Ac);
                }
                r Ag = TiebaSyncService.this.mModel.Ag();
                if (Ag != null) {
                    TbadkCoreApplication.getInst().getListItemRule().eE(Ag.yJ());
                    TbadkCoreApplication.getInst().getListItemRule().eG(Ag.yL());
                    TbadkCoreApplication.getInst().getListItemRule().eF(Ag.yK());
                    TbadkCoreApplication.getInst().setUseNewResign(Ag.yT());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(Ag.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(Ag.zc());
                    TbadkCoreApplication.getInst().setGameInfoData(Ag.yU(), Ag.yW(), Ag.yV());
                    af.vx().b(Ag.yE(), Ag.yF(), Ag.yG(), Ag.yH(), Ag.yI());
                    String yD = Ag.yD();
                    com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
                    if (yD == null) {
                        yD = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", yD);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("tail_link", Ag.yM());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("bubble_link", Ag.yN());
                    XiaoyingUtil.setShowTime(Ag.yO());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(Ag.yP());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_cache_time", Ag.yR());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_page_max_thread_count", Ag.yS());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("localvideo_open", Ag.yZ());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.getInst().setTTSSwitchOpen(Ag.yX());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("card_show_statistic_max_count", Ag.asq);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("nick_name_activity_link", Ag.zb());
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("clean_smart_frs_cookie", "");
                    String yY = Ag.yY();
                    if (!TextUtils.equals(string, yY)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("clean_smart_frs_cookie", yY);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("recommend_tab_show", Ag.yQ());
                    TbConfig.setMaxPhotoMemoryCache(Ag.za());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.Ab() != null && TiebaSyncService.this.mModel.Ab().yq() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.Ab().yq().yz());
                }
                if (TiebaSyncService.this.mModel.Ab() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.Ab().yr());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                    return;
                }
                return;
            }
            TiebaSyncService.access$608(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, TbConfig.USE_TIME_INTERVAL);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
