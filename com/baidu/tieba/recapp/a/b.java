package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class b implements e {
    private final HashMap<String, f> jNl;

    private b() {
        this.jNl = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0790b {
        private static b lCB = new b();
    }

    public static b dnl() {
        return C0790b.lCB;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Pn = a.Pn(str);
            f fVar = this.jNl.get(Pn.getKey());
            if (fVar != null && Pn.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Pn.getParams().putAll(hashMap);
                }
                fVar.a(obj, Pn.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.jNl.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes20.dex */
    public static class a {
        private boolean dYO;
        HashMap<String, String> ejh;
        String key;

        public boolean isValid() {
            return this.dYO;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.ejh;
        }

        private a(String str) {
            this.dYO = false;
            Uri parse = Uri.parse(str);
            this.dYO = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dYO) {
                this.key = parse.getAuthority() + parse.getPath();
                this.ejh = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.ejh.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.ejh = new HashMap<>();
        }

        public static a Pn(String str) {
            return new a(str);
        }
    }
}
