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
import com.baidu.tieba.su2;
/* loaded from: classes7.dex */
public interface ru2 extends su2.b {
    ov1 A(String str);

    View B(String str);

    String C();

    g93 D();

    void E(du2 du2Var, as2 as2Var);

    uq1 F();

    @NonNull
    jh3 G();

    o82 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    xq1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    xq1 P();

    void a();

    String b();

    void c();

    void d(du2 du2Var, as2 as2Var);

    @NonNull
    v93 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    v93 f(String str);

    String g();

    SwanAppActivity getActivity();

    nv1 i();

    @NonNull
    v93 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, gj2 gj2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    lv1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(gj2 gj2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(jj2 jj2Var, boolean z);

    String z();
}
