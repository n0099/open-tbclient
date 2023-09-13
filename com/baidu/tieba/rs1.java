package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface rs1 {
    SwanCoreVersion m();

    go2 n(SwanAppActivity swanAppActivity, String str);

    pe2 o(aq3<Exception> aq3Var);

    void p(Intent intent);

    View q(na2 na2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    tl2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
