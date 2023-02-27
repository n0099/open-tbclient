package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.pi4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface vg4 {
    wj4 A();

    int B();

    void C();

    void D(bl4 bl4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(pl4 pl4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    vi4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    op4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<fi4> l(String str, long j);

    void m(String str, String str2, pi4.c cVar);

    vi4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, li4 li4Var, List<mi4> list);

    String q();

    boolean r(@Nullable ni4 ni4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(em4 em4Var, um4 um4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
