package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface is1 {
    SwanCoreVersion m();

    xn2 n(SwanAppActivity swanAppActivity, String str);

    ge2 o(rp3<Exception> rp3Var);

    void p(Intent intent);

    View q(ea2 ea2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    kl2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
