package com.baidu.tieba;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.pc4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface zm1 {
    void d(byte[] bArr);

    void e(String str, String str2, ResponseCallback responseCallback);

    void f(String str, String str2, pc4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(m33 m33Var, JSONObject jSONObject, String str, String str2, Callback callback, fi3 fi3Var);
}
