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
import com.baidu.tieba.xo2;
/* loaded from: classes6.dex */
public interface wo2 extends xo2.b {
    tp1 A(String str);

    View B(String str);

    String C();

    l33 D();

    void E(io2 io2Var, fm2 fm2Var);

    zk1 F();

    @NonNull
    ob3 G();

    t22 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    cl1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    cl1 P();

    void a();

    String b();

    void c();

    void d(io2 io2Var, fm2 fm2Var);

    @NonNull
    a43 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    a43 f(String str);

    String g();

    SwanAppActivity getActivity();

    sp1 i();

    @NonNull
    a43 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ld2 ld2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    qp1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ld2 ld2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(od2 od2Var, boolean z);

    String z();
}
