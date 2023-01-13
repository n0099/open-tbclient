package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.qq1;
/* loaded from: classes6.dex */
public interface rq1<T extends qq1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(w52 w52Var);

    String a();

    void attachActivity(Activity activity);

    void b(x22 x22Var);

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

    void t(w52 w52Var);
}
