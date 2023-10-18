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
public class ls3 implements or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ls3() {
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

    @Override // com.baidu.tieba.or1
    public oi4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ks3.b().a();
        }
        return (oi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !ks3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.or1
    public void b(tb2 tb2Var, rb2 rb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tb2Var, rb2Var) != null) || rb2Var == null) {
            return;
        }
        if (tb2Var != null && !TextUtils.isEmpty(tb2Var.a)) {
            String str = tb2Var.a;
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
                    rb2Var.onFail();
                    return;
                } else {
                    ks3.b().b(true, rb2Var);
                    return;
                }
            } else if (tb2Var.b) {
                ks3.b().b(false, rb2Var);
                return;
            } else {
                ks3.b().b(true, rb2Var);
                return;
            }
        }
        rb2Var.onFail();
    }

    @Override // com.baidu.tieba.or1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !ef2.d.w() && (!ef2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !jc2.V().t0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
