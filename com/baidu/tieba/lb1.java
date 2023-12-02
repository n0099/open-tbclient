package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface lb1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, sb1<JSONObject> sb1Var);

    boolean b(Context context);

    void c(Activity activity, String str, gb1 gb1Var);

    void d(Context context, JSONObject jSONObject, gb1 gb1Var);

    void e(Activity activity, String str, gb1 gb1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, gb1 gb1Var);

    String j(Context context);
}
