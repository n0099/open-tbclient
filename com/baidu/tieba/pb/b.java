package com.baidu.tieba.pb;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ FileDownloader cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FileDownloader fileDownloader) {
        this.cHJ = fileDownloader;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        super.handleMessage(message);
        if (message.what == 900002) {
            if (message.arg2 > 0) {
                this.cHJ.progress = (int) ((message.arg1 * 100) / message.arg2);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                this.cHJ.schedule = stringBuffer.toString();
                Context baseContext = this.cHJ.getBaseContext();
                int i = this.cHJ.progress;
                str = this.cHJ.schedule;
                str2 = this.cHJ.mInfo;
                NotificationHelper.showProgressNotification(baseContext, 10, null, i, str, str2, true);
            }
        } else if (message.what == 1) {
            UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), (String) message.obj);
            this.cHJ.stopSelf();
        }
    }
}
