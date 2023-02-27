package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class l44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(t34 t34Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, t34Var, jsObject) == null) {
            m44 m44Var = new m44();
            t12 F = t12.F(jsObject);
            if (F == null) {
                F = new t12();
            }
            boolean z = false;
            if (t34Var == null) {
                m44Var.errMsg = "openCustomerServiceConversation:fail";
                yb4.call(F, false, m44Var);
                return;
            }
            if (w54.c()) {
                m93 M = m93.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ts2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        m44Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        m44Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    m44Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                m44Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            yb4.call(F, z, m44Var);
        }
    }
}
