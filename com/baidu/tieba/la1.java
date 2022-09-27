package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface la1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, sa1<JSONObject> sa1Var);

    boolean b(Context context);

    void c(Activity activity, String str, ga1 ga1Var);

    void d(Context context, JSONObject jSONObject, ga1 ga1Var);

    void e(Activity activity, String str, ga1 ga1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, ga1 ga1Var);

    String j(Context context);
}
