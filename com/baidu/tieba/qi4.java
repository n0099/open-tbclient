package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.kk4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface qi4 {
    rl4 A();

    int B();

    void C();

    void D(wm4 wm4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(kn4 kn4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    qk4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    jr4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<ak4> l(String str, long j);

    void m(String str, String str2, kk4.c cVar);

    qk4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, gk4 gk4Var, List<hk4> list);

    String q();

    boolean r(@Nullable ik4 ik4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(zn4 zn4Var, po4 po4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
