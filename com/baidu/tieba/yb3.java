package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.zb3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public interface yb3 {
    public static final Set<String> p0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(zb3.a aVar);

    fe3 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(oq3<zb3.a> oq3Var);

    void p(String str);

    vb3 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(oq3<zb3.a> oq3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    ys1 x();

    q83 y();
}
