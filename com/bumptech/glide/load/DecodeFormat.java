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
public final class DecodeFormat {
    public static final /* synthetic */ DecodeFormat[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DecodeFormat DEFAULT;
    public static final DecodeFormat PREFER_ARGB_8888;
    public static final DecodeFormat PREFER_RGB_565;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1446111360, "Lcom/bumptech/glide/load/DecodeFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1446111360, "Lcom/bumptech/glide/load/DecodeFormat;");
                return;
            }
        }
        PREFER_ARGB_8888 = new DecodeFormat("PREFER_ARGB_8888", 0);
        DecodeFormat decodeFormat = new DecodeFormat("PREFER_RGB_565", 1);
        PREFER_RGB_565 = decodeFormat;
        DecodeFormat decodeFormat2 = PREFER_ARGB_8888;
        $VALUES = new DecodeFormat[]{decodeFormat2, decodeFormat};
        DEFAULT = decodeFormat2;
    }

    public DecodeFormat(String str, int i2) {
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

    public static DecodeFormat valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DecodeFormat) Enum.valueOf(DecodeFormat.class, str) : (DecodeFormat) invokeL.objValue;
    }

    public static DecodeFormat[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DecodeFormat[]) $VALUES.clone() : (DecodeFormat[]) invokeV.objValue;
    }
}
