package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class x54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(f54 f54Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, f54Var, jsObject) == null) {
            y54 y54Var = new y54();
            f32 F = f32.F(jsObject);
            if (F == null) {
                F = new f32();
            }
            boolean z = false;
            if (f54Var == null) {
                y54Var.errMsg = "openCustomerServiceConversation:fail";
                kd4.call(F, false, y54Var);
                return;
            }
            if (i74.c()) {
                ya3 M = ya3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(fu2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        y54Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        y54Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    y54Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                y54Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            kd4.call(F, z, y54Var);
        }
    }
}
