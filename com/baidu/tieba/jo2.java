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
import com.baidu.tieba.ko2;
/* loaded from: classes4.dex */
public interface jo2 extends ko2.b {
    gp1 A(String str);

    View B(String str);

    String C();

    y23 D();

    void E(vn2 vn2Var, sl2 sl2Var);

    mk1 F();

    @NonNull
    bb3 G();

    g22 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    pk1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    pk1 P();

    void a();

    String b();

    void c();

    void d(vn2 vn2Var, sl2 sl2Var);

    @NonNull
    n33 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    n33 f(String str);

    String g();

    SwanAppActivity getActivity();

    fp1 i();

    @NonNull
    n33 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, yc2 yc2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    dp1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(yc2 yc2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(bd2 bd2Var, boolean z);

    String z();
}
