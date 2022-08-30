package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface ji1 {
    void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener);

    String b();

    void c(JSONObject jSONObject);

    t84 d();

    void e(int i, String str);

    void f(@NonNull tf3<Boolean> tf3Var);
}
