package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class wc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<rc9> a;

    public wc9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public void a(rc9 rc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rc9Var) == null) {
            this.a.add(rc9Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            w58 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !gi.isEmpty(str) && !gi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public tc9 c(vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            if ("notification".equals(vc9Var.c()) && "addObserver".equals(vc9Var.a())) {
                Iterator<rc9> it = this.a.iterator();
                while (it.hasNext()) {
                    tc9Var = it.next().addObserver(vc9Var.d(), tc9Var, true);
                    if (tc9Var.j()) {
                        return tc9Var;
                    }
                }
                if (!tc9Var.j()) {
                    tc9Var.y(202);
                    tc9Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = vc9Var.c();
                if (!gi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    tc9Var.y(201);
                    return tc9Var;
                }
                Iterator<rc9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    tc9Var = it2.next().dispatch(vc9Var, tc9Var);
                    if (tc9Var.i()) {
                        return tc9Var;
                    }
                }
                if (!tc9Var.i()) {
                    tc9Var.y(202);
                }
            }
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }

    public void d(WebView webView, tc9 tc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, tc9Var) != null) || webView == null || tc9Var == null || !tc9Var.k()) {
            return;
        }
        b(webView, tc9Var.c(), tc9Var.d());
    }

    public void e(WebView webView, List<tc9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (tc9 tc9Var : list) {
                if (tc9Var != null && tc9Var.k()) {
                    b(webView, tc9Var.c(), tc9Var.d());
                }
            }
        }
    }

    public List<tc9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<tc9> list = null;
            if (gi.isEmpty(str)) {
                return null;
            }
            Iterator<rc9> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(webView, str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLLL.objValue;
    }
}
