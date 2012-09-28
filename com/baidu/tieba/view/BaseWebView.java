package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private OnLoadUrlListener mOnLoadUrlListener;
    private WebViewClient mWebViewClient;

    /* loaded from: classes.dex */
    public interface OnLoadUrlListener {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public BaseWebView(Context context) {
        super(context);
        this.mOnLoadUrlListener = null;
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mOnLoadUrlListener = null;
        init();
    }

    public void init() {
        this.mWebViewClient = new MyWebViewClient();
        setWebViewClient(this.mWebViewClient);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.view.BaseWebView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                return true;
            }
        });
    }

    /* loaded from: classes.dex */
    public class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (BaseWebView.this.mOnLoadUrlListener != null) {
                return BaseWebView.this.mOnLoadUrlListener.shouldOverrideUrlLoading(view, url);
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }
    }

    public void setOnLoadUrlListener(OnLoadUrlListener src) {
        this.mOnLoadUrlListener = src;
    }

    public void resetProxy(int type) {
        disablePlatformNotifications();
        enablePlatformNotifications();
    }
}
