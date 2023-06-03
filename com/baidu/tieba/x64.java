package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class x64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(f64 f64Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, f64Var, jsObject) == null) {
            y64 y64Var = new y64();
            f42 F = f42.F(jsObject);
            if (F == null) {
                F = new f42();
            }
            boolean z = false;
            if (f64Var == null) {
                y64Var.errMsg = "openCustomerServiceConversation:fail";
                ke4.call(F, false, y64Var);
                return;
            }
            if (i84.c()) {
                yb3 M = yb3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(fv2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        y64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        y64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    y64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                y64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            ke4.call(F, z, y64Var);
        }
    }
}
