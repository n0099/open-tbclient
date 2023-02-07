package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.aq3;
import com.baidu.tieba.eq3;
import com.baidu.tieba.ip3;
import com.baidu.tieba.pr3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public interface zp3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, ip1 ip1Var);

    xp3 d(Context context);

    void e(Activity activity, String str, String str2, yp3 yp3Var);

    void f(Context context, pr3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(kp1 kp1Var);

    void i(Context context, aq3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, yp3 yp3Var);

    void m(Activity activity, String str, er3 er3Var);

    void n(String str, ArrayList<String> arrayList, eq3.c cVar);

    void o(ip3.a aVar, String str, List<String> list);
}
