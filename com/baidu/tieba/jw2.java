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
import com.baidu.tieba.kw2;
/* loaded from: classes6.dex */
public interface jw2 extends kw2.b {
    gx1 A(String str);

    View B(String str);

    String C();

    ya3 D();

    void E(vv2 vv2Var, st2 st2Var);

    ms1 F();

    @NonNull
    bj3 G();

    ga2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    ps1 L();

    boolean M();

    void N();

    ps1 O();

    void a();

    String b();

    void c();

    void d(vv2 vv2Var, st2 st2Var);

    @NonNull
    nb3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    nb3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    fx1 i();

    @NonNull
    nb3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, yk2 yk2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    dx1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(yk2 yk2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(bl2 bl2Var, boolean z);

    String z();
}
