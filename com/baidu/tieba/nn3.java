package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.dp3;
import com.baidu.tieba.on3;
import com.baidu.tieba.sn3;
import com.baidu.tieba.wm3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public interface nn3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, xm1 xm1Var);

    ln3 d(Context context);

    void e(Activity activity, String str, String str2, mn3 mn3Var);

    void f(Context context, dp3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(zm1 zm1Var);

    void i(Context context, on3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, mn3 mn3Var);

    void m(Activity activity, String str, so3 so3Var);

    void n(String str, ArrayList<String> arrayList, sn3.c cVar);

    void o(wm3.a aVar, String str, List<String> list);
}
