package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class w24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e24 e24Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, e24Var, jsObject) == null) {
            x24 x24Var = new x24();
            e02 F = e02.F(jsObject);
            if (F == null) {
                F = new e02();
            }
            boolean z = false;
            if (e24Var == null) {
                x24Var.errMsg = "openCustomerServiceConversation:fail";
                ja4.call(F, false, x24Var);
                return;
            }
            if (h44.c()) {
                x73 M = x73.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(er2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        x24Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        x24Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    x24Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                x24Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            ja4.call(F, z, x24Var);
        }
    }
}
