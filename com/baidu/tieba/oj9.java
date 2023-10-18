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
/* loaded from: classes7.dex */
public class oj9 extends pea {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j1;
    public transient /* synthetic */ FieldHolder $fh;
    public px4 g1;
    public px4 h1;
    public px4 i1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948034315, "Lcom/baidu/tieba/oj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948034315, "Lcom/baidu/tieba/oj9;");
                return;
            }
        }
        j1 = BdUniqueId.gen();
    }

    public oj9() {
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

    @Override // com.baidu.tieba.pea, com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return j1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            px4 px4Var = this.g1;
            if (px4Var != null && !StringUtils.isNull(px4Var.b)) {
                return true;
            }
            px4 px4Var2 = this.h1;
            if (px4Var2 != null && !StringUtils.isNull(px4Var2.b)) {
                return true;
            }
            px4 px4Var3 = this.i1;
            if (px4Var3 != null) {
                return !StringUtils.isNull(px4Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
