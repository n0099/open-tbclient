package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.dt3;
import com.baidu.tieba.hs3;
import com.baidu.tieba.ou3;
import com.baidu.tieba.zs3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public interface ys3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, hs1 hs1Var);

    ws3 d(Context context);

    void e(Activity activity, String str, String str2, xs3 xs3Var);

    void f(Context context, ou3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(js1 js1Var);

    void i(Context context, zs3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, xs3 xs3Var);

    void m(Activity activity, String str, du3 du3Var);

    void n(String str, ArrayList<String> arrayList, dt3.c cVar);

    void o(hs3.a aVar, String str, List<String> list);
}
