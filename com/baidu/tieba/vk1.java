package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface vk1 {
    SwanCoreVersion m();

    kg2 n(SwanAppActivity swanAppActivity, String str);

    t62 o(ei3<Exception> ei3Var);

    void p(Intent intent);

    View q(r22 r22Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    xd2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
