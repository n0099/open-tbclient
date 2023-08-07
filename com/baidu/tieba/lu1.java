package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.bk4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface lu1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, bk4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull ya3 ya3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, rp3<String> rp3Var);
}
