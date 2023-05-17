package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.nv1;
/* loaded from: classes6.dex */
public interface ov1<T extends nv1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(ta2 ta2Var);

    String a();

    void attachActivity(Activity activity);

    void b(u72 u72Var);

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

    void t(ta2 ta2Var);
}
