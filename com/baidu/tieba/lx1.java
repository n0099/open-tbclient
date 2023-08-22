package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.kx1;
/* loaded from: classes7.dex */
public interface lx1<T extends kx1> extends TypedCallbackHandler {
    @UiThread
    void M();

    void S(qc2 qc2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(r92 r92Var);

    void c0();

    void destroy();

    SwanAppWebViewManager.d getConfig();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void p();

    T r();

    void s(qc2 qc2Var);
}
