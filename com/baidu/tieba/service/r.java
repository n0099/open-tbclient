package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.data.VersionData;
import java.io.File;
/* loaded from: classes.dex */
class r extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private VersionData b;
    private al c = null;
    private volatile boolean d = false;

    public r(TiebaUpdateService tiebaUpdateService, VersionData versionData) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = versionData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        Boolean bool;
        Exception e;
        File e2;
        Handler handler;
        boolean z;
        long j;
        Boolean bool2 = false;
        while (!this.d) {
            try {
                this.c = new al(this.b.getUrl());
                handler = this.a.u;
                bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.b.getNewFile()) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
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
                        j = this.a.q;
                        if (currentTimeMillis - j > 20000) {
                            this.a.a("showToast", "other_error");
                            bool = bool2;
                            break;
                        }
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
                x.j(this.b.getNewFile());
                File d = x.d(String.valueOf(this.b.getNewFile()) + ".tmp");
                if (d != null && (e2 = x.e(this.b.getNewFile())) != null && !d.renameTo(e2)) {
                    BdLog.e(getClass().getName(), "doInBackground", "renameTo error");
                    TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingAsyncTask");
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
        this.a.d = null;
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
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.a.d = null;
        try {
            if (bool.booleanValue()) {
                this.a.s = true;
                handler = this.a.u;
                handler2 = this.a.u;
                handler.sendMessageDelayed(handler2.obtainMessage(1, this.b), 100L);
                return;
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.stopSelf();
    }
}
