package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.tieba.tv1;
/* loaded from: classes6.dex */
public interface uv1<T extends tv1> extends TypedCallbackHandler {
    @UiThread
    void N();

    void U(za2 za2Var);

    String a();

    void attachActivity(Activity activity);

    void b(a82 a82Var);

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

    void t(za2 za2Var);
}
