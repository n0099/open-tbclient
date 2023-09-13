package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.au3;
import com.baidu.tieba.ls3;
import com.baidu.tieba.ps3;
import com.baidu.tieba.tr3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface ks3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, tr1 tr1Var);

    is3 d(Context context);

    void e(Activity activity, String str, String str2, js3 js3Var);

    void f(Context context, au3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(vr1 vr1Var);

    void i(Context context, ls3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, js3 js3Var);

    void m(Activity activity, String str, pt3 pt3Var);

    void n(String str, ArrayList<String> arrayList, ps3.c cVar);

    void o(tr3.a aVar, String str, List<String> list);
}
