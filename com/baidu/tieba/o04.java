package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class o04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(wz3 wz3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, wz3Var, jsObject) == null) {
            p04 p04Var = new p04();
            xx1 G = xx1.G(jsObject);
            if (G == null) {
                G = new xx1();
            }
            boolean z = false;
            if (wz3Var == null) {
                p04Var.errMsg = "openCustomerServiceConversation:fail";
                b84.a(G, false, p04Var);
                return;
            }
            if (z14.c()) {
                p53 M = p53.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.P() + "\"}";
                    if (SchemeRouter.invoke(wo2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        p04Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        p04Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    p04Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                p04Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            b84.a(G, z, p04Var);
        }
    }
}
