package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.xr1;
/* loaded from: classes9.dex */
public interface yr1<T extends xr1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void R(c72 c72Var);

    String Y();

    String a();

    void attachActivity(Activity activity);

    void b(d42 d42Var);

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

    void r(c72 c72Var);
}
