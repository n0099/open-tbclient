package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements e {
    private final HashMap<String, f> hQW;

    private b() {
        this.hQW = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0583b {
        private static b jBD = new b();
    }

    public static b czP() {
        return C0583b.jBD;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Hm = a.Hm(str);
            f fVar = this.hQW.get(Hm.getKey());
            if (fVar != null && Hm.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Hm.getParams().putAll(hashMap);
                }
                fVar.a(obj, Hm.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hQW.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean cKZ;
        HashMap<String, String> hQX;
        String key;

        public boolean isValid() {
            return this.cKZ;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hQX;
        }

        private a(String str) {
            this.cKZ = false;
            Uri parse = Uri.parse(str);
            this.cKZ = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cKZ) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hQX = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hQX.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hQX = new HashMap<>();
        }

        public static a Hm(String str) {
            return new a(str);
        }
    }
}
