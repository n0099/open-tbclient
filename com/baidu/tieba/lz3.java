package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class lz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lz3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nz3> a;

    public lz3() {
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

    public static lz3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (lz3.class) {
                    if (b == null) {
                        b = new lz3();
                    }
                }
            }
            return b;
        }
        return (lz3) invokeV.objValue;
    }

    public void a(nz3 nz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nz3Var) == null) && nz3Var != null && !this.a.contains(nz3Var)) {
            this.a.add(nz3Var);
        }
    }

    public void d(nz3 nz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nz3Var) == null) && this.a.contains(nz3Var)) {
            this.a.remove(nz3Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (nz3 nz3Var : this.a) {
                if (i == 16) {
                    nz3Var.c();
                } else if (i == 17) {
                    nz3Var.b(str);
                }
                d(nz3Var);
            }
        }
    }
}
