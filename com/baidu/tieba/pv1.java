package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.fl4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface pv1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, fl4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull cc3 cc3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, vq3<String> vq3Var);
}
