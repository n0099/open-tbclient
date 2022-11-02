package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class z98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public z98(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
    }

    public PersonStatus g(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, userData)) == null) {
            if (userData == null) {
                if (this.a) {
                    return PersonStatus.HOST_DEFAULT;
                }
                return PersonStatus.GUEST_DEFAULT;
            } else if (userData.isBaijiahaoUser()) {
                if (this.a) {
                    return PersonStatus.HOST_BJH;
                }
                return PersonStatus.GUEST_BJH;
            } else if (this.a) {
                return PersonStatus.HOST_DEFAULT;
            } else {
                return PersonStatus.GUEST_DEFAULT;
            }
        }
        return (PersonStatus) invokeL.objValue;
    }

    public PersonStatus h(ga8 ga8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ga8Var)) == null) {
            if (ga8Var != null && ga8Var.j() != null) {
                return g(ga8Var.j());
            }
            if (this.a) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        }
        return (PersonStatus) invokeL.objValue;
    }
}
