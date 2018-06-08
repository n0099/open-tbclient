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
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.d;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.g;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private int mHaveRetry = 0;
    private d mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaSyncService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaSyncService.this.checkUpdata();
        }
    };

    static /* synthetic */ int access$608(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        return i;
    }

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
        this.mSyncTask = new a();
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
            TbadkCoreApplication.getInst().refreshNewVersion(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, d> {
        y mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_SYNC_ADDRESS);
                this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
                this.mNetWork.o("board", Build.BOARD);
                this.mNetWork.o("brand", Build.BRAND);
                this.mNetWork.o("incremental", Build.VERSION.INCREMENTAL);
                this.mNetWork.o("model", Build.MODEL);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.o("_phone_screen", stringBuffer.toString());
                this.mNetWork.o("scr_w", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.o("scr_h", String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.o("scr_dip", String.valueOf(l.ak(TbadkCoreApplication.getInst().getApp())));
                if (c.DE().DH() > 0) {
                    this.mNetWork.o("_msg_status", "0");
                } else {
                    this.mNetWork.o("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.o("_active", activeVersion);
                }
                this.mNetWork.o("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (TiebaSyncService.mStatistics != null) {
                    this.mNetWork.o("_msg_type", TiebaSyncService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.o("package", packageName);
                this.mNetWork.o("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.o("signmd5", ar.d(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.o(ARResourceKey.HTTP_AR_MD5, g.getTiebaApkMd5());
                String yl = this.mNetWork.yl();
                if (this.mNetWork.yM()) {
                    TbadkCoreApplication.getInst().clearActiveVersion();
                }
                if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(yl);
                        if (TbadkCoreApplication.getClientId() == null && dVar.Ej().getClientId() != null && dVar.Ej().getClientId().length() > 0) {
                            TbadkCoreApplication.saveClientId(TiebaSyncService.this, dVar.Ej().getClientId());
                            TbadkCoreApplication.setClientId(dVar.Ej().getClientId());
                        }
                        if (dVar.Ef() != null) {
                            b.getInstance().putInt("crash_limit_count", dVar.Ef().getCrashLimitCount());
                        }
                        String unused = TiebaSyncService.mStatistics = null;
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
                this.mNetWork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            int performSampleCount;
            super.onPostExecute(dVar);
            TiebaSyncService.this.mSyncTask = null;
            if (dVar != null) {
                com.baidu.tbadk.util.a.KN().KO();
                TiebaSyncService.this.mModel = dVar;
                com.baidu.tieba.a.a(TiebaSyncService.this.mModel.El());
                if (TiebaSyncService.this.mModel.Ei().hasNewVer() && TbConfig.COULD_UPDATE) {
                    TbadkCoreApplication.getInst().setVersionData(TiebaSyncService.this.mModel.Ei());
                    TiebaSyncService.this.broadcastNewVersion();
                    if (TiebaSyncService.this.mModel.Ei().forceUpdate()) {
                        if (TiebaSyncService.this.mModel.Ef() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Ei(), TiebaSyncService.this.mModel.Eh())));
                        }
                    } else {
                        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                        Long valueOf2 = Long.valueOf(new Date().getTime());
                        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && TiebaSyncService.this.mModel.Ei().getStrategy() == 0 && TiebaSyncService.this.mModel.Ef() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TiebaSyncService.this.mModel.Ei(), TiebaSyncService.this.mModel.Eh())));
                            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                        }
                    }
                }
                TbadkCoreApplication.getInst().setIsNoInterestTag(1 == TiebaSyncService.this.mModel.Em());
                TbadkCoreApplication.getInst().setIsFirstTimeMotivate(TiebaSyncService.this.mModel.En());
                TbadkCoreApplication.getInst().loadLcsSwitchStratgy();
                int nextInt = new Random().nextInt(10000) + 1;
                int BY = dVar.Ef().BY();
                if (BY > 0 && nextInt % BY == 0 && (performSampleCount = TbadkCoreApplication.getInst().getPerformSampleCount()) < 10) {
                    TbadkCoreApplication.getInst().setPerformSampleCount(performSampleCount + 1);
                }
                String Eg = TiebaSyncService.this.mModel.Eg();
                if (!StringUtils.isNull(Eg)) {
                    TbadkCoreApplication.getInst().setConfigVersion(Eg);
                }
                v Ek = TiebaSyncService.this.mModel.Ek();
                if (Ek != null) {
                    TbadkCoreApplication.getInst().setActivityPrizeData(Ek.getActivityPrizeData());
                    TbadkCoreApplication.getInst().getListItemRule().fy(Ek.Cy());
                    TbadkCoreApplication.getInst().getListItemRule().fA(Ek.CA());
                    TbadkCoreApplication.getInst().getListItemRule().fz(Ek.Cz());
                    TbadkCoreApplication.getInst().setUseNewResign(Ek.CJ());
                    TbadkCoreApplication.getInst().setUegVoiceWarning(Ek.getUegVoiceWarning());
                    TbadkCoreApplication.getInst().setUrlText(Ek.CR());
                    TbadkCoreApplication.getInst().setGameInfoData(Ek.CK(), Ek.CM(), Ek.CL());
                    ag.yX().b(Ek.Ct(), Ek.Cu(), Ek.Cv(), Ek.Cw(), Ek.Cx());
                    String Cs = Ek.Cs();
                    b bVar = b.getInstance();
                    if (Cs == null) {
                        Cs = "";
                    }
                    bVar.putString("apply_vip_live_room_pid", Cs);
                    b.getInstance().putString("tail_link", Ek.CB());
                    b.getInstance().putString("bubble_link", Ek.CC());
                    long CD = Ek.CD();
                    if (CD >= 0 && CD != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(Ek.CD());
                    }
                    long CS = Ek.CS() * 1000;
                    if (CS > 0) {
                        b.getInstance().putLong("KEY_UPLOAD_LOG_INTERVAL", CS);
                    }
                    XiaoyingUtil.setShowTime(Ek.CE());
                    TbadkCoreApplication.getInst().setLastUpdateThemeTime(Ek.CF());
                    b.getInstance().putLong("recommend_frs_cache_time", Ek.CH());
                    b.getInstance().putInt("home_page_max_thread_count", Ek.CI());
                    b.getInstance().putBoolean("localvideo_open", Ek.CO());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001365));
                    b.getInstance().putInt("card_show_statistic_max_count", Ek.aCj);
                    b.getInstance().putString("nick_name_activity_link", Ek.CQ());
                    String string = b.getInstance().getString("clean_smart_frs_cookie", "");
                    String CN = Ek.CN();
                    if (!TextUtils.equals(string, CN)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016501, Boolean.TRUE));
                    }
                    b.getInstance().putString("clean_smart_frs_cookie", CN);
                    b.getInstance().putInt("recommend_tab_show", Ek.CG());
                    TbConfig.setMaxPhotoMemoryCache(Ek.CP());
                    b.getInstance().putInt("key_card_show_type", Ek.CT());
                    TbadkCoreApplication.getInst().setCardShowType(Ek.CT());
                    b.getInstance().putInt("key_card_abstract_switch", Ek.CU());
                    q CV = Ek.CV();
                    if (CV != null) {
                        b.getInstance().putBoolean("nani_key_is_show_download_nani_panel", CV.aBy);
                        b.getInstance().putBoolean("nani_key_is_activate_app", CV.aBz);
                        b.getInstance().putInt("nani_key_download_show_position", CV.aBA);
                        b.getInstance().putInt("nani_key_download_show_rate", CV.aBB);
                        b.getInstance().putString("nani_key_download_link_url", CV.aBC);
                        b.getInstance().putString("nani_key_download_txt", CV.aBD);
                        b.getInstance().putString("nani_key_show_tail_txt", CV.aBE);
                        b.getInstance().putInt("nani_key_show_tail_video_type", CV.aBF);
                        b.getInstance().putString("nani_key_show_tail_txt", CV.aBE);
                        b.getInstance().putString("nani_key_pre_h5_link", CV.aBG);
                    }
                    b.getInstance().putLong("key_frs_cache_time", Ek.CW() * 1000);
                }
                TiebaSyncService.this.stopSelf();
                if (TiebaSyncService.this.mModel.Ef() != null && TiebaSyncService.this.mModel.Ef().BZ() != null) {
                    TbadkCoreApplication.getInst().setCheckUrl(TiebaSyncService.this.mModel.Ef().BZ().Ci());
                }
                if (TiebaSyncService.this.mModel.Ef() != null) {
                    TbadkCoreApplication.getInst().setLastUpdateMemberCenterTime(TiebaSyncService.this.mModel.Ef().Ca());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016459, true));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001371));
                if (TiebaSyncService.this.mModel.getAdAdSense() != null) {
                    TbadkCoreApplication.getInst().setAdAdSense(TiebaSyncService.this.mModel.getAdAdSense());
                }
                if (TiebaSyncService.this.mModel.getActivitySwitch() != null) {
                    TbadkCoreApplication.getInst().setActivitySwitch(TiebaSyncService.this.mModel.getActivitySwitch());
                    return;
                }
                return;
            }
            TiebaSyncService.access$608(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
