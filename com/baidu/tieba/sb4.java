package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.md4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface sb4 {
    te4 A();

    int B();

    void C();

    void D(yf4 yf4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(mg4 mg4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    sd4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    lk4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<cd4> l(String str, long j);

    void m(String str, String str2, md4.c cVar);

    sd4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, id4 id4Var, List<jd4> list);

    String q();

    boolean r(@Nullable kd4 kd4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(bh4 bh4Var, rh4 rh4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
