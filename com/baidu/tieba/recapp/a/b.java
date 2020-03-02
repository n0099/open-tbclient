package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> hWA;

    private b() {
        this.hWA = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0596b {
        private static b jGd = new b();
    }

    public static b cCw() {
        return C0596b.jGd;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a HK = a.HK(str);
            f fVar = this.hWA.get(HK.getKey());
            if (fVar != null && HK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    HK.getParams().putAll(hashMap);
                }
                fVar.a(obj, HK.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hWA.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean cPo;
        HashMap<String, String> hWB;
        String key;

        public boolean isValid() {
            return this.cPo;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hWB;
        }

        private a(String str) {
            this.cPo = false;
            Uri parse = Uri.parse(str);
            this.cPo = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cPo) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hWB = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hWB.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hWB = new HashMap<>();
        }

        public static a HK(String str) {
            return new a(str);
        }
    }
}
