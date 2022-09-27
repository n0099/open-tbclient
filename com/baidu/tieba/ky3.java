package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class ky3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(sx3 sx3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, sx3Var, jsObject) == null) {
            ly3 ly3Var = new ly3();
            sv1 F = sv1.F(jsObject);
            if (F == null) {
                F = new sv1();
            }
            boolean z = false;
            if (sx3Var == null) {
                ly3Var.errMsg = "openCustomerServiceConversation:fail";
                x54.call(F, false, ly3Var);
                return;
            }
            if (vz3.c()) {
                l33 M = l33.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(sm2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        ly3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        ly3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    ly3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                ly3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            x54.call(F, z, ly3Var);
        }
    }
}
