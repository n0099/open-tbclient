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
public class qsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<lsa> a;

    public qsa() {
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

    public void a(lsa lsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lsaVar) == null) {
            this.a.add(lsaVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !qd.isEmpty(str) && !qd.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public nsa c(psa psaVar, nsa nsaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            if ("notification".equals(psaVar.c()) && "addObserver".equals(psaVar.a())) {
                Iterator<lsa> it = this.a.iterator();
                while (it.hasNext()) {
                    nsaVar = it.next().addObserver(psaVar.d(), nsaVar, true);
                    if (nsaVar.j()) {
                        return nsaVar;
                    }
                }
                if (!nsaVar.j()) {
                    nsaVar.z(202);
                    nsaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = psaVar.c();
                if (!qd.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    nsaVar.z(201);
                    return nsaVar;
                }
                Iterator<lsa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    nsaVar = it2.next().dispatch(psaVar, nsaVar);
                    if (nsaVar.i()) {
                        return nsaVar;
                    }
                }
                if (!nsaVar.i()) {
                    nsaVar.z(202);
                }
            }
            return nsaVar;
        }
        return (nsa) invokeLL.objValue;
    }

    public void d(WebView webView, nsa nsaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, nsaVar) != null) || webView == null || nsaVar == null || !nsaVar.k()) {
            return;
        }
        b(webView, nsaVar.c(), nsaVar.d());
    }

    public void e(WebView webView, List<nsa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (nsa nsaVar : list) {
                if (nsaVar != null && nsaVar.k()) {
                    b(webView, nsaVar.c(), nsaVar.d());
                }
            }
        }
    }

    public List<nsa> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<nsa> list = null;
            if (qd.isEmpty(str)) {
                return null;
            }
            Iterator<lsa> it = this.a.iterator();
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
