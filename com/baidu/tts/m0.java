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
public final class m0 {
    public static /* synthetic */ Interceptable $ic;
    public static final m0 b;
    public static final m0 c;
    public static final m0 d;
    public static final /* synthetic */ m0[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722261070, "Lcom/baidu/tts/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722261070, "Lcom/baidu/tts/m0;");
                return;
            }
        }
        m0 m0Var = new m0("ONLINE", 0, 0, "online engine");
        b = m0Var;
        m0 m0Var2 = new m0("OFFLINE", 1, 1, "offline engine");
        c = m0Var2;
        m0 m0Var3 = new m0("MIX", 2, 2, "online and offline mix engine");
        d = m0Var3;
        e = new m0[]{m0Var, m0Var2, m0Var3};
    }

    public m0(String str, int i, int i2, String str2) {
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

    public static m0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (m0) Enum.valueOf(m0.class, str);
        }
        return (m0) invokeL.objValue;
    }

    public static m0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (m0[]) e.clone();
        }
        return (m0[]) invokeV.objValue;
    }
}
