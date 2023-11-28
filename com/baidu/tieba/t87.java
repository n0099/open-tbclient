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
public class t87 extends q87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t87() {
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

    @Override // com.baidu.tieba.q87
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
            return zz4.b(str2);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.q87
    @NonNull
    public nb7<?> h(@NonNull s57<?> s57Var, @NonNull n67 n67Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s57Var, n67Var)) == null) {
            b67 b67Var = new b67();
            b67Var.c = s57Var;
            b67Var.b = n67Var.a();
            b67Var.a = n67Var.c();
            return b67Var;
        }
        return (nb7) invokeLL.objValue;
    }
}
