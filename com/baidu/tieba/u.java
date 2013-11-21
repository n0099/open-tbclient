package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FileDownloader f2443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FileDownloader fileDownloader) {
        this.f2443a = fileDownloader;
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
            notification = this.f2443a.b;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.f2443a.b;
                notification2.contentView.setProgressBar(R.id.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.f2443a.b;
                notification3.contentView.setTextViewText(R.id.schedule, stringBuffer);
                notificationManager = this.f2443a.f999a;
                notification4 = this.f2443a.b;
                notificationManager.notify(10, notification4);
            }
        } else if (message.what == 1) {
            UtilHelper.b(TiebaApplication.g(), (String) message.obj);
            this.f2443a.stopSelf();
        }
    }
}
