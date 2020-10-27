package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class b implements e {
    private final HashMap<String, f> kxB;

    private b() {
        this.kxB = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0820b {
        private static b mnk = new b();
    }

    public static b dxN() {
        return C0820b.mnk;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Ra = a.Ra(str);
            f fVar = this.kxB.get(Ra.getKey());
            if (fVar != null && Ra.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Ra.getParams().putAll(hashMap);
                }
                fVar.a(obj, Ra.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kxB.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes26.dex */
    public static class a {
        HashMap<String, String> eGd;
        private boolean evA;
        String key;

        public boolean isValid() {
            return this.evA;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eGd;
        }

        private a(String str) {
            this.evA = false;
            Uri parse = Uri.parse(str);
            this.evA = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.evA) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eGd = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eGd.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eGd = new HashMap<>();
        }

        public static a Ra(String str) {
            return new a(str);
        }
    }
}
