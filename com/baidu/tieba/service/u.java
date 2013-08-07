package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f1713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TiebaUpdateService tiebaUpdateService) {
        this.f1713a = tiebaUpdateService;
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
            notification = this.f1713a.d;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.f1713a.d;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.f1713a.d;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.f1713a.b;
                notification4 = this.f1713a.d;
                notificationManager.notify(14, notification4);
            }
        } else if (message.what == 2) {
            str = this.f1713a.h;
            if (str != null) {
                str2 = this.f1713a.h;
                if (str2.length() > 0) {
                    z = this.f1713a.i;
                    if (!z) {
                        this.f1713a.i = true;
                        return;
                    }
                    handler = this.f1713a.j;
                    handler2 = this.f1713a.j;
                    versionData = this.f1713a.f;
                    handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
                }
            }
        }
    }
}
