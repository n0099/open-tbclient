package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class iz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qy3 qy3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, qy3Var, jsObject) == null) {
            jz3 jz3Var = new jz3();
            qw1 F = qw1.F(jsObject);
            if (F == null) {
                F = new qw1();
            }
            boolean z = false;
            if (qy3Var == null) {
                jz3Var.errMsg = "openCustomerServiceConversation:fail";
                v64.call(F, false, jz3Var);
                return;
            }
            if (t04.c()) {
                j43 M = j43.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(qn2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        jz3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        jz3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    jz3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                jz3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            v64.call(F, z, jz3Var);
        }
    }
}
