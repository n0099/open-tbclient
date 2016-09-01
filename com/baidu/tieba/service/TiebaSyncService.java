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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.ah;
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
        ab NX;

        private a() {
            this.NX = null;
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
                this.NX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.NX.n("_os_version", Build.VERSION.RELEASE);
                this.NX.n("board", Build.BOARD);
                this.NX.n("brand", Build.BRAND);
                this.NX.n("incremental", Build.VERSION.INCREMENTAL);
                this.NX.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("_phone_screen", stringBuffer.toString());
                this.NX.n("scr_w", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("scr_h", String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.NX.n("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yX().za() > 0) {
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
                this.NX.n("signmd5", bc.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.NX.n("md5", ah.getTiebaApkMd5());
                String ue = this.NX.ue();
                if (this.NX.uG()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.NX.uD().vA().oE()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(ue);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zD().getClientId() != null && dVar.zD().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zD().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zD().getClientId());
                        }
                        if (dVar.zz() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tS().putInt("crash_limit_count", dVar.zz().getCrashLimitCount());
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
                com.baidu.tbadk.util.a.GO().GP();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zF());
                if (TiebaSyncService.this.mModel.zC().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zC());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zC().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zz() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zC(), TiebaSyncService.this.mModel.zB())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zC().getStrategy() == 0 && TiebaSyncService.this.mModel.zz() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zC(), TiebaSyncService.this.mModel.zB())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xI = dVar.zz().xI();
                if (xI > 0 && nextInt % xI == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zA = TiebaSyncService.this.mModel.zA();
                if (!StringUtils.isNull(zA)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zA);
                }
                t zE = TiebaSyncService.this.mModel.zE();
                if (zE != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().eg(zE.yc());
                    TbadkCoreApplication.m9getInst().getListItemRule().ei(zE.ye());
                    TbadkCoreApplication.m9getInst().getListItemRule().eh(zE.yd());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zE.yl());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zE.ym(), zE.yo(), zE.yn());
                    am.uS().b(zE.xX(), zE.xY(), zE.xZ(), zE.ya(), zE.yb());
                    String xW = zE.xW();
                    com.baidu.tbadk.core.sharedPref.b tS = com.baidu.tbadk.core.sharedPref.b.tS();
                    if (xW == null) {
                        xW = "";
                    }
                    tS.putString("apply_vip_live_room_pid", xW);
                    com.baidu.tbadk.core.sharedPref.b.tS().putString("tail_link", zE.yf());
                    com.baidu.tbadk.core.sharedPref.b.tS().putString("bubble_link", zE.yg());
                    XiaoyingUtil.setShowTime(zE.yh());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zE.yi());
                    com.baidu.tbadk.core.sharedPref.b.tS().putLong("recommend_frs_cache_time", zE.yj());
                    com.baidu.tbadk.core.sharedPref.b.tS().putInt("home_page_max_thread_count", zE.yk());
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("localvideo_open", zE.yu());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setAdKillerData(zE.yp(), zE.getaDKillerUrl());
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zE.yq());
                    com.baidu.tbadk.core.sharedPref.b.tS().putInt("card_show_statistic_max_count", zE.akP);
                    com.baidu.tbadk.core.sharedPref.b.tS().putInt("wefan_switch", zE.yr());
                    com.baidu.tbadk.core.sharedPref.b.tS().putString("wefan_url", zE.yt());
                    com.baidu.tbadk.core.sharedPref.b.tS().putString("wefan_tab_name", zE.ys());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zz() != null && TiebaSyncService.this.mModel.zz().xJ() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zz().xJ().xS());
                }
                if (TiebaSyncService.this.mModel.zz() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zz().xK());
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
