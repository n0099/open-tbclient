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
/* loaded from: classes6.dex */
public abstract class rc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<sc9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, vc9Var, tc9Var)) == null) {
            return null;
        }
        return (tc9) invokeLLL.objValue;
    }

    public abstract List<tc9> processNotification(WebView webView, String str, HashMap hashMap);

    public rc9() {
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

    public tc9 addObserver(WebView webView, String str, tc9 tc9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, tc9Var, Boolean.valueOf(z)})) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            if (this.mNotificationNameList.contains(str)) {
                tc9Var.n(false);
                tc9Var.s(true);
                List<sc9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                sc9 sc9Var = new sc9();
                sc9Var.e(tc9Var.c());
                sc9Var.d(z);
                sc9Var.f(tc9Var.e());
                list.add(sc9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof gd6) {
                    ((gd6) webView).a(str, sc9Var.a());
                }
            }
            return tc9Var;
        }
        return (tc9) invokeCommon.objValue;
    }

    public tc9 addObserver(String str, tc9 tc9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tc9Var, z)) == null) {
            return addObserver(null, str, tc9Var, z);
        }
        return (tc9) invokeLLZ.objValue;
    }

    public tc9 dispatch(vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vc9Var, tc9Var)) == null) {
            return dispatch(null, vc9Var, tc9Var);
        }
        return (tc9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<sc9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<sc9> it = list2.iterator();
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
