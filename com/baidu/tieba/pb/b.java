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
    private final String SD;
    final /* synthetic */ FileDownloader bFD;
    private final String mUrl;
    private aa Ok = null;
    private volatile boolean wb = false;

    public b(FileDownloader fileDownloader, String str, String str2) {
        this.bFD = fileDownloader;
        this.mUrl = str;
        this.SD = str2;
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
                this.Ok = new aa(this.mUrl);
                handler = this.bFD.handler;
                bool = Boolean.valueOf(this.Ok.a(String.valueOf(this.SD) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.Ok.st() == -2) {
                    break;
                } else if (!this.Ok.sp().tq().hi()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            o.cs(this.SD);
            File cm = o.cm(String.valueOf(this.SD) + ".tmp");
            if (cm != null && (cn = o.cn(this.SD)) != null) {
                cm.renameTo(cn);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.bFD.mDowndingTask = null;
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
        int i;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.bFD.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.bFD.getBaseContext(), 10);
            handler = this.bFD.handler;
            handler2 = this.bFD.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.SD), 100L);
            return;
        }
        Context baseContext = this.bFD.getBaseContext();
        i = this.bFD.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.bFD.getString(y.error_sd_error), false);
        this.bFD.stopSelf();
    }
}
