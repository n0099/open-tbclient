package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
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
public class ms9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<hs9> a;

    public ms9() {
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

    public void a(hs9 hs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hs9Var) == null) {
            this.a.add(hs9Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            yk8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !qi.isEmpty(str) && !qi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public js9 c(ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            if ("notification".equals(ls9Var.c()) && "addObserver".equals(ls9Var.a())) {
                Iterator<hs9> it = this.a.iterator();
                while (it.hasNext()) {
                    js9Var = it.next().addObserver(ls9Var.d(), js9Var, true);
                    if (js9Var.j()) {
                        return js9Var;
                    }
                }
                if (!js9Var.j()) {
                    js9Var.z(202);
                    js9Var.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ls9Var.c();
                if (!qi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    js9Var.z(201);
                    return js9Var;
                }
                Iterator<hs9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    js9Var = it2.next().dispatch(ls9Var, js9Var);
                    if (js9Var.i()) {
                        return js9Var;
                    }
                }
                if (!js9Var.i()) {
                    js9Var.z(202);
                }
            }
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    public void d(WebView webView, js9 js9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, js9Var) != null) || webView == null || js9Var == null || !js9Var.k()) {
            return;
        }
        b(webView, js9Var.c(), js9Var.d());
    }

    public void e(WebView webView, List<js9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (js9 js9Var : list) {
                if (js9Var != null && js9Var.k()) {
                    b(webView, js9Var.c(), js9Var.d());
                }
            }
        }
    }

    public List<js9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<js9> list = null;
            if (qi.isEmpty(str)) {
                return null;
            }
            Iterator<hs9> it = this.a.iterator();
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
