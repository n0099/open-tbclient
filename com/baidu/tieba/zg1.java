package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface zg1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, gh1<JSONObject> gh1Var);

    boolean b(Context context);

    void c(Activity activity, String str, ug1 ug1Var);

    void d(Context context, JSONObject jSONObject, ug1 ug1Var);

    void e(Activity activity, String str, ug1 ug1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, ug1 ug1Var);

    String j(Context context);
}
