package com.baidu.tieba;

import android.webkit.ValueCallback;
/* loaded from: classes4.dex */
public interface k22 {
    void addJavascriptInterface(Object obj, String str);

    void continueTimer();

    void evaluateJavascript(String str, ValueCallback valueCallback);

    String getContainerId();

    String getUrl();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();

    void suspendTimer();
}
