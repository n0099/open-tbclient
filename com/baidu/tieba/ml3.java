package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.cn3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.vk3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface ml3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, vk1 vk1Var);

    kl3 d(Context context);

    void e(Activity activity, String str, String str2, ll3 ll3Var);

    void f(Context context, cn3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(xk1 xk1Var);

    void i(Context context, nl3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, ll3 ll3Var);

    void m(Activity activity, String str, rm3 rm3Var);

    void n(String str, ArrayList<String> arrayList, rl3.c cVar);

    void o(vk3.a aVar, String str, List<String> list);
}
