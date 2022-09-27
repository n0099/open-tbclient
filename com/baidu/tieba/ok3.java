package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.em3;
import com.baidu.tieba.pk3;
import com.baidu.tieba.tk3;
import com.baidu.tieba.xj3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface ok3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, xj1 xj1Var);

    mk3 d(Context context);

    void e(Activity activity, String str, String str2, nk3 nk3Var);

    void f(Context context, em3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(zj1 zj1Var);

    void i(Context context, pk3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, nk3 nk3Var);

    void m(Activity activity, String str, tl3 tl3Var);

    void n(String str, ArrayList<String> arrayList, tk3.c cVar);

    void o(xj3.a aVar, String str, List<String> list);
}
