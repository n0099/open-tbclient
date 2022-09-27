package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class pw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pw3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rw3> a;

    public pw3() {
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

    public static pw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (pw3.class) {
                    if (b == null) {
                        b = new pw3();
                    }
                }
            }
            return b;
        }
        return (pw3) invokeV.objValue;
    }

    public void a(rw3 rw3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rw3Var) == null) || rw3Var == null || this.a.contains(rw3Var)) {
            return;
        }
        this.a.add(rw3Var);
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (rw3 rw3Var : this.a) {
                if (i == 16) {
                    rw3Var.c();
                } else if (i == 17) {
                    rw3Var.b(str);
                }
                d(rw3Var);
            }
        }
    }

    public void d(rw3 rw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rw3Var) == null) && this.a.contains(rw3Var)) {
            this.a.remove(rw3Var);
        }
    }
}
