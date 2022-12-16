package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.hd4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface rn1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, hd4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull e43 e43Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, xi3<String> xi3Var);
}
