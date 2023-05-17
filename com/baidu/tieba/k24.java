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
public class k24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k24 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<m24> a;

    public k24() {
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

    public static k24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (k24.class) {
                    if (b == null) {
                        b = new k24();
                    }
                }
            }
            return b;
        }
        return (k24) invokeV.objValue;
    }

    public void a(m24 m24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, m24Var) == null) && m24Var != null && !this.a.contains(m24Var)) {
            this.a.add(m24Var);
        }
    }

    public void d(m24 m24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m24Var) == null) && this.a.contains(m24Var)) {
            this.a.remove(m24Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (m24 m24Var : this.a) {
                if (i == 16) {
                    m24Var.c();
                } else if (i == 17) {
                    m24Var.b(str);
                }
                d(m24Var);
            }
        }
    }
}
