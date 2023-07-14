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
/* loaded from: classes8.dex */
public class ti9 extends yca {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j1;
    public transient /* synthetic */ FieldHolder $fh;
    public z35 g1;
    public z35 h1;
    public z35 i1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182309, "Lcom/baidu/tieba/ti9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182309, "Lcom/baidu/tieba/ti9;");
                return;
            }
        }
        j1 = BdUniqueId.gen();
    }

    public ti9() {
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

    @Override // com.baidu.tieba.yca, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return j1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            z35 z35Var = this.g1;
            if (z35Var != null && !StringUtils.isNull(z35Var.b)) {
                return true;
            }
            z35 z35Var2 = this.h1;
            if (z35Var2 != null && !StringUtils.isNull(z35Var2.b)) {
                return true;
            }
            z35 z35Var3 = this.i1;
            if (z35Var3 != null) {
                return !StringUtils.isNull(z35Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
