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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.t;
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
        ab NY;

        private a() {
            this.NY = null;
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
                this.NY = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.NY.n("_os_version", Build.VERSION.RELEASE);
                this.NY.n("board", Build.BOARD);
                this.NY.n("brand", Build.BRAND);
                this.NY.n("incremental", Build.VERSION.INCREMENTAL);
                this.NY.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.NY.n("_phone_screen", stringBuffer.toString());
                this.NY.n("scr_w", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                this.NY.n("scr_h", String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.NY.n("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.za().zd() > 0) {
                    this.NY.n("_msg_status", "0");
                } else {
                    this.NY.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.NY.n("_active", activeVersion);
                }
                this.NY.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.NY.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.NY.n("package", packageName);
                this.NY.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.NY.n("signmd5", bb.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.NY.n("md5", af.getTiebaApkMd5());
                String uu = this.NY.uu();
                if (this.NY.uV()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.NY.uS().vO().oF()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(uu);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zG().getClientId() != null && dVar.zG().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zG().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zG().getClientId());
                        }
                        if (dVar.zC() != null) {
                            com.baidu.tbadk.core.sharedPref.b.uh().putInt("crash_limit_count", dVar.zC().getCrashLimitCount());
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
            if (this.NY != null) {
                this.NY.eg();
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
                com.baidu.tbadk.util.a.GN().GO();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zI());
                if (TiebaSyncService.this.mModel.zF().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zF());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zF().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zC() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zF(), TiebaSyncService.this.mModel.zE())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zF().getStrategy() == 0 && TiebaSyncService.this.mModel.zC() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zF(), TiebaSyncService.this.mModel.zE())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xL = dVar.zC().xL();
                if (xL > 0 && nextInt % xL == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zD = TiebaSyncService.this.mModel.zD();
                if (!StringUtils.isNull(zD)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zD);
                }
                t zH = TiebaSyncService.this.mModel.zH();
                if (zH != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().ej(zH.yf());
                    TbadkCoreApplication.m9getInst().getListItemRule().el(zH.yh());
                    TbadkCoreApplication.m9getInst().getListItemRule().ek(zH.yg());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zH.yo());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zH.yp(), zH.yr(), zH.yq());
                    am.vh().b(zH.ya(), zH.yb(), zH.yc(), zH.yd(), zH.ye());
                    String xZ = zH.xZ();
                    com.baidu.tbadk.core.sharedPref.b uh = com.baidu.tbadk.core.sharedPref.b.uh();
                    if (xZ == null) {
                        xZ = "";
                    }
                    uh.putString("apply_vip_live_room_pid", xZ);
                    com.baidu.tbadk.core.sharedPref.b.uh().putString("tail_link", zH.yi());
                    com.baidu.tbadk.core.sharedPref.b.uh().putString("bubble_link", zH.yj());
                    XiaoyingUtil.setShowTime(zH.yk());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zH.yl());
                    com.baidu.tbadk.core.sharedPref.b.uh().putLong("recommend_frs_cache_time", zH.ym());
                    com.baidu.tbadk.core.sharedPref.b.uh().putInt("home_page_max_thread_count", zH.yn());
                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("localvideo_open", zH.yx());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setAdKillerData(zH.ys(), zH.getaDKillerUrl());
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zH.yt());
                    com.baidu.tbadk.core.sharedPref.b.uh().putInt("card_show_statistic_max_count", zH.akv);
                    com.baidu.tbadk.core.sharedPref.b.uh().putInt("wefan_switch", zH.yu());
                    com.baidu.tbadk.core.sharedPref.b.uh().putString("wefan_url", zH.yw());
                    com.baidu.tbadk.core.sharedPref.b.uh().putString("wefan_tab_name", zH.yv());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zC() != null && TiebaSyncService.this.mModel.zC().xM() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zC().xM().xV());
                }
                if (TiebaSyncService.this.mModel.zC() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zC().xN());
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
