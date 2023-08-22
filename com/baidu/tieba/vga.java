package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.h5power.DescriptionTableInfo;
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
/* loaded from: classes8.dex */
public class vga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<qga> a;

    public vga() {
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

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !di.isEmpty(str) && !di.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public sga c(uga ugaVar, sga sgaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            if ("notification".equals(ugaVar.c()) && "addObserver".equals(ugaVar.a())) {
                Iterator<qga> it = this.a.iterator();
                while (it.hasNext()) {
                    sgaVar = it.next().addObserver(ugaVar.d(), sgaVar, true);
                    if (sgaVar.j()) {
                        return sgaVar;
                    }
                }
                if (!sgaVar.j()) {
                    sgaVar.z(202);
                    sgaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ugaVar.c();
                if (!di.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    sgaVar.z(201);
                    return sgaVar;
                }
                Iterator<qga> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    sgaVar = it2.next().dispatch(ugaVar, sgaVar);
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
        return (sga) invokeLL.objValue;
    }

    public void d(WebView webView, sga sgaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, sgaVar) != null) || webView == null || sgaVar == null || !sgaVar.k()) {
            return;
        }
        b(webView, sgaVar.c(), sgaVar.d());
    }

    public void e(WebView webView, List<sga> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (sga sgaVar : list) {
                if (sgaVar != null && sgaVar.k()) {
                    b(webView, sgaVar.c(), sgaVar.d());
                }
            }
        }
    }

    public List<sga> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<sga> list = null;
            if (di.isEmpty(str)) {
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
