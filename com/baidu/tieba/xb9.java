package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xb9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static xb9 a(int i, float f, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            return new xb9();
        }
        return (xb9) invokeCommon.objValue;
    }

    public static xb9 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return a(i, 0.47f, 3.0f, 2.14f, 1.41f, 1.03f);
                            }
                            return a(i, 0.53f, 3.0f, 1.64f, 1.08f, 0.62f);
                        }
                        return a(i, 0.59f, 3.0f, 1.11f, 0.71f, 0.67f);
                    }
                    return a(i, 0.1f, 2.0f, 0.39f, 0.31f, 0.66f);
                }
                return a(i, 0.1f, 1.0f, 0.0f, 0.0f, 0.09f);
            }
            return a(i, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        return (xb9) invokeI.objValue;
    }
}
