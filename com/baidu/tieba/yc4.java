package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.se4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface yc4 {
    zf4 A();

    int B();

    void C();

    void D(eh4 eh4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(sh4 sh4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    ye4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    ql4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<ie4> l(String str, long j);

    void m(String str, String str2, se4.c cVar);

    ye4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, oe4 oe4Var, List<pe4> list);

    String q();

    boolean r(@Nullable qe4 qe4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(hi4 hi4Var, xi4 xi4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
