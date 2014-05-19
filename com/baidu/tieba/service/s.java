package com.baidu.tieba.service;

import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.data.VersionData;
import java.io.File;
/* loaded from: classes.dex */
class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private String b;
    private al c = null;
    private volatile boolean d = false;

    public s(TiebaUpdateService tiebaUpdateService, String str) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00da, code lost:
        r0 = r7.a.s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e0, code lost:
        if (r0 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e2, code lost:
        r7.a.i = true;
        r0 = r7.a.u;
        r2 = r7.a.u;
        r4 = r7.a.e;
        r0.sendMessageDelayed(r2.obtainMessage(1, r4), 100);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0104, code lost:
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
        File e2;
        Handler handler;
        boolean z;
        long j;
        Boolean bool2 = false;
        while (true) {
            try {
                if (this.d) {
                    break;
                }
                this.c = new al(this.b);
                handler = this.a.v;
                bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.a.a) + ".tmp", handler, 900003));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.d() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.c.a().b().c()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e3) {
                        }
                    }
                    z = this.a.t;
                    if (z && UtilHelper.isNetOk()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.a.r;
                        if (currentTimeMillis - j > 20000) {
                            break;
                        }
                    }
                }
            } catch (Exception e4) {
                bool = bool2;
                e = e4;
            }
        }
        try {
            if (bool.booleanValue()) {
                x.j(this.a.a);
                File d = x.d(String.valueOf(this.a.a) + ".tmp");
                if (d != null && (e2 = x.e(this.a.a)) != null && !d.renameTo(e2)) {
                    BdLog.e(getClass().getName(), "doInBackground", "renameTo error");
                    TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
                }
            }
        } catch (Exception e5) {
            e = e5;
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.f = null;
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        boolean z;
        Handler handler;
        Handler handler2;
        VersionData versionData;
        NotificationManager notificationManager;
        super.onPostExecute(bool);
        this.a.f = null;
        try {
            if (bool.booleanValue()) {
                notificationManager = this.a.b;
                notificationManager.cancel(14);
                this.a.r = System.currentTimeMillis();
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.a.i;
        if (!z) {
            this.a.i = true;
            return;
        }
        handler = this.a.u;
        handler2 = this.a.u;
        versionData = this.a.e;
        handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
    }
}
