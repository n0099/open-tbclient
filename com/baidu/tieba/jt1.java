package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface jt1 {
    SwanCoreVersion m();

    yo2 n(SwanAppActivity swanAppActivity, String str);

    hf2 o(sq3<Exception> sq3Var);

    void p(Intent intent);

    View q(fb2 fb2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    lm2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
