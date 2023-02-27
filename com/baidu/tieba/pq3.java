package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.fs3;
import com.baidu.tieba.qq3;
import com.baidu.tieba.uq3;
import com.baidu.tieba.yp3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface pq3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, yp1 yp1Var);

    nq3 d(Context context);

    void e(Activity activity, String str, String str2, oq3 oq3Var);

    void f(Context context, fs3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(aq1 aq1Var);

    void i(Context context, qq3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, oq3 oq3Var);

    void m(Activity activity, String str, ur3 ur3Var);

    void n(String str, ArrayList<String> arrayList, uq3.c cVar);

    void o(yp3.a aVar, String str, List<String> list);
}
