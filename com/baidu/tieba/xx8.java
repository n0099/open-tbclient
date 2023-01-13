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
public abstract class xx8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<yx8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public zx8 dispatch(WebView webView, by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, by8Var, zx8Var)) == null) {
            return null;
        }
        return (zx8) invokeLLL.objValue;
    }

    public abstract List<zx8> processNotification(WebView webView, String str, HashMap hashMap);

    public xx8() {
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

    public zx8 addObserver(String str, zx8 zx8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, zx8Var, z)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            if (this.mNotificationNameList.contains(str)) {
                zx8Var.n(false);
                zx8Var.s(true);
                List<yx8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                yx8 yx8Var = new yx8();
                yx8Var.e(zx8Var.c());
                yx8Var.d(z);
                yx8Var.f(zx8Var.e());
                list.add(yx8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return zx8Var;
        }
        return (zx8) invokeLLZ.objValue;
    }

    public zx8 dispatch(by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, by8Var, zx8Var)) == null) {
            return dispatch(null, by8Var, zx8Var);
        }
        return (zx8) invokeLL.objValue;
    }
}
