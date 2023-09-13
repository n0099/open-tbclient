package com.baidu.tts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class r0 {
    public static /* synthetic */ Interceptable $ic;
    public static final r0 b;
    public static final r0 c;
    public static final r0 d;
    public static final /* synthetic */ r0[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722265875, "Lcom/baidu/tts/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722265875, "Lcom/baidu/tts/r0;");
                return;
            }
        }
        r0 r0Var = new r0("HZ8K", 0, 8000, "8k");
        b = r0Var;
        r0 r0Var2 = new r0("HZ16K", 1, 16000, "16k");
        c = r0Var2;
        r0 r0Var3 = new r0("HZ24K", 2, 24000, "24k");
        d = r0Var3;
        e = new r0[]{r0Var, r0Var2, r0Var3};
    }

    public r0(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
    }

    public static r0 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            r0[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                r0 r0Var = values[i2];
                if (r0Var.a == i) {
                    return r0Var;
                }
            }
            return null;
        }
        return (r0) invokeI.objValue;
    }

    public static r0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (r0) Enum.valueOf(r0.class, str);
        }
        return (r0) invokeL.objValue;
    }

    public static r0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (r0[]) e.clone();
        }
        return (r0[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
