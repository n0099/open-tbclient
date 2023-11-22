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
public class rsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<msa> a;

    public rsa() {
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

    public void a(msa msaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msaVar) == null) {
            this.a.add(msaVar);
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

    public osa c(qsa qsaVar, osa osaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            if ("notification".equals(qsaVar.c()) && "addObserver".equals(qsaVar.a())) {
                Iterator<msa> it = this.a.iterator();
                while (it.hasNext()) {
                    osaVar = it.next().addObserver(qsaVar.d(), osaVar, true);
                    if (osaVar.j()) {
                        return osaVar;
                    }
                }
                if (!osaVar.j()) {
                    osaVar.z(202);
                    osaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = qsaVar.c();
                if (!qd.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    osaVar.z(201);
                    return osaVar;
                }
                Iterator<msa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    osaVar = it2.next().dispatch(qsaVar, osaVar);
                    if (osaVar.i()) {
                        return osaVar;
                    }
                }
                if (!osaVar.i()) {
                    osaVar.z(202);
                }
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public void d(WebView webView, osa osaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, osaVar) != null) || webView == null || osaVar == null || !osaVar.k()) {
            return;
        }
        b(webView, osaVar.c(), osaVar.d());
    }

    public void e(WebView webView, List<osa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (osa osaVar : list) {
                if (osaVar != null && osaVar.k()) {
                    b(webView, osaVar.c(), osaVar.d());
                }
            }
        }
    }

    public List<osa> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<osa> list = null;
            if (qd.isEmpty(str)) {
                return null;
            }
            Iterator<msa> it = this.a.iterator();
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
