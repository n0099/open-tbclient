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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.af;
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
        z NX;

        private a() {
            this.NX = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.NX = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.NX.n("_os_version", Build.VERSION.RELEASE);
                this.NX.n("board", Build.BOARD);
                this.NX.n("brand", Build.BRAND);
                this.NX.n("incremental", Build.VERSION.INCREMENTAL);
                this.NX.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.I(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.J(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("_phone_screen", stringBuffer.toString());
                this.NX.n("scr_w", String.valueOf(k.I(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("scr_h", String.valueOf(k.J(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("scr_dip", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yV().yY() > 0) {
                    this.NX.n("_msg_status", "0");
                } else {
                    this.NX.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.NX.n("_active", activeVersion);
                }
                this.NX.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.NX.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.NX.n("package", packageName);
                this.NX.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.NX.n("signmd5", ax.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.NX.n("md5", af.getTiebaApkMd5());
                String uk = this.NX.uk();
                if (this.NX.uL()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.NX.uI().vC().oH()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(uk);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zA().getClientId() != null && dVar.zA().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zA().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zA().getClientId());
                        }
                        if (dVar.zw() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tW().putInt("crash_limit_count", dVar.zw().getCrashLimitCount());
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
            if (this.NX != null) {
                this.NX.eg();
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
                com.baidu.tbadk.util.a.Gm().Gn();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zC());
                if (TiebaSyncService.this.mModel.zz().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zz());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zz().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zw() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zz(), TiebaSyncService.this.mModel.zy())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zz().getStrategy() == 0 && TiebaSyncService.this.mModel.zw() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zz(), TiebaSyncService.this.mModel.zy())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xF = dVar.zw().xF();
                if (xF > 0 && nextInt % xF == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zx = TiebaSyncService.this.mModel.zx();
                if (!StringUtils.isNull(zx)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zx);
                }
                r zB = TiebaSyncService.this.mModel.zB();
                if (zB != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().ei(zB.xZ());
                    TbadkCoreApplication.m9getInst().getListItemRule().ek(zB.yb());
                    TbadkCoreApplication.m9getInst().getListItemRule().ej(zB.ya());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zB.yi());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zB.yj(), zB.yl(), zB.yk());
                    aj.uV().b(zB.xU(), zB.xV(), zB.xW(), zB.xX(), zB.xY());
                    String xT = zB.xT();
                    com.baidu.tbadk.core.sharedPref.b tW = com.baidu.tbadk.core.sharedPref.b.tW();
                    if (xT == null) {
                        xT = "";
                    }
                    tW.putString("apply_vip_live_room_pid", xT);
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("tail_link", zB.yc());
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("bubble_link", zB.yd());
                    XiaoyingUtil.setShowTime(zB.ye());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zB.yf());
                    com.baidu.tbadk.core.sharedPref.b.tW().putLong("recommend_frs_cache_time", zB.yg());
                    com.baidu.tbadk.core.sharedPref.b.tW().putInt("home_page_max_thread_count", zB.yh());
                    com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("localvideo_open", zB.ys());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setAdKillerData(zB.ym(), zB.getaDKillerUrl());
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zB.yn());
                    com.baidu.tbadk.core.sharedPref.b.tW().putInt("card_show_statistic_max_count", zB.akP);
                    com.baidu.tbadk.core.sharedPref.b.tW().putInt("wefan_switch", zB.yo());
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("wefan_url", zB.yq());
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("wefan_tab_name", zB.yp());
                    String string = com.baidu.tbadk.core.sharedPref.b.tW().getString("clean_smart_frs_cookie", "");
                    String yr = zB.yr();
                    if (!TextUtils.equals(string, yr)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("clean_smart_frs_cookie", yr);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ACROSS_FORUM_THEME_INFO_GET, zB.akU));
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zw() != null && TiebaSyncService.this.mModel.zw().xG() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zw().xG().xP());
                }
                if (TiebaSyncService.this.mModel.zw() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zw().xH());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_FINISH));
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.m9getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
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
