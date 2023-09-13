package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface qs1 {
    void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener);

    String b();

    void c(JSONObject jSONObject);

    cj4 d();

    void e(int i, String str);

    void f(@NonNull aq3<Boolean> aq3Var);
}
