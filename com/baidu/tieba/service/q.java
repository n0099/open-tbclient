package com.baidu.tieba.service;

import android.app.Notification;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
final class q extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        String str2;
        boolean z;
        Handler handler;
        Handler handler2;
        VersionData versionData;
        Notification notification;
        long j;
        boolean z2;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        super.handleMessage(message);
        if (message.what == 900003) {
            notification = this.a.c;
            if (notification != null && message.arg2 > 0) {
                j = this.a.m;
                if (message.arg2 > j) {
                    this.a.r = System.currentTimeMillis();
                }
                this.a.m = message.arg1;
                this.a.k = message.arg2;
                int i = (int) ((message.arg1 * 100) / message.arg2);
                z2 = this.a.n;
                if (z2) {
                    j2 = this.a.j;
                    j3 = this.a.l;
                    if (j2 == j3) {
                        TiebaUpdateService tiebaUpdateService = this.a;
                        j4 = this.a.j;
                        j5 = this.a.m;
                        long j8 = j4 + j5;
                        j6 = this.a.j;
                        j7 = this.a.k;
                        TiebaUpdateService.a(tiebaUpdateService, j8, j6 + j7);
                        this.a.a(i);
                    }
                }
            }
        } else if (message.what == 2) {
            str = this.a.h;
            if (str != null) {
                str2 = this.a.h;
                if (str2.length() > 0) {
                    z = this.a.i;
                    if (!z) {
                        this.a.i = true;
                        return;
                    }
                    handler = this.a.u;
                    handler2 = this.a.u;
                    versionData = this.a.e;
                    handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
                }
            }
        }
    }
}
