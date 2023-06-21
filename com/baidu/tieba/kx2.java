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
import com.baidu.tieba.lx2;
/* loaded from: classes6.dex */
public interface kx2 extends lx2.b {
    hy1 A(String str);

    View B(String str);

    String C();

    zb3 D();

    void E(ww2 ww2Var, tu2 tu2Var);

    nt1 F();

    @NonNull
    ck3 G();

    hb2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    qt1 L();

    boolean M();

    void N();

    qt1 O();

    void a();

    String b();

    void c();

    void d(ww2 ww2Var, tu2 tu2Var);

    @NonNull
    oc3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    oc3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    gy1 i();

    @NonNull
    oc3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, zl2 zl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    ey1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(zl2 zl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(cm2 cm2Var, boolean z);

    String z();
}
