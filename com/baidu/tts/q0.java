package com.baidu.tts;

import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class q0 {
    public static /* synthetic */ Interceptable $ic;
    public static final q0 a;
    public static final q0 b;
    public static final q0 c;
    public static final /* synthetic */ q0[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722264914, "Lcom/baidu/tts/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722264914, "Lcom/baidu/tts/q0;");
                return;
            }
        }
        q0 q0Var = new q0(EngineName.DEFAULT_ENGINE, 0);
        a = q0Var;
        q0 q0Var2 = new q0("HIGH_SPEED_NETWORK", 1);
        b = q0Var2;
        q0 q0Var3 = new q0("HIGH_SPEED_NETWORK_WITHOUT_ETHER", 2);
        c = q0Var3;
        d = new q0[]{q0Var, q0Var2, q0Var3};
    }

    public q0(String str, int i) {
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

    public static q0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (q0) Enum.valueOf(q0.class, str);
        }
        return (q0) invokeL.objValue;
    }

    public static q0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (q0[]) d.clone();
        }
        return (q0[]) invokeV.objValue;
    }
}
