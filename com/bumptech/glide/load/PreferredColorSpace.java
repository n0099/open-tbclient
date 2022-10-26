package com.bumptech.glide.load;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class PreferredColorSpace {
    public static final /* synthetic */ PreferredColorSpace[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PreferredColorSpace DISPLAY_P3;
    public static final PreferredColorSpace SRGB;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846534259, "Lcom/bumptech/glide/load/PreferredColorSpace;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1846534259, "Lcom/bumptech/glide/load/PreferredColorSpace;");
                return;
            }
        }
        SRGB = new PreferredColorSpace("SRGB", 0);
        PreferredColorSpace preferredColorSpace = new PreferredColorSpace("DISPLAY_P3", 1);
        DISPLAY_P3 = preferredColorSpace;
        $VALUES = new PreferredColorSpace[]{SRGB, preferredColorSpace};
    }

    public PreferredColorSpace(String str, int i) {
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

    public static PreferredColorSpace valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, str);
        }
        return (PreferredColorSpace) invokeL.objValue;
    }

    public static PreferredColorSpace[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PreferredColorSpace[]) $VALUES.clone();
        }
        return (PreferredColorSpace[]) invokeV.objValue;
    }
}
