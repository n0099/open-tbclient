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
import com.baidu.tieba.mm2;
/* loaded from: classes4.dex */
public interface lm2 extends mm2.b {
    in1 A(String str);

    View B(String str);

    String C();

    a13 D();

    void E(xl2 xl2Var, uj2 uj2Var);

    oi1 F();

    @NonNull
    d93 G();

    i02 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    ri1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    ri1 P();

    void a();

    String b();

    void c();

    void d(xl2 xl2Var, uj2 uj2Var);

    @NonNull
    p13 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    p13 f(String str);

    String g();

    SwanAppActivity getActivity();

    hn1 i();

    @NonNull
    p13 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ab2 ab2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    fn1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ab2 ab2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(db2 db2Var, boolean z);

    String z();
}
