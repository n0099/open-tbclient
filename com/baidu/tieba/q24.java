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
public class q24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q24 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<s24> a;

    public q24() {
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

    public static q24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (q24.class) {
                    if (b == null) {
                        b = new q24();
                    }
                }
            }
            return b;
        }
        return (q24) invokeV.objValue;
    }

    public void a(s24 s24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, s24Var) == null) && s24Var != null && !this.a.contains(s24Var)) {
            this.a.add(s24Var);
        }
    }

    public void d(s24 s24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s24Var) == null) && this.a.contains(s24Var)) {
            this.a.remove(s24Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (s24 s24Var : this.a) {
                if (i == 16) {
                    s24Var.c();
                } else if (i == 17) {
                    s24Var.b(str);
                }
                d(s24Var);
            }
        }
    }
}
