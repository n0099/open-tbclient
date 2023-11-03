package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.kn3;
import com.baidu.tieba.on3;
import com.baidu.tieba.sm3;
import com.baidu.tieba.zo3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface jn3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, tm1 tm1Var);

    hn3 d(Context context);

    void e(Activity activity, String str, String str2, in3 in3Var);

    void f(Context context, zo3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(vm1 vm1Var);

    void i(Context context, kn3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, in3 in3Var);

    void m(Activity activity, String str, oo3 oo3Var);

    void n(String str, ArrayList<String> arrayList, on3.c cVar);

    void o(sm3.a aVar, String str, List<String> list);
}
