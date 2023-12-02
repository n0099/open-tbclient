package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.nf4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface td4 {
    ug4 A();

    int B();

    void C();

    void D(zh4 zh4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(ni4 ni4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    tf4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    lm4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<df4> l(String str, long j);

    void m(String str, String str2, nf4.c cVar);

    tf4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, jf4 jf4Var, List<kf4> list);

    String q();

    boolean r(@Nullable lf4 lf4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(cj4 cj4Var, sj4 sj4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
