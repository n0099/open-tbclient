package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.bp3;
import com.baidu.tieba.fo3;
import com.baidu.tieba.mq3;
import com.baidu.tieba.xo3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface wo3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, fo1 fo1Var);

    uo3 d(Context context);

    void e(Activity activity, String str, String str2, vo3 vo3Var);

    void f(Context context, mq3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(ho1 ho1Var);

    void i(Context context, xo3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, vo3 vo3Var);

    void m(Activity activity, String str, bq3 bq3Var);

    void n(String str, ArrayList<String> arrayList, bp3.c cVar);

    void o(fo3.a aVar, String str, List<String> list);
}
