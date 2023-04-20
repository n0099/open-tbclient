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
public abstract class qm9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<rm9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, um9Var, sm9Var)) == null) {
            return null;
        }
        return (sm9) invokeLLL.objValue;
    }

    public abstract List<sm9> processNotification(WebView webView, String str, HashMap hashMap);

    public qm9() {
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

    public sm9 addObserver(WebView webView, String str, sm9 sm9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, sm9Var, Boolean.valueOf(z)})) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            if (this.mNotificationNameList.contains(str)) {
                sm9Var.n(false);
                sm9Var.s(true);
                List<rm9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                rm9 rm9Var = new rm9();
                rm9Var.e(sm9Var.c());
                rm9Var.d(z);
                rm9Var.f(sm9Var.e());
                list.add(rm9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof pe6) {
                    ((pe6) webView).a(str, rm9Var.a());
                }
            }
            return sm9Var;
        }
        return (sm9) invokeCommon.objValue;
    }

    public sm9 addObserver(String str, sm9 sm9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sm9Var, z)) == null) {
            return addObserver(null, str, sm9Var, z);
        }
        return (sm9) invokeLLZ.objValue;
    }

    public sm9 dispatch(um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, um9Var, sm9Var)) == null) {
            return dispatch(null, um9Var, sm9Var);
        }
        return (sm9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<rm9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<rm9> it = list2.iterator();
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
