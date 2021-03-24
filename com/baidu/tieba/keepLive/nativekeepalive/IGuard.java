package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
import com.baidu.tieba.keepLive.nativekeepalive.GuardProxy;
/* loaded from: classes.dex */
public interface IGuard {

    /* loaded from: classes.dex */
    public static class Fetcher {
        public static IGuard mDaemonStrategy;

        public static IGuard fetchGuard() {
            IGuard iGuard = mDaemonStrategy;
            if (iGuard != null) {
                return iGuard;
            }
            int i = Build.VERSION.SDK_INT;
            if (i != 21) {
                if (i != 22) {
                    if (Build.MODEL != null && isXiaomiModel()) {
                        GuardProxy guardProxy = new GuardProxy();
                        guardProxy.getClass();
                        mDaemonStrategy = new GuardProxy.d();
                    } else {
                        String str = Build.MODEL;
                        if (str != null && str.toLowerCase().startsWith("a31")) {
                            GuardProxy guardProxy2 = new GuardProxy();
                            guardProxy2.getClass();
                            mDaemonStrategy = new GuardProxy.b();
                        } else {
                            GuardProxy guardProxy3 = new GuardProxy();
                            guardProxy3.getClass();
                            mDaemonStrategy = new GuardProxy.a(guardProxy3);
                        }
                    }
                } else {
                    GuardProxy guardProxy4 = new GuardProxy();
                    guardProxy4.getClass();
                    mDaemonStrategy = new GuardProxy.c();
                }
            } else if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {
                GuardProxy guardProxy5 = new GuardProxy();
                guardProxy5.getClass();
                mDaemonStrategy = new GuardProxy.a(guardProxy5);
            } else {
                GuardProxy guardProxy6 = new GuardProxy();
                guardProxy6.getClass();
                mDaemonStrategy = new GuardProxy.b();
            }
            return mDaemonStrategy;
        }

        public static boolean isXiaomiModel() {
            String lowerCase = Build.MODEL.toLowerCase();
            return lowerCase.startsWith("mi") || lowerCase.startsWith("hm") || lowerCase.startsWith("redmi");
        }
    }

    void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations);

    void onDaemonDead();

    boolean onInitialization(Context context);

    void onPersistentCreate(Context context, GuardConfigurations guardConfigurations);
}
