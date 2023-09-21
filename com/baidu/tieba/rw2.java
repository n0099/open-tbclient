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
import com.baidu.tieba.sw2;
/* loaded from: classes7.dex */
public interface rw2 extends sw2.b {
    ox1 A(String str);

    View B(String str);

    String C();

    gb3 D();

    void E(dw2 dw2Var, au2 au2Var);

    us1 F();

    @NonNull
    jj3 G();

    oa2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    xs1 L();

    boolean M();

    void N();

    xs1 O();

    void a();

    String b();

    void c();

    void d(dw2 dw2Var, au2 au2Var);

    @NonNull
    vb3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    vb3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    nx1 i();

    @NonNull
    vb3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, gl2 gl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    lx1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(gl2 gl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(jl2 jl2Var, boolean z);

    String z();
}
