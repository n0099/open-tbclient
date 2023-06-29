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
import com.baidu.tieba.ox2;
/* loaded from: classes7.dex */
public interface nx2 extends ox2.b {
    ky1 A(String str);

    View B(String str);

    String C();

    cc3 D();

    void E(zw2 zw2Var, wu2 wu2Var);

    qt1 F();

    @NonNull
    fk3 G();

    kb2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    tt1 L();

    boolean M();

    void N();

    tt1 O();

    void a();

    String b();

    void c();

    void d(zw2 zw2Var, wu2 wu2Var);

    @NonNull
    rc3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    rc3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    jy1 i();

    @NonNull
    rc3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, cm2 cm2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    hy1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(cm2 cm2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(fm2 fm2Var, boolean z);

    String z();
}
