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
/* loaded from: classes8.dex */
public class vj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<r0a> a;

    public vj6() {
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

    public void a(r0a r0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r0aVar) == null) {
            this.a.add(r0aVar);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<r0a> it = this.a.iterator();
            while (it.hasNext()) {
                r0a next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            tr8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "端能力返回结果：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public t0a c(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            if ("notification".equals(v0aVar.c()) && "addObserver".equals(v0aVar.a())) {
                Iterator<r0a> it = this.a.iterator();
                while (it.hasNext()) {
                    t0aVar = it.next().addObserver(webView, v0aVar.d(), t0aVar, true);
                    if (t0aVar.j()) {
                        return t0aVar;
                    }
                }
                if (!t0aVar.j()) {
                    t0aVar.z(202);
                    t0aVar.v(ol6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<r0a> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    t0aVar = it2.next().dispatch(webView, v0aVar, t0aVar);
                    if (t0aVar.i()) {
                        return t0aVar;
                    }
                }
                if (!t0aVar.i()) {
                    t0aVar.z(202);
                }
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    public void d(WebView webView, t0a t0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, t0aVar) != null) || webView == null || t0aVar == null || !t0aVar.k()) {
            return;
        }
        b(webView, t0aVar.c(), t0aVar.d());
    }

    public boolean e(WebView webView, List<t0a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (t0a t0aVar : list) {
                    if (t0aVar != null && t0aVar.k()) {
                        if (b(webView, t0aVar.c(), t0aVar.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<t0a> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<t0a> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<r0a> it = this.a.iterator();
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
