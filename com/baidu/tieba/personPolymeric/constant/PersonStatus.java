package com.baidu.tieba.personPolymeric.constant;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class PersonStatus {
    public static final /* synthetic */ PersonStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PersonStatus GUEST_BJH;
    public static final PersonStatus GUEST_DEFAULT;
    public static final PersonStatus HOST_BJH;
    public static final PersonStatus HOST_DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-725485901, "Lcom/baidu/tieba/personPolymeric/constant/PersonStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-725485901, "Lcom/baidu/tieba/personPolymeric/constant/PersonStatus;");
                return;
            }
        }
        HOST_DEFAULT = new PersonStatus("HOST_DEFAULT", 0);
        HOST_BJH = new PersonStatus("HOST_BJH", 1);
        GUEST_DEFAULT = new PersonStatus("GUEST_DEFAULT", 2);
        PersonStatus personStatus = new PersonStatus("GUEST_BJH", 3);
        GUEST_BJH = personStatus;
        $VALUES = new PersonStatus[]{HOST_DEFAULT, HOST_BJH, GUEST_DEFAULT, personStatus};
    }

    public PersonStatus(String str, int i) {
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

    public static PersonStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PersonStatus) Enum.valueOf(PersonStatus.class, str);
        }
        return (PersonStatus) invokeL.objValue;
    }

    public static PersonStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PersonStatus[]) $VALUES.clone();
        }
        return (PersonStatus[]) invokeV.objValue;
    }
}
