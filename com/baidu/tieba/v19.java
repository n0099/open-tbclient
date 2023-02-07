package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class v19 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<w19>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public x19 dispatch(WebView webView, z19 z19Var, x19 x19Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, z19Var, x19Var)) == null) {
            return null;
        }
        return (x19) invokeLLL.objValue;
    }

    public abstract List<x19> processNotification(WebView webView, String str, HashMap hashMap);

    public v19() {
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

    public x19 addObserver(String str, x19 x19Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, x19Var, z)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            if (this.mNotificationNameList.contains(str)) {
                x19Var.n(false);
                x19Var.s(true);
                List<w19> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                w19 w19Var = new w19();
                w19Var.e(x19Var.c());
                w19Var.d(z);
                w19Var.f(x19Var.e());
                list.add(w19Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return x19Var;
        }
        return (x19) invokeLLZ.objValue;
    }

    public x19 dispatch(z19 z19Var, x19 x19Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, z19Var, x19Var)) == null) {
            return dispatch(null, z19Var, x19Var);
        }
        return (x19) invokeLL.objValue;
    }
}
