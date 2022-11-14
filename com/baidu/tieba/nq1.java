package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.mq1;
/* loaded from: classes5.dex */
public interface nq1<T extends mq1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(s52 s52Var);

    String a();

    void attachActivity(Activity activity);

    void b(t22 t22Var);

    String b0();

    SwanAppWebViewManager.d d();

    void destroy();

    void e0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void q();

    T r();

    void t(s52 s52Var);
}
