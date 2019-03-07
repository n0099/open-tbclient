package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.lcs.a;
/* loaded from: classes.dex */
public class GuardServiceWatcher extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            TiebaStatic.log("c12662");
            a.c(0, 0, 0, 1, 5);
            BdSocketLinkService.startService(false, "restart");
            return 2;
        } catch (Throwable th) {
            return 2;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
