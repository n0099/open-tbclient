package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.ss1;
/* loaded from: classes8.dex */
public interface ts1<T extends ss1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void R(x72 x72Var);

    String Y();

    String a();

    void attachActivity(Activity activity);

    void b(y42 y42Var);

    void b0();

    void destroy();

    SwanAppWebViewManager.d getConfig();

    String getUserAgent();

    T getWebView();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void p();

    void r(x72 x72Var);
}
