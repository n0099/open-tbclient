package com.baidu.tieba.pb.ejection.value;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class LifeCycleState {
    public static final /* synthetic */ LifeCycleState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LifeCycleState ACTIVE;
    public static final LifeCycleState DEAD;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1319448019, "Lcom/baidu/tieba/pb/ejection/value/LifeCycleState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1319448019, "Lcom/baidu/tieba/pb/ejection/value/LifeCycleState;");
                return;
            }
        }
        ACTIVE = new LifeCycleState("ACTIVE", 0);
        LifeCycleState lifeCycleState = new LifeCycleState("DEAD", 1);
        DEAD = lifeCycleState;
        $VALUES = new LifeCycleState[]{ACTIVE, lifeCycleState};
    }

    public LifeCycleState(String str, int i) {
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

    public static LifeCycleState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LifeCycleState) Enum.valueOf(LifeCycleState.class, str) : (LifeCycleState) invokeL.objValue;
    }

    public static LifeCycleState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LifeCycleState[]) $VALUES.clone() : (LifeCycleState[]) invokeV.objValue;
    }
}
