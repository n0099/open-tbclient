package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, Boolean> {
    private aa OE;
    private volatile boolean ayP;
    final /* synthetic */ TiebaUpdateService cdF;

    private m(TiebaUpdateService tiebaUpdateService) {
        this.cdF = tiebaUpdateService;
        this.ayP = false;
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
        while (!this.ayP) {
            try {
                str2 = this.cdF.mMainApkUrl;
                this.OE = new aa(str2);
                aa aaVar = this.OE;
                str3 = this.cdF.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.cdF.mMainApkHandler;
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
                        j = this.cdF.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.cdF.downloadError();
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
                TiebaUpdateService tiebaUpdateService = this.cdF;
                str = this.cdF.mMainApkFileName;
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
        this.cdF.mDowndMainApkTask = null;
        this.ayP = true;
        if (this.OE != null) {
            this.OE.gS();
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
        this.cdF.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.cdF.mIsMainApkDone = true;
                handler = this.cdF.mMainApkHandler;
                handler2 = this.cdF.mMainApkHandler;
                str = this.cdF.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 300L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
