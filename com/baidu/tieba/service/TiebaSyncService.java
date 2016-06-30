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
            TbadkCoreApplication.m9getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.d.d> {
        ab LK;

        private a() {
            this.LK = null;
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
                this.LK = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.LK.n("_os_version", Build.VERSION.RELEASE);
                this.LK.n("board", Build.BOARD);
                this.LK.n("brand", Build.BRAND);
                this.LK.n("incremental", Build.VERSION.INCREMENTAL);
                this.LK.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.A(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m9getInst().getApp())));
                this.LK.n("_phone_screen", stringBuffer.toString());
                this.LK.n("scr_w", String.valueOf(k.A(TbadkCoreApplication.m9getInst().getApp())));
                this.LK.n("scr_h", String.valueOf(k.B(TbadkCoreApplication.m9getInst().getApp())));
                this.LK.n("scr_dip", String.valueOf(k.C(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() > 0) {
                    this.LK.n("_msg_status", "0");
                } else {
                    this.LK.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.LK.n("_active", activeVersion);
                }
                this.LK.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.LK.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.LK.n("package", packageName);
                this.LK.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.LK.n("signmd5", bc.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.LK.n("md5", ai.getTiebaApkMd5());
                String ta = this.LK.ta();
                if (this.LK.tB()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.LK.ty().uv().nU()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(ta);
                        if (TbadkCoreApplication.getClientId() == null && dVar.yq().getClientId() != null && dVar.yq().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.yq().getClientId());
                            TbadkCoreApplication.setClientId(dVar.yq().getClientId());
                        }
                        if (dVar.ym() != null) {
                            com.baidu.tbadk.core.sharedPref.b.sO().putInt("crash_limit_count", dVar.ym().getCrashLimitCount());
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
            if (this.LK != null) {
                this.LK.dm();
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
                com.baidu.tbadk.util.a.Ft().Fu();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.ys());
                if (TiebaSyncService.this.mModel.yp().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.yp());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yp().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.ym() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.yp(), TiebaSyncService.this.mModel.yo())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yp().getStrategy() == 0 && TiebaSyncService.this.mModel.ym() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.yp(), TiebaSyncService.this.mModel.yo())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wy = dVar.ym().wy();
                if (wy > 0 && nextInt % wy == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yn = TiebaSyncService.this.mModel.yn();
                if (!StringUtils.isNull(yn)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(yn);
                }
                q yr = TiebaSyncService.this.mModel.yr();
                if (yr != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().ee(yr.wS());
                    TbadkCoreApplication.m9getInst().getListItemRule().eg(yr.wU());
                    TbadkCoreApplication.m9getInst().getListItemRule().ef(yr.wT());
                    TbadkCoreApplication.m9getInst().setUseNewResign(yr.xb());
                    TbadkCoreApplication.m9getInst().setGameInfoData(yr.xc(), yr.xe(), yr.xd());
                    am.tN().b(yr.wN(), yr.wO(), yr.wP(), yr.wQ(), yr.wR());
                    String wM = yr.wM();
                    com.baidu.tbadk.core.sharedPref.b sO = com.baidu.tbadk.core.sharedPref.b.sO();
                    if (wM == null) {
                        wM = "";
                    }
                    sO.putString("apply_vip_live_room_pid", wM);
                    com.baidu.tbadk.core.sharedPref.b.sO().putString("tail_link", yr.wV());
                    com.baidu.tbadk.core.sharedPref.b.sO().putString("bubble_link", yr.wW());
                    XiaoyingUtil.setShowTime(yr.wX());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(yr.wY());
                    com.baidu.tbadk.core.sharedPref.b.sO().putLong("recommend_frs_cache_time", yr.wZ());
                    com.baidu.tbadk.core.sharedPref.b.sO().putInt("home_page_max_thread_count", yr.xa());
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("localvideo_open", yr.xh());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setAdKillerData(yr.xf(), yr.getaDKillerUrl());
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(yr.xg());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.ym() != null && TiebaSyncService.this.mModel.ym().wz() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.ym().wz().wI());
                }
                if (TiebaSyncService.this.mModel.ym() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.ym().wA());
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
