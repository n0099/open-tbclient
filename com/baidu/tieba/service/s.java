package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private ae b;
    private volatile boolean c;

    private s(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaUpdateService tiebaUpdateService, s sVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        while (!this.c) {
            try {
                str2 = this.a.mMainApkUrl;
                this.b = new ae(str2);
                ae aeVar = this.b;
                str3 = this.a.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.a.mMainApkHandler;
                bool2 = Boolean.valueOf(aeVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.b.c() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.b.a().b().c()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z && UtilHelper.isNetOk()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.a.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.a.sendBroadcast("action_update_progress_interrupted", true);
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
                TiebaUpdateService tiebaUpdateService = this.a;
                str = this.a.mMainApkFileName;
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
        this.a.mDowndMainApkTask = null;
        this.c = true;
        if (this.b != null) {
            this.b.f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        Handler handler;
        Handler handler2;
        String str;
        super.onPostExecute(bool);
        this.a.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.a.mIsMainApkDone = true;
                handler = this.a.mMainApkHandler;
                handler2 = this.a.mMainApkHandler;
                str = this.a.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
