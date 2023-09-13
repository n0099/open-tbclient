package com.baidu.tieba.tracker.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/TraceType;", "", "(Ljava/lang/String;I)V", "Finished", V8ExceptionInfo.V8_EXCEPTION_ERROR, "Navigation", "SendMsg", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TraceType {
    public static final /* synthetic */ TraceType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TraceType Error;
    public static final TraceType Finished;
    public static final TraceType Navigation;
    public static final TraceType SendMsg;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ TraceType[] $values() {
        return new TraceType[]{Finished, Error, Navigation, SendMsg};
    }

    public static TraceType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TraceType) Enum.valueOf(TraceType.class, str) : (TraceType) invokeL.objValue;
    }

    public static TraceType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TraceType[]) $VALUES.clone() : (TraceType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(730658422, "Lcom/baidu/tieba/tracker/core/data/TraceType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(730658422, "Lcom/baidu/tieba/tracker/core/data/TraceType;");
                return;
            }
        }
        Finished = new TraceType("Finished", 0);
        Error = new TraceType(V8ExceptionInfo.V8_EXCEPTION_ERROR, 1);
        Navigation = new TraceType("Navigation", 2);
        SendMsg = new TraceType("SendMsg", 3);
        $VALUES = $values();
    }

    public TraceType(String str, int i) {
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
}
