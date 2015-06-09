package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, Boolean> {
    private aa OE;
    private volatile boolean ayQ;
    final /* synthetic */ TiebaUpdateService cdG;

    private n(TiebaUpdateService tiebaUpdateService) {
        this.cdG = tiebaUpdateService;
        this.OE = null;
        this.ayQ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(TiebaUpdateService tiebaUpdateService, n nVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
        r0 = r7.cdG.mHasTieba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
        if (r0 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
        r0 = r7.cdG.mHasAs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
        r0 = r7.cdG.mIsMainApkDone;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a8, code lost:
        r7.cdG.downloadError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        r0 = r1;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
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
                if (this.ayQ) {
                    break;
                }
                str2 = this.cdG.mOtherApkUrl;
                this.OE = new aa(str2);
                aa aaVar = this.OE;
                str3 = this.cdG.mOtherApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.cdG.mOtherApkHandler;
                bool2 = Boolean.valueOf(aaVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.OE.tb() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.OE.sX().tT().gT()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.cdG.mOtherTaskWaitingTimestamp;
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
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                TiebaUpdateService tiebaUpdateService = this.cdG;
                str = this.cdG.mOtherApkFileName;
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
        boolean z;
        boolean z2;
        super.cancel(true);
        this.cdG.mDowndOtherApkTask = null;
        this.ayQ = true;
        if (this.OE != null) {
            this.OE.gS();
        }
        z = this.cdG.mHasTieba;
        if (!z) {
            z2 = this.cdG.mHasAs;
            if (!z2) {
                TiebaUpdateService.sHasStart = false;
                this.cdG.stopSelf();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        boolean z3;
        super.onPostExecute(bool);
        this.cdG.mDowndOtherApkTask = null;
        if (bool.booleanValue()) {
            this.cdG.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
        }
        z = this.cdG.mHasTieba;
        if (!z) {
            z3 = this.cdG.mHasAs;
            if (!z3) {
                TiebaUpdateService.sHasStart = false;
                this.cdG.stopSelf();
                return;
            }
        }
        z2 = this.cdG.mMainApkInstallEnable;
        if (!z2) {
            this.cdG.mMainApkInstallEnable = true;
            return;
        }
        handler = this.cdG.mOtherApkHandler;
        handler2 = this.cdG.mOtherApkHandler;
        handler.sendMessageDelayed(handler2.obtainMessage(2, null), 300L);
    }
}
