package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.lb3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public interface kb3 {
    public static final Set<String> p0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(lb3.a aVar);

    rd3 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(aq3<lb3.a> aq3Var);

    void p(String str);

    hb3 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(aq3<lb3.a> aq3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    ks1 x();

    c83 y();
}
