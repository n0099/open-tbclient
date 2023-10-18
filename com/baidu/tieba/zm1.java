package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface zm1 {
    void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener);

    String b();

    void c(JSONObject jSONObject);

    kd4 d();

    void e(int i, String str);

    void f(@NonNull ik3<Boolean> ik3Var);
}
