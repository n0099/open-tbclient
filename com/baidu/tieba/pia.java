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
public class pia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<kia> a;

    public pia() {
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

    public void a(kia kiaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kiaVar) == null) {
            this.a.add(kiaVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !ei.isEmpty(str) && !ei.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public mia c(oia oiaVar, mia miaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            if ("notification".equals(oiaVar.c()) && "addObserver".equals(oiaVar.a())) {
                Iterator<kia> it = this.a.iterator();
                while (it.hasNext()) {
                    miaVar = it.next().addObserver(oiaVar.d(), miaVar, true);
                    if (miaVar.j()) {
                        return miaVar;
                    }
                }
                if (!miaVar.j()) {
                    miaVar.z(202);
                    miaVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = oiaVar.c();
                if (!ei.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    miaVar.z(201);
                    return miaVar;
                }
                Iterator<kia> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    miaVar = it2.next().dispatch(oiaVar, miaVar);
                    if (miaVar.i()) {
                        return miaVar;
                    }
                }
                if (!miaVar.i()) {
                    miaVar.z(202);
                }
            }
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public void d(WebView webView, mia miaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, miaVar) != null) || webView == null || miaVar == null || !miaVar.k()) {
            return;
        }
        b(webView, miaVar.c(), miaVar.d());
    }

    public void e(WebView webView, List<mia> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (mia miaVar : list) {
                if (miaVar != null && miaVar.k()) {
                    b(webView, miaVar.c(), miaVar.d());
                }
            }
        }
    }

    public List<mia> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<mia> list = null;
            if (ei.isEmpty(str)) {
                return null;
            }
            Iterator<kia> it = this.a.iterator();
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
