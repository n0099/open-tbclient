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
/* loaded from: classes4.dex */
public class jy7 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId W0;
    public transient /* synthetic */ FieldHolder $fh;
    public ps4 T0;
    public ps4 U0;
    public ps4 V0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899713, "Lcom/baidu/tieba/jy7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899713, "Lcom/baidu/tieba/jy7;");
                return;
            }
        }
        W0 = BdUniqueId.gen();
    }

    public jy7() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? W0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ps4 ps4Var = this.T0;
            if (ps4Var == null || StringUtils.isNull(ps4Var.b)) {
                ps4 ps4Var2 = this.U0;
                if (ps4Var2 == null || StringUtils.isNull(ps4Var2.b)) {
                    ps4 ps4Var3 = this.V0;
                    return (ps4Var3 == null || StringUtils.isNull(ps4Var3.b)) ? false : true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
