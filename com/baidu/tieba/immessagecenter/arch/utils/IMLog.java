package com.baidu.tieba.immessagecenter.arch.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ew8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class IMLog {
    public static final /* synthetic */ IMLog[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final IMLog INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final ew8 instance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1232997619, "Lcom/baidu/tieba/immessagecenter/arch/utils/IMLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1232997619, "Lcom/baidu/tieba/immessagecenter/arch/utils/IMLog;");
                return;
            }
        }
        IMLog iMLog = new IMLog("INSTANCE", 0);
        INSTANCE = iMLog;
        $VALUES = new IMLog[]{iMLog};
    }

    public static ew8 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE.instance;
        }
        return (ew8) invokeV.objValue;
    }

    public static IMLog[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (IMLog[]) $VALUES.clone();
        }
        return (IMLog[]) invokeV.objValue;
    }

    public IMLog(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.instance = new ew8("im");
    }

    public static IMLog valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (IMLog) Enum.valueOf(IMLog.class, str);
        }
        return (IMLog) invokeL.objValue;
    }
}
