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
import com.baidu.tieba.vp2;
/* loaded from: classes6.dex */
public interface up2 extends vp2.b {
    rq1 A(String str);

    View B(String str);

    String C();

    j43 D();

    void E(gp2 gp2Var, dn2 dn2Var);

    xl1 F();

    @NonNull
    mc3 G();

    r32 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    am1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    am1 P();

    void a();

    String b();

    void c();

    void d(gp2 gp2Var, dn2 dn2Var);

    @NonNull
    y43 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    y43 f(String str);

    String g();

    SwanAppActivity getActivity();

    qq1 i();

    @NonNull
    y43 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, je2 je2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    oq1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(je2 je2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(me2 me2Var, boolean z);

    String z();
}
