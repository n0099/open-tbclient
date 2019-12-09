package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> hcN;

    private b() {
        this.hcN = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0500b {
        private static b iHl = new b();
    }

    public static b cfK() {
        return C0500b.iHl;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Cy = a.Cy(str);
            f fVar = this.hcN.get(Cy.getKey());
            if (fVar != null && Cy.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Cy.getParams().putAll(hashMap);
                }
                fVar.a(obj, Cy.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hcN.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bYO;
        HashMap<String, String> hcO;
        String key;

        public boolean isValid() {
            return this.bYO;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hcO;
        }

        private a(String str) {
            this.bYO = false;
            Uri parse = Uri.parse(str);
            this.bYO = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bYO) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hcO = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hcO.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hcO = new HashMap<>();
        }

        public static a Cy(String str) {
            return new a(str);
        }
    }
}
