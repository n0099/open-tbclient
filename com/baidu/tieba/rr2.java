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
import com.baidu.tieba.sr2;
/* loaded from: classes8.dex */
public interface rr2 extends sr2.b {
    String A();

    ps1 B(String str);

    View C(String str);

    String D();

    void E(Context context);

    g63 F();

    void G(dr2 dr2Var, ap2 ap2Var);

    vn1 H();

    @NonNull
    je3 I();

    o52 J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    void M(String str);

    yn1 N();

    boolean O();

    void P();

    yn1 Q();

    void a();

    String b();

    void c();

    void d(dr2 dr2Var, ap2 ap2Var);

    @NonNull
    v63 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    v63 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    os1 i();

    @NonNull
    v63 j(String str);

    boolean k();

    void l(Context context);

    void m(SwanAppActivity swanAppActivity);

    void n(String str, gg2 gg2Var);

    FullScreenFloatView o(Activity activity);

    void p();

    void q();

    @DebugTrace
    ms1 r();

    @NonNull
    Pair<Integer, Integer> s();

    SwanAppConfigData t();

    void u(Intent intent);

    void v(gg2 gg2Var);

    void w();

    void x();

    @NonNull
    Pair<Integer, Integer> y();

    void z(jg2 jg2Var, boolean z);
}
