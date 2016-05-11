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
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xF().xI() > 0) {
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
                String tc = this.LL.tc();
                if (this.LL.tD()) {
                    TbadkCoreApplication.m11getInst().clearActiveVersion();
                }
                if (this.LL.tA().uv().nZ()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(tc);
                        if (TbadkCoreApplication.getClientId() == null && dVar.yl().getClientId() != null && dVar.yl().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.yl().getClientId());
                            TbadkCoreApplication.setClientId(dVar.yl().getClientId());
                        }
                        if (dVar.yh() != null) {
                            com.baidu.tbadk.core.sharedPref.b.sQ().putInt("crash_limit_count", dVar.yh().getCrashLimitCount());
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
                com.baidu.tbadk.util.a.Fj().Fk();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.yk().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m11getInst().setVersionData(TiebaSyncService.this.mModel.yk());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.yk().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.yh() != null && TbadkCoreApplication.m11getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m11getInst().getApp(), TiebaSyncService.this.mModel.yk(), TiebaSyncService.this.mModel.yj())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m11getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.yk().getStrategy() == 0 && TiebaSyncService.this.mModel.yh() != null && TbadkCoreApplication.m11getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m11getInst().getApp(), TiebaSyncService.this.mModel.yk(), TiebaSyncService.this.mModel.yj())));
                            TbadkCoreApplication.m11getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m11getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int wu = dVar.yh().wu();
                if (wu > 0 && nextInt % wu == 0 && (performSampleCount = TbadkCoreApplication.m11getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m11getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String yi = TiebaSyncService.this.mModel.yi();
                if (!StringUtils.isNull(yi)) {
                    TbadkCoreApplication.m11getInst().setConfigVersion(yi);
                }
                p ym = TiebaSyncService.this.mModel.ym();
                if (ym != null) {
                    TbadkCoreApplication.m11getInst().getListItemRule().ea(ym.wN());
                    TbadkCoreApplication.m11getInst().getListItemRule().ec(ym.wP());
                    TbadkCoreApplication.m11getInst().getListItemRule().eb(ym.wO());
                    TbadkCoreApplication.m11getInst().setUseNewResign(ym.wW());
                    TbadkCoreApplication.m11getInst().setGameInfoData(ym.wX(), ym.wZ(), ym.wY());
                    al.tN().b(ym.wI(), ym.wJ(), ym.wK(), ym.wL(), ym.wM());
                    String wH = ym.wH();
                    com.baidu.tbadk.core.sharedPref.b sQ = com.baidu.tbadk.core.sharedPref.b.sQ();
                    if (wH == null) {
                        wH = "";
                    }
                    sQ.putString("apply_vip_live_room_pid", wH);
                    com.baidu.tbadk.core.sharedPref.b.sQ().putString("tail_link", ym.wQ());
                    com.baidu.tbadk.core.sharedPref.b.sQ().putString("bubble_link", ym.wR());
                    XiaoyingUtil.setShowTime(ym.wS());
                    TbadkCoreApplication.m11getInst().setLastUpdateThemeTime(ym.wT());
                    com.baidu.tbadk.core.sharedPref.b.sQ().putLong("recommend_frs_cache_time", ym.wU());
                    com.baidu.tbadk.core.sharedPref.b.sQ().putInt("home_page_max_thread_count", ym.wV());
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("localvideo_open", ym.xc());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m11getInst().setAdKillerData(ym.xa(), ym.getaDKillerUrl());
                    TbadkCoreApplication.m11getInst().setTTSSwitchOpen(ym.xb());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.yh() != null && TiebaSyncService.this.mModel.yh().wv() != null) {
                    TbadkCoreApplication.m11getInst().setCheckUrl(TiebaSyncService.this.mModel.yh().wv().wE());
                }
                if (TiebaSyncService.this.mModel.yh() != null) {
                    TbadkCoreApplication.m11getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.yh().ww());
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
