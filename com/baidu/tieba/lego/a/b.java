package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> kSf;

    private b() {
        this.kSf = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0772b {
        private static b kSg = new b();
    }

    public static b cZm() {
        return C0772b.kSg;
    }

    public void k(Object obj, String str) {
        if (str != null) {
            a MM = a.MM(str);
            f fVar = this.kSf.get(MM.getKey());
            if (fVar != null && MM.isValid()) {
                fVar.a(obj, MM.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a MM = a.MM(str);
            f fVar = this.kSf.get(MM.getKey());
            if (fVar != null && MM.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    MM.getParams().putAll(hashMap);
                }
                fVar.a(obj, MM.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kSf.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean eLO;
        HashMap<String, String> eXq;
        String key;

        public boolean isValid() {
            return this.eLO;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eXq;
        }

        private a(String str) {
            this.eLO = false;
            Uri parse = Uri.parse(str);
            this.eLO = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eXq = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eXq.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eXq = new HashMap<>();
        }

        public String ML(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.eXq.keySet()) {
                    if (str.equals(str2)) {
                        return this.eXq.get(str2);
                    }
                }
            }
            return null;
        }

        public static a MM(String str) {
            return new a(str);
        }
    }
}
