package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.gk4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface qu1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, gk4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull db3 db3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, wp3<String> wp3Var);
}
