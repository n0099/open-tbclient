package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.data.VersionData;
import java.io.File;
/* loaded from: classes.dex */
final class r extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private VersionData b;
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
        Handler handler;
        Handler handler2;
        Boolean bool2 = bool;
        super.a((r) bool2);
        this.a.d = null;
        try {
            if (bool2.booleanValue()) {
                this.a.s = true;
                handler = this.a.t;
                handler2 = this.a.t;
                handler.sendMessageDelayed(handler2.obtainMessage(1, this.b), 100L);
                return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.stopSelf();
    }

    public r(TiebaUpdateService tiebaUpdateService, VersionData versionData) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = versionData;
    }

    private Boolean a() {
        Boolean bool;
        Exception e;
        File e2;
        Handler handler;
        long j;
        Boolean bool2 = false;
        this.a.q = System.currentTimeMillis();
        while (!this.d) {
            try {
                this.c = new ak(this.b.getUrl());
                handler = this.a.t;
                bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.b.getNew_file()) + ".tmp", handler, 900002));
                if (bool2.booleanValue() || this.c.d() == -2) {
                    break;
                }
                if (!this.c.a().b().c()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e3) {
                    }
                }
                if (!this.c.a().b().a()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.a.q;
                    if (currentTimeMillis - j > 10000) {
                        this.a.a("showToast", "other_error");
                        bool = bool2;
                        break;
                    }
                }
            } catch (Exception e4) {
                bool = bool2;
                e = e4;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                w.j(this.b.getNew_file());
                File d = w.d(String.valueOf(this.b.getNew_file()) + ".tmp");
                if (d != null && (e2 = w.e(this.b.getNew_file())) != null && !d.renameTo(e2)) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "renameTo error");
                    TiebaStatic.a("renameTo erro", "TiebaUpdateService.DownLoadingAsyncTask");
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
        this.a.d = null;
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
    }
}
