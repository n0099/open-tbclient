package com.baidu.tts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class t0 {
    public static /* synthetic */ Interceptable $ic;
    public static final t0 c;
    public static final t0 d;
    public static final t0 e;
    public static final /* synthetic */ t0[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722267797, "Lcom/baidu/tts/t0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722267797, "Lcom/baidu/tts/t0;");
                return;
            }
        }
        t0 t0Var = new t0("ONLINE", 0, 0, "just online");
        c = t0Var;
        t0 t0Var2 = new t0("OFFLINE", 1, 1, "just offline");
        d = t0Var2;
        t0 t0Var3 = new t0("MIX", 2, 2, "if online cannot use switch from online to offline");
        e = t0Var3;
        f = new t0[]{t0Var, t0Var2, t0Var3};
    }

    public t0(String str, int i, int i2, String str2) {
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
        this.b = str2;
    }

    public static t0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (t0) Enum.valueOf(t0.class, str);
        }
        return (t0) invokeL.objValue;
    }

    public static t0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (t0[]) f.clone();
        }
        return (t0[]) invokeV.objValue;
    }
}
