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
/* loaded from: classes5.dex */
public class jw8 extends sl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId d1;
    public transient /* synthetic */ FieldHolder $fh;
    public oy4 a1;
    public oy4 b1;
    public oy4 c1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897822, "Lcom/baidu/tieba/jw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897822, "Lcom/baidu/tieba/jw8;");
                return;
            }
        }
        d1 = BdUniqueId.gen();
    }

    public jw8() {
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

    @Override // com.baidu.tieba.sl9, com.baidu.tieba.hn
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
            oy4 oy4Var = this.a1;
            if (oy4Var != null && !StringUtils.isNull(oy4Var.b)) {
                return true;
            }
            oy4 oy4Var2 = this.b1;
            if (oy4Var2 != null && !StringUtils.isNull(oy4Var2.b)) {
                return true;
            }
            oy4 oy4Var3 = this.c1;
            if (oy4Var3 != null) {
                return !StringUtils.isNull(oy4Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
