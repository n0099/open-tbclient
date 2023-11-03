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
public abstract class lsa {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<msa>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, psaVar, nsaVar)) == null) {
            return null;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Nullable
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (cj6) invokeV.objValue;
    }

    public abstract List<nsa> processNotification(WebView webView, String str, HashMap hashMap);

    public lsa() {
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
        cj6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public nsa addObserver(WebView webView, String str, nsa nsaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, nsaVar, Boolean.valueOf(z)})) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            if (this.mNotificationNameList.contains(str)) {
                nsaVar.n(false);
                nsaVar.t(true);
                List<msa> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                msa msaVar = new msa();
                msaVar.e(nsaVar.c());
                msaVar.d(z);
                msaVar.f(nsaVar.e());
                list.add(msaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof zi6) {
                    ((zi6) webView).a(str, msaVar.a());
                }
            }
            return nsaVar;
        }
        return (nsa) invokeCommon.objValue;
    }

    public nsa addObserver(String str, nsa nsaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, nsaVar, z)) == null) {
            return addObserver(null, str, nsaVar, z);
        }
        return (nsa) invokeLLZ.objValue;
    }

    public nsa dispatch(psa psaVar, nsa nsaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, psaVar, nsaVar)) == null) {
            return dispatch(null, psaVar, nsaVar);
        }
        return (nsa) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<msa> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<msa> it = list2.iterator();
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
