package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ph1 {
    public static /* synthetic */ Interceptable $ic;
    public static ph1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public qh1 a;

    public ph1(qh1 qh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qh1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qh1Var;
    }

    public static void c(qh1 qh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, qh1Var) == null) && b == null) {
            synchronized (ph1.class) {
                if (b == null) {
                    b = new ph1(qh1Var);
                }
            }
        }
    }

    public static ph1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (ph1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        qh1 qh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (qh1Var = this.a) != null) {
            qh1Var.a(imageView, str);
        }
    }
}
