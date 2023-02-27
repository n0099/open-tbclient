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
/* loaded from: classes5.dex */
public class q69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<l69> a;

    public q69() {
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

    public void a(l69 l69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l69Var) == null) {
            this.a.add(l69Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            r08 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !dj.isEmpty(str) && !dj.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public n69 c(p69 p69Var, n69 n69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            if ("notification".equals(p69Var.c()) && "addObserver".equals(p69Var.a())) {
                Iterator<l69> it = this.a.iterator();
                while (it.hasNext()) {
                    n69Var = it.next().addObserver(p69Var.d(), n69Var, true);
                    if (n69Var.j()) {
                        return n69Var;
                    }
                }
                if (!n69Var.j()) {
                    n69Var.y(202);
                    n69Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = p69Var.c();
                if (!dj.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    n69Var.y(201);
                    return n69Var;
                }
                Iterator<l69> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    n69Var = it2.next().dispatch(p69Var, n69Var);
                    if (n69Var.i()) {
                        return n69Var;
                    }
                }
                if (!n69Var.i()) {
                    n69Var.y(202);
                }
            }
            return n69Var;
        }
        return (n69) invokeLL.objValue;
    }

    public void d(WebView webView, n69 n69Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, n69Var) != null) || webView == null || n69Var == null || !n69Var.k()) {
            return;
        }
        b(webView, n69Var.c(), n69Var.d());
    }

    public void e(WebView webView, List<n69> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (n69 n69Var : list) {
                if (n69Var != null && n69Var.k()) {
                    b(webView, n69Var.c(), n69Var.d());
                }
            }
        }
    }

    public List<n69> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<n69> list = null;
            if (dj.isEmpty(str)) {
                return null;
            }
            Iterator<l69> it = this.a.iterator();
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
