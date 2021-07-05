package com.baidu.tieba.interestlabel.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class LabelRequestEnum {
    public static final /* synthetic */ LabelRequestEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LabelRequestEnum GET_LABEL;
    public static final LabelRequestEnum SUB_LABEL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2139327366, "Lcom/baidu/tieba/interestlabel/model/LabelRequestEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2139327366, "Lcom/baidu/tieba/interestlabel/model/LabelRequestEnum;");
                return;
            }
        }
        GET_LABEL = new LabelRequestEnum("GET_LABEL", 0);
        LabelRequestEnum labelRequestEnum = new LabelRequestEnum("SUB_LABEL", 1);
        SUB_LABEL = labelRequestEnum;
        $VALUES = new LabelRequestEnum[]{GET_LABEL, labelRequestEnum};
    }

    public LabelRequestEnum(String str, int i2) {
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

    public static LabelRequestEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LabelRequestEnum) Enum.valueOf(LabelRequestEnum.class, str) : (LabelRequestEnum) invokeL.objValue;
    }

    public static LabelRequestEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LabelRequestEnum[]) $VALUES.clone() : (LabelRequestEnum[]) invokeV.objValue;
    }
}
