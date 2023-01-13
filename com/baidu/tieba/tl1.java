package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface tl1 {
    SwanCoreVersion m();

    ih2 n(SwanAppActivity swanAppActivity, String str);

    r72 o(cj3<Exception> cj3Var);

    void p(Intent intent);

    View q(p32 p32Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    ve2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
