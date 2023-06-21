package com.baidu.tieba.yunpush;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.tieba.tr8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class YunPushLog {
    public static final /* synthetic */ YunPushLog[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YunPushLog INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final tr8 instance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1239519058, "Lcom/baidu/tieba/yunpush/YunPushLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1239519058, "Lcom/baidu/tieba/yunpush/YunPushLog;");
                return;
            }
        }
        YunPushLog yunPushLog = new YunPushLog("INSTANCE", 0);
        INSTANCE = yunPushLog;
        $VALUES = new YunPushLog[]{yunPushLog};
    }

    public static tr8 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE.instance;
        }
        return (tr8) invokeV.objValue;
    }

    public static YunPushLog[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (YunPushLog[]) $VALUES.clone();
        }
        return (YunPushLog[]) invokeV.objValue;
    }

    public YunPushLog(String str, int i) {
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
        this.instance = new tr8(Config.DEVICE_PART);
    }

    public static YunPushLog valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (YunPushLog) Enum.valueOf(YunPushLog.class, str);
        }
        return (YunPushLog) invokeL.objValue;
    }
}
