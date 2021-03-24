package com.baidu.webkit.sdk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
@Deprecated
/* loaded from: classes5.dex */
public class WebViewFragment extends Fragment {
    public boolean mIsWebViewAvailable;
    public WebView mWebView;

    public WebView getWebView() {
        if (this.mIsWebViewAvailable) {
            return this.mWebView;
        }
        return null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.destroy();
        }
        WebView webView2 = new WebView(getActivity());
        this.mWebView = webView2;
        this.mIsWebViewAvailable = true;
        return webView2;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.destroy();
            this.mWebView = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.mIsWebViewAvailable = false;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWebView.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        this.mWebView.onResume();
        super.onResume();
    }
}
