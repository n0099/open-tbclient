package com.baidu.tieba.write.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class PhotoType {
    public static final /* synthetic */ PhotoType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PhotoType APNG;
    public static final PhotoType GIF;
    public static final PhotoType JPEG;
    public static final PhotoType PNG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646112194, "Lcom/baidu/tieba/write/util/PhotoType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646112194, "Lcom/baidu/tieba/write/util/PhotoType;");
                return;
            }
        }
        APNG = new PhotoType("APNG", 0);
        PNG = new PhotoType("PNG", 1);
        GIF = new PhotoType("GIF", 2);
        PhotoType photoType = new PhotoType("JPEG", 3);
        JPEG = photoType;
        $VALUES = new PhotoType[]{APNG, PNG, GIF, photoType};
    }

    public PhotoType(String str, int i) {
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

    public static PhotoType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PhotoType) Enum.valueOf(PhotoType.class, str);
        }
        return (PhotoType) invokeL.objValue;
    }

    public static PhotoType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PhotoType[]) $VALUES.clone();
        }
        return (PhotoType[]) invokeV.objValue;
    }
}
