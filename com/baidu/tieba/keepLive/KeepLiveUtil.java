package com.baidu.tieba.keepLive;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
import com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener;
import com.baidu.tieba.keepLive.startActivity.ScreenManager;
import com.baidu.tieba.keepLive.sync.SyncService;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
/* loaded from: classes2.dex */
public class KeepLiveUtil {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final String NEEDSHOWNOTIFICATION = "needShowBindSystemNotification";
    private static final String NOTICEACTION = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    public static Context mKeepLiveContext;
    private static ScreenManager screenManager = null;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x002e -> B:21:0x0025). Please submit an issue!!! */
    public static void startForKeeplive(Context context) {
        if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
            if (context == null) {
                context = mKeepLiveContext;
            }
            if (context != null) {
                if ((context instanceof Activity) || (context instanceof Application)) {
                    mKeepLiveContext = context;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        BdSocketLinkService.startService(false, "restart");
                    } else {
                        GuardServiceObserver.startNativeServiceForUnder23(context);
                    }
                } catch (Throwable th) {
                    BdSocketLinkService.startService(false, "restart");
                }
            } else {
                return;
            }
        }
        reBorn();
    }

    public static void startRemoteService() {
        BdSocketLinkService.startService(false, "restart");
    }

    public static void startKeepLiveForBackGroungActivity() {
        if (screenManager == null) {
            screenManager = ScreenManager.getInstance(TbadkCoreApplication.getInst().getBaseContext());
            new ScreenBroadcastListener(TbadkCoreApplication.getInst().getBaseContext()).registerListener(new ScreenBroadcastListener.ScreenStateListener() { // from class: com.baidu.tieba.keepLive.KeepLiveUtil.1
                @Override // com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener.ScreenStateListener
                public void onScreenOn() {
                }

                @Override // com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener.ScreenStateListener
                public void onScreenOff() {
                }
            });
        }
    }

    public static void startOrStopActivityForKeepLive(boolean z) {
        if (screenManager == null) {
            startKeepLiveForBackGroungActivity();
        }
        if (z) {
        }
    }

    public static void reBorn() {
        if (mKeepLiveContext == null) {
            mKeepLiveContext = TbadkCoreApplication.getInst().getApplicationContext();
        }
        if (!RomTypeUtil.isEmui()) {
            SyncService.startAccountSync(mKeepLiveContext.getApplicationContext());
        }
    }
}
