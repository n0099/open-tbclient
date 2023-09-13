package com.baidu.tts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class k0 {
    public static /* synthetic */ Interceptable $ic;
    public static final k0 c;
    public static final k0 d;
    public static final k0 e;
    public static final k0 f;
    public static final k0 g;
    public static final /* synthetic */ k0[] h;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final double b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722259148, "Lcom/baidu/tts/k0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722259148, "Lcom/baidu/tts/k0;");
                return;
            }
        }
        k0 k0Var = new k0("OPUS_16K", 0, "OPUS_16K", "16", 16000.0d);
        c = k0Var;
        k0 k0Var2 = new k0("OPUS_32K", 1, "OPUS_32K", PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK, 32000.0d);
        d = k0Var2;
        k0 k0Var3 = new k0("OPUS_64K", 2, "OPUS_32K", "64", 64000.0d);
        e = k0Var3;
        k0 k0Var4 = new k0("OPUS_128K", 3, "OPUS_32K", "128", 128000.0d);
        f = k0Var4;
        k0 k0Var5 = new k0("PCM", 4, "PCM", "0", 0.0d);
        g = k0Var5;
        h = new k0[]{k0Var, k0Var2, k0Var3, k0Var4, k0Var5};
    }

    public k0(String str, int i, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, Double.valueOf(d2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str3;
        this.b = d2;
    }

    public static k0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (k0) Enum.valueOf(k0.class, str);
        }
        return (k0) invokeL.objValue;
    }

    public static k0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (k0[]) h.clone();
        }
        return (k0[]) invokeV.objValue;
    }
}
