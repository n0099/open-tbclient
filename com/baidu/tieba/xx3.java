package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class xx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fx3 fx3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fx3Var, jsObject) == null) {
            yx3 yx3Var = new yx3();
            fv1 F = fv1.F(jsObject);
            if (F == null) {
                F = new fv1();
            }
            boolean z = false;
            if (fx3Var == null) {
                yx3Var.errMsg = "openCustomerServiceConversation:fail";
                k54.call(F, false, yx3Var);
                return;
            }
            if (iz3.c()) {
                y23 M = y23.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(fm2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        yx3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        yx3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    yx3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                yx3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            k54.call(F, z, yx3Var);
        }
    }
}
