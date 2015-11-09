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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.t;
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
        w Tj;

        private a() {
            this.Tj = null;
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
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Tj.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Tj.o("_phone_screen", stringBuffer.toString());
                this.Tj.o("scr_w", String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                this.Tj.o("scr_h", String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Tj.o("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xm() > 0) {
                    this.Tj.o("_msg_status", "0");
                } else {
                    this.Tj.o("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Tj.o("_active", activeVersion);
                }
                this.Tj.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.Tj.o("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Tj.o("package", packageName);
                this.Tj.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Tj.o("signmd5", au.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Tj.o("md5", t.getTiebaApkMd5());
                String tG = this.Tj.tG();
                if (this.Tj.uk()) {
                    TbadkCoreApplication.m411getInst().clearActiveVersion();
                }
                if (this.Tj.uh().va().qT()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(tG);
                        if (TbadkCoreApplication.getClientId() == null && dVar.xP().getClientId() != null && dVar.xP().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.xP().getClientId());
                            TbadkCoreApplication.setClientId(dVar.xP().getClientId());
                        }
                        if (dVar.xL() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tu().putInt("crash_limit_count", dVar.xL().getCrashLimitCount());
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
            if (this.Tj != null) {
                this.Tj.gJ();
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
                com.baidu.tbadk.util.a.Ei().Ej();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.xO().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m411getInst().setVersionData(TiebaSyncService.this.mModel.xO());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.xO().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.xL() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.xO(), TiebaSyncService.this.mModel.xN())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.xO().getStrategy() == 0 && TiebaSyncService.this.mModel.xL() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.xO(), TiebaSyncService.this.mModel.xN())));
                            TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wk = dVar.xL().wk();
                if (wk > 0 && nextInt % wk == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String xM = TiebaSyncService.this.mModel.xM();
                if (!StringUtils.isNull(xM)) {
                    TbadkCoreApplication.m411getInst().setConfigVersion(xM);
                }
                m xQ = TiebaSyncService.this.mModel.xQ();
                if (xQ != null) {
                    TbadkCoreApplication.m411getInst().getListItemRule().dN(xQ.wC());
                    TbadkCoreApplication.m411getInst().getListItemRule().dP(xQ.wE());
                    TbadkCoreApplication.m411getInst().getListItemRule().dO(xQ.wD());
                    af.ut().b(xQ.wx(), xQ.wy(), xQ.wz(), xQ.wA(), xQ.wB());
                    String ww = xQ.ww();
                    com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
                    if (ww == null) {
                        ww = "";
                    }
                    tu.putString("apply_vip_live_room_pid", ww);
                    com.baidu.tbadk.core.sharedPref.b.tu().putString("tail_link", xQ.wF());
                    com.baidu.tbadk.core.sharedPref.b.tu().putString("bubble_link", xQ.wG());
                    XiaoyingUtil.setShowTime(xQ.wH());
                    TbadkCoreApplication.m411getInst().setLastUpdateThemeTime(xQ.wI());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.xL() != null && TiebaSyncService.this.mModel.xL().wl() != null) {
                    TbadkCoreApplication.m411getInst().setCheckUrl(TiebaSyncService.this.mModel.xL().wl().wt());
                    return;
                }
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
