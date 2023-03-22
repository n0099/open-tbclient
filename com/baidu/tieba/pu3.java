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
/* loaded from: classes5.dex */
public class pu3 implements rt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pu3() {
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

    @Override // com.baidu.tieba.rt1
    public sk4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ou3.b().a();
        }
        return (sk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rt1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !ou3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rt1
    public void b(xd2 xd2Var, vd2 vd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xd2Var, vd2Var) != null) || vd2Var == null) {
            return;
        }
        if (xd2Var != null && !TextUtils.isEmpty(xd2Var.a)) {
            String str = xd2Var.a;
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
                    vd2Var.onFail();
                    return;
                } else {
                    ou3.b().b(true, vd2Var);
                    return;
                }
            } else if (xd2Var.b) {
                ou3.b().b(false, vd2Var);
                return;
            } else {
                ou3.b().b(true, vd2Var);
                return;
            }
        }
        vd2Var.onFail();
    }

    @Override // com.baidu.tieba.rt1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !ih2.d.w() && (!ih2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !ne2.U().s0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
