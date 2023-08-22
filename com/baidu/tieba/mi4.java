package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gk4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface mi4 {
    nl4 A();

    int B();

    void C();

    void D(sm4 sm4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(gn4 gn4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    mk4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    fr4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<wj4> l(String str, long j);

    void m(String str, String str2, gk4.c cVar);

    mk4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, ck4 ck4Var, List<dk4> list);

    String q();

    boolean r(@Nullable ek4 ek4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(vn4 vn4Var, lo4 lo4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
