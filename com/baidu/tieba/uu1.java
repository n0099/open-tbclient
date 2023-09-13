package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.kk4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface uu1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, kk4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull hb3 hb3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, aq3<String> aq3Var);
}
