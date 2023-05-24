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
public class ns9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<is9> a;

    public ns9() {
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

    public void a(is9 is9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, is9Var) == null) {
            this.a.add(is9Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            zk8 hybridLog = HybridLog.getInstance();
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

    public ks9 c(ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            if ("notification".equals(ms9Var.c()) && "addObserver".equals(ms9Var.a())) {
                Iterator<is9> it = this.a.iterator();
                while (it.hasNext()) {
                    ks9Var = it.next().addObserver(ms9Var.d(), ks9Var, true);
                    if (ks9Var.j()) {
                        return ks9Var;
                    }
                }
                if (!ks9Var.j()) {
                    ks9Var.z(202);
                    ks9Var.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ms9Var.c();
                if (!qi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    ks9Var.z(201);
                    return ks9Var;
                }
                Iterator<is9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    ks9Var = it2.next().dispatch(ms9Var, ks9Var);
                    if (ks9Var.i()) {
                        return ks9Var;
                    }
                }
                if (!ks9Var.i()) {
                    ks9Var.z(202);
                }
            }
            return ks9Var;
        }
        return (ks9) invokeLL.objValue;
    }

    public void d(WebView webView, ks9 ks9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, ks9Var) != null) || webView == null || ks9Var == null || !ks9Var.k()) {
            return;
        }
        b(webView, ks9Var.c(), ks9Var.d());
    }

    public void e(WebView webView, List<ks9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (ks9 ks9Var : list) {
                if (ks9Var != null && ks9Var.k()) {
                    b(webView, ks9Var.c(), ks9Var.d());
                }
            }
        }
    }

    public List<ks9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<ks9> list = null;
            if (qi.isEmpty(str)) {
                return null;
            }
            Iterator<is9> it = this.a.iterator();
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
