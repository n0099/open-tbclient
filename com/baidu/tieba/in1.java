package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.hn1;
/* loaded from: classes4.dex */
public interface in1<T extends hn1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d G();

    @UiThread
    void N();

    void U(n22 n22Var);

    String a();

    void attachActivity(Activity activity);

    void b(oz1 oz1Var);

    String b0();

    void destroy();

    void e0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void p();

    T r();

    void s(n22 n22Var);
}
