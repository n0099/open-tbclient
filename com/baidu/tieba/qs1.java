package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.ps1;
/* loaded from: classes8.dex */
public interface qs1<T extends ps1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void R(u72 u72Var);

    String Y();

    String a();

    void attachActivity(Activity activity);

    void b(v42 v42Var);

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

    void r(u72 u72Var);
}
