package com.baidu.tieba;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface n42 {
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
