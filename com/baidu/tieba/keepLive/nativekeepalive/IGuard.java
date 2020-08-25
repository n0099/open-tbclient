package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tieba.keepLive.nativekeepalive.GuardProxy;
/* loaded from: classes2.dex */
public interface IGuard {
    void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations);

    void onDaemonDead();

    boolean onInitialization(Context context);

    void onPersistentCreate(Context context, GuardConfigurations guardConfigurations);

    /* loaded from: classes2.dex */
    public static class Fetcher {
        private static IGuard mDaemonStrategy;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static IGuard fetchGuard() {
            if (mDaemonStrategy != null) {
                return mDaemonStrategy;
            }
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {
                        GuardProxy guardProxy = new GuardProxy();
                        guardProxy.getClass();
                        mDaemonStrategy = new GuardProxy.a();
                        break;
                    } else {
                        GuardProxy guardProxy2 = new GuardProxy();
                        guardProxy2.getClass();
                        mDaemonStrategy = new GuardProxy.b();
                        break;
                    }
                case 22:
                    GuardProxy guardProxy3 = new GuardProxy();
                    guardProxy3.getClass();
                    mDaemonStrategy = new GuardProxy.c();
                    break;
                default:
                    if (Build.MODEL != null && isXiaomiModel()) {
                        GuardProxy guardProxy4 = new GuardProxy();
                        guardProxy4.getClass();
                        mDaemonStrategy = new GuardProxy.d();
                        break;
                    } else if (Build.MODEL != null && Build.MODEL.toLowerCase().startsWith("a31")) {
                        GuardProxy guardProxy5 = new GuardProxy();
                        guardProxy5.getClass();
                        mDaemonStrategy = new GuardProxy.b();
                        break;
                    } else {
                        GuardProxy guardProxy6 = new GuardProxy();
                        guardProxy6.getClass();
                        mDaemonStrategy = new GuardProxy.a();
                        break;
                    }
                    break;
            }
            return mDaemonStrategy;
        }

        static boolean isXiaomiModel() {
            String lowerCase = Build.MODEL.toLowerCase();
            return lowerCase.startsWith(BdStatsConstant.StatsKey.MERGE_ITEM) || lowerCase.startsWith("hm") || lowerCase.startsWith("redmi");
        }
    }
}
