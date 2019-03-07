package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.lcs.a;
/* loaded from: classes.dex */
public class GuardServiceObserver extends Service {
    private final long STEP = 900000;

    public static void startNativeServiceForUnder23(Context context) {
        try {
            TiebaStatic.log("c12662");
            if (TbadkCoreApplication.getKeepLiveSwitch(context) && context != null) {
                a.c(0, 0, 0, 1, 5);
                context.startService(new Intent(context, GuardServiceObserver.class));
            }
        } catch (Throwable th) {
            BdSocketLinkService.startService(false, "restart");
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

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
        } catch (Throwable th) {
        }
        return super.onStartCommand(intent, i, i2);
    }
}
