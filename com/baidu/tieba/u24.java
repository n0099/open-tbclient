package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class u24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c24 c24Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, c24Var, jsObject) == null) {
            v24 v24Var = new v24();
            c02 F = c02.F(jsObject);
            if (F == null) {
                F = new c02();
            }
            boolean z = false;
            if (c24Var == null) {
                v24Var.errMsg = "openCustomerServiceConversation:fail";
                ha4.call(F, false, v24Var);
                return;
            }
            if (f44.c()) {
                v73 M = v73.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(cr2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        v24Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        v24Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    v24Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                v24Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            ha4.call(F, z, v24Var);
        }
    }
}
