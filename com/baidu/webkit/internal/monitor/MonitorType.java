package com.baidu.webkit.internal.monitor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes11.dex */
public class MonitorType implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MONITOR_TYPE_AD = 24577;
    public static final int MONITOR_TYPE_ADD_JAVA_SCRIPT = 12320;
    public static final int MONITOR_TYPE_DOWNLOAD_WEBKIT = 12324;
    public static final int MONITOR_TYPE_INIT_WEBKIT = 12323;
    public static final int MONITOR_TYPE_SEARCH_FPS = 12335;
    public static final int MONITOR_TYPE_STARTUP_TIMING = 12300;
    public static final String SERVER_TYPE_SAILOR_MONITOR = "sailor_monitor";
    public transient /* synthetic */ FieldHolder $fh;

    public MonitorType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
