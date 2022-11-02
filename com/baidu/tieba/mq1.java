package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.lq1;
/* loaded from: classes5.dex */
public interface mq1<T extends lq1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(r52 r52Var);

    String a();

    void attachActivity(Activity activity);

    void b(s22 s22Var);

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

    void t(r52 r52Var);
}
