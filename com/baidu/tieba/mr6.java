package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mr6 extends y87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mr6() {
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

    @Override // com.baidu.tieba.y87
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
            return q45.b(str2);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.y87
    @NonNull
    public jb7<?> h(@NonNull b77<?> b77Var, @NonNull p77 p77Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b77Var, p77Var)) == null) {
            i77 i77Var = new i77();
            i77Var.c = b77Var;
            i77Var.b = p77Var.a();
            i77Var.a = p77Var.c();
            return i77Var;
        }
        return (jb7) invokeLL.objValue;
    }
}
