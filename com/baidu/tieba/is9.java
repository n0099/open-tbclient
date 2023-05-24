package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.Nullable;
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
public abstract class is9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<js9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, ms9Var, ks9Var)) == null) {
            return null;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Nullable
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (kh6) invokeV.objValue;
    }

    public abstract List<ks9> processNotification(WebView webView, String str, HashMap hashMap);

    public is9() {
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

    public final void onDestroy() {
        kh6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public ks9 addObserver(WebView webView, String str, ks9 ks9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, ks9Var, Boolean.valueOf(z)})) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            if (this.mNotificationNameList.contains(str)) {
                ks9Var.n(false);
                ks9Var.t(true);
                List<js9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                js9 js9Var = new js9();
                js9Var.e(ks9Var.c());
                js9Var.d(z);
                js9Var.f(ks9Var.e());
                list.add(js9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof hh6) {
                    ((hh6) webView).a(str, js9Var.a());
                }
            }
            return ks9Var;
        }
        return (ks9) invokeCommon.objValue;
    }

    public ks9 addObserver(String str, ks9 ks9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ks9Var, z)) == null) {
            return addObserver(null, str, ks9Var, z);
        }
        return (ks9) invokeLLZ.objValue;
    }

    public ks9 dispatch(ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ms9Var, ks9Var)) == null) {
            return dispatch(null, ms9Var, ks9Var);
        }
        return (ks9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<js9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<js9> it = list2.iterator();
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
