package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface y91 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, fa1<JSONObject> fa1Var);

    boolean b(Context context);

    void c(Activity activity, String str, t91 t91Var);

    void d(Context context, JSONObject jSONObject, t91 t91Var);

    void e(Activity activity, String str, t91 t91Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, t91 t91Var);

    String j(Context context);
}
