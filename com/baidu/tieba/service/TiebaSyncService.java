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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
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
        y mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.d.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.d.d dVar;
            Exception e;
            try {
                this.mNetWork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.n("board", Build.BOARD);
                this.mNetWork.n("brand", Build.BRAND);
                this.mNetWork.n("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.I(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.J(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(k.I(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(k.J(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yT() > 0) {
                    this.mNetWork.n("_msg_status", "0");
                } else {
                    this.mNetWork.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.n("_active", activeVersion);
                }
                this.mNetWork.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.mNetWork.n("package", packageName);
                this.mNetWork.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.mNetWork.n("signmd5", av.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n("md5", af.getTiebaApkMd5());
                String ud = this.mNetWork.ud();
                if (this.mNetWork.uF()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.mNetWork.uC().vw().isRequestSuccess()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(ud);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zv().getClientId() != null && dVar.zv().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zv().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zv().getClientId());
                        }
                        if (dVar.zr() != null) {
                            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("crash_limit_count", dVar.zr().getCrashLimitCount());
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
            if (this.mNetWork != null) {
                this.mNetWork.ee();
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
                com.baidu.tbadk.util.a.Ge().Gf();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zx());
                if (TiebaSyncService.this.mModel.zu().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zu());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zu().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zr() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zu(), TiebaSyncService.this.mModel.zt())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zu().getStrategy() == 0 && TiebaSyncService.this.mModel.zr() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zu(), TiebaSyncService.this.mModel.zt())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xB = dVar.zr().xB();
                if (xB > 0 && nextInt % xB == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zs = TiebaSyncService.this.mModel.zs();
                if (!StringUtils.isNull(zs)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zs);
                }
                r zw = TiebaSyncService.this.mModel.zw();
                if (zw != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().eg(zw.xV());
                    TbadkCoreApplication.m9getInst().getListItemRule().ei(zw.xX());
                    TbadkCoreApplication.m9getInst().getListItemRule().eh(zw.xW());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zw.ye());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zw.yf(), zw.yh(), zw.yg());
                    ah.uP().b(zw.xQ(), zw.xR(), zw.xS(), zw.xT(), zw.xU());
                    String xP = zw.xP();
                    com.baidu.tbadk.core.sharedPref.b tQ = com.baidu.tbadk.core.sharedPref.b.tQ();
                    if (xP == null) {
                        xP = "";
                    }
                    tQ.putString("apply_vip_live_room_pid", xP);
                    com.baidu.tbadk.core.sharedPref.b.tQ().putString("tail_link", zw.xY());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putString("bubble_link", zw.xZ());
                    XiaoyingUtil.setShowTime(zw.ya());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zw.yb());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putLong("recommend_frs_cache_time", zw.yc());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putInt("home_page_max_thread_count", zw.yd());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("localvideo_open", zw.yn());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zw.yi());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putInt("card_show_statistic_max_count", zw.akb);
                    com.baidu.tbadk.core.sharedPref.b.tQ().putInt("wefan_switch", zw.yj());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putString("wefan_url", zw.yl());
                    com.baidu.tbadk.core.sharedPref.b.tQ().putString("wefan_tab_name", zw.yk());
                    String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("clean_smart_frs_cookie", "");
                    String ym = zw.ym();
                    if (!TextUtils.equals(string, ym)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.tQ().putString("clean_smart_frs_cookie", ym);
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zr() != null && TiebaSyncService.this.mModel.zr().xC() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zr().xC().xL());
                }
                if (TiebaSyncService.this.mModel.zr() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zr().xD());
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
