package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class j14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(r04 r04Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, r04Var, jsObject) == null) {
            k14 k14Var = new k14();
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                G = new sy1();
            }
            boolean z = false;
            if (r04Var == null) {
                k14Var.errMsg = "openCustomerServiceConversation:fail";
                w84.a(G, false, k14Var);
                return;
            }
            if (u24.c()) {
                k63 M = k63.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.P() + "\"}";
                    if (SchemeRouter.invoke(rp2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        k14Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        k14Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    k14Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                k14Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            w84.a(G, z, k14Var);
        }
    }
}
