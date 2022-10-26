package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes4.dex */
public class lo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;

    public lo8() {
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
        this.a = new ArrayList();
    }

    public void a(go8 go8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, go8Var) == null) {
            this.a.add(go8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) && webView != null && !ej.isEmpty(str) && !ej.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
        }
    }

    public io8 c(ko8 ko8Var, io8 io8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ko8Var, io8Var)) == null) {
            if (io8Var == null) {
                io8Var = new io8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(ko8Var.c()) && "addObserver".equals(ko8Var.a())) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    io8Var = ((go8) it.next()).addObserver(ko8Var.d(), io8Var, true);
                    if (io8Var.j()) {
                        return io8Var;
                    }
                }
                if (!io8Var.j()) {
                    io8Var.y(202);
                    io8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c));
                }
            } else {
                String c = ko8Var.c();
                if (!ej.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    io8Var.y(201);
                    return io8Var;
                }
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    io8Var = ((go8) it2.next()).dispatch(ko8Var, io8Var);
                    if (io8Var.i()) {
                        return io8Var;
                    }
                }
                if (!io8Var.i()) {
                    io8Var.y(202);
                }
            }
            return io8Var;
        }
        return (io8) invokeLL.objValue;
    }

    public void d(WebView webView, io8 io8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, io8Var) != null) || webView == null || io8Var == null || !io8Var.k()) {
            return;
        }
        b(webView, io8Var.c(), io8Var.d());
    }

    public void e(WebView webView, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                io8 io8Var = (io8) it.next();
                if (io8Var != null && io8Var.k()) {
                    b(webView, io8Var.c(), io8Var.d());
                }
            }
        }
    }

    public List f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List list = null;
            if (ej.isEmpty(str)) {
                return null;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                list = ((go8) it.next()).processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
