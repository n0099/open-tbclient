package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService bJh;
    private volatile boolean kJ;
    private ac mNetWork;

    private u(TiebaUpdateService tiebaUpdateService) {
        this.bJh = tiebaUpdateService;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(TiebaUpdateService tiebaUpdateService, u uVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        Boolean bool;
        Exception e;
        String str;
        String str2;
        String str3;
        Handler handler;
        boolean z;
        long j;
        Boolean bool2 = false;
        while (!this.kJ) {
            try {
                str2 = this.bJh.mMainApkUrl;
                this.mNetWork = new ac(str2);
                ac acVar = this.mNetWork;
                str3 = this.bJh.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bJh.mMainApkHandler;
                bool2 = Boolean.valueOf(acVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.mNetWork.mg() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.mNetWork.mc().nb().mm()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z && UtilHelper.isNetOk()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bJh.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bJh.sendBroadcast("action_update_progress_interrupted", true);
                            bool = bool2;
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                bool = bool2;
                e = e3;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                TiebaUpdateService tiebaUpdateService = this.bJh;
                str = this.bJh.mMainApkFileName;
                tiebaUpdateService.renameFile(str);
            }
        } catch (Exception e4) {
            e = e4;
            BdLog.e(e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.bJh.mDowndMainApkTask = null;
        this.kJ = true;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        Handler handler;
        Handler handler2;
        String str;
        super.onPostExecute(bool);
        this.bJh.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bJh.mIsMainApkDone = true;
                handler = this.bJh.mMainApkHandler;
                handler2 = this.bJh.mMainApkHandler;
                str = this.bJh.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
