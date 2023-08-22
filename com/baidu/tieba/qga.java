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
/* loaded from: classes7.dex */
public abstract class qga {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<rga>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, ugaVar, sgaVar)) == null) {
            return null;
        }
        return (sga) invokeLLL.objValue;
    }

    @Nullable
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (vl6) invokeV.objValue;
    }

    public abstract List<sga> processNotification(WebView webView, String str, HashMap hashMap);

    public qga() {
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
        vl6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public sga addObserver(WebView webView, String str, sga sgaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, sgaVar, Boolean.valueOf(z)})) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            if (this.mNotificationNameList.contains(str)) {
                sgaVar.n(false);
                sgaVar.t(true);
                List<rga> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                rga rgaVar = new rga();
                rgaVar.e(sgaVar.c());
                rgaVar.d(z);
                rgaVar.f(sgaVar.e());
                list.add(rgaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof sl6) {
                    ((sl6) webView).a(str, rgaVar.a());
                }
            }
            return sgaVar;
        }
        return (sga) invokeCommon.objValue;
    }

    public sga addObserver(String str, sga sgaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sgaVar, z)) == null) {
            return addObserver(null, str, sgaVar, z);
        }
        return (sga) invokeLLZ.objValue;
    }

    public sga dispatch(uga ugaVar, sga sgaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ugaVar, sgaVar)) == null) {
            return dispatch(null, ugaVar, sgaVar);
        }
        return (sga) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<rga> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<rga> it = list2.iterator();
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
