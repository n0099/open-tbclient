package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class x04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x04 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<z04> a;

    public x04() {
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
        this.a = new CopyOnWriteArrayList();
    }

    public static x04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (x04.class) {
                    if (b == null) {
                        b = new x04();
                    }
                }
            }
            return b;
        }
        return (x04) invokeV.objValue;
    }

    public void a(z04 z04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, z04Var) == null) && z04Var != null && !this.a.contains(z04Var)) {
            this.a.add(z04Var);
        }
    }

    public void d(z04 z04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z04Var) == null) && this.a.contains(z04Var)) {
            this.a.remove(z04Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (z04 z04Var : this.a) {
                if (i == 16) {
                    z04Var.c();
                } else if (i == 17) {
                    z04Var.b(str);
                }
                d(z04Var);
            }
        }
    }
}
