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
public class wd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<fq9> a;

    public wd6() {
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

    public void a(fq9 fq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fq9Var) == null) {
            this.a.add(fq9Var);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<fq9> it = this.a.iterator();
            while (it.hasNext()) {
                fq9 next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            dj8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public hq9 c(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            if ("notification".equals(jq9Var.c()) && "addObserver".equals(jq9Var.a())) {
                Iterator<fq9> it = this.a.iterator();
                while (it.hasNext()) {
                    hq9Var = it.next().addObserver(webView, jq9Var.d(), hq9Var, true);
                    if (hq9Var.j()) {
                        return hq9Var;
                    }
                }
                if (!hq9Var.j()) {
                    hq9Var.z(202);
                    hq9Var.v(mf6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<fq9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    hq9Var = it2.next().dispatch(webView, jq9Var, hq9Var);
                    if (hq9Var.i()) {
                        return hq9Var;
                    }
                }
                if (!hq9Var.i()) {
                    hq9Var.z(202);
                }
            }
            return hq9Var;
        }
        return (hq9) invokeLLL.objValue;
    }

    public void d(WebView webView, hq9 hq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, hq9Var) != null) || webView == null || hq9Var == null || !hq9Var.k()) {
            return;
        }
        b(webView, hq9Var.c(), hq9Var.d());
    }

    public boolean e(WebView webView, List<hq9> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (hq9 hq9Var : list) {
                    if (hq9Var != null && hq9Var.k()) {
                        if (z || b(webView, hq9Var.c(), hq9Var.d())) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<hq9> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<hq9> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<fq9> it = this.a.iterator();
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
