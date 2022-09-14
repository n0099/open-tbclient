package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.bc4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface lm1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, bc4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull y23 y23Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, rh3<String> rh3Var);
}
