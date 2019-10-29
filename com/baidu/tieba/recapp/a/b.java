package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> hdE;

    private b() {
        this.hdE = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0505b {
        private static b iIc = new b();
    }

    public static b cfM() {
        return C0505b.iIc;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Cy = a.Cy(str);
            f fVar = this.hdE.get(Cy.getKey());
            if (fVar != null && Cy.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Cy.getParams().putAll(hashMap);
                }
                fVar.a(obj, Cy.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hdE.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bZF;
        HashMap<String, String> hdF;
        String key;

        public boolean isValid() {
            return this.bZF;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hdF;
        }

        private a(String str) {
            this.bZF = false;
            Uri parse = Uri.parse(str);
            this.bZF = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bZF) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hdF = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hdF.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hdF = new HashMap<>();
        }

        public static a Cy(String str) {
            return new a(str);
        }
    }
}
