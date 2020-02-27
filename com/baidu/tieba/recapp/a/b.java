package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> hWy;

    private b() {
        this.hWy = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0596b {
        private static b jGb = new b();
    }

    public static b cCu() {
        return C0596b.jGb;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a HK = a.HK(str);
            f fVar = this.hWy.get(HK.getKey());
            if (fVar != null && HK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    HK.getParams().putAll(hashMap);
                }
                fVar.a(obj, HK.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hWy.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean cPn;
        HashMap<String, String> hWz;
        String key;

        public boolean isValid() {
            return this.cPn;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hWz;
        }

        private a(String str) {
            this.cPn = false;
            Uri parse = Uri.parse(str);
            this.cPn = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cPn) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hWz = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hWz.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hWz = new HashMap<>();
        }

        public static a HK(String str) {
            return new a(str);
        }
    }
}
