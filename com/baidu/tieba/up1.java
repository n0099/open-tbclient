package com.baidu.tieba;

import android.app.Activity;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
/* loaded from: classes6.dex */
public interface up1 extends TypedCallbackHandler {
    void N();

    void U(z42 z42Var);

    String a();

    void attachActivity(Activity activity);

    void b(a22 a22Var);

    String b0();

    SwanAppWebViewManager.d d();

    void destroy();

    void e0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    void q();

    tp1 r();

    void t(z42 z42Var);
}
