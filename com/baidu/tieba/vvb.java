package com.baidu.tieba;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class vvb {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255655, "Lcom/baidu/tieba/vvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255655, "Lcom/baidu/tieba/vvb;");
                return;
            }
        }
        a = new String[]{DownloadStatisticConstants.UBC_VALUE_UNKNOW, "idle", "preparing", DpStatConstants.KEY_PREPARED, "ready", "loading", "playing", "paused", "ended", "invalid"};
    }
}
