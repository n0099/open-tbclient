package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.cl4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface mv1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, cl4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull zb3 zb3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, sq3<String> sq3Var);
}
