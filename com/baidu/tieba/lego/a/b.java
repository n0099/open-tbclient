package com.baidu.tieba.lego.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.b.e {
    private final HashMap<String, f> gFr;

    private b() {
        this.gFr = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0267b {
        private static b gFt = new b();
    }

    public static b bzA() {
        return C0267b.gFt;
    }

    public void g(Object obj, String str) {
        if (str != null) {
            a xU = a.xU(str);
            f fVar = this.gFr.get(xU.getKey());
            if (fVar != null && xU.isValid()) {
                fVar.a(obj, xU.getParams(), str);
            }
        }
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.d dVar) {
        if (str != null) {
            a xU = a.xU(str);
            f fVar = this.gFr.get(xU.getKey());
            if (fVar != null && xU.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    xU.getParams().putAll(hashMap);
                }
                fVar.a(obj, xU.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gFr.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean bzd;
        HashMap<String, String> gFs;
        String key;

        public boolean isValid() {
            return this.bzd;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gFs;
        }

        private a(String str) {
            this.bzd = false;
            Uri parse = Uri.parse(str);
            this.bzd = "tblego".equals(parse.getScheme());
            if (isValid()) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gFs = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gFs.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gFs = new HashMap<>();
        }

        public String xT(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (isValid()) {
                for (String str2 : this.gFs.keySet()) {
                    if (str.equals(str2)) {
                        return this.gFs.get(str2);
                    }
                }
            }
            return null;
        }

        public static a xU(String str) {
            return new a(str);
        }
    }
}
