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
public final class we5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public final lk1<ue5> a;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            jk1 b = jk1.b();
            this.a = b;
            b.a(new ve5());
        }
    }

    public we5() {
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

    public final ne5 a(String schema) {
        InterceptResult invokeL;
        List<ue5> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            lk1<ue5> lk1Var = this.a;
            if (lk1Var != null && (list = lk1Var.getList()) != null) {
                for (ue5 ue5Var : list) {
                    ne5 a = ue5Var.a(schema);
                    if (a.b()) {
                        return a;
                    }
                }
            }
            return new ne5();
        }
        return (ne5) invokeL.objValue;
    }
}
