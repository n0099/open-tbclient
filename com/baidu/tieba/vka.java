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
public class vka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<qka> a;

    public vka() {
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

    public void a(qka qkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qkaVar) == null) {
            this.a.add(qkaVar);
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

    public ska c(uka ukaVar, ska skaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            if ("notification".equals(ukaVar.c()) && "addObserver".equals(ukaVar.a())) {
                Iterator<qka> it = this.a.iterator();
                while (it.hasNext()) {
                    skaVar = it.next().addObserver(ukaVar.d(), skaVar, true);
                    if (skaVar.j()) {
                        return skaVar;
                    }
                }
                if (!skaVar.j()) {
                    skaVar.z(202);
                    skaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ukaVar.c();
                if (!di.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    skaVar.z(201);
                    return skaVar;
                }
                Iterator<qka> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    skaVar = it2.next().dispatch(ukaVar, skaVar);
                    if (skaVar.i()) {
                        return skaVar;
                    }
                }
                if (!skaVar.i()) {
                    skaVar.z(202);
                }
            }
            return skaVar;
        }
        return (ska) invokeLL.objValue;
    }

    public void d(WebView webView, ska skaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, skaVar) != null) || webView == null || skaVar == null || !skaVar.k()) {
            return;
        }
        b(webView, skaVar.c(), skaVar.d());
    }

    public void e(WebView webView, List<ska> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (ska skaVar : list) {
                if (skaVar != null && skaVar.k()) {
                    b(webView, skaVar.c(), skaVar.d());
                }
            }
        }
    }

    public List<ska> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<ska> list = null;
            if (di.isEmpty(str)) {
                return null;
            }
            Iterator<qka> it = this.a.iterator();
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
