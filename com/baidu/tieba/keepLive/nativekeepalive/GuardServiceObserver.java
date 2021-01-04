package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.lcs.a;
import com.fun.ad.sdk.FunAdConfig;
/* loaded from: classes.dex */
public class GuardServiceObserver extends Service {
    private final long STEP = FunAdConfig.Builder.AD_EXPIRED_INTERVAL;

    public static void startNativeServiceForUnder23(Context context) {
        try {
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
            if (TbadkCoreApplication.getKeepLiveSwitch(context) && context != null) {
                a.d(0, 0, 0, 1, 5);
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
            TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
            a.d(0, 0, 0, 1, 5);
            BdSocketLinkService.startService(false, "restart");
        } catch (Throwable th) {
        }
        return super.onStartCommand(intent, i, i2);
    }
}
