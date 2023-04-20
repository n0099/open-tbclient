package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface xe1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, ef1<JSONObject> ef1Var);

    boolean b(Context context);

    void c(Activity activity, String str, se1 se1Var);

    void d(Context context, JSONObject jSONObject, se1 se1Var);

    void e(Activity activity, String str, se1 se1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, se1 se1Var);

    String j(Context context);
}
