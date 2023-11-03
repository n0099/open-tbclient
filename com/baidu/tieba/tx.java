package com.baidu.tieba;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class tx {
    public static /* synthetic */ Interceptable $ic;
    public static tx b;
    public transient /* synthetic */ FieldHolder $fh;
    public i4 a;

    public tx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i4.n(AppRuntime.getAppContext());
    }

    public static tx a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (AbTestManager.class) {
                    if (b == null) {
                        b = new tx();
                    }
                }
            }
            return b;
        }
        return (tx) invokeV.objValue;
    }

    public void b(List<q4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
            this.a.G(list, z);
        }
    }
}
