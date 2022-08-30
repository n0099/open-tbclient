package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class yv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gv3 gv3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, gv3Var, jsObject) == null) {
            zv3 zv3Var = new zv3();
            ht1 F = ht1.F(jsObject);
            if (F == null) {
                F = new ht1();
            }
            boolean z = false;
            if (gv3Var == null) {
                zv3Var.errMsg = "openCustomerServiceConversation:fail";
                l34.call(F, false, zv3Var);
                return;
            }
            if (jx3.c()) {
                a13 M = a13.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(hk2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        zv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        zv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    zv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                zv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            l34.call(F, z, zv3Var);
        }
    }
}
