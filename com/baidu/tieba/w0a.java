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
/* loaded from: classes8.dex */
public class w0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<r0a> a;

    public w0a() {
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

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            tr8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !vi.isEmpty(str) && !vi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public t0a c(v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            if ("notification".equals(v0aVar.c()) && "addObserver".equals(v0aVar.a())) {
                Iterator<r0a> it = this.a.iterator();
                while (it.hasNext()) {
                    t0aVar = it.next().addObserver(v0aVar.d(), t0aVar, true);
                    if (t0aVar.j()) {
                        return t0aVar;
                    }
                }
                if (!t0aVar.j()) {
                    t0aVar.z(202);
                    t0aVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = v0aVar.c();
                if (!vi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    t0aVar.z(201);
                    return t0aVar;
                }
                Iterator<r0a> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    t0aVar = it2.next().dispatch(v0aVar, t0aVar);
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
        return (t0a) invokeLL.objValue;
    }

    public void d(WebView webView, t0a t0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, t0aVar) != null) || webView == null || t0aVar == null || !t0aVar.k()) {
            return;
        }
        b(webView, t0aVar.c(), t0aVar.d());
    }

    public void e(WebView webView, List<t0a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (t0a t0aVar : list) {
                if (t0aVar != null && t0aVar.k()) {
                    b(webView, t0aVar.c(), t0aVar.d());
                }
            }
        }
    }

    public List<t0a> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<t0a> list = null;
            if (vi.isEmpty(str)) {
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
