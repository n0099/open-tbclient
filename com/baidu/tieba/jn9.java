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
/* loaded from: classes6.dex */
public class jn9 extends tha {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j1;
    public transient /* synthetic */ FieldHolder $fh;
    public h35 g1;
    public h35 h1;
    public h35 i1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889204, "Lcom/baidu/tieba/jn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889204, "Lcom/baidu/tieba/jn9;");
                return;
            }
        }
        j1 = BdUniqueId.gen();
    }

    public jn9() {
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

    @Override // com.baidu.tieba.tha, com.baidu.tieba.cn
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
            h35 h35Var = this.g1;
            if (h35Var != null && !StringUtils.isNull(h35Var.b)) {
                return true;
            }
            h35 h35Var2 = this.h1;
            if (h35Var2 != null && !StringUtils.isNull(h35Var2.b)) {
                return true;
            }
            h35 h35Var3 = this.i1;
            if (h35Var3 != null) {
                return !StringUtils.isNull(h35Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
