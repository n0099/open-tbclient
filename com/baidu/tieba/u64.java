package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class u64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c64 c64Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, c64Var, jsObject) == null) {
            v64 v64Var = new v64();
            c42 F = c42.F(jsObject);
            if (F == null) {
                F = new c42();
            }
            boolean z = false;
            if (c64Var == null) {
                v64Var.errMsg = "openCustomerServiceConversation:fail";
                he4.call(F, false, v64Var);
                return;
            }
            if (f84.c()) {
                vb3 M = vb3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(cv2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        v64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        v64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    v64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                v64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            he4.call(F, z, v64Var);
        }
    }
}
