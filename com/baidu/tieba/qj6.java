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
public class qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zy9> a;

    public qj6() {
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

    public void a(zy9 zy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zy9Var) == null) {
            this.a.add(zy9Var);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<zy9> it = this.a.iterator();
            while (it.hasNext()) {
                zy9 next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            zq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public bz9 c(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            if ("notification".equals(dz9Var.c()) && "addObserver".equals(dz9Var.a())) {
                Iterator<zy9> it = this.a.iterator();
                while (it.hasNext()) {
                    bz9Var = it.next().addObserver(webView, dz9Var.d(), bz9Var, true);
                    if (bz9Var.j()) {
                        return bz9Var;
                    }
                }
                if (!bz9Var.j()) {
                    bz9Var.z(202);
                    bz9Var.v(jl6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<zy9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    bz9Var = it2.next().dispatch(webView, dz9Var, bz9Var);
                    if (bz9Var.i()) {
                        return bz9Var;
                    }
                }
                if (!bz9Var.i()) {
                    bz9Var.z(202);
                }
            }
            return bz9Var;
        }
        return (bz9) invokeLLL.objValue;
    }

    public void d(WebView webView, bz9 bz9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, bz9Var) != null) || webView == null || bz9Var == null || !bz9Var.k()) {
            return;
        }
        b(webView, bz9Var.c(), bz9Var.d());
    }

    public boolean e(WebView webView, List<bz9> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (bz9 bz9Var : list) {
                    if (bz9Var != null && bz9Var.k()) {
                        if (b(webView, bz9Var.c(), bz9Var.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<bz9> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<bz9> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<zy9> it = this.a.iterator();
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
