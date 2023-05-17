package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface qq1 {
    SwanCoreVersion m();

    fm2 n(SwanAppActivity swanAppActivity, String str);

    oc2 o(zn3<Exception> zn3Var);

    void p(Intent intent);

    View q(m82 m82Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    sj2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
