package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class t24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b24 b24Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, b24Var, jsObject) == null) {
            u24 u24Var = new u24();
            b02 F = b02.F(jsObject);
            if (F == null) {
                F = new b02();
            }
            boolean z = false;
            if (b24Var == null) {
                u24Var.errMsg = "openCustomerServiceConversation:fail";
                ga4.call(F, false, u24Var);
                return;
            }
            if (e44.c()) {
                u73 M = u73.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(br2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        u24Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        u24Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    u24Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                u24Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            ga4.call(F, z, u24Var);
        }
    }
}
