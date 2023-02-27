package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.cache.prerender.LRUCache;
import com.baidu.tieba.browser.core.webview.base.BaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes5.dex */
public class pb6 extends LRUCache<String, BaseWebView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb6() {
        super(8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @UiThread
    public synchronized BaseWebView d(String str) {
        InterceptResult invokeL;
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                baseWebView = null;
                if (!TextUtils.isEmpty(str) && jb6.g(str)) {
                    baseWebView = (BaseWebView) super.b(str);
                }
                if (baseWebView != null) {
                    baseWebView.d();
                }
            }
            return baseWebView;
        }
        return (BaseWebView) invokeL.objValue;
    }

    @UiThread
    public synchronized BaseWebView e(String str, @NonNull BaseWebView baseWebView) {
        InterceptResult invokeLL;
        BaseWebView baseWebView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, baseWebView)) == null) {
            synchronized (this) {
                baseWebView2 = (BaseWebView) super.c(str, baseWebView);
                Log.e("lt-log", "recycle:" + str + "，instance=" + baseWebView2);
                if (baseWebView2 == null) {
                    baseWebView.c();
                    baseWebView.setPrerender(true);
                } else {
                    baseWebView2.c();
                    baseWebView2.setPrerender(false);
                }
            }
            return baseWebView2;
        }
        return (BaseWebView) invokeLL.objValue;
    }
}
