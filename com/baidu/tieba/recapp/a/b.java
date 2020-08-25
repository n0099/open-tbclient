package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class b implements e {
    private final HashMap<String, f> jNf;

    private b() {
        this.jNf = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0790b {
        private static b lCq = new b();
    }

    public static b dni() {
        return C0790b.lCq;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Pm = a.Pm(str);
            f fVar = this.jNf.get(Pm.getKey());
            if (fVar != null && Pm.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Pm.getParams().putAll(hashMap);
                }
                fVar.a(obj, Pm.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.jNf.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes20.dex */
    public static class a {
        private boolean dYK;
        HashMap<String, String> ejd;
        String key;

        public boolean isValid() {
            return this.dYK;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.ejd;
        }

        private a(String str) {
            this.dYK = false;
            Uri parse = Uri.parse(str);
            this.dYK = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dYK) {
                this.key = parse.getAuthority() + parse.getPath();
                this.ejd = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.ejd.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.ejd = new HashMap<>();
        }

        public static a Pm(String str) {
            return new a(str);
        }
    }
}
