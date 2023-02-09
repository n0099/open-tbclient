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
/* loaded from: classes7.dex */
public abstract class z29 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<a39>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public b39 dispatch(WebView webView, d39 d39Var, b39 b39Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, d39Var, b39Var)) == null) {
            return null;
        }
        return (b39) invokeLLL.objValue;
    }

    public abstract List<b39> processNotification(WebView webView, String str, HashMap hashMap);

    public z29() {
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

    public b39 addObserver(String str, b39 b39Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, b39Var, z)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            if (this.mNotificationNameList.contains(str)) {
                b39Var.n(false);
                b39Var.s(true);
                List<a39> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                a39 a39Var = new a39();
                a39Var.e(b39Var.c());
                a39Var.d(z);
                a39Var.f(b39Var.e());
                list.add(a39Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return b39Var;
        }
        return (b39) invokeLLZ.objValue;
    }

    public b39 dispatch(d39 d39Var, b39 b39Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d39Var, b39Var)) == null) {
            return dispatch(null, d39Var, b39Var);
        }
        return (b39) invokeLL.objValue;
    }
}
