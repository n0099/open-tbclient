package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> hYm;

    private b() {
        this.hYm = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0597b {
        private static b jHO = new b();
    }

    public static b cCR() {
        return C0597b.jHO;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a HK = a.HK(str);
            f fVar = this.hYm.get(HK.getKey());
            if (fVar != null && HK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    HK.getParams().putAll(hashMap);
                }
                fVar.a(obj, HK.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hYm.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean cPC;
        HashMap<String, String> hYn;
        String key;

        public boolean isValid() {
            return this.cPC;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hYn;
        }

        private a(String str) {
            this.cPC = false;
            Uri parse = Uri.parse(str);
            this.cPC = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cPC) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hYn = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hYn.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hYn = new HashMap<>();
        }

        public static a HK(String str) {
            return new a(str);
        }
    }
}
