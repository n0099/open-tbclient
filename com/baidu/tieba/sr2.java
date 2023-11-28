package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.tr2;
/* loaded from: classes8.dex */
public interface sr2 extends tr2.b {
    String A();

    qs1 B(String str);

    View C(String str);

    String D();

    void E(Context context);

    h63 F();

    void G(er2 er2Var, bp2 bp2Var);

    wn1 H();

    @NonNull
    ke3 I();

    p52 J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    void M(String str);

    zn1 N();

    boolean O();

    void P();

    zn1 Q();

    void a();

    String b();

    void c();

    void d(er2 er2Var, bp2 bp2Var);

    @NonNull
    w63 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    w63 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    ps1 i();

    @NonNull
    w63 j(String str);

    boolean k();

    void l(Context context);

    void m(SwanAppActivity swanAppActivity);

    void n(String str, hg2 hg2Var);

    FullScreenFloatView o(Activity activity);

    void p();

    void q();

    @DebugTrace
    ns1 r();

    @NonNull
    Pair<Integer, Integer> s();

    SwanAppConfigData t();

    void u(Intent intent);

    void v(hg2 hg2Var);

    void w();

    void x();

    @NonNull
    Pair<Integer, Integer> y();

    void z(kg2 kg2Var, boolean z);
}
