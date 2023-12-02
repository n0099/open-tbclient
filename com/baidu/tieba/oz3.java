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
public class oz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oz3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qz3> a;

    public oz3() {
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

    public static oz3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (oz3.class) {
                    if (b == null) {
                        b = new oz3();
                    }
                }
            }
            return b;
        }
        return (oz3) invokeV.objValue;
    }

    public void a(qz3 qz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qz3Var) == null) && qz3Var != null && !this.a.contains(qz3Var)) {
            this.a.add(qz3Var);
        }
    }

    public void d(qz3 qz3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qz3Var) == null) && this.a.contains(qz3Var)) {
            this.a.remove(qz3Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (qz3 qz3Var : this.a) {
                if (i == 16) {
                    qz3Var.c();
                } else if (i == 17) {
                    qz3Var.b(str);
                }
                d(qz3Var);
            }
        }
    }
}
