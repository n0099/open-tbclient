package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.id4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface sn1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, id4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull f43 f43Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, yi3<String> yi3Var);
}
