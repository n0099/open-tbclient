package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface yf1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, fg1<JSONObject> fg1Var);

    boolean b(Context context);

    void c(Activity activity, String str, tf1 tf1Var);

    void d(Context context, JSONObject jSONObject, tf1 tf1Var);

    void e(Activity activity, String str, tf1 tf1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, tf1 tf1Var);

    String j(Context context);
}
