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
import com.baidu.tieba.rp2;
/* loaded from: classes5.dex */
public interface qp2 extends rp2.b {
    nq1 A(String str);

    View B(String str);

    String C();

    f43 D();

    void E(cp2 cp2Var, zm2 zm2Var);

    tl1 F();

    @NonNull
    ic3 G();

    n32 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    wl1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    wl1 P();

    void a();

    String b();

    void c();

    void d(cp2 cp2Var, zm2 zm2Var);

    @NonNull
    u43 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    u43 f(String str);

    String g();

    SwanAppActivity getActivity();

    mq1 i();

    @NonNull
    u43 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, fe2 fe2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    kq1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(fe2 fe2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(ie2 ie2Var, boolean z);

    String z();
}
