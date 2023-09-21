package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.ks3;
import com.baidu.tieba.os3;
import com.baidu.tieba.sr3;
import com.baidu.tieba.zt3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface js3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, sr1 sr1Var);

    hs3 d(Context context);

    void e(Activity activity, String str, String str2, is3 is3Var);

    void f(Context context, zt3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(ur1 ur1Var);

    void i(Context context, ks3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, is3 is3Var);

    void m(Activity activity, String str, ot3 ot3Var);

    void n(String str, ArrayList<String> arrayList, os3.c cVar);

    void o(sr3.a aVar, String str, List<String> list);
}
