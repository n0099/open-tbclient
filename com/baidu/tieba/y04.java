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
public class y04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y04 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a14> a;

    public y04() {
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

    public static y04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (y04.class) {
                    if (b == null) {
                        b = new y04();
                    }
                }
            }
            return b;
        }
        return (y04) invokeV.objValue;
    }

    public void a(a14 a14Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, a14Var) == null) && a14Var != null && !this.a.contains(a14Var)) {
            this.a.add(a14Var);
        }
    }

    public void d(a14 a14Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a14Var) == null) && this.a.contains(a14Var)) {
            this.a.remove(a14Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (a14 a14Var : this.a) {
                if (i == 16) {
                    a14Var.c();
                } else if (i == 17) {
                    a14Var.b(str);
                }
                d(a14Var);
            }
        }
    }
}
