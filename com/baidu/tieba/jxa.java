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
public class jxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<exa> a;

    public jxa() {
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

    public void a(exa exaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exaVar) == null) {
            this.a.add(exaVar);
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

    public gxa c(ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            if ("notification".equals(ixaVar.c()) && "addObserver".equals(ixaVar.a())) {
                Iterator<exa> it = this.a.iterator();
                while (it.hasNext()) {
                    gxaVar = it.next().addObserver(ixaVar.d(), gxaVar, true);
                    if (gxaVar.j()) {
                        return gxaVar;
                    }
                }
                if (!gxaVar.j()) {
                    gxaVar.z(202);
                    gxaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ixaVar.c();
                if (!rd.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    gxaVar.z(201);
                    return gxaVar;
                }
                Iterator<exa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    gxaVar = it2.next().dispatch(ixaVar, gxaVar);
                    if (gxaVar.i()) {
                        return gxaVar;
                    }
                }
                if (!gxaVar.i()) {
                    gxaVar.z(202);
                }
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public void d(WebView webView, gxa gxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, gxaVar) != null) || webView == null || gxaVar == null || !gxaVar.k()) {
            return;
        }
        b(webView, gxaVar.c(), gxaVar.d());
    }

    public void e(WebView webView, List<gxa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (gxa gxaVar : list) {
                if (gxaVar != null && gxaVar.k()) {
                    b(webView, gxaVar.c(), gxaVar.d());
                }
            }
        }
    }

    public List<gxa> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<gxa> list = null;
            if (rd.isEmpty(str)) {
                return null;
            }
            Iterator<exa> it = this.a.iterator();
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
