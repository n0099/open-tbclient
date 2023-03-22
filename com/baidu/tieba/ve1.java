package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface ve1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, cf1<JSONObject> cf1Var);

    boolean b(Context context);

    void c(Activity activity, String str, qe1 qe1Var);

    void d(Context context, JSONObject jSONObject, qe1 qe1Var);

    void e(Activity activity, String str, qe1 qe1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, qe1 qe1Var);

    String j(Context context);
}
