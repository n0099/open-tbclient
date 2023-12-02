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
/* loaded from: classes6.dex */
public class ixa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<dxa> a;

    public ixa() {
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

    public void a(dxa dxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dxaVar) == null) {
            this.a.add(dxaVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !rd.isEmpty(str) && !rd.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public fxa c(hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            if ("notification".equals(hxaVar.c()) && "addObserver".equals(hxaVar.a())) {
                Iterator<dxa> it = this.a.iterator();
                while (it.hasNext()) {
                    fxaVar = it.next().addObserver(hxaVar.d(), fxaVar, true);
                    if (fxaVar.j()) {
                        return fxaVar;
                    }
                }
                if (!fxaVar.j()) {
                    fxaVar.z(202);
                    fxaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = hxaVar.c();
                if (!rd.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    fxaVar.z(201);
                    return fxaVar;
                }
                Iterator<dxa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    fxaVar = it2.next().dispatch(hxaVar, fxaVar);
                    if (fxaVar.i()) {
                        return fxaVar;
                    }
                }
                if (!fxaVar.i()) {
                    fxaVar.z(202);
                }
            }
            return fxaVar;
        }
        return (fxa) invokeLL.objValue;
    }

    public void d(WebView webView, fxa fxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, fxaVar) != null) || webView == null || fxaVar == null || !fxaVar.k()) {
            return;
        }
        b(webView, fxaVar.c(), fxaVar.d());
    }

    public void e(WebView webView, List<fxa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (fxa fxaVar : list) {
                if (fxaVar != null && fxaVar.k()) {
                    b(webView, fxaVar.c(), fxaVar.d());
                }
            }
        }
    }

    public List<fxa> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<fxa> list = null;
            if (rd.isEmpty(str)) {
                return null;
            }
            Iterator<dxa> it = this.a.iterator();
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
