package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> gFq;

    private b() {
        this.gFq = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0267b {
        private static b gFs = new b();
    }

    public static b bzz() {
        return C0267b.gFs;
    }

    public void g(Object obj, String str) {
        if (str != null) {
            a xT = a.xT(str);
            f fVar = this.gFq.get(xT.getKey());
            if (fVar != null && xT.isValid()) {
                fVar.a(obj, xT.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.d dVar) {
        if (str != null) {
            a xT = a.xT(str);
            f fVar = this.gFq.get(xT.getKey());
            if (fVar != null && xT.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    xT.getParams().putAll(hashMap);
                }
                fVar.a(obj, xT.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gFq.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean bzd;
        HashMap<String, String> gFr;
        String key;

        public boolean isValid() {
            return this.bzd;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gFr;
        }

        private a(String str) {
            this.bzd = false;
            Uri parse = Uri.parse(str);
            this.bzd = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gFr = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gFr.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gFr = new HashMap<>();
        }

        public String xS(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.gFr.keySet()) {
                    if (str.equals(str2)) {
                        return this.gFr.get(str2);
                    }
                }
            }
            return null;
        }

        public static a xT(String str) {
            return new a(str);
        }
    }
}
