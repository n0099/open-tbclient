package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.cp3;
import com.baidu.tieba.go3;
import com.baidu.tieba.nq3;
import com.baidu.tieba.yo3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public interface xo3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, go1 go1Var);

    vo3 d(Context context);

    void e(Activity activity, String str, String str2, wo3 wo3Var);

    void f(Context context, nq3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(io1 io1Var);

    void i(Context context, yo3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, wo3 wo3Var);

    void m(Activity activity, String str, cq3 cq3Var);

    void n(String str, ArrayList<String> arrayList, cp3.c cVar);

    void o(go3.a aVar, String str, List<String> list);
}
