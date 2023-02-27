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
import com.baidu.tieba.yu2;
/* loaded from: classes6.dex */
public interface xu2 extends yu2.b {
    uv1 A(String str);

    View B(String str);

    String C();

    m93 D();

    void E(ju2 ju2Var, gs2 gs2Var);

    ar1 F();

    @NonNull
    ph3 G();

    u82 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    dr1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    dr1 P();

    void a();

    String b();

    void c();

    void d(ju2 ju2Var, gs2 gs2Var);

    @NonNull
    ba3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    ba3 f(String str);

    String g();

    SwanAppActivity getActivity();

    tv1 i();

    @NonNull
    ba3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, mj2 mj2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    rv1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(mj2 mj2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(pj2 pj2Var, boolean z);

    String z();
}
