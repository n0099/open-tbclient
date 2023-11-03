package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.jf4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface pd4 {
    qg4 A();

    int B();

    void C();

    void D(vh4 vh4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(ji4 ji4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    pf4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    hm4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<ze4> l(String str, long j);

    void m(String str, String str2, jf4.c cVar);

    pf4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, ff4 ff4Var, List<gf4> list);

    String q();

    boolean r(@Nullable hf4 hf4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(yi4 yi4Var, oj4 oj4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
