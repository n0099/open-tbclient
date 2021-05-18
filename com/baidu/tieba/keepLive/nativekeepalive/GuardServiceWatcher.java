package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.j0.c0.a;
/* loaded from: classes4.dex */
public class GuardServiceWatcher extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
            a.b(0, 0, 0, 1, 5);
            BdSocketLinkService.startService(false, "restart");
            return 2;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
