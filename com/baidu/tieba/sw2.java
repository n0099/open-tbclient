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
import com.baidu.tieba.tw2;
/* loaded from: classes8.dex */
public interface sw2 extends tw2.b {
    px1 A(String str);

    View B(String str);

    String C();

    hb3 D();

    void E(ew2 ew2Var, bu2 bu2Var);

    vs1 F();

    @NonNull
    kj3 G();

    pa2 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    ys1 L();

    boolean M();

    void N();

    ys1 O();

    void a();

    String b();

    void c();

    void d(ew2 ew2Var, bu2 bu2Var);

    @NonNull
    wb3 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    wb3 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    ox1 i();

    @NonNull
    wb3 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, hl2 hl2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    mx1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(hl2 hl2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(kl2 kl2Var, boolean z);

    String z();
}
