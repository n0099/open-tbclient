package com.baidu.yunjiasu.tornadosdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u0011H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoRuntime;", "", "()V", "dataLatency", "", "getDataLatency", "()Ljava/lang/Long;", "setDataLatency", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "dataLoss", "getDataLoss", "setDataLoss", "dataOptimizeRate", "getDataOptimizeRate", "setDataOptimizeRate", "gameID", "", "getGameID", "()Ljava/lang/String;", "setGameID", "(Ljava/lang/String;)V", "gamePackage", "getGamePackage", "setGamePackage", "gameRegion", "getGameRegion", "setGameRegion", CommandMessage.SDK_VERSION, "getSdkVersion", "setSdkVersion", FetchLog.START_TIME, "getStartTime", "setStartTime", "state", "Lcom/baidu/yunjiasu/tornadosdk/TornadoState;", "getState", "()Lcom/baidu/yunjiasu/tornadosdk/TornadoState;", "setState", "(Lcom/baidu/yunjiasu/tornadosdk/TornadoState;)V", "reset", "", "toString", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class TornadoRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final TornadoRuntime INSTANCE;
    public static Long dataLatency;
    public static Long dataLoss;
    public static Long dataOptimizeRate;
    public static String gameID;
    public static String gamePackage;
    public static String gameRegion;
    public static String sdkVersion;
    public static Long startTime;
    public static TornadoState state;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(501720957, "Lcom/baidu/yunjiasu/tornadosdk/TornadoRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(501720957, "Lcom/baidu/yunjiasu/tornadosdk/TornadoRuntime;");
                return;
            }
        }
        INSTANCE = new TornadoRuntime();
        state = TornadoState.STATE_UNINIT;
        sdkVersion = "1.0.0";
    }

    public TornadoRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Long getDataLatency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? dataLatency : (Long) invokeV.objValue;
    }

    public final Long getDataLoss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dataLoss : (Long) invokeV.objValue;
    }

    public final Long getDataOptimizeRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? dataOptimizeRate : (Long) invokeV.objValue;
    }

    public final String getGameID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? gameID : (String) invokeV.objValue;
    }

    public final String getGamePackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? gamePackage : (String) invokeV.objValue;
    }

    public final String getGameRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? gameRegion : (String) invokeV.objValue;
    }

    public final String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? sdkVersion : (String) invokeV.objValue;
    }

    public final Long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? startTime : (Long) invokeV.objValue;
    }

    public final TornadoState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? state : (TornadoState) invokeV.objValue;
    }

    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            gameID = null;
            gamePackage = null;
            gameRegion = null;
            dataLoss = null;
            dataLatency = null;
            dataOptimizeRate = null;
        }
    }

    public final void setDataLatency(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, l) == null) {
            dataLatency = l;
        }
    }

    public final void setDataLoss(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l) == null) {
            dataLoss = l;
        }
    }

    public final void setDataOptimizeRate(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l) == null) {
            dataOptimizeRate = l;
        }
    }

    public final void setGameID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            gameID = str;
        }
    }

    public final void setGamePackage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            gamePackage = str;
        }
    }

    public final void setGameRegion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            gameRegion = str;
        }
    }

    public final void setSdkVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            sdkVersion = str;
        }
    }

    public final void setStartTime(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, l) == null) {
            startTime = l;
        }
    }

    public final void setState(TornadoState tornadoState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tornadoState) == null) {
            Intrinsics.checkNotNullParameter(tornadoState, "<set-?>");
            state = tornadoState;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "sdkVersion:" + sdkVersion + " gameID:" + ((Object) gameID) + " gamePackage:" + ((Object) gamePackage) + " gameRegion:" + ((Object) gameRegion);
        }
        return (String) invokeV.objValue;
    }
}
