package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, Boolean> {
    private aa Ok;
    final /* synthetic */ TiebaUpdateService bZt;
    private volatile boolean wb;

    private m(TiebaUpdateService tiebaUpdateService) {
        this.bZt = tiebaUpdateService;
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
                str2 = this.bZt.mMainApkUrl;
                this.Ok = new aa(str2);
                aa aaVar = this.Ok;
                str3 = this.bZt.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bZt.mMainApkHandler;
                bool2 = Boolean.valueOf(aaVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.Ok.st() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.Ok.sp().tq().hi()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bZt.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bZt.sendBroadcast("action_update_progress_interrupted", true);
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
                TiebaUpdateService tiebaUpdateService = this.bZt;
                str = this.bZt.mMainApkFileName;
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
        this.bZt.mDowndMainApkTask = null;
        this.wb = true;
        if (this.Ok != null) {
            this.Ok.hh();
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
        this.bZt.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bZt.mIsMainApkDone = true;
                handler = this.bZt.mMainApkHandler;
                handler2 = this.bZt.mMainApkHandler;
                str = this.bZt.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
