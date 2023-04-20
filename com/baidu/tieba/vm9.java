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
/* loaded from: classes6.dex */
public class vm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<qm9> a;

    public vm9() {
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

    public void a(qm9 qm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qm9Var) == null) {
            this.a.add(qm9Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            vg8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !hi.isEmpty(str) && !hi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public sm9 c(um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            if ("notification".equals(um9Var.c()) && "addObserver".equals(um9Var.a())) {
                Iterator<qm9> it = this.a.iterator();
                while (it.hasNext()) {
                    sm9Var = it.next().addObserver(um9Var.d(), sm9Var, true);
                    if (sm9Var.j()) {
                        return sm9Var;
                    }
                }
                if (!sm9Var.j()) {
                    sm9Var.y(202);
                    sm9Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = um9Var.c();
                if (!hi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    sm9Var.y(201);
                    return sm9Var;
                }
                Iterator<qm9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    sm9Var = it2.next().dispatch(um9Var, sm9Var);
                    if (sm9Var.i()) {
                        return sm9Var;
                    }
                }
                if (!sm9Var.i()) {
                    sm9Var.y(202);
                }
            }
            return sm9Var;
        }
        return (sm9) invokeLL.objValue;
    }

    public void d(WebView webView, sm9 sm9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, sm9Var) != null) || webView == null || sm9Var == null || !sm9Var.k()) {
            return;
        }
        b(webView, sm9Var.c(), sm9Var.d());
    }

    public void e(WebView webView, List<sm9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (sm9 sm9Var : list) {
                if (sm9Var != null && sm9Var.k()) {
                    b(webView, sm9Var.c(), sm9Var.d());
                }
            }
        }
    }

    public List<sm9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<sm9> list = null;
            if (hi.isEmpty(str)) {
                return null;
            }
            Iterator<qm9> it = this.a.iterator();
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
