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
import com.baidu.tieba.pw2;
/* loaded from: classes7.dex */
public interface ow2 extends pw2.b {
    lx1 A(String str);

    View B(String str);

    String C();

    db3 D();

    void E(aw2 aw2Var, xt2 xt2Var);

    rs1 F();

    @NonNull
    gj3 G();

    la2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    us1 L();

    boolean M();

    void N();

    us1 O();

    void a();

    String b();

    void c();

    void d(aw2 aw2Var, xt2 xt2Var);

    @NonNull
    sb3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    sb3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    kx1 i();

    @NonNull
    sb3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, dl2 dl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    ix1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(dl2 dl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(gl2 gl2Var, boolean z);

    String z();
}
