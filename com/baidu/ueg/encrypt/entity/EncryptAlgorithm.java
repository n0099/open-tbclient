package com.baidu.ueg.encrypt.entity;

import com.baidu.android.common.security.RSAUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class EncryptAlgorithm {
    public static final /* synthetic */ EncryptAlgorithm[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EncryptAlgorithm RSA;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1293183573, "Lcom/baidu/ueg/encrypt/entity/EncryptAlgorithm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1293183573, "Lcom/baidu/ueg/encrypt/entity/EncryptAlgorithm;");
                return;
            }
        }
        EncryptAlgorithm encryptAlgorithm = new EncryptAlgorithm(RSAUtil.ALGORITHM_RSA, 0);
        RSA = encryptAlgorithm;
        $VALUES = new EncryptAlgorithm[]{encryptAlgorithm};
    }

    public static EncryptAlgorithm[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (EncryptAlgorithm[]) $VALUES.clone();
        }
        return (EncryptAlgorithm[]) invokeV.objValue;
    }

    public EncryptAlgorithm(String str, int i) {
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

    public static EncryptAlgorithm valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (EncryptAlgorithm) Enum.valueOf(EncryptAlgorithm.class, str);
        }
        return (EncryptAlgorithm) invokeL.objValue;
    }
}
