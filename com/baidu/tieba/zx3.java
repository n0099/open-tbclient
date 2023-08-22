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
/* loaded from: classes9.dex */
public class zx3 implements bx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zx3() {
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

    @Override // com.baidu.tieba.bx1
    public co4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return yx3.b().a();
        }
        return (co4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bx1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !yx3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bx1
    public void b(hh2 hh2Var, fh2 fh2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh2Var, fh2Var) != null) || fh2Var == null) {
            return;
        }
        if (hh2Var != null && !TextUtils.isEmpty(hh2Var.a)) {
            String str = hh2Var.a;
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
                    fh2Var.onFail();
                    return;
                } else {
                    yx3.b().b(true, fh2Var);
                    return;
                }
            } else if (hh2Var.b) {
                yx3.b().b(false, fh2Var);
                return;
            } else {
                yx3.b().b(true, fh2Var);
                return;
            }
        }
        fh2Var.onFail();
    }

    @Override // com.baidu.tieba.bx1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !sk2.d.w() && (!sk2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !xh2.U().s0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
