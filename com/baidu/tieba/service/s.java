package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        boolean z;
        Handler handler;
        Handler handler2;
        VersionData versionData;
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        super.handleMessage(message);
        if (message.what == 900003) {
            notification = this.a.d;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.a.d;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.a.d;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.a.b;
                notification4 = this.a.d;
                notificationManager.notify(14, notification4);
            }
        } else if (message.what == 2) {
            str = this.a.i;
            if (str != null) {
                str2 = this.a.i;
                if (str2.length() > 0) {
                    z = this.a.j;
                    if (!z) {
                        this.a.j = true;
                        return;
                    }
                    handler = this.a.k;
                    handler2 = this.a.k;
                    versionData = this.a.f;
                    handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
                }
            }
        }
    }
}
