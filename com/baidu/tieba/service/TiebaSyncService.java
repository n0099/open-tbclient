package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.ag;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private int mHaveRetry = 0;
    private com.baidu.tbadk.coreExtra.d.d mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new g(this);

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
        this.mSyncTask = new a(this, null);
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
            TbadkCoreApplication.m11getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab LL;

        private a() {
            this.LL = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.LL = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.LL.n("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m11getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.C(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("_phone_screen", stringBuffer.toString());
                this.LL.n("scr_w", String.valueOf(k.B(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("scr_h", String.valueOf(k.C(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("scr_dip", String.valueOf(k.D(TbadkCoreApplication.m11getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xG().xJ() > 0) {
                    this.LL.n("_msg_status", "0");
                } else {
                    this.LL.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m11getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.LL.n("_active", activeVersion);
                }
                this.LL.n("_pic_quality", String.valueOf(TbadkCoreApplication.m11getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.LL.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m11getInst().getPackageName();
                this.LL.n("package", packageName);
                this.LL.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m11getInst().getVersionCode())).toString());
                this.LL.n("signmd5", ba.a(TbadkCoreApplication.m11getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.LL.n("md5", ag.getTiebaApkMd5());
                String td = this.LL.td();
                if (this.LL.tE()) {
                    TbadkCoreApplication.m11getInst().clearActiveVersion();
                }
                if (this.LL.tB().uw().nZ()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(td);
                        if (TbadkCoreApplication.getClientId() == null && dVar.ym().getClientId() != null && dVar.ym().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.ym().getClientId());
                            TbadkCoreApplication.setClientId(dVar.ym().getClientId());
                        }
                        if (dVar.yi() != null) {
                            com.baidu.tbadk.core.sharedPref.b.sR().putInt("crash_limit_count", dVar.yi().getCrashLimitCount());
                        }
                        TiebaSyncService.mStatistics = null;
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
            if (this.LL != null) {
                this.LL.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.d.d dVar) {
            int performSampleCount;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.a.Fl().Fm();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.yl().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m11getInst().setVersionData(TiebaSyncService.this.mModel.yl());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yl().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.yi() != null && TbadkCoreApplication.m11getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m11getInst().getApp(), TiebaSyncService.this.mModel.yl(), TiebaSyncService.this.mModel.yk())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m11getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yl().getStrategy() == 0 && TiebaSyncService.this.mModel.yi() != null && TbadkCoreApplication.m11getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m11getInst().getApp(), TiebaSyncService.this.mModel.yl(), TiebaSyncService.this.mModel.yk())));
                            TbadkCoreApplication.m11getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m11getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wv = dVar.yi().wv();
                if (wv > 0 && nextInt % wv == 0 && (performSampleCount = TbadkCoreApplication.m11getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m11getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yj = TiebaSyncService.this.mModel.yj();
                if (!StringUtils.isNull(yj)) {
                    TbadkCoreApplication.m11getInst().setConfigVersion(yj);
                }
                p yn = TiebaSyncService.this.mModel.yn();
                if (yn != null) {
                    TbadkCoreApplication.m11getInst().getListItemRule().ea(yn.wO());
                    TbadkCoreApplication.m11getInst().getListItemRule().ec(yn.wQ());
                    TbadkCoreApplication.m11getInst().getListItemRule().eb(yn.wP());
                    TbadkCoreApplication.m11getInst().setUseNewResign(yn.wX());
                    TbadkCoreApplication.m11getInst().setGameInfoData(yn.wY(), yn.xa(), yn.wZ());
                    al.tO().b(yn.wJ(), yn.wK(), yn.wL(), yn.wM(), yn.wN());
                    String wI = yn.wI();
                    com.baidu.tbadk.core.sharedPref.b sR = com.baidu.tbadk.core.sharedPref.b.sR();
                    if (wI == null) {
                        wI = "";
                    }
                    sR.putString("apply_vip_live_room_pid", wI);
                    com.baidu.tbadk.core.sharedPref.b.sR().putString("tail_link", yn.wR());
                    com.baidu.tbadk.core.sharedPref.b.sR().putString("bubble_link", yn.wS());
                    XiaoyingUtil.setShowTime(yn.wT());
                    TbadkCoreApplication.m11getInst().setLastUpdateThemeTime(yn.wU());
                    com.baidu.tbadk.core.sharedPref.b.sR().putLong("recommend_frs_cache_time", yn.wV());
                    com.baidu.tbadk.core.sharedPref.b.sR().putInt("home_page_max_thread_count", yn.wW());
                    com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("localvideo_open", yn.xd());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m11getInst().setAdKillerData(yn.xb(), yn.getaDKillerUrl());
                    TbadkCoreApplication.m11getInst().setTTSSwitchOpen(yn.xc());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.yi() != null && TiebaSyncService.this.mModel.yi().ww() != null) {
                    TbadkCoreApplication.m11getInst().setCheckUrl(TiebaSyncService.this.mModel.yi().ww().wF());
                }
                if (TiebaSyncService.this.mModel.yi() != null) {
                    TbadkCoreApplication.m11getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.yi().wx());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
                return;
            }
            TiebaSyncService.this.mHaveRetry++;
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, TbConfig.USE_TIME_INTERVAL);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
