package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface wk1 {
    SwanCoreVersion m();

    lg2 n(SwanAppActivity swanAppActivity, String str);

    u62 o(fi3 fi3Var);

    void p(Intent intent);

    View q(s22 s22Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    yd2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
