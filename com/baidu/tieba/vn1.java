package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public interface vn1 {
    SwanCoreVersion m();

    jj2 n(SwanAppActivity swanAppActivity, String str);

    s92 o(dl3<Exception> dl3Var);

    void p(Intent intent);

    View q(q52 q52Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    wg2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
