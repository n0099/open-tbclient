package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
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
            notification = this.a.c;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.a.c;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.a.c;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.a.b;
                notification4 = this.a.c;
                notificationManager.notify(10, notification4);
            }
        } else if (message.what == 1 && (versionData = (VersionData) message.obj) != null) {
            z = this.a.j;
            if (!z) {
                this.a.j = true;
                return;
            }
            UtilHelper.a(TiebaApplication.g().b(), versionData.getNew_file());
            if (this.a.a != null && this.a.a.length() > 4) {
                TiebaApplication.g().k(this.a.a);
            }
            this.a.stopSelf();
        }
    }
}
