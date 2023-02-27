package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.ListUtils;
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
public class vb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<l69> a;

    public vb6() {
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

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<l69> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().removeObserverBridge(list);
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            r08 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public n69 c(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            if ("notification".equals(p69Var.c()) && "addObserver".equals(p69Var.a())) {
                Iterator<l69> it = this.a.iterator();
                while (it.hasNext()) {
                    n69Var = it.next().addObserver(webView, p69Var.d(), n69Var, true);
                    if (n69Var.j()) {
                        return n69Var;
                    }
                }
                if (!n69Var.j()) {
                    n69Var.y(202);
                    n69Var.u(wd6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<l69> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    n69Var = it2.next().dispatch(webView, p69Var, n69Var);
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
        return (n69) invokeLLL.objValue;
    }

    public void d(WebView webView, n69 n69Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, n69Var) != null) || webView == null || n69Var == null || !n69Var.k()) {
            return;
        }
        b(webView, n69Var.c(), n69Var.d());
    }

    public boolean e(WebView webView, List<n69> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (n69 n69Var : list) {
                    if (n69Var != null && n69Var.k()) {
                        if (z || b(webView, n69Var.c(), n69Var.d())) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<n69> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<n69> list = null;
            if (TextUtils.isEmpty(str)) {
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
