package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ua5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public final tf1<sa5> a;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rf1 b = rf1.b();
            this.a = b;
            b.a(new ta5());
        }
    }

    public ua5() {
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
        b();
    }

    public final ka5 a(String schema) {
        InterceptResult invokeL;
        List<sa5> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            tf1<sa5> tf1Var = this.a;
            if (tf1Var != null && (list = tf1Var.getList()) != null) {
                for (sa5 sa5Var : list) {
                    ka5 a = sa5Var.a(schema);
                    if (a.b()) {
                        return a;
                    }
                }
            }
            return new ka5();
        }
        return (ka5) invokeL.objValue;
    }
}
