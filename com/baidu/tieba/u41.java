package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.tieba.s41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class u41 implements s41.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u41() {
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

    @Override // com.baidu.tieba.s41.a
    public AbsContainer a(y41 y41Var, z41 z41Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, y41Var, z41Var, i)) == null) ? new BaseNativeBrowserContainer(y41Var, z41Var) : (AbsContainer) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.s41.a
    public boolean b(HashMap<String, String> hashMap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, i)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.s41.a
    public void c(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }
}
