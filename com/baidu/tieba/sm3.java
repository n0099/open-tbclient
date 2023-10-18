package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.bm3;
import com.baidu.tieba.io3;
import com.baidu.tieba.tm3;
import com.baidu.tieba.xm3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public interface sm3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, cm1 cm1Var);

    qm3 d(Context context);

    void e(Activity activity, String str, String str2, rm3 rm3Var);

    void f(Context context, io3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(em1 em1Var);

    void i(Context context, tm3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, rm3 rm3Var);

    void m(Activity activity, String str, xn3 xn3Var);

    void n(String str, ArrayList<String> arrayList, xm3.c cVar);

    void o(bm3.a aVar, String str, List<String> list);
}
