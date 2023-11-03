package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public interface rn1 {
    SwanCoreVersion m();

    fj2 n(SwanAppActivity swanAppActivity, String str);

    o92 o(zk3<Exception> zk3Var);

    void p(Intent intent);

    View q(m52 m52Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    sg2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
