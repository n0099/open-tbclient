package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.ji4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface ts1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, ji4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull g93 g93Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, zn3<String> zn3Var);
}
