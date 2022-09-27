package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.oc4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface ua4 {
    vd4 A();

    int B();

    void C();

    void D(af4 af4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(of4 of4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    uc4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    nj4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<ec4> l(String str, long j);

    void m(String str, String str2, oc4.c cVar);

    uc4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, kc4 kc4Var, List<lc4> list);

    String q();

    boolean r(@Nullable mc4 mc4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(dg4 dg4Var, tg4 tg4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
