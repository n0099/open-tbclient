package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface pl1 {
    SwanCoreVersion m();

    eh2 n(SwanAppActivity swanAppActivity, String str);

    n72 o(yi3<Exception> yi3Var);

    void p(Intent intent);

    View q(l32 l32Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    re2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
