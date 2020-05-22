package com.baidu.tieba.keepLive;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.lcs.a;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
import com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener;
import com.baidu.tieba.keepLive.startActivity.ScreenManager;
import com.baidu.tieba.keepLive.sync.SyncService;
/* loaded from: classes8.dex */
public class KeepLiveUtil {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final String NEEDSHOWNOTIFICATION = "needShowBindSystemNotification";
    private static final String NOTICEACTION = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    public static Context mKeepLiveContext;
    private static ScreenManager screenManager = null;

    public static void startForKeeplive(Context context) {
        new BdAsyncTask<Context, Void, Void>() { // from class: com.baidu.tieba.keepLive.KeepLiveUtil.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public Void doInBackground(Context... contextArr) {
                Context context2;
                try {
                    context2 = contextArr[0];
                    TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
                } catch (Throwable th) {
                }
                if (TbadkCoreApplication.getKeepLiveSwitch(context2)) {
                    if (context2 == null) {
                        context2 = KeepLiveUtil.mKeepLiveContext;
                    }
                    if (context2 != null) {
                        if ((context2 instanceof Activity) || (context2 instanceof Application)) {
                            KeepLiveUtil.mKeepLiveContext = context2;
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            a.d(0, 0, 0, 1, 5);
                            BdSocketLinkService.startService(false, "restart");
                        } else {
                            GuardServiceObserver.startNativeServiceForUnder23(context2);
                        }
                    }
                    return null;
                }
                KeepLiveUtil.reBorn();
                return null;
            }
        }.execute(context);
    }

    public static void startRemoteService() {
        TiebaStatic.log(CommonStatisticKey.KEY_KEEP_LIVE);
        BdSocketLinkService.startService(false, "restart");
    }

    public static void startKeepLiveForBackGroungActivity() {
        if (screenManager == null) {
            screenManager = ScreenManager.getInstance(TbadkCoreApplication.getInst().getBaseContext());
            new ScreenBroadcastListener(TbadkCoreApplication.getInst().getBaseContext()).registerListener(new ScreenBroadcastListener.ScreenStateListener() { // from class: com.baidu.tieba.keepLive.KeepLiveUtil.2
                @Override // com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener.ScreenStateListener
                public void onScreenOn() {
                    KeepLiveUtil.screenManager.finishActivity();
                }

                @Override // com.baidu.tieba.keepLive.startActivity.ScreenBroadcastListener.ScreenStateListener
                public void onScreenOff() {
                    KeepLiveUtil.screenManager.startActivity();
                }
            });
        }
    }

    public static void startOrStopActivityForKeepLive(boolean z) {
        if (screenManager == null) {
            startKeepLiveForBackGroungActivity();
        }
        if (z) {
            screenManager.startActivity();
        } else {
            screenManager.finishActivity();
        }
    }

    public static void reBorn() {
        if (mKeepLiveContext == null) {
            mKeepLiveContext = TbadkCoreApplication.getInst().getApplicationContext();
        }
        if (!ak.isEmui()) {
            SyncService.startAccountSync(mKeepLiveContext.getApplicationContext());
        }
    }
}
