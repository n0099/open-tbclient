package com.baidu.tieba;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface w12 {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void continueTimer();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    String getUrl();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();

    void suspendTimer();
}
