package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface qs1 {
    SwanCoreVersion m();

    fo2 n(SwanAppActivity swanAppActivity, String str);

    oe2 o(zp3<Exception> zp3Var);

    void p(Intent intent);

    View q(ma2 ma2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    sl2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
