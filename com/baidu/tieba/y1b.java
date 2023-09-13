package com.baidu.tieba;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class y1b implements q1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Integer[] a;
    public final Function2<Integer, Intent, Unit> b;

    public y1b(Integer[] codes, Function2<? super Integer, ? super Intent, Unit> onActivityResult) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {codes, onActivityResult};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(onActivityResult, "onActivityResult");
        this.a = codes;
        this.b = onActivityResult;
    }

    @Override // com.baidu.tieba.q1b
    public void a(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, intent) == null) {
            this.b.invoke(Integer.valueOf(i), intent);
        }
    }

    @Override // com.baidu.tieba.q1b
    public Integer[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Integer[]) invokeV.objValue;
    }
}
