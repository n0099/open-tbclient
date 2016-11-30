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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.z;
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
        z Ob;

        private a() {
            this.Ob = null;
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
                this.Ob = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.Ob.n("_os_version", Build.VERSION.RELEASE);
                this.Ob.n("board", Build.BOARD);
                this.Ob.n("brand", Build.BRAND);
                this.Ob.n("incremental", Build.VERSION.INCREMENTAL);
                this.Ob.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("_phone_screen", stringBuffer.toString());
                this.Ob.n("scr_w", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("scr_h", String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zh().zk() > 0) {
                    this.Ob.n("_msg_status", "0");
                } else {
                    this.Ob.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Ob.n("_active", activeVersion);
                }
                this.Ob.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.Ob.n("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.Ob.n("package", packageName);
                this.Ob.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.Ob.n("signmd5", az.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ob.n("md5", af.getTiebaApkMd5());
                String uy = this.Ob.uy();
                if (this.Ob.uZ()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.Ob.uW().vS().oH()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(uy);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zN().getClientId() != null && dVar.zN().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zN().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zN().getClientId());
                        }
                        if (dVar.zJ() != null) {
                            com.baidu.tbadk.core.sharedPref.b.um().putInt("crash_limit_count", dVar.zJ().getCrashLimitCount());
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
            if (this.Ob != null) {
                this.Ob.eg();
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
                com.baidu.tbadk.util.a.GQ().GR();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zP());
                if (TiebaSyncService.this.mModel.zM().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zM());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zM().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zJ() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zM(), TiebaSyncService.this.mModel.zL())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zM().getStrategy() == 0 && TiebaSyncService.this.mModel.zJ() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zM(), TiebaSyncService.this.mModel.zL())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xR = dVar.zJ().xR();
                if (xR > 0 && nextInt % xR == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zK = TiebaSyncService.this.mModel.zK();
                if (!StringUtils.isNull(zK)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zK);
                }
                t zO = TiebaSyncService.this.mModel.zO();
                if (zO != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().el(zO.yl());
                    TbadkCoreApplication.m9getInst().getListItemRule().en(zO.yn());
                    TbadkCoreApplication.m9getInst().getListItemRule().em(zO.ym());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zO.yu());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zO.yv(), zO.yx(), zO.yw());
                    ak.vl().b(zO.yg(), zO.yh(), zO.yi(), zO.yj(), zO.yk());
                    String yf = zO.yf();
                    com.baidu.tbadk.core.sharedPref.b um = com.baidu.tbadk.core.sharedPref.b.um();
                    if (yf == null) {
                        yf = "";
                    }
                    um.putString("apply_vip_live_room_pid", yf);
                    com.baidu.tbadk.core.sharedPref.b.um().putString("tail_link", zO.yo());
                    com.baidu.tbadk.core.sharedPref.b.um().putString("bubble_link", zO.yp());
                    XiaoyingUtil.setShowTime(zO.yq());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zO.yr());
                    com.baidu.tbadk.core.sharedPref.b.um().putLong("recommend_frs_cache_time", zO.ys());
                    com.baidu.tbadk.core.sharedPref.b.um().putInt("home_page_max_thread_count", zO.yt());
                    com.baidu.tbadk.core.sharedPref.b.um().putBoolean("localvideo_open", zO.yE());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setAdKillerData(zO.yy(), zO.getaDKillerUrl());
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zO.yz());
                    com.baidu.tbadk.core.sharedPref.b.um().putInt("card_show_statistic_max_count", zO.alo);
                    com.baidu.tbadk.core.sharedPref.b.um().putInt("wefan_switch", zO.yA());
                    com.baidu.tbadk.core.sharedPref.b.um().putString("wefan_url", zO.yC());
                    com.baidu.tbadk.core.sharedPref.b.um().putString("wefan_tab_name", zO.yB());
                    String string = com.baidu.tbadk.core.sharedPref.b.um().getString("clean_smart_frs_cookie", "");
                    String yD = zO.yD();
                    if (!TextUtils.equals(string, yD)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.um().putString("clean_smart_frs_cookie", yD);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ACROSS_FORUM_THEME_INFO_GET, zO.alt));
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zJ() != null && TiebaSyncService.this.mModel.zJ().xS() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zJ().xS().yb());
                }
                if (TiebaSyncService.this.mModel.zJ() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zJ().xT());
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
