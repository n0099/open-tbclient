package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gFq;

    private b() {
        this.gFq = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0300b {
        private static b ihc = new b();
    }

    public static b bWH() {
        return C0300b.ihc;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Bv = a.Bv(str);
            f fVar = this.gFq.get(Bv.getKey());
            if (fVar != null && Bv.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Bv.getParams().putAll(hashMap);
                }
                fVar.a(obj, Bv.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gFq.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
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
            this.bzd = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bzd) {
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

        public static a Bv(String str) {
            return new a(str);
        }
    }
}
