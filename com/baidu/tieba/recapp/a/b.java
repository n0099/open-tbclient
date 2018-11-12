package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> feI;

    private b() {
        this.feI = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0294b {
        private static b gEM = new b();
    }

    public static b bsH() {
        return C0294b.gEM;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a tW = a.tW(str);
            f fVar = this.feI.get(tW.getKey());
            if (fVar != null && tW.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    tW.getParams().putAll(hashMap);
                }
                fVar.a(obj, tW.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.feI.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean aol;
        String key;
        HashMap<String, String> params;

        public boolean isValid() {
            return this.aol;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.params;
        }

        private a(String str) {
            this.aol = false;
            Uri parse = Uri.parse(str);
            this.aol = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.aol) {
                this.key = parse.getAuthority() + parse.getPath();
                this.params = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.params.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.params = new HashMap<>();
        }

        public static a tW(String str) {
            return new a(str);
        }
    }
}
