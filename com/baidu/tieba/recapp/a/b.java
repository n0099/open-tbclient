package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eKw;

    private b() {
        this.eKw = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0225b {
        private static b gne = new b();
    }

    public static b boK() {
        return C0225b.gne;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a sK = a.sK(str);
            f fVar = this.eKw.get(sK.getKey());
            if (fVar != null && sK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    sK.getParams().putAll(hashMap);
                }
                fVar.a(obj, sK.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eKw.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean agJ;
        HashMap<String, String> eKx;
        String key;

        public boolean isValid() {
            return this.agJ;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eKx;
        }

        private a(String str) {
            this.agJ = false;
            Uri parse = Uri.parse(str);
            this.agJ = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.agJ) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eKx = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eKx.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eKx = new HashMap<>();
        }

        public static a sK(String str) {
            return new a(str);
        }
    }
}
