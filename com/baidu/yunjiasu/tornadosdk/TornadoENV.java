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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoENV;", "", "(Ljava/lang/String;I)V", "ENABLE_DEBUG", "ENABLE_PING_CMD", "ENABLE_IPV6", "ALLOWED_ALL", "PRINT_LOG", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TornadoENV {
    public static final /* synthetic */ TornadoENV[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TornadoENV ALLOWED_ALL;
    public static final TornadoENV ENABLE_DEBUG;
    public static final TornadoENV ENABLE_IPV6;
    public static final TornadoENV ENABLE_PING_CMD;
    public static final TornadoENV PRINT_LOG;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ TornadoENV[] $values() {
        return new TornadoENV[]{ENABLE_DEBUG, ENABLE_PING_CMD, ENABLE_IPV6, ALLOWED_ALL, PRINT_LOG};
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1722502648, "Lcom/baidu/yunjiasu/tornadosdk/TornadoENV;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1722502648, "Lcom/baidu/yunjiasu/tornadosdk/TornadoENV;");
                return;
            }
        }
        ENABLE_DEBUG = new TornadoENV("ENABLE_DEBUG", 0);
        ENABLE_PING_CMD = new TornadoENV("ENABLE_PING_CMD", 1);
        ENABLE_IPV6 = new TornadoENV("ENABLE_IPV6", 2);
        ALLOWED_ALL = new TornadoENV("ALLOWED_ALL", 3);
        PRINT_LOG = new TornadoENV("PRINT_LOG", 4);
        $VALUES = $values();
    }

    public TornadoENV(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }

    public static TornadoENV valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TornadoENV) Enum.valueOf(TornadoENV.class, str) : (TornadoENV) invokeL.objValue;
    }

    public static TornadoENV[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TornadoENV[]) $VALUES.clone() : (TornadoENV[]) invokeV.objValue;
    }
}
