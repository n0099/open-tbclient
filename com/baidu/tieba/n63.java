package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.o63;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public interface n63 {
    public static final Set<String> p0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(o63.a aVar);

    u83 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(dl3<o63.a> dl3Var);

    void p(String str);

    k63 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(dl3<o63.a> dl3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    on1 x();

    f33 y();
}
