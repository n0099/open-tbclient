package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eOl;

    private b() {
        this.eOl = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0225b {
        private static b gor = new b();
    }

    public static b bnp() {
        return C0225b.gor;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a sJ = a.sJ(str);
            f fVar = this.eOl.get(sJ.getKey());
            if (fVar != null && sJ.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    sJ.getParams().putAll(hashMap);
                }
                fVar.a(obj, sJ.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eOl.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.rq(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean agc;
        HashMap<String, String> eOm;
        String key;

        public boolean isValid() {
            return this.agc;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eOm;
        }

        private a(String str) {
            this.agc = false;
            Uri parse = Uri.parse(str);
            this.agc = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.agc) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eOm = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eOm.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eOm = new HashMap<>();
        }

        public static a sJ(String str) {
            return new a(str);
        }
    }
}
