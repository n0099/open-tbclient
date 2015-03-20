package com.baidu.tieba.pb;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
class b extends BdAsyncTask<String, Integer, Boolean> {
    private final String SB;
    final /* synthetic */ FileDownloader bFq;
    private final String mUrl;
    private aa Oi = null;
    private volatile boolean wb = false;

    public b(FileDownloader fileDownloader, String str, String str2) {
        this.bFq = fileDownloader;
        this.mUrl = str;
        this.SB = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        File cn;
        Handler handler;
        Boolean bool = false;
        while (!this.wb) {
            try {
                this.Oi = new aa(this.mUrl);
                handler = this.bFq.handler;
                bool = Boolean.valueOf(this.Oi.a(String.valueOf(this.SB) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.Oi.st() == -2) {
                    break;
                } else if (!this.Oi.sp().tq().hi()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            o.cs(this.SB);
            File cm = o.cm(String.valueOf(this.SB) + ".tmp");
            if (cm != null && (cn = o.cn(this.SB)) != null) {
                cm.renameTo(cn);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.bFq.mDowndingTask = null;
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
        int i;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.bFq.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.bFq.getBaseContext(), 10);
            handler = this.bFq.handler;
            handler2 = this.bFq.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.SB), 100L);
            return;
        }
        Context baseContext = this.bFq.getBaseContext();
        i = this.bFq.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.bFq.getString(y.error_sd_error), false);
        this.bFq.stopSelf();
    }
}
