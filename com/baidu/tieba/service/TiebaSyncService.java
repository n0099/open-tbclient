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
        ab QV;

        private a() {
            this.QV = null;
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
                this.QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
                this.QV.p("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.C(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("_phone_screen", stringBuffer.toString());
                this.QV.p("scr_w", String.valueOf(k.B(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("scr_h", String.valueOf(k.C(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("scr_dip", String.valueOf(k.D(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zP() > 0) {
                    this.QV.p("_msg_status", "0");
                } else {
                    this.QV.p("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.QV.p("_active", activeVersion);
                }
                this.QV.p("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.QV.p("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.QV.p("package", packageName);
                this.QV.p("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.QV.p("signmd5", ba.a(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.QV.p("md5", ag.getTiebaApkMd5());
                String vw = this.QV.vw();
                if (this.QV.vX()) {
                    TbadkCoreApplication.m411getInst().clearActiveVersion();
                }
                if (this.QV.vU().wP().qC()) {
                    dVar = new com.baidu.tbadk.coreExtra.d.d();
                    try {
                        dVar.parserJson(vw);
                        if (TbadkCoreApplication.getClientId() == null && dVar.As().getClientId() != null && dVar.As().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.As().getClientId());
                            TbadkCoreApplication.setClientId(dVar.As().getClientId());
                        }
                        if (dVar.Ao() != null) {
                            com.baidu.tbadk.core.sharedPref.b.vk().putInt("crash_limit_count", dVar.Ao().getCrashLimitCount());
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
            if (this.QV != null) {
                this.QV.gX();
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
                com.baidu.tbadk.util.a.Hm().Hn();
                TiebaSyncService.this.mModel = dVar;
                if (TiebaSyncService.this.mModel.Ar().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.m411getInst().setVersionData(TiebaSyncService.this.mModel.Ar());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.Ar().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.Ao() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.Ar(), TiebaSyncService.this.mModel.Aq())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.Ar().getStrategy() == 0 && TiebaSyncService.this.mModel.Ao() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), TiebaSyncService.this.mModel.Ar(), TiebaSyncService.this.mModel.Aq())));
                            TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int yB = dVar.Ao().yB();
                if (yB > 0 && nextInt % yB == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String Ap = TiebaSyncService.this.mModel.Ap();
                if (!StringUtils.isNull(Ap)) {
                    TbadkCoreApplication.m411getInst().setConfigVersion(Ap);
                }
                o At = TiebaSyncService.this.mModel.At();
                if (At != null) {
                    TbadkCoreApplication.m411getInst().getListItemRule().ee(At.yU());
                    TbadkCoreApplication.m411getInst().getListItemRule().eg(At.yW());
                    TbadkCoreApplication.m411getInst().getListItemRule().ef(At.yV());
                    TbadkCoreApplication.m411getInst().setUseNewResign(At.zd());
                    TbadkCoreApplication.m411getInst().setGameInfoData(At.ze(), At.zg(), At.zf());
                    al.wh().b(At.yP(), At.yQ(), At.yR(), At.yS(), At.yT());
                    String yO = At.yO();
                    com.baidu.tbadk.core.sharedPref.b vk = com.baidu.tbadk.core.sharedPref.b.vk();
                    if (yO == null) {
                        yO = "";
                    }
                    vk.putString("apply_vip_live_room_pid", yO);
                    com.baidu.tbadk.core.sharedPref.b.vk().putString("tail_link", At.yX());
                    com.baidu.tbadk.core.sharedPref.b.vk().putString("bubble_link", At.yY());
                    XiaoyingUtil.setShowTime(At.yZ());
                    TbadkCoreApplication.m411getInst().setLastUpdateThemeTime(At.za());
                    com.baidu.tbadk.core.sharedPref.b.vk().putLong("recommend_frs_cache_time", At.zb());
                    com.baidu.tbadk.core.sharedPref.b.vk().putInt("home_page_max_thread_count", At.zc());
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("localvideo_open", At.zj());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP));
                    TbadkCoreApplication.m411getInst().setAdKillerData(At.zh(), At.getaDKillerUrl());
                    TbadkCoreApplication.m411getInst().setTTSSwitchOpen(At.zi());
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.Ao() != null && TiebaSyncService.this.mModel.Ao().yC() != null) {
                    TbadkCoreApplication.m411getInst().setCheckUrl(TiebaSyncService.this.mModel.Ao().yC().yL());
                }
                if (TiebaSyncService.this.mModel.Ao() != null) {
                    TbadkCoreApplication.m411getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.Ao().yD());
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
