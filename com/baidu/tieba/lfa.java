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
/* loaded from: classes7.dex */
public class lfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<gfa> a;

    public lfa() {
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

    public void a(gfa gfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gfaVar) == null) {
            this.a.add(gfaVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !ad.isEmpty(str) && !ad.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public ifa c(kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar = new ifa();
            }
            if ("notification".equals(kfaVar.c()) && "addObserver".equals(kfaVar.a())) {
                Iterator<gfa> it = this.a.iterator();
                while (it.hasNext()) {
                    ifaVar = it.next().addObserver(kfaVar.d(), ifaVar, true);
                    if (ifaVar.j()) {
                        return ifaVar;
                    }
                }
                if (!ifaVar.j()) {
                    ifaVar.z(202);
                    ifaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = kfaVar.c();
                if (!ad.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    ifaVar.z(201);
                    return ifaVar;
                }
                Iterator<gfa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    ifaVar = it2.next().dispatch(kfaVar, ifaVar);
                    if (ifaVar.i()) {
                        return ifaVar;
                    }
                }
                if (!ifaVar.i()) {
                    ifaVar.z(202);
                }
            }
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    public void d(WebView webView, ifa ifaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, ifaVar) != null) || webView == null || ifaVar == null || !ifaVar.k()) {
            return;
        }
        b(webView, ifaVar.c(), ifaVar.d());
    }

    public void e(WebView webView, List<ifa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (ifa ifaVar : list) {
                if (ifaVar != null && ifaVar.k()) {
                    b(webView, ifaVar.c(), ifaVar.d());
                }
            }
        }
    }

    public List<ifa> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<ifa> list = null;
            if (ad.isEmpty(str)) {
                return null;
            }
            Iterator<gfa> it = this.a.iterator();
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
