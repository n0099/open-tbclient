package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z0a extends nwa {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l1;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 i1;
    public my4 j1;
    public my4 k1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307518, "Lcom/baidu/tieba/z0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307518, "Lcom/baidu/tieba/z0a;");
                return;
            }
        }
        l1 = BdUniqueId.gen();
    }

    public z0a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.nwa, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return l1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            my4 my4Var = this.i1;
            if (my4Var != null && !StringUtils.isNull(my4Var.b)) {
                return true;
            }
            my4 my4Var2 = this.j1;
            if (my4Var2 != null && !StringUtils.isNull(my4Var2.b)) {
                return true;
            }
            my4 my4Var3 = this.k1;
            if (my4Var3 != null) {
                return !StringUtils.isNull(my4Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
