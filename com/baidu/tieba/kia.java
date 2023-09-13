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
public abstract class kia {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<lia>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, oiaVar, miaVar)) == null) {
            return null;
        }
        return (mia) invokeLLL.objValue;
    }

    @Nullable
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (tm6) invokeV.objValue;
    }

    public abstract List<mia> processNotification(WebView webView, String str, HashMap hashMap);

    public kia() {
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
        tm6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public mia addObserver(WebView webView, String str, mia miaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, miaVar, Boolean.valueOf(z)})) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            if (this.mNotificationNameList.contains(str)) {
                miaVar.n(false);
                miaVar.t(true);
                List<lia> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                lia liaVar = new lia();
                liaVar.e(miaVar.c());
                liaVar.d(z);
                liaVar.f(miaVar.e());
                list.add(liaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof qm6) {
                    ((qm6) webView).a(str, liaVar.a());
                }
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }

    public mia addObserver(String str, mia miaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, miaVar, z)) == null) {
            return addObserver(null, str, miaVar, z);
        }
        return (mia) invokeLLZ.objValue;
    }

    public mia dispatch(oia oiaVar, mia miaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, oiaVar, miaVar)) == null) {
            return dispatch(null, oiaVar, miaVar);
        }
        return (mia) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<lia> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<lia> it = list2.iterator();
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
