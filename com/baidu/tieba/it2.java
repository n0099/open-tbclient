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
import com.baidu.tieba.jt2;
/* loaded from: classes5.dex */
public interface it2 extends jt2.b {
    fu1 A(String str);

    View B(String str);

    String C();

    x73 D();

    void E(us2 us2Var, rq2 rq2Var);

    lp1 F();

    @NonNull
    ag3 G();

    f72 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    op1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    op1 P();

    void a();

    String b();

    void c();

    void d(us2 us2Var, rq2 rq2Var);

    @NonNull
    m83 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    m83 f(String str);

    String g();

    SwanAppActivity getActivity();

    eu1 i();

    @NonNull
    m83 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, xh2 xh2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    cu1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(xh2 xh2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(ai2 ai2Var, boolean z);

    String z();
}
