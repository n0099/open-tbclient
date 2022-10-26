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
public class qw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qw3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;

    public qw3() {
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

    public static qw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (qw3.class) {
                    if (b == null) {
                        b = new qw3();
                    }
                }
            }
            return b;
        }
        return (qw3) invokeV.objValue;
    }

    public void a(sw3 sw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sw3Var) == null) && sw3Var != null && !this.a.contains(sw3Var)) {
            this.a.add(sw3Var);
        }
    }

    public void d(sw3 sw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sw3Var) == null) && this.a.contains(sw3Var)) {
            this.a.remove(sw3Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (sw3 sw3Var : this.a) {
                if (i == 16) {
                    sw3Var.c();
                } else if (i == 17) {
                    sw3Var.b(str);
                }
                d(sw3Var);
            }
        }
    }
}
