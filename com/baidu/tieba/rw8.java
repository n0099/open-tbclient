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
public class rw8 extends am9 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId d1;
    public transient /* synthetic */ FieldHolder $fh;
    public py4 a1;
    public py4 b1;
    public py4 c1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948136150, "Lcom/baidu/tieba/rw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948136150, "Lcom/baidu/tieba/rw8;");
                return;
            }
        }
        d1 = BdUniqueId.gen();
    }

    public rw8() {
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

    @Override // com.baidu.tieba.am9, com.baidu.tieba.in
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return d1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            py4 py4Var = this.a1;
            if (py4Var != null && !StringUtils.isNull(py4Var.b)) {
                return true;
            }
            py4 py4Var2 = this.b1;
            if (py4Var2 != null && !StringUtils.isNull(py4Var2.b)) {
                return true;
            }
            py4 py4Var3 = this.c1;
            if (py4Var3 != null) {
                return !StringUtils.isNull(py4Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
