package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r08 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId Y0;
    public transient /* synthetic */ FieldHolder $fh;
    public vt4 V0;
    public vt4 W0;
    public vt4 X0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067919, "Lcom/baidu/tieba/r08;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067919, "Lcom/baidu/tieba/r08;");
                return;
            }
        }
        Y0 = BdUniqueId.gen();
    }

    public r08() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Y0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            vt4 vt4Var = this.V0;
            if (vt4Var != null && !StringUtils.isNull(vt4Var.b)) {
                return true;
            }
            vt4 vt4Var2 = this.W0;
            if (vt4Var2 != null && !StringUtils.isNull(vt4Var2.b)) {
                return true;
            }
            vt4 vt4Var3 = this.X0;
            if (vt4Var3 != null && !StringUtils.isNull(vt4Var3.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
