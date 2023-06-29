package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.jy1;
/* loaded from: classes6.dex */
public interface ky1<T extends jy1> extends TypedCallbackHandler {
    @UiThread
    void L();

    void S(pd2 pd2Var);

    String Z();

    String a();

    void attachActivity(Activity activity);

    void b(qa2 qa2Var);

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

    void s(pd2 pd2Var);
}
