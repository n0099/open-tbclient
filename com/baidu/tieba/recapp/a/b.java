package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gWD;

    private b() {
        this.gWD = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0395b {
        private static b izz = new b();
    }

    public static b ceN() {
        return C0395b.izz;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a CR = a.CR(str);
            f fVar = this.gWD.get(CR.getKey());
            if (fVar != null && CR.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    CR.getParams().putAll(hashMap);
                }
                fVar.a(obj, CR.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gWD.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bGv;
        HashMap<String, String> gWE;
        String key;

        public boolean isValid() {
            return this.bGv;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gWE;
        }

        private a(String str) {
            this.bGv = false;
            Uri parse = Uri.parse(str);
            this.bGv = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bGv) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gWE = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gWE.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gWE = new HashMap<>();
        }

        public static a CR(String str) {
            return new a(str);
        }
    }
}
