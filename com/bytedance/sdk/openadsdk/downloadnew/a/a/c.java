package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.o;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f4702a;

    public c(Context context) {
        this.f4702a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.g
    public void a(String str, String str2, final Map<String, Object> map, p pVar) {
        int i;
        o oVar;
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
        i eqX = i.eqX();
        new j(i, str2, eqX) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.c.1
            @Override // com.bytedance.sdk.adnet.core.Request
            protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
                return hashMap;
            }
        }.build(com.bytedance.sdk.openadsdk.h.d.a(com.bytedance.sdk.openadsdk.core.p.a()).d());
        try {
            oVar = eqX.get();
        } catch (Throwable th) {
            oVar = null;
        }
        if (oVar != null && oVar.a()) {
            if (pVar != null) {
                pVar.a((String) oVar.f4049a);
                return;
            }
            return;
        }
        boolean z = TextUtils.isEmpty(oVar != null && oVar.pxT != null ? oVar.pxT.getMessage() : null) ? false : true;
        if (pVar != null) {
            if (z) {
                valueOf = oVar.pxT.getMessage();
            } else {
                valueOf = oVar != null ? String.valueOf(oVar.h) : "";
            }
            pVar.a(new Exception(valueOf));
        }
    }
}
