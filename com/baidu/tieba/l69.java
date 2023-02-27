package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class l69 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<m69>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, p69Var, n69Var)) == null) {
            return null;
        }
        return (n69) invokeLLL.objValue;
    }

    public abstract List<n69> processNotification(WebView webView, String str, HashMap hashMap);

    public l69() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public n69 addObserver(WebView webView, String str, n69 n69Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, n69Var, Boolean.valueOf(z)})) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            if (this.mNotificationNameList.contains(str)) {
                n69Var.n(false);
                n69Var.s(true);
                List<m69> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                m69 m69Var = new m69();
                m69Var.e(n69Var.c());
                m69Var.d(z);
                m69Var.f(n69Var.e());
                list.add(m69Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof be6) {
                    ((be6) webView).a(str, m69Var.a());
                }
            }
            return n69Var;
        }
        return (n69) invokeCommon.objValue;
    }

    public n69 addObserver(String str, n69 n69Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, n69Var, z)) == null) {
            return addObserver(null, str, n69Var, z);
        }
        return (n69) invokeLLZ.objValue;
    }

    public n69 dispatch(p69 p69Var, n69 n69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, p69Var, n69Var)) == null) {
            return dispatch(null, p69Var, n69Var);
        }
        return (n69) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<m69> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<m69> it = list2.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().a(), pair.second)) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }
}
