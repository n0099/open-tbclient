package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class oj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<uy9> a;

    public oj6() {
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

    public void a(uy9 uy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uy9Var) == null) {
            this.a.add(uy9Var);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<uy9> it = this.a.iterator();
            while (it.hasNext()) {
                uy9 next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            wq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public wy9 c(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            if ("notification".equals(yy9Var.c()) && "addObserver".equals(yy9Var.a())) {
                Iterator<uy9> it = this.a.iterator();
                while (it.hasNext()) {
                    wy9Var = it.next().addObserver(webView, yy9Var.d(), wy9Var, true);
                    if (wy9Var.j()) {
                        return wy9Var;
                    }
                }
                if (!wy9Var.j()) {
                    wy9Var.z(202);
                    wy9Var.v(hl6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<uy9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    wy9Var = it2.next().dispatch(webView, yy9Var, wy9Var);
                    if (wy9Var.i()) {
                        return wy9Var;
                    }
                }
                if (!wy9Var.i()) {
                    wy9Var.z(202);
                }
            }
            return wy9Var;
        }
        return (wy9) invokeLLL.objValue;
    }

    public void d(WebView webView, wy9 wy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, wy9Var) != null) || webView == null || wy9Var == null || !wy9Var.k()) {
            return;
        }
        b(webView, wy9Var.c(), wy9Var.d());
    }

    public boolean e(WebView webView, List<wy9> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (wy9 wy9Var : list) {
                    if (wy9Var != null && wy9Var.k()) {
                        if (b(webView, wy9Var.c(), wy9Var.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<wy9> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<wy9> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<uy9> it = this.a.iterator();
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
