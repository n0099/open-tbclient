package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
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
    public ArrayList<qga> a;

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

    public void a(qga qgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qgaVar) == null) {
            this.a.add(qgaVar);
        }
    }

    public void g(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<qga> it = this.a.iterator();
            while (it.hasNext()) {
                qga next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public void b(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "H5通知callJsDispatchEvent params:" + str);
            if (webView != null && !TextUtils.isEmpty(str)) {
                webView.evaluateJavascript("javascript:var eventType = 'naNotify';var setEvent = new Event(eventType);setEvent.detail = " + str + ";document.dispatchEvent(setEvent);", null);
            }
        }
    }

    public boolean f(WebView webView, List<sga> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (sga sgaVar : list) {
                    if (sgaVar != null && sgaVar.k()) {
                        if (c(webView, sgaVar.c(), sgaVar.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "端能力返回H5：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public sga d(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            if ("notification".equals(ugaVar.c()) && "addObserver".equals(ugaVar.a())) {
                Iterator<qga> it = this.a.iterator();
                while (it.hasNext()) {
                    sgaVar = it.next().addObserver(webView, ugaVar.d(), sgaVar, true);
                    if (sgaVar.j()) {
                        return sgaVar;
                    }
                }
                if (!sgaVar.j()) {
                    sgaVar.z(202);
                    sgaVar.v(kl6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<qga> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    sgaVar = it2.next().dispatch(webView, ugaVar, sgaVar);
                    if (sgaVar.i()) {
                        return sgaVar;
                    }
                }
                if (!sgaVar.i()) {
                    sgaVar.z(202);
                }
            }
            return sgaVar;
        }
        return (sga) invokeLLL.objValue;
    }

    public void e(WebView webView, sga sgaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, webView, sgaVar) != null) || webView == null || sgaVar == null || !sgaVar.k()) {
            return;
        }
        c(webView, sgaVar.c(), sgaVar.d());
    }

    public List<sga> h(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, hashMap)) == null) {
            List<sga> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<qga> it = this.a.iterator();
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
