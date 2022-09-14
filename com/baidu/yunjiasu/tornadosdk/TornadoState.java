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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoState;", "", "(Ljava/lang/String;I)V", "STATE_UNINIT", "STATE_INIT", "STATE_STARTING", "STATE_RUNNING", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TornadoState {
    public static final /* synthetic */ TornadoState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TornadoState STATE_INIT;
    public static final TornadoState STATE_RUNNING;
    public static final TornadoState STATE_STARTING;
    public static final TornadoState STATE_UNINIT;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ TornadoState[] $values() {
        return new TornadoState[]{STATE_UNINIT, STATE_INIT, STATE_STARTING, STATE_RUNNING};
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1326348188, "Lcom/baidu/yunjiasu/tornadosdk/TornadoState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1326348188, "Lcom/baidu/yunjiasu/tornadosdk/TornadoState;");
                return;
            }
        }
        STATE_UNINIT = new TornadoState("STATE_UNINIT", 0);
        STATE_INIT = new TornadoState("STATE_INIT", 1);
        STATE_STARTING = new TornadoState("STATE_STARTING", 2);
        STATE_RUNNING = new TornadoState("STATE_RUNNING", 3);
        $VALUES = $values();
    }

    public TornadoState(String str, int i) {
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

    public static TornadoState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TornadoState) Enum.valueOf(TornadoState.class, str) : (TornadoState) invokeL.objValue;
    }

    public static TornadoState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TornadoState[]) $VALUES.clone() : (TornadoState[]) invokeV.objValue;
    }
}
