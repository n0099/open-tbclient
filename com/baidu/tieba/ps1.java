package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.os1;
/* loaded from: classes7.dex */
public interface ps1<T extends os1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void R(t72 t72Var);

    String Y();

    String a();

    void attachActivity(Activity activity);

    void b(u42 u42Var);

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

    void r(t72 t72Var);
}
