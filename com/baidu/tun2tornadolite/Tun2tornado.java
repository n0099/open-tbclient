package com.baidu.tun2tornadolite;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.Engine;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0019J\u0016\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0019J\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J&\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/tun2tornadolite/Tun2tornado;", "", "()V", "ENV_CHANNEL_NAME", "", "ENV_CLIENT_VERSION", "ENV_CUID", "ENV_SYSTEM_VERSION", "ENV_TOKEN", "EVENT_LOG_DEBUG", "", "EVENT_LOG_ERROR", "EVENT_LOG_INFO", "NETWORK_AUTO", "NETWORK_CELLULER", "NETWORK_OTHER", "NETWORK_VPN", "NETWORK_WIFI", "init", "", "onEvent", "eventCode", "tag", "msg", "prepare", "", "sClientList", "", "setDebug", "b", "setEnv", "name", "value", "setLog", "setNetworkAvailable", FpsTracer.UBC_KEY_NET_TYPE, "isAvailable", "setNetworkSwitchTo", "setOperationInterface", "ai", "Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "start", "tunfd", "", "region", "gameID", "gamePackageName", IntentConfig.STOP, "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Tun2tornado {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENV_CHANNEL_NAME = "CHANNEL_NAME";
    public static final String ENV_CLIENT_VERSION = "CLIENT_VERSION";
    public static final String ENV_CUID = "CUID";
    public static final String ENV_SYSTEM_VERSION = "SYSTEM_VERSION";
    public static final String ENV_TOKEN = "TOKEN";
    public static final long EVENT_LOG_DEBUG = 0;
    public static final long EVENT_LOG_ERROR = 2;
    public static final long EVENT_LOG_INFO = 1;
    public static final Tun2tornado INSTANCE;
    public static final long NETWORK_AUTO = 0;
    public static final long NETWORK_CELLULER = 2;
    public static final long NETWORK_OTHER = 3;
    public static final long NETWORK_VPN = 4;
    public static final long NETWORK_WIFI = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1678508470, "Lcom/baidu/tun2tornadolite/Tun2tornado;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1678508470, "Lcom/baidu/tun2tornadolite/Tun2tornado;");
                return;
            }
        }
        INSTANCE = new Tun2tornado();
    }

    public Tun2tornado() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Engine.INSTANCE.init();
        }
    }

    public final void onEvent(long j, String tag, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), tag, msg}) == null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (j == 0) {
                LogTo.INSTANCE.d(tag, msg);
            } else if (j == 1) {
                LogTo.INSTANCE.i(tag, msg);
            } else if (j == 2) {
                LogTo.INSTANCE.e(tag, msg);
            }
        }
    }

    public final boolean prepare(List<String> sClientList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sClientList)) == null) {
            Intrinsics.checkNotNullParameter(sClientList, "sClientList");
            return Engine.INSTANCE.prepare(sClientList);
        }
        return invokeL.booleanValue;
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            TornadoLiteRuntime.INSTANCE.setDebug(z);
        }
    }

    public final boolean setEnv(String name, String value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, name, value)) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            switch (name.hashCode()) {
                case -2029438873:
                    if (name.equals(ENV_CHANNEL_NAME)) {
                        TornadoLiteRuntime.INSTANCE.setChannel$tun2tornadolite_release(value);
                        return true;
                    }
                    return true;
                case -1127606616:
                    if (name.equals(ENV_SYSTEM_VERSION)) {
                        TornadoLiteRuntime.INSTANCE.setSysVersion$tun2tornadolite_release(value);
                        return true;
                    }
                    return true;
                case 2080013:
                    if (name.equals("CUID")) {
                        TornadoLiteRuntime.INSTANCE.setCuid$tun2tornadolite_release(value);
                        return true;
                    }
                    return true;
                case 80003545:
                    if (name.equals(ENV_TOKEN)) {
                        TornadoLiteRuntime.INSTANCE.setToken$tun2tornadolite_release(value);
                        return true;
                    }
                    return true;
                case 543374404:
                    if (name.equals(ENV_CLIENT_VERSION)) {
                        TornadoLiteRuntime.INSTANCE.setClientVersion$tun2tornadolite_release(value);
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void setLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LogTo.INSTANCE.setDebug(z);
        }
    }

    public final void setNetworkAvailable(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
        }
    }

    public final long setNetworkSwitchTo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            return 0L;
        }
        return invokeJ.longValue;
    }

    public final void setOperationInterface(AndroidOperationInterface ai) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ai) == null) {
            Intrinsics.checkNotNullParameter(ai, "ai");
            Engine.INSTANCE.setAi(ai);
        }
    }

    public final void start(int i, String region, String gameID, String gamePackageName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), region, gameID, gamePackageName}) == null) {
            Intrinsics.checkNotNullParameter(region, "region");
            Intrinsics.checkNotNullParameter(gameID, "gameID");
            Intrinsics.checkNotNullParameter(gamePackageName, "gamePackageName");
            Engine.INSTANCE.start(i, region, gameID, gamePackageName);
        }
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Engine.INSTANCE.stop();
        }
    }
}
