package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> lcz;

    private b() {
        this.lcz = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0781b {
        private static b lcA = new b();
    }

    public static b dbA() {
        return C0781b.lcA;
    }

    public void l(Object obj, String str) {
        if (str != null) {
            a NH = a.NH(str);
            f fVar = this.lcz.get(NH.getKey());
            if (fVar != null && NH.isValid()) {
                fVar.a(obj, NH.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a NH = a.NH(str);
            f fVar = this.lcz.get(NH.getKey());
            if (fVar != null && NH.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    NH.getParams().putAll(hashMap);
                }
                fVar.a(obj, NH.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.lcz.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        HashMap<String, String> fbf;
        private boolean isValid;
        String key;

        public boolean isValid() {
            return this.isValid;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.fbf;
        }

        private a(String str) {
            this.isValid = false;
            Uri parse = Uri.parse(str);
            this.isValid = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.fbf = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.fbf.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.fbf = new HashMap<>();
        }

        public String NG(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.fbf.keySet()) {
                    if (str.equals(str2)) {
                        return this.fbf.get(str2);
                    }
                }
            }
            return null;
        }

        public static a NH(String str) {
            return new a(str);
        }
    }
}
