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
/* loaded from: classes8.dex */
public abstract class uy9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<vy9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, yy9Var, wy9Var)) == null) {
            return null;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Nullable
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (sl6) invokeV.objValue;
    }

    public abstract List<wy9> processNotification(WebView webView, String str, HashMap hashMap);

    public uy9() {
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
        sl6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public wy9 addObserver(WebView webView, String str, wy9 wy9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, wy9Var, Boolean.valueOf(z)})) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            if (this.mNotificationNameList.contains(str)) {
                wy9Var.n(false);
                wy9Var.t(true);
                List<vy9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                vy9 vy9Var = new vy9();
                vy9Var.e(wy9Var.c());
                vy9Var.d(z);
                vy9Var.f(wy9Var.e());
                list.add(vy9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof pl6) {
                    ((pl6) webView).a(str, vy9Var.a());
                }
            }
            return wy9Var;
        }
        return (wy9) invokeCommon.objValue;
    }

    public wy9 addObserver(String str, wy9 wy9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, wy9Var, z)) == null) {
            return addObserver(null, str, wy9Var, z);
        }
        return (wy9) invokeLLZ.objValue;
    }

    public wy9 dispatch(yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, yy9Var, wy9Var)) == null) {
            return dispatch(null, yy9Var, wy9Var);
        }
        return (wy9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<vy9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<vy9> it = list2.iterator();
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
