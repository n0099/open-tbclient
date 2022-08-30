package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface ki1 {
    SwanCoreVersion m();

    zd2 n(SwanAppActivity swanAppActivity, String str);

    i42 o(tf3<Exception> tf3Var);

    void p(Intent intent);

    View q(g02 g02Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    mb2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
