package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.yo2;
/* loaded from: classes6.dex */
public interface xo2 extends yo2.b {
    up1 A(String str);

    View B(String str);

    String C();

    m33 D();

    void E(jo2 jo2Var, gm2 gm2Var);

    al1 F();

    pb3 G();

    u22 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    dl1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    dl1 P();

    void a();

    String b();

    void c();

    void d(jo2 jo2Var, gm2 gm2Var);

    b43 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    b43 f(String str);

    String g();

    SwanAppActivity getActivity();

    tp1 i();

    b43 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, md2 md2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    rp1 q();

    Pair r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(md2 md2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    Pair x();

    void y(pd2 pd2Var, boolean z);

    String z();
}
