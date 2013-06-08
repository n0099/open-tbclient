package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bg;
import com.baidu.tieba.d.ag;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        super.handleMessage(message);
        if (message.what == 900002) {
            notification = this.a.b;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.a.b;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                notification3 = this.a.b;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.a.a;
                notification4 = this.a.b;
                notificationManager.notify(10, notification4);
            }
        } else if (message.what == 1) {
            bg bgVar = (bg) message.obj;
            if (bgVar != null) {
                ag.b(TiebaApplication.d(), bgVar.f());
            }
            this.a.stopSelf();
        }
    }
}
