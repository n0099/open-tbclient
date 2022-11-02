package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface ol1 {
    SwanCoreVersion m();

    dh2 n(SwanAppActivity swanAppActivity, String str);

    m72 o(xi3<Exception> xi3Var);

    void p(Intent intent);

    View q(k32 k32Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    qe2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
