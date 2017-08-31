package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class NativeGuardService1 extends Service {
    private final long STEP = 900000;

    public static void startNativeService(Context context) {
        if (context != null) {
            if (ProcessUtil.isMainProcess(context) || ProcessUtil.isNativeProcess(context)) {
                context.startService(new Intent(context, NativeGuardService1.class));
            }
        }
    }

    public static void startNativeServiceForUnder23(Context context) {
        try {
            if (TbadkCoreApplication.getKeepLiveSwitch(context) && context != null) {
                context.startService(new Intent(context, NativeGuardService1.class));
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
        BdSocketLinkService.startService(false, "restart");
        return super.onStartCommand(intent, i, i2);
    }
}
