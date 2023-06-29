package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface mt1 {
    SwanCoreVersion m();

    bp2 n(SwanAppActivity swanAppActivity, String str);

    kf2 o(vq3<Exception> vq3Var);

    void p(Intent intent);

    View q(ib2 ib2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    om2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
