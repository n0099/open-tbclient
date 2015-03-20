package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, Boolean> {
    private aa Oi;
    final /* synthetic */ TiebaUpdateService bZe;
    private volatile boolean wb;

    private m(TiebaUpdateService tiebaUpdateService) {
        this.bZe = tiebaUpdateService;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(TiebaUpdateService tiebaUpdateService, m mVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
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
        while (!this.wb) {
            try {
                str2 = this.bZe.mMainApkUrl;
                this.Oi = new aa(str2);
                aa aaVar = this.Oi;
                str3 = this.bZe.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bZe.mMainApkHandler;
                bool2 = Boolean.valueOf(aaVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.Oi.st() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.Oi.sp().tq().hi()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bZe.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bZe.sendBroadcast("action_update_progress_interrupted", true);
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
                TiebaUpdateService tiebaUpdateService = this.bZe;
                str = this.bZe.mMainApkFileName;
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
        this.bZe.mDowndMainApkTask = null;
        this.wb = true;
        if (this.Oi != null) {
            this.Oi.hh();
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
        this.bZe.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bZe.mIsMainApkDone = true;
                handler = this.bZe.mMainApkHandler;
                handler2 = this.bZe.mMainApkHandler;
                str = this.bZe.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
