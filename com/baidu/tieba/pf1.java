package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface pf1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, wf1<JSONObject> wf1Var);

    boolean b(Context context);

    void c(Activity activity, String str, kf1 kf1Var);

    void d(Context context, JSONObject jSONObject, kf1 kf1Var);

    void e(Activity activity, String str, kf1 kf1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, kf1 kf1Var);

    String j(Context context);
}
