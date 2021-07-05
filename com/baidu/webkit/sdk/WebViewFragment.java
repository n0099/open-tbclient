package com.baidu.webkit.sdk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes6.dex */
public class WebViewFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsWebViewAvailable;
    public WebView mWebView;

    public WebViewFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mIsWebViewAvailable) {
                return this.mWebView;
            }
            return null;
        }
        return (WebView) invokeV.objValue;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.destroy();
            }
            WebView webView2 = new WebView(getActivity());
            this.mWebView = webView2;
            this.mIsWebViewAvailable = true;
            return webView2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.destroy();
                this.mWebView = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mIsWebViewAvailable = false;
            super.onDestroyView();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            this.mWebView.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mWebView.onResume();
            super.onResume();
        }
    }
}
