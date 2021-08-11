package com.baidu.wallet.paysdk.datamodel;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class SourceFlag {
    public static final /* synthetic */ SourceFlag[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SourceFlag H5;
    public static final SourceFlag IFrame;
    public static final SourceFlag PC;
    public static final SourceFlag SDK;
    public transient /* synthetic */ FieldHolder $fh;
    public String mSourceFlag;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(970213199, "Lcom/baidu/wallet/paysdk/datamodel/SourceFlag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(970213199, "Lcom/baidu/wallet/paysdk/datamodel/SourceFlag;");
                return;
            }
        }
        SDK = new SourceFlag("SDK", 0, 3);
        PC = new SourceFlag("PC", 1, 0);
        H5 = new SourceFlag("H5", 2, 1);
        SourceFlag sourceFlag = new SourceFlag("IFrame", 3, 2);
        IFrame = sourceFlag;
        $VALUES = new SourceFlag[]{SDK, PC, H5, sourceFlag};
    }

    public SourceFlag(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSourceFlag = Integer.toString(i3);
    }

    public static SourceFlag valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SourceFlag) Enum.valueOf(SourceFlag.class, str) : (SourceFlag) invokeL.objValue;
    }

    public static SourceFlag[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SourceFlag[]) $VALUES.clone() : (SourceFlag[]) invokeV.objValue;
    }

    public String value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSourceFlag : (String) invokeV.objValue;
    }
}
