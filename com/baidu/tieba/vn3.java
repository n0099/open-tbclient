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
public class vn3 implements ym1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vn3() {
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

    @Override // com.baidu.tieba.ym1
    public xd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? un3.b().a() : (xd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ym1
    public void b(e72 e72Var, c72 c72Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e72Var, c72Var) == null) || c72Var == null) {
            return;
        }
        if (e72Var != null && !TextUtils.isEmpty(e72Var.a)) {
            String str = e72Var.a;
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
                    c72Var.onFail();
                    return;
                } else {
                    un3.b().b(true, c72Var);
                    return;
                }
            } else if (e72Var.b) {
                un3.b().b(false, c72Var);
                return;
            } else {
                un3.b().b(true, c72Var);
                return;
            }
        }
        c72Var.onFail();
    }

    @Override // com.baidu.tieba.ym1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || pa2.d.w() || (pa2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && u72.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ym1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !un3.b().c() : invokeV.booleanValue;
    }
}
