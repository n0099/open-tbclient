package com.baidu.tun2tornadolite.booster.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.tun2tornadolite.booster.Engine;
import com.baidu.tun2tornadolite.booster.LogTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0004H\u0000¢\u0006\u0002\bTJ\u001d\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u000fH\u0000¢\u0006\u0002\bTR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R$\u0010'\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R$\u0010*\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u000e\u0010-\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R$\u00107\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R$\u0010:\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R$\u0010=\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R$\u0010@\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R$\u0010C\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0017R$\u0010K\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R$\u0010N\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017¨\u0006V"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/data/TornadoLiteRuntime;", "", "()V", "EVENT_BOOSTER_PREPARE_FAIL", "", "EVENT_BOOSTER_PREPARE_OK", "EVENT_BOOSTER_SCLIENT_EOF", "EVENT_BOOSTER_START_FAIL", "EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID", "EVENT_BOOSTER_START_OK", "EVENT_BOOSTER_STOP", "EVENT_REMOTE_EVENT_CLOSED", "EVENT_SCLIENT_HAND_SHAKE_FAIL", "EVENT_SCLIENT_HAND_SHAKE_OK", "STATE_INIT", "", "STATE_RUNNING", "STATE_STARTING", "<set-?>", "channel", "getChannel", "()Ljava/lang/String;", "setChannel$tun2tornadolite_release", "(Ljava/lang/String;)V", "clientVersion", "getClientVersion", "setClientVersion$tun2tornadolite_release", "cuid", "getCuid", "setCuid$tun2tornadolite_release", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", Config.DEVICE_PART, "getDevice", "setDevice$tun2tornadolite_release", "gameID", "getGameID", "setGameID$tun2tornadolite_release", "gamePackageName", "getGamePackageName", "setGamePackageName$tun2tornadolite_release", "lastEventMsg", "", "latencyFromMClientToSClient", "getLatencyFromMClientToSClient", "()I", "setLatencyFromMClientToSClient$tun2tornadolite_release", "(I)V", "latencyFromSClientToRemote", "getLatencyFromSClientToRemote", "setLatencyFromSClientToRemote$tun2tornadolite_release", "lossRateFromMClientToSClient", "getLossRateFromMClientToSClient", "setLossRateFromMClientToSClient$tun2tornadolite_release", "lossRateFromSClientToRemote", "getLossRateFromSClientToRemote", "setLossRateFromSClientToRemote$tun2tornadolite_release", "optimizationRate", "getOptimizationRate", "setOptimizationRate$tun2tornadolite_release", "region", "getRegion", "setRegion$tun2tornadolite_release", "startTime", "getStartTime", "()J", "setStartTime$tun2tornadolite_release", "(J)V", "status", "getStatus", "setStatus", "sysVersion", "getSysVersion", "setSysVersion$tun2tornadolite_release", "token", "getToken", "setToken$tun2tornadolite_release", "onEvent", "", "event", "onEvent$tun2tornadolite_release", "eventMsg", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TornadoLiteRuntime {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long EVENT_BOOSTER_PREPARE_FAIL = 1;
    public static final long EVENT_BOOSTER_PREPARE_OK = 0;
    public static final long EVENT_BOOSTER_SCLIENT_EOF = 41;
    public static final long EVENT_BOOSTER_START_FAIL = 22;
    public static final long EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID = 23;
    public static final long EVENT_BOOSTER_START_OK = 21;
    public static final long EVENT_BOOSTER_STOP = 31;
    public static final long EVENT_REMOTE_EVENT_CLOSED = 61;
    public static final long EVENT_SCLIENT_HAND_SHAKE_FAIL = 52;
    public static final long EVENT_SCLIENT_HAND_SHAKE_OK = 51;
    public static final TornadoLiteRuntime INSTANCE;
    public static final String STATE_INIT = "INIT";
    public static final String STATE_RUNNING = "RUNNING";
    public static final String STATE_STARTING = "STARTING";
    public static String channel;
    public static String clientVersion;
    public static String cuid;
    public static boolean debug;
    public static String device;
    public static String gameID;
    public static String gamePackageName;
    public static String lastEventMsg;
    public static int latencyFromMClientToSClient;
    public static int latencyFromSClientToRemote;
    public static int lossRateFromMClientToSClient;
    public static int lossRateFromSClientToRemote;
    public static int optimizationRate;
    public static String region;
    public static long startTime;
    public static String status;
    public static String sysVersion;
    public static String token;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1465079839, "Lcom/baidu/tun2tornadolite/booster/data/TornadoLiteRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1465079839, "Lcom/baidu/tun2tornadolite/booster/data/TornadoLiteRuntime;");
                return;
            }
        }
        INSTANCE = new TornadoLiteRuntime();
        status = STATE_INIT;
        optimizationRate = 100;
        channel = "main";
        device = "android";
        cuid = "";
        token = "";
        clientVersion = "";
        sysVersion = "";
        region = "";
        gameID = "";
        gamePackageName = "";
        lastEventMsg = "";
    }

    public TornadoLiteRuntime() {
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

    public final String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return channel;
        }
        return (String) invokeV.objValue;
    }

    public final String getClientVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return clientVersion;
        }
        return (String) invokeV.objValue;
    }

    public final String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return cuid;
        }
        return (String) invokeV.objValue;
    }

    public final boolean getDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return debug;
        }
        return invokeV.booleanValue;
    }

    public final String getDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return device;
        }
        return (String) invokeV.objValue;
    }

    public final String getGameID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return gameID;
        }
        return (String) invokeV.objValue;
    }

    public final String getGamePackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return gamePackageName;
        }
        return (String) invokeV.objValue;
    }

    public final int getLatencyFromMClientToSClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return latencyFromMClientToSClient;
        }
        return invokeV.intValue;
    }

    public final int getLatencyFromSClientToRemote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return latencyFromSClientToRemote;
        }
        return invokeV.intValue;
    }

    public final int getLossRateFromMClientToSClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return lossRateFromMClientToSClient;
        }
        return invokeV.intValue;
    }

    public final int getLossRateFromSClientToRemote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return lossRateFromSClientToRemote;
        }
        return invokeV.intValue;
    }

    public final int getOptimizationRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return optimizationRate;
        }
        return invokeV.intValue;
    }

    public final String getRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return region;
        }
        return (String) invokeV.objValue;
    }

    public final long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return startTime;
        }
        return invokeV.longValue;
    }

    public final String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return status;
        }
        return (String) invokeV.objValue;
    }

    public final String getSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return sysVersion;
        }
        return (String) invokeV.objValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return token;
        }
        return (String) invokeV.objValue;
    }

    public final void onEvent$tun2tornadolite_release(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            onEvent$tun2tornadolite_release(j, "");
        }
    }

    public final void setChannel$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            channel = str;
        }
    }

    public final void setClientVersion$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            clientVersion = str;
        }
    }

    public final void setCuid$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            cuid = str;
        }
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            debug = z;
        }
    }

    public final void setDevice$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            device = str;
        }
    }

    public final void setGameID$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            gameID = str;
        }
    }

    public final void setGamePackageName$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            gamePackageName = str;
        }
    }

    public final void setLatencyFromMClientToSClient$tun2tornadolite_release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            latencyFromMClientToSClient = i;
        }
    }

    public final void setLatencyFromSClientToRemote$tun2tornadolite_release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            latencyFromSClientToRemote = i;
        }
    }

    public final void setLossRateFromMClientToSClient$tun2tornadolite_release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            lossRateFromMClientToSClient = i;
        }
    }

    public final void setLossRateFromSClientToRemote$tun2tornadolite_release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            lossRateFromSClientToRemote = i;
        }
    }

    public final void setOptimizationRate$tun2tornadolite_release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            optimizationRate = i;
        }
    }

    public final void setRegion$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            region = str;
        }
    }

    public final void setStartTime$tun2tornadolite_release(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            startTime = j;
        }
    }

    public final void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            status = str;
        }
    }

    public final void setSysVersion$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            sysVersion = str;
        }
    }

    public final void setToken$tun2tornadolite_release(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            token = str;
        }
    }

    public final void onEvent$tun2tornadolite_release(long j, String eventMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048594, this, j, eventMsg) == null) {
            Intrinsics.checkNotNullParameter(eventMsg, "eventMsg");
            if (j == 0) {
                LogTo.INSTANCE.d("*****", "[OnEvent] EVENT_BOOSTER_PREPARE_OK");
            } else if (j == 1) {
                lastEventMsg = eventMsg;
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_BOOSTER_PREPARE_FAIL ", lastEventMsg));
            } else if (j == 21) {
                LogTo.INSTANCE.d("*****", "[OnEvent] EVENT_BOOSTER_START_OK");
                AndroidOperationInterface ai = Engine.INSTANCE.getAi();
                if (ai != null) {
                    ai.onEvent(j, "");
                }
            } else if (j == 22) {
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_BOOSTER_START_FAIL ", lastEventMsg));
                AndroidOperationInterface ai2 = Engine.INSTANCE.getAi();
                if (ai2 != null) {
                    ai2.onEvent(j, lastEventMsg);
                }
            } else if (j == 23) {
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID ", lastEventMsg));
                AndroidOperationInterface ai3 = Engine.INSTANCE.getAi();
                if (ai3 != null) {
                    ai3.onEvent(j, lastEventMsg);
                }
            } else if (j == 31) {
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_BOOSTER_STOP ", lastEventMsg));
                AndroidOperationInterface ai4 = Engine.INSTANCE.getAi();
                if (ai4 != null) {
                    ai4.onEvent(j, lastEventMsg);
                }
            } else if (j == 41) {
                lastEventMsg = eventMsg;
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_BOOSTER_SCLIENT_EOF ", lastEventMsg));
            } else if (j == 51) {
                LogTo.INSTANCE.d("*****", "[OnEvent] EVENT_SCLIENT_HAND_SHAKE_OK");
            } else if (j == 52) {
                lastEventMsg = eventMsg;
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_SCLIENT_HAND_SHAKE_FAIL ", lastEventMsg));
            } else if (j == 61) {
                lastEventMsg = eventMsg;
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[OnEvent] EVENT_REMOTE_EVENT_CLOSED ", lastEventMsg));
            }
        }
    }
}
