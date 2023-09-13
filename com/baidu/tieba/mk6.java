package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
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
public class mk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<kia> a;

    public mk6() {
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

    public void g(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<kia> it = this.a.iterator();
            while (it.hasNext()) {
                kia next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public void b(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "H5通知callJsDispatchEvent params:" + str);
            if (webView != null && !TextUtils.isEmpty(str)) {
                webView.evaluateJavascript("javascript:var eventType = 'naNotify';var setEvent = new Event(eventType);setEvent.detail = " + str + ";document.dispatchEvent(setEvent);", null);
            }
        }
    }

    public boolean f(WebView webView, List<mia> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (mia miaVar : list) {
                    if (miaVar != null && miaVar.k()) {
                        if (c(webView, miaVar.c(), miaVar.d(), miaVar.j) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(WebView webView, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{webView, str, str2, Boolean.valueOf(z)})) == null) {
            if (!z) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("JsBridge", "端能力返回H5：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            }
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public mia d(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            if ("notification".equals(oiaVar.c()) && "addObserver".equals(oiaVar.a())) {
                Iterator<kia> it = this.a.iterator();
                while (it.hasNext()) {
                    miaVar = it.next().addObserver(webView, oiaVar.d(), miaVar, true);
                    if (miaVar.j()) {
                        return miaVar;
                    }
                }
                if (!miaVar.j()) {
                    miaVar.z(202);
                    miaVar.v(im6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<kia> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    miaVar = it2.next().dispatch(webView, oiaVar, miaVar);
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
        return (mia) invokeLLL.objValue;
    }

    public void e(WebView webView, mia miaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, webView, miaVar) != null) || webView == null || miaVar == null || !miaVar.k()) {
            return;
        }
        c(webView, miaVar.c(), miaVar.d(), miaVar.j);
    }

    public List<mia> h(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, hashMap)) == null) {
            List<mia> list = null;
            if (TextUtils.isEmpty(str)) {
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
