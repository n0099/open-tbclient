package com.baidu.turbonet.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes11.dex */
public abstract class CommandLine {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<CommandLine> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-184004840, "Lcom/baidu/turbonet/base/CommandLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-184004840, "Lcom/baidu/turbonet/base/CommandLine;");
                return;
            }
        }
        new ArrayList();
        a = new AtomicReference<>();
    }

    public CommandLine() {
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

    public static CommandLine a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.get() : (CommandLine) invokeV.objValue;
    }

    public static native void nativeAppendSwitch(String str);

    public static native void nativeAppendSwitchWithValue(String str, String str2);

    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    public static native String nativeGetSwitchValue(String str);

    public static native boolean nativeHasSwitch(String str);

    public static native void nativeReset();

    public abstract boolean b(String str);
}
