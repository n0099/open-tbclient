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
/* loaded from: classes5.dex */
public class pn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<kn8> a;

    public pn8() {
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

    public void a(kn8 kn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kn8Var) == null) {
            this.a.add(kn8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || dj.isEmpty(str) || dj.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public mn8 c(on8 on8Var, mn8 mn8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, on8Var, mn8Var)) == null) {
            if (mn8Var == null) {
                mn8Var = new mn8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(on8Var.c()) && "addObserver".equals(on8Var.a())) {
                Iterator<kn8> it = this.a.iterator();
                while (it.hasNext()) {
                    mn8Var = it.next().addObserver(on8Var.d(), mn8Var, true);
                    if (mn8Var.j()) {
                        return mn8Var;
                    }
                }
                if (!mn8Var.j()) {
                    mn8Var.y(202);
                    mn8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c));
                }
            } else {
                String c = on8Var.c();
                if (!dj.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    mn8Var.y(201);
                    return mn8Var;
                }
                Iterator<kn8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    mn8Var = it2.next().dispatch(on8Var, mn8Var);
                    if (mn8Var.i()) {
                        return mn8Var;
                    }
                }
                if (!mn8Var.i()) {
                    mn8Var.y(202);
                }
            }
            return mn8Var;
        }
        return (mn8) invokeLL.objValue;
    }

    public void d(WebView webView, mn8 mn8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, mn8Var) == null) || webView == null || mn8Var == null || !mn8Var.k()) {
            return;
        }
        b(webView, mn8Var.c(), mn8Var.d());
    }

    public void e(WebView webView, List<mn8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (mn8 mn8Var : list) {
            if (mn8Var != null && mn8Var.k()) {
                b(webView, mn8Var.c(), mn8Var.d());
            }
        }
    }

    public List<mn8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<mn8> list = null;
            if (dj.isEmpty(str)) {
                return null;
            }
            Iterator<kn8> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
