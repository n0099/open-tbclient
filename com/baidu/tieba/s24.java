package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class s24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(a24 a24Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, a24Var, jsObject) == null) {
            t24 t24Var = new t24();
            a02 F = a02.F(jsObject);
            if (F == null) {
                F = new a02();
            }
            boolean z = false;
            if (a24Var == null) {
                t24Var.errMsg = "openCustomerServiceConversation:fail";
                fa4.call(F, false, t24Var);
                return;
            }
            if (d44.c()) {
                t73 M = t73.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ar2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        t24Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        t24Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    t24Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                t24Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            fa4.call(F, z, t24Var);
        }
    }
}
