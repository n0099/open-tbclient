package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.kf4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface qd4 {
    rg4 A();

    int B();

    void C();

    void D(wh4 wh4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(ki4 ki4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    qf4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    im4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<af4> l(String str, long j);

    void m(String str, String str2, kf4.c cVar);

    qf4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, gf4 gf4Var, List<hf4> list);

    String q();

    boolean r(@Nullable if4 if4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(zi4 zi4Var, pj4 pj4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
