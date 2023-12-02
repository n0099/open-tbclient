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
import com.baidu.tieba.wr2;
/* loaded from: classes8.dex */
public interface vr2 extends wr2.b {
    String A();

    ts1 B(String str);

    View C(String str);

    String D();

    void E(Context context);

    k63 F();

    void G(hr2 hr2Var, ep2 ep2Var);

    zn1 H();

    @NonNull
    ne3 I();

    s52 J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    void M(String str);

    co1 N();

    boolean O();

    void P();

    co1 Q();

    void a();

    String b();

    void c();

    void d(hr2 hr2Var, ep2 ep2Var);

    @NonNull
    z63 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    z63 f(String str);

    String g();

    SwanAppActivity getActivity();

    SwanCoreVersion getCoreVersion();

    ss1 i();

    @NonNull
    z63 j(String str);

    boolean k();

    void l(Context context);

    void m(SwanAppActivity swanAppActivity);

    void n(String str, kg2 kg2Var);

    FullScreenFloatView o(Activity activity);

    void p();

    void q();

    @DebugTrace
    qs1 r();

    @NonNull
    Pair<Integer, Integer> s();

    SwanAppConfigData t();

    void u(Intent intent);

    void v(kg2 kg2Var);

    void w();

    void x();

    @NonNull
    Pair<Integer, Integer> y();

    void z(ng2 ng2Var, boolean z);
}
