package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> kWK;

    private b() {
        this.kWK = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0789b {
        private static b kWL = new b();
    }

    public static b dde() {
        return C0789b.kWL;
    }

    public void k(Object obj, String str) {
        if (str != null) {
            a NT = a.NT(str);
            f fVar = this.kWK.get(NT.getKey());
            if (fVar != null && NT.isValid()) {
                fVar.a(obj, NT.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a NT = a.NT(str);
            f fVar = this.kWK.get(NT.getKey());
            if (fVar != null && NT.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    NT.getParams().putAll(hashMap);
                }
                fVar.a(obj, NT.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kWK.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean eQz;
        HashMap<String, String> fbY;
        String key;

        public boolean isValid() {
            return this.eQz;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.fbY;
        }

        private a(String str) {
            this.eQz = false;
            Uri parse = Uri.parse(str);
            this.eQz = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.fbY = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.fbY.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.fbY = new HashMap<>();
        }

        public String NS(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.fbY.keySet()) {
                    if (str.equals(str2)) {
                        return this.fbY.get(str2);
                    }
                }
            }
            return null;
        }

        public static a NT(String str) {
            return new a(str);
        }
    }
}
