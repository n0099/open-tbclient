package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f1712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TiebaUpdateService tiebaUpdateService) {
        this.f1712a = tiebaUpdateService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        VersionData versionData;
        boolean z;
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        super.handleMessage(message);
        if (message.what == 900002) {
            notification = this.f1712a.c;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.f1712a.c;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.f1712a.c;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.f1712a.b;
                notification4 = this.f1712a.c;
                notificationManager.notify(10, notification4);
            }
        } else if (message.what == 1 && (versionData = (VersionData) message.obj) != null) {
            z = this.f1712a.i;
            if (!z) {
                this.f1712a.i = true;
                return;
            }
            am.b(TiebaApplication.f(), versionData.getNew_file());
            if (this.f1712a.f1692a != null && this.f1712a.f1692a.length() > 4) {
                TiebaApplication.f().i(this.f1712a.f1692a);
            }
            this.f1712a.stopSelf();
        }
    }
}
