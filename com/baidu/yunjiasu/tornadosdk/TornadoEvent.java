package com.baidu.yunjiasu.tornadosdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoEvent;", "", "(Ljava/lang/String;I)V", "EVENT_BOOSTER_START_OK", "EVENT_BOOSTER_START_FAIL", "EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID", "EVENT_BOOSTER_STOP", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TornadoEvent {
    public static final /* synthetic */ TornadoEvent[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TornadoEvent EVENT_BOOSTER_START_FAIL;
    public static final TornadoEvent EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID;
    public static final TornadoEvent EVENT_BOOSTER_START_OK;
    public static final TornadoEvent EVENT_BOOSTER_STOP;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ TornadoEvent[] $values() {
        return new TornadoEvent[]{EVENT_BOOSTER_START_OK, EVENT_BOOSTER_START_FAIL, EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID, EVENT_BOOSTER_STOP};
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1725195397, "Lcom/baidu/yunjiasu/tornadosdk/TornadoEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1725195397, "Lcom/baidu/yunjiasu/tornadosdk/TornadoEvent;");
                return;
            }
        }
        EVENT_BOOSTER_START_OK = new TornadoEvent("EVENT_BOOSTER_START_OK", 0);
        EVENT_BOOSTER_START_FAIL = new TornadoEvent("EVENT_BOOSTER_START_FAIL", 1);
        EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID = new TornadoEvent("EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID", 2);
        EVENT_BOOSTER_STOP = new TornadoEvent("EVENT_BOOSTER_STOP", 3);
        $VALUES = $values();
    }

    public TornadoEvent(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }

    public static TornadoEvent valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TornadoEvent) Enum.valueOf(TornadoEvent.class, str) : (TornadoEvent) invokeL.objValue;
    }

    public static TornadoEvent[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TornadoEvent[]) $VALUES.clone() : (TornadoEvent[]) invokeV.objValue;
    }
}
