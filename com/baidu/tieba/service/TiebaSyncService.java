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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.ai;
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
            TbadkCoreApplication.m10getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab LI;

        private a() {
            this.LI = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.LI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.LI.n("_os_version", Build.VERSION.RELEASE);
                this.LI.n("board", Build.BOARD);
                this.LI.n("brand", Build.BRAND);
                this.LI.n("incremental", Build.VERSION.INCREMENTAL);
                this.LI.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.A(TbadkCoreApplication.m10getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m10getInst().getApp())));
                this.LI.n("_phone_screen", stringBuffer.toString());
                this.LI.n("scr_w", String.valueOf(k.A(TbadkCoreApplication.m10getInst().getApp())));
                this.LI.n("scr_h", String.valueOf(k.B(TbadkCoreApplication.m10getInst().getApp())));
                this.LI.n("scr_dip", String.valueOf(k.C(TbadkCoreApplication.m10getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() > 0) {
                    this.LI.n("_msg_status", "0");
                } else {
                    this.LI.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m10getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.LI.n("_active", activeVersion);
                }
                this.LI.n("_pic_quality", String.valueOf(TbadkCoreApplication.m10getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.LI.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m10getInst().getPackageName();
                this.LI.n("package", packageName);
                this.LI.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m10getInst().getVersionCode())).toString());
                this.LI.n("signmd5", bc.b(TbadkCoreApplication.m10getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.LI.n("md5", ai.getTiebaApkMd5());
                String sZ = this.LI.sZ();
                if (this.LI.tA()) {
                    TbadkCoreApplication.m10getInst().clearActiveVersion();
                }
                if (this.LI.tx().uv().nJ()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(sZ);
                        if (TbadkCoreApplication.getClientId() == null && dVar.yq().getClientId() != null && dVar.yq().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.yq().getClientId());
                            TbadkCoreApplication.setClientId(dVar.yq().getClientId());
                        }
                        if (dVar.ym() != null) {
                            com.baidu.tbadk.core.sharedPref.b.sN().putInt("crash_limit_count", dVar.ym().getCrashLimitCount());
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
            if (this.LI != null) {
                this.LI.dl();
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
                com.baidu.tbadk.util.a.Fu().Fv();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.ys());
                if (TiebaSyncService.this.mModel.yp().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m10getInst().setVersionData(TiebaSyncService.this.mModel.yp());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yp().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.ym() != null && TbadkCoreApplication.m10getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m10getInst().getApp(), TiebaSyncService.this.mModel.yp(), TiebaSyncService.this.mModel.yo())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m10getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yp().getStrategy() == 0 && TiebaSyncService.this.mModel.ym() != null && TbadkCoreApplication.m10getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m10getInst().getApp(), TiebaSyncService.this.mModel.yp(), TiebaSyncService.this.mModel.yo())));
                            TbadkCoreApplication.m10getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m10getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wy = dVar.ym().wy();
                if (wy > 0 && nextInt % wy == 0 && (performSampleCount = TbadkCoreApplication.m10getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m10getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yn = TiebaSyncService.this.mModel.yn();
                if (!StringUtils.isNull(yn)) {
                    TbadkCoreApplication.m10getInst().setConfigVersion(yn);
                }
                q yr = TiebaSyncService.this.mModel.yr();
                if (yr != null) {
                    TbadkCoreApplication.m10getInst().getListItemRule().ed(yr.wS());
                    TbadkCoreApplication.m10getInst().getListItemRule().ef(yr.wU());
                    TbadkCoreApplication.m10getInst().getListItemRule().ee(yr.wT());
                    TbadkCoreApplication.m10getInst().setUseNewResign(yr.xb());
                    TbadkCoreApplication.m10getInst().setGameInfoData(yr.xc(), yr.xe(), yr.xd());
                    am.tM().b(yr.wN(), yr.wO(), yr.wP(), yr.wQ(), yr.wR());
                    String wM = yr.wM();
                    com.baidu.tbadk.core.sharedPref.b sN = com.baidu.tbadk.core.sharedPref.b.sN();
                    if (wM == null) {
                        wM = "";
                    }
                    sN.putString("apply_vip_live_room_pid", wM);
                    com.baidu.tbadk.core.sharedPref.b.sN().putString("tail_link", yr.wV());
                    com.baidu.tbadk.core.sharedPref.b.sN().putString("bubble_link", yr.wW());
                    XiaoyingUtil.setShowTime(yr.wX());
                    TbadkCoreApplication.m10getInst().setLastUpdateThemeTime(yr.wY());
                    com.baidu.tbadk.core.sharedPref.b.sN().putLong("recommend_frs_cache_time", yr.wZ());
                    com.baidu.tbadk.core.sharedPref.b.sN().putInt("home_page_max_thread_count", yr.xa());
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("localvideo_open", yr.xh());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m10getInst().setAdKillerData(yr.xf(), yr.getaDKillerUrl());
                    TbadkCoreApplication.m10getInst().setTTSSwitchOpen(yr.xg());
                    com.baidu.tbadk.core.sharedPref.b.sN().putInt("card_show_statistic_max_count", yr.ahO);
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.ym() != null && TiebaSyncService.this.mModel.ym().wz() != null) {
                    TbadkCoreApplication.m10getInst().setCheckUrl(TiebaSyncService.this.mModel.ym().wz().wI());
                }
                if (TiebaSyncService.this.mModel.ym() != null) {
                    TbadkCoreApplication.m10getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.ym().wA());
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
