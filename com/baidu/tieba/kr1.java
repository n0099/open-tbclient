package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.ah4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface kr1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, ah4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull x73 x73Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, qm3<String> qm3Var);
}
