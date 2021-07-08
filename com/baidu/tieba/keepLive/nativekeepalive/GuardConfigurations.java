package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GuardConfigurations {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DaemonConfiguration DAEMON_ASSISTANT_CONFIG;
    public final DaemonListener LISTENER;
    public final DaemonConfiguration PERSISTENT_CONFIG;

    /* loaded from: classes4.dex */
    public static class DaemonConfiguration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String PROCESS_NAME;
        public final String RECEIVER_NAME;
        public final String SERVICE_NAME;

        public DaemonConfiguration(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.PROCESS_NAME = str;
            this.SERVICE_NAME = str2;
            this.RECEIVER_NAME = str3;
        }
    }

    /* loaded from: classes4.dex */
    public interface DaemonListener {
        void onDaemonAssistantStart(Context context);

        void onPersistentStart(Context context);

        void onWatchDaemonDaed();
    }

    public GuardConfigurations(DaemonConfiguration daemonConfiguration, DaemonConfiguration daemonConfiguration2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {daemonConfiguration, daemonConfiguration2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.PERSISTENT_CONFIG = daemonConfiguration;
        this.DAEMON_ASSISTANT_CONFIG = daemonConfiguration2;
        this.LISTENER = null;
    }

    public GuardConfigurations(DaemonConfiguration daemonConfiguration, DaemonConfiguration daemonConfiguration2, DaemonListener daemonListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {daemonConfiguration, daemonConfiguration2, daemonListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.PERSISTENT_CONFIG = daemonConfiguration;
        this.DAEMON_ASSISTANT_CONFIG = daemonConfiguration2;
        this.LISTENER = daemonListener;
    }
}
