package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pf1 {
    public static /* synthetic */ Interceptable $ic;
    public static pf1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public qf1 a;

    public pf1(qf1 qf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qf1Var;
    }

    public static void c(qf1 qf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, qf1Var) == null) && b == null) {
            synchronized (pf1.class) {
                if (b == null) {
                    b = new pf1(qf1Var);
                }
            }
        }
    }

    public static pf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (pf1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        qf1 qf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (qf1Var = this.a) != null) {
            qf1Var.a(imageView, str);
        }
    }
}
