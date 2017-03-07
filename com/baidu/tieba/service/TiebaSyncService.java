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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.ak;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private int mHaveRetry = 0;
    private com.baidu.tbadk.coreExtra.c.d mModel = null;
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
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.d> {
        z mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* synthetic */ a(TiebaSyncService tiebaSyncService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.c.d doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.c.d dVar;
            Exception e;
            try {
                this.mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.n("board", Build.BOARD);
                this.mNetWork.n("brand", Build.BRAND);
                this.mNetWork.n("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.n("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.ag(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.ah(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(k.ag(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(k.ah(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(k.ai(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zh().zk() > 0) {
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
                this.mNetWork.n("signmd5", aw.b(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n("md5", ak.getTiebaApkMd5());
                String uB = this.mNetWork.uB();
                if (this.mNetWork.vc()) {
                    TbadkCoreApplication.m9getInst().clearActiveVersion();
                }
                if (this.mNetWork.uZ().vT().isRequestSuccess()) {
                    dVar = new com.baidu.tbadk.coreExtra.c.d();
                    try {
                        dVar.parserJson(uB);
                        if (TbadkCoreApplication.getClientId() == null && dVar.zM().getClientId() != null && dVar.zM().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.zM().getClientId());
                            TbadkCoreApplication.setClientId(dVar.zM().getClientId());
                        }
                        if (dVar.zI() != null) {
                            com.baidu.tbadk.core.sharedPref.b.uo().putInt("crash_limit_count", dVar.zI().getCrashLimitCount());
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
                this.mNetWork.fm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.c.d dVar) {
            int performSampleCount;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.a.GD().GE();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.zO());
                if (TiebaSyncService.this.mModel.zL().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m9getInst().setVersionData(TiebaSyncService.this.mModel.zL());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.zL().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.zI() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zL(), TiebaSyncService.this.mModel.zK())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m9getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.zL().getStrategy() == 0 && TiebaSyncService.this.mModel.zI() != null && TbadkCoreApplication.m9getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m9getInst().getApp(), TiebaSyncService.this.mModel.zL(), TiebaSyncService.this.mModel.zK())));
                            TbadkCoreApplication.m9getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int xX = dVar.zI().xX();
                if (xX > 0 && nextInt % xX == 0 && (performSampleCount = TbadkCoreApplication.m9getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m9getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String zJ = TiebaSyncService.this.mModel.zJ();
                if (!StringUtils.isNull(zJ)) {
                    TbadkCoreApplication.m9getInst().setConfigVersion(zJ);
                }
                r zN = TiebaSyncService.this.mModel.zN();
                if (zN != null) {
                    TbadkCoreApplication.m9getInst().getListItemRule().ea(zN.yr());
                    TbadkCoreApplication.m9getInst().getListItemRule().ec(zN.yt());
                    TbadkCoreApplication.m9getInst().getListItemRule().eb(zN.ys());
                    TbadkCoreApplication.m9getInst().setUseNewResign(zN.yA());
                    TbadkCoreApplication.m9getInst().setGameInfoData(zN.yB(), zN.yD(), zN.yC());
                    ai.vm().b(zN.ym(), zN.yn(), zN.yo(), zN.yp(), zN.yq());
                    String yl = zN.yl();
                    com.baidu.tbadk.core.sharedPref.b uo = com.baidu.tbadk.core.sharedPref.b.uo();
                    if (yl == null) {
                        yl = "";
                    }
                    uo.putString("apply_vip_live_room_pid", yl);
                    com.baidu.tbadk.core.sharedPref.b.uo().putString("tail_link", zN.yu());
                    com.baidu.tbadk.core.sharedPref.b.uo().putString("bubble_link", zN.yv());
                    XiaoyingUtil.setShowTime(zN.yw());
                    TbadkCoreApplication.m9getInst().setLastUpdateThemeTime(zN.yx());
                    com.baidu.tbadk.core.sharedPref.b.uo().putLong("recommend_frs_cache_time", zN.yy());
                    com.baidu.tbadk.core.sharedPref.b.uo().putInt("home_page_max_thread_count", zN.yz());
                    com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("localvideo_open", zN.yJ());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m9getInst().setTTSSwitchOpen(zN.yE());
                    com.baidu.tbadk.core.sharedPref.b.uo().putInt("card_show_statistic_max_count", zN.apz);
                    com.baidu.tbadk.core.sharedPref.b.uo().putInt("wefan_switch", zN.yF());
                    com.baidu.tbadk.core.sharedPref.b.uo().putString("wefan_url", zN.yH());
                    com.baidu.tbadk.core.sharedPref.b.uo().putString("wefan_tab_name", zN.yG());
                    String string = com.baidu.tbadk.core.sharedPref.b.uo().getString("clean_smart_frs_cookie", "");
                    String yI = zN.yI();
                    if (!TextUtils.equals(string, yI)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE, Boolean.TRUE));
                    }
                    com.baidu.tbadk.core.sharedPref.b.uo().putString("clean_smart_frs_cookie", yI);
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.zI() != null && TiebaSyncService.this.mModel.zI().xY() != null) {
                    TbadkCoreApplication.m9getInst().setCheckUrl(TiebaSyncService.this.mModel.zI().xY().yh());
                }
                if (TiebaSyncService.this.mModel.zI() != null) {
                    TbadkCoreApplication.m9getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.zI().xZ());
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
