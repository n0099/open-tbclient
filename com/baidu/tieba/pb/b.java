package com.baidu.tieba.pb;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
class b extends BdAsyncTask<String, Integer, Boolean> {
    private final String To;
    final /* synthetic */ FileDownloader bIy;
    private final String mUrl;
    private aa OE = null;
    private volatile boolean ayP = false;

    public b(FileDownloader fileDownloader, String str, String str2) {
        this.bIy = fileDownloader;
        this.mUrl = str;
        this.To = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        File cC;
        Handler handler;
        Boolean bool = false;
        while (!this.ayP) {
            try {
                this.OE = new aa(this.mUrl);
                handler = this.bIy.handler;
                bool = Boolean.valueOf(this.OE.a(String.valueOf(this.To) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.OE.tb() == -2) {
                    break;
                } else if (!this.OE.sX().tT().gT()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            o.cH(this.To);
            File cB = o.cB(String.valueOf(this.To) + ".tmp");
            if (cB != null && (cC = o.cC(this.To)) != null) {
                cB.renameTo(cC);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.bIy.mDowndingTask = null;
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
        int i;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.bIy.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.bIy.getBaseContext(), 10);
            handler = this.bIy.handler;
            handler2 = this.bIy.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.To), 100L);
            return;
        }
        Context baseContext = this.bIy.getBaseContext();
        i = this.bIy.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.bIy.getString(t.error_sd_error), false);
        this.bIy.stopSelf();
    }
}
