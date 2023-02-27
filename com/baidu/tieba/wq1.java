package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface wq1 {
    SwanCoreVersion m();

    lm2 n(SwanAppActivity swanAppActivity, String str);

    uc2 o(fo3<Exception> fo3Var);

    void p(Intent intent);

    View q(s82 s82Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    yj2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
