package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.c0.a;
/* loaded from: classes4.dex */
public class GuardServiceObserver extends Service {
    public final long STEP = 900000;

    public static void startNativeServiceForUnder23(Context context) {
        try {
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
            if (!TbadkCoreApplication.getKeepLiveSwitch(context) || context == null) {
                return;
            }
            a.b(0, 0, 0, 1, 5);
            context.startService(new Intent(context, GuardServiceObserver.class));
        } catch (Throwable unused) {
            BdSocketLinkService.startService(false, "restart");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
            a.b(0, 0, 0, 1, 5);
            BdSocketLinkService.startService(false, "restart");
        } catch (Throwable unused) {
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
