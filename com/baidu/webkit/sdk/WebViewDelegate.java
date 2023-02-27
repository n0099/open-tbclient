package com.baidu.webkit.sdk;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes7.dex */
public class WebViewDelegate {
    public WebView mWebView;

    public WebViewDelegate(WebView webView) {
        this.mWebView = webView;
    }

    public boolean canGoBack() {
        return this.mWebView.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return this.mWebView.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return this.mWebView.canGoForward();
    }

    public View getCurrentTitleBar() {
        return null;
    }

    public View getEmbeddedTitlebar() {
        return null;
    }

    public View getLandingPageTitleBar() {
        return null;
    }

    public View getSearchResultTitleBar() {
        return null;
    }

    public int getTitlebarHeight() {
        return 0;
    }

    public void goBack() {
        this.mWebView.goBack();
    }

    public void goBackOrForward(int i) {
        this.mWebView.goBackOrForward(i);
    }

    public void goForward() {
        this.mWebView.goForward();
    }

    public boolean isTitlebarCanShow() {
        return true;
    }

    public boolean isTitlebarShowing() {
        return false;
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.mWebView.onOverScrolledSuper(i, i2, z, z2);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mWebView.onScrollChangedSuper(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWebView.onTouchEventSuper(motionEvent);
    }

    public void setCurrentTitleBar(boolean z) {
    }
}
