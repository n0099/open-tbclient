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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.o;
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
            TbadkCoreApplication.m411getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        aa Ty;

        private a() {
            this.Ty = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ty.p("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.p("_phone_screen", stringBuffer.toString());
                this.Ty.p("scr_w", String.valueOf(k.K(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.p("scr_h", String.valueOf(k.L(TbadkCoreApplication.m411getInst().getApp())));
                this.Ty.p("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zn() > 0) {
                    this.Ty.p("_msg_status", "0");
                } else {
                    this.Ty.p("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Ty.p("_active", activeVersion);
                }
                this.Ty.p("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.Ty.p("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.Ty.p("package", packageName);
                this.Ty.p("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.Ty.p("signmd5", ay.a(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ty.p("md5", ag.getTiebaApkMd5());
                String uZ = this.Ty.uZ();
                if (this.Ty.vE()) {
                    TbadkCoreApplication.m411getInst().clearActiveVersion();
                }
                if (this.Ty.vB().ww().rl()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(uZ);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zP().getClientId() != null && dVar.zP().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zP().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zP().getClientId());
                        }
                        if (dVar.zL() != null) {
                            com.baidu.tbadk.core.sharedPref.b.uO().putInt("crash_limit_count", dVar.zL().getCrashLimitCount());
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
                this.Ty.gT();
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
                com.baidu.tbadk.util.a.Gq().Gr();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.zO().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m411getInst().setVersionData(TiebaSyncService.this.mModel.zO());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zO().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zL() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.zO(), TiebaSyncService.this.mModel.zN())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zO().getStrategy() == 0 && TiebaSyncService.this.mModel.zL() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.zO(), TiebaSyncService.this.mModel.zN())));
                            TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int ya = dVar.zL().ya();
                if (ya > 0 && nextInt % ya == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zM = TiebaSyncService.this.mModel.zM();
                if (!StringUtils.isNull(zM)) {
                    TbadkCoreApplication.m411getInst().setConfigVersion(zM);
                }
                o zQ = TiebaSyncService.this.mModel.zQ();
                if (zQ != null) {
                    TbadkCoreApplication.m411getInst().getListItemRule().dX(zQ.yt());
                    TbadkCoreApplication.m411getInst().getListItemRule().dZ(zQ.yv());
                    TbadkCoreApplication.m411getInst().getListItemRule().dY(zQ.yu());
                    TbadkCoreApplication.m411getInst().setUseNewResign(zQ.yC());
                    TbadkCoreApplication.m411getInst().setGameInfoData(zQ.yD(), zQ.yF(), zQ.yE());
                    aj.vO().b(zQ.yo(), zQ.yp(), zQ.yq(), zQ.yr(), zQ.ys());
                    String yn = zQ.yn();
                    com.baidu.tbadk.core.sharedPref.b uO = com.baidu.tbadk.core.sharedPref.b.uO();
                    if (yn == null) {
                        yn = "";
                    }
                    uO.putString("apply_vip_live_room_pid", yn);
                    com.baidu.tbadk.core.sharedPref.b.uO().putString("tail_link", zQ.yw());
                    com.baidu.tbadk.core.sharedPref.b.uO().putString("bubble_link", zQ.yx());
                    XiaoyingUtil.setShowTime(zQ.yy());
                    TbadkCoreApplication.m411getInst().setLastUpdateThemeTime(zQ.yz());
                    com.baidu.tbadk.core.sharedPref.b.uO().putLong("recommend_frs_cache_time", zQ.yA());
                    com.baidu.tbadk.core.sharedPref.b.uO().putInt("home_page_max_thread_count", zQ.yB());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m411getInst().setAdKillerData(zQ.yG(), zQ.getaDKillerUrl());
                    TbadkCoreApplication.m411getInst().setTTSSwitchOpen(zQ.yH());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zL() != null && TiebaSyncService.this.mModel.zL().yb() != null) {
                    TbadkCoreApplication.m411getInst().setCheckUrl(TiebaSyncService.this.mModel.zL().yb().yk());
                }
                if (TiebaSyncService.this.mModel.zL() != null) {
                    TbadkCoreApplication.m411getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zL().yc());
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
