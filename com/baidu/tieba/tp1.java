package com.baidu.tieba;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes6.dex */
public interface tp1 extends k22 {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // com.baidu.tieba.k22
    void evaluateJavascript(String str, ValueCallback valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i, int i2, String str);

    void webViewScrollTo(int i, int i2);
}
