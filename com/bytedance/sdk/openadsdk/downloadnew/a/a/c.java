package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import d.b.c.b.b.i;
import d.b.c.b.b.j;
import d.b.c.b.d.o;
import d.o.a.a.a.a.g;
import d.o.a.a.a.a.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f28940a;

    public c(Context context) {
        this.f28940a = new WeakReference<>(context);
    }

    @Override // d.o.a.a.a.a.g
    public void a(String str, String str2, final Map<String, Object> map, p pVar) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != 70454) {
            if (hashCode == 2461856 && str.equals("POST")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("GET")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        int i2 = (c2 == 0 || c2 != 1) ? 0 : 1;
        i c3 = i.c();
        new j(i2, str2, c3) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.c.1
            @Override // com.bytedance.sdk.adnet.core.Request
            public Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
                return hashMap;
            }
        }.build(com.bytedance.sdk.openadsdk.i.e.c().e());
        o<String> oVar = null;
        try {
            oVar = c3.get();
        } catch (Throwable unused) {
        }
        a(oVar, pVar);
    }

    @Override // d.o.a.a.a.a.g
    public void a(String str, final byte[] bArr, final String str2, int i2, p pVar) {
        o<String> oVar;
        i c2 = i.c();
        new j(1, str, c2) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.c.2
            @Override // com.bytedance.sdk.adnet.core.Request
            public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
                return bArr;
            }

            @Override // com.bytedance.sdk.adnet.core.Request
            public String getBodyContentType() {
                return str2;
            }
        }.build(com.bytedance.sdk.openadsdk.i.e.c().e());
        try {
            oVar = c2.get();
        } catch (Throwable unused) {
            oVar = null;
        }
        a(oVar, pVar);
    }

    private void a(o<String> oVar, p pVar) {
        String valueOf;
        if (oVar != null && oVar.f()) {
            if (pVar != null) {
                pVar.a(oVar.f65809a);
                return;
            }
            return;
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(oVar != null && oVar.f65811c != null ? oVar.f65811c.getMessage() : null);
        if (pVar != null) {
            if (isEmpty) {
                valueOf = oVar.f65811c.getMessage();
            } else {
                valueOf = oVar != null ? String.valueOf(oVar.f65816h) : "";
            }
            pVar.a(new Exception(valueOf));
        }
    }
}
