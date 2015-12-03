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
import com.baidu.tieba.y;
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
        ab Ty;

        private a() {
            this.Ty = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ty.o("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.o("_phone_screen", stringBuffer.toString());
                this.Ty.o("scr_w", String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.o("scr_h", String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.o("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yj() > 0) {
                    this.Ty.o("_msg_status", "0");
                } else {
                    this.Ty.o("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Ty.o("_active", activeVersion);
                }
                this.Ty.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.Ty.o("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Ty.o("package", packageName);
                this.Ty.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Ty.o("signmd5", az.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ty.o("md5", y.getTiebaApkMd5());
                String ul = this.Ty.ul();
                if (this.Ty.uP()) {
                    TbadkCoreApplication.m411getInst().clearActiveVersion();
                }
                if (this.Ty.uM().vG().rf()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(ul);
                        if (TbadkCoreApplication.getClientId() == null && dVar.yL().getClientId() != null && dVar.yL().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.yL().getClientId());
                            TbadkCoreApplication.setClientId(dVar.yL().getClientId());
                        }
                        if (dVar.yH() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("crash_limit_count", dVar.yH().getCrashLimitCount());
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
            if (this.Ty != null) {
                this.Ty.gL();
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
                com.baidu.tbadk.util.a.Fk().Fl();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.yK().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m411getInst().setVersionData(TiebaSyncService.this.mModel.yK());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yK().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.yH() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.yK(), TiebaSyncService.this.mModel.yJ())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yK().getStrategy() == 0 && TiebaSyncService.this.mModel.yH() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.yK(), TiebaSyncService.this.mModel.yJ())));
                            TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xe = dVar.yH().xe();
                if (xe > 0 && nextInt % xe == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yI = TiebaSyncService.this.mModel.yI();
                if (!StringUtils.isNull(yI)) {
                    TbadkCoreApplication.m411getInst().setConfigVersion(yI);
                }
                o yM = TiebaSyncService.this.mModel.yM();
                if (yM != null) {
                    TbadkCoreApplication.m411getInst().getListItemRule().dV(yM.xx());
                    TbadkCoreApplication.m411getInst().getListItemRule().dX(yM.xz());
                    TbadkCoreApplication.m411getInst().getListItemRule().dW(yM.xy());
                    ak.uZ().b(yM.xs(), yM.xt(), yM.xu(), yM.xv(), yM.xw());
                    String xr = yM.xr();
                    com.baidu.tbadk.core.sharedPref.b tZ = com.baidu.tbadk.core.sharedPref.b.tZ();
                    if (xr == null) {
                        xr = "";
                    }
                    tZ.putString("apply_vip_live_room_pid", xr);
                    com.baidu.tbadk.core.sharedPref.b.tZ().putString("tail_link", yM.xA());
                    com.baidu.tbadk.core.sharedPref.b.tZ().putString("bubble_link", yM.xB());
                    XiaoyingUtil.setShowTime(yM.xC());
                    TbadkCoreApplication.m411getInst().setLastUpdateThemeTime(yM.xD());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.yH() != null && TiebaSyncService.this.mModel.yH().xf() != null) {
                    TbadkCoreApplication.m411getInst().setCheckUrl(TiebaSyncService.this.mModel.yH().xf().xo());
                }
                if (TiebaSyncService.this.mModel.yH() != null) {
                    TbadkCoreApplication.m411getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.yH().xg());
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
