package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface it1 {
    SwanCoreVersion m();

    xo2 n(SwanAppActivity swanAppActivity, String str);

    gf2 o(rq3<Exception> rq3Var);

    void p(Intent intent);

    View q(eb2 eb2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    km2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
