package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.ap3;
import com.baidu.tieba.ln3;
import com.baidu.tieba.pn3;
import com.baidu.tieba.tm3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public interface kn3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, um1 um1Var);

    in3 d(Context context);

    void e(Activity activity, String str, String str2, jn3 jn3Var);

    void f(Context context, ap3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(wm1 wm1Var);

    void i(Context context, ln3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, jn3 jn3Var);

    void m(Activity activity, String str, po3 po3Var);

    void n(String str, ArrayList<String> arrayList, pn3.c cVar);

    void o(tm3.a aVar, String str, List<String> list);
}
