package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.kq3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.sp3;
import com.baidu.tieba.zr3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface jq3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, sp1 sp1Var);

    hq3 d(Context context);

    void e(Activity activity, String str, String str2, iq3 iq3Var);

    void f(Context context, zr3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(up1 up1Var);

    void i(Context context, kq3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, iq3 iq3Var);

    void m(Activity activity, String str, or3 or3Var);

    void n(String str, ArrayList<String> arrayList, oq3.c cVar);

    void o(sp3.a aVar, String str, List<String> list);
}
