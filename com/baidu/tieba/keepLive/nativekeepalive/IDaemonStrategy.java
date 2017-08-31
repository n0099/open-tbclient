package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
import com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy21;
import com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy22;
import com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy23;
import com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategyUnder21;
import com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategyXiaomi;
/* loaded from: classes.dex */
public interface IDaemonStrategy {
    void onDaemonAssistantCreate(Context context, DaemonConfigurations daemonConfigurations);

    void onDaemonDead();

    boolean onInitialization(Context context);

    void onPersistentCreate(Context context, DaemonConfigurations daemonConfigurations);

    /* loaded from: classes.dex */
    public static class Fetcher {
        private static IDaemonStrategy mDaemonStrategy;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static IDaemonStrategy fetchStrategy() {
            if (mDaemonStrategy != null) {
                return mDaemonStrategy;
            }
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {
                        mDaemonStrategy = new DaemonStrategyUnder21();
                        break;
                    } else {
                        mDaemonStrategy = new DaemonStrategy21();
                        break;
                    }
                case 22:
                    mDaemonStrategy = new DaemonStrategy22();
                    break;
                case 23:
                    mDaemonStrategy = new DaemonStrategy23();
                    break;
                default:
                    if (Build.MODEL != null && isXiaomiModel()) {
                        mDaemonStrategy = new DaemonStrategyXiaomi();
                        break;
                    } else if (Build.MODEL != null && Build.MODEL.toLowerCase().startsWith("a31")) {
                        mDaemonStrategy = new DaemonStrategy21();
                        break;
                    } else {
                        mDaemonStrategy = new DaemonStrategyUnder21();
                        break;
                    }
                    break;
            }
            return mDaemonStrategy;
        }

        static boolean isXiaomiModel() {
            String lowerCase = Build.MODEL.toLowerCase();
            return lowerCase.startsWith("mi") || lowerCase.startsWith("hm") || lowerCase.startsWith("redmi");
        }
    }
}
