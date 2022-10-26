package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class ly3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(tx3 tx3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tx3Var, jsObject) == null) {
            my3 my3Var = new my3();
            tv1 F = tv1.F(jsObject);
            if (F == null) {
                F = new tv1();
            }
            boolean z = false;
            if (tx3Var == null) {
                my3Var.errMsg = "openCustomerServiceConversation:fail";
                y54.call(F, false, my3Var);
                return;
            }
            if (wz3.c()) {
                m33 M = m33.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(tm2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        my3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        my3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    my3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                my3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            y54.call(F, z, my3Var);
        }
    }
}
