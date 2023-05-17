package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ji4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface pg4 {
    qj4 A();

    int B();

    void C();

    void D(vk4 vk4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(jl4 jl4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    pi4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    ip4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<zh4> l(String str, long j);

    void m(String str, String str2, ji4.c cVar);

    pi4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, fi4 fi4Var, List<gi4> list);

    String q();

    boolean r(@Nullable hi4 hi4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(yl4 yl4Var, om4 om4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
