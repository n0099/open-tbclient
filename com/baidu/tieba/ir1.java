package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.yg4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface ir1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, yg4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull v73 v73Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, om3<String> om3Var);
}
