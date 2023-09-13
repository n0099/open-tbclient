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
public class l44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l44 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n44> a;

    public l44() {
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

    public static l44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (l44.class) {
                    if (b == null) {
                        b = new l44();
                    }
                }
            }
            return b;
        }
        return (l44) invokeV.objValue;
    }

    public void a(n44 n44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, n44Var) == null) && n44Var != null && !this.a.contains(n44Var)) {
            this.a.add(n44Var);
        }
    }

    public void d(n44 n44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n44Var) == null) && this.a.contains(n44Var)) {
            this.a.remove(n44Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (n44 n44Var : this.a) {
                if (i == 16) {
                    n44Var.c();
                } else if (i == 17) {
                    n44Var.b(str);
                }
                d(n44Var);
            }
        }
    }
}
