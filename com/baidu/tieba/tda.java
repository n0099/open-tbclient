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
public class tda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<oda> a;

    public tda() {
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

    public void a(oda odaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, odaVar) == null) {
            this.a.add(odaVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            h29 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !xi.isEmpty(str) && !xi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public qda c(sda sdaVar, qda qdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            if ("notification".equals(sdaVar.c()) && "addObserver".equals(sdaVar.a())) {
                Iterator<oda> it = this.a.iterator();
                while (it.hasNext()) {
                    qdaVar = it.next().addObserver(sdaVar.d(), qdaVar, true);
                    if (qdaVar.j()) {
                        return qdaVar;
                    }
                }
                if (!qdaVar.j()) {
                    qdaVar.z(202);
                    qdaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = sdaVar.c();
                if (!xi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    qdaVar.z(201);
                    return qdaVar;
                }
                Iterator<oda> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    qdaVar = it2.next().dispatch(sdaVar, qdaVar);
                    if (qdaVar.i()) {
                        return qdaVar;
                    }
                }
                if (!qdaVar.i()) {
                    qdaVar.z(202);
                }
            }
            return qdaVar;
        }
        return (qda) invokeLL.objValue;
    }

    public void d(WebView webView, qda qdaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, qdaVar) != null) || webView == null || qdaVar == null || !qdaVar.k()) {
            return;
        }
        b(webView, qdaVar.c(), qdaVar.d());
    }

    public void e(WebView webView, List<qda> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (qda qdaVar : list) {
                if (qdaVar != null && qdaVar.k()) {
                    b(webView, qdaVar.c(), qdaVar.d());
                }
            }
        }
    }

    public List<qda> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<qda> list = null;
            if (xi.isEmpty(str)) {
                return null;
            }
            Iterator<oda> it = this.a.iterator();
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
