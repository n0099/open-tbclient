package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fl4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface lj4 {
    mm4 A();

    int B();

    void C();

    void D(rn4 rn4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(fo4 fo4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    ll4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    es4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<vk4> l(String str, long j);

    void m(String str, String str2, fl4.c cVar);

    ll4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, bl4 bl4Var, List<cl4> list);

    String q();

    boolean r(@Nullable dl4 dl4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(uo4 uo4Var, kp4 kp4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
