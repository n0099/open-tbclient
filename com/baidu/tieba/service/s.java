package com.baidu.tieba.service;

import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.data.VersionData;
import java.io.File;
/* loaded from: classes.dex */
final class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private String b;
    private ak c = null;
    private volatile boolean d = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        boolean z;
        Handler handler;
        Handler handler2;
        VersionData versionData;
        NotificationManager notificationManager;
        Boolean bool2 = bool;
        super.a((s) bool2);
        this.a.f = null;
        try {
            if (bool2.booleanValue()) {
                notificationManager = this.a.b;
                notificationManager.cancel(14);
                this.a.r = System.currentTimeMillis();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
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

    public s(TiebaUpdateService tiebaUpdateService, String str) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
        r0 = r7.a.s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
        if (r0 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
        r7.a.i = true;
        r0 = r7.a.u;
        r2 = r7.a.u;
        r4 = r7.a.e;
        r0.sendMessageDelayed(r2.obtainMessage(1, r4), 100);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fb, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Boolean a() {
        Boolean bool;
        Exception e;
        File e2;
        Handler handler;
        boolean z;
        long j;
        Boolean bool2 = false;
        while (true) {
            try {
                if (!this.d) {
                    this.c = new ak(this.b);
                    handler = this.a.v;
                    bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.a.a) + ".tmp", handler, 900003));
                    if (bool2.booleanValue() || this.c.d() == -2) {
                        break;
                    }
                    if (!this.c.a().b().c()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e3) {
                        }
                    }
                    z = this.a.t;
                    if (z && UtilHelper.a()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.a.r;
                        if (currentTimeMillis - j > 20000) {
                            break;
                        }
                    }
                } else {
                    break;
                }
            } catch (Exception e4) {
                bool = bool2;
                e = e4;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                w.j(this.a.a);
                File d = w.d(String.valueOf(this.a.a) + ".tmp");
                if (d != null && (e2 = w.e(this.a.a)) != null && !d.renameTo(e2)) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "renameTo error");
                    TiebaStatic.a("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
                }
            }
        } catch (Exception e5) {
            e = e5;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.f = null;
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
    }
}
