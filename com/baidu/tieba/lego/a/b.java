package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> lah;

    private b() {
        this.lah = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0774b {
        private static b lai = new b();
    }

    public static b dbk() {
        return C0774b.lai;
    }

    public void k(Object obj, String str) {
        if (str != null) {
            a NA = a.NA(str);
            f fVar = this.lah.get(NA.getKey());
            if (fVar != null && NA.isValid()) {
                fVar.a(obj, NA.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a NA = a.NA(str);
            f fVar = this.lah.get(NA.getKey());
            if (fVar != null && NA.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    NA.getParams().putAll(hashMap);
                }
                fVar.a(obj, NA.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.lah.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        HashMap<String, String> eZG;
        private boolean isValid;
        String key;

        public boolean isValid() {
            return this.isValid;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eZG;
        }

        private a(String str) {
            this.isValid = false;
            Uri parse = Uri.parse(str);
            this.isValid = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eZG = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eZG.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eZG = new HashMap<>();
        }

        public String Nz(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.eZG.keySet()) {
                    if (str.equals(str2)) {
                        return this.eZG.get(str2);
                    }
                }
            }
            return null;
        }

        public static a NA(String str) {
            return new a(str);
        }
    }
}
