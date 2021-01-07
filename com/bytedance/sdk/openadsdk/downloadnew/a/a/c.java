package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f7362a;

    public c(Context context) {
        this.f7362a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.g
    public void a(String str, String str2, final Map<String, Object> map, p pVar) {
        int i;
        com.bytedance.sdk.adnet.core.p pVar2;
        String valueOf;
        char c = 65535;
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    c = 0;
                    break;
                }
                break;
            case 2461856:
                if (str.equals("POST")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        i esj = i.esj();
        new j(i, str2, esj) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.c.1
            @Override // com.bytedance.sdk.adnet.core.Request
            protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
                return hashMap;
            }
        }.build(com.bytedance.sdk.openadsdk.i.e.a(com.bytedance.sdk.openadsdk.core.p.a()).d());
        try {
            pVar2 = esj.get();
        } catch (Throwable th) {
            pVar2 = null;
        }
        if (pVar2 != null && pVar2.a()) {
            if (pVar != null) {
                pVar.a((String) pVar2.f6345a);
                return;
            }
            return;
        }
        boolean z = TextUtils.isEmpty(pVar2 != null && pVar2.ppF != null ? pVar2.ppF.getMessage() : null) ? false : true;
        if (pVar != null) {
            if (z) {
                valueOf = pVar2.ppF.getMessage();
            } else {
                valueOf = pVar2 != null ? String.valueOf(pVar2.h) : "";
            }
            pVar.a(new Exception(valueOf));
        }
    }
}
