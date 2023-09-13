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
public final class l0 {
    public static /* synthetic */ Interceptable $ic;
    public static final l0 a;
    public static final l0 b;
    public static final l0 c;
    public static final l0 d;
    public static final l0 e;
    public static final l0 f;
    public static final l0 g;
    public static final l0 h;
    public static final /* synthetic */ l0[] i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722260109, "Lcom/baidu/tts/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722260109, "Lcom/baidu/tts/l0;");
                return;
            }
        }
        l0 l0Var = new l0("SYN_START", 0);
        a = l0Var;
        l0 l0Var2 = new l0("SYN_FINISH", 1);
        b = l0Var2;
        l0 l0Var3 = new l0("SYN_DATA", 2);
        c = l0Var3;
        l0 l0Var4 = new l0("SYN_STOP", 3);
        d = l0Var4;
        l0 l0Var5 = new l0("SYN_ERROR", 4);
        e = l0Var5;
        l0 l0Var6 = new l0("PLAY_START", 5);
        f = l0Var6;
        l0 l0Var7 = new l0("PLAY_PROGRESS", 6);
        g = l0Var7;
        l0 l0Var8 = new l0("PLAY_FINISH", 7);
        h = l0Var8;
        i = new l0[]{l0Var, l0Var2, l0Var3, l0Var4, l0Var5, l0Var6, l0Var7, l0Var8};
    }

    public l0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static l0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (l0) Enum.valueOf(l0.class, str);
        }
        return (l0) invokeL.objValue;
    }

    public static l0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (l0[]) i.clone();
        }
        return (l0[]) invokeV.objValue;
    }
}
