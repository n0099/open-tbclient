package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public interface sn1 {
    SwanCoreVersion m();

    gj2 n(SwanAppActivity swanAppActivity, String str);

    p92 o(al3<Exception> al3Var);

    void p(Intent intent);

    View q(n52 n52Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    tg2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
