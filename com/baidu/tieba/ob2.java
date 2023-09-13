package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class ob2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kb2> a;
    public boolean b;

    public ob2() {
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
        this.a = new ArrayList();
        this.b = false;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String g = vn3.g(System.currentTimeMillis(), "【HH:mm:ss】");
            List<kb2> list = this.a;
            if (list != null && !list.isEmpty()) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                for (kb2 kb2Var : this.a) {
                    if (kb2Var.c()) {
                        i++;
                        if (kb2Var.b()) {
                            i2++;
                        } else {
                            i3++;
                        }
                    }
                }
                return String.format("\n%s jserror：共%d个，影响渲染%d个（框架%d个，开发者%d个）；", g, Integer.valueOf(this.a.size()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            return String.format("\n%s jserror：共0个；", g);
        }
        return (String) invokeV.objValue;
    }

    public void c(List<kb2> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && list != null && !list.isEmpty()) {
            this.a = list;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.b = z;
        }
    }
}
