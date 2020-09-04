package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
/* loaded from: classes.dex */
public class GuardConfigurations {
    public final DaemonConfiguration DAEMON_ASSISTANT_CONFIG;
    public final DaemonListener LISTENER;
    public final DaemonConfiguration PERSISTENT_CONFIG;

    /* loaded from: classes.dex */
    public interface DaemonListener {
        void onDaemonAssistantStart(Context context);

        void onPersistentStart(Context context);

        void onWatchDaemonDaed();
    }

    public GuardConfigurations(DaemonConfiguration daemonConfiguration, DaemonConfiguration daemonConfiguration2) {
        this.PERSISTENT_CONFIG = daemonConfiguration;
        this.DAEMON_ASSISTANT_CONFIG = daemonConfiguration2;
        this.LISTENER = null;
    }

    public GuardConfigurations(DaemonConfiguration daemonConfiguration, DaemonConfiguration daemonConfiguration2, DaemonListener daemonListener) {
        this.PERSISTENT_CONFIG = daemonConfiguration;
        this.DAEMON_ASSISTANT_CONFIG = daemonConfiguration2;
        this.LISTENER = daemonListener;
    }

    /* loaded from: classes.dex */
    public static class DaemonConfiguration {
        public final String PROCESS_NAME;
        public final String RECEIVER_NAME;
        public final String SERVICE_NAME;

        public DaemonConfiguration(String str, String str2, String str3) {
            this.PROCESS_NAME = str;
            this.SERVICE_NAME = str2;
            this.RECEIVER_NAME = str3;
        }
    }
}
