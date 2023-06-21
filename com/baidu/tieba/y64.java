package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class y64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(g64 g64Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, g64Var, jsObject) == null) {
            z64 z64Var = new z64();
            g42 F = g42.F(jsObject);
            if (F == null) {
                F = new g42();
            }
            boolean z = false;
            if (g64Var == null) {
                z64Var.errMsg = "openCustomerServiceConversation:fail";
                le4.call(F, false, z64Var);
                return;
            }
            if (j84.c()) {
                zb3 M = zb3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(gv2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        z64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        z64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    z64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                z64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            le4.call(F, z, z64Var);
        }
    }
}
