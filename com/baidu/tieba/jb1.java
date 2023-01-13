package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface jb1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, qb1<JSONObject> qb1Var);

    boolean b(Context context);

    void c(Activity activity, String str, eb1 eb1Var);

    void d(Context context, JSONObject jSONObject, eb1 eb1Var);

    void e(Activity activity, String str, eb1 eb1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, eb1 eb1Var);

    String j(Context context);
}
