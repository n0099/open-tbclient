package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class v34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d34 d34Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, d34Var, jsObject) == null) {
            w34 w34Var = new w34();
            d12 F = d12.F(jsObject);
            if (F == null) {
                F = new d12();
            }
            boolean z = false;
            if (d34Var == null) {
                w34Var.errMsg = "openCustomerServiceConversation:fail";
                ib4.call(F, false, w34Var);
                return;
            }
            if (g54.c()) {
                w83 M = w83.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ds2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        w34Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        w34Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    w34Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                w34Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            ib4.call(F, z, w34Var);
        }
    }
}
