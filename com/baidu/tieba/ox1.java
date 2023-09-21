package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.nx1;
/* loaded from: classes7.dex */
public interface ox1<T extends nx1> extends TypedCallbackHandler {
    @UiThread
    void M();

    void S(tc2 tc2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(u92 u92Var);

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

    void s(tc2 tc2Var);
}
