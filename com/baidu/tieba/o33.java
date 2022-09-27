package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.p33;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public interface o33 {
    public static final Set<String> o0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(p33.a aVar);

    v53 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(ei3<p33.a> ei3Var);

    void p(String str);

    l33 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(ei3<p33.a> ei3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    ok1 x();

    g03 y();
}
