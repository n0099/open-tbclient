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
import com.baidu.tieba.qp2;
/* loaded from: classes5.dex */
public interface pp2 extends qp2.b {
    mq1 A(String str);

    View B(String str);

    String C();

    e43 D();

    void E(bp2 bp2Var, ym2 ym2Var);

    sl1 F();

    @NonNull
    hc3 G();

    m32 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    vl1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    vl1 P();

    void a();

    String b();

    void c();

    void d(bp2 bp2Var, ym2 ym2Var);

    @NonNull
    t43 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    t43 f(String str);

    String g();

    SwanAppActivity getActivity();

    lq1 i();

    @NonNull
    t43 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ee2 ee2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    jq1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ee2 ee2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(he2 he2Var, boolean z);

    String z();
}
