package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.fm3;
import com.baidu.tieba.qk3;
import com.baidu.tieba.uk3;
import com.baidu.tieba.yj3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface pk3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, yj1 yj1Var);

    nk3 d(Context context);

    void e(Activity activity, String str, String str2, ok3 ok3Var);

    void f(Context context, fm3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(ak1 ak1Var);

    void i(Context context, qk3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, ok3 ok3Var);

    void m(Activity activity, String str, ul3 ul3Var);

    void n(String str, ArrayList arrayList, uk3.c cVar);

    void o(yj3.a aVar, String str, List list);
}
