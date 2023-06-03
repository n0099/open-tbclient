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
import com.baidu.tieba.kx2;
/* loaded from: classes6.dex */
public interface jx2 extends kx2.b {
    gy1 A(String str);

    View B(String str);

    String C();

    yb3 D();

    void E(vw2 vw2Var, su2 su2Var);

    mt1 F();

    @NonNull
    bk3 G();

    gb2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    pt1 L();

    boolean M();

    void N();

    pt1 O();

    void a();

    String b();

    void c();

    void d(vw2 vw2Var, su2 su2Var);

    @NonNull
    nc3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    nc3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    fy1 i();

    @NonNull
    nc3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, yl2 yl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    dy1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(yl2 yl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(bm2 bm2Var, boolean z);

    String z();
}
