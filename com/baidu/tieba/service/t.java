package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private ae b;
    private volatile boolean c;

    private t(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(TiebaUpdateService tiebaUpdateService, t tVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        r0 = r7.a.mHasTieba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
        if (r0 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
        r0 = r7.a.mHasAs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        r0 = r7.a.mIsMainApkDone;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
        r7.a.sendBroadcast("action_update_progress_interrupted", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        r0 = r1;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        while (true) {
            try {
                if (this.c) {
                    break;
                }
                str2 = this.a.mOtherApkUrl;
                this.b = new ae(str2);
                ae aeVar = this.b;
                str3 = this.a.mOtherApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.a.mOtherApkHandler;
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
                        j = this.a.mOtherTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                bool = bool2;
                e = e3;
            }
        }
        try {
            if (bool.booleanValue()) {
                TiebaUpdateService tiebaUpdateService = this.a;
                str = this.a.mOtherApkFileName;
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
        this.a.mDowndOtherApkTask = null;
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
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        boolean z3;
        super.onPostExecute(bool);
        this.a.mDowndOtherApkTask = null;
        if (bool.booleanValue()) {
            this.a.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
        }
        z = this.a.mHasTieba;
        if (!z) {
            z3 = this.a.mHasAs;
            if (!z3) {
                return;
            }
        }
        z2 = this.a.mMainApkInstallEnable;
        if (!z2) {
            this.a.mMainApkInstallEnable = true;
            return;
        }
        handler = this.a.mOtherApkHandler;
        handler2 = this.a.mOtherApkHandler;
        handler.sendMessageDelayed(handler2.obtainMessage(2, null), 100L);
    }
}
