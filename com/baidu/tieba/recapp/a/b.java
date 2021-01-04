package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements e {
    private final HashMap<String, f> kWK;

    private b() {
        this.kWK = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0836b {
        private static b mMX = new b();
    }

    public static b dEW() {
        return C0836b.mMX;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a RB = a.RB(str);
            f fVar = this.kWK.get(RB.getKey());
            if (fVar != null && RB.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    RB.getParams().putAll(hashMap);
                }
                fVar.a(obj, RB.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kWK.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean eQz;
        HashMap<String, String> fbY;
        String key;

        public boolean isValid() {
            return this.eQz;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.fbY;
        }

        private a(String str) {
            this.eQz = false;
            Uri parse = Uri.parse(str);
            this.eQz = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.eQz) {
                this.key = parse.getAuthority() + parse.getPath();
                this.fbY = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.fbY.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.fbY = new HashMap<>();
        }

        public static a RB(String str) {
            return new a(str);
        }
    }
}
