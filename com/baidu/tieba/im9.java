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
/* loaded from: classes4.dex */
public abstract class im9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<jm9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, mm9Var, km9Var)) == null) {
            return null;
        }
        return (km9) invokeLLL.objValue;
    }

    public abstract List<km9> processNotification(WebView webView, String str, HashMap hashMap);

    public im9() {
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

    public km9 addObserver(WebView webView, String str, km9 km9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, km9Var, Boolean.valueOf(z)})) == null) {
            if (km9Var == null) {
                km9Var = new km9();
            }
            if (this.mNotificationNameList.contains(str)) {
                km9Var.n(false);
                km9Var.s(true);
                List<jm9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                jm9 jm9Var = new jm9();
                jm9Var.e(km9Var.c());
                jm9Var.d(z);
                jm9Var.f(km9Var.e());
                list.add(jm9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof oe6) {
                    ((oe6) webView).a(str, jm9Var.a());
                }
            }
            return km9Var;
        }
        return (km9) invokeCommon.objValue;
    }

    public km9 addObserver(String str, km9 km9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, km9Var, z)) == null) {
            return addObserver(null, str, km9Var, z);
        }
        return (km9) invokeLLZ.objValue;
    }

    public km9 dispatch(mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, mm9Var, km9Var)) == null) {
            return dispatch(null, mm9Var, km9Var);
        }
        return (km9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<jm9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<jm9> it = list2.iterator();
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
