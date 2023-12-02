package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.nf4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface yp1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, nf4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull k63 k63Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, dl3<String> dl3Var);
}
