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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.z;
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
            TbadkCoreApplication.m411getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab Ua;

        private a() {
            this.Ua = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ua.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ua.o("_phone_screen", stringBuffer.toString());
                this.Ua.o("scr_w", String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                this.Ua.o("scr_h", String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ua.o("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV() > 0) {
                    this.Ua.o("_msg_status", "0");
                } else {
                    this.Ua.o("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Ua.o("_active", activeVersion);
                }
                this.Ua.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.Ua.o("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Ua.o("package", packageName);
                this.Ua.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Ua.o("signmd5", az.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ua.o("md5", z.getTiebaApkMd5());
                String tV = this.Ua.tV();
                if (this.Ua.uz()) {
                    TbadkCoreApplication.m411getInst().clearActiveVersion();
                }
                if (this.Ua.uw().vq().qO()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(tV);
                        if (TbadkCoreApplication.getClientId() == null && dVar.yx().getClientId() != null && dVar.yx().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.yx().getClientId());
                            TbadkCoreApplication.setClientId(dVar.yx().getClientId());
                        }
                        if (dVar.yt() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("crash_limit_count", dVar.yt().getCrashLimitCount());
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
            if (this.Ua != null) {
                this.Ua.gL();
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
                com.baidu.tbadk.util.a.EY().EZ();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.yw().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m411getInst().setVersionData(TiebaSyncService.this.mModel.yw());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yw().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.yt() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.yw(), TiebaSyncService.this.mModel.yv())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yw().getStrategy() == 0 && TiebaSyncService.this.mModel.yt() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.yw(), TiebaSyncService.this.mModel.yv())));
                            TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wN = dVar.yt().wN();
                if (wN > 0 && nextInt % wN == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yu = TiebaSyncService.this.mModel.yu();
                if (!StringUtils.isNull(yu)) {
                    TbadkCoreApplication.m411getInst().setConfigVersion(yu);
                }
                o yy = TiebaSyncService.this.mModel.yy();
                if (yy != null) {
                    TbadkCoreApplication.m411getInst().getListItemRule().dY(yy.xg());
                    TbadkCoreApplication.m411getInst().getListItemRule().ea(yy.xi());
                    TbadkCoreApplication.m411getInst().getListItemRule().dZ(yy.xh());
                    TbadkCoreApplication.m411getInst().setUseNewResign(yy.xp());
                    ak.uJ().b(yy.xb(), yy.xc(), yy.xd(), yy.xe(), yy.xf());
                    String xa = yy.xa();
                    com.baidu.tbadk.core.sharedPref.b tJ = com.baidu.tbadk.core.sharedPref.b.tJ();
                    if (xa == null) {
                        xa = "";
                    }
                    tJ.putString("apply_vip_live_room_pid", xa);
                    com.baidu.tbadk.core.sharedPref.b.tJ().putString("tail_link", yy.xj());
                    com.baidu.tbadk.core.sharedPref.b.tJ().putString("bubble_link", yy.xk());
                    XiaoyingUtil.setShowTime(yy.xl());
                    TbadkCoreApplication.m411getInst().setLastUpdateThemeTime(yy.xm());
                    com.baidu.tbadk.core.sharedPref.b.tJ().putLong("recommend_frs_cache_time", yy.xn());
                    com.baidu.tbadk.core.sharedPref.b.tJ().putInt("home_page_max_thread_count", yy.xo());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.yt() != null && TiebaSyncService.this.mModel.yt().wO() != null) {
                    TbadkCoreApplication.m411getInst().setCheckUrl(TiebaSyncService.this.mModel.yt().wO().wX());
                }
                if (TiebaSyncService.this.mModel.yt() != null) {
                    TbadkCoreApplication.m411getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.yt().wP());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_MEMBER_CENTER_RED_TIP));
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
