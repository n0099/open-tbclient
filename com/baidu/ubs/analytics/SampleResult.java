package com.baidu.ubs.analytics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class SampleResult {
    public static final /* synthetic */ SampleResult[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SampleResult C1;
    public static final SampleResult C2;
    public static final SampleResult C3;
    public static final SampleResult C4;
    public static final SampleResult C5;
    public static final SampleResult OTHERE;
    public static final SampleResult T1;
    public static final SampleResult T2;
    public static final SampleResult T3;
    public static final SampleResult T4;
    public static final SampleResult T5;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1274967948, "Lcom/baidu/ubs/analytics/SampleResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1274967948, "Lcom/baidu/ubs/analytics/SampleResult;");
                return;
            }
        }
        T1 = new SampleResult("T1", 0);
        T2 = new SampleResult("T2", 1);
        T3 = new SampleResult("T3", 2);
        T4 = new SampleResult("T4", 3);
        T5 = new SampleResult("T5", 4);
        C1 = new SampleResult("C1", 5);
        C2 = new SampleResult("C2", 6);
        C3 = new SampleResult("C3", 7);
        C4 = new SampleResult("C4", 8);
        C5 = new SampleResult("C5", 9);
        SampleResult sampleResult = new SampleResult("OTHERE", 10);
        OTHERE = sampleResult;
        $VALUES = new SampleResult[]{T1, T2, T3, T4, T5, C1, C2, C3, C4, C5, sampleResult};
    }

    public SampleResult(String str, int i) {
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

    public static SampleResult valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (SampleResult) Enum.valueOf(SampleResult.class, str);
        }
        return (SampleResult) invokeL.objValue;
    }

    public static SampleResult[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (SampleResult[]) $VALUES.clone();
        }
        return (SampleResult[]) invokeV.objValue;
    }
}
