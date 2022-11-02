package com.baidu.tieba.tblauncher;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class MainTabScheduleStrategy {
    public static final /* synthetic */ MainTabScheduleStrategy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MainTabScheduleStrategy FLUSHING;
    public static final MainTabScheduleStrategy SCHEDULE;
    public static final MainTabScheduleStrategy UNSCHEDULE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473511160, "Lcom/baidu/tieba/tblauncher/MainTabScheduleStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473511160, "Lcom/baidu/tieba/tblauncher/MainTabScheduleStrategy;");
                return;
            }
        }
        SCHEDULE = new MainTabScheduleStrategy("SCHEDULE", 0);
        UNSCHEDULE = new MainTabScheduleStrategy("UNSCHEDULE", 1);
        MainTabScheduleStrategy mainTabScheduleStrategy = new MainTabScheduleStrategy("FLUSHING", 2);
        FLUSHING = mainTabScheduleStrategy;
        $VALUES = new MainTabScheduleStrategy[]{SCHEDULE, UNSCHEDULE, mainTabScheduleStrategy};
    }

    public MainTabScheduleStrategy(String str, int i) {
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
            }
        }
    }

    public static MainTabScheduleStrategy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (MainTabScheduleStrategy) Enum.valueOf(MainTabScheduleStrategy.class, str);
        }
        return (MainTabScheduleStrategy) invokeL.objValue;
    }

    public static MainTabScheduleStrategy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (MainTabScheduleStrategy[]) $VALUES.clone();
        }
        return (MainTabScheduleStrategy[]) invokeV.objValue;
    }
}
