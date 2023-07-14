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
public abstract class oda {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<pda>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, sdaVar, qdaVar)) == null) {
            return null;
        }
        return (qda) invokeLLL.objValue;
    }

    @Nullable
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (in6) invokeV.objValue;
    }

    public abstract List<qda> processNotification(WebView webView, String str, HashMap hashMap);

    public oda() {
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
        in6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public qda addObserver(WebView webView, String str, qda qdaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, qdaVar, Boolean.valueOf(z)})) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            if (this.mNotificationNameList.contains(str)) {
                qdaVar.n(false);
                qdaVar.t(true);
                List<pda> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                pda pdaVar = new pda();
                pdaVar.e(qdaVar.c());
                pdaVar.d(z);
                pdaVar.f(qdaVar.e());
                list.add(pdaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof fn6) {
                    ((fn6) webView).a(str, pdaVar.a());
                }
            }
            return qdaVar;
        }
        return (qda) invokeCommon.objValue;
    }

    public qda addObserver(String str, qda qdaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, qdaVar, z)) == null) {
            return addObserver(null, str, qdaVar, z);
        }
        return (qda) invokeLLZ.objValue;
    }

    public qda dispatch(sda sdaVar, qda qdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sdaVar, qdaVar)) == null) {
            return dispatch(null, sdaVar, qdaVar);
        }
        return (qda) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<pda> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<pda> it = list2.iterator();
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
