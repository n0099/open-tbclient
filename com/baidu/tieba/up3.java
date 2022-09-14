package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
@Service
/* loaded from: classes6.dex */
public class up3 implements wo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public up3() {
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

    @Override // com.baidu.tieba.wo1
    public xf4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? tp3.b().a() : (xf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo1
    public void b(c92 c92Var, a92 a92Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c92Var, a92Var) == null) || a92Var == null) {
            return;
        }
        if (c92Var != null && !TextUtils.isEmpty(c92Var.a)) {
            String str = c92Var.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1195918653) {
                if (hashCode == 1825003424 && str.equals("by_click")) {
                    c = 0;
                }
            } else if (str.equals("by_silent")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    a92Var.onFail();
                    return;
                } else {
                    tp3.b().b(true, a92Var);
                    return;
                }
            } else if (c92Var.b) {
                tp3.b().b(false, a92Var);
                return;
            } else {
                tp3.b().b(true, a92Var);
                return;
            }
        }
        a92Var.onFail();
    }

    @Override // com.baidu.tieba.wo1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || nc2.d.w() || (nc2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && s92.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wo1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !tp3.b().c() : invokeV.booleanValue;
    }
}
