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
/* loaded from: classes7.dex */
public class ry3 implements tx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ry3() {
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

    @Override // com.baidu.tieba.tx1
    public uo4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return qy3.b().a();
        }
        return (uo4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tx1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !qy3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tx1
    public void b(zh2 zh2Var, xh2 xh2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh2Var, xh2Var) != null) || xh2Var == null) {
            return;
        }
        if (zh2Var != null && !TextUtils.isEmpty(zh2Var.a)) {
            String str = zh2Var.a;
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
                    xh2Var.onFail();
                    return;
                } else {
                    qy3.b().b(true, xh2Var);
                    return;
                }
            } else if (zh2Var.b) {
                qy3.b().b(false, xh2Var);
                return;
            } else {
                qy3.b().b(true, xh2Var);
                return;
            }
        }
        xh2Var.onFail();
    }

    @Override // com.baidu.tieba.tx1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !kl2.d.w() && (!kl2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !pi2.U().s0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
