package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.ox1;
/* loaded from: classes7.dex */
public interface px1<T extends ox1> extends TypedCallbackHandler {
    @UiThread
    void M();

    void S(uc2 uc2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(v92 v92Var);

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

    void s(uc2 uc2Var);
}
