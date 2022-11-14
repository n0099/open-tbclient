package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.id4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface ob4 {
    pe4 A();

    int B();

    void C();

    void D(uf4 uf4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(ig4 ig4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    od4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    hk4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<yc4> l(String str, long j);

    void m(String str, String str2, id4.c cVar);

    od4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, ed4 ed4Var, List<fd4> list);

    String q();

    boolean r(@Nullable gd4 gd4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(xg4 xg4Var, nh4 nh4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
