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
public class zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<uy9> a;

    public zy9() {
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

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            wq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !ui.isEmpty(str) && !ui.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public wy9 c(yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            if ("notification".equals(yy9Var.c()) && "addObserver".equals(yy9Var.a())) {
                Iterator<uy9> it = this.a.iterator();
                while (it.hasNext()) {
                    wy9Var = it.next().addObserver(yy9Var.d(), wy9Var, true);
                    if (wy9Var.j()) {
                        return wy9Var;
                    }
                }
                if (!wy9Var.j()) {
                    wy9Var.z(202);
                    wy9Var.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = yy9Var.c();
                if (!ui.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    wy9Var.z(201);
                    return wy9Var;
                }
                Iterator<uy9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    wy9Var = it2.next().dispatch(yy9Var, wy9Var);
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
        return (wy9) invokeLL.objValue;
    }

    public void d(WebView webView, wy9 wy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, wy9Var) != null) || webView == null || wy9Var == null || !wy9Var.k()) {
            return;
        }
        b(webView, wy9Var.c(), wy9Var.d());
    }

    public void e(WebView webView, List<wy9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (wy9 wy9Var : list) {
                if (wy9Var != null && wy9Var.k()) {
                    b(webView, wy9Var.c(), wy9Var.d());
                }
            }
        }
    }

    public List<wy9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<wy9> list = null;
            if (ui.isEmpty(str)) {
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
