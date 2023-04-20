package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.dp3;
import com.baidu.tieba.ho3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.zo3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public interface yo3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, ho1 ho1Var);

    wo3 d(Context context);

    void e(Activity activity, String str, String str2, xo3 xo3Var);

    void f(Context context, oq3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(jo1 jo1Var);

    void i(Context context, zo3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, xo3 xo3Var);

    void m(Activity activity, String str, dq3 dq3Var);

    void n(String str, ArrayList<String> arrayList, dp3.c cVar);

    void o(ho3.a aVar, String str, List<String> list);
}
