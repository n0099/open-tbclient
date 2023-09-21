package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ws6 extends la7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ws6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.la7
    @Nullable
    public Object e(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (str.hashCode() == 155229553 && str.equals("click_back_card")) {
                c = 0;
            } else {
                c = 65535;
            }
            if (c != 0) {
                return super.e(str, str2);
            }
            return w45.b(str2);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.la7
    @NonNull
    public yc7<?> h(@NonNull n87<?> n87Var, @NonNull b97 b97Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n87Var, b97Var)) == null) {
            u87 u87Var = new u87();
            u87Var.c = n87Var;
            u87Var.b = b97Var.a();
            u87Var.a = b97Var.c();
            return u87Var;
        }
        return (yc7) invokeLL.objValue;
    }
}
